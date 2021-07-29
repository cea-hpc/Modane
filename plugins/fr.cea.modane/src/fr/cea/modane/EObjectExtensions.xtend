/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane

import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.ModanePackage
import fr.cea.modane.modane.NamedElement
import fr.cea.modane.modane.OverrideFunction
import org.eclipse.emf.ecore.EObject

class EObjectExtensions
{
	/**
	 * Retourne le premier ModaneElement rencontré en partant de l'objet
	 * passé en paramètre et en remontant par le lien eContainer.
	 */
	def static ModaneElement getModaneParent(EObject it)
	{
		if (it === null || !(eClass.EPackage instanceof ModanePackage)) null
		else if (it instanceof ModaneElement) it
		else eContainer.modaneParent
	}

	/**
	 * Retourne le premier NamedElement rencontré en partant de l'objet
	 * passé en paramètre et en remontant par le lien eContainer.
	 */
	def static NamedElement getNamedParent(EObject it)
	{
		if (it === null || !(eClass.EPackage instanceof ModanePackage)) null
		else if (it instanceof NamedElement) it
		else eContainer.namedParent
	}

	/**
	 * Retourne le nom complet de l'objet.
	 * Par exemple, pour une fonction f, d'un service s dans le package a,
	 * cette fonction retourne a.s.f.
	 */
	def static String getFullName(EObject it)
	{
		if (it === null || !(eClass.EPackage instanceof ModanePackage)) null
		else if (it instanceof ModaneElement) name
		else if (it instanceof OverrideFunction) eContainer.fullName + '.' + func.name
		else if (it instanceof NamedElement) eContainer.fullName + '.' + name
		else eContainer.fullName
	}
}