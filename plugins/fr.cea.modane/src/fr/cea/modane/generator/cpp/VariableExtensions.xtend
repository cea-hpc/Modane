/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.cpp

import fr.cea.modane.modane.ItemType
import fr.cea.modane.modane.SimpleType
import fr.cea.modane.modane.Variable
import fr.cea.modane.modane.VariableMultiplicity

import static extension fr.cea.modane.ModaneStringExtensions.*

class VariableExtensions 
{	
	static def getFieldName(Variable it) { 'm_' + name.separateWith('_') }
	
	static def getTypeName(Variable it) { getTypeName(type, support, multiplicity) }	

	static def getTypeName(SimpleType varType, ItemType support, VariableMultiplicity mult) 
	{
		var tname = if (varType == SimpleType::BOOL) 'Byte' else varType.literal
		var result = ''

		switch support
		{
			case ItemType::MAT_CELL : result = 'MaterialVariableCell'
			case ItemType::ENV_CELL : result = 'EnvironmentVariableCell'
			case ItemType::NO_ITEM : result = 'Variable'
			default : result = 'Variable' + support.literal
		}

		switch mult 
		{
			case VariableMultiplicity::SCALAR: result += if(support == ItemType::NO_ITEM) 'Scalar' + tname else tname
			case VariableMultiplicity::ARRAY: result += 'Array' + tname
			case VariableMultiplicity::ARRAY2: result += 'Array2' + tname
		}

		return result;
	}
}