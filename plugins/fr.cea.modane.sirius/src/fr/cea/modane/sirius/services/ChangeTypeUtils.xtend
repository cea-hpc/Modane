/*******************************************************************************
 * Copyright (c) 2022 CEA
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.services

import fr.cea.modane.modane.Function
import fr.cea.modane.modane.ItemGroupType
import fr.cea.modane.modane.ItemType
import fr.cea.modane.modane.ModaneFactory
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.PtyOrArgType
import fr.cea.modane.modane.Referenceable
import fr.cea.modane.modane.SimpleType
import java.util.ArrayList
import java.util.Collection
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.viewers.LabelProvider
import org.eclipse.jface.window.Window
import org.eclipse.sirius.business.api.helper.SiriusUtil
import org.eclipse.ui.dialogs.ElementListSelectionDialog

import static extension fr.cea.modane.sirius.services.PtyOrArgTypeExtensions.*
import fr.cea.modane.modane.Simple
import fr.cea.modane.modane.Item
import fr.cea.modane.modane.ItemGroup
import fr.cea.modane.modane.Reference

class ChangeTypeUtils 
{
	/** Bug Sirius ? impossible d'affecter la valeur d'énuméré Real à un SimpleType. Les autres valeurs fonctionnent ! */
	def createRealType(Pty p) { createTypeInstance(SimpleType::REAL) }
	def getTypeName(Pty p) { if (p.type === null) 'null' else p.type.name }
	def getTypeName(Function f) { if (f.type === null) 'void' else f.type.name }
		
	def getTypeFromSelection(EObject context, PtyOrArgType poat) 
	{
		val selectedType = getUserSelectedType(context, "Change property's type", "Select a type (* = any string, ? = any char)")
		if (selectedType === null) poat
		else getType(poat, selectedType)
	}

	def getType(PtyOrArgType poat, Object newType) 
	{
		if (poat === null)
			createTypeInstance(newType)
		else if (poat.getTypeOfType !== newType)
		{
			SiriusUtil.delete(poat)
			createTypeInstance(newType)
		}
	}
	
	/** Open a dialog to allow the user to select a type and return this selected type */
	private def Object getUserSelectedType(EObject context, String dlgTitle, String dlgMessage) 
	{
		val labelProvider = new LabelProvider() 
		{
			override getText(Object element) 
			{
				if (element instanceof Referenceable) element.name
				else super.getText(element)					
			}
		}
		
		// Open selection dialog
		val dlg = new ElementListSelectionDialog(Utils::shell, labelProvider) => 
		[
			title = dlgTitle
			message = dlgMessage
			elements = context.allAvailableTypes
		]
		
		// Create property if dialog has been validated
		if (dlg.open == Window.OK) dlg.firstResult
		else null
	}
	
	/**
	 * Return a list of all types (SimpleType, ItemType, ItemGroupType and Referenceable)
	 */
	def Collection<Object> getAllAvailableTypes(EObject context) 
	{
		val choices = new ArrayList<Object>
		choices += SimpleType.VALUES
		choices += ItemType.VALUES.filter[i | i !== ItemType::NO_ITEM]
		choices += ItemGroupType.VALUES.filter[i | i !== ItemGroupType::NO_ITEM_GROUP]
		choices += context.allReferenceables
		choices
	}

	def getDisplayName(Object element) 
	{
		if (element instanceof Referenceable) element.name
		else element.toString					
	}
	
	def getTypeOfType(PtyOrArgType poat)
	{
		val t = poat
		switch (t)
		{
			Simple : t.type
			Item : t.type
			ItemGroup : t.type
			Reference : t.target
		}
	}
			
	private def Collection<Referenceable> getAllReferenceables(EObject context) 
	{
		Utils::getAllResourceSetModaneElements(context).filter(Referenceable).toList
	}
	
	private def dispatch PtyOrArgType createTypeInstance(Object it) { }
	
	private def dispatch PtyOrArgType createTypeInstance(SimpleType simpleType) 
	{
		val simple = ModaneFactory.eINSTANCE.createSimple
		simple.type = simpleType
		simple
	}
	
	private def dispatch PtyOrArgType createTypeInstance(ItemType itemType) 
	{
		val item = ModaneFactory.eINSTANCE.createItem
		item.type = itemType
		item
	}
	
	private def dispatch PtyOrArgType createTypeInstance(ItemGroupType itemGroupType) 
	{
		val itemGroup = ModaneFactory.eINSTANCE.createItemGroup
		itemGroup.type = itemGroupType
		itemGroup
	}
	
	private def dispatch PtyOrArgType createTypeInstance(Referenceable referenceable) 
	{
		val reference = ModaneFactory.eINSTANCE.createReference
		reference.target = referenceable
		reference
	}
}
