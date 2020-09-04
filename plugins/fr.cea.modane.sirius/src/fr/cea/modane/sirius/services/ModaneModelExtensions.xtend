/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.services

import fr.cea.modane.modane.ModaneModel
import java.util.HashSet
import org.eclipse.emf.ecore.util.EcoreUtil

class ModaneModelExtensions 
{
	def getName(ModaneModel it) { namePrefix + 'Model' }

	def getNamePrefix(ModaneModel it)
	{
		val name = eResource.URI.trimFileExtension.lastSegment.toFirstUpper
		if (name.startsWith('__')) name.substring(2)
		else name	
	}
	
	def getReferencedModaneModels(ModaneModel it)
	{
		val references = EcoreUtil.ExternalCrossReferencer.find(it)
		val referencedModels = new HashSet<ModaneModel>
		for (k : references.keySet)
			referencedModels.add(Utils::getModaneModel(k))
		return referencedModels
	}
}