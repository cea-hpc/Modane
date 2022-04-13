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

import org.eclipse.amalgam.explorer.contextual.core.ui.view.ext.ISelectionHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

public class ModaneSelectionHelper implements ISelectionHelper {

	@Inject
    IResourceSetProvider resourceSetProvider;
	
	@Override
	public Object getSelection(IWorkbenchPart part, ISelection selection, Object object) {
		if (selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
			if (selectedElement instanceof EObject) {
				return selectedElement;
			} else if (selectedElement instanceof EObjectNode) {
				EObjectNode node = (EObjectNode)selectedElement;
				URI objectURI = node.getEObjectURI();
				URI resourceURI = objectURI.trimFragment();
				Resource resource = getResourceInSiriusSession(resourceURI);
				if (resource != null) {
					EObject eObject = resource.getEObject(objectURI.fragment());
					if (eObject != null) {
						return eObject;
					}
				}
//				XtextEditor activeXtextEditor = EditorUtils.getActiveXtextEditor();
//				IEditorInput editorInput = activeXtextEditor.getEditorInput();

				
			}
		}
		
		
		return null;
	}

	private Resource getResourceInSiriusSession(URI uri) {
		for (Session session : SessionManager.INSTANCE.getSessions()) {
			for (Resource resource : session.getTransactionalEditingDomain().getResourceSet().getResources()) {
				if (uri.equals(resource.getURI())) {
					return resource;
				}
			}
		}
		return null;
	}
}