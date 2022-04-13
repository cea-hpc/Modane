/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane

import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.generator.OutputConfiguration
import org.eclipse.xtext.generator.IFileSystemAccess

class ModaneOutputConfigurationProvider implements IOutputConfigurationProvider 
{
	public static val GEN_ONCE_OUTPUT = "gen-once"
	
	override getOutputConfigurations() 
	{
		val defaultOutput = new OutputConfiguration(IFileSystemAccess::DEFAULT_OUTPUT)
		defaultOutput.description = 'Fichiers entièrement générés (à écraser)'
		defaultOutput.outputDirectory = 'src'
		defaultOutput.setDerivedProperty = true
		defaultOutput.cleanUpDerivedResources = false
		defaultOutput.overrideExistingResources = true
		defaultOutput.createOutputDirectory = true

		val readOnlyOutput = new OutputConfiguration(GEN_ONCE_OUTPUT)
		readOnlyOutput.description = 'Fichiers développeurs (ne pas écraser)'
		readOnlyOutput.outputDirectory = 'src'
		readOnlyOutput.setDerivedProperty = false
		readOnlyOutput.cleanUpDerivedResources = false
		readOnlyOutput.overrideExistingResources = false
		readOnlyOutput.createOutputDirectory = true
		
		newHashSet(defaultOutput, readOnlyOutput)
	}
}