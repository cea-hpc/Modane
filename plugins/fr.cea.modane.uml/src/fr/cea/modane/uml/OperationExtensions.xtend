/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.uml

import fr.cea.modane.modane.EntryPointAutoLoad
import fr.cea.modane.modane.EntryPointLocation
import fr.cea.modane.modane.FunctionItemType
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.uml2.uml.EnumerationLiteral
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.ParameterDirectionKind
import org.eclipse.uml2.uml.Profile
import org.eclipse.uml2.uml.Stereotype

import static extension fr.cea.modane.uml.ArcaneProfileExtensions.*
import static extension fr.cea.modane.uml.EObjectExtensions.*

class OperationExtensions 
{
	Profile profile
	
	new (Profile arcaneProfile)
	{
		this.profile = arcaneProfile
	}
	
	def getEpInVars(Operation it) { getInVars(profile.entryPointSt) }
	def getEpOutVars(Operation it) { getOutVars(profile.entryPointSt) }
	def getEpInNotOutVars(Operation it) { getInNotOutVars(profile.entryPointSt) }
	def getEpCalledFuncs(Operation it) { getCalledFuncs(profile.entryPointSt) }

	def getEpLocation(Operation it) 
	{ 
		val umlLocation = getValue(profile.entryPointSt, "location") as EnumerationLiteral
		EntryPointLocation::getByName(umlLocation.name)
	}

	def getEpAutoLoad(Operation it) 
	{ 
		val umlAutoLoad = getValue(profile.entryPointSt, "autoLoad") as EnumerationLiteral
		switch (umlAutoLoad.name)
		{
			case 'Begin' : EntryPointAutoLoad::AUTO_LOAD_BEGIN
			case 'End' : EntryPointAutoLoad::AUTO_LOAD_END
			default : EntryPointAutoLoad::NO_AUTO_LOAD
		}
	}
	
	def getFuncInVars(Operation it) { getInVars(profile.funcSt) }
	def getFuncOutVars(Operation it) { getOutVars(profile.funcSt) }
	def getFuncInNotOutVars(Operation it) { getInNotOutVars(profile.funcSt) }
	def getFuncCalledFuncs(Operation it) { getCalledFuncs(profile.funcSt) }
	def isFuncParallel(Operation it) { getValue(profile.funcSt, "parallel") as Boolean }
	def isFuncConst(Operation it) { getValue(profile.funcSt, "const") as Boolean }
	private def isFuncItemTypeSpecialized(Operation it) { getValue(profile.funcSt, "itemTypeSpecialized") as Boolean }
	def getFuncSupport(Operation it)
	{
		if (isFuncItemTypeSpecialized)
			FunctionItemType::ITEM_TYPE_SPECIALIZED
		else
		{	
			val umlSupport =getValue(profile.funcSt, "support") as EObject
			if (umlSupport === null) FunctionItemType::NO_ITEM
			else FunctionItemType::getByName(umlSupport.toUmlPrimitiveType.name) 
		}
	}
	
	def hasReturnParameter(Operation it) { returnParameter !== null }	
	def getReturnParameter(Operation it)
	{
		ownedParameters.findFirst[x | x.direction == ParameterDirectionKind::RETURN_LITERAL]
	}
	
	def getInOutParameters(Operation it)
	{
		ownedParameters.filter(x | x.direction != ParameterDirectionKind::RETURN_LITERAL)		
	}
	
	private def getInVars(Operation it, Stereotype st) { getValue(st, "inVariables") as List<EObject> }
	private def getOutVars(Operation it, Stereotype st) { getValue(st, "outVariables") as List<EObject> }
	private def getInNotOutVars(Operation it, Stereotype st) { getInVars(st).filter[x | !getOutVars(st).contains(x)] }
	private def getCalledFuncs(Operation it, Stereotype st) { getValue(st, "calledFunctions") as List<EObject> }
}