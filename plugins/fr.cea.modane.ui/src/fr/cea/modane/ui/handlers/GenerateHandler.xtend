/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.ui.handlers

import com.google.inject.Inject
import fr.cea.modane.Utils
import fr.cea.modane.generator.ModaneGeneratorMessageDispatcher.MessageType
import fr.cea.modane.ui.ModaneConsoleFactory
import fr.cea.modane.ui.ModaneUiUtils
import fr.cea.modane.ui.dialogs.GenerateTitleDialog
import fr.cea.modane.ui.dialogs.GenerateTitleDialogOptions
import fr.cea.modane.uml.PackageExtensions
import fr.cea.modane.uml.UmlToCpp
import java.io.FileNotFoundException
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import org.eclipse.emf.common.util.URI
import org.eclipse.jface.viewers.TreeSelection
import org.eclipse.jface.window.Window
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Shell
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.uml2.uml.Model

class GenerateHandler extends AbstractHandler
{
	@Inject ModaneConsoleFactory consoleFactory

	// On devrait faire ça car le plugin.xml est prévu pour. L'instance est bien injectée.
	// Mais ensuite, la sérialization ne fonctionne pas car le scope provider n'est pas global...
	// @Inject UmlToCpp umlToCpp
	override execute(ExecutionEvent event) throws ExecutionException
	{
		val selection = HandlerUtil::getActiveMenuSelection(event)
		val shell = HandlerUtil::getActiveShell(event)
		if (shell !== null && selection !== null && selection instanceof TreeSelection)
		{
			val elt = (selection as TreeSelection).firstElement
			if (elt !== null && elt instanceof IFile) execute(elt as IFile, shell)
		}
		return selection
	}

	private def execute(IFile modelFile, Shell shell)
	{
		consoleFactory.openConsole
		consoleFactory.clearAndActivateConsole

		// lecture du modèle UML pour récupérer la liste des packages
		var Model model
		val umlToCpp = UmlToCpp::createInstance
		umlToCpp.messageDispatcher.traceListeners += [type, msg | consoleFactory.printConsole(type, msg)]
		try
		{
			consoleFactory.printConsole(MessageType.Start, "Loading EMF UML resource: " + modelFile.name)
			shell.display.syncExec([shell.cursor = shell.display.getSystemCursor(SWT.CURSOR_WAIT)])
			model = umlToCpp.readModel(URI::createPlatformResourceURI(modelFile.fullPath.toString, true))
			shell.display.syncExec([shell.cursor = null])
			consoleFactory.printConsole(MessageType.End, "EMF UML resource loaded: " + modelFile.name)
		}
		catch (Exception e)
		{
			shell.display.syncExec([shell.cursor = null])
			consoleFactory.printConsole(MessageType.Error, "EMF UML resource can not be loaded: " + modelFile.name)
			consoleFactory.printConsole(MessageType.Error, e.message)
			consoleFactory.printConsole(MessageType.Error, Utils.getStackTrace(e))
			return
		}

		// lecture des options pour initialiser la boite de dialogue
		val options = new GenerateTitleDialogOptions
		try
		{
			options.load(modelFile.propertiesFileUri)
		}
		catch (FileNotFoundException e) 
		{
			// Pas d'options sauvegardées. On met le projet par défaut
			options.outputDir = modelFile.project.locationURI.path
		}

		// affichage de la boite de dialogue
		val dialog = new GenerateTitleDialog(shell, options, PackageExtensions::getAllPackageNames(model))
		if (dialog.open == Window::OK)
		{
			// les options ont peut-être changé => sauvegarde
			options.save(modelFile.propertiesFileUri)
			modelFile.parent.refreshLocal(1, null)

			val m = model // just to have a final variable
			new Thread
			([
				try
				{
					// lancement de la génération
					consoleFactory.printConsole(MessageType.Start, "Starting generation process for: " + modelFile.name)
					var packageToGenerate = ''
					if (options.hasPackagePrefix && !options.generateAllPackages)
						packageToGenerate = options.packagePrefix + '.' + options.packageToGenerate
					else
						packageToGenerate = options.packageToGenerate

					umlToCpp.generate(m, options.outputDir, options.packagePrefix, packageToGenerate, options.writeCmakeFiles, options.writeModaneFiles)
					consoleFactory.printConsole(MessageType.End, "Generation process ended successfully for: " + modelFile.name)
					ModaneUiUtils::refreshResourceDir(modelFile, options.outputDir)
				}
				catch (Exception e)
				{
					consoleFactory.printConsole(MessageType.Error, "Generation process failed for: " + modelFile.name)
					consoleFactory.printConsole(MessageType.Error, e.message)
					consoleFactory.printConsole(MessageType.Error, Utils::getStackTrace(e))
					return
				}
			]).start
		}
	}

	private def getPropertiesFileUri(IFile modelFile)
	{
		modelFile.locationURI.path.replace(".uml", ".properties")
	}
}