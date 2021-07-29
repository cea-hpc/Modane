/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.cpp

import fr.cea.modane.modane.ArgDefinition
import fr.cea.modane.modane.ArgMultiplicity
import fr.cea.modane.modane.Direction
import fr.cea.modane.modane.Item
import fr.cea.modane.modane.PtyOrArgType

import static extension fr.cea.modane.generator.cpp.PtyOrArgTypeExtensions.*

class ArgDefinitionExtensions 
{
	/**
	 * Retourne le type de l'argument.
	 * +---------------+------+----------------------------+-------------------+
	 * | Type          | Card | In                         | Out               |
	 * +---------------+------+----------------------------+-------------------+
	 * | Simple ou     | 1    | const Real                 | Real&             |
	 * | Enumeration   |      |                            |                   |
	 * | ex: Real      | *    | ConstArrayView<Real>       | Array<Real>&      |
	 * +---------------+------+----------------------------+-------------------+
	 * | Item          | 1    | const Cell                 | Cell&             |
	 * | ex: Cell      | *    | CellVectorView             | CellVector&       |
	 * +---------------+------+----------------------------+-------------------+
	 * | ItemGroup     | 1    | const CellGroup            | CellGroup&        |
	 * | ex: CellGroup | *    | ConstArrayView<CellGroup>  | Array<CellGroup>& |
	 * +---------------+------+----------------------------+-------------------+
	 * | Classe        | 1    | const A*                   | A*                |
	 * | ex: A         | *    | ConstArrayView<A*>         | Array<A*>&        |
	 * +---------------+------+----------------------------+-------------------+
	 */	 
	static def getTypeName(ArgDefinition it) 
	{
		switch (it)
		{
			case direction == Direction::IN && multiplicity == ArgMultiplicity::SCALAR : type.inUniqueTypeName		
			case direction == Direction::IN && multiplicity == ArgMultiplicity::ARRAY : type.inMultipleTypeName
			case direction != Direction::IN && multiplicity == ArgMultiplicity::SCALAR : type.outUniqueTypeName
			case direction != Direction::IN && multiplicity == ArgMultiplicity::ARRAY : type.outMultipleTypeName
		}
	} 
	
	private static def getInUniqueTypeName(PtyOrArgType type) 
	{ 
		'const ' + type.typeName 
	}
	
	private static def getInMultipleTypeName(PtyOrArgType type) 
	{
		if (type instanceof Item)  type.typeName + 'VectorView'
		else 'ConstArrayView< ' + type.typeName + ' >'
	}
	
	private static def getOutUniqueTypeName(PtyOrArgType type) 
	{ 
		if (type.typeName.endsWith('*')) type.typeName
		else type.typeName + '&'
	}
	
	private static def getOutMultipleTypeName(PtyOrArgType type) 
	{
		if (type instanceof Item)  type.typeName + 'Vector&'
		else 'Array< ' + type.typeName + ' >&'
	}
	
	static def getFieldName(ArgDefinition it) { 'm_' + name }
}