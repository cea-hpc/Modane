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

import fr.cea.modane.sirius.ui.dialogs.ConfirmDeletionServices
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.command.DeleteCommand
import org.eclipse.emf.transaction.util.TransactionUtil
import org.eclipse.jface.viewers.TreeSelection
import org.eclipse.ui.handlers.HandlerUtil

class EmfDeleteHandler extends AbstractHandler
{
	override execute(ExecutionEvent event) throws ExecutionException 
	{
		val selection = HandlerUtil:: getActiveMenuSelection(event)
		if (selection !== null && selection instanceof TreeSelection) 
		{
			val elt = (selection as TreeSelection).firstElement
			if (elt instanceof EObject) 
			{
				val services = new ConfirmDeletionServices
				if (services.showConfirmationDeletionDialogForEObjects(#[elt]))
				{
					val domain = TransactionUtil::getEditingDomain(elt)
					domain.commandStack.execute(DeleteCommand::create(domain, services.getAllElementsToDelete(elt)))
				}
			}
		}
		return selection
	}
}
