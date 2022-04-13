/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.ui.syntaxcoloring

import org.eclipse.swt.SWT
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor
import org.eclipse.xtext.ui.editor.utils.TextStyle

class ModaneHighlightingConfiguration extends DefaultHighlightingConfiguration 
{
	public static val DOX_COMMENT = "DOX_COMMENT"
	public static val QUALIFIED_NAME = "QualifiedName"
	public static val SIMPLE_NAME = "SimpleName"
	public static val OVERRIDE_FUNCTION = "OverrideFunction"
		
	override configure(IHighlightingConfigurationAcceptor acceptor) 
	{
		super.configure(acceptor)
		acceptor.acceptDefaultHighlighting(DOX_COMMENT, "Doxygen Comment", doxCommentTextStyle());
		acceptor.acceptDefaultHighlighting(QUALIFIED_NAME, "Qualified Name", qualifiedNameTextStyle());
		acceptor.acceptDefaultHighlighting(SIMPLE_NAME, "Simple Name", simpleNameTextStyle());
		acceptor.acceptDefaultHighlighting(OVERRIDE_FUNCTION, "Override Function", overrideFunctionTextStyle());
	}
	
	def TextStyle doxCommentTextStyle() { commentTextStyle.copy }
	def TextStyle simpleNameTextStyle() { qualifiedNameTextStyle.copy }
	def TextStyle overrideFunctionTextStyle() { qualifiedNameTextStyle.copy }

	def TextStyle qualifiedNameTextStyle()
	{
		val textStyle = new TextStyle();
		textStyle.setStyle(SWT.BOLD);
		textStyle;
	}	
}