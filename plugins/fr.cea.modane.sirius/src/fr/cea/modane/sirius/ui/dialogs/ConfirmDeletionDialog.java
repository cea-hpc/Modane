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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ui.tools.api.color.VisualBindingManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

import fr.cea.modane.modane.provider.ModaneItemProviderAdapterFactory;
import fr.cea.modane.modaneproject.ModaneProject;

public class ConfirmDeletionDialog extends MessageDialog {

	/**
	 * Viewer filter to only display elements impacted by this deletion.
	 */
	private class ModeFilter extends ViewerFilter {
		private Predicate<Object> isDeletedPredicate;
		private Predicate<Object> isModifiedPredicate;

		public ModeFilter(Predicate<Object> isDeletedPredicate, Predicate<Object> isModifiedPredicate) {
			this.isDeletedPredicate = isDeletedPredicate;
			this.isModifiedPredicate = isModifiedPredicate;
		}

		private boolean isMatchingOrHasMatchingDescendants(Object element) {
			if (element instanceof EObject) {
				return isOrHasDescendant(element, Predicates.or(isDeletedPredicate, isModifiedPredicate));
			}
			return false;
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			return isMatchingOrHasMatchingDescendants(element);
		}
	}

	private ModeFilter filter;

	private TreeViewer treeViewer;

	private final ConfirmDeletionTreeLabelProvider labelProvider;

	private ITreeContentProvider contentProvider;

	private final int width = 60;

	private final int height = 18;

	/**
	 * Constructor.
	 *
	 * @param allDeletedObjects
	 *            Semantic elements to delete
	 * @param allModifiedObjects
	 *            Semantic elements that will be modified
	 */
	public ConfirmDeletionDialog(final Collection<EObject> allDeletedObjects,
			final Collection<EObject> allModifiedObjects) {
		super(PlatformUI.getWorkbench().getDisplay().getActiveShell(), "Deletion", null, //$NON-NLS-1$
				null, 0, new String[] { IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL }, 1);
		contentProvider = new ConfirmDeletionTreeContentProvider(getAdapterFactory());
		labelProvider = new ConfirmDeletionTreeLabelProvider();
		final Predicate<Object> isDeletedPredicate = new Predicate<Object>() {
			public boolean apply(Object input) {
				return allDeletedObjects.contains(input);
			}
		};
		final Predicate<Object> isModifiedPredicate = new Predicate<Object>() {
			public boolean apply(Object input) {
				return allModifiedObjects.contains(input);
			}
		};
		labelProvider.setDeletedPredicate(isDeletedPredicate);
		labelProvider.setModifiedPredicate(isModifiedPredicate);
		filter = new ModeFilter(isDeletedPredicate, isModifiedPredicate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.MessageDialog#createCustomArea(org.eclipse.swt.
	 * widgets.Composite)
	 */
	@Override
	protected Control createCustomArea(Composite composite) {
		createLabelsArea(composite);
		treeViewer = createTreeViewer(composite);
		treeViewer.expandAll();
		final GridData data = new GridData(GridData.FILL_BOTH);
		data.widthHint = convertWidthInCharsToPixels(width);
		data.heightHint = convertHeightInCharsToPixels(height);
		final Tree treeWidget = treeViewer.getTree();
		treeWidget.setLayoutData(data);
		treeWidget.setFont(composite.getFont());
		createSelectionButtonsAfterMessageArea(composite);
		return composite;
	}

	/**
	 * Creates labels area
	 * 
	 * @param composite
	 *            the parent composite.
	 */
	private void createLabelsArea(Composite composite) {
		Composite labelsComposite = new Composite(composite, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = false;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginLeft = 0;
		gridLayout.marginTop = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		labelsComposite.setLayout(gridLayout);
		final Label labelRed = new Label(labelsComposite, SWT.NONE);
		labelRed.setText("Red:"); //$NON-NLS-1$
		labelRed.setFont(composite.getFont());
		labelRed.setForeground(VisualBindingManager.getDefault().getColorFromName("red")); //$NON-NLS-1$
		final Label labelDeletedElements = new Label(labelsComposite, SWT.NONE);
		labelDeletedElements.setText("elements that will be deleted."); //$NON-NLS-1$
		labelDeletedElements.setFont(composite.getFont());
		final Label labelOrange = new Label(labelsComposite, SWT.NONE);
		labelOrange.setText("Orange:"); //$NON-NLS-1$
		labelOrange.setForeground(VisualBindingManager.getDefault().getColorFromName("orange")); //$NON-NLS-1$
		labelOrange.setFont(composite.getFont());
		final Label labelModifiedElements = new Label(labelsComposite, SWT.NONE);
		labelModifiedElements.setText("elements that will be modified."); //$NON-NLS-1$
		labelModifiedElements.setFont(composite.getFont());

		final Label messageLabel = new Label(composite, SWT.NONE);
		messageLabel.setText("Confirm deletion ?"); //$NON-NLS-1$
		messageLabel.setFont(composite.getFont());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IconAndMessageDialog#createMessageArea(org.eclipse.
	 * swt.widgets.Composite)
	 */
	@Override
	protected Control createMessageArea(Composite composite) {
		return null;
	}

	/**
	 * Creates selection buttons.
	 *
	 * @param composite
	 *            the parent composite
	 * @return the selection buttons composite
	 */
	protected Composite createSelectionButtonsAfterMessageArea(Composite composite) {
		final Composite buttonComposite = new Composite(composite, SWT.RIGHT);
		final GridLayout layout = new GridLayout();
		layout.numColumns = 7;
		layout.makeColumnsEqualWidth = false;
		buttonComposite.setLayout(layout);
		buttonComposite.setFont(composite.getFont());

		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_END | GridData.GRAB_HORIZONTAL);
		data.grabExcessHorizontalSpace = true;
		composite.setData(data);

		return buttonComposite;
	}

	/**
	 * Creates the tree viewer.
	 *
	 * @param parent
	 *            the parent composite
	 * @return the tree viewer
	 */
	protected TreeViewer createTreeViewer(Composite parent) {
		treeViewer = new TreeViewer(parent);
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setLabelProvider(labelProvider);
		final Collection<EObject> roots = getAllRootsInSessions();
		final Collection<Object> inputs = Sets.newHashSet();
		inputs.addAll(roots);
		treeViewer.addFilter(filter);
		treeViewer.setInput(inputs);
		return treeViewer;
	}

	/**
	 * Returns the adapter factory used by this viewer.
	 *
	 * @return The adapter factory used by this viewer.
	 */
	private AdapterFactory getAdapterFactory() {
		final List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		factories.add(new ModaneItemProviderAdapterFactory());
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		return new ComposedAdapterFactory(factories);
	}

	/**
	 * Get all roots in the sessions.
	 * 
	 * @return all roots in the sessions.
	 */
	private Collection<EObject> getAllRootsInSessions() {
		final Collection<EObject> roots = new ArrayList<EObject>();
		for (final Session session : SessionManager.INSTANCE.getSessions()) {
			for (final Resource childRes : session.getSemanticResources()) {
				for (final EObject eObject : childRes.getContents()) {
					if (eObject instanceof ModaneProject) {
						roots.add(eObject);
					}
				}
			}
		}
		return roots;
	}

	/**
	 * Check if the given element is or has descendant according to the given
	 * predicate.
	 * 
	 * @param element
	 *            the given element.
	 * @param pred
	 *            the given predicate.
	 * @return <code>true</code> if the given element is or has descendant,
	 *         <code>false</code> otherwise.
	 */
	private boolean isOrHasDescendant(Object element, final Predicate<Object> pred) {
		final boolean matches = pred.apply(element);
		if (matches) {
			return true;
		}
		return Iterables.any(Arrays.asList(contentProvider.getChildren(element)), new Predicate<Object>() {
			public boolean apply(Object input) {
				return isOrHasDescendant(input, pred);
			}
		});
	}

	/**
	 * Open dialog.
	 *
	 * @return <code>true</code> if user confirm the deletion, <code>false</code>
	 *         otherwise
	 */
	public boolean openConfirm() {
		final int result[] = new int[] { 0 };
		result[0] = super.open();
		return result[0] == IDialogConstants.OK_ID;
	}

	/**
	 * Refreshes this dialog's viewer.
	 */
	public void refresh() {
		treeViewer.refresh();
	}

}
