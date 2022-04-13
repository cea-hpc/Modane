/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.services

import fr.cea.modane.modane.ModaneElement
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.sirius.business.api.dialect.DialectManager
import org.eclipse.sirius.business.api.session.SessionManager
import org.eclipse.sirius.diagram.DSemanticDiagram
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager
import org.eclipse.sirius.viewpoint.DRepresentation
import org.eclipse.sirius.viewpoint.DView
import org.eclipse.xtext.EcoreUtil2

import static fr.cea.modane.sirius.services.DAnnotationUtils.*

import static extension fr.cea.modane.sirius.services.DAnnotationUtils.getOrCreateAnnotation

class SemanticDiagramExtensions
{
	static def DRepresentation getDiagramNavigation(DSemanticDiagram it, ModaneElement elt)
	{
		val _name = elt.name
		val annotation = getDAnnotation(DANNOTATION_DIAGRAM_NAVIGATION_SOURCE)
		if (annotation !== null && annotation.details.containsKey(_name)) 
			return getDiagramFromName(annotation.details.get(_name))
		else
			return null
	}

	static def setDiagramNavigation(DSemanticDiagram it, ModaneElement elt, DSemanticDiagram navigationTarget)
	{
		val _name = elt.name
		val annotation = getOrCreateAnnotation(DANNOTATION_DIAGRAM_NAVIGATION_SOURCE)
		annotation.details.put(_name, navigationTarget.name)
	}

	private static def DRepresentation getDiagramFromName(DSemanticDiagram it, String diagramName)
	{
		val r = EcoreUtil2::getContainerOfType(it, DView)
		//val r = EcoreUtil2::getAllContainers(it).findFirst[x | x instanceof DRepresentationContainer]
		return r.ownedRepresentationDescriptors.findFirst[x | x.name == diagramName].representation
	}

	static def openDiagram(DSemanticDiagram it)
	{
		val manager = SessionManager::INSTANCE
		val session = manager.getSession(it.target)
		DialectUIManager::INSTANCE.openEditor(session, it, new NullProgressMonitor)
	}

	static def isDisplayedModaneElement(DSemanticDiagram it, ModaneElement element)
	{
		displayedModaneElements.contains(element)
	}

	static def getDisplayedModaneElements(DSemanticDiagram it)
	{
		return ownedDiagramElements.filter[ n | n.target !== null && n.target instanceof ModaneElement].map[ n | n.target as ModaneElement].toSet
	}

	static def getContainingDiagramTargets(DSemanticDiagram it, ModaneElement element)
	{
		val r = EcoreUtil2::getContainerOfType(it, DView)
		return r.ownedRepresentationDescriptors.map[x|x.representation].filter(DSemanticDiagram).filter[d | d != it && d.displayedModaneElements.contains(element)].map[x | x.target].toSet
	}

	static def refresh(DSemanticDiagram it)
	{
		DialectManager::INSTANCE.refresh(it, true, new NullProgressMonitor)
		return it
	}
}
