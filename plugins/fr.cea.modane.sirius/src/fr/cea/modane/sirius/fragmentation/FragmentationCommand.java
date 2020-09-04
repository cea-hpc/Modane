/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.fragmentation;

import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.sirius.business.api.control.SiriusControlCommand;
import org.eclipse.sirius.business.api.preferences.SiriusPreferencesKeys;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.SiriusPlugin;

import fr.cea.modane.modane.ModaneModel;

public class FragmentationCommand extends SiriusControlCommand implements IFragmentationCommand 
{
	private ModaneModel model;
	
	public FragmentationCommand(final ModaneModel model, URI semanticURI, URI airdURI, Set<DRepresentationDescriptor> representationsDescriptors, IProgressMonitor monitor) 
	{
		super(model, semanticURI, representationsDescriptors, airdURI, false, monitor);
		this.model = model;
	}

	public ModaneModel getModel() { return model; }
	
	@Override
	protected void doExecute() 
	{
		System.out.println("FragmentationCommand.doExecute()");
		// Execute with setting/resetting the preferences if needed
		doExecuteWithCorrectPreferences(() -> super.doExecute());
		System.out.println("FragmentationCommand.doExecute() fin");
	}
	
	private void doExecuteWithCorrectPreferences(Runnable command) 
	{
		IEclipsePreferences node = InstanceScope.INSTANCE.getNode(SiriusPlugin.ID);
		
		// Get current value
		boolean emptyAirdFragmentOnControl = node.getBoolean(SiriusPreferencesKeys.PREF_EMPTY_AIRD_FRAGMENT_ON_CONTROL.name(), false);
		
		if (emptyAirdFragmentOnControl == false) 
		{
			// We have to set the value before executing the command
			node.put(SiriusPreferencesKeys.PREF_EMPTY_AIRD_FRAGMENT_ON_CONTROL.name(), Boolean.TRUE.toString());
			// Execute the command
			command.run();
			// And then reset the value
			node.put(SiriusPreferencesKeys.PREF_EMPTY_AIRD_FRAGMENT_ON_CONTROL.name(), Boolean.FALSE.toString());
		} 
		else command.run();
	}
}
