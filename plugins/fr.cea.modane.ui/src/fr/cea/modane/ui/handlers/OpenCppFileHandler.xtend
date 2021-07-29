/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.ui.handlers

import com.google.inject.Inject
import fr.cea.modane.ModaneOutputConfigurationProvider
import fr.cea.modane.Utils
import fr.cea.modane.generator.GenerationOptionsUtils
import fr.cea.modane.generator.cpp.ModuleCppMethodContainer
import fr.cea.modane.generator.cpp.ServiceCppMethodContainer
import fr.cea.modane.modane.EntryPoint
import fr.cea.modane.modane.Function
import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.Module
import fr.cea.modane.modane.OverrideFunction
import fr.cea.modane.modane.Service
import fr.cea.modane.ui.ModaneUiUtils
import java.util.ArrayList
import java.util.regex.Pattern
import org.eclipse.cdt.core.CCorePlugin
import org.eclipse.cdt.core.dom.ast.IFunction
import org.eclipse.cdt.core.index.IIndex
import org.eclipse.cdt.core.index.IIndexName
import org.eclipse.cdt.core.index.IndexFilter
import org.eclipse.cdt.core.model.CoreModel
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.text.TextSelection
import org.eclipse.jface.viewers.TreeSelection
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.ui.ide.IDE
import org.eclipse.ui.texteditor.ITextEditor
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode

import static extension fr.cea.modane.ModaneElementExtensions.*
import static extension fr.cea.modane.generator.cpp.CppMethodContainerExtensions.*

/**
 * Permet d'ouvrir le fichier C++ 'développeur' (non généré à 100%) associé à un élément de modèle de type Service, Module ou Family.
 * Si l'objet sélectionné est de type 'Function' ou 'OverrideFunction', l'éditeur sera positionné au bon endroit.
 */
class OpenCppFileHandler extends AbstractHandler
{
	@Inject EclipseOutputConfigurationProvider configurationProvider
	@Inject GenerationOptionsUtils goUtils

	override execute(ExecutionEvent event) throws ExecutionException
	{
		val selection = HandlerUtil::getCurrentSelection(event)
		if (selection !== null)
		{
			// sélection dans l'éditeur
			if (selection instanceof TextSelection)
			{
				execute(selection.offset)
			}
			// sélection dans l'outline
			else if (selection instanceof TreeSelection && (selection as TreeSelection).firstElement instanceof EObjectNode)
			{
				val elt = (selection as TreeSelection).firstElement as EObjectNode
				if (elt !== null) 
				{
					val text = elt.fullTextRegion
					execute(text.offset)
				}
			}
		}
		return selection
	}

	private def execute(int offset)
	{
		val doc = ModaneUiUtils::activeXtextEditor.document
		val elt = ModaneUiUtils::findModaneElementOrModel(doc, offset)
		
		if (elt !== null && elt instanceof ModaneElement)
		{
			// on recherche le fichier Eclipse associé pour retrouver le projet et les options de génération 
			val resource = Utils::toEclipseResource(elt.eResource)
			if (resource !== null)
			{
				// Recherche des options de génération pour retrouver le répertoire de sortie
				// et ouverture du fichier
				val modaneElt = elt as ModaneElement
				val selectedElt = ModaneUiUtils::findEObject(doc, offset)
				val initialRoot = ResourcesPlugin::workspace.root.location.toString
				val options = goUtils.createGenerationOptionsFor(initialRoot, modaneElt.model)
				val cppFileName = modaneElt.cppFileName
				val cppFile = createIFile(resource.project, modaneElt.outputPath, cppFileName)
				val cppEditor = cppFile.tryToOpenFile

				// Liaison avec le CDT : tentative du positionnement de l'éditeur sur l'élément
				if (cppFile !== null && cppEditor !== null && selectedElt !== null && selectedElt.functionOrEntryPoint)
				{
					val cproject = CoreModel::getDefault.getCModel.getCProject(resource.project.name)
					val manager = CCorePlugin::indexManager
					val index = manager.getIndex(cproject)
					try 
					{
						index.acquireReadLock
						val selectedIndexes = filterBindings(index, selectedElt, modaneElt, options.variableAsArgs)
						val hIndexName = selectedIndexes.findFirst[n | n.fileLocation.fileName.endsWith(cppFile.fullPath.toString)]
						if (hIndexName !== null) (cppEditor as ITextEditor).selectAndReveal(hIndexName.nodeOffset, 0)
					} 
					catch (Exception e)
					{
						e.printStackTrace
					} 
					finally
					{
						if (index !== null) index.releaseReadLock
					}
				}
			}
		}
	}

	private def IEditorPart tryToOpenFile(IFile file)
	{
		if (file !== null && file.exists)
		{
			val workbenchPage = PlatformUI::workbench.activeWorkbenchWindow.activePage
			return IDE::openEditor(workbenchPage, file)
		}	
		return null
	}

	private def createIFile(IProject project, String outputPath, String fileName)
	{
		val confs = configurationProvider.getOutputConfigurations(project)
		val srcDir = confs.findFirst[x | x.name == ModaneOutputConfigurationProvider::GEN_ONCE_OUTPUT].outputDirectory

		if (srcDir !== null && outputPath !== null && fileName !== null)
		{
			val file = project.getFile(srcDir + '/' + outputPath + '/' + fileName)
			if (file.exists) return file
		}	
		return null
	}

	private def isFunction(EObject elt) { elt instanceof Function || elt instanceof OverrideFunction }
	private def isFunctionOrEntryPoint(EObject elt) { elt.function || elt instanceof EntryPoint }
	private def dispatch getCppFileName(Module m) { new ModuleCppMethodContainer(m).developerBodyFileName }
	private def dispatch getCppFileName(Service m) { new ServiceCppMethodContainer(m).developerBodyFileName }
	private def dispatch getCppFileName(ModaneElement elt) { null } // pas de fichier utilisateur pour les autres objets

	/**
	 * Retourne la liste des index pour les bindings de type 'IFunction' de owner 'parentElement' ayant les mêmes paramètres que 'selectedFunction'.
	 * Modane ne permet pas la surcharge de fonction mais le développeur peut le faire dans le C++.
	 */
	private def dispatch ArrayList<IIndexName> filterBindings(IIndex index, Function selectedFunction, ModaneElement parentElement, boolean variableAsArgs)
	{
		val pattern = Pattern::compile(selectedFunction.name)
		val bindings = index.findBindings(pattern, false, IndexFilter::ALL, null).filter[b | b.owner.name.startsWith(parentElement.name)]
		val indexNames = new ArrayList<IIndexName>
		
		for (binding : bindings)
		{
			// Filtrage sur les éléments fonctions ayant les mêmes paramètres.
			//
			if (binding instanceof IFunction)
			{
				val bindingFunction = binding as IFunction
				if (checkArgs(bindingFunction, selectedFunction))
				{ 
					val indexName = index.findNames(bindingFunction, IIndex::FIND_DEFINITIONS)
					if (indexName !== null) indexNames.addAll(indexName)
				}
			}
		}

		return indexNames
	}

	private def dispatch ArrayList<IIndexName> filterBindings(IIndex index, OverrideFunction selectedFunction, ModaneElement parentElement, boolean variableAsArgs)
	{
		filterBindings(index, selectedFunction.func, parentElement, variableAsArgs)
	}

	private def dispatch ArrayList<IIndexName> filterBindings(IIndex index, EObject selectedElt, ModaneElement parentElement, boolean variableAsArgs)
	{
		new ArrayList<IIndexName>
	}

	/**
	 * Retourne la liste des index pour les bindings de type 'IFunction' de owner 'parentElement' ayant les mêmes paramètres que 'selectedEntryPoint'.
	 * Modane ne permet pas la surcharge de fonction mais le développeur peut le faire dans le C++.
	 */
	private def dispatch ArrayList<IIndexName> filterBindings(IIndex index, EntryPoint selectedEntryPoint, ModaneElement parentElement, boolean variableAsArgs)
	{
		val pattern = Pattern::compile(selectedEntryPoint.name)
		val bindings = index.findBindings(pattern, false, IndexFilter::ALL, null).filter[b | b.owner.name.startsWith(parentElement.name)]
		val indexNames = new ArrayList<IIndexName>

		for (binding : bindings)
		{
			// Filtrage sur les éléments fonctions ayant les mêmes paramètres.
			//
			if (binding instanceof IFunction)
			{
				val bindingFunction = binding as IFunction
				if (checkArgs(bindingFunction, variableAsArgs))
				{ 
					val indexName = index.findNames(bindingFunction, IIndex::FIND_DEFINITIONS)
					if (indexName !== null) indexNames.addAll(indexName)
				}
			}
		}

		return indexNames;
	}

	/**
	 * Retourne vrai si les arguments de f2 semblent matcher ceux de f1,
	 * c'est à dire si tous les arguments de f1 existent dans f2.
	 * Difficile de vérifier l'égalité stricte des listes d'arguments : elle dépend du conteneur.
	 * Par exemple, une Family n'a pas les mêmes arguments C+ qu'un module même si les arguments
	 * sont les mêmes dans le modèle.
	 */
	private static def boolean checkArgs(IFunction f1, Function f2)
	{
		for (arg : f2.args)
			if (!f1.parameters.exists[p | p.name == arg.name]) return false
		return true
	}

	/**
	 * Retourne vrai si la fonction f1 :
	 *  - n'a aucun paramètre et que variableAsArgs vaut faux,
	 *  - a un seul paramètre vars et que variableAsArgs vaut vrai.
	 */
	private static def boolean checkArgs(IFunction f1, boolean variableAsArgs)
	{
		(f1.parameters.length == 1 && f1.parameters.head.name == 'vars' && variableAsArgs)
		|| (f1.parameters.length == 0 && !variableAsArgs)
	}
}