/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator

import com.google.common.collect.Maps
import com.google.inject.Inject
import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher.MessageType
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.generator.OutputConfiguration
import org.eclipse.xtext.util.RuntimeIOException

/**
 * Cette classe est créée pour contourner un bug de la classe JavaIoFileSystemAccess
 * qui ne tient pas compte de toute la configuration outputConfigName notamment pour
 * le boolean overrideExistingResources.
 */
class StandaloneFileSystemAccess extends JavaIoFileSystemAccess 
{
	@Inject IOutputConfigurationProvider configurationProvider
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) @Inject ModaneGeneratorMessageDispatcher messageDispatcher

	def initialize()
	{
		outputConfigurations = configurationProvider.outputConfigurations.toMap
	}

	/** 
	 * La méthode setOutputPath change le outputDirectory de la configuration DEFAULT_OUTPUT.
	 * La méthode ci-dessous est le get équivalent.
	 */
	def getOutputPath() { outputConfigurations.get(IFileSystemAccess::DEFAULT_OUTPUT).outputDirectory }

	def initialize(String absoluteOutputPath)
	{
		initialize
		outputConfigurations.values.forEach[x | x.outputDirectory = absoluteOutputPath]	
	}

	override generateFile(String fileName, String outputConfigName, CharSequence contents) throws RuntimeIOException 
	{
		val outputConfig = super.getOutputConfig(outputConfigName)
		if (outputConfig !== null)
		{
			val file = super.getFile(fileName, outputConfigName)
			// Génération sauf si le fichier existe et que overrideExistingResources vaut faux
			if (outputConfig.overrideExistingResources || !file.exists)
			{
				// Si le contenu du fichier n'a pas changé, pas de regénération
				if (file.exists && isEqual(contents, fileName))
					messageDispatcher.post(MessageType::Exec, "File contents unchanged, no overwrite: " + fileName)
				{
					messageDispatcher.post(MessageType.Exec, "Generate file: " + fileName)
					super.generateFile(fileName, outputConfigName, contents)
				}
			}
			else
				messageDispatcher.post(MessageType.Exec, "File already exists, no overwrite: " + fileName)
		}
	}

	/* Bout de code volé dans org.eclipse.xtext.generator.GeneratorComponent */
	private def toMap(Set<OutputConfiguration> configurations) 
	{
		Maps::uniqueIndex(configurations, [ OutputConfiguration from | from.name ]);
	}

	/** Can be optimized in case of big files in using a BufferedReader to read the file */
	private def boolean isEqual(CharSequence newContent, String fullFileName)
	{
		val oldContent = super.readTextFile(fullFileName)
		return (CharSequence.compare(newContent, oldContent) == 0)
	}
}