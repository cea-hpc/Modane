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

import fr.cea.modane.modane.ModaneFactory
import fr.cea.modane.modaneproject.ModaneprojectFactory
import fr.cea.modane.modaneproject.ModaneprojectPackage
import fr.cea.modane.modaneproject.PackagesContainer
import fr.cea.modane.sirius.ui.dialogs.CreatePackageDialog
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.command.CreateChildCommand
import org.eclipse.emf.edit.domain.EditingDomain
import org.eclipse.jface.window.Window

class CreatePackageHandler extends EmfCommandHandler 
{
	new() { super(ModaneprojectPackage::eINSTANCE.packagesContainer) }
	
	override execute(EditingDomain ed, EObject elt)
	{
		val dlg = new CreatePackageDialog(null)
		if (dlg.open == Window.OK) 
		{
			val container = elt as PackagesContainer
			var p = container.subPackages.findFirst[s|s.name == dlg.data.packageName]
			if (p === null)
			{
				// On crée le package
				p = ModaneprojectFactory.eINSTANCE.createPackage
				p.name = dlg.data.packageName
				ed.commandStack.execute(new CreateChildCommand(ed, container, ModaneprojectPackage::eINSTANCE.packagesContainer_SubPackages, p, null))
			}
			
			// On créé le ModaneModel si demandé
			if (dlg.data.createModaneModel) 
			{
				val model = ModaneFactory.eINSTANCE.createModaneModel
				model.name = p.fullyQualifiedName
				ed.commandStack.execute(new CreateChildCommand(ed, p, ModaneprojectPackage::eINSTANCE.package_Model, model, null))
			}		
		}
	}
}
