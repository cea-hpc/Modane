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

import org.eclipse.sirius.ui.tools.api.color.VisualBindingManager;
import org.eclipse.sirius.ui.tools.internal.views.common.navigator.SiriusCommonLabelProvider;
import org.eclipse.swt.graphics.Color;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

@SuppressWarnings("restriction")
public class ConfirmDeletionTreeLabelProvider extends SiriusCommonLabelProvider {

	private Predicate<Object> isDeleted = Predicates.alwaysFalse();
	private Predicate<Object> isModified = Predicates.alwaysFalse();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getBackground(Object element) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getForeground(final Object element) {

		Color foreground = null;

		if (isDeleted.apply(element)) {
			foreground = VisualBindingManager.getDefault().getColorFromName("red"); //$NON-NLS-1$
		} else if (isModified.apply(element)) {
			foreground = VisualBindingManager.getDefault().getColorFromName("orange"); //$NON-NLS-1$
		} else {
			foreground = VisualBindingManager.getDefault().getColorFromName("gray"); //$NON-NLS-1$
		}
		return foreground;
	}

	/**
	 * Set the deleted predicate. Predicate to find the deleted elements that will
	 * be represented in red in the tree viewer.
	 *
	 * @param isDeletedPredicate
	 *            Deleted elements predicate
	 * @return Deleted predicate
	 */
	public Predicate<Object> setDeletedPredicate(Predicate<Object> isDeletedPredicate) {
		return isDeleted = isDeletedPredicate != null ? isDeletedPredicate : Predicates.alwaysFalse();
	}

	/**
	 * Set the modified predicate. Predicate to find the modified elements that will
	 * be represented in orange in the tree viewer.
	 *
	 * @param isModifiedPredicate
	 *            Modified elements predicate
	 * @return DeModifiedleted predicate
	 */
	public Predicate<Object> setModifiedPredicate(Predicate<Object> isModifiedPredicate) {
		return isModified = isModifiedPredicate != null ? isModifiedPredicate : Predicates.alwaysFalse();
	}
}
