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

import java.io.File;

public class ServiceTestCase extends TestCaseBase
{
	private final static String Dir = "Service";

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
	public void makeFullClean()
	{
		for (File f : getAllFiles(Dir))
		{
			if (f.getName().matches("__(.*).h")
					|| f.getName().matches("(.*).axl")
					|| f.getName().matches("(.*).(.*)nabla")
					|| f.getName().matches("CompriService.(.*)")
					|| f.getName().matches("Compri2Service.(.*)")
					|| f.getName().matches("AnotherConcreteFaceDefaultService.(.*)")
					|| f.getName().matches("HydroModule.(.*)")
					|| f.getName().matches("AfaceDefault.(.*)")
					|| f.getName().matches("OrnythorinqueService.(.*)")
					|| f.getName().matches("SingletonDefaultService.(.*)")
					|| f.getName().matches("TrackingDefaultService.(.*)")
					)
				f.delete();
		}
	}
}
