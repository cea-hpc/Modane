/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.ui.search

import fr.cea.modane.cycles.DependencyGraph
import fr.cea.modane.cycles.DependencyInfo
import java.util.LinkedList
import java.util.List
import org.eclipse.jface.viewers.ArrayContentProvider
import org.eclipse.jface.viewers.ITreeContentProvider
import org.eclipse.xtend.lib.annotations.Data

@Data 
class CyclesSearchResultContentProvider extends ArrayContentProvider implements ITreeContentProvider
{
	val DependencyGraph graph
	
	override getChildren(Object parentElement) 
	{
		// Attention : on ne peut pas faire un switch sur le type de la liste.
		// Java ne fait pas la différence entre List<X> et List<Y>
		switch(parentElement)
		{
			List<?> case parentElement.size > 0 : 
			{
				val listElt = parentElement.head
				
				switch(listElt)
				{
					// Liste de cycles : les children sont les éléments de la liste
					List<?> : return parentElement
					
					// Cycle : à partir du cycle, il faut construire une liste de segments.
					// On va représenter un segment par une Pair<String, String>.
					String case parentElement.size > 1 : 
					{
						val segments = new LinkedList<EdgeResultInfo>
						for (i : 1..<parentElement.size)
						{
							val startNode = parentElement.get(i-1) as String
							val targetNode = parentElement.get(i) as String
							val dependencies = graph.getDependencyInfos(startNode, targetNode)
							segments.add(new EdgeResultInfo(startNode, targetNode, dependencies))
						}	
						return segments
					}
					
					// Dépendances : les children sont les éléments de la liste
					DependencyInfo : return parentElement
				}
			}
					
			// Segment : les children sont la liste des dépendances du segment
			EdgeResultInfo : return parentElement.infos
			
			default : return null
		}
	}
	
	override getParent(Object element) { null }
	
	override hasChildren(Object element) 
	{
		switch(element)
		{
			List<?> : true
			EdgeResultInfo : true
			default : false
		}
	}
}

@Data
package class EdgeResultInfo 
{
	val String startNode
	val String endNode
	val List<DependencyInfo> infos
}

