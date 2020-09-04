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

import com.google.inject.Inject
import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher.MessageType
import fr.cea.modane.modane.ModaneModel
import java.io.File

import static extension fr.cea.modane.ModaneModelExtensions.*

class GenerationOptionsUtils
{
	@Inject ModaneGeneratorMessageDispatcher messageDispatcher

	/**
	 * Retourne les options de génération associées à un chemin relatif en 
	 * recherchant tous les fichiers de configuration dans l'arborescence du chemin. 
	 * Si l'arborescence est, par exemple, a/b/c
	 * le fichier de configuration va être cherché dans a, puis dans b et enfin
	 * dans c. S'il existe plusieurs fichiers, le fichier racine est lu en premier
	 * et les options des autres fichiers sont cumulées dessus.
	 */
	def createGenerationOptionsFor(String homePath, ModaneModel model)
	{
		val options = new GenerationOptions
		fillOptions(homePath, model.outputPath, options)
		return options
	}

	private def void fillOptions(String homePath, String relativePath, GenerationOptions options)
	{
		if (relativePath.nullOrEmpty) tryToLoadOptions(homePath, options)
		else
		{
			// recherche d'un fichier de configuration dans les répertoires parents
			val lastDirIndex = relativePath.lastIndexOf('/')
			if (lastDirIndex == -1) fillOptions(homePath, null, options)
			else fillOptions(homePath, relativePath.substring(0, lastDirIndex), options) 
			// surcharge des options s'il y a un fichier local
			tryToLoadOptions(homePath + '/' + relativePath, options)
		}
	}

	private def void tryToLoadOptions(String path, GenerationOptions options)
	{
		val file = new File(path, GenerationOptions::PtyFileName)
		if (file !== null && file.exists) 
		{
			if (messageDispatcher !== null)
				messageDispatcher.post(MessageType.Exec, 'Reading property file: ' + file.path)
			options.load(file)
		}
	}
}