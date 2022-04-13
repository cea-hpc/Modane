/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.cycles

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference

import static extension fr.cea.modane.EObjectExtensions.*
import static extension fr.cea.modane.ModaneElementExtensions.*

/**
 * Graphe de dépendances entre packages.
 * Les noeuds sont les noms des packages.
 * Si un package A dépend de B, il existe un arc A -> B.
 * Cet arc porte une liste de DependencyInfo.
 * @see DependencyInfo
 */
interface DependencyGraph 
{
	public static val Separator = ' >> '
	
	def void setPackages(List<String> packages)
	def void addDependencyInfo(DependencyInfo info)	
	def List<DependencyInfo> getDependencyInfos(String sourcePackage, String targetPackage)
	
	/** 
	 * Retourne la liste des cycles élémentaires.
	 * Chaque cycle est représenté par une liste de noeuds.
	 * Le premier noeud et le dernier noeud de la liste doivent être identiques.
	 */
	def List<List<String>> findSimpleCycles()
}

/**
 * Classe représentant des informations sur la dépendance entre objets d'une application.
 * Elle contient l'élément de départ de la dépendance, l'élément d'arrivée, le type de 
 * la dépendance (en terme EMF) et l'indice dans le cas d'une cardinalité multiple. 
 */
class DependencyInfo
{
	val EObject sourceElement
	val EObject targetElement
	val EReference dependencyElement
	val int index

	new(EObject sourceElement, EObject targetElement, EReference dependencyElement, int index)
	{
		this.sourceElement = sourceElement
		this.targetElement = targetElement
		this.dependencyElement = dependencyElement
		this.index = index
	}
	
	def getSourceElement() { sourceElement }
	def getTargetElement() { targetElement }
	def getDependencyElement() { dependencyElement }
	def getIndex() { index }
	def getSourcePackage() { sourceElement.modaneParent.model.name }
	def getTargetPackage() { targetElement.modaneParent.model.name }
	
	override toString()
	{
		val ret = new StringBuilder
		ret.append(sourceElement.eClass.name + ' ' + sourceElement.fullName)
		ret.append(DependencyGraph::Separator)
		ret.append(targetElement.eClass.name + ' ' + targetElement.fullName)
		ret.append(' (' + dependencyElement.name + ')')
		return ret.toString 
	}
}