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

import fr.cea.modane.modane.ModanePackage
import fr.cea.modane.modane.OverrideFunction
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator

class ModaneSemanticHightlightingCalculator implements ISemanticHighlightingCalculator 
{
	override provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) 
	{
		if (resource !== null && resource.parseResult !== null)
		{
			val root = resource.parseResult.rootNode
			for (node : root.asTreeIterable)
			{
				val rule = node.grammarElement
				if (rule !== null)
				{
					switch rule
					{
						AbstractRule : colorize(acceptor, node, rule.name)
						RuleCall : colorize(acceptor, node, rule.rule.name)
					}
				}
			}
		}
	}
	
	private def colorize(IHighlightedPositionAcceptor acceptor, INode node, String ruleName)
	{
		if (ruleName == ModaneHighlightingConfiguration::QUALIFIED_NAME)
			acceptor.addPosition(node.offset, node.length, ModaneHighlightingConfiguration::QUALIFIED_NAME)
		else if (ruleName == ModaneHighlightingConfiguration::SIMPLE_NAME)
			acceptor.addPosition(node.offset, node.length, ModaneHighlightingConfiguration::SIMPLE_NAME)
		else if (ruleName == ModaneHighlightingConfiguration::DOX_COMMENT)
			acceptor.addPosition(node.offset, node.length, ModaneHighlightingConfiguration::DOX_COMMENT)
		else if (ruleName == ModaneHighlightingConfiguration::OVERRIDE_FUNCTION)
		{
			if (node.semanticElement !== null && node.semanticElement instanceof OverrideFunction)
			{
				val of = node.semanticElement as OverrideFunction
				for (n : NodeModelUtils::findNodesForFeature(of, ModanePackage.Literals.OVERRIDE_FUNCTION__FUNC))
					acceptor.addPosition(n.offset, n.length, ModaneHighlightingConfiguration::OVERRIDE_FUNCTION)	
			}
		}
	}	
}