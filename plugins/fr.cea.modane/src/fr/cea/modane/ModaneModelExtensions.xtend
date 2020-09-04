/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane

import fr.cea.modane.modane.ModaneModel
import fr.cea.modane.modane.ModanePackage
import java.util.LinkedHashSet
import org.eclipse.xtext.scoping.IScope

class ModaneModelExtensions 
{
	static def String[] getNameTokens(ModaneModel it) 
	{
		if (name.nullOrEmpty) #[] 
		else name.split("\\.")
	}
	
	static def getNsName(ModaneModel it) { nameTokens.map[s | s.toFirstUpper].join }	
	static def getOutputPath(ModaneModel it) { if (nameTokens.empty) '' else nameTokens.join('/') }
	static def areEquals(ModaneModel a, ModaneModel b) { a.name == b.name }
	
	static def getModelNames(IScope scope)
	{
		val packages = new LinkedHashSet<String>
		for (desc : scope.allElements.filter[x|x.EClass===ModanePackage::eINSTANCE.modaneModel])
			packages += desc.name.toString
		return packages
	}
}