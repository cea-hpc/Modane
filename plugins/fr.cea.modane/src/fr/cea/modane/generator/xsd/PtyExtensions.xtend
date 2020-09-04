/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.xsd

import fr.cea.modane.Utils
import fr.cea.modane.modane.Enumeration
import fr.cea.modane.modane.EnumerationLiteral
import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.Item
import fr.cea.modane.modane.Legacy
import fr.cea.modane.modane.ModanePackage
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.PtyMultiplicity
import fr.cea.modane.modane.Reference
import fr.cea.modane.modane.Service
import fr.cea.modane.modane.Simple
import fr.cea.modane.modane.SimpleType
import fr.cea.modane.modane.Struct
import java.util.LinkedHashSet
import org.eclipse.emf.ecore.EObject

import static fr.cea.modane.generator.xsd.XsdUtils.*

import static extension fr.cea.modane.generator.xsd.ModaneElementExtensions.*

class PtyExtensions
{
	static def CharSequence getContent(Pty it)
	'''
		«IF !description.nullOrEmpty»<!-- «description» -->«ENDIF»
		«getContent(type)»
	'''

	private static def dispatch getContent(Pty it, Simple t)
	'''
		«IF t.type.attrType === null»
			<xs:element name="«xsdName»"«IF defaultValue!==null» default="«defaultValue»"«ENDIF» «arcaneBound»>
				<xs:simpleType><xs:list itemType="xs:double"/></xs:simpleType>
			</xs:element>
		«ELSE»
			<xs:element name="«xsdName»" type="«t.type.attrType»"«IF defaultValue!==null» default="«defaultValue»"«ENDIF» «arcaneBound»/>
		«ENDIF»
	'''

	private static def dispatch getContent(Pty it, Item t)
	'''
		<xs:element name="«xsdName»" type="xs:string"«IF defaultValue!==null» default="«defaultValue»"«ENDIF» «arcaneBound»/>
	'''

	private static def dispatch getContent(Pty it, Reference t)
	{
		// Legacy non géré pour l'instant
		if (!(t.target instanceof Legacy)) GenerationContext::Current.addImport(t.target)
		getReferenceContent(t.target)
	}

	private static def dispatch getReferenceContent(Pty it, Struct t)
	'''
		<xs:element name="«xsdName»" type="«t.xsdTypeNameWithNs»" «arcaneBound»/>
	'''

	private static def dispatch getReferenceContent(Pty it, Enumeration e)
	'''
		<xs:element name="«xsdName»" type="«e.xsdTypeNameWithNs»" «arcaneBound»/>
	'''

	/**
	 * PROBLEME : pas possible de contraindre la valeur de l'attribut et le contenu de l'élément
	 * Il faut faire des types nommés pour les services pour pouvoir les appeler après import.
	 *
	 */
	private static def dispatch getReferenceContent(Pty it, Interface i)
	'''
		<xs:element name="«xsdName»" type="«i.xsdTypeNameWithNs»"«IF defaultValue!==null» default="«defaultValue.split('\\.').last»"«ENDIF» «arcaneBound»>
			«FOR s : getAllServicesImplementing(i, it) SEPARATOR '\n'»<xs:alternative test="@name='«s.name»'" type="«s.xsdTypeName»"/>«ENDFOR»
		</xs:element>
	'''

	private static def dispatch getReferenceContent(Pty it, Legacy t)
	'''
		<!-- La propriété '«name»' de type Legacy n'est pas traitée car les types Legacy ne sont pas génés -->
	'''

	static def getXsdName(Pty p) { getXsdName(p.name, p.namefr) }
	static def getXsdName(EnumerationLiteral l) { getXsdName(l.name, l.namefr) }
	
	private static def getArcaneBound(Pty it)
	{
		switch multiplicity
		{
			case PtyMultiplicity::ZERO_STAR : '''minOccurs="0" maxOccurs="unbounded"'''
			case PtyMultiplicity::ONE_STAR : '''minOccurs="1" maxOccurs="unbounded"'''
			case PtyMultiplicity::ZERO_ONE : '''minOccurs="0" maxOccurs="1"'''
			default : '''minOccurs="1" maxOccurs="1"'''
		}
	}

	private static def getAttrType(SimpleType t)
	{
		switch(t)
		{
			case BOOL: '''xs:boolean'''
			case INT32: '''xs:integer'''
			case INT64: '''xs:integer'''
			case INTEGER: '''xs:integer'''
			case REAL: '''xs:double'''
			case STRING: '''xs:string'''
			// pour les Real2, Real2x2...
			default: null
		}
	}

	/** Fonction utilitaire qui devrait probablement être ailleurs... */
	static def getAllServicesImplementing(Interface interf, EObject context)
	{
		val gc = GenerationContext::Current
		val services = Utils::getAllElementsOfType(gc.scopeProvider, context, ModanePackage::eINSTANCE.service)
		val candidates = new LinkedHashSet<Service>()
		for (s : services)
		{
			val service = s as Service
			if (service.interfaces.contains(interf)) candidates.add(service)
		}
		return candidates
	}
}