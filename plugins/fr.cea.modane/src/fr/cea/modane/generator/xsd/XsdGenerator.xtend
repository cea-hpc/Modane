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

import com.google.inject.Inject
import fr.cea.modane.Utils
import fr.cea.modane.modane.Enumeration
import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.ModanePackage
import fr.cea.modane.modane.Module
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.Service
import fr.cea.modane.modane.Struct
import java.util.Collection
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.scoping.IScopeProvider

import static extension fr.cea.modane.ModuleExtensions.*
import static extension fr.cea.modane.ServiceExtensions.*
import static extension fr.cea.modane.StructExtensions.*
import static extension fr.cea.modane.generator.xsd.ModaneElementExtensions.*
import static extension fr.cea.modane.generator.xsd.PtyExtensions.*
import static extension fr.cea.modane.generator.xsd.XsdUtils.*

class XsdGenerator
{
	@Inject IScopeProvider scopeProvider

	def setLangFr(boolean langFr)
	{
		new GenerationContext(langFr,scopeProvider)
	}

	def generateFiles(ModaneElement elt, IFileSystemAccess fsa)
	{
		val context = GenerationContext::Current
		context.newFile(elt)
		val content = elt.fileContent
		if (content !== null)
		{
			context.addContent(content)
			context.generate(fsa)
		}

		/* 
		 * Génération d'un fichier contenant l'ensemble des modules en attendant de faire la boucle en temps.
		 * A chaque fois qu'un nouveau module est créé, il faut refaire le fichier.
		 * Le problème est qu'il est difficile de savoir quand un module est créé avec le Build incrémental.
		 * Pour l'instant, on génère le fichier à chaque fois... pas terrible mais normalement temporaire...
		 */
		context.newFile('', 'global')
		val objects = Utils::getAllElementsOfType(scopeProvider, elt, ModanePackage::eINSTANCE.module)
		val modules = objects.map[ m | m as Module]
		modules.forEach[m | context.addImport(m)]
		context.addContent(modules.globalFileContent)
		context.generate(fsa)
	}

	private def dispatch getFileContent(Module it) { getContent(allProperties) }
	private def dispatch getFileContent(Service it) { getContent(allProperties) }
	private def dispatch getFileContent(Struct it) { getContent(allProperties) }

	private def dispatch getFileContent(Enumeration it)
	'''
		<xs:simpleType name="«xsdTypeName»">
			<xs:restriction base="xs:string">
				«FOR l : literals SEPARATOR '\n'»<xs:enumeration value="«l.xsdName»"/>«ENDFOR»
			</xs:restriction>
		</xs:simpleType>
	'''

	/** 
	 * Pas de déclaration des propriétés de l'interface car pas d'utilisation de l'héritage.
	 * Le service déclare toutes les propriétés des interfaces qu'il implémente plutôt que
	 * d'en hériter, pour des raisons de simplicité (équivalent)
	 */
	private def dispatch getFileContent(Interface it)
	'''
		<xs:complexType name="«xsdTypeName»" abstract="true">
			<xs:attribute name="name">
				<xs:simpleType>
					<xs:restriction base="xs:string">
						«FOR s : getAllServicesImplementing(it, it.eContainer) SEPARATOR '\n'»<xs:enumeration value="«s.name»"/>«ENDFOR»
					</xs:restriction>
				</xs:simpleType>
			</xs:attribute>
		</xs:complexType>
	'''

	/** Tous les autres types d'éléments... */
	private def dispatch getFileContent(ModaneElement it) { null }

	private def getContent(ModaneElement container, Collection<Pty> properties)
	'''
		<xs:complexType name="«container.xsdTypeName»">
			<xs:sequence>
				«FOR pty : properties»«pty.content»«ENDFOR»
			</xs:sequence>
		</xs:complexType>
	'''
}
