/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.cpp

import com.google.inject.Inject
import fr.cea.modane.generator.GenerationOptions
import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher
import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher.MessageType
import fr.cea.modane.modane.Enumeration
import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.Module
import fr.cea.modane.modane.Service
import fr.cea.modane.modane.Struct
import java.util.Collection
import org.eclipse.xtext.generator.IFileSystemAccess

import static extension fr.cea.modane.generator.cpp.CppMethodContainerExtensions.*
import static extension fr.cea.modane.generator.cpp.EnumerationExtensions.*
import static extension fr.cea.modane.generator.cpp.InterfaceExtensions.*
import static extension fr.cea.modane.generator.cpp.StructExtensions.*

class CppGenerator
{
	@Inject ModaneGeneratorMessageDispatcher dispatcher

	def setGenerationOptions(GenerationOptions options)
	{
		new GenerationContext(options, dispatcher)
	}

	def generateFiles(ModaneElement elt, IFileSystemAccess fsa, Collection<String> cmakeFiles)
	{
		dispatcher.post(MessageType.Exec, "    C++ generation for: " + elt.name )
		switch elt
		{
			Module : new ModuleCppMethodContainer(elt).compile(fsa, cmakeFiles)
			Service : new ServiceCppMethodContainer(elt).compile(fsa, cmakeFiles)
			Struct : elt.compile(fsa, cmakeFiles)
			Enumeration : elt.compile(fsa, cmakeFiles)
			Interface : elt.compile(fsa, cmakeFiles)
		}
	}
}