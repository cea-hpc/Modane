/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.cpp

import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.Module
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.Service
import java.util.ArrayList

import static extension fr.cea.modane.InterfaceExtensions.*
import static extension fr.cea.modane.ModuleExtensions.*
import static extension fr.cea.modane.ServiceExtensions.*

/**
 * Interface pour tout élément de modèle succeptibles d'implémenter
 * des méthodes (Function, OverrideFunction et EntryPoint).
 */
interface CppMethodContainer
{
	def String getShortName() 
	def boolean hasAxl()
	def String getClassNameSuffix()
	def ModaneElement getModaneElement()
	def Iterable<Pty> getAllProperties()
	def Iterable<CppMethod> getAllMethods()
	def Iterable<Interface> getInterfaces()
	def Iterable<String> getUnitTestMethodNames()
}

class ServiceCppMethodContainer implements CppMethodContainer
{
	Service s
		
	new(Service s) { this.s = s }
	
	override getShortName() { s.name }
	override hasAxl() { true }
	override getClassNameSuffix() { 'Service' }
	override getModaneElement() { s }
	override getAllProperties() { s.allProperties }
	override getInterfaces() { s.interfaces }
	
	override getAllMethods() 
	{ 
		s.functions.map[f | new FunctionCppMethod(f, shortName)] +
		s.overrideFuncs.map[f | new OverrideFunctionCppMethod(f, shortName)]
	}

	override getUnitTestMethodNames() 
	{ 
		val names = new ArrayList<String>
		s.unitTestFunctions.forEach[x | names += x.name]
		if (s.classSetUp) names += 'setUpForClass'
		if (s.testSetUp) names += 'setUp'
		if (s.classTearDown) names += 'tearDownForClass'
		if (s.testTearDown) names += 'tearDown'		 
		return names
	}
}

class ModuleCppMethodContainer implements CppMethodContainer
{
	Module m
		
	new(Module m) { this.m = m } 

	override getShortName() { m.name }
	override hasAxl() { true }
	override getClassNameSuffix() { 'Module' }
	override getModaneElement() { m }
	override getAllProperties() { m.allProperties }
	override getInterfaces() { m.interfaces }
	override getUnitTestMethodNames() { newArrayList }
	
	override getAllMethods() 
	{ 
		m.entryPoints.map[f | new EntryPointCppMethod(f, shortName)] +
		m.functions.map[f | new FunctionCppMethod(f, shortName)] +
		m.overrideFuncs.map[f | new OverrideFunctionCppMethod(f, shortName)]
	}
}

class InterfaceCppMethodContainer implements CppMethodContainer
{
	Interface i
	
	new(Interface i) { this.i = i }

	override getShortName()
	{
		i.defaultImplementationName
	}
	
	override hasAxl() { false }
	override getClassNameSuffix() { '' }
	override getModaneElement() { i }
	override getAllProperties() { i.allProperties  }
	override getInterfaces() { newArrayList(i) }
	override getUnitTestMethodNames() { newArrayList }
	
	override getAllMethods() 
	{ 
		i.allFunctions.map[f | new FunctionCppMethod(f, shortName)]
	}
}
