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
import fr.cea.modane.Utils
import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher
import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher.MessageType
import java.io.StringReader
import javax.xml.parsers.SAXParserFactory
import org.xml.sax.InputSource

class DescriptionUtils
{
	@Inject ModaneGeneratorMessageDispatcher messageDispatcher

	def formatDescription(String comment)
	{
		if (!comment.isNullOrEmpty)
		{
			val c = comment
			if (c.validXml) '''<description>«c»</description>'''
			else '''<description><![CDATA[«c»]]></description>'''
		}
	}

	def isValidXml(String comment)
	{
		var valid = false
		val c = '<c>' + comment + '</c>'
		try
		{
			val spf = SAXParserFactory.newInstance()
			val sp = spf.newSAXParser()
			val reader = sp.getXMLReader()
			reader.setErrorHandler(null)
			reader.setContentHandler(null)
			reader.setEntityResolver(null)
			reader.setDTDHandler(null)
			reader.parse(new InputSource(new StringReader(c)))
			valid = true
		}
		catch (Exception e)
		{
			messageDispatcher.post(MessageType.Warning, 'Invalid XML comment in [CDATA[: ' + comment + '\n')
			messageDispatcher.post(MessageType.Warning, e.message)
			messageDispatcher.post(MessageType.Warning, Utils::getStackTrace(e))
			valid = false
		}
		return valid
	}
}