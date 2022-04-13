/*******************************************************************************
 * Copyright (c) 2022 CEA
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

public class SupportTestCase extends TestCaseBase
{
	private final static String Dir = "Support";

	@Override
	public void testGeneration()
	{
		makeFullClean();
		testGenerationFromUmlModel(Dir);
	}

	@Override
	public void testCompilation()
	{
		testGenerationAndCompilationFromUmlModel(Dir);
	}

	@Override
	public void testExecution()
	{
		testGenerationAndCompilationFromUmlModel(Dir);
		assertEquals(0, run("./build/Hydro -arcane_opt max_iteration 1 ./Support.arc", Dir));
	}

	@Override
	public void makeFullClean()
	{
		for (File f : getAllFiles(Dir))
		{
			if (f.getName().matches("__(.*).h")
					|| f.getName().matches("(.*).axl")
					)
				f.delete();
		}
	}
}
