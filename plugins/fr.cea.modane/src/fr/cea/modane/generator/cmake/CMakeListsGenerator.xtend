/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.cmake

import java.util.Collection
import org.eclipse.xtext.generator.IFileSystemAccess

class CMakeListsGenerator
{
	static val FileName = 'CMakeLists.txt'

	def generate(IFileSystemAccess fsa, String packageFullyQualifiedName, Collection<String> subPackageShortNames, CMakeFiles cMakeFiles)
	{
		fsa.generateFile(packageFullyQualifiedName.path + '/' + FileName, getContent(packageFullyQualifiedName, subPackageShortNames, cMakeFiles))
	}

	private def getContent(String packageFullyQualifiedName, Collection<String> subPackageShortNames, CMakeFiles cMakeFiles)
	'''
		#
		# Generated file - Do not overwrite
		#
		««« On ne garde que les fichiers cc (pas les h)
		«val sources = cMakeFiles.cppFilesForCMake.filter[x | x.endsWith(".cc")] + cMakeFiles.axlFilesForCMake.map[x | x + "_axl.h"]»
		«IF !sources.empty»
			add_library(«packageFullyQualifiedName.shortName»«FOR f : sources»«'\n'»  «f»«ENDFOR»«'\n'»)

			«FOR axlFile : cMakeFiles.axlFilesForCMake AFTER "\n"»
				arcane_generate_axl(«axlFile»)
			«ENDFOR»
			target_link_libraries(«packageFullyQualifiedName.shortName» PRIVATE arcane_full)
			target_include_directories(«packageFullyQualifiedName.shortName» PUBLIC ${CMAKE_SOURCE_DIR} ${CMAKE_BINARY_DIR})
		«ENDIF»

		«FOR subPackageShortName : subPackageShortNames AFTER "\n"»
			add_subdirectory(«subPackageShortName»)
		«ENDFOR»
		if (EXISTS ${CMAKE_CURRENT_SOURCE_DIR}/Project.cmake)
		include(Project.cmake)
		endif()
	'''

	def generateRoot(IFileSystemAccess fsa, String projectName, String arcaneHome, Collection<String> subPackageShortNames)
	{
		fsa.generateFile(FileName, getContent(projectName, arcaneHome, subPackageShortNames))
	}

	private def getContent(String projectName, String arcaneHome, Collection<String> subPackageShortNames)
	'''
		#
		# Generated file - Do not overwrite
		#
		cmake_minimum_required(VERSION 3.13)
		project(«projectName» LANGUAGES C CXX)

		set(Arcane_ROOT «arcaneHome»)
		include(«arcaneHome»/samples/ArcaneCompilerConfig.cmake)
		find_package(Arcane REQUIRED)

		«FOR subPackageShortName : subPackageShortNames»
		add_subdirectory(«subPackageShortName»)
		«ENDFOR»

		if (EXISTS ${CMAKE_CURRENT_SOURCE_DIR}/Project.cmake)
		include(Project.cmake)
		endif()
	'''

	private def getShortName(String fullyQualifiedName)
	{ 
		if (fullyQualifiedName.contains('.')) fullyQualifiedName.split("\\.").last
		else fullyQualifiedName
	}

	private def getPath(String fullyQualifiedName) { fullyQualifiedName.replace('.', '/') }
}