/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.handlers

import fr.cea.modane.modane.ModaneModel
import fr.cea.modane.sirius.fragmentation.DefragmentationCommand
import java.util.List
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.domain.EditingDomain
import org.eclipse.emf.transaction.util.TransactionUtil
import org.eclipse.jface.viewers.TreeSelection
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.xtend.lib.annotations.Data

@Data
abstract class EmfCommandHandler extends AbstractHandler
{
	val EClass myClass
	
	override execute(ExecutionEvent event) throws ExecutionException 
	{
		val selection = HandlerUtil:: getActiveMenuSelection(event)
		if (selection !== null && selection instanceof TreeSelection) 
		{
			val elt = (selection as TreeSelection).firstElement
			if (elt instanceof EObject && myClass.isSuperTypeOf((elt as EObject).eClass)) 
			{				
				val o = elt as EObject
				val editingDomain = TransactionUtil::getEditingDomain(o)
				execute(editingDomain, o)
			}
		}
		return selection
	}
	
	abstract def void execute(EditingDomain ed, EObject elt)

	protected def void defragment(EditingDomain ed, List<ModaneModel> models)
	{
		for (model : models)
		{
			//println('Demande de defragmentation du model : ' + model.name)
			ed.commandStack.execute(new DefragmentationCommand(model, new NullProgressMonitor))
			//println('Fin de defragmentation')
		}			
	}
}