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

import fr.cea.modane.modane.ArgDefinition
import fr.cea.modane.modane.EntryPoint
import fr.cea.modane.modane.EnumerationLiteral
import fr.cea.modane.modane.Function
import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.ModaneModel
import fr.cea.modane.modane.NamedElement
import fr.cea.modane.modane.OverrideFunction
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.Reference
import fr.cea.modane.modane.ServiceOrModule
import fr.cea.modane.modane.UnitTestFunction
import fr.cea.modane.modane.VarDefinition
import fr.cea.modane.modane.VarReference
import fr.cea.modane.modane.Variable
import fr.cea.modane.sirius.internal.DiagnosticAttachment
import java.util.ArrayList
import java.util.LinkedHashSet
import java.util.List
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.Diagnostician
import org.eclipse.sirius.business.api.session.SessionManager
import org.eclipse.sirius.diagram.DSemanticDiagram
import org.eclipse.swt.graphics.Color
import org.eclipse.swt.graphics.RGB
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Shell

import static extension fr.cea.modane.InterfaceExtensions.*
import static extension fr.cea.modane.sirius.services.ModaneElementExtensions.*
import static extension fr.cea.modane.sirius.services.PtyOrArgTypeExtensions.*
import static extension fr.cea.modane.sirius.services.SemanticDiagramExtensions.*

class Utils
{
	static def shouldBeDisplayed(Pty pty, DSemanticDiagram diagram)
	{
		val t = pty.type
		switch t
		{
			Reference : !diagram.isDisplayedModaneElement(t.target)
			default : true
		}
	}

	static def getColor(int r, int g, int b)
	{ 
		new Color(Display::^default, new RGB(r, g, b));
	}

	static def getReturnTypeName(Function it)
	{
		if (type === null) 'void'
		else
			multiplicity.literal + ' ' + type.name
	}

	//TODO Vérifier toujours utile ?
	static def getAllResourceSetModaneElements(EObject o)
	{
		val allElements = new LinkedHashSet<ModaneElement>
		if (o.eResource !== null && o.eResource.resourceSet !== null)
		{
			for (r : o.eResource.resourceSet.resources)
				for (c : r.contents.filter[x | x instanceof ModaneModel])
					allElements.addAll((c as ModaneModel).elements)
		}

		return allElements
	}

	static def trace(String s)
	{
		println(s)
		return s
	}

	static def trace(EObject o)
	{
		if (o === null) println("NULL")
		else println(o + ' : ' + o.class.name)
		return o
	}

	static def traceWithVars(EObject o)
	{
		println("TraceWithVars")
		val manager = SessionManager::INSTANCE
		val session = manager.getSession(o)
		val interpreter = session.interpreter
		val variables = interpreter.variables
		println("Variables [" + variables.size + "] : ")
		variables.keySet.forEach[v | println(v + ' : ' + variables.get(v))]
		println
		o.trace
	}

	static def Shell getShell()
	{
		Display.^default.activeShell
	}

	static def dispatch getDisplayExpression(ArgDefinition it)
	{
		#[direction.literal, multiplicity.literal, type.name, name].join(' ')
	}

	static def dispatch getDisplayExpression(VarDefinition it)
	{
		#[direction.literal, support.literal, multiplicity.literal, type.literal, name].join(' ')
	}

	static def dispatch getDisplayExpression(VarReference it)
	{
		direction.literal + " " + variable.name
	}

	static def getFamilyDisplayExpression(Variable it)
	{
		if (family === null) 'None'
		else family.name
	}

	static def getAllFunctions(ServiceOrModule it)
	{
		val functions = new LinkedHashSet<Function>
		interfaces.forEach[i | functions += i.allFunctions]
		return functions
	}

	static def isDesignDiagramDisplayable(EObject object)
	{
		switch object
		{
			ModaneElement : object.isDesignDiagramDisplayable
			default : false
		}
	}

	static def <T extends EObject> shiftItemInList(T item, List<T> list, int shift)
	{
		val index = list.indexOf(item)
		if (index  !== -1)
		{
			val size = list.size
			list.remove(item)
			list.add((index+size+shift)%size, item)
		}
		return list
	}

	static def ModaneModel getModaneModel(EObject o)
	{
		val c = o.eContainer
		if (c === null) null
		else if (c instanceof ModaneModel) c
		else c.modaneModel
	}

	static def dispatch getFormatedDescription(ModaneElement it) { description.format }
	static def dispatch getFormatedDescription(Pty it) { description.format }
	static def dispatch getFormatedDescription(EntryPoint it) { description.format }
	static def dispatch getFormatedDescription(Function it) { description.format }
	static def dispatch getFormatedDescription(OverrideFunction it) { description.format }
	static def dispatch getFormatedDescription(UnitTestFunction it) { description.format }
	static def dispatch getFormatedDescription(EnumerationLiteral it) { description.format }
	static def dispatch getFormatedDescription(EObject it) { "" }

	private static def format(String description)
	{
		if (description.nullOrEmpty) return ""
		// ajout d'un saut de ligne tous les 50 caractères
		val lines = new ArrayList<String>
		var line = ""
		for (word : description.split (' '))
		{
			line += word
			if (line.length > 50)
			{
				lines += line
				line = ""
			}
			else line += ' '
		}
		if (!line.empty) lines += line
		return lines.join('\n')
	}

	static def hasError(EObject eObj)
	{
		var attachment = DiagnosticAttachment.getAttachment(eObj)
		if (attachment === null)
		{
			var diagnostic = Diagnostician.INSTANCE.validate(eObj)
			attachment = DiagnosticAttachment.getOrCreate(eObj, diagnostic)
		}
		if (attachment !== null)
		{
			var diag = attachment.diagnostic
			if (diag !== null && diag.children.size > 0)
				return diag.severity == Diagnostic.ERROR
		}
		return false
	}

	static def hasWarning(EObject eObj)
	{
		var attachment = DiagnosticAttachment.getAttachment(eObj)
		if (attachment === null)
		{
			var diagnostic = Diagnostician.INSTANCE.validate(eObj)
			attachment = DiagnosticAttachment.getOrCreate(eObj, diagnostic)
		}
		if (attachment !== null)
		{
			var diag = attachment.diagnostic
			if (diag !== null && diag.children.size > 0)
				return diag.severity == Diagnostic.WARNING
		}
		return false
	}

	static def getErrorMsg(EObject eObj)
	{
		if (DiagnosticAttachment.get(eObj).present)
		{
			var diag = DiagnosticAttachment.get(eObj)
			prettyMessage(eObj, diag.get)
		}
	}

	private static def String prettyMessage(EObject eObj, Diagnostic diag)
	{
		var result = ""
		for (child : diag.children)
		{
			var message = child.message
			var dataList = child.data
			for (d : dataList)
			{
				if (d instanceof EObject)
				{
					if (eObj != d && d instanceof NamedElement)
					{
						message = "(" + d.eClass.name + " "+ (d as NamedElement).name + ") " + message
					}
				}
			}
			if (!result.empty)
			{
				result += System.lineSeparator
			}
			result += severityLabel(child.severity) + " : " + message
			result += prettyMessage(eObj, child)
		}
		return result
	}

	private static def severityLabel(int severity)
	{
		switch (severity)
		{
			case Diagnostic.ERROR:
				return "ERROR"
			case Diagnostic.CANCEL:
				return "CANCEL"
			case Diagnostic.INFO:
				return "INFO"
			case Diagnostic.WARNING:
				return "WARNING"
			case Diagnostic.OK:
				return "OK"
		}
		return "UNKNOWN"
	}
}
