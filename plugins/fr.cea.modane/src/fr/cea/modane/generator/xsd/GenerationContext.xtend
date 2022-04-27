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

import fr.cea.modane.modane.ModaneElement
import java.util.ArrayList
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.scoping.IScopeProvider

import static extension fr.cea.modane.ModaneElementExtensions.*

class GenerationContext
{
	public static val FileExtension = ".xsd"

	public static GenerationContext Current = null
	public val boolean langFr
	public val IScopeProvider scopeProvider

	String outputPath
	String fileNameWithoutExtension
	String content
	ArrayList<ModaneElement> imports

	new(boolean langFr, IScopeProvider scopeProvider)
	{ 
		this.langFr = langFr
		this.scopeProvider = scopeProvider
		Current = this
	}

	def newFile(String outputPath, String fileNameWithoutExtension)
	{
		this.outputPath = outputPath
		this.fileNameWithoutExtension = fileNameWithoutExtension
		this.content = ""
		this.imports = new ArrayList<ModaneElement>
	}

	def newFile(ModaneElement element)
	{
		this.outputPath = element.outputPath
		this.fileNameWithoutExtension = element.name
		this.content = ""
		this.imports = new ArrayList<ModaneElement>
	}

	def addContent(CharSequence c) { content = content.concat(c.toString) }
	def addImport(ModaneElement e) { if (!imports.contains(e)) imports += e }

	def generate(IFileSystemAccess fsa)
	{
		fsa.generateFile(fullFileName, IFileSystemAccess::DEFAULT_OUTPUT, dumpXsd)
	}

	/**
	 * Squelette du fichier .xsd 
	 */
	private def dumpXsd()
	'''
		<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" 
				xmlns="http://www.cea.fr/modane/«outputPath»"
				targetNamespace="http://www.cea.fr/modane/«outputPath»"
				«FOR i : imports SEPARATOR '\n'»xmlns:«i.nsName»="http://www.cea.fr/modane/«i.outputPath»"«ENDFOR»
				elementFormDefault = "qualified">
				
			«FOR i : imports AFTER '\n'»
			<xs:import schemaLocation="«pathToRoot»«i.fullFileName»" namespace="http://www.cea.fr/modane/«i.outputPath»"/>
			«ENDFOR»

			«content»

		</xs:schema>
	'''

	private def getFullFileName(ModaneElement e) { e.outputPath + '/' + e.name + FileExtension }
	private def getFullFileName() { outputPath + '/' + fileNameWithoutExtension + FileExtension }

	private def getPathToRoot()
	{
		val depth = outputPath.numberOfFileSeparator
		var path = ''
		for (i : 0..<depth) path += '../'
		return path
	}

	private def getNumberOfFileSeparator(String s)
	{
		if (s.contains('/')) outputPath.split('/').length
		else 0
	}
}