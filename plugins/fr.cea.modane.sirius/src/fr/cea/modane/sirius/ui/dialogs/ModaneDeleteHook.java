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
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.sirius.business.api.delete.IDeleteHook;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

public class ModaneDeleteHook implements IDeleteHook {

	@Override
	public IStatus beforeDeleteCommandExecution(Collection<DSemanticDecorator> selectedMappings, Map<String, Object> parameters) {
		ConfirmDeletionServices services = new ConfirmDeletionServices();
		boolean showConfirmationDeletionDialog = services.showConfirmationDeletionDialog(selectedMappings);
		if (showConfirmationDeletionDialog) {
			return Status.OK_STATUS;
		}
		return Status.CANCEL_STATUS;
	}
}
