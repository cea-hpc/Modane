/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.ui.dialogs

import java.io.FileReader
import java.io.FileWriter
import java.io.InputStream
import java.io.OutputStream
import java.util.Properties

class GenerateTitleDialogOptions
{
	public static val FileTitle = 'Options de la boite de dialogue de génération Modane'

	static val OutputDirPty = 'outputDir'
	static val PackagePrefixPty = 'packagePrefix'
	static val PackageToGeneratePty = 'packageToGenerate'
	static val WriteModaneFilesPty = 'writeModaneFiles'
	static val WriteCMakeFilesPty = 'writeCMakeFiles'

	val pties = new Properties

	def hasOutputDir() { !outputDir.nullOrEmpty }
	def hasPackagePrefix() { !packagePrefix.nullOrEmpty }
	def generateAllPackages() { packageToGenerate.nullOrEmpty }

	def getOutputDir() { pties.getProperty(OutputDirPty, 'src') }
	def getPackagePrefix() { pties.getProperty(PackagePrefixPty, '') }
	def getPackageToGenerate() { pties.getProperty(PackageToGeneratePty, '') }
	def isWriteModaneFiles()  { Boolean.parseBoolean(pties.getProperty(WriteModaneFilesPty, 'false')) }
	def isWriteCmakeFiles()  { Boolean.parseBoolean(pties.getProperty(WriteCMakeFilesPty, 'false')) }

	def setOutputDir(String value) { pties.setProperty(OutputDirPty, value) }
	def setPackagePrefix(String value) { pties.setProperty(PackagePrefixPty, value) }
	def setPackageToGenerate(String value) { pties.setProperty(PackageToGeneratePty, value) }
	def setWriteModaneFiles(boolean value) { pties.setProperty(WriteModaneFilesPty, value.toString) }
	def setWriteCMakeFiles(boolean value) { pties.setProperty(WriteCMakeFilesPty, value.toString) }

	def load(InputStream stream) { pties.load(stream) }
	def load(String fileName) { pties.load(new FileReader(fileName)) }
	def save(OutputStream stream) { pties.store(stream, FileTitle) }
	def save(String fileName) { pties.store(new FileWriter(fileName), FileTitle) }
}