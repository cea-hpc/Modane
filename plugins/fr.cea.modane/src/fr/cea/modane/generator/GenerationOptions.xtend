/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator

import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.util.Properties

/** 
 * Le répertoire de génération peut être null par défaut.
 * Dans ce cas, c'est celui du ModaneOutputConfigurationProvider qui sera utilisé.
 */
class GenerationOptions
{
	public static val PtyFileName = 'modane.properties'
	public static val FileTitle = 'Options de génération Modane'

	static val ParallelLoopsPty = 'parallelLoops'
	static val AlwaysMaterialManagerPty = 'alwaysMaterialMng'
	static val VariableAsArgsPty = 'variableAsArgs'
	static val DefaultServicePty = 'defaultService'
	static val TraceMsgPty = 'traceMsg'
	static val GenerateXsdPty = 'generateXsd'
	static val LangFrPty = 'langFr'
	static val MajorCodeVersionPty = 'majorCodeVersion'
	static val MinorCodeVersionPty = 'minorCodeVersion'

	val pties = new Properties

	def getParallelLoops() { Boolean.parseBoolean(pties.getProperty(ParallelLoopsPty, 'true')) }
	def getAlwaysMaterialMng() { Boolean.parseBoolean(pties.getProperty(AlwaysMaterialManagerPty, 'false')) }
	def getVariableAsArgs() { Boolean.parseBoolean(pties.getProperty(VariableAsArgsPty, 'true')) }
	def getDefaultService() { Boolean.parseBoolean(pties.getProperty(DefaultServicePty, 'true')) }
	def getTraceMsg() { Boolean.parseBoolean(pties.getProperty(TraceMsgPty, 'false')) }
	def getGenerateXsd() { Boolean.parseBoolean(pties.getProperty(GenerateXsdPty, 'false')) }
	def getLangFr() { Boolean.parseBoolean(pties.getProperty(LangFrPty, 'false')) }
	def getMajorCodeVersion() { Integer.parseInt(pties.getProperty(MajorCodeVersionPty, '1')) }
	def getMinorCodeVersion() { Integer.parseInt(pties.getProperty(MinorCodeVersionPty, '0')) }

	def setParallelLoops(boolean value) { pties.setProperty(ParallelLoopsPty, value.toString) }
	def setAlwaysMaterialMng(boolean value) { pties.setProperty(AlwaysMaterialManagerPty, value.toString) }
	def setVariableAsArgs(boolean value) { pties.setProperty(VariableAsArgsPty, value.toString) }
	def setDefaultService(boolean value) { pties.setProperty(DefaultServicePty, value.toString) }
	def setTraceMsg(boolean value) { pties.setProperty(TraceMsgPty, value.toString) }
	def setGenerateXsd(boolean value) { pties.setProperty(GenerateXsdPty, value.toString) }
	def setLangFr(boolean value) { pties.setProperty(LangFrPty, value.toString) }
	def setMajorCodeVersion(int value) { pties.setProperty(MajorCodeVersionPty, value.toString) }
	def setMinorCodeVersion(int value) { pties.setProperty(MinorCodeVersionPty, value.toString) }

	def load(File file) { pties.load(new FileReader(file)) }
	def load(String fileName) { pties.load(new FileReader(fileName)) }
	def save(String fileName) { pties.store(new FileWriter(fileName), FileTitle) }
}