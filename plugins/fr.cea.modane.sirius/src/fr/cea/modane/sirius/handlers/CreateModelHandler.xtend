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

import fr.cea.modane.modane.ModaneFactory
import fr.cea.modane.modaneproject.ModaneprojectPackage
import fr.cea.modane.modaneproject.Package
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.command.CreateChildCommand
import org.eclipse.emf.edit.domain.EditingDomain

class CreateModelHandler extends EmfCommandHandler 
{
	new() { super(ModaneprojectPackage::eINSTANCE.package) }
	
	override execute(EditingDomain ed, EObject elt)
	{
		val p = elt as Package
		if (p.model === null)	
		{	
			val model = ModaneFactory.eINSTANCE.createModaneModel
			model.name = p.fullyQualifiedName
			ed.commandStack.execute(new CreateChildCommand(ed, p, ModaneprojectPackage::eINSTANCE.package_Model, model, null))
		}
	}
}
