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

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.Model;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import fr.cea.modane.generator.StandaloneGenerator;
import fr.cea.modane.uml.UmlToCpp;

public abstract class TestCaseBase
{
	static final String TestBaseHome = "tests/";
	static final String GenFolder = TestBaseHome + "fr.cea.modane.tests/tests/";
	static GitUtils git;

	protected int launchCommand(String cmd, String testName, String packageName)
	{
		int exitValue = -1;
		try
		{
			// lancement de la commande
			System.out.println("[" + cmd + "] - cas test : " + testName);
			String pathName = (packageName == null ? getRelativeSrcDir(testName) : getRelativeSrcDir(testName) + "/" + packageName);
			File path = new File(pathName);
			Process p = Runtime.getRuntime().exec(cmd, null, path);

			// ecriture a l'ecran du flux standard
			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			BufferedReader bf = new BufferedReader(isr);
			String line;
			while ((line = bf.readLine()) != null)
				System.out.println(line);

			// ecriture a l'ecran du flux erreur
			isr = new InputStreamReader(p.getErrorStream());
			bf = new BufferedReader(isr);
			line = bf.readLine();
			while ((line = bf.readLine()) != null)
				System.out.println(line);

			// retour du process
			p.waitFor();
			exitValue = p.exitValue();
			System.out.println("[" + cmd + "] - retour : " + exitValue);
			System.out.println();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return exitValue;
	}

	private void generateFromUmlModel(String testName)
	{
		UmlToCpp umlToCpp = UmlToCpp.createInstance();
		Model model = umlToCpp.readModel(getUmlModelFileURI(testName));
		umlToCpp.generate(model, getAbsoluteSrcDir(testName), null, null, false, false);
	}

	private void generateFromModaneModel(String testName, String[] modaneFileNames)
	{
		StandaloneGenerator generator = StandaloneGenerator.createInstance();
		for (String modaneFileName : modaneFileNames)
			generator.generate(getModaneModelFileURI(testName, modaneFileName), getAbsoluteSrcDir(testName), null);
	}

	protected void testGenerationFromUmlModel(String testName)
	{
		initGitRepository();
		generateFromUmlModel(testName);
		git.testNoGitDiff(GenFolder + testName + "/src");
	}

	protected void testGenerationFromModaneModel(String testName, String[] modaneFileNames)
	{
		initGitRepository();
		generateFromModaneModel(testName, modaneFileNames);
		git.testNoGitDiff(GenFolder + testName + "/src");
	}

	protected void testGenerationAndCompilationFromUmlModel(String testName)
	{
		assertEquals(0, launchCommand("cmake .", testName, testName));
		assertEquals(2, launchCommand("make fullclean", testName, testName));
		generateFromUmlModel(testName);
		assertEquals(0, launchCommand("make", testName, testName));
	}

	protected void testGenerationAndCompilationFromModaneModel(String testName, String[] modaneFileNames)
	{
		assertEquals(0, launchCommand("cmake .", testName, testName));
		assertEquals(2, launchCommand("make fullclean", testName, testName));
		generateFromModaneModel(testName, modaneFileNames);
		assertEquals(0, launchCommand("make", testName, testName));
	}

	protected String getRelativeSrcDir(String testName) { return TestBaseHome + testName + "/src"; }
	protected String getAbsoluteSrcDir(String testName) { return (new File(getRelativeSrcDir(testName)).getAbsolutePath()); }
			
	protected URI getUmlModelFileURI(String testName)
	{
		//System.out.println("umlModelURI = " + buildURI(testName + "/emf/" + testName + ".uml"));
		return buildURI(testName + "/emf/" + testName + ".uml");
	}

	protected URI getModaneModelFileURI(String testName, String modaneFileName)
	{
		return buildURI(testName + "/" + modaneFileName + ".modane");
	}

	private URI buildURI(String fileRelativePath)
	{
		String filePath = new File(TestBaseHome + fileRelativePath).getAbsolutePath();
		URI uri = URI.createFileURI(new File(filePath).getAbsolutePath());
		return uri;
	}

	private void initGitRepository()
	{
		String testProjectPath = System.getProperty("user.dir");
		String wsPath = testProjectPath + "/../../";
		git = new GitUtils(wsPath);
	}

	protected List<File> getAllFiles(String testName)
	{
		return FileUtils.listAllFiles(getRelativeSrcDir(testName)+"/"+testName);
	}

	@Category(GenerationTests.class)
	@Test
	public abstract void testGeneration();

	@Category(CompilationTests.class)
	@Test
	public abstract void testCompilation();

	protected abstract void makeFullClean();
}