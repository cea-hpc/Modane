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

import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSelector;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSession;

public class ModaneAnalysisSelectorProvider
		implements org.eclipse.sirius.business.api.session.danalysis.DAnalysisSelectorProvider {

	public ModaneAnalysisSelectorProvider() {
	}

	@Override
	public boolean provides(DAnalysisSession session) {
		return true;
	}

	@Override
	public DAnalysisSelector getSelector(DAnalysisSession session) {
		return new ModaneAnalysisSelector();
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}
}
