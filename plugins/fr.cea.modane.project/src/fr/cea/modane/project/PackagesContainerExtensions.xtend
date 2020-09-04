/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
 package fr.cea.modane.project

import fr.cea.modane.modane.ModaneModel
import fr.cea.modane.modaneproject.Package
import fr.cea.modane.modaneproject.ModaneProject
import fr.cea.modane.modaneproject.PackagesContainer

class PackagesContainerExtensions 
{
	static def getAllModaneModels(PackagesContainer it)
	{
		eAllContents.filter(ModaneModel).toList
	}
	
	static def ModaneProject getModaneProject(PackagesContainer pc)
	{
		if (pc === null) null
		else switch pc
		{ 
			ModaneProject : pc
			Package : (pc.eContainer as PackagesContainer).modaneProject
			default : null
		}	 
	}
}