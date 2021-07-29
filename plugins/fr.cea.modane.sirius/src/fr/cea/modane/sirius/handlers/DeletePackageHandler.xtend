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

import fr.cea.modane.modaneproject.ModaneprojectPackage
import fr.cea.modane.modaneproject.Package
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.command.DeleteCommand
import org.eclipse.emf.edit.domain.EditingDomain
import org.eclipse.jface.dialogs.MessageDialog

import static extension fr.cea.modane.project.PackagesContainerExtensions.*

class DeletePackageHandler extends EmfCommandHandler 
{
	new() { super(ModaneprojectPackage::eINSTANCE.package) }
	
	override execute(EditingDomain ed, EObject elt)
	{
		val p = elt as Package
		val allModels = p.allModaneModels
		val confirm = allModels.empty || MessageDialog.openQuestion(null, "Delete Package", "Are you sure you want to delete all the models ?")
			
		if (confirm) 
		{
			// defragmentation
			defragment(ed, allModels)
			ed.commandStack.execute(DeleteCommand::create(ed, p))
		}
	}
}
