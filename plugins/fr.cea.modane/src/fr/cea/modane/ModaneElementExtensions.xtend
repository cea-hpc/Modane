/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane

import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.Legacy
import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.ModaneModel
import fr.cea.modane.modane.Module
import fr.cea.modane.modane.Service
import fr.cea.modane.modane.Struct

import static extension fr.cea.modane.InterfaceExtensions.*
import static extension fr.cea.modane.ModaneModelExtensions.*
import static extension fr.cea.modane.ModuleExtensions.*
import static extension fr.cea.modane.ServiceExtensions.*
import static extension fr.cea.modane.StructExtensions.*

class ModaneElementExtensions 
{
	static def dispatch getNsName(ModaneElement it) { model.nsName }
	static def dispatch getNsName(Legacy it) { originNamespace }
	
	static def getOutputPath(ModaneElement it) { model.outputPath }
	static def areEquals(ModaneElement a, ModaneElement b) { areEquals(a.model, b.model) && a.name == b.name }
	static def getModel(ModaneElement it) { eContainer as ModaneModel }
	
	static def getProps(ModaneElement it)
	{
		switch it
		{
			Service : allProperties
			Struct : allProperties
			Interface : allProperties
			Module : allProperties
			default : null
		}
	}
}