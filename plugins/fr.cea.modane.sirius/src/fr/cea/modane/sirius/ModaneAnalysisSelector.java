/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSelector;
import org.eclipse.sirius.ui.business.api.session.analysis.SmartDialogAnalysisSelector;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import fr.cea.modane.modane.ModaneModel;
import fr.cea.modane.sirius.fragmentation.FragmentationUtils;

public class ModaneAnalysisSelector extends SmartDialogAnalysisSelector implements DAnalysisSelector {

	@Override
	public DAnalysis selectSmartlyAnalysisForAddedRepresentation(DRepresentation representation, Collection<DAnalysis> allAnalysis) {
		if (representation instanceof DSemanticDecorator) {
			DAnalysis analysis = null;
			EObject target = ((DSemanticDecorator) representation).getTarget();
			if (target instanceof ModaneModel) {
				analysis = getAnalysis((ModaneModel)target, allAnalysis);
				if (analysis != null) {
					return analysis;					
				}
			}
			// We can be here if the target was not a ModaneModel
			// or if the corresponding analysis could not be found
			analysis = getMainAnalysis(target);
			if (analysis != null) {
				return analysis;
			}
		}
		
		return super.selectSmartlyAnalysisForAddedRepresentation(representation, allAnalysis);
	}
	
	private DAnalysis getAnalysis(ModaneModel model, Collection<DAnalysis> allAnalysis) {
		if (FragmentationUtils.isControlled(model)) {
			// ModaneModel is in its own resource, we should return the corresponding AIRD file
			URI airdURI = FragmentationUtils.getAirdURI(model);
			for (DAnalysis analysis : allAnalysis) {
				if (airdURI.equals(analysis.eResource().getURI())) {
					return analysis;
				}
			}
		}
		return null;
	}
	
	private DAnalysis getMainAnalysis(EObject object) {
		Session session = new EObjectQuery(object).getSession();
		if (session != null) {
			EList<EObject> contents = session.getSessionResource().getContents();
			if (!contents.isEmpty()) {
				EObject rootObject = contents.get(0);				
				if (rootObject instanceof DAnalysis) {
					return (DAnalysis)rootObject;
				}
			}
		}
		return null;
	}
}
