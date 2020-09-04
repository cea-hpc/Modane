/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.handlers

import fr.cea.modane.modane.ModaneModel
import fr.cea.modane.modane.ModanePackage
import fr.cea.modane.modaneproject.ModaneprojectFactory
import fr.cea.modane.modaneproject.ModaneprojectPackage
import fr.cea.modane.modaneproject.Package
import fr.cea.modane.modaneproject.PackagesContainer
import fr.cea.modane.sirius.ui.dialogs.RenamePackageDialog
import java.util.ArrayList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.command.CreateChildCommand
import org.eclipse.emf.edit.command.SetCommand
import org.eclipse.emf.edit.domain.EditingDomain
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.jface.window.Window

import static extension fr.cea.modane.project.PackagesContainerExtensions.*

class RenamePackageHandler extends EmfCommandHandler
{
	new() { super(ModaneprojectPackage::eINSTANCE.package) }

	override execute(EditingDomain ed, EObject elt)
	{
		val p = elt as Package
		val dlg = new RenamePackageDialog(null, p.name)
		if (dlg.open == Window.OK)
		{
			val newName = dlg.getData.newPackageName
			if (newName == p.name) return;
			
			if ((p.eContainer as PackagesContainer).subPackages.exists[x|x.name == newName])
			{ 
				MessageDialog.openError(null, "Rename Package", "A package with this name already exists")
				return
			}

			// On doit renommer si il n'y a pas de sous-packages
			// ou si l'utilisateur a décidé de renommer tous les sous-packages
			// sinon il faut créer un nouveau package pour ne pas impacter les sous-packages.
			val modelsToDefrag = new ArrayList<ModaneModel>
			var shouldRename = false
			if (p.subPackages.isEmpty)
			{
				if (p.model !== null) modelsToDefrag += p.model
				shouldRename = true
			}
			else
			{
				if (dlg.data.renameSubPackages)
				{
					modelsToDefrag += p.allModaneModels
					shouldRename = true
				}
				else
				{
					if (p.model !== null) modelsToDefrag += p.model
					// Pas de renommage pour ne pas affecter les sous packages
					// mais création d'un nouveau package et placement du model dedans
					shouldRename = false
				}
			}

			// defragmentation
			defragment(ed, modelsToDefrag)

			if (shouldRename)
			{
				// On renomme le répertoire puis on met à jour tous les noms de modanemodel contenus
				ed.commandStack.execute(new SetCommand(ed, p, ModaneprojectPackage::eINSTANCE.packagesContainer_Name, newName))
				for (child : p.eAllContents.filter(Package).filter[x|x.model!==null].toIterable)
					ed.commandStack.execute(new SetCommand(ed, child.model, ModanePackage::eINSTANCE.modaneModel_Name, child.fullyQualifiedName))
				if (p.model !== null)
					ed.commandStack.execute(new SetCommand(ed, p.model, ModanePackage::eINSTANCE.modaneModel_Name, p.fullyQualifiedName))
			} 
			else 
			{
				// On crée un nouveau package pour ne pas changer toute la hiérarchie
				val parent = p.eContainer
				if (parent instanceof PackagesContainer) 
				{
					// création du package
					val newP = ModaneprojectFactory.eINSTANCE.createPackage
					newP.name = newName	
					ed.commandStack.execute(new CreateChildCommand(ed, parent, ModaneprojectPackage::eINSTANCE.packagesContainer_SubPackages, newP, null))

					// affectation du modèle
					ed.commandStack.execute(new SetCommand(ed, newP, ModaneprojectPackage::eINSTANCE.package_Model, p.model))
					ed.commandStack.execute(new SetCommand(ed, newP.model, ModanePackage::eINSTANCE.modaneModel_Name, newP.fullyQualifiedName))
				}
			}
		}
	}
}
