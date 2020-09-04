/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.fragmentation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.NotificationFilter.Custom;

import fr.cea.modane.modane.ModanePackage;
import fr.cea.modane.modaneproject.ModaneprojectPackage;

public class FragmentationNotificationFilter extends Custom 
{
	@Override
	public boolean matches(Notification notification) 
	{
		// The fragmentation process will be triggered on modifications about these features
		Object feature = notification.getFeature();
		return (ModaneprojectPackage.eINSTANCE.getPackagesContainer_SubPackages().equals(feature)
				|| ModaneprojectPackage.eINSTANCE.getPackage_Model().equals(feature)
				|| ModaneprojectPackage.eINSTANCE.getPackagesContainer_Name().equals(feature)
				|| ModanePackage.eINSTANCE.getNamedElement_Name().equals(feature));
	}
}
