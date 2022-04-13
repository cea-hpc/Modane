/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.ui.wizard;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.query.DViewQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import com.google.common.collect.Sets;

import fr.cea.modane.sirius.Activator;

public class NewProjectWizard extends Wizard implements INewWizard {
	private final static String TITLE = "Modane Project";
	private WizardNewProjectCreationPage page;

	public NewProjectWizard() {
		setWindowTitle(TITLE);
	}

	@Override
	public void addPages() {
		super.addPages();
		page = new WizardNewProjectCreationPage(TITLE);
		page.setTitle(TITLE);
		page.setDescription("Create a new Modane project");
		addPage(page);
	}

	@Override
    public boolean performFinish() {
        boolean finished = true;
        
		String name = page.getProjectName();
		URI location = null;
		if (!page.useDefaults()) location = page.getLocationURI();
        final ProjectCreationOperation operation = new ProjectCreationOperation(name, location);
        
        try {
            getContainer().run(true, false, operation);
        } catch (InvocationTargetException e) {
            logError(e);;
            finished = false;
        } catch (InterruptedException e) {
            logError(e);;
            finished = false;
        }
        
        try {
            getContainer().run(false, false, new IRunnableWithProgress() {
                public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                    try {
                        monitor.beginTask("Open the diagram metamodel", 2);
                        monitor.worked(1);
                        openFirstRepresentation(operation.getNewProject(), SubMonitor.convert(monitor,1));
                    } finally {
                        monitor.done();
                    }
                }
            });
        } catch (InvocationTargetException e) {
            logError(e);;
            finished = false;
        } catch (InterruptedException e) {
            logError(e);;
            finished = false;
        }
        return finished;
    }

    @Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}
    
    /**
     * Open the first representation containing in the representation file of
     * this Modeling project.
     * 
     * @param project
     *            The modeling project containing the representations file.
     * @param monitor
     *            a {@link IProgressMonitor} to show progression of first
     *            {@link DRepresentation} opening
     */
    private void openFirstRepresentation(IProject project, IProgressMonitor monitor) {
        Option<ModelingProject> optionalModelingProject = ModelingProject.asModelingProject(project);
        if (optionalModelingProject.some()) {
            Session session = optionalModelingProject.get().getSession();
            if (session != null) {
                if (!session.getSelectedViews().isEmpty()) {
                    Set<DRepresentation> representationsToOpen = Sets.newLinkedHashSet();
                    for (DView view : session.getSelectedViews()) {
                        for (DRepresentation dRepresentation : new DViewQuery(view).getLoadedRepresentations()) {
                            representationsToOpen.add(dRepresentation);
                        }
                    }
                    for (DRepresentation dRepresentation : representationsToOpen) {
                        DialectUIManager.INSTANCE.openEditor(session, dRepresentation, monitor);
                    }
                }
            }
        }
    }

    private void logError(Throwable e) {
		final IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR, e.getMessage(), e);
		Activator.getDefault().getLog().log(status);
	}
}
