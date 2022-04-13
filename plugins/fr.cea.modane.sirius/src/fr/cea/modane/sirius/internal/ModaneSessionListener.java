/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.internal;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

public class ModaneSessionListener implements SessionManagerListener {

	private LiveValidationTrigger liveValidationTrigger;

	public ModaneSessionListener() {
	}

	@Override
	public void notify(Session arg0, int arg1) {
	}

	@Override
	public void notifyAddSession(Session newSession) {
		this.liveValidationTrigger = new LiveValidationTrigger(newSession.getTransactionalEditingDomain());
		newSession.getEventBroker().addLocalTrigger(LiveValidationTrigger.IS_MODANE_CHANGE, this.liveValidationTrigger);
	}

	@Override
	public void notifyRemoveSession(Session newSession) {
		if (this.liveValidationTrigger != null) {
			newSession.getEventBroker().removeLocalTrigger(this.liveValidationTrigger);
		}
	}

	@Override
	public void viewpointDeselected(Viewpoint arg0) {
	}

	@Override
	public void viewpointSelected(Viewpoint arg0) {
	}

}
