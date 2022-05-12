/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.cpp

import fr.cea.modane.modane.Enumeration
import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.Legacy
import fr.cea.modane.modane.Referenceable
import fr.cea.modane.modane.Struct

import static extension fr.cea.modane.ModaneElementExtensions.*

class ReferenceableExtensions
{
	static def getReferencedTypeName(Referenceable it)
	{
		switch it
		{
			// Enumeration are referenced by value
			Enumeration: getReferencedNameWithNs(it, true)
			// Interface are referenced by pointer but CaseOption inherits from them
			Interface: getReferencedNameWithNs(it, false) + '*'
			Legacy: getReferencedNameWithNs(it) + '*'
			default: getReferencedNameWithNs(it, false) + '*'
		}
	}

	static def dispatch getReferencedNameWithNs(Referenceable it)
	{
		getReferencedNameWithNs(it, true)
	}

	static def dispatch getReferencedNameWithNs(Legacy it)
	{
		val context = GenerationContext::Current
		if (!originFile.nullOrEmpty)
		{
			if (context.name.endsWith(GenerationContext::HeaderExtension))
			{
				if (forceInclude)
					context.addInclude(originFile)
				else
					context.addClassDeclaration(originNamespace, referencedName, originFile)
			}
		}

		if (originNamespace.nullOrEmpty) referencedName
		else '::' + originNamespace + '::' + referencedName
	}

	static def dispatch getReferencedName(Struct it) { 'I' + name }
	static def dispatch getReferencedName(Interface it) { 'I' + name }
	static def dispatch getReferencedName(Referenceable it) { name }

	static def dispatch getReferencedFileName(Legacy it) { originFile }
	static def dispatch getReferencedFileName(Referenceable it) 
	{
		#[GenerationContext::GenFilePrefix, referencedName, GenerationContext::HeaderExtension].join
	}

	private static def getReferencedNameWithNs(Referenceable it, boolean forceInclude)
	{
		val context = GenerationContext::Current
		if (forceInclude)
			context.addInclude(outputPath, referencedFileName)
		else if (context.name.endsWith(GenerationContext::HeaderExtension))
			context.addClassDeclaration(nsName, referencedName, outputPath + "/" + referencedFileName)

		if (nsName != context.nsName && !context.isAUsedNs(nsName))
			'::' + nsName + '::' + referencedName
		else
			referencedName
	}
}