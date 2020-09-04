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
import fr.cea.modane.Utils
import fr.cea.modane.generator.axl.AxlGenerator
import fr.cea.modane.generator.cmake.CMakeFiles
import fr.cea.modane.generator.cpp.CppGenerator
import fr.cea.modane.generator.xsd.XsdGenerator
import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.ModaneModel
import org.eclipse.emf.transaction.RecordingCommand
import org.eclipse.emf.transaction.Transaction
import org.eclipse.emf.transaction.TransactionalCommandStack
import org.eclipse.emf.transaction.util.TransactionUtil
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess2

/** Classe commune au générateur Standalone et au générateur utilisée par Xtext. */
abstract class GeneratorBase
{
	@Inject ModaneGeneratorMessageDispatcher dispatcher
	@Inject GenerationOptionsUtils goUtils
	@Inject ModelTransformer transformer
	@Inject CppGenerator cppGenerator
	@Inject AxlGenerator axlGenerator
	@Inject XsdGenerator xsdGenerator

	def getMessageDispatcher() { dispatcher }

	protected def doGenerate(ModaneModel model, IFileSystemAccess2 fsa)
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