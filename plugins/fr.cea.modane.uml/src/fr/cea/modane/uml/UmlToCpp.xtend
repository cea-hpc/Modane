/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.uml

import com.google.inject.Inject
import fr.cea.modane.ModaneStandaloneSetupGenerated
import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher.MessageType
import fr.cea.modane.generator.StandaloneGenerator
import org.eclipse.emf.common.util.URI
import org.eclipse.uml2.uml.Model

/**
 * Cette classe est utilisée par les tests unitaires et l'IHM.
 * Les tests génèrent le C++ à partir d'un nom de fichier.
 * L'IHM a besoin de décomposer les étapes pour initialiser une boite de dialogue. 
 */
class UmlToCpp
{
	@Inject StandaloneGenerator generator
	@Inject UmlToModane umlToModane

	def static createInstance()
	{
		val injector = new ModaneStandaloneSetupGenerated().createInjectorAndDoEMFRegistration
		injector.getInstance(UmlToCpp)
	}

	def readModel(URI umlFileURI)
	{
		UmlUtils::readUmlModel(umlFileURI)
	}

	def getMessageDispatcher()
	{
		generator.messageDispatcher
	}

	def generate(Model umlModel, String absoluteOutputPath, String packagePrefix, String packageToGenerate, boolean generateCMakeLists, boolean writeModaneFiles)
	{
		val startTime = System.currentTimeMillis

		messageDispatcher.post(MessageType.Exec, "Starting UML to Modane model transformation")
		val resources = umlToModane.createModaneModelsResources(umlModel, absoluteOutputPath, packagePrefix, writeModaneFiles)
		val afterConvertionTime = System.currentTimeMillis
		messageDispatcher.post(MessageType.Exec, "UML to Modane model transformation ended in " + (afterConvertionTime-startTime)/1000.0 + "s")

		messageDispatcher.post(MessageType.Exec, "Starting code generation")
		generator.generate(resources, absoluteOutputPath, packageToGenerate, generateCMakeLists)
		val afterGenerationTime = System.currentTimeMillis
		messageDispatcher.post(MessageType.Exec, "Code generation ended in " + (afterGenerationTime-afterConvertionTime)/1000.0 + "s")

		messageDispatcher.post(MessageType.Exec, "Total time: " + (afterGenerationTime-startTime)/1000.0 + "s");
	}
}