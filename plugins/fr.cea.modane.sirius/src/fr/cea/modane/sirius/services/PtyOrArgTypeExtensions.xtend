/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.services

import fr.cea.modane.modane.Item
import fr.cea.modane.modane.ItemGroup
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.Reference
import fr.cea.modane.modane.Simple

class PtyOrArgTypeExtensions 
{
	
	static def getTargetType(Pty it) { if (type === null) null else type.realType }
	
	static def dispatch getRealType(Simple it) { type }
	static def dispatch getRealType(Item it) { type }
	static def dispatch getRealType(ItemGroup it) { type }
	static def dispatch getRealType(Reference it) { target }

	static def dispatch getName(Simple it) { type.literal }
	static def dispatch getName(Item it) { type }
	static def dispatch getName(ItemGroup it) { type }
	static def dispatch getName(Reference it) 
	{ 
		if (target === null) '' 
		else if (target.name === null) 'Orphan'
		else target.name
	}
}