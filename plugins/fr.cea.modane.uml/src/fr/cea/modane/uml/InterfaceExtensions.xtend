/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.uml

import org.eclipse.uml2.uml.Interface
import org.eclipse.uml2.uml.Profile
import org.eclipse.uml2.uml.Property

import static extension fr.cea.modane.uml.ArcaneProfileExtensions.*

class InterfaceExtensions 
{
	Profile profile
	
	new (Profile arcaneProfile)
	{
		this.profile = arcaneProfile
	}
	
	def getPties(Interface it) { ownedMembers.filter(m | m.isStereotypeApplied(profile.ptySt)).filter(x | (x as Property).upperBound != 0) }
	def getFuncs(Interface it) { ownedOperations.filter(o | o.isStereotypeApplied(profile.funcSt)) }
	def getParentInterfaces(Interface it) { parents.filter(c | c.isStereotypeApplied(profile.interfSt)) }
}