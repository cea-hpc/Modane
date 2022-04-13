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

import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.Module
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.Variable
import java.util.LinkedHashSet

import static extension fr.cea.modane.InterfaceExtensions.*

class ModuleExtensions
{
	static def LinkedHashSet<Pty> getAllProperties(Module it)
	{
		var allProperties = new LinkedHashSet<Pty>
		for (i : interfaces) allProperties += i.allProperties
		allProperties.addAll(properties)
		return allProperties
	}

	static def LinkedHashSet<Interface> getAllInterfaces(Module it)
	{
		var allInterfaces = new LinkedHashSet<Interface>
		for (i : interfaces) allInterfaces.addAll(i.allInterfaces)
		allInterfaces.addAll(interfaces)
		return allInterfaces
	}

	static def getAllVariables(Module it)
	{
		val usedVariables = new LinkedHashSet<Variable>
		for (ep : entryPoints) 
			for (vref : ep.vars)
				usedVariables.add(vref.variable)
		for (f : functions)
			for (vref : f.vars)
				usedVariables.add(vref.variable)
		return usedVariables
	}
}