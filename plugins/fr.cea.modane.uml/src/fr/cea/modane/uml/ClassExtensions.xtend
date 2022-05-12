/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.uml

import fr.cea.modane.modane.ItemType
import fr.cea.modane.modane.ServiceType
import fr.cea.modane.modane.SimpleType
import fr.cea.modane.modane.VariableMultiplicity
import org.eclipse.emf.ecore.EObject
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.EnumerationLiteral
import org.eclipse.uml2.uml.Profile
import org.eclipse.uml2.uml.Property
import org.eclipse.uml2.uml.Stereotype

import static extension fr.cea.modane.uml.ArcaneProfileExtensions.*
import static extension fr.cea.modane.uml.EObjectExtensions.*

class ClassExtensions
{
	Profile profile

	new (Profile arcaneProfile)
	{
		this.profile = arcaneProfile
	}

	def getPties(Class it) { ownedMembers.filter(m | m.isStereotypeApplied(profile.ptySt)).filter(x | (x as Property).upperBound != 0) }
	def getEntryPoints(Class it) { ownedOperations.filter(o | o.isStereotypeApplied(profile.entryPointSt)) }
	def getFuncs(Class it) { ownedOperations.filter(o | o.isStereotypeApplied(profile.funcSt)) }
	def getParentStructs(Class it) { parents.filter(s | s.isStereotypeApplied(profile.structSt)) }

	def getVarDump(Class it) { getValue(profile.variableSt, "dump") as Boolean }
	def getVarExecDep(Class it) { getValue(profile.variableSt, "executionDepend") as Boolean }
	def getVarNeedSync(Class it) { getValue(profile.variableSt, "needSync") as Boolean }
	def getVarRestore(Class it) { getValue(profile.variableSt, "restore") as Boolean }

	def getVarMult(Class it)
	{
		val umlMult = getValue(profile.variableSt, "multiplicity") as EnumerationLiteral
		VariableMultiplicity::getByName(umlMult.name)
	}

	def getVarSupport(Class it)
	{
		getSupport(profile.variableSt)
	}

	def getVarItemFamily(Class it)
	{
		val family = getValue(profile.variableSt, "family") as EObject
		if (family === null)
			null
		else
			family.toUmlClass
	}

	def getVarType(Class it)
	{
		val umlType = getValue(profile.variableSt, "type") as EObject
		SimpleType::getByName(umlType.toUmlPrimitiveType.name)
	}

	def getItemFamilySupport(Class it)
	{
		getSupport(profile.itemFamilySt)
	}

	private def getSupport(Class it, Stereotype s)
	{
		val umlSupport = getValue(s, "support") as EObject
		if (umlSupport === null) ItemType::NO_ITEM
		else ItemType::getByName(umlSupport.toUmlPrimitiveType.name)
	}

	def getServiceType(Class it)
	{
		val type = getValue(profile.serviceSt, "type") as EnumerationLiteral
		ServiceType::getByName(type.name.toLowerCase)
	}

	def isSingleton(Class it)
	{
		getValue(profile.serviceSt, "singleton") as Boolean
	}

	def getForceInclude(Class it) { getValue(profile.legacySt, "forceInclude") as Boolean }
	def getLegacyNamespace(Class it) { getValue(profile.legacySt, "originNamespace") as String }
	def getLegacyFile(Class it) { getValue(profile.legacySt, "file") as String }
}