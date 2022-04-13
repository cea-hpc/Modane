/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.uml

import java.util.ArrayList
import java.util.List
import org.eclipse.uml2.uml.Model
import org.eclipse.uml2.uml.Package

class PackageExtensions 
{	
	String packagePrefix
	
	new (String packagePrefix)
	{
		this.packagePrefix = packagePrefix
	}

	def String getFullName(Package it)
	{
		if (packagePrefix.nullOrEmpty) fullNameWithoutPrefix
		else packagePrefix + '.' + fullNameWithoutPrefix
	}
	
	private def static String getFullNameWithoutPrefix(Package it)
	{
		if (it === null || it instanceof Model) ''
		else if (owner !== null && owner instanceof Package && !(owner instanceof Model))
			(owner as Package).getFullNameWithoutPrefix + '.' + name
		else name
	}
	
	/**
	 * Liste de tous les noms de packages sans prefixe de nom
	 */
	def static List<String> getAllPackageNames(Package it)
	{
		val names = new ArrayList<String>
		if (!getFullNameWithoutPrefix.empty) names += getFullNameWithoutPrefix
		for (p : ownedElements.filter(x | x instanceof Package && x.appliedStereotypes.empty))
			names.addAll((p as Package).allPackageNames)
		return names
	}
}