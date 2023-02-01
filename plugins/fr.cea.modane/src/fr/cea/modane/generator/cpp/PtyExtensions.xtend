/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.cpp

import fr.cea.modane.modane.Item
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.PtyMultiplicity

import static extension fr.cea.modane.ModaneStringExtensions.*
import static extension fr.cea.modane.generator.cpp.PtyOrArgTypeExtensions.*

class PtyExtensions extends fr.cea.modane.PtyExtensions 
{
	/**
	 * Retourne le type de l'argument pour un setter.
	 * +---------------+------+-------------------+
	 * | Simple        | 1    | Real              |
	 * | ex: Real      | *    | Array<Real>&      |
	 * +---------------+------+-------------------+
	 * | Item          | 1    | Cell              |
	 * | ex: Cell      | *    | CellVector        |
	 * +---------------+------+-------------------+
	 * | ItemGroup     | 1    | CellGroup         |
	 * | ex: CellGroup | *    | Array<CellGroup>& |
	 * +---------------+------+-------------------+
	 * | Classe        | 1    | A*                |
	 * | ex: A         | *    | Array<A*>&        |
	 * +---------------+------+-------------------+
	 */
	private static def getSetterTypeName(Pty it) 
	{ 
		if (multiple)
		{
			if (type instanceof Item) type.typeName + 'Vector'
			else 'Array< ' +  type.typeName + ' >&'
		}
		else
		{
			type.typeName	
		}
	}
	
	/**
	 * Retourne le type de l'argument pour un getter.
	 * Attention : cette méthode doit être compatible avec les retour du CaseOption
	 * +---------------+------+---------------------------+
	 * | Simple        | 1    | Real                      |
	 * | ex: Real      | *    | ConstArrayView<Real>      |
	 * +---------------+------+---------------------------+
	 * | Item          | 1    | Cell                      |
	 * | ex: Cell      | *    | CellVector                |
	 * +---------------+------+---------------------------+
	 * | ItemGroup     | 1    | CellGroup                 |
	 * | ex: CellGroup | *    | ConstArrayView<CellGroup> |
	 * +---------------+------+---------------------------+
	 * | Classe        | 1    | A*                        |
	 * | ex: A         | *    | ConstArrayView<A*>        |
	 * +---------------+------+---------------------------+
	 */
	private static def getReturnTypeName(Pty it)
	{
		if (multiple)
		{
			if (type instanceof Item) type.typeName + 'Vector'
			else 'ConstArrayView< ' +  type.typeName + ' >'
		}
		else
		{
			type.typeName	
		}
	}

	/**
	 * Retourne le type d'un attribut de classe.
	 * +---------------+------+------------------------+
	 * | Simple        | 1    | Real                   |
	 * | ex: Real      | *    | UniqueArray<Real>      |
	 * +---------------+------+------------------------+
	 * | Item          | 1    | Cell                   |
	 * | ex: Cell      | *    | CellVector             |
	 * +---------------+------+------------------------+
	 * | ItemGroup     | 1    | CellGroup              |
	 * | ex: CellGroup | *    | UniqueArray<CellGroup> |
	 * +---------------+------+------------------------+
	 * | Classe        | 1    | A*                     |
	 * | ex: A         | *    | UniqueArray<A*>        |
	 * +---------------+------+------------------------+
	 */
	static def getAttrTypeName(Pty it) 
	{ 
		if (multiple)
		{
			if (type instanceof Item) type.typeName + 'Vector'
			else 'UniqueArray< ' +  type.typeName + ' >'
		}
		else
		{
			type.typeName	
		}
	}

	static def getAbstractGetterContent(Pty it)
	'''
		«IF description !== null »/*! «description» */«ENDIF»
		virtual «returnTypeName» «getterName»() = 0;
	'''

	static def getAbstractHasAccessorContent(Pty it)
	'''
		virtual bool «hasName»() const = 0;
	'''
	
	/** 
	 * Attention pour la compatibilité avec les méthodes du CaseOption,
	 * le getter ne doit pas être 'const'.
	 */
	static def getGetterContent(Pty it, CharSequence body, boolean withOverride)
	'''
		«returnTypeName» «getterName»() «IF(withOverride)»override «ENDIF»{ «body» }
	'''

	static def getSetterContent(Pty it, CharSequence body)
	'''
		void «setterName»(«setterTypeName» value) { «body» }
	'''

	static def getHasAccessorContent(Pty it, CharSequence body, boolean withOverride)
	'''
		bool «hasName»() const «IF(withOverride)»override «ENDIF»{ «body» }
	'''

	static def getFieldName(Pty it) { 'm_' + name }
	static def getGetterName(Pty it) { 'get' + name.separateWithUpperCase }
	static def getSetterName(Pty it) { 'set' + name.separateWithUpperCase }
	static def getHasName(Pty it) { 'has' + name.separateWithUpperCase }
	static def needHasAccessor(Pty it) { multiplicity == PtyMultiplicity::ZERO_ONE }
	
	static def getInitValue(Pty it)
	{
		if (attrTypeName.endsWith('*')) 0
		else attrTypeName + '()'
	}
}