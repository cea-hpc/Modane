/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.services

import fr.cea.modane.modane.Enumeration
import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.ItemFamily
import fr.cea.modane.modane.Legacy
import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.Module
import fr.cea.modane.modane.Reference
import fr.cea.modane.modane.Service
import fr.cea.modane.modane.ServiceOrModule
import fr.cea.modane.modane.Struct
import fr.cea.modane.modane.Variable
import java.util.List

import static extension fr.cea.modane.sirius.services.ModaneElementColorExtensions.*

class ModaneElementExtensions 
{
	static def dispatch getProperties(ServiceOrModule it) { properties }
	static def dispatch getProperties(Struct it) { properties }
	static def dispatch getProperties(Interface it) { properties }
	static def dispatch getProperties(ModaneElement it) { #[] }
	
	static def dispatch getFunctions(ServiceOrModule it) { functions }
	static def dispatch getFunctions(Interface it) { functions }
	static def dispatch getFunctions(ModaneElement it) { #[] }

	static def dispatch hasOperations(Module it) { entryPoints.size + overrideFuncs.size + functions.size > 0 }
	static def dispatch hasOperations(Service it) { overrideFuncs.size + functions.size > 0 }
	static def dispatch hasOperations(Interface it) { functions.size > 0 }
	static def dispatch hasOperations(ModaneElement it) { false }
	
	static def dispatch List<? extends ModaneElement> getParents(Interface it) { parents }
	static def dispatch List<? extends ModaneElement> getParents(Struct it) { parents }
	static def dispatch List<? extends ModaneElement> getParents(ModaneElement it) { #[] }

	static def dispatch List<? extends ModaneElement> getInterfaces(ServiceOrModule it) { interfaces }
	static def dispatch List<? extends ModaneElement> getInterfaces(ModaneElement it) { #[] }

	static def dispatch List<? extends ModaneElement> getAllParents(Interface it) { parents }
	static def dispatch List<? extends ModaneElement> getAllParents(Struct it) { parents }
	static def dispatch List<? extends ModaneElement> getAllParents(ServiceOrModule it) { interfaces }
	static def dispatch List<? extends ModaneElement> getAllParents(ModaneElement it) { #[] }

	static def dispatch getInfo(Legacy it) { originFile }
	static def dispatch getInfo(ModaneElement it) { null }
	static def hasInfo(ModaneElement it) { info !== null }
	
	static def dispatch isPropertiesContainer(ServiceOrModule it) { true }
	static def dispatch isPropertiesContainer(Interface it) { true }
	static def dispatch isPropertiesContainer(Struct it) { true }
	static def dispatch isPropertiesContainer(ModaneElement it) { false }

	static def dispatch isOperationsContainer(ServiceOrModule it) { true }
	static def dispatch isOperationsContainer(Interface it) { true }
	static def dispatch isOperationsContainer(ModaneElement it) { false }

	static def dispatch isRelatedElementsContainer(Legacy it) { false }
	static def dispatch isRelatedElementsContainer(Enumeration it) { false }
	static def dispatch isRelatedElementsContainer(Variable it) { false }
	static def dispatch isRelatedElementsContainer(ModaneElement it) { true }

	static def dispatch isChildrenContainer(Struct it) { true }
	static def dispatch isChildrenContainer(Interface it) { true }
	static def dispatch isChildrenContainer(ModaneElement it) { false }
	
	private static def getAssociations(ModaneElement it) 
	{ 
		properties.map[p|p.type].filter[t|t instanceof Reference].map[x | (x as Reference).target as ModaneElement]
	}

	static def getRelatedElements(ModaneElement it) { (associations + parents + interfaces).toList }

	static def getBluePackageColor(ModaneElement it) { packageColor.blue }
	static def getGreenPackageColor(ModaneElement it) { packageColor.green }
	static def getRedPackageColor(ModaneElement it) { packageColor.red }
	
	static def isDesignDiagramDisplayable(ModaneElement it)
	{
		switch it 
		{ 
			Variable : false
			ItemFamily : false
			default : true
		}
	}
}
