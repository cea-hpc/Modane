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
import fr.cea.modane.ui.ModaneUiUtils
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.viewers.OwnerDrawLabelProvider
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.graphics.Rectangle
import org.eclipse.swt.widgets.Event

import static extension fr.cea.modane.EObjectExtensions.*

/**
 * Classe de base des labels providers utiles pour afficher icone + label.
 * Les images font au maximum 16 x 16 mais peuvent faire moins.
 * On aimerait qu'elles se placent au milieu d'un carré de 20x20
 */
abstract class CyclesSearchResultLabelProvider extends OwnerDrawLabelProvider
{
	public static int SIZE = 24

	override protected measure(Event event, Object element) 
	{
		event.bounds = new Rectangle(event.x, event.y, 250, SIZE)
	}

	def protected paintIconAndLabel(Event event, EObject o)
	{
		val image =getImage(o)
		event.gc.drawImage(image, event.bounds.x + image.getXShift, event.bounds.y + image.getYShift)
		event.gc.drawString(o.fullName, event.bounds.x + SIZE, event.bounds.y + image.getYShift, true)
	}

	def protected paintLabel(Event event, String s)
	{
		event.gc.drawString(s, event.bounds.x, event.bounds.y + 3, true)
	}

	def protected getXShift(Image i) { (SIZE - i.bounds.width) / 2 }
	def protected getYShift(Image i) { (SIZE - i.bounds.height) / 2 }

	private def getImage(EObject o) { ModaneUiUtils::getImage(o) }
}

class CyclesSearchResultSourceLabelProvider extends CyclesSearchResultLabelProvider
{
	override protected paint(Event event, Object element)
	{
		if (element instanceof DependencyInfo) paintIconAndLabel(event, element.sourceElement)
		else paintLabel(event, element.text)
	}

	private def getText(Object o)
	{
		switch(o)
		{
			// Cycle
			List<String> :  o.join(DependencyGraph::Separator)
			// Segment
			EdgeResultInfo :
			{
				var t = o.startNode + DependencyGraph::Separator + o.endNode
				t = t + '  (' + o.infos.size + ' dépendance'
				if (o.infos.size > 1) t = t + 's'
				t + ')'
			}
		}
	}
}

class CyclesSearchResultTargetLabelProvider extends CyclesSearchResultLabelProvider
{
	override protected paint(Event event, Object element)
	{
		if (element instanceof DependencyInfo) paintIconAndLabel(event, element.targetElement)
		// else rien a afficher
	}
}
