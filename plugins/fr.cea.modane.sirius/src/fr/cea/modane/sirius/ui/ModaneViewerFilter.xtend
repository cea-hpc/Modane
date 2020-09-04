/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.ui

import fr.cea.modane.modane.ModaneModel
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.jface.viewers.Viewer
import org.eclipse.jface.viewers.ViewerFilter
import org.eclipse.sirius.ui.tools.api.views.common.item.ItemWrapper

class ModaneViewerFilter extends ViewerFilter
{
	override boolean select(Viewer viewer, Object parentElement, Object element)
	{
		//println('type de element : ' + element.class.name + ' - ' + element.toString + ' - ' + (element instanceof ItemWrapper))
		if (element instanceof ItemWrapper)
		{
			val wrappedObject = element.wrappedObject
			//println('type de wrapped object : ' + wrappedObject.toString)
			
			// Evite de déplier les fichiers .aird
			// ViewpointSpec introuvable dans les nouvelles versions de Sirius
			//if (wrappedObject instanceof ViewpointSpec) return false
			
			// Evite de déplier les fichiers .modane
			if (wrappedObject instanceof ModaneModel) return false
		}

		if (element instanceof IFile)
			return !element.name.contains('.aird')

		if (element instanceof IFolder)
			return !element.name.equals("models")

		return true
	}
}
