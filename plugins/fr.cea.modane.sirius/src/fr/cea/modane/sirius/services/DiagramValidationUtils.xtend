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

import org.eclipse.emf.ecore.EObject

import static extension fr.cea.modane.sirius.services.Utils.*

class DiagramValidationUtils 
{
	def renderTooltip(EObject eObj)
	{
		if (eObj.hasError || eObj.hasWarning)
			eObj.errorMsg
		else
			eObj.formatedDescription
	}
}