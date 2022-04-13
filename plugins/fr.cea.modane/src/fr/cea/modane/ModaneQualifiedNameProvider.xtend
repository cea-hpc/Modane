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

import com.google.inject.Inject
import fr.cea.modane.modane.ModaneModel
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName

/**
 * Cette classe est nécessaire dans le cas où le ModaneModel est contenu par un Modane Project
 */
class ModaneQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider 
{
	@Inject IQualifiedNameConverter converter
	
	def QualifiedName qualifiedName(ModaneModel m)
	{
		converter.toQualifiedName(m.name)
	}
}