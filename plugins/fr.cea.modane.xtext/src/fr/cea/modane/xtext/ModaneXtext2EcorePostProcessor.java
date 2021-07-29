/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.xtext;

import java.util.Optional;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor;

@SuppressWarnings("restriction")
public class ModaneXtext2EcorePostProcessor implements IXtext2EcorePostProcessor {

	@Override
	public void process(GeneratedMetamodel metamodel) {
		process(metamodel.getEPackage());
	}

	private void process(EPackage p) {
		for (EClassifier c : p.getEClassifiers()) {
			if (c instanceof EClass && "ModaneModel".contentEquals(c.getName())) {
				for (EReference r : ((EClass) c).getEReferences()) {
					if ("elements".equals(r.getName())) {
						addEKey(r);
					}
				}
			}
		}
	}

	private void addEKey(EReference r)
	{
		Optional<EAttribute> modaneEltName = r.getEReferenceType().getEAllAttributes().stream().filter(a -> "name".equals(a.getName())).findFirst();
		if (modaneEltName.isPresent()) {
			r.getEKeys().add(modaneEltName.get());
		}
	}
}
