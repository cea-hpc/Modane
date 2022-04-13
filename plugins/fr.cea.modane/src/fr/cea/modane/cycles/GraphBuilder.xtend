/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.cycles

import fr.cea.modane.modane.ArgDefinition
import fr.cea.modane.modane.EntryPoint
import fr.cea.modane.modane.Enumeration
import fr.cea.modane.modane.Function
import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.ItemFamily
import fr.cea.modane.modane.Legacy
import fr.cea.modane.modane.ModaneModel
import fr.cea.modane.modane.ModanePackage
import fr.cea.modane.modane.Module
import fr.cea.modane.modane.OverrideFunction
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.Reference
import fr.cea.modane.modane.Service
import fr.cea.modane.modane.ServiceOrModule
import fr.cea.modane.modane.Struct
import fr.cea.modane.modane.VarReference
import fr.cea.modane.modane.Variable
import java.util.LinkedHashSet
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference

import static fr.cea.modane.ModaneModelExtensions.*

import static extension fr.cea.modane.EObjectExtensions.*
import static extension fr.cea.modane.ModaneElementExtensions.*

/** Permet de construire un graphe à partir d'une liste de modèles */
class GraphBuilder
{
	val static pack = ModanePackage::eINSTANCE
	DependencyGraph graph

	/**
	 * Le constructeur fonctionne en 3 étapes.
	 * 
	 * La premiere etape consiste a construire la liste des packages :
	 * - 1 map pour retrouver le package a partir de son index
	 * - 1 map pour retrouver l'index a partir du nom de package
	 * 
	 * La deuxieme etape construit la matrice des connexions (arcs). 
	 * 
	 * La troisieme etape remplit les informations des arcs avec les 
	 * connexions existantes.
	 */
	def createGraph(Iterable<ModaneModel> models)
	{
		graph = new JGraphTDependencyGraph

		// Construction de la liste des packages
		val packages = new LinkedHashSet<String>
		for (m : models)
			for (e : m.elements)
				packages.add(e.model.name)

		// Allocation du graph
		graph.packages = packages.toList

		// Création des arcs avec les informations de dépendance sur le modèle
		for (m : models)
			for (e : m.elements)
				e.findArcs

		return graph
	}

	private def dispatch findArcs(Variable e) {}
	private def dispatch findArcs(Legacy e) {}
	private def dispatch findArcs(Enumeration e) {}
	private def dispatch findArcs(ItemFamily e) {}

	private def dispatch findArcs(Module it)
	{
		it.findArcsForServiceOrModule
		entryPoints.forEach[x | x.checkDependency]
	}

	private def dispatch findArcs(Service it)
	{
		it.findArcsForServiceOrModule
	}

	private def findArcsForServiceOrModule(ServiceOrModule it)
	{
		for (i : 0..<interfaces.size)
			checkDependency(it, interfaces.get(i), pack.serviceOrModule_Interfaces, i)

		properties.forEach[x | x.checkDependency]
		functions.forEach[x | x.checkDependency]
		overrideFuncs.forEach[x | x.checkDependency]
	}

	private def dispatch findArcs(Struct it)
	{
		for (i : 0..<parents.size)
			checkDependency(it, parents.get(i), pack.struct_Parents, i)

		properties.forEach[x | x.checkDependency]
	}

	private def dispatch findArcs(Interface it)
	{
		for (i : 0..<parents.size)
			checkDependency(it, parents.get(i), pack.interface_Parents, i)

		properties.forEach[x | x.checkDependency]
		functions.forEach[x | x.checkDependency]
	}

	private def checkDependency(EObject source, EObject target, EReference reference, int index)
	{
		if (!areEquals(source.modaneParent.model, target.modaneParent.model))
			graph.addDependencyInfo(new DependencyInfo(source, target, reference, index))
	}

	private def checkDependency(Pty it)
	{
		if (type instanceof Reference)
			checkDependency(it, (type as Reference).target, pack.reference_Target, -1)
	}

	private def checkDependency(ArgDefinition it)
	{
		if (type instanceof Reference)
			checkDependency(it, (type as Reference).target, pack.reference_Target, -1)
	}

	private def checkDependency(VarReference it)
	{
		checkDependency(it, variable, pack.varReference_Variable, -1)
	}

	private def checkDependency(Function it)
	{
		// type de retour
		if (type instanceof Reference)
			checkDependency(it, (type as Reference).target, pack.reference_Target, -1)

		vars.forEach[v | v.checkDependency]
		args.filter(ArgDefinition).forEach[a | a.checkDependency]

		// calls
		for (i : 0..<calls.size)
			checkDependency(it, calls.get(i), pack.function_Calls, i)
	}

	private def checkDependency(OverrideFunction it)
	{
		vars.forEach[v | v.checkDependency]

		// calls
		for (i : 0..<calls.size)
			checkDependency(it, calls.get(i), pack.overrideFunction_Calls, i)
	}

	private def checkDependency(EntryPoint it)
	{
		vars.forEach[v | v.checkDependency]

		// calls
		for (i : 0..<calls.size)
			checkDependency(it, calls.get(i), pack.entryPoint_Calls, i)
	}
}
