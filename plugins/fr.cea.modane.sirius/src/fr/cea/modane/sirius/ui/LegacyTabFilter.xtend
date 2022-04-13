/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.ui

import org.eclipse.eef.properties.ui.api.IEEFTabDescriptor
import org.eclipse.eef.properties.ui.api.IEEFTabDescriptorFilter
import org.eclipse.eef.properties.ui.legacy.internal.^extension.impl.LegacyPropertyTabItemDescriptor

class LegacyTabFilter implements IEEFTabDescriptorFilter
{
	override filter(IEEFTabDescriptor arg0)
	{
		switch arg0
		{
			LegacyPropertyTabItemDescriptor:
			{
				if (arg0.contributorId.startsWith("org.eclipse.sirius.diagram.ui")
					&& arg0.id.startsWith("property.tab.semantic"))
					return false
				if (arg0.contributorId.startsWith("org.eclipse.sirius.ui.tools.views.model.explorer")
					&& arg0.category.startsWith("default"))
					return false
			}
		}
		return true
	}
}
