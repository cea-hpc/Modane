/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.ui.dialogs;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;

import com.google.common.collect.Lists;

import fr.cea.modane.modane.Arg;
import fr.cea.modane.modane.Function;
import fr.cea.modane.modane.ModanePackage;
import fr.cea.modane.modane.Pty;
import fr.cea.modane.modane.Referenceable;
import fr.cea.modane.modane.Variable;
import fr.cea.modane.modane.util.ModaneSwitch;

public class ModaneAdditionalDeletionSwitch extends ModaneSwitch<Collection<EObject>> {

	@Override
	public Collection<EObject> defaultCase(EObject object) {
		return Collections.emptyList();
	}

	@Override
	public Collection<EObject> caseReferenceable(Referenceable object) {
		Collection<EObject> objectsToDelete = Lists.newArrayList();
		ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter.getCrossReferenceAdapter(object);
		Collection<Setting> inverseReferences = crossReferenceAdapter.getInverseReferences(object);
		for (Setting s : inverseReferences) {
			EStructuralFeature eStructuralFeature = s.getEStructuralFeature();
			if (ModanePackage.Literals.REFERENCE__TARGET.equals(eStructuralFeature)) {
				EObject eObject = s.getEObject();
				EObject eContainer = eObject.eContainer();
				if (eContainer instanceof Pty || eContainer instanceof Arg) {
					objectsToDelete.add(eContainer);
					objectsToDelete.add(eObject);
				}
			}
		}
		return objectsToDelete;
	}
	
	@Override
	public Collection<EObject> caseVariable(Variable object) {
		Collection<EObject> objectsToDelete = Lists.newArrayList();
		ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter.getCrossReferenceAdapter(object);
		Collection<Setting> inverseReferences = crossReferenceAdapter.getInverseReferences(object);
		for (Setting s : inverseReferences) {
			EStructuralFeature eStructuralFeature = s.getEStructuralFeature();
			if (ModanePackage.Literals.VAR_REFERENCE__VARIABLE.equals(eStructuralFeature)) {
				EObject eObject = s.getEObject();
				objectsToDelete.add(eObject);
			}
		}
		return objectsToDelete;
	}
	
	@Override
	public Collection<EObject> caseFunction(Function object) {
		Collection<EObject> objectsToDelete = Lists.newArrayList();
		ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter.getCrossReferenceAdapter(object);
		Collection<Setting> inverseReferences = crossReferenceAdapter.getInverseReferences(object);
		for (Setting s : inverseReferences) {
			EStructuralFeature eStructuralFeature = s.getEStructuralFeature();
			if (ModanePackage.Literals.OVERRIDE_FUNCTION__FUNC.equals(eStructuralFeature)) {
				EObject eObject = s.getEObject();
				objectsToDelete.add(eObject);
			}
		}
		return objectsToDelete;
	}
}
