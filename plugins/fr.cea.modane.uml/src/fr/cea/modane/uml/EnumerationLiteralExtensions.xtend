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

import org.eclipse.uml2.uml.EnumerationLiteral
import org.eclipse.uml2.uml.Profile

import static extension fr.cea.modane.uml.ArcaneProfileExtensions.*

class EnumerationLiteralExtensions 
{
	Profile profile
	
	new (Profile arcaneProfile)
	{
		this.profile = arcaneProfile
	}

	def getValue(EnumerationLiteral it) 
	{ 
		val value = getValue(profile.enumLiteralSt, "value")
		if (value === null || (value as String).nullOrEmpty) ''
		else value as String
	}
}