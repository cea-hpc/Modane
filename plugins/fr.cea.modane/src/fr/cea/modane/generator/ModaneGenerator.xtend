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

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.generator.IGeneratorContext

/**
 * Generates code from your model files on save.
 * see http://www.eclipse.org/Xtext/documentation.html#TutorialCodeGeneration
 */
class ModaneGenerator extends GeneratorBase implements IGenerator2
{
	/** 
	 * API IGenerator : appelé depuis Xtext par la compilation incrémentale 
	 * Les URI des resources sont de type Platform car tout se passe dans Eclipse  
	 */
	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) 
	{
		//doGenerate(input, fsa, '')
	}

	override afterGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
	}

	override beforeGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
	}
}

