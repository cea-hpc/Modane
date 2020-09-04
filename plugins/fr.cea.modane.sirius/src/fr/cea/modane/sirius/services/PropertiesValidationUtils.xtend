/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.services

import fr.cea.modane.ModaneStandaloneSetupGenerated
import fr.cea.modane.modane.EnumerationLiteral
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.ServiceOrModule
import fr.cea.modane.validation.ModaneValidator

class PropertiesValidationUtils 
{
	/* ----- FRENCH NAME ----- */
	
	// On doit garder cette règle car son équivalent dans ModaneValidator nécessite d'injecter le scopeProvider
	// NB attention à l'ordre des extensions dans le odesign.
	// PropertiesValidationUtils doit être en dessous de ModaneValiator !

	def checkUniqueNameFr(ServiceOrModule sorm)
	{
		val injector = new ModaneStandaloneSetupGenerated().createInjectorAndDoEMFRegistration
		val modaneValidator = injector.getInstance(ModaneValidator)
		modaneValidator.checkUniqueNameFr(sorm)
	}

	def checkUniqueNameFr(Pty pty)
	{
		val injector = new ModaneStandaloneSetupGenerated().createInjectorAndDoEMFRegistration
		val modaneValidator = injector.getInstance(ModaneValidator)
		modaneValidator.checkUniqueNameFr(pty)
	}

	def checkUniqueNameFr(EnumerationLiteral el)
	{
		val injector = new ModaneStandaloneSetupGenerated().createInjectorAndDoEMFRegistration
		val modaneValidator = injector.getInstance(ModaneValidator)
		modaneValidator.checkUniqueNameFr(el)
	}
}