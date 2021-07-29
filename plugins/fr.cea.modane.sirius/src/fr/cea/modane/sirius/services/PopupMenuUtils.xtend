/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.services

import fr.cea.modane.modane.ModaneElement
import java.util.Collection
import org.eclipse.emf.ecore.EObject
import org.eclipse.sirius.diagram.DNodeContainer

import static extension fr.cea.modane.sirius.services.DAnnotationUtils.*
import static extension fr.cea.modane.sirius.services.ModaneElementExtensions.*
import fr.cea.modane.modane.ModanePackage
import org.eclipse.sirius.viewpoint.DSemanticDecorator

class PopupMenuUtils 
{		
	// *** MENUS SHOW/HIDE PROPERTIES/OPERATIONS
	def getShowOperationsCandidateNodes(Collection<? extends EObject> views)
	{
		val isContainer = [ModaneElement x | x.isOperationsContainer]
		val isCompartmentReady = [DNodeContainer x | !x.isOperationsCompartmentShown ]
		views.getCandidates(isContainer, isCompartmentReady)
	}

	def enableShowOperations(Collection<? extends EObject> views)
	{
		!views.showOperationsCandidateNodes.empty
	}
	
	def getShowPropertiesCandidateNodes(Collection<? extends EObject> views)
	{
		val isContainer = [ModaneElement x | x.isPropertiesContainer]
		val isCompartmentReady = [DNodeContainer x | !x.isPropertiesCompartmentShown ]
		views.getCandidates(isContainer, isCompartmentReady)
	}

	def enableHideProperties(Collection<? extends EObject> views)
	{
		!views.hidePropertiesCandidateNodes.empty
	}

	def getHideOperationsCandidateNodes(Collection<? extends EObject> views)
	{
		val isContainer = [ModaneElement x | x.isOperationsContainer]
		val isCompartmentReady = [DNodeContainer x | x.isOperationsCompartmentShown ]
		views.getCandidates(isContainer, isCompartmentReady)
	}

	def enableHideOperations(Collection<? extends EObject> views)
	{
		!views.hideOperationsCandidateNodes.empty
	}
	
	def getHidePropertiesCandidateNodes(Collection<? extends EObject> views)
	{
		val isContainer = [ModaneElement x | x.isPropertiesContainer]
		val isCompartmentReady = [DNodeContainer x | x.isPropertiesCompartmentShown ]
		views.getCandidates(isContainer, isCompartmentReady)
	}

	def enableShowProperties(Collection<? extends EObject> views)
	{
		!views.showPropertiesCandidateNodes.empty
	}

	private def getCandidates(Collection<? extends EObject> views, (ModaneElement)=>boolean isContainer, (DNodeContainer)=>boolean isCompartmentReady)
	{
		views.filter(DNodeContainer).filter(x | x.isCandidate(isContainer, isCompartmentReady)).toList
	}
	
	private def isCandidate(DNodeContainer nc, (ModaneElement)=>boolean isContainer, (DNodeContainer)=>boolean isCompartmentReady)
	{
		nc.target instanceof ModaneElement && isContainer.apply(nc.target as ModaneElement) && isCompartmentReady.apply(nc)
	}
	
	// *** MENU DISPLAY RELATED ELEMENTS
	def getDisplayRelatedElementsCandidateNodes(Collection<? extends EObject> views)
	{
		views.filter(DNodeContainer).filter(x | x.target instanceof ModaneElement && (x.target as ModaneElement).isRelatedElementsContainer).toList
	}
	
	def enableDisplayRelatedElements(Collection<? extends EObject> views)
	{
		!views.displayRelatedElementsCandidateNodes.empty
	}
	
	// *** MENU DISPLAY CHILDREN
	def getDisplayChildrenCandidateNodes(Collection<? extends EObject> views)
	{
		views.filter(DNodeContainer).filter(x | x.target instanceof ModaneElement && (x.target as ModaneElement).isChildrenContainer).toList
	}
	
	def enableDisplayChildren(Collection<? extends EObject> views)
	{
		!views.getDisplayChildrenCandidateNodes.empty
	}
	
	// *** MENU OPEN TEXTUAL EDITOR
	def getOpenTextualEditorCandidateEObjects(Collection<? extends EObject> views)
	{
		views.filter(DSemanticDecorator).filter(x | x.target.eClass.EPackage == ModanePackage::eINSTANCE).map[x|x.target].toList
	}
	
	def enableOpenTextualEditor(Collection<? extends EObject> views)
	{
		!views.getOpenTextualEditorCandidateEObjects.empty
	}
}