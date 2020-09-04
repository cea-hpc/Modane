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

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.control.SiriusUncontrolCommand;
import org.eclipse.sirius.viewpoint.Messages;
import org.eclipse.sirius.viewpoint.SiriusPlugin;
import org.eclipse.xtext.resource.XtextResource;

import fr.cea.modane.modane.ModaneModel;

public class DefragmentationCommand extends SiriusUncontrolCommand  implements IFragmentationCommand 
{
	private ModaneModel model;
	
	public DefragmentationCommand(final ModaneModel model, IProgressMonitor monitor) 
	{
		super(model, true, false, monitor);
		this.model = model;
	}

	public ModaneModel getModel() { return model; }
	
	@Override
	protected void doExecute() 
	{
		System.out.println("DefragmentationCommand.doExecute()");
		super.doExecute();
		System.out.println("fin de DefragmentationCommand.doExecute()");
	}

	@Override
	protected void deleteResource(Resource res) 
	{
		System.out.println("DefragmentationCommand.deleteResource() sur " + res.getURI().toString());
		if (res != null) 
		{
            try 
            {
            	if (!(res instanceof XtextResource)) res.save(Collections.emptyMap());
                res.delete(Collections.emptyMap());
            } 
            catch (IOException e) 
            {
                SiriusPlugin.getDefault().error(Messages.SiriusUncontrolCommand_resourceDeletionFailedMsg, e);
            }
        }
	}
}
