/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.cpp

import fr.cea.modane.modane.Direction
import fr.cea.modane.modane.VarDefinition
import fr.cea.modane.modane.VarReference

import static extension fr.cea.modane.ModaneStringExtensions.*
import static extension fr.cea.modane.generator.cpp.ItemTypeExtensions.*
import static extension fr.cea.modane.generator.cpp.VariableExtensions.*

abstract class CppVariable 
{
	abstract def String getName()
	abstract def String getDescription()
	abstract def Direction getDirection()
	abstract def boolean isComponent()
	abstract def String getTypeName()
	abstract def String getArgName()
	
	final def String getFieldName() { 'm_' + name }
	final def String getArgTypeName()
	{
		if (direction == Direction::IN) 'const ' + typeName + '&'
		else typeName + '&'
	}
}

class CppVarDefinition extends CppVariable
{
	VarDefinition v
	
	new(VarDefinition variable) { v = variable }

	override getName() { v.name }
	override getDescription() { null }
	override getDirection() { v.direction }
	override isComponent() { v.support.component }
	override getTypeName() { getTypeName(v.type, v.support, v.multiplicity) }
	override getArgName() { v.name }	
}

class CppVarReference  extends CppVariable
{
	VarReference v
	
	new(VarReference variable) { v = variable }

	override getName() { v.variable.name.separateWith('_') }
	override getDescription() { v.variable.description }
	override getDirection() { v.direction }
	override isComponent() { v.variable.support.component }
	override getTypeName() { v.variable.typeName }
	override getArgName() { fieldName }
}
	
