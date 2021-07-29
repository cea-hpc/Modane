/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.uml

import fr.cea.modane.modane.ModaneModel
import java.util.HashMap
import java.util.List
import org.eclipse.uml2.uml.Model

class ModelMetricsExtensions 
{
	static def getTotalNbElements(List<ModaneModel> models)
	{
		var totalNbElements = 0
		for (m : models) totalNbElements += m.eAllContents.size
		return totalNbElements
	}

	static def getNbElementsByModel(List<ModaneModel> models)
	{
		val nbElementsByModel = new HashMap<String, Integer>
		for (m : models)
			nbElementsByModel.put(m.name, m.eAllContents.size) 
		return nbElementsByModel
	}
	
	static def getUsedUmlEclass(Model umlModel)
	{
		val umlModelClasses = umlModel.eAllContents.groupBy[x|x.eClass].keySet
		umlModelClasses.map[name]
	}
}