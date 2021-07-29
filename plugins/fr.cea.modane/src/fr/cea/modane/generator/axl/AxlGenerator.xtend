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
import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher
import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher.MessageType
import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.Module
import fr.cea.modane.modane.Service
import java.io.StringReader
import java.io.StringWriter
import java.util.Collection
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource
import org.eclipse.xtext.generator.IFileSystemAccess

import static extension fr.cea.modane.ModaneElementExtensions.*

class AxlGenerator
{
	public static val FileExtension = ".axl"

	@Inject ModaneGeneratorMessageDispatcher messageDispatcher
	@Inject extension ModuleExtensions
	@Inject extension ServiceExtensions

	def generateFiles(ModaneElement elt, IFileSystemAccess fsa, Collection<String> cmakeFiles)
	{
		if (elt.fileContent !== null)
		{
			val fileName = elt.outputPath + '/' + elt.name + FileExtension
			cmakeFiles += elt.name
			val content = elt.fileContent.toString.beautifyXml
			messageDispatcher.post(MessageType.Exec, "Generate file: " + fileName)
			fsa.generateFile(fileName, content)
		}
	}

	private def dispatch getFileContent(Module elt) { elt.content }
	private def dispatch getFileContent(Service elt) { elt.content }
	private def dispatch getFileContent(ModaneElement elt) { null }

	private def beautifyXml(String content)
	{
		// premiere transformation avec la feuille XSL (voir constante
		// ci-dessous) pour virer les espaces
		val transformer = TransformerFactory::newInstance.newTransformer(new StreamSource(new StringReader(XslStripSpace)))
		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8")
		val source1 = new StreamSource(new StringReader(content.toString))
		val result1 = new StreamResult(new StringWriter)
		transformer.transform(source1, result1)

		// deuxieme transformation pour indenter
		val indenter = TransformerFactory::newInstance.newTransformer
		indenter.setOutputProperty(OutputKeys.INDENT, "yes")
		indenter.setOutputProperty(OutputKeys.ENCODING, "utf-8")
		indenter.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2")
		val source2 = new StreamSource(new StringReader(result1.writer.toString))
		val result2 = new StreamResult(new StringWriter)
		indenter.transform(source2, result2)

		return result2.writer.toString
	}

	final static String XslStripSpace = #["<xsl:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>"
			, "<xsl:output method='xml' omit-xml-declaration='no'/>" , "<xsl:strip-space elements='*'/>"
			, "<xsl:template match='@*|node()'>" , "<xsl:copy>" , "<xsl:apply-templates select='@*|node()'/>" , "</xsl:copy>"
			, "</xsl:template>" , "</xsl:stylesheet>"].join
}