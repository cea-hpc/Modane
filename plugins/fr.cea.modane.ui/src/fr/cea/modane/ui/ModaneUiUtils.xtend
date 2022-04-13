/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.ui

import fr.cea.modane.Utils
import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.ModaneModel
import fr.cea.modane.modane.provider.ModaneItemProviderAdapterFactory
import fr.cea.modane.ui.internal.ModaneActivator
import java.net.URI
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.edit.provider.ItemProviderAdapter
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry
import org.eclipse.jface.resource.ResourceLocator
import org.eclipse.ui.PartInitException
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.ide.IDE
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.DefaultLocationInFileProvider
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.IXtextDocument

import static extension fr.cea.modane.EObjectExtensions.*

class ModaneUiUtils
{
	public static final String PLUGIN_ID = "fr.cea.modane.ui"; //$NON-NLS-1$

	val locationProvider = new DefaultLocationInFileProvider

	/** Refresh du répertoire s'il est contenu dans la resource (évite le F5) */
	static def refreshResourceDir(IResource r, String dirAbsolutePath)
	{
		val uri = URI::create('file://' + dirAbsolutePath)
		val containers = r.workspace.root.findContainersForLocationURI(uri)
		if (containers !== null && containers.size == 1) containers.head.refreshLocal(IResource::DEPTH_INFINITE, null)
	}

	def openXtextEditor(EObject elt) { openXtextEditor(elt, null) }

	def openXtextEditor(EObject elt, EStructuralFeature feature)
	{
		val resource = Utils::toEclipseResource(elt.eResource)
		if (resource !== null && resource.type == IResource::FILE)
		{
			try 
			{
				val workbenchPage = PlatformUI::workbench.activeWorkbenchWindow.activePage
				val editorPart = IDE::openEditor(workbenchPage, (resource as IFile), ModaneActivator::FR_CEA_MODANE_MODANE)
				if (editorPart instanceof XtextEditor) 
				{
					val region = getFullTextRegion(elt, feature)
					//editorPart.selectAndReveal(region.offset, region.length)
					editorPart.selectAndReveal(region.offset, 0)
				}
			}
			catch (PartInitException e)
			{
				e.printStackTrace()
			}
		}
	}

	private def getFullTextRegion(EObject elt, EStructuralFeature feature)
	{
		if (feature === null) locationProvider.getFullTextRegion(elt)
		else locationProvider.getFullTextRegion(elt, feature, 0)
	} 

	/** 
	 * Retourne le ModaneElement à l'offset dans le document. 
	 * Si l'offset tombe entre 2 ModaneElement, retourne le ModaneModel.
	 */
	static def findModaneElementOrModel(IXtextDocument doc, int offset)
	{
		val selectedObject = findEObject(doc, offset)

		// Si on est sur un ModaneModel ou un ModaneElement => ok
		// Sinon, on remonte au ModaneElement conteneur 
		if (!(selectedObject instanceof ModaneModel || selectedObject instanceof ModaneElement))
			selectedObject.modaneParent
		else
			selectedObject
	}

	/**
	 * Retourne l'EObject à l'offset dans le document
	 */
	static def findEObject(IXtextDocument doc, int offset)
	{
		doc.readOnly([ state | 
			if (!state.contents.empty)
			{
				val model = state.contents.get(0)
				val modelNode = NodeModelUtils::findActualNodeFor(model)

				// si le caractère sélectionné est le dernier de la ligne, et que la ligne n'est pas vide, 
				// on prend le caractère d'avant (sinon, le curseur après '}' sélectionne le bloc d'après
				val correctedOffset = if (!isEmptyLine(doc, offset) && isLastCharacterOfLine(doc, offset)) offset - 1 else offset
				val selectedNode = NodeModelUtils::findLeafNodeAtOffset(modelNode, correctedOffset) as INode

				if (selectedNode === null)
					return null
				else
				{
					var selectedObject = NodeModelUtils::findActualSemanticObjectFor(selectedNode)
					
					// Quand la ligne est vide, le selectedNode est l'élément se trouvant sur la première ligne non vide qui suit.
					// On préfère ramener la sélection au bloc englogant pour être cohérent avec l'outline
					if (isEmptyLine(doc, offset)) selectedObject = selectedObject.eContainer
										
					return selectedObject
				}
			}
		])
	}

	private static def boolean isLastCharacterOfLine(IXtextDocument doc, int offset)
	{
		val region = doc.getLineInformationOfOffset(offset)
		(offset == region.offset + region.length)
	}

	/** Retourne vrai si la ligne à offset est vide, c'est à dire si elle ne contient que des HiddenLeafNode */
	private static def boolean isEmptyLine(IXtextDocument doc, int offset)
	{
		val region = doc.getLineInformationOfOffset(offset)
		for (i : 0 ..< region.length)
		{
			val pos = region.offset + i
			if (doc.getChar(pos) != ' ') return false
		}
		return true
	}

	static def getActiveXtextEditor()
	{
		val window = PlatformUI::workbench.activeWorkbenchWindow
		if (window !== null
			&& window.activePage !== null
			&& window.activePage.activeEditor !== null
			&& window.activePage.activeEditor instanceof XtextEditor)
			(window.activePage.activeEditor as XtextEditor)
		else
			null
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	static def getImageDescriptor(String path)
	{
		ResourceLocator::imageDescriptorFromBundle(PLUGIN_ID, path)
	}

	static def getImage(Notifier target)
	{
		val factory = new ModaneItemProviderAdapterFactory
		val adapter = factory.createAdapter(target) as ItemProviderAdapter
		ExtendedImageRegistry::INSTANCE.getImage(adapter.getImage(target))
	}
}