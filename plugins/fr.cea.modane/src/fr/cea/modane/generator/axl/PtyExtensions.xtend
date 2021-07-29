/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.axl

import com.google.inject.Inject
import fr.cea.modane.modane.Enumeration
import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.Item
import fr.cea.modane.modane.ItemGroup
import fr.cea.modane.modane.Legacy
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.PtyMultiplicity
import fr.cea.modane.modane.Reference
import fr.cea.modane.modane.Referenceable
import fr.cea.modane.modane.Simple
import fr.cea.modane.modane.Struct
import fr.cea.modane.modane.UserCategory
import java.util.HashMap
import java.util.List

import static extension fr.cea.modane.ModaneElementExtensions.*
import static extension fr.cea.modane.ModaneStringExtensions.*
import static extension fr.cea.modane.StructExtensions.*

class PtyExtensions
{
	@Inject extension DescriptionUtils

	def CharSequence getContent(Pty it, HashMap<Struct, Integer> encounteredStructs)
	{
		getContent(type, encounteredStructs)
	}

	def dispatch getReferencedName(Struct it) { 'I' + name }
	def dispatch getReferencedName(Interface it) { 'I' + name }
	def dispatch getReferencedName(Referenceable it) { name }

	def getReferencedNameWithNs(Referenceable it)
	{
		if (nsName !== null && nsName != '')
			'::' + nsName + '::' + referencedName
		else
			referencedName
	}

	private def dispatch getContent(Pty it, Simple t, HashMap<Struct, Integer> encounteredStructs)
	'''
		<simple 
			name="«name.separateWith('-')»"
			type="«t.type.literal.toLowerCase»"
			«IF defaultValue !== null» default="«defaultValue»"«ENDIF»
			«arcaneBound»>
				«idBlock»
		</simple>
	'''

	private def dispatch getContent(Pty it, Item t, HashMap<Struct, Integer> encounteredStructs)
	'''
		<extended 
			name="«name.separateWith('-')»"
			type="«t.type.literal»"
			«IF defaultValue !== null» default="«defaultValue»"«ENDIF»
			«arcaneBound»>
				«idBlock»
		</extended>
	'''

	private def dispatch getContent(Pty it, ItemGroup t, HashMap<Struct, Integer> encounteredStructs)
	'''
		<extended 
			name="«name.separateWith('-')»"
			type="«t.type.literal»"
			«IF defaultValue !== null» default="«defaultValue»"«ENDIF»
			«arcaneBound»>
				«idBlock»
		</extended>
	'''

	private def dispatch getContent(Pty it, Reference t, HashMap<Struct, Integer> encounteredStructs)
	{ 
		getReferenceContent(t.target, encounteredStructs)
	}

	/**
	 * On ne peut pas faire ref="«t.shortName»" a la place de type=... 
	 * si la cardinalité n'est pas la même pour les deux types.
	 */
	private def dispatch getReferenceContent(Pty it, Struct t, HashMap<Struct, Integer> encounteredStructs)
	'''
		<complex 
			name="«name.separateWith('-')»"
			interface="«t.referencedNameWithNs»"
			type="«t.getStructTypeName(encounteredStructs)»"
			«arcaneBound»>
				«idBlock»
				«FOR pty : t.allProperties»«pty.getContent(encounteredStructs)»«ENDFOR»
		</complex>
	'''

	private def getStructTypeName(Struct s, HashMap<Struct, Integer> encounteredStructs)
	{
		var nbStructs = encounteredStructs.get(s)
		if (nbStructs === null)
		{
			encounteredStructs.put(s, 1)
			s.name
		}
		else 
		{
			encounteredStructs.put(s, nbStructs + 1)
			s.name + (nbStructs + 1).toString
		}
	}

	private def dispatch getReferenceContent(Pty it, Interface t, HashMap<Struct, Integer> encounteredStructs)
	'''
		<service-instance
			name="«name.separateWith('-')»"
			type="«t.referencedNameWithNs»"
			«IF defaultValue!==null»default="«defaultValue.split('\\.').last»"«ENDIF»
			«arcaneBound»>
				«idBlock»
		</service-instance>
	'''

	private def dispatch getReferenceContent(Pty it, Enumeration t, HashMap<Struct, Integer> encounteredStructs)
	'''
		<enumeration 
			name="«name.separateWith('-')»"
			type="«t.referencedNameWithNs»"
			«IF defaultValue!==null» default="«defaultValue.separateWith('-')»"«ENDIF»
			«arcaneBound»>
				«idBlock»
				«FOR l : t.literals»
				<enumvalue genvalue="«t.referencedNameWithNs»::«l.name.toFirstUpper»" name="«l.name.separateWith('-')»">
					«getIdBlock(l.categories, l.namefr, l.description)»
				</enumvalue>
				«ENDFOR»
		</enumeration>
	'''

	private def dispatch getReferenceContent(Pty it, Legacy t, HashMap<Struct, Integer> encounteredStructs)
	'''
		<service-instance
			name="«name.separateWith('-')»"
			type="«t.referencedNameWithNs»"
			«IF defaultValue!==null» default="«defaultValue.split('\\.').last»"«ENDIF»
			«arcaneBound»>
				«idBlock»
		</service-instance>
	'''

	private def getArcaneBound(Pty it)
	{
		switch multiplicity
		{
			case PtyMultiplicity::ZERO_STAR : '''minOccurs="0" maxOccurs="unbounded"'''
			case PtyMultiplicity::ONE_STAR : '''minOccurs="1" maxOccurs="unbounded"'''
			case PtyMultiplicity::ZERO_ONE : '''optional="true"'''
			default : ''''''
		}
	}

	private def getIdBlock(Pty it)  { getIdBlock(categories, namefr, description) }

	private def getIdBlock(List<UserCategory> categories, String namefr, String description)
	{
		var result = ""
		for (c : categories)
			result += "<userclass>" + c.name + "</userclass>"
		if (!namefr.nullOrEmpty)
			result += "<name lang='fr'>" + namefr.separateWith('-') + "</name>"
		if (!description.nullOrEmpty)
			result += description.formatDescription
		return result;
	}
}