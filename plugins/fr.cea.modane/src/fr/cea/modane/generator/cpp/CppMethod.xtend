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

import fr.cea.modane.modane.Arg
import fr.cea.modane.modane.ArgDefinition
import fr.cea.modane.modane.ArgMultiplicity
import fr.cea.modane.modane.EntryPoint
import fr.cea.modane.modane.Function
import fr.cea.modane.modane.FunctionItemType
import fr.cea.modane.modane.OverrideFunction
import fr.cea.modane.modane.PtyOrArgType
import fr.cea.modane.modane.VarDefinition

interface CppMethod 
{
	def String getName()
	def String getDescription()
	def String getContainerName()
	def Iterable<? extends CppVariable> getAllVars()
	def Iterable<ArgDefinition> getArgDefinitions()
	def Iterable<? extends Arg> getAllArgs()
	def Iterable<Function> getCalls()
	def PtyOrArgType getReturnType()
	def boolean isMultiple()
	def FunctionItemType getSupport()
	def boolean isSequential()
	def boolean isConst()
	def boolean isOverride()
}

class FunctionCppMethod implements CppMethod
{
	Function f
	String containerName
	
	new(Function f, String containerName) 
	{ 
		this.f = f
		this.containerName = containerName
	}
	
	override getName() { f.name }
	override getDescription() { f.description }
	override getContainerName() { containerName }
	override getArgDefinitions() { f.args.filter(ArgDefinition) }
	override getAllArgs() { f.args }
	override getCalls() { f.calls }
	override getReturnType() { f.type }
	override isMultiple() { f.multiplicity == ArgMultiplicity::ARRAY }
	override getSupport() { f.support }
	override isSequential() { f.sequential }
	override isConst() { f.const }
	override isOverride() { false }	
	
	override getAllVars() 
	{ 
		f.vars.map[v | new CppVarReference(v)] +
		f.args.filter(VarDefinition).map[v | new CppVarDefinition(v)]
	}
}

class OverrideFunctionCppMethod extends FunctionCppMethod
{
	OverrideFunction of
	
	new(OverrideFunction of, String containerName) 
	{ 
		super(of.func, containerName)
		this.of = of
	}
	
	override getDescription() { of.description }
	override getCalls() { of.calls }
	override isOverride() { true }	
	
	override getAllVars() 
	{ 
		of.vars.map[v | new CppVarReference(v)] + 
		of.func.vars.map[v | new CppVarReference(v)] +
		of.func.args.filter(VarDefinition).map[v | new CppVarDefinition(v)]
	}
}

class EntryPointCppMethod implements CppMethod
{
	EntryPoint ep
	String containerName
	
	new(EntryPoint ep, String containerName) 
	{ 
		this.ep = ep
		this.containerName = containerName
	}

	override getName() { ep.name }
	override getDescription() { ep.description }
	override getContainerName() { containerName }	
	override getAllArgs() { newArrayList }
	override getArgDefinitions() { newArrayList }
	override getCalls() { ep.calls }
	override getReturnType() { null }	
	override isMultiple() { false }
	override getSupport() { ep.support }
	override isSequential() { true }
	override isConst() { false }
	override isOverride() { false }	
	
	override getAllVars() { ep.vars.map[v | new CppVarReference(v)] }
}