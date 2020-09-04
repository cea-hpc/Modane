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

import fr.cea.modane.modane.Item
import fr.cea.modane.modane.ItemGroup
import fr.cea.modane.modane.Reference
import fr.cea.modane.modane.Simple

import static extension fr.cea.modane.generator.cpp.ItemGroupTypeExtensions.*
import static extension fr.cea.modane.generator.cpp.ItemTypeExtensions.*
import static extension fr.cea.modane.generator.cpp.ReferenceableExtensions.*

class PtyOrArgTypeExtensions 
{
	static def dispatch getTypeName(Reference it)	{ if (target === null) '' else target.referencedTypeName }
	static def dispatch getTypeName(Simple it)		{ type.literal }
	static def dispatch getTypeName(Item it)   		{ type.literal }
	static def dispatch getTypeName(ItemGroup it)	{ type.literal }

	static def dispatch isComponent(Reference it)	{ false }
	static def dispatch isComponent(Simple it)		{ false }
	static def dispatch isComponent(Item it)   		{ type.component }
	static def dispatch isComponent(ItemGroup it)	{ type.component }
}