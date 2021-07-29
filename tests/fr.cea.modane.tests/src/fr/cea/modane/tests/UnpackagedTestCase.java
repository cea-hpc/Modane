/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.eclipse.uml2.uml.Model;

import fr.cea.modane.uml.UmlToCpp;

public class UnpackagedTestCase extends TestCaseBase
{
	private final static String Dir = "Unpackaged";
	
	@Override
	public void testGeneration()
	{
		makeFullClean();
		UmlToCpp umlToCpp = UmlToCpp.createInstance();
		Model model = umlToCpp.readModel(getUmlModelFileURI(Dir));
		umlToCpp.generate(model, getAbsoluteSrcDir(Dir), null, null, false, false);
	}

	@Override
	public void testCompilation()
	{
		assertEquals(0, launchCommand("cmake .", Dir, null));
		assertEquals(2, launchCommand("make fullclean", Dir, null));
		UmlToCpp umlToCpp = UmlToCpp.createInstance();
		Model model = umlToCpp.readModel(getUmlModelFileURI(Dir));
		umlToCpp.generate(model, getAbsoluteSrcDir(Dir), null, null, false, false);
		assertEquals(0, launchCommand("make", Dir, null));
	}

	@Override
	protected void makeFullClean()
	{
		for (File f : FileUtils.listAllFiles(getRelativeSrcDir(Dir)))
		{
			if (f.getName().matches("__(.*).h")
					|| f.getName().matches("(.*).axl")
					|| f.getName().matches("(.*)_axl.h")
					|| f.getName().matches("HydroModule.(.*)")
				)
				f.delete();
		}
	}
}
