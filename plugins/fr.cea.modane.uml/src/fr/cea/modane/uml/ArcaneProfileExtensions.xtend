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

import org.eclipse.uml2.uml.Profile

class ArcaneProfileExtensions 
{
	static def getVariableSt(Profile it) { ownedStereotypes.findFirst(s | s.name == "Variable") }
	static def getStructSt(Profile it) { ownedStereotypes.findFirst(s | s.name == "Struct") }
	static def getEnumSt(Profile it) { ownedStereotypes.findFirst(s | s.name == "Enum") }
	static def getEnumLiteralSt(Profile it) { ownedStereotypes.findFirst(s | s.name == "EnumLiteral") }
	static def getPtySt(Profile it) { ownedStereotypes.findFirst(s | s.name == "Pty") }
	static def getInterfSt(Profile it) { ownedStereotypes.findFirst(s | s.name == "Interf") }
	static def getFuncSt(Profile it) { ownedStereotypes.findFirst(s | s.name == "Func") }
	static def getEntryPointSt(Profile it) { ownedStereotypes.findFirst(s | s.name == "EntryPoint") }
	static def getModuleSt(Profile it) { ownedStereotypes.findFirst(s | s.name == "Module") }
	static def getServiceSt(Profile it) { ownedStereotypes.findFirst(s | s.name == "Service") }
	static def getLegacySt(Profile it) { ownedStereotypes.findFirst(s | s.name == "Legacy") }	
	static def getItemFamilySt(Profile it) { ownedStereotypes.findFirst(s | s.name == "ItemFamily") }		
}