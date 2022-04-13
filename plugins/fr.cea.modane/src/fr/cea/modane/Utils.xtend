/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane

import fr.cea.modane.modane.EntryPointLocation
import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.ModanePackage
import fr.cea.modane.modane.Module
import fr.cea.modane.modane.OverrideFunction
import fr.cea.modane.modane.Service
import java.io.PrintWriter
import java.io.StringWriter
import java.util.Collection
import java.util.LinkedHashSet
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.scoping.IScopeProvider

import static extension fr.cea.modane.ModuleExtensions.*
import static extension fr.cea.modane.ServiceExtensions.*

class Utils
{
	static def IResource toEclipseResource(Resource emfResource) { emfResource.URI.toEclipseResource }

	static def IResource toEclipseResource(URI uri)
	{
		if (uri.platformResource)
		{
			val ws = ResourcesPlugin::workspace.root
			val platformString = uri.toPlatformString(true)
			val resource = ws.findMember(platformString)
			return resource
		}
		else throw new RuntimeException("URI non gérée : " + uri.toString)
	 }

	static def String getAbsolutePath(URI uri)
	{
		if (uri.platformResource)
		{
			val r = uri.toEclipseResource
			if (r !== null && r.location !== null) r.location.toString
			else throw new RuntimeException("Resource introuvable pour l'URI : " + uri.toString)
		}
		else if (uri.file) uri.toFileString
		else throw new RuntimeException("URI non gérée : " + uri.toString)
	}

	static def findElement(IScopeProvider scopeProvider, EObject context, String name)
	{
		val allElements = scopeProvider.getScopeElements(context)
		val description = allElements.findFirst[e | e.name == name]
		return description.EObjectOrProxy.resolveProxy(context)
	}

	static def getAllElementsOfType(IScopeProvider scopeProvider, EObject context, EClass c)
	{
		val allElements = scopeProvider.getScopeElements(context)
		val resultElements = new LinkedHashSet<EObject>
		for (desc : allElements.filter[e | e.EObjectOrProxy.eClass == c || e.EObjectOrProxy.eClass.EAllSuperTypes.contains(c)])
			resultElements += desc.EObjectOrProxy.resolveProxy(context)
		return resultElements
	}

	static def boolean isInitGroup(EntryPointLocation l)
	{
		( l == EntryPointLocation::CONTINUE_INIT ||
		  l == EntryPointLocation::INIT ||
		  l == EntryPointLocation::START_INIT )
	}

	static def getAllVisibleModaneElements(EObject it)
	{
		eResource?.resourceSet.allContents.filter[x | x instanceof ModaneElement].toIterable
	}

	static def Collection<Interface> getAllInterfaces(OverrideFunction it)
	{
		switch eContainer
		{
			Service : (eContainer as Service).allInterfaces
			Module : (eContainer as Module).allInterfaces
			default : null
		}
	}

	static def String getStackTrace(Exception e)
	{
		val result = new StringWriter()
		val printWriter = new PrintWriter(result)
		e.printStackTrace(printWriter)
		return result.toString()
	}

	private static def getScopeElements(IScopeProvider scopeProvider, EObject context)
	{
		if (scopeProvider === null) throw new AssertionError("** Scope provider is null !")
		val scope = scopeProvider.getScope(context, ModanePackage::eINSTANCE.modaneModel_Elements)
		return scope.allElements
	}

	private static def resolveProxy(EObject o, EObject context)
	{
		if (o.eIsProxy) EcoreUtil::resolve(o, context)
		else o 
	}
}