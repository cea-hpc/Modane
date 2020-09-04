/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane

import fr.cea.modane.Utils
import fr.cea.modane.modane.Function
import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.Module
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.Reference
import fr.cea.modane.modane.Service
import fr.cea.modane.modane.Struct
import java.util.LinkedHashSet

import static extension fr.cea.modane.PtyExtensions.*

class InterfaceExtensions 
{
	static def boolean isConcrete(Interface it)
	{
		if (hasRealizations)
			return true
		else if (parents.exists(p | p.concrete))
			return true
		else if (referencedByAStruct)
			return true
		else if (properties.exists(p | p.concrete))
			return true
		return false
	}

	/** Retourne l'ensemble des méthodes de l'interface et de ses parents */
	static def LinkedHashSet<Function> getAllFunctions(Interface it)
	{
		var allFunctions = new LinkedHashSet<Function>
		for (p : parents) allFunctions.addAll(p.allFunctions)
		allFunctions.addAll(functions)
		return allFunctions
	}

	/** Retourne l'ensemble des parents de l'interface en remontant tout l'arbre d'héritage */
	static def LinkedHashSet<Interface> getAllInterfaces(Interface it)
	{
		var allInterfaces = new LinkedHashSet<Interface>
		for (p : parents) allInterfaces.addAll(p.allInterfaces)
		allInterfaces.addAll(parents)
		return allInterfaces
	}

	/** Retourne l'ensemble des propriétés de l'interface et de ses parents */
	static def LinkedHashSet<Pty> getAllProperties(Interface it)
	{
		var allProperties = new LinkedHashSet<Pty>
		for (p : parents) allProperties.addAll(p.allProperties)
		allProperties.addAll(properties)
		return allProperties
	}

	/** Retourne vrai si l'interface à au moins une réalisation : module ou service */
	static def boolean hasRealizations(Interface it) { !allServiceRealisations.empty || !allModuleRealisations.empty }
	
	/** Retourne l'ensemble des services implémentant une interface */
	static def LinkedHashSet<Service> getAllServiceRealisations(Interface it)
	{
		var allRealisations = new LinkedHashSet<Service>
		for (s : Utils::getAllVisibleModaneElements(it).filter(t | t instanceof Service && (t as Service).interfaces.contains(it)))
			allRealisations += s as Service
		return allRealisations
	}

	/** Retourne l'ensemble des modules implémentant une interface */
	static def LinkedHashSet<Module> getAllModuleRealisations(Interface it)
	{
		var allRealisations = new LinkedHashSet<Module>
		for (s : Utils::getAllVisibleModaneElements(it).filter(t | t instanceof Module && (t as Module).interfaces.contains(it)))
			allRealisations += s as Module
		return allRealisations
	}

	/** Retourne vrai si l'interface est référencée par une structure */
	static def isReferencedByAStruct(Interface it)
	{
		// recherche de toutes les structures visibles
		val allStructs = Utils::getAllVisibleModaneElements(it).filter(s | s instanceof Struct)
		for (elt : allStructs)
			// parcours de toutes les propriétés des stuctures
			for (p : (elt as Struct).properties)
				// si la structure a une propriété qui est une référence sur l'interface => vrai
				if (p.type instanceof Reference)
				{
					val ref = p.type as Reference
					if (ref.target instanceof Interface && (ref.target as Interface) == it) 
						return true
				}
		return false
	}
	
	static def defaultImplementationName(Interface it) { name + 'Default'}
}