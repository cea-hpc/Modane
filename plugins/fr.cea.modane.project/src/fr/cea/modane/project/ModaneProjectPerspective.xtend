/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
 package fr.cea.modane.project;

import org.eclipse.ui.IPageLayout
import org.eclipse.ui.IPerspectiveFactory
import org.eclipse.ui.console.IConsoleConstants

class ModaneProjectPerspective implements IPerspectiveFactory 
{
	// l'ID n'est pas présent dans la classe org.eclipse.amalgam.explorer.contextual.view.AmalgamExplorerContextualView.
	// La référence dans le code ci-dessous se fait simplement par la chaine de caractères CONTEXTUAL_EXPLORER_ID représentant l'ID.
	// ATTENTION : il faut laisser la dépendance (dans plugin.xml) sur org.eclipse.amalgam.explorer.contextual.ui pour que la vue
	// soit bien présente au runtime.
	static val CONTEXTUAL_EXPLORER_ID = 'org.eclipse.amalgam.explorer.contextual.ui.view.ExplorerContextualID'
	static val MODEL_EXPLORER_VIEW_ID = "org.eclipse.sirius.ui.tools.views.model.explorer"
	static val MODANE_PERSPECTIVE_ID = 'fr.cea.modane.project.ModaneProjectPerspective'
	static val LEFT_FOLDER_ID = "left.folder"
	static val BOTTOM_FOLDER_ID = "bottom.folder"
	static val NEW_MODANE_PROJECT_WIZARD_ID = 'fr.cea.modane.sirius.wizardID'
	static val MODANE_EXAMPLE_WIZARD_ID = 'fr.cea.modane.ui.examples.project.wizard'
	static val ERROR_LOG_VIEW = "org.eclipse.pde.runtime.LogView"
	
	override createInitialLayout(IPageLayout layout) 
	{
		layout.editorAreaVisible = true

		val leftFolder = layout.createFolder(LEFT_FOLDER_ID, IPageLayout.LEFT, 0.25f, IPageLayout.ID_EDITOR_AREA)
		leftFolder.addView(MODEL_EXPLORER_VIEW_ID)
		leftFolder.addView(IPageLayout.ID_OUTLINE)

		val bottomFolder = layout.createFolder(BOTTOM_FOLDER_ID, IPageLayout.BOTTOM, 0.75f, IPageLayout.ID_EDITOR_AREA)
		bottomFolder.addView(IConsoleConstants.ID_CONSOLE_VIEW)
		bottomFolder.addView(IPageLayout.ID_PROP_SHEET)
		bottomFolder.addView(IPageLayout.ID_PROBLEM_VIEW)
		bottomFolder.addView(ERROR_LOG_VIEW)
		bottomFolder.addView(CONTEXTUAL_EXPLORER_ID)

		layout.addShowViewShortcut(MODEL_EXPLORER_VIEW_ID)
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE)
		layout.addShowViewShortcut(IConsoleConstants.ID_CONSOLE_VIEW)
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET)
		layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW)
		layout.addShowViewShortcut(ERROR_LOG_VIEW)

		layout.addNewWizardShortcut(NEW_MODANE_PROJECT_WIZARD_ID)
		layout.addNewWizardShortcut(MODANE_EXAMPLE_WIZARD_ID)

		layout.addPerspectiveShortcut(MODANE_PERSPECTIVE_ID)
	}
}
