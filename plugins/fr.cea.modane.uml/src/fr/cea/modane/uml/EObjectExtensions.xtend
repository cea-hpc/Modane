/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.uml

import org.eclipse.emf.ecore.EObject
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.PrimitiveType
import org.eclipse.uml2.uml.Interface

class EObjectExtensions 
{
	static def Interface toUmlInterface(EObject it) 
	{
		val baseClass = eClass.getEStructuralFeature("base_Interface")
		eGet(baseClass) as Interface
	}

	static def Class toUmlClass(EObject it) 
	{
		val baseClass = eClass.getEStructuralFeature("base_Class")
		eGet(baseClass) as Class
	}
	
	static def PrimitiveType toUmlPrimitiveType(EObject it) 
	{
		val baseClass = eClass.getEStructuralFeature("base_DataType")
		eGet(baseClass) as PrimitiveType
	}
	
	static def Operation toOperation(EObject it) 
	{
		val baseClass = eClass.getEStructuralFeature("base_Operation")
		eGet(baseClass) as Operation
	}
}