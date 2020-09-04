/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.tests;

import static org.junit.Assert.fail;

import java.io.File;

import org.eclipse.uml2.uml.Model;
import org.eclipse.xtext.util.Arrays;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import fr.cea.modane.uml.UmlToCpp;

public class PartialGenTestCase extends TestCaseBase
{
	private final static String ModelName = "PartialGen";
	private final static File Level1Folder = new File("tests/" + ModelName + "/src/level1");

	@Category(GenerationTests.class)
	@Test
	public void testGenerateLevel3()
	{
		makeFullClean();

		UmlToCpp umlToCpp = UmlToCpp.createInstance();
		Model model = umlToCpp.readModel(getUmlModelFileURI(ModelName));
		umlToCpp.generate(model, getAbsoluteSrcDir(ModelName), null, "level1.level2.level3", false, false);

		// il faut vérifier qu'il n'y a eu aucun fichier créé au niveau 1
		for (File f : Level1Folder.listFiles())
			if (f.isFile() && !f.getName().equals("Makefile"))
				fail();

		// il faut vérifier que le service est présent au niveau 3
		File level3Folder = new File("tests/" + ModelName + "/src/level1/level2/level3");
		String[] files = level3Folder.list();
		if (!Arrays.contains(files, "MyLevel3Service.h") || !Arrays.contains(files, "MyLevel3Service.cc") || !Arrays.contains(files, "MyLevel3.axl"))
			fail();
	}

	@Category(GenerationTests.class)
	@Test
	public void testGenerateLevel1()
	{
		makeFullClean();

		UmlToCpp umlToCpp = UmlToCpp.createInstance();
		Model model = umlToCpp.readModel(getUmlModelFileURI(ModelName));
		umlToCpp.generate(model, getAbsoluteSrcDir(ModelName), null, "level1", false, false);

		// il faut vérifier que le service est présent au niveau 1
		String[] files = Level1Folder.list();
		if (!Arrays.contains(files, "MyLevel1Module.h") || !Arrays.contains(files, "MyLevel1Module.cc") || !Arrays.contains(files, "MyLevel1.axl"))
			fail();

		// il faut vérifier que le service est présent au niveau 3
		File level3Folder = new File("tests/" + ModelName + "/src/level1/level2/level3");
		files = level3Folder.list();
		if (!Arrays.contains(files, "MyLevel3Service.h") || !Arrays.contains(files, "MyLevel3Service.cc") || !Arrays.contains(files, "MyLevel3.axl"))
			fail();
	}

	@Override
	public void testGeneration()
	{
		//cf testGenerateLevel1 & testGenerateLevel3
	}

	@Override
	public void testCompilation()
	{
		//No Compilation
	}

	@Override
	protected void makeFullClean()
	{
		for (File f : FileUtils.listAllFiles(getRelativeSrcDir(ModelName)))
		{
			if (f.getName().matches("(.*).h")
					|| f.getName().matches("(.*).axl")
					|| f.getName().matches("(.*).cc")
					|| f.getName().matches("(.*).modane")
					)
				f.delete();
		}
	}
}
