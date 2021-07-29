/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.contextual.queries

import fr.cea.modane.modane.EntryPoint
import fr.cea.modane.modane.Function
import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.OverrideFunction
import fr.cea.modane.modane.Reference
import fr.cea.modane.modane.ServiceOrModule
import fr.cea.modane.modane.Struct
import fr.cea.modane.modane.VarReference
import fr.cea.modane.modane.Variable
import java.util.List
import org.eclipse.amalgam.explorer.contextual.core.query.IQuery
import org.eclipse.emf.ecore.EObject
import org.eclipse.sirius.business.api.query.EObjectQuery

class ReferencingElementsQuery implements IQuery
{
	override List<Object> compute(Object it)
	{
		val l = allReferencingElements
		switch it
		{
			Struct: (l.filter(Struct) + l.filter(Reference).map[r | r.semanticContainer]).toObjectList
			Interface: (l.filter[x | x instanceof ServiceOrModule || x instanceof Interface] + l.filter(Reference).map[r | r.semanticContainer]).toObjectList
			Function: (l.filter[x | x instanceof Function || x instanceof OverrideFunction || x instanceof EntryPoint]).toObjectList
			Variable: (l.filter(VarReference).map[r | r.semanticContainer]).toObjectList
			default : #[]
		}
	}

	private def dispatch getAllReferencingElements(Object object) { null }
	private def dispatch getAllReferencingElements(EObject object)
	{
		// Use cross referencer to retrieve elements
		val session = new EObjectQuery(object).session
		if (session !== null)
			session.semanticCrossReferencer.getInverseReferences(object).map[x | x.EObject]
	}

	/** Depuis un Referenceable, la méthode de crossReference.inverse renvoit un objet de type Reference
	 *  On remonte ensuite soit à la Pty puis à l'objet qui contient la Pty (Service, Module, Interface ...)
	 * 	soit à Arg puis à l'objet qui contient l'Arg (Function, OverrideFunction ...)
	 */
	private def getSemanticContainer(Reference it)
	{
		eContainer.eContainer
	}

	/** Depuis une Variable, la méthode de crossReference.inverse renvoit un objet de type VarReference
	 *  On remonte ensuite soit à l'objet qui contient la VarReference (Function, OverrideFunction ...)
	 */
	private def getSemanticContainer(VarReference it)
	{
		eContainer
	}

	private def List<Object> toObjectList(Iterable<? extends EObject> it) { toList.toArray }
}
