/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.fragmentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.ModelChangeTrigger;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ext.base.Options;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;

import fr.cea.modane.modane.ModaneModel;
import fr.cea.modane.modaneproject.ModaneProject;
import fr.cea.modane.modaneproject.Package;

public class FragmentationModelChangeTrigger implements ModelChangeTrigger 
{
	private Session session = null;

	@Override
	public int priority() { return 0; }

	@Override
	public Option<Command> localChangesAboutToCommit(Collection<Notification> notifications) 
	{
		// Collect objects to test for fragmentation
		Collection<EObject> notifiers = new HashSet<>();		
		for (Notification notification : notifications) 
		{
			// Maybe we could filter a bit more, and only keep objects
			// whose containers are not within the list
			Object notifier = notification.getNotifier();
			if (notifier instanceof EObject && !notifiers.contains(notifier)) 
				notifiers.add((EObject)notifier);
		}

		// Create a command for each object which needs to be
		List<IFragmentationCommand> allCommands = new ArrayList<>();
		Collection<ModaneModel> modelsToBeFragmented = new ArrayList<>();
		Collection<ModaneModel> modelsToBeDefragmented = new ArrayList<>();

		for (EObject object : notifiers) 
		{							
			for (IFragmentationCommand fragmentationCmd : getFragmentationCommands(object)) 
			{
				if (fragmentationCmd instanceof FragmentationCommand) 
				{
					if (!modelsToBeFragmented.contains(fragmentationCmd.getModel())) 
					{
						// The command for this model is not already here 
						// to avoid duplicates
						allCommands.add(fragmentationCmd);
						modelsToBeFragmented.add(fragmentationCmd.getModel());
					}					
				} 
				else if (fragmentationCmd instanceof DefragmentationCommand) 
				{
					if (!modelsToBeDefragmented.contains(fragmentationCmd.getModel())) 
					{
						// The command for this model is not already here 
						// to avoid duplicates
						allCommands.add(fragmentationCmd);
						modelsToBeDefragmented.add(fragmentationCmd.getModel());
					}					
				}
			}
		}

		System.out.println("FragmentationModelChangeTrigger.localChangesAboutToCommit() : liste des modele à defragmenter : ");
		for (ModaneModel m : modelsToBeDefragmented) System.out.println("  - " + m.getName());
		System.out.println("FragmentationModelChangeTrigger.localChangesAboutToCommit() : liste des modele à fragmenter : ");
		for (ModaneModel m : modelsToBeFragmented) System.out.println("  - " + m.getName());
		
		// Build result
		if (allCommands.isEmpty()) return Options.newNone();
		else if (allCommands.size() == 1) return Options.newSome(allCommands.get(0));
		else 
		{
			// Build a compound command
			CompoundCommand compoundCmd = new CompoundCommand();
			for (IFragmentationCommand cmd : allCommands) compoundCmd.append(cmd);
			return Options.newSome(compoundCmd);
		}
	}
	
    private Collection<IFragmentationCommand> getFragmentationCommands(EObject object) 
    {
    	// Steps
    	// 1 - get all ModaneModelReference instances
    	// 2 - check whether the referenced ModaneModel is in its own resource and whether the URI is the expected one
    	// 3 - check whether the aird file exists
    	// 4 - create the resource if needed and the corresponding aird file
    	if (object instanceof ModaneProject) {
    		ModaneProject root = (ModaneProject)object;
			return caseModaneProject(root);
    	} else if (object instanceof Package) {
    		Package p = (Package) object;
    		return casePackage(p);
    	} else if (object instanceof ModaneModel) {
    		ModaneModel model = (ModaneModel)object;
    		return getCommandsForModaneModel(model);
    	}
    	return Collections.emptyList();
    }

	private Collection<IFragmentationCommand> caseModaneProject(ModaneProject root) 
	{
		Collection<IFragmentationCommand> commands = new ArrayList<>();
		for (Package p : root.getSubPackages()) commands.addAll(casePackage(p));
		return commands;
	}
	
	
	private Collection<IFragmentationCommand> casePackage(Package p) 
	{
		Collection<IFragmentationCommand> commands = new ArrayList<>();
		for (Package subPackage : p.getSubPackages()) commands.addAll(casePackage(subPackage));
		if (p.getModel() != null) commands.addAll(getCommandsForModaneModel(p.getModel()));
		return commands;
	}
	
	private Collection<IFragmentationCommand> getCommandsForModaneModel(ModaneModel model) 
	{
		Collection<IFragmentationCommand> commands = new ArrayList<>();
		URI semanticURI = FragmentationUtils.getSemanticURI(model);

		// L'URI est-elle déjà correcte ?
		if (!semanticURI.equals(model.eResource().getURI())) 
		{
			// is the model already fragmented ?
			if (FragmentationUtils.isControlled(model)) 
				// Object is controlled but not in the right resource
				// We have to uncontrol before controlling with the correct uri
				commands.add(new DefragmentationCommand(model, new NullProgressMonitor()));
			// else object is not controlled and uncontrol is useless
			
			URI airdURI = FragmentationUtils.getAirdURI(model);
			commands.add(new FragmentationCommand(model,
					semanticURI,
					airdURI,
					new HashSet<DRepresentationDescriptor>(getRepresentationDescriptors(model)),
					new NullProgressMonitor()));
		}
		
		return commands;
	}
    
    private Collection<DRepresentationDescriptor> getRepresentationDescriptors(EObject object) 
    {
		return DialectManager.INSTANCE.getRepresentationDescriptors(object, getSession(object));
    }

    private Session getSession(EObject object) 
    {
    	if (session == null) session = new EObjectQuery(object).getSession();
    	return session;
    }
}

