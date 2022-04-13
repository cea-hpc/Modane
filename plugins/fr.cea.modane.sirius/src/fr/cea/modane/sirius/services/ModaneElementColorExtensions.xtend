/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.services

import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.ModaneModel
import java.util.Properties
import org.eclipse.core.resources.IProject

/** 
 * Retourne la couleur du package d'un élément du modèle.
 * Le projet est stocké pour éviter de relire le fichier de propriétés si ce n'est pas nécessaire
 */
class ModaneElementColorExtensions
{
	static val PackageColors = #[ '29,210,175', '25,182,152', '64,212,126', '46,204,113', '39,174,96', '44,195,107', '22,160,133', '26,188,156',
								  '74,163,223', '46,142,206', '242,202,39', '244,166,42', '233,139,57', '236,94,0', '234,97,83', '241,196,15',
								  '243,156,18', '230,126,34', '211,84,0', '231,76,60', '209,66,51', '251,252,252', '203,208,211', '163,177,178',
								  '140,152,153', '192,57,43', '236,240,241', '189,195,199', '149,165,166', '127,140,141', '255,51,166', '52,73,94',
								  '53,75,96', '61,86,110', '44,62,80', '176,51,255', '155,89,182', '142,68,173', '155,80,186', '166,107,190', 
								  '41,128,185', '52,152,219', '51,157,255', '30,15,190', '102,0,153']
 
	static val PtyFileName = 'packagecolors.properties'
	static val pties = new Properties
	static var IProject project
	
	static def getPackageColor(ModaneElement it)  
	{ 
		elementProject.loadPties
		val cs =  packageColorString.split(',').map[s | Integer.parseInt(s.trim)]
		Utils::getColor(cs.get(0), cs.get(1), cs.get(2))
	}
	
	private static def loadPties(IProject p)
	{
		if (project != p)
		{
			project = p
			val ptyFile = project.getFile(PtyFileName)
			if (ptyFile.exists) pties.load(ptyFile.contents)
		}
	}
	
	private static def getElementProject(ModaneElement it)
	{
		val workspaceFile = fr.cea.modane.Utils::toEclipseResource(eResource)
		if (workspaceFile === null) null
		else workspaceFile.project		
	}
	
	private static def getPackageColorString(ModaneElement it) 
	{
		pties.getProperty(packageName, defaultPackageColorString)
	}
	
	private static def getDefaultPackageColorString(ModaneElement it)
	{
		PackageColors.get(Math::abs(packageName.hashCode) % PackageColors.size)
	}
	
	private static def getPackageName(ModaneElement it) 
	{ 
		(eContainer as ModaneModel).name
	}
}
