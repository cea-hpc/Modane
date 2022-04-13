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

import org.eclipse.uml2.uml.Element
import org.eclipse.uml2.uml.Stereotype

import static extension fr.cea.modane.ModaneStringExtensions.*

class ElementExtensions 
{
	static def getDescription(Element it)
	{
		var s = new String
		for (c : ownedComments)
			if (c.body !== null) 
				s = s.concat(c.body)
		if (s.empty) null
		else s
	}
	
	static def isUserEnabled(Element it, Stereotype st) { getValue(st, "userEnabled") as Boolean }
	
	/**
	 * On trouve de tout dans le modèle pour le namefr...
	 * On transforme en une chaine suivant la règle de nommage d'un attribut Modane : minuscule et '_' comme séparateur.
	 */
	static def getNameFr(Element it, Stereotype st) 
	{ 
		var namefr = (getValue(st, "nameFr") as String)
		if (namefr !== null)
		{
			namefr = namefr.replace(' ', '_')
			namefr = namefr.replace('-', '_')
			namefr = namefr.separateWith('_')
		}
		return namefr
	}
}