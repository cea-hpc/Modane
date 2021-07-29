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

import fr.cea.modane.modane.ItemType
import fr.cea.modane.modane.FunctionItemType

class ItemTypeExtensions 
{
	static def boolean isComponent(ItemType it) 
	{ 
		it == ItemType::MAT_CELL || 
		it == ItemType::ENV_CELL || 
		it == ItemType::COMPONENT_CELL || 
		it == ItemType::ALL_ENV_CELL
	}

	static def boolean isComponent(FunctionItemType it) 
	{ 
		it == FunctionItemType::MAT_CELL || 
		it == FunctionItemType::ENV_CELL || 
		it == FunctionItemType::COMPONENT_CELL || 
		it == FunctionItemType::ALL_ENV_CELL
	}
}

