/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.ui.dialogs;

import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import com.google.common.collect.Lists;

import fr.cea.modane.modane.ArgMultiplicity;
import fr.cea.modane.modane.Function;
import fr.cea.modane.modane.Referenceable;

public class ConfirmDeletionServices {

	public static ModaneAdditionalDeletionSwitch ADDITIONAL_DELETION_SWITCH = new ModaneAdditionalDeletionSwitch();
	public static ModaneModifiedSwitch MODIFIED_SWITCH = new ModaneModifiedSwitch();

	public boolean showConfirmationDeletionDialogForTable(EObject objectToDelete) {
		ConfirmDeletionDialog dialog = new ConfirmDeletionDialog(getAllElementsToDelete(objectToDelete),
				MODIFIED_SWITCH.doSwitch(objectToDelete));
		return dialog.openConfirm();
	}

	public boolean showConfirmationDeletionDialog(Collection<DSemanticDecorator> selectedMappings) {
		Collection<EObject> selectedElements = Lists.newArrayList();
		for (DSemanticDecorator dSemanticDecorator : selectedMappings) {
			selectedElements.add(dSemanticDecorator.getTarget());
		}

		return showConfirmationDeletionDialogForEObjects(selectedElements);
	}

	public boolean showConfirmationDeletionDialogForEObjects(Collection<EObject> selectedElements) {
		Collection<EObject> deletedElements = Lists.newArrayList();
		Collection<EObject> modifiedElements = Lists.newArrayList();
		for (EObject objectToDelete : selectedElements) {
			deletedElements.addAll(getAllElementsToDelete(objectToDelete));
			modifiedElements.addAll(MODIFIED_SWITCH.doSwitch(objectToDelete));
		}

		ConfirmDeletionDialog dialog = new ConfirmDeletionDialog(deletedElements, modifiedElements);
		return dialog.openConfirm();
	}

	public Collection<EObject> getAllElementsToDelete(EObject objectToDelete) {
		Collection<EObject> deletedElements = Lists.newArrayList();
		deletedElements.add(objectToDelete);
		final TreeIterator<EObject> iter = objectToDelete.eAllContents();
		while (iter.hasNext()) {
			final EObject eObject = iter.next();
			deletedElements.add(eObject);
		}
		deletedElements.addAll(ADDITIONAL_DELETION_SWITCH.doSwitch(objectToDelete));
		return deletedElements;
	}

	public void changeFunctionTypeToVoid(EObject objectToDelete) {
		if (objectToDelete instanceof Referenceable) {
			Collection<EObject> modifiedElements = MODIFIED_SWITCH.doSwitch(objectToDelete);
			for (EObject eObject : modifiedElements) {
				if (eObject instanceof Function) {
					((Function) eObject).setType(null);
					((Function) eObject).setMultiplicity(ArgMultiplicity.SCALAR);
				}
			}
		}
	}
}
