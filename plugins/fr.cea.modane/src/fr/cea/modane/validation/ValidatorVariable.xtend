/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.validation

import fr.cea.modane.modane.ItemType
import fr.cea.modane.modane.ModanePackage
import fr.cea.modane.modane.SimpleType
import fr.cea.modane.modane.VarDefinition
import fr.cea.modane.modane.Variable
import fr.cea.modane.modane.VariableMultiplicity
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.xtend.lib.annotations.Data

interface ValidatorVariable 
{
	def ItemType getSupport()
	def VariableMultiplicity getMultiplicity()
	def SimpleType getType()
	def EAttribute getSupportLiteral()
	def EAttribute getMultiplicityLiteral()
}

@Data
class VariableValidatorVariable implements ValidatorVariable
{
	val Variable v
	
	override getSupport() { v.support }
	override getMultiplicity() { v.multiplicity }	
	override getType() { v.type }
	override getSupportLiteral() { ModanePackage.Literals::VARIABLE__SUPPORT }
	override getMultiplicityLiteral() { ModanePackage.Literals::VARIABLE__MULTIPLICITY }
}

@Data
class VarDefinitionValidatorVariable implements ValidatorVariable
{
	val VarDefinition v
	
	override getSupport() { v.support }
	override getMultiplicity() { v.multiplicity }	
	override getType() { v.type }
	override getSupportLiteral() { ModanePackage.Literals::VAR_DEFINITION__SUPPORT }
	override getMultiplicityLiteral() { ModanePackage.Literals::VAR_DEFINITION__MULTIPLICITY }
}
