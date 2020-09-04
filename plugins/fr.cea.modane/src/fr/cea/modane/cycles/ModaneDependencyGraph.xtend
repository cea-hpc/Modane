/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.cycles

import java.util.HashMap
import java.util.LinkedList
import java.util.List
import org.eclipse.xtend.lib.annotations.Data

/**
 * Implémentation simple de l'interface DependencyGraph.
 * La recherche de cycles n'est pas optimale.
 */
class ModaneDependencyGraph implements DependencyGraph
{
	val nodesByName = new HashMap<String, Node>
	
	def getNodes() { nodesByName.values }
	def getNode(String nodeName) { nodesByName.get(nodeName) }
	def getDim() { nodesByName.size }
	
	override toString()
	{
		val ret = new StringBuilder
		ret.append("Liste des arcs : \n")
		for(n : nodes)
			for (a : n.outArcs)
				ret.append(a.toString + '\n   ' + a.infos.join('\n   ') + '\n\n')
		return ret.toString
	}
	
	override setPackages(List<String> packages) 
	{
		packages.forEach[p | nodesByName.put(p, new Node(p))]
	}
	
	override addDependencyInfo(DependencyInfo info) 
	{
		val sourceNode = info.sourcePackage.node
		val targetNode = info.targetPackage.node
		sourceNode.addArc(info, targetNode)
	}
	
	override getDependencyInfos(String sourcePackage, String targetPackage) 
	{
		val sourceNode = sourcePackage.node
		if (sourceNode !== null)
		{
			val arc = sourceNode.outArcs.findFirst[a | a.endNode.name == targetPackage]
			if (arc !== null) return arc.infos
		}
		return null
	}
	
	/**
	 * Recherche les cycles dans un graphe.
	 * Ne retourne pas forcément la totalité des cycles car un cycle
	 * peut en masquer un autre. Mais, comme l'objectif est de supprimer
	 * les cycles, à terme ils seront tous trouvés.
	 */	
 	override findSimpleCycles() 
	{
		val cycles = new LinkedList<List<Node>>
		
		for (node : nodes)
		{
			val cycle = prof(node, node, new HashMap<Node, Boolean>)
			if (cycle !== null && !cycles.exists[c | areSameCycles(c, cycle)]) cycles += cycle
		}

		return cycles.map[ cycle | cycle.map[ node | node.name ]]
	}
	
	/** marks est le tableau des sommets marqués comme parcourus */
	private def List<Node> prof(Node startNode, Node currentNode, HashMap<Node, Boolean> marks)
	{
		marks.put(currentNode, true)

		// première rencontre de currentNode
		for (arc : currentNode.outArcs)
		{
			if (startNode == arc.endNode) 
			{
				// cycle détecté
				return newArrayList(currentNode, startNode)
			}

			if (!marks.isMarked(arc.endNode)) 
			{
				val cycle = prof(startNode, arc.endNode, marks)
				if (cycle !== null) 
				{
					// Un cycle a été rencontré, s en fait partie
					cycle.add(0, currentNode)
					return cycle
				}
			} 
		}
		
		// Pas de cycle détecté
		return null
	}
	
	private def isMarked(HashMap<Node, Boolean> marks, Node node)
	{
		marks.get(node) ?: false
	}
	
	/** Regarde si les cycles sont identiques par permutation circulaire */
	private def areSameCycles(List<Node> c1, List<Node> c2)
	{
		if (c1.size != c2.size) return false
		
		var targetIndex = c2.indexOf(c1.head) 
		if (targetIndex == -1) return false
		
		// recherche de la permutation
		var index = 0		
		while (index < c1.size-1)
		{
			index = index + 1
			targetIndex = (targetIndex + 1) % c1.size 
			if (!c1.get(index).equals(c2.get(targetIndex))) return false
		}
		
		// cycle2 est une permutation circulaire de cycle 1
		return true
	}
}

class Node
{
	val String name
	val outArcs = new LinkedList<Arc>
	
	new(String name) { this.name = name }
	def getName() { name } 
	def getOutArcs() { outArcs }
	
	def addArc(DependencyInfo info, Node endNode)
	{
		var arc = outArcs.findFirst[a | a.endNode == endNode]
		if (arc === null)
		{
			arc = new Arc(this, endNode)
			outArcs.add(arc)
		}
		arc.infos.add(info)
	}
	
 	override toString() { name }
 	
	override equals(Object obj)
	{
		if (!(obj instanceof Node)) return false
		return ((obj as Node).name == name)
	}
}

@Data
class Arc
{
 	val Node startNode
 	val Node endNode
	val infos = new LinkedList<DependencyInfo>

 	override toString() 
	{ 
		val ret = new StringBuilder
		ret.append(startNode)
		ret.append(ModaneDependencyGraph::Separator)
		ret.append(endNode)
		ret.append('  (' + infos.size)
		if (infos.size > 1)  ret.append(' dépendances)')
		else ret.append(' dépendance)')
		return ret.toString 		
	}
 	
	override equals(Object obj)
	{
		if (!(obj instanceof Arc)) return false
		
		val target = obj as Arc
		return (startNode.equals(target.startNode) && endNode.equals(target.endNode))
	}
}
