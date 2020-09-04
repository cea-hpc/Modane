/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius;

import org.eclipse.emf.common.util.URI;
import org.eclipse.sirius.business.api.resource.strategy.AbstractResourceStrategyImpl;

public class ModaneResourceStrategy extends AbstractResourceStrategyImpl 
{
	@Override
	public boolean isPotentialSemanticResource(URI uri)
	{
		boolean result = super.isPotentialSemanticResource(uri);
		if (result && uri != null)
		{
			String extension = uri.fileExtension();
			result = !("uml".equals(extension) || "xsd".equals(extension));
		}
		return result;
	}

	@Override
	public boolean canHandle(URI resourceURI, ResourceStrategyType resourceStrategyType)
	{
		return ResourceStrategyType.SEMANTIC_RESOURCE.equals(resourceStrategyType);
	}
}
