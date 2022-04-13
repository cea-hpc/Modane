/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.ui

import fr.cea.modane.modaneproject.Package
import org.eclipse.core.expressions.PropertyTester

class PackageModelExistenceTester extends PropertyTester
{
	override test(Object receiver, String property, Object[] args, Object expectedValue) 
	{
		if (receiver instanceof Package && expectedValue !== null)
		{
			val p = receiver as Package
			if (expectedValue.toString == "false") return p.model === null
			if (expectedValue.toString == "true") return p.model !== null
		}
		return false
	}	
}