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

import com.google.inject.Inject
import fr.cea.modane.ModaneStandaloneSetupGenerated
import fr.cea.modane.Utils
import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher.MessageType
import fr.cea.modane.generator.axl.AxlGenerator
import fr.cea.modane.generator.cmake.CMakeFiles
import fr.cea.modane.generator.cmake.CMakeListsGenerator
import fr.cea.modane.generator.cpp.CppGenerator
import fr.cea.modane.generator.xsd.XsdGenerator
import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.ModaneModel
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.transaction.RecordingCommand
import org.eclipse.emf.transaction.Transaction
import org.eclipse.emf.transaction.TransactionalCommandStack
import org.eclipse.emf.transaction.util.TransactionUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess2

class StandaloneGenerator
{
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) @Inject StandaloneFileSystemAccess fsa
	@Inject ResourceSet resourceSet
	@Inject GenerationOptionsUtils goUtils
	@Inject ModelTransformer transformer
	@Inject CppGenerator cppGenerator
	@Inject AxlGenerator axlGenerator
	@Inject XsdGenerator xsdGenerator
	@Inject CMakeListsGenerator cMakeGenerator

	// Utilisé par les tests
	def static createInstance()
	{
		val injector = new ModaneStandaloneSetupGenerated().createInjectorAndDoEMFRegistration
		injector.getInstance(StandaloneGenerator)
	}

	def getMessageDispatcher()
	{
		fsa.messageDispatcher
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

	private def doGenerate(ModaneModel model, IFileSystemAccess2 fsa)
	{
		val cmakeFiles = new CMakeFiles

		val optionsPath = Utils::getAbsolutePath(fsa.getURI('.'))
		val options = goUtils.createGenerationOptionsFor(optionsPath, model)

		cppGenerator.generationOptions = options
		xsdGenerator.langFr = options.langFr

		val domain = TransactionUtil::getEditingDomain(model)
		var RecordingCommand cmd = null
		var TransactionalCommandStack stack = null

		if (options.defaultService)
		{
			if (domain === null)
			{
				transformer.insertDefaultService(model)
				transformer.insertDefaultValueForPties(model)
			}
			else
			{
				stack = domain.commandStack as TransactionalCommandStack
				cmd = new RecordingCommand(domain)
				{
					override doExecute()
					{
						transformer.insertDefaultService(model)
						transformer.insertDefaultValueForPties(model)
					}
				}
				stack.execute(cmd, #{Transaction.OPTION_NO_NOTIFICATIONS -> Boolean::TRUE, Transaction.OPTION_NO_TRIGGERS -> Boolean::TRUE})
			}
		}

		for (elt : model.elements) doGenerate(elt, fsa, options, cmakeFiles)

		if (domain !== null && cmd !== null && stack.undoCommand === cmd) stack.undo()
		return cmakeFiles
	}

	private def doGenerate(ModaneElement elt, IFileSystemAccess fsa, GenerationOptions options, CMakeFiles cmakeFiles)
	{
		axlGenerator.generateFiles(elt, fsa, cmakeFiles.axlFilesForCMake)
		cppGenerator.generateFiles(elt, fsa, cmakeFiles.cppFilesForCMake)
		if (options.generateXsd) xsdGenerator.generateFiles(elt,fsa)
	}
}