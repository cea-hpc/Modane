/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.xsd

import fr.cea.modane.modane.ModaneElement

import static extension fr.cea.modane.ModaneElementExtensions.*

class ModaneElementExtensions 
{
	static def getXsdTypeName(ModaneElement it) { name }
	static def getXsdTypeNameWithNs(ModaneElement it) { nsName + ':' + xsdTypeName }
}