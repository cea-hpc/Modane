/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.xsd

import fr.cea.modane.modane.Module

import static extension fr.cea.modane.ModaneStringExtensions.*
import static extension fr.cea.modane.generator.xsd.ModaneElementExtensions.*

class XsdUtils 
{
	static def getXsdName(String name, String frName)
	{
		if (GenerationContext::Current.langFr && !frName.nullOrEmpty) frName.separateWith('-')
		else name.separateWith('-')
	}
	
	static def getGlobalFileContent(Iterable<Module> modules)
	'''
		«arcaneContent»
		
		«arcanePostProcessingContent»
		
		«meshContent»

		<xs:element name="«caseName»" type="CaseType"/>
		
		<!-- DEBUT DES TYPES DU BLOC CASE -->

		<xs:complexType name="CaseType">
			<xs:all>
				<xs:element name="arcane" type="ArcaneType"/>
				<xs:element name="arcane-post-processing" type="ArcanePostProcessingType"/>
				<xs:element name="«meshName»" type="MeshType"/>
				«FOR m : modules SEPARATOR '\n'»«m.globalFileContent»«ENDFOR»
			</xs:all>
			<xs:attribute name="codename" type="xs:string"/>
			<xs:attribute name="codeversion" type="xs:string"/>
			<xs:attribute name="xml:lang" type="LangType"/>			
		</xs:complexType>
		
		<xs:simpleType name="LangType">
			<xs:restriction base="xs:string">
				<xs:enumeration value="fr"/>
				<xs:enumeration value="en"/>
			</xs:restriction>
		</xs:simpleType>
		
		<!-- FIN DES TYPES DU BLOC CASE -->
	'''
	
	private static def getArcaneContent()
	'''
		<!-- DEBUT DES TYPES DU BLOC ARCANE -->

		<xs:complexType name="ArcaneType">
			<xs:sequence>
				<xs:element name="«titleName»" type="xs:string"/>
				<xs:element name="«timeLoopName»" type="xs:string"/>
				<xs:element name="modules" type="ModulesType"/>
				<xs:element name="configuration" type="ConfigurationType"/>
			</xs:sequence>
		</xs:complexType>

		<xs:complexType name="ModulesType">
			<xs:sequence>
				<xs:element name="module" type="ModuleType" minOccurs="0" maxOccurs="unbounded"/>
			</xs:sequence>
		</xs:complexType>

		<xs:complexType name="ModuleType">
			<xs:attribute name="name" type="xs:string"/>
			<xs:attribute name="active" type="xs:boolean"/>
		</xs:complexType>

		<xs:complexType name="ConfigurationType">
			<xs:sequence>
				<xs:element name="«parameterName»" type="ParameterType" minOccurs="0" maxOccurs="unbounded"/>
			</xs:sequence>
		</xs:complexType>

		<xs:complexType name="ParameterType">
			<xs:attribute name="name" type="xs:string"/>
			<xs:attribute name="value" type="xs:string"/>
		</xs:complexType>

		<!-- FIN DES TYPES DU BLOC ARCANE -->
	'''
	
	private static def getMeshContent()
	'''
		<!-- DEBUT DES TYPES DU BLOC MESH -->
		
		<xs:complexType name="MeshType">
			<xs:sequence>
				<xs:element name="fichier" type="xs:string" minOccurs="1" maxOccurs="1"/>
			</xs:sequence>
			<xs:attribute name="internal-partition" type="xs:boolean"/>
			<xs:attribute name="format" type="xs:string"/>
		</xs:complexType>
		
		<!-- FIN DES TYPES DU BLOC MESH -->
	'''
	
	/** 
	 * Petite bidouille temporaire pour A3. 
	 * Ne preprésente pas l'AXL du module PostProcessing au complet.
	 */
	private static def getArcanePostProcessingContent()
	'''
		<!-- DEBUT DES TYPES DU BLOC ARCANE POST PROCESSING -->
		
		<xs:complexType name="ArcanePostProcessingType">
			<xs:sequence>
				<xs:element name="output-history-period" type="xs:integer" minOccurs="1" maxOccurs="1"/>
			</xs:sequence>
		</xs:complexType>
		
		<!-- FIN DES TYPES DU BLOC ARCANE POST PROCESSING -->
	'''
	
		
		
	
	private static def getCaseName() { if (GenerationContext::Current.langFr) "cas" else "case" }
	private static def getMeshName() { if (GenerationContext::Current.langFr) "maillage" else "mesh" }
	private static def getTitleName() { if (GenerationContext::Current.langFr) "titre" else "title" }
	private static def getTimeLoopName() { if (GenerationContext::Current.langFr) "boucle-en-temps" else "timeloop" }
	private static def getParameterName() { if (GenerationContext::Current.langFr) "parametre" else "parameter" }

	private static def getGlobalFileContent(Module it)
	'''
		<xs:element name="«xsdName»" type="«xsdTypeNameWithNs»"/>
	'''
	
	private static def getXsdName(Module m) { getXsdName(m.name, m.namefr) }
}