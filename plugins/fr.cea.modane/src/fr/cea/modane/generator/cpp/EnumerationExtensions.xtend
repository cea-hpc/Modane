/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.cpp

import fr.cea.modane.modane.Enumeration
import java.util.Collection
import org.eclipse.xtext.generator.IFileSystemAccess

import static extension fr.cea.modane.ModaneElementExtensions.*
import static extension fr.cea.modane.generator.cpp.ReferenceableExtensions.*

class EnumerationExtensions
{
	static def compile(Enumeration it, IFileSystemAccess fsa, Collection<String> cmakeFiles)
	{
		val context = GenerationContext::Current
		context.newFile(outputPath, referencedFileName, false, false)
		cmakeFiles += referencedFileName
		context.addContent(content)
		context.generate(fsa)
	}

	private static def getContent(Enumeration it)
	'''
		/*!
		 * \brief Classe représentant l'énumération «name»
		 * «description»
		 */
		enum class «name»
		{
		  «FOR l : literals SEPARATOR ','»
		  «l.name.toFirstUpper»«IF !l.value.nullOrEmpty» = «l.value»«ENDIF»
		  «ENDFOR»
		};
	'''
}