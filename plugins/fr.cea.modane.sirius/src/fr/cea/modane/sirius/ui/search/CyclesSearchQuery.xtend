/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.ui.search

import fr.cea.modane.cycles.DependencyGraph
import fr.cea.modane.cycles.GraphBuilder
import fr.cea.modane.ui.internal.ModaneActivator
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.core.runtime.Status
import org.eclipse.search.ui.ISearchQuery
import org.eclipse.xtend.lib.annotations.Accessors
import fr.cea.modane.modaneproject.ModaneProject

import static extension fr.cea.modane.project.PackagesContainerExtensions.*

class CyclesSearchQuery implements ISearchQuery 
{
	DependencyGraph graph
	val GraphBuilder graphBuilder	
	val CyclesSearchResult result
	@Accessors(PUBLIC_SETTER)
	ModaneProject modaneProject
	
	new()
	{
		result = new CyclesSearchResult(this)
		graphBuilder = new GraphBuilder
	}

	def getGraph() { graph }
	override canRerun() { true }
	override canRunInBackground() { true }
	override getLabel() { 'Modane - Find Cross References' }	
	override getSearchResult() { result }
	
	override run(IProgressMonitor monitor) throws OperationCanceledException 
	{
		val modaneModels = modaneProject.allModaneModels
		if (modaneModels.nullOrEmpty)
			return new Status(Status::WARNING, ModaneActivator::FR_CEA_MODANE_MODANE, "Aucun modèle modane dans ce projet", null)
			
		try
		{
			// construction du graphe et recherche des cycles
			graph = graphBuilder.createGraph(modaneModels)			
			result.cycles = graph.findSimpleCycles()
			return Status::OK_STATUS
		}
		catch (Exception e)
		{
			return new Status(Status::ERROR, ModaneActivator::FR_CEA_MODANE_MODANE, e.message, null)
		}
	}
}
