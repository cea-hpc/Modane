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

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

public class EmfUmlExporter {
	private static final String EMFUML2XMI_ENV = "EMFUML2XMI_COMMAND";
	private static final String EXPORT_ROOT_DIR = "tests";
	private static final String OUTDIR_DIR = "emf";

	/**
	 * Recherche tous les fichiers mdzip contenus dans l'arborescence
	 * EXPORT_ROOT_DIR et exporte au format EMF-UML. Le résultat de l'export se
	 * trouve dans un répertoire OUTDIR_DIR à l'emplacement du fichier mdzip. C'est
	 * lent mais cela ne fonctionne malheureusement pas en multi-threads...
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// Get Env_Variable for EmfUml2Xmi Plugin
		String EmfUml2XmiCommand = System.getenv(EMFUML2XMI_ENV);
		if (EmfUml2XmiCommand == null)
			throw new RuntimeException("Env variable " + EMFUML2XMI_ENV
					+ " not defined in the system environment (Path for exportEMFXMI plugin)");

		// lancement de tous les exports
		File exportRootDir = new File(EXPORT_ROOT_DIR);
		List<File> mdzipFiles = findMdzipFiles(exportRootDir);
		for (File mdzip : mdzipFiles) {
			// creation du répertoire d'exportation si-nécessaire
			File exportDir = new File(mdzip.getParentFile().getAbsolutePath() + "/" + OUTDIR_DIR);
			if (!exportDir.exists())
				exportDir.mkdir();

			// exportation
			System.out.println(">>> MDZIP --> EMF UML for " + mdzip.getName() + " : " + exportDir.getAbsolutePath());
			ProcessBuilder pb = new ProcessBuilder(EmfUml2XmiCommand, "project_file=" + mdzip.getAbsolutePath(),
					"destination_dir=" + exportDir.getAbsolutePath());
			pb.redirectOutput(Redirect.INHERIT);
			pb.redirectError(Redirect.INHERIT);
			Process p = pb.start();
			int exitValue = p.waitFor();
			System.out.println("<<< MDZIP --> EMF UML for " + mdzip.getName() + " : " + exitValue);
		}
	}

	/**
	 * Retourne tous les fichiers mdzip de l'arborescence parentDirectory.
	 */
	private static List<File> findMdzipFiles(File parentDirectory) {
		ArrayList<File> mdzipFiles = new ArrayList<File>();
		if (parentDirectory.exists() && parentDirectory.isDirectory()) {
			for (File child : parentDirectory.listFiles()) {
				if (child.isDirectory())
					mdzipFiles.addAll(findMdzipFiles(child));
				else if (child.getName().endsWith(".mdzip"))
					mdzipFiles.add(child);
			}
		}
		return mdzipFiles;
	}
}
