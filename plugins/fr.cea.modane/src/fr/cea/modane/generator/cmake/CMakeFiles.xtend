/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.cmake

import java.util.LinkedHashSet
import org.eclipse.xtend.lib.annotations.Data

@Data
class CMakeFiles 
{
	val cppFilesForCMake = new LinkedHashSet<String>
	val axlFilesForCMake = new LinkedHashSet<String>
	
	def isEmpty()
	{
		cppFilesForCMake.empty && axlFilesForCMake.empty
	}
}
