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
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.Service
import fr.cea.modane.modane.Variable
import java.util.LinkedHashSet

import static extension fr.cea.modane.InterfaceExtensions.*

class ServiceExtensions
{
	static def LinkedHashSet<Pty> getAllProperties(Service it)
	{
		val allProperties = new LinkedHashSet<Pty>
		for (i : interfaces) allProperties += i.allProperties
		allProperties.addAll(properties)
		return allProperties
	}

	static def LinkedHashSet<Interface> getAllInterfaces(Service it)
	{
		val allInterfaces = new LinkedHashSet<Interface>
		for (i : interfaces) allInterfaces.addAll(i.allInterfaces)
		allInterfaces.addAll(interfaces)
		return allInterfaces
	}

	static def LinkedHashSet<Interface> getParentInterfaces(Service it)
	{
		val parentInterfaces = new LinkedHashSet<Interface>
		for (i : interfaces) parentInterfaces.addAll(i.allInterfaces)
		return parentInterfaces
	}

	static def getAllVariables(Service it)
	{
		val usedVariables = new LinkedHashSet<Variable>
		for (f : overrideFuncs) 
			for (vref : f.vars)
				usedVariables.add(vref.variable)
		for (f : functions)
			for (vref : f.vars)
				usedVariables.add(vref.variable)
		return usedVariables
	}
}