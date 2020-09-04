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
import fr.cea.modane.modaneproject.ModaneProject
import fr.cea.modane.modaneproject.ModaneprojectFactory
import fr.cea.modane.modaneproject.ModaneprojectPackage
import fr.cea.modane.modaneproject.Package
import fr.cea.modane.modaneproject.PackagesContainer
import fr.cea.modane.uml.UmlToModane
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.command.CreateChildCommand
import org.eclipse.emf.edit.command.SetCommand
import org.eclipse.emf.edit.domain.EditingDomain
import org.eclipse.swt.custom.BusyIndicator
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.FileDialog

import static extension fr.cea.modane.ModaneModelExtensions.*

class ImportUmlModelHandler  extends EmfCommandHandler 
{
	
	new() { super(ModaneprojectPackage::eINSTANCE.modaneProject) }
	
	override execute(EditingDomain ed, EObject elt)
	{
		val project = elt as ModaneProject
		// boite de dialogue pour choisir le fichier uml 
		val dlg = new FileDialog(Display::current.activeShell)
		dlg.text = "Sélectionner un fichier de modèle avec l'extension '.uml'"
		dlg.filterExtensions = #['*.uml']
		val umlModelFilePath = dlg.open
		if (umlModelFilePath !== null) 
		{
			val models = new ArrayList<ModaneModel> 
			BusyIndicator::showWhile(Display::current, [fillModaneModels(umlModelFilePath, models)])
			models.filter[x|!x.elements.empty].forEach[x | addModaneModel(ed, project, x)]
		}
	}
	
	private def fillModaneModels(String umlModelFilePath, List<ModaneModel> modaneModels)
	{
		val URI = URI::createFileURI(umlModelFilePath)
		val umlToModane = UmlToModane::createInstance
		val umlModel = umlToModane.readModel(URI)
		modaneModels.addAll(umlToModane.createModaneModels(umlModel, null))
	}
	
	private def addModaneModel(EditingDomain ed, PackagesContainer rootContainer, ModaneModel m)
	{
		val tokens = m.nameTokens
		var PackagesContainer container = rootContainer
		var Package child = null 
		for (token : tokens) 
		{ 
			child = container.subPackages.findFirst[s|s.name==token]
			if (child === null)
			{
				child = ModaneprojectFactory.eINSTANCE.createPackage
				child.name = token
				ed.commandStack.execute(new CreateChildCommand(ed, container, ModaneprojectPackage::eINSTANCE.packagesContainer_SubPackages, child, null))
			}
			container = child
		}
			
		// affectation du modele au package
		if (child !== null) 
		{
			ed.commandStack.execute(new SetCommand(ed, child, ModaneprojectPackage::eINSTANCE.package_Model, m))
		}
	}
}