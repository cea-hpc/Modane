/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.modaneproject.impl;

import org.eclipse.emf.ecore.EObject;

public class PackageImplCustom extends fr.cea.modane.modaneproject.impl.PackageImpl {

	/**
	 * 
	 * @generated NOT
	 */
	public String getFullyQualifiedName() {
		String fqn = getName();

		EObject container = eContainer();
		if (container instanceof fr.cea.modane.modaneproject.Package) {
			fqn = ((fr.cea.modane.modaneproject.Package) container).getFullyQualifiedName() + "." + fqn;
		}

		return fqn;
	}

	/**
	 * 
	 * @generated NOT
	 */
	public void updateModelName() {
		if (getModel() != null) {
			getModel().setName(getFullyQualifiedName());
		}
		for (fr.cea.modane.modaneproject.Package subPackage : getSubPackages()) {
			subPackage.updateModelName();
		}
	}
}
