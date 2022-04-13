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

import fr.cea.modane.ui.ModaneUiUtils
import java.util.List
import org.eclipse.search.ui.ISearchResult
import org.eclipse.search.ui.ISearchResultListener
import org.eclipse.xtend.lib.annotations.Accessors

class CyclesSearchResult implements ISearchResult
{
	@Accessors List<List<String>> cycles
	val CyclesSearchQuery query

	new(CyclesSearchQuery query)
	{
		this.query = query
	}

	def getGraph() { query.graph }
	override addListener(ISearchResultListener l) { }
	override removeListener(ISearchResultListener l) { }

	override getImageDescriptor()
	{
		val id = ModaneUiUtils::getImageDescriptor('icons/modane.gif')
		if (id.present) id.get else null
	}

	override getQuery() { query }
	override getLabel() { query.label }
	override getTooltip() { label }
}
