/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.ui.wizard;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.DefaultLocalSessionCreationOperation;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionCreationOperation;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallback;
import org.eclipse.sirius.ui.business.internal.commands.ChangeViewpointSelectionCommand;
import org.eclipse.sirius.ui.tools.api.project.ModelingProjectManager;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import fr.cea.modane.modaneproject.ModaneProject;
import fr.cea.modane.modaneproject.ModaneprojectFactory;
import fr.cea.modane.sirius.Activator;

@SuppressWarnings("restriction")
public class ProjectCreationOperation extends WorkspaceModifyOperation {
	private final static String XTEXT_NATURE = "org.eclipse.xtext.ui.shared.xtextNature";
	private final static String MODANE_VIEWPOINT = "ModaneViewpoint";
	public final static String MODANE_PROJECT_FILE_EXTENSION = "modaneprj";
	
	private IProject project;
	private String projectName;
	private URI projectLocation;

	public ProjectCreationOperation(String projectName, URI projectLocation)
	{
		this.project = null;
		this.projectName = projectName;
		this.projectLocation = projectLocation;
	}

	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		try {
			monitor.beginTask("Create modeling resources: ", 100); //$NON-NLS-1$
			
			// create the project
			project = createProject(projectName, projectLocation);
			
			// add a models folder
			IFolder modelsFolder = project.getFolder(Activator.MODELS_PACKAGE);
			if (!modelsFolder.exists()) modelsFolder.create(false, true, new NullProgressMonitor());
			
			// create the ModaneProject (.modaneprj file)
			final String prjPath = projectName + "/" + projectName + "." + MODANE_PROJECT_FILE_EXTENSION;
			final org.eclipse.emf.common.util.URI semanticModelURI = createModaneProjectResource(prjPath);
			
			// convert to modeling projects and apply viewpoints
			ModelingProjectManager.INSTANCE.convertToModelingProject(project, monitor);
			final Session session = createAird(project, semanticModelURI, monitor);
			applyModaneViewpoints(project, monitor, session, prjPath);
		} finally {
			monitor.done();
		}
	}

	private org.eclipse.emf.common.util.URI createModaneProjectResource(String prjPath) {
		/*
		 * Create a resource for this file. Create in a other resourceset and let the
		 * workspace monitor for modeling project add it as semantic resource.
		 */
		final ResourceSet rs = new ResourceSetImpl();
		final org.eclipse.emf.common.util.URI semanticModelURI = org.eclipse.emf.common.util.URI.createPlatformResourceURI(prjPath, true);
		final Resource resource = rs.createResource(semanticModelURI);

		/* Add the initial model object to the contents. */
		ModaneProject root = ModaneprojectFactory.eINSTANCE.createModaneProject();
		root.setName(projectName);
		resource.getContents().add(root);

		try {
			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
			resource.save(options);
		} catch (IOException e) {
			/* do nothing it should always work */
		}
		return semanticModelURI;
	}

	private Session createAird(IProject project, org.eclipse.emf.common.util.URI representationsURI, IProgressMonitor monitor) {
		final Session session;
		final Option<ModelingProject> modelingProject = ModelingProject.asModelingProject(project);
		if (modelingProject.some()) {
			session = modelingProject.get().getSession();
		} else {
			Session tempSession = null;
			SessionCreationOperation sessionCreationOperation = new DefaultLocalSessionCreationOperation(representationsURI, monitor);
			try {
				sessionCreationOperation.execute();
				tempSession = sessionCreationOperation.getCreatedSession();
			} catch (CoreException e) {
				logError(e);
			}
			if (tempSession != null) {
				session = tempSession;
			} else {
				session = null;
			}
		}
		return session;
	}

	protected void logError(Throwable e) {
		final IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR, e.getMessage(), e);
		Activator.getDefault().getLog().log(status);
	}

	public IProject getNewProject() {
		return this.project;
	}

	private IProject createProject(String projectName, URI location) throws CoreException {
		IProject newProject = null;
		if (projectName!=null && projectName.length()>0) {
			newProject = createBaseProject(projectName, location);
			addNature(newProject, XTEXT_NATURE);
			// On met la nature Modeling a posteriori pour créer l'AIRD en même temps
			//addNature(project, ModelingProject.NATURE_ID);
		}
		return newProject;
	}

	private IProject createBaseProject(String projectName, URI location) throws CoreException {
		final IWorkspaceRoot rootWs = ResourcesPlugin.getWorkspace().getRoot();
		final IProject newProject = rootWs.getProject(projectName);
		if (!newProject.exists()) {
			URI projectLocation = location;
			final IProjectDescription description = newProject.getWorkspace().newProjectDescription(newProject.getName());
			if (location != null && rootWs.getLocationURI().equals(location)) projectLocation = null;
			description.setLocationURI(projectLocation);
			newProject.create(description, null);
			if (!newProject.isOpen()) newProject.open(null);
		}
		return newProject;
	}

	private void addNature(IProject project, String natureId) throws CoreException {
		if (!project.hasNature(natureId)) {
			final IProjectDescription desc = project.getDescription(); 
			final String[] prevNatures = desc.getNatureIds(); 
			final String[] newNatures = new String[prevNatures.length + 1]; 
			System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length); 
			newNatures[prevNatures.length] = natureId;
			desc.setNatureIds(newNatures);			
			project.setDescription(desc, null);
		}
	}

	private void applyModaneViewpoints(IProject project, IProgressMonitor monitor, Session session, String modelPath) {
		monitor.subTask("Prepare Modane project..."); //$NON-NLS-1$
		CompoundCommand cc = new CompoundCommand("Prepare Modane project"); //$NON-NLS-1$ 
		cc.append(new AddSemanticResourceCommand(session, org.eclipse.emf.common.util.URI.createPlatformResourceURI(modelPath, true), SubMonitor.convert(monitor,1)));
		cc.append(new ChangeViewpointSelectionCommand(session, new ViewpointSelectionCallback(), getFirstModaneViewpoint(session), Collections.<Viewpoint> emptySet(), SubMonitor.convert(monitor,1)));
		monitor.subTask("Link the created models..."); //$NON-NLS-1$ 
		session.getTransactionalEditingDomain().getCommandStack().execute(cc);
		monitor.worked(10);
	}
	
	private HashSet<Viewpoint> getFirstModaneViewpoint(Session session) {
		final ViewpointRegistry registry = ViewpointRegistry.getInstance();
		final HashSet<Viewpoint> modaneViewpoints = new HashSet<Viewpoint>();
		for (Viewpoint v : registry.getViewpoints())
			if (v.getName().equals(MODANE_VIEWPOINT)) 
				{
					modaneViewpoints.add(v);
					// On ne récupère que le premier Viewpoint
					break;
				}
		return modaneViewpoints;
	}
}

