/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.handlers

import fr.cea.modane.modane.ModaneModel
import fr.cea.modane.ui.ModaneUiUtils
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.jface.viewers.TreeSelection
import org.eclipse.ui.handlers.HandlerUtil

class OpenTextualEditorHandler extends AbstractHandler
{
	val uiUtils = new ModaneUiUtils

	override execute(ExecutionEvent event) throws ExecutionException
	{
		val selection = HandlerUtil:: getActiveMenuSelection(event)
		if (selection !== null && selection instanceof TreeSelection)
		{
			val elt = (selection as TreeSelection).firstElement
			if (elt instanceof ModaneModel) uiUtils.openXtextEditor(elt)
		}
		return selection
	}
}