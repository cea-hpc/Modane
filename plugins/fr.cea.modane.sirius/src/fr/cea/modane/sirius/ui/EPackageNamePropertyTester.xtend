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

import org.eclipse.core.expressions.PropertyTester
import org.eclipse.emf.ecore.EObject

class EPackageNamePropertyTester extends PropertyTester
{
	override test(Object receiver, String property, Object[] args, Object expectedValue)
	{
		if (receiver instanceof EObject)
			if (receiver.eClass.EPackage.name == expectedValue)
				return true
		return false
	}
}