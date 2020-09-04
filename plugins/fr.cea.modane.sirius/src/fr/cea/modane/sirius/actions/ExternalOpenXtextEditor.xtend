/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.actions

import fr.cea.modane.modane.EntryPoint
import fr.cea.modane.modane.Function
import fr.cea.modane.modane.ModanePackage
import fr.cea.modane.ui.ModaneUiUtils
import java.util.Collection
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction

/** Utilisé dans la fenêtre de propriété pour ouvrir l'éditeur sur la liste des arguments */
class ExternalOpenXtextEditor implements IExternalJavaAction 
{
	static val PARAMETER_ARGS = 'ArgsFeature' 
	static val PARAMETER_VARS = 'VarsFeature'
	val utils = new ModaneUiUtils
	
	override canExecute(Collection<? extends EObject> selections) 
	{
		selections.exists[o|o.eClass.EPackage == ModanePackage::eINSTANCE]
	}
	
	override execute(Collection<? extends EObject> selections, Map<String, Object> parameters) 
	{
		for (o : selections.filter[x | x.eClass.EPackage == ModanePackage::eINSTANCE])
			switch o
			{
				Function case parameters.containsKey(PARAMETER_ARGS) : 
					utils.openXtextEditor(o, ModanePackage::eINSTANCE.function_Args)
				Function case parameters.containsKey(PARAMETER_VARS) : 
					utils.openXtextEditor(o, ModanePackage::eINSTANCE.function_Vars)
				EntryPoint case parameters.containsKey(PARAMETER_VARS) : 
					utils.openXtextEditor(o, ModanePackage::eINSTANCE.entryPoint_Vars)
				default:
					utils.openXtextEditor(o)
			}
	}
}