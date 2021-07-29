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

import fr.cea.modane.modaneproject.ModaneProject
import fr.cea.modane.modaneproject.ModaneprojectPackage
import fr.cea.modane.sirius.ui.search.CyclesSearchQuery
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.domain.EditingDomain
import org.eclipse.search.ui.NewSearchUI

class FindCrossReferencesHandler extends EmfCommandHandler 
{
	val query = new CyclesSearchQuery

	new() 
	{ 
		super(ModaneprojectPackage::eINSTANCE.modaneProject)
	}

	override execute(EditingDomain ed, EObject elt) 
	{
		query.modaneProject = elt as ModaneProject
		NewSearchUI::runQueryInBackground(query)	
	}
}


