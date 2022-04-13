/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.contextual.queries

import fr.cea.modane.modane.ArgDefinition
import fr.cea.modane.modane.EntryPoint
import fr.cea.modane.modane.Function
import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.OverrideFunction
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.PtyOrArgType
import fr.cea.modane.modane.Reference
import fr.cea.modane.modane.ServiceOrModule
import fr.cea.modane.modane.Struct
import fr.cea.modane.modane.VarReference
import java.util.List
import org.eclipse.amalgam.explorer.contextual.core.query.IQuery
import org.eclipse.emf.ecore.EObject

class ReferencedElementsQuery implements IQuery
{
	override List<Object> compute(Object it)
	{
		switch it
		{
			Struct: (parents + properties.ptyReferenceables).toObjectList
			// On a choisi de ne pas remonter les dépendances provenant des Functions sur les Interfaces
			Interface: (parents + properties.ptyReferenceables).toObjectList
			// On a choisi de ne pas remonter les dépendances provenant des OverrideFunctions sur les Services et des EntryPoints sur les Modules
			ServiceOrModule: (interfaces + properties.ptyReferenceables).toObjectList
			Pty case (type instanceof Reference):  #[(type as Reference).target]
			Function: (calls + vars.variables + args.filter(ArgDefinition).argReferenceables).toObjectList
			OverrideFunction: (calls + vars.variables + #[func]).toObjectList
			EntryPoint: (calls + vars.variables).toObjectList
			default : #[]
		}
	}

	private def getPtyReferenceables(Iterable<Pty> l) { l.map[x|x.type].referenceables }
	private def getArgReferenceables(Iterable<ArgDefinition> l) { l.map[x|x.type].referenceables }
	private def getReferenceables(Iterable<PtyOrArgType> l) { l.filter(Reference).map[r|r.target] }
	private def getVariables(Iterable<VarReference> l) { l.map[x|x.variable] }

	private def List<Object> toObjectList(Iterable<? extends EObject> it) { toList.toArray }
}