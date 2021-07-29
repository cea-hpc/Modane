/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator

import com.google.inject.Inject
import fr.cea.modane.ModaneStandaloneSetupGenerated
import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher.MessageType
import fr.cea.modane.generator.cmake.CMakeFiles
import fr.cea.modane.generator.cmake.CMakeListsGenerator
import fr.cea.modane.modane.ModaneModel
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors

class StandaloneGenerator extends GeneratorBase
{
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) @Inject StandaloneFileSystemAccess fsa
	@Inject ResourceSet resourceSet
	@Inject CMakeListsGenerator cMakeGenerator

	// utilisé par les tests
	def static createInstance()
	{
		val injector = new ModaneStandaloneSetupGenerated().createInjectorAndDoEMFRegistration
		injector.getInstance(StandaloneGenerator)
	} 

	/** Génération depuis des fichiers '.modane' pour les tests unitaires */
	def generate(URI modaneFileURI, String absoluteOutputDir, String packageToGenerate)
	{
		val r = resourceSet.getResource(modaneFileURI, true)
		generate(#[r], absoluteOutputDir, packageToGenerate, false)
	}

	/** 
	 * Génération depuis des fichiers '.uml' 
	 * Dans le cas d'un fichier uml, les ressources sont créées mais ne persistent pas.
	 */
	def generate(List<Resource> modaneResources, String absoluteOutputPath, String packageToGenerate, boolean generateCMakeLists)
	{
		// Positionnement du répertoire de sortie du générateur fourni en paramètre		
		fsa.initialize(absoluteOutputPath)

		// Validation des fichiers et génération C++ et AXL
		// On ne peut pas valider en mode standalone pour des histoires de scope provider
		val models = modaneResources.models
		val cMakeFilesByModel = new HashMap<ModaneModel, CMakeFiles>
		for (model : models) 
		{
			// on ne génère que les éléments dans le package demandé ou ses sous-packages
			if (packageToGenerate.nullOrEmpty || model.name.startsWith(packageToGenerate)) 
			{
				val cmakeFiles = doGenerate(model, fsa)
				cMakeFilesByModel.put(model, cmakeFiles)
				//if (generateCMakeLists) cMakeGenerator.generate(fsa, model.name, model.getSubModelsNames(models), cmakeFiles)			
			}
			else
				messageDispatcher.post(MessageType.Start, "Package to generate: " + packageToGenerate + " => nothing to do for " + model.name)
		}

		if (generateCMakeLists)
		{
			for (model : cMakeFilesByModel.keySet) 
			{
				val subModelNames = model.getSubModelsNames(models)
				val cmakeFiles = cMakeFilesByModel.get(model)
				if (!subModelNames.empty || !cmakeFiles.empty)
					cMakeGenerator.generate(fsa, model.name, subModelNames, cmakeFiles)
			}
		}
	}

	def generate(ModaneModel model)
	{ 
		doGenerate(model, fsa)
	}

	private def getModels(List<Resource> resources)
	{
		val models = new ArrayList<ModaneModel>
		resources.forEach[models += contents.filter(ModaneModel)]
		return models
	}

	private def getSubModelsNames(ModaneModel parentModel, List<ModaneModel> models)
	{
		val subModelNames = new ArrayList<String>
		for (m : models)
		{
			if (m !== parentModel && m.name.startsWith(parentModel.name))
			{
				val subName = m.name.replaceFirst(parentModel.name + '.', "")
				if (!subName.contains('.')) subModelNames += subName 
			}
		}
		return subModelNames
	}
}