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

import fr.cea.modane.modane.EntryPoint
import fr.cea.modane.modane.Module

class EntryPointExtensions 
{
	def static getModule(EntryPoint it)
	{
		eContainer as Module
	}
}