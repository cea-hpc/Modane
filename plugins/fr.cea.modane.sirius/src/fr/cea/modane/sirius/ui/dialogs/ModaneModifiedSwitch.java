/*******************************************************************************
 * Copyright (c) 2021 CEA
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

import fr.cea.modane.modane.Function;
import fr.cea.modane.modane.Interface;
import fr.cea.modane.modane.ItemFamily;
import fr.cea.modane.modane.ModanePackage;
import fr.cea.modane.modane.Referenceable;
import fr.cea.modane.modane.Struct;
import fr.cea.modane.modane.util.ModaneSwitch;

public class ModaneModifiedSwitch extends ModaneSwitch<Collection<EObject>> {

	@Override
	public Collection<EObject> defaultCase(EObject object) {
		return Collections.emptyList();
	}

	@Override
	public Collection<EObject> caseReferenceable(Referenceable object) {
		Collection<EObject> objectsModified = Lists.newArrayList();
		ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter.getCrossReferenceAdapter(object);
		Collection<Setting> inverseReferences = crossReferenceAdapter.getInverseReferences(object);
		for (Setting s : inverseReferences) {
			EStructuralFeature eStructuralFeature = s.getEStructuralFeature();
			if (ModanePackage.Literals.REFERENCE__TARGET.equals(eStructuralFeature)) {
				EObject eObject = s.getEObject();
				EObject eContainer = eObject.eContainer();
				if (eContainer instanceof Function) {
					objectsModified.add(eContainer);
					objectsModified.add(eObject);
				}
			}
		}
		return objectsModified;
	}

	@Override
	public Collection<EObject> caseInterface(Interface object) {
		Collection<EObject> objectsModified = caseReferenceable(object);
		ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter.getCrossReferenceAdapter(object);
		Collection<Setting> inverseReferences = crossReferenceAdapter.getInverseReferences(object);
		for (Setting s : inverseReferences) {
			EStructuralFeature eStructuralFeature = s.getEStructuralFeature();
			if (ModanePackage.Literals.SERVICE_OR_MODULE__INTERFACES.equals(eStructuralFeature)) {
				objectsModified.add(s.getEObject());
			} else if (ModanePackage.Literals.INTERFACE__PARENTS.equals(eStructuralFeature)) {
				objectsModified.add(s.getEObject());
			}
		}
		return objectsModified;
	}

	@Override
	public Collection<EObject> caseFunction(Function object) {
		Collection<EObject> objectsModified = Lists.newArrayList();
		ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter.getCrossReferenceAdapter(object);
		Collection<Setting> inverseReferences = crossReferenceAdapter.getInverseReferences(object);
		for (Setting s : inverseReferences) {
			EStructuralFeature eStructuralFeature = s.getEStructuralFeature();
			if (ModanePackage.Literals.FUNCTION__CALLS.equals(eStructuralFeature)) {
				objectsModified.add(s.getEObject());
			} else if (ModanePackage.Literals.OVERRIDE_FUNCTION__CALLS.equals(eStructuralFeature)) {
				objectsModified.add(s.getEObject());
			} else if (ModanePackage.Literals.ENTRY_POINT__CALLS.equals(eStructuralFeature)) {
				objectsModified.add(s.getEObject());
			}
		}
		return objectsModified;
	}

	@Override
	public Collection<EObject> caseStruct(Struct object) {
		Collection<EObject> objectsModified = caseReferenceable(object);
		ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter.getCrossReferenceAdapter(object);
		Collection<Setting> inverseReferences = crossReferenceAdapter.getInverseReferences(object);
		for (Setting s : inverseReferences) {
			EStructuralFeature eStructuralFeature = s.getEStructuralFeature();
			if (ModanePackage.Literals.STRUCT__PARENTS.equals(eStructuralFeature)) {
				objectsModified.add(s.getEObject());
			}
		}
		return objectsModified;
	}

	@Override
	public Collection<EObject> caseItemFamily(ItemFamily object) {
		Collection<EObject> objectsModified = Lists.newArrayList();
		ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter.getCrossReferenceAdapter(object);
		Collection<Setting> inverseReferences = crossReferenceAdapter.getInverseReferences(object);
		for (Setting s : inverseReferences) {
			EStructuralFeature eStructuralFeature = s.getEStructuralFeature();
			if (ModanePackage.Literals.VARIABLE__FAMILY.equals(eStructuralFeature)) {
				objectsModified.add(s.getEObject());
			}
		}
		return objectsModified;
	}
}
