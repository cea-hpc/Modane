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

class ModaneStringExtensions
{
	static val LowerCaseSeparator = '_'

	/**
	 * Prend une chaine utilisant les majuscules comme séparateur et retourne une chaine
	 * utilisant separator comme séparateur. La chaine retournée est en minuscules.
	 */ 
	static def separateWith(String it, String separator) 
	{ 
		if (contains('_'))
			// chaine de la forme mon_nom 
			replace('_', separator).toLowerCase
		else 
			// chaine de la forme monNom
			Character::toLowerCase(charAt(0)) + toCharArray.tail.map[c | if (Character::isUpperCase(c)) separator + Character::toLowerCase(c) else c  ].join
	}

	static def separateWithDefault(String it) { separateWith(LowerCaseSeparator) }

	/**
	 * Prend une chaine utilisant LowerCaseSeparator comme séparateur et retourne une chaine utilisant les majuscules.
	 * Ex: si separator vaut '_', my_pty_name devient MyPtyName
	 */
	static def separateWithUpperCase(String it) 
	{
		split(LowerCaseSeparator).map[t | t.toFirstUpper].join
	}

	static def startByUc(String it) { Character::isUpperCase(charAt(0)) }
	static def containsSeparator(String it) { contains(LowerCaseSeparator) }
	static def containsUC(String it) { toCharArray.exists(c | Character::isUpperCase(c)) }
}