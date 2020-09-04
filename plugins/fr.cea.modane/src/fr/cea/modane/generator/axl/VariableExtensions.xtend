/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.axl

import com.google.inject.Inject
import fr.cea.modane.modane.ItemType
import fr.cea.modane.modane.Variable

import static extension fr.cea.modane.ModaneStringExtensions.*

class VariableExtensions
{
	@Inject extension DescriptionUtils

	def getContent(Variable it)
	'''
		<variable field-name="«name.separateWith('_')»" name="«name»" data-type="«typeName»" item-kind="«itemKindName»"«IF family !== null» family-name="«family.name»"«ENDIF» dim="«dim»" dump="«dump»" need-sync="«needSync»" restore="«restore»" execution-depend="«executionDepend»"«componentExtension»>
			«description.formatDescription»
		</variable>
	'''

	private def getTypeName(Variable it) { type.literal.toLowerCase }

	private def getItemKindName(Variable it)
	{
		switch support
		{
			case ItemType::MAT_CELL : 'cell'
			case ItemType::ENV_CELL : 'cell'
			case ItemType::NO_ITEM : 'none'
			default : support.literal.toLowerCase
		}
	}

	private def getDim(Variable it) { multiplicity.ordinal }
	
	private def getComponentExtension(Variable it)
	{
		switch support
		{
			case ItemType::MAT_CELL : ' material="true"'
			case ItemType::ENV_CELL : ' environment="true"'
			default : ''
		}
	}
}