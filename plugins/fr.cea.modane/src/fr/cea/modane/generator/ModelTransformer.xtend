/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator

import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.ModaneFactory
import fr.cea.modane.modane.ModaneModel
import fr.cea.modane.modane.Module
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.Reference
import fr.cea.modane.modane.Service
import fr.cea.modane.modane.ServiceType
import fr.cea.modane.modane.Struct
import java.util.ArrayList
import java.util.List

import static extension fr.cea.modane.ModaneElementExtensions.*
import static extension fr.cea.modane.InterfaceExtensions.*

class ModelTransformer
{
	def insertDefaultService(ModaneModel model)
	{
		/* 
		 * Recherche des interfaces n'ayant aucune implémentation
		 * et creation d'un service par defaut si et seulement si
		 * l'interface (...est réellement utilisé comme une propriété et
		 * qu'elle...) est concrete. Dans le cas où elle n'est pas concrete,
		 * une classe sera créée par le générateur C++ à la place du service.
		 */
		val newServices = new ArrayList<Service>
		for (i : model.elements.filter(i | i instanceof Interface)) 
		{
			val interf = i as Interface
			if (interf.isCandidateForDefaultService)
			{
				// creation du service qui implemente l'interface
				val s = ModaneFactory::eINSTANCE.createService
				newServices += s
				// même nom que l'interface sans le I
				s.name = interf.defaultImplementationName
				s.description = "Service par défaut pour l'interface " + interf.name
				s.type = ServiceType::CASEOPTION
				s.interfaces += interf
				for (interfFunc : interf.functions)
				{
					val serviceFunc = ModaneFactory::eINSTANCE.createOverrideFunction
					serviceFunc.func = interfFunc
					s.overrideFuncs += serviceFunc
				}
			}
		}

		if (!newServices.empty) model.elements.addAll(newServices)
	}

	def insertDefaultValueForPties(ModaneModel model)
	{
		// recherche de tous les modules/services qui ont une option de type i
		// on met le service créé comme valeur par defaut
		for (elt : model.elements)
		{
			switch(elt)
			{
 				Interface : elt.properties.setDefaultValues	
				Module : elt.properties.setDefaultValues
				Service : elt.properties.setDefaultValues
				Struct : elt.properties.setDefaultValues
 			}
		}
	}

	private def setDefaultValues(List<Pty> pties)
	{
		for (p : pties.filter(t | t.type instanceof Reference && (t.type as Reference).target instanceof Interface))
		{
			if (p.defaultValue === null)
			{
				val interf = (p.type as Reference).target as Interface
				if (interf.candidateForDefaultService)
					p.defaultValue = interf.model.name + '.' + interf.defaultImplementationName
				else if (interf.allServiceRealisations.size == 1)
				{
					val service = interf.allServiceRealisations.head
					p.defaultValue = service.model.name + "." + service.name
				}
			}
		}
	}	

	private def isCandidateForDefaultService(Interface interf)
	{
		!interf.hasRealizations && interf.concrete
	}
}