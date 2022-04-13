/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.handlers

import fr.cea.modane.Utils
import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher.MessageType
import fr.cea.modane.generator.StandaloneGenerator
import fr.cea.modane.generator.cmake.CMakeListsGenerator
import fr.cea.modane.modaneproject.ModaneProject
import fr.cea.modane.modaneproject.Package
import fr.cea.modane.modaneproject.PackagesContainer
import fr.cea.modane.ui.ModaneConsoleFactory
import fr.cea.modane.ui.internal.ModaneActivator
import java.util.ArrayList
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.Diagnostician
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.jface.viewers.TreeSelection
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Shell
import org.eclipse.ui.PartInitException
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.handlers.HandlerUtil

import static extension fr.cea.modane.project.PackagesContainerExtensions.*

class GenerateCodeHandler extends AbstractHandler
{
	static val PROBLEMS_VIEW_ID = "org.eclipse.ui.views.ProblemView"

	override execute(ExecutionEvent event) throws ExecutionException
	{
		val selection = HandlerUtil::getActiveMenuSelection(event)
		if (selection !== null && selection instanceof TreeSelection)
		{
			val elt = (selection as TreeSelection).firstElement
			if (elt instanceof EObject && elt instanceof PackagesContainer)
			{
				val pc = elt as PackagesContainer
				val shell = HandlerUtil::getActiveShell(event)
				if (pc.valid)
					pc.generate(shell)
				else
				{
					try { PlatformUI.workbench.activeWorkbenchWindow.activePage.showView(PROBLEMS_VIEW_ID) }
					catch (PartInitException e) { e.printStackTrace }
					MessageDialog::openError(shell, "Validation", "Le modèle est invalide. Les erreurs sont visibles dans la vue 'Problems'.")
				}
			}
		}
		return selection
	}

	private def generate(PackagesContainer pc, Shell shell)
	{
		val inj = ModaneActivator.instance.getInjector(ModaneActivator.FR_CEA_MODANE_MODANE)
		val ModaneConsoleFactory consoleFactory = if (inj === null) null else inj.getInstance(ModaneConsoleFactory)
		consoleFactory?.openConsole
		consoleFactory?.clearAndActivateConsole

		new Thread
		([
			val project = pc.modaneProject
			val srcDirName = project.srcDir
			if (srcDirName.nullOrEmpty)
					consoleFactory?.printConsole(MessageType.Error, "Unknown generation directory. Fill it in the Properties View of the Modane Project")
			else
			{
				val rootWs = ResourcesPlugin::workspace.root
				val srcDir = rootWs.findMember(srcDirName)
				if (srcDir === null)
				{
					consoleFactory?.printConsole(MessageType.Error, "Invalid generation directory: " + srcDirName + ". Correct it in the Properties View of the Modane Project")
				}
				else
				{
					try
					{
						consoleFactory?.printConsole(MessageType.Start, "Starting generation process for: " + pc.name)
						val absoluteOutputPath = srcDir.location.toOSString	
						val codeGenerator = StandaloneGenerator.createInstance
						if (consoleFactory !== null)
							codeGenerator.messageDispatcher.traceListeners += [type, msg | consoleFactory.printConsole(type, msg)]
						codeGenerator.fsa.initialize(absoluteOutputPath)
						val cMakeGenerator = new CMakeListsGenerator
						shell.display.syncExec([shell.cursor = shell.display.getSystemCursor(SWT.CURSOR_WAIT)])
						pc.generate(project.generateCMakeLists, codeGenerator, cMakeGenerator)
						shell.display.syncExec([shell.cursor = null])
						consoleFactory?.printConsole(MessageType.End, "Generation process ended successfully for: " + pc.name)
						srcDir.refreshLocal(IResource::DEPTH_INFINITE, null)
					}
					catch (Exception e)
					{
						shell.display.syncExec([shell.cursor = null])
						consoleFactory?.printConsole(MessageType.Error, "Generation process failed for: " + pc.name)
						consoleFactory?.printConsole(MessageType.Error, e.message)
						consoleFactory?.printConsole(MessageType.Error, Utils::getStackTrace(e))
					}
				}
			}
		]).start
	}

	private def isGenerateCMakeLists(ModaneProject it) { !arcaneHome.nullOrEmpty }

	private def dispatch boolean generate(ModaneProject p, boolean generateCMakeLists, StandaloneGenerator codeGenerator, CMakeListsGenerator cMakeGenerator)
	{
		val cmakeSubPackages = new ArrayList<String>
		for (subP : p.subPackages)
			if (subP.generate(generateCMakeLists, codeGenerator, cMakeGenerator))
				cmakeSubPackages += subP.name

		// on génère le fichier root même si pas de sous-packages
		if (generateCMakeLists)
			cMakeGenerator.generateRoot(codeGenerator.fsa, p.name, p.arcaneHome, cmakeSubPackages)

		return generateCMakeLists
	}

	/* 
	 * Retourne vrai si un fichier CMakeLists.txt doit être généré pour le package p. 
	 * C'est vrai si le package a des fichiers C++ ou des sous-packages pour lequels la méthode retourne vrai.
	 */
	private def dispatch boolean generate(Package p, boolean generateCMakeLists, StandaloneGenerator codeGenerator, CMakeListsGenerator cMakeGenerator)
	{
		var mustHaveCMakeFile = false

		val cmakeSubPackages = new ArrayList<String>
		for (subP : p.subPackages)
			if (subP.generate(generateCMakeLists, codeGenerator, cMakeGenerator))
				cmakeSubPackages += subP.name

		val model = p.model
		if (model !== null )
		{
			val cmakeFiles = codeGenerator.generate(model)
			if (generateCMakeLists)
				if (!cmakeFiles.empty || !cmakeSubPackages.empty)
				{
					cMakeGenerator.generate(codeGenerator.fsa, p.fullyQualifiedName, cmakeSubPackages, cmakeFiles)
					mustHaveCMakeFile = true
				}
		}

		return mustHaveCMakeFile
	}

	private def isValid(PackagesContainer pc)
	{
		val diagnostic = Diagnostician.INSTANCE.validate(pc)
		return !(diagnostic.severity == Diagnostic::ERROR || diagnostic.severity == Diagnostic::WARNING)
	}
}