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

public class UnitTestTestCase extends TestCaseBase
{
	private final static String Dir = "UnitTest";

	@Override
	public void testGeneration()
	{
		makeFullClean();
		testGenerationFromModaneModel(Dir, new String[] {"UnitTest"});
	}

	@Override
	public void testCompilation()
	{
		testGenerationAndCompilationFromModaneModel(Dir, new String[] {"UnitTest"});
		assertEquals(0, launchCommand("./UnitTest ./UnitTest.arc", Dir, Dir));
	}

	@Override
	protected void makeFullClean()
	{
		for (File f : getAllFiles(Dir))
		{
			if (f.getName().matches("__(.*).h")
					|| f.getName().matches("(.*).axl")
					|| f.getName().matches("(.*)_axl.h")
					|| f.getName().matches("PerfectGasService.(.*)")
					|| f.getName().matches("StiffenedGasService.(.*)")
					|| f.getName().matches("HydroModule.(.*)")
					|| f.getName().matches("MyEosDelegation.(.*)")
					)
				f.delete();
		}
	}
}
