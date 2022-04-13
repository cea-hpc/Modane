/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.contextual;

import org.eclipse.amalgam.explorer.contextual.core.filter.ICandidateElementFilter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.viewpoint.ViewpointPackage;

// Cette méthode permet de filter dans les panneaux du ContextualExplorer les éléments graphiques de Sirius 
// (du type DNodeContainer ...)
public class ModaneCandidateElementFilter implements ICandidateElementFilter {

	@Override
	public boolean select(Object object) {
		return object instanceof EObject;
	}

	@Override
    public boolean accept(Object object) {
        if (object instanceof EObject) {
        	EClass eClass = ((EObject) object).eClass();
			if (ViewpointPackage.eINSTANCE.getDRepresentation().isSuperTypeOf(eClass)) {
				return true;
			}
			String nsURI = eClass.getEPackage().getNsURI();
			if (nsURI != null && nsURI.startsWith("http://www.eclipse.org/sirius")) {
				return false;
			}
        }
        return true;
    }
}
