/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane

import java.util.ArrayList
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IResourceVisitor
import org.eclipse.core.runtime.CoreException
import org.eclipse.xtend.lib.annotations.Accessors

class ModaneResourceVisitor implements IResourceVisitor
{
	@Accessors(PUBLIC_GETTER) val modaneFiles = new ArrayList<IResource>
	
	override visit(IResource resource) throws CoreException 
	{
		if (resource.name.endsWith(".modane"))
			modaneFiles.add(resource)	
		else if (resource.name.equals("bin"))
			return false
			
		return true
	}
}