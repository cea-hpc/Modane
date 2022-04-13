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
		if (it instanceof Enumeration)
			referencedNameWithNs
		else
			referencedNameWithNs + '*'
	}
 
 	static def dispatch getReferencedNameWithNs(Referenceable it)
 	{
		val context = GenerationContext::Current
		if (context.name.endsWith(GenerationContext::HeaderExtension)) context.addInclude(outputPath, referencedFileName)
		if (nsName != context.nsName && !context.isAUsedNs(nsName))
			'::' + nsName + '::' + referencedName
		else
			referencedName	
 	}
 	
 	static def dispatch getReferencedNameWithNs(Legacy it)
 	{
		val context = GenerationContext::Current
		if (context.name.endsWith(GenerationContext::HeaderExtension) && !originFile.nullOrEmpty)
		{
			context.addCcInclude(originFile)
			context.addClassDeclaration(originNamespace, referencedName)
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
}