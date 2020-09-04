/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.headless;

import java.io.File;
import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.uml2.uml.Model;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher;
import fr.cea.modane.uml.UmlToCpp;

public class Application implements IApplication
{
	/**
	 * Environment variable to get the emf2xmi Magicdraw tool.
	 * Depending on the the Magicdraw installation.
	 * Full path is needed.
	 */
	final static String EMF2XMI = "EMF2XMI";

	String cppDir = null;
	String umlDir = null;
	String mdzipFile = null;
	String umlFile = null;
	String pkgToGenerate = null;
	boolean writeCMakesFiles = false;

	/**
	 * Always return Application.EXIT_OK to avoid an unexpected message dialog window.
	 */
	@Override
	public Object start(IApplicationContext context) throws Exception
	{
		// Parse arguments and execute
		final Map<?,?> args = context.getArguments();
		final String[] appArgs = (String[])args.get("application.args");
		if (parseArgs(appArgs))
		{
			// Arguments are checked
			if (umlDir != null && mdzipFile != null)
			{
				// Step 0: check EMF2XMI_DIR environment variable
				String emf2xmiDir = System.getenv(EMF2XMI);
				if (emf2xmiDir == null)
				{
					System.out.println(EMF2XMI + " environment variable must be set with the full path to Magicdraw emf2xmi tool.");
					return Application.EXIT_OK;
				}

				// Step 1: ".mdzip" file to ".uml" file
				System.out.println(">>>>> MDZIP --> EMF UML");
				System.out.println("      emf2xmi dir     : " + emf2xmiDir);
				System.out.println("      Mdzip file      : " + mdzipFile);
				System.out.println("      Destination dir : " + umlDir);
				ProcessBuilder pb = new ProcessBuilder(emf2xmiDir, "project_file=" + mdzipFile, "destination_dir=" + umlDir);
				pb.redirectOutput(Redirect.INHERIT);
				pb.redirectError(Redirect.INHERIT);
				Process p = pb.start();
				p.waitFor();
				int exitValue = p.exitValue();
				System.out.println("        Exit value : " + exitValue);

				if (exitValue != 0)
				{
					System.out.println(">>>>> UML generation failed. Exiting...");
					return Application.EXIT_OK;
				}
				System.out.println(">>>>> UML generation ok");
				File f = new File(mdzipFile);
				umlFile = umlDir + '/' + f.getName().replace(".mdzip", ".uml");
			}

			if (umlFile != null)
			{
				// Step 2: C++ generation from a ".uml" file
				System.out.println(">>>>> Loading EMF UML resource: " + umlFile);
				UmlToCpp umlToCpp = UmlToCpp.createInstance();
				Procedure2<ModaneGeneratorMessageDispatcher.MessageType, String> printConsole = (ModaneGeneratorMessageDispatcher.MessageType type, String msg) -> { System.out.println(msg); };
				umlToCpp.getMessageDispatcher().getTraceListeners().add(printConsole);
				Model model = umlToCpp.readModel(URI.createFileURI(umlFile));
				System.out.println(">>>>> EMF UML resource loaded: " + umlFile);

				System.out.println(">>>>> Starting generation process for: " + model.getName());
				if (pkgToGenerate == null)
					umlToCpp.generate(model, cppDir, "", "", writeCMakesFiles, false);
				else
					umlToCpp.generate(model, cppDir, "", pkgToGenerate, writeCMakesFiles, false);
				System.out.println(">>>>> Generation process ended successfully for: " + model.getName());
			}
		}

		return Application.EXIT_OK;
	}

	@Override
	public void stop()
	{
		// nothing to do
	}

	private void printUsage()
	{
		System.out.println("Usage (Directories need absolute pathes and package separator is '.': A, A.B, A.B.C...):");
		System.out.println("  Generate from a '.mdzip' model: modane --cpp-dir <AXL_AND_CPP_FILES_OUTPUT_DIR> --uml-dir <UML_FILES_OUTPUT_DIR> --mdzip <MDZIP_MODEL_FILE> [--pkg <PACKAGE_NAME_TO_GENERATE>] [--cmakes]");
		System.out.println("  Generate from a '.uml'   model: modane --cpp-dir <AXL_AND_CPP_FILES_OUTPUT_DIR> --uml <UML_ROOT_MODEL_FILE> [--pkg <PACKAGE_NAME_TO_GENERATE>] [--cmakes]");
	}

	private boolean parseArgs(String[] appArgs)
	{
		boolean valid = false;

		for (int i=0 ; i<appArgs.length ; ++i)
		{
			switch (appArgs[i])
			{
			case "--cpp-dir": cppDir = appArgs[++i]; break;
			case "--uml-dir": umlDir = appArgs[++i]; break;
			case "--mdzip": mdzipFile = appArgs[++i]; break;
			case "--uml": umlFile = appArgs[++i]; break;
			case "--pkg": pkgToGenerate = appArgs[++i]; break;
			case "--cmakes": writeCMakesFiles = true; break;
			default:
			{
				System.out.println("Unknow option: " + appArgs[i]);
				printUsage();
				return false;
			}
			}
		}
		valid = (dirOK(cppDir) && (fileOK(umlFile, "uml") || (fileOK(mdzipFile, "mdzip") && dirOK(umlDir))));

		if (!valid) printUsage();
		return valid;
	}

	private boolean dirOK(String dir)
	{
		if (dir != null && dir != "")
		{
			File d = new File(dir);
			if (d.exists() && d.isDirectory()) return true;
			System.out.println("Unknow directory: " + dir);
		}
		return false;
	}

	private boolean fileOK(String fileName, String expectedExtension)
	{
		if (fileName != null && fileName != "")
		{
			if (fileName.endsWith("." + expectedExtension))
			{
				File f = new File(fileName);
				if (f.exists() && f.isFile()) return true;
				System.out.println("Unknow " + expectedExtension + " file: " + fileName);
			}
			else 
				System.out.println("Unknown file type (expected " + expectedExtension + "): " + fileName);
		}
		return false;
	}
}
