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
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import com.google.common.collect.Lists;

public class ConfirmDeletionTreeContentProvider extends AdapterFactoryContentProvider {

	/**
	 * Constructor.
	 *
	 * @param adapterFactory
	 *            Adapter factory
	 */
	public ConfirmDeletionTreeContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object parentElement) {
		final List<Object> children = Lists.newArrayList();
		if (parentElement instanceof EObject) {
			for (final Object child : super.getChildren(parentElement)) {
				children.add(child);
			}
		}
		return children.toArray();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object[] getElements(Object object) {
		if (object instanceof Collection) {
			return ((Collection) object).toArray();
		}
		return super.getElements(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object element) {
		final Object[] children = getChildren(element);
		if (children != null && children.length != 0) {
			return true;
		}
		return false;
	}
}
