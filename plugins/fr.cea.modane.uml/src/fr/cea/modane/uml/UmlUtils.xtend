/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.uml

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.uml2.uml.Model
import org.eclipse.uml2.uml.resource.UMLResource
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil

class UmlUtils
{
	static def Model readUmlModel(URI uri)
	{
		val resourceSet = new ResourceSetImpl
		UMLResourcesUtil::init(resourceSet)
		resourceSet.resourceFactoryRegistry.extensionToFactoryMap.put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE)

		// Demand load the resource for this file
		val resource = resourceSet.getResource(uri, true)
		resource.getContents().get(0) as Model
	}

//	static def Model readUmlModelFromJava(String modelFileName)
//	{
//		//val umlPackage = UMLPackage.eINSTANCE
//		val resourceSet = new ResourceSetImpl
//		UMLResourcesUtil::init(resourceSet)
//		// Factory pour le UML
//		resourceSet.resourceFactoryRegistry.extensionToFactoryMap.put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE)
//		// Factory pour le xmi = factory par défaut pour tous les fichiers
//		resourceSet.resourceFactoryRegistry.extensionToFactoryMap.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl)
//		// Get the URI of the model file.
//		val fileURI = Utils::createURI(modelFileName)
//		// Demand load the resource for this file.
//		val resource = resourceSet.getResource(fileURI, true)
//		resource.getContents().get(0) as Model
//	}
}