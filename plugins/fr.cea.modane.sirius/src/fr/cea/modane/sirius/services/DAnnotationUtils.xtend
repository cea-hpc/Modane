/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.services

import fr.cea.modane.modane.ModaneElement
import org.eclipse.sirius.diagram.DDiagram
import org.eclipse.sirius.diagram.DNodeContainer
import org.eclipse.sirius.viewpoint.description.DescriptionFactory

class DAnnotationUtils 
{
	public static val DANNOTATION_OPERATIONS_COMPARTMENT_SOURCE = "operations-compartment-visibility"
	public static val DANNOTATION_PROPERTIES_COMPARTMENT_SOURCE = "properties-compartment-visibility"
	public static val DANNOTATION_DIAGRAM_NAVIGATION_SOURCE = "diagram-navigation"
	
	static def isOperationsCompartmentShown(DNodeContainer nc) { isCompartmentShown(nc, DANNOTATION_OPERATIONS_COMPARTMENT_SOURCE) }
	static def isPropertiesCompartmentShown(DNodeContainer nc) { isCompartmentShown(nc, DANNOTATION_PROPERTIES_COMPARTMENT_SOURCE) }
	
	private static def isCompartmentShown(DNodeContainer nc, String annotationKey) 
	{
		val _name = (nc.target as ModaneElement).name
		val annotation = nc.parentDiagram.getDAnnotation(annotationKey)
		if (annotation !== null && annotation.details.containsKey(_name)) 
		{
			val valueAsString = annotation.details.get(_name)
			return Boolean::parseBoolean(valueAsString)
		}
		else 
		{
			return true		
		}
	}

	static def setOperationsCompartmentShown(DNodeContainer nc, Boolean value) { setCompartmentShown(nc, DANNOTATION_OPERATIONS_COMPARTMENT_SOURCE, value) }
	static def setPropertiesCompartmentShown(DNodeContainer nc, Boolean value) { setCompartmentShown(nc, DANNOTATION_PROPERTIES_COMPARTMENT_SOURCE, value) }

	private static def DNodeContainer setCompartmentShown(DNodeContainer nc, String annotationKey, Boolean value) 
	{
		val _name = (nc.target as ModaneElement).name
		val annotation = nc.parentDiagram.getOrCreateAnnotation(annotationKey)
		annotation.details.put(_name, Boolean::toString(value))	
		return nc
	}
		
	static def getOrCreateAnnotation(DDiagram d, String annotationKey)
	{
		var annotation = d.getDAnnotation(annotationKey)
		if (annotation === null) 
		{
			annotation = DescriptionFactory::eINSTANCE.createDAnnotation
			annotation.setSource(annotationKey)
			d.getEAnnotations += annotation
		}
		return annotation
	}
	
	
}