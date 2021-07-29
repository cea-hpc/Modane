/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.cycles

import java.util.LinkedList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.jgrapht.alg.cycle.TiernanSimpleCycles
import org.jgrapht.graph.DefaultDirectedGraph
import org.jgrapht.graph.DefaultEdge

class JGraphTDependencyGraph implements DependencyGraph
{
	val graph = new DefaultDirectedGraph<String, JGraphTDependencyEdge>(JGraphTDependencyEdge)
	
	override setPackages(List<String> packages) 
	{
		packages.forEach[ p | graph.addVertex(p) ]
	}
	
	override addDependencyInfo(DependencyInfo info) 
	{
		val sourceNode = info.sourcePackage
		val targetNode = info.targetPackage
		val e = graph.getEdge(sourceNode, targetNode) ?: graph.addEdge(sourceNode, targetNode)
		e.dependencies.add(info)
	}
	
	override getDependencyInfos(String sourcePackage, String targetPackage) 
	{
		val edge = tiernan.graph.getEdge(sourcePackage, targetPackage)
		if (edge === null) null
		else edge.dependencies
	}

	/**
	 * JGraphT ne répète pas le premier noeud du cycle en fin de liste.
	 * Par exemple, un cycle A >> B >> A est représenté par A >> B.
	 * Il faut ajouter le premier noeud en fin de liste pour être conforme à l'interface
	 */	
 	override findSimpleCycles() 
	{ 
		val cycles = tiernan.findSimpleCycles
		
		val newCycles = new LinkedList<List<String>>
		for (c : cycles)
		{
			val newC = new LinkedList<String>
			newC.addAll(c)
			newC.add(c.head)
			newCycles.add(newC)
		}
		return newCycles
	}
	
	private def getTiernan() { new TiernanSimpleCycles<String, JGraphTDependencyEdge>(graph) }
//	private def getJohnson() { new JohnsonSimpleCycles<String, JGraphTDependencyEdge>(graph) }
//	private def getSzwarcfiterLauer() { new SzwarcfiterLauerSimpleCycles<String, JGraphTDependencyEdge>(graph) }
//	private def getTarjan() { new TarjanSimpleCycles<String, JGraphTDependencyEdge>(graph) }
}

class JGraphTDependencyEdge extends DefaultEdge
{
	@Accessors val dependencies = new LinkedList<DependencyInfo>

 	override toString() 
	{ 
		val ret = new StringBuilder
		ret.append(source)
		ret.append(DependencyGraph::Separator)
		ret.append(target)
		ret.append('  (' + dependencies.size)
		if (dependencies.size > 1)  ret.append(' dépendances)')
		else ret.append(' dépendance)')
		return ret.toString 		
	}	
}
