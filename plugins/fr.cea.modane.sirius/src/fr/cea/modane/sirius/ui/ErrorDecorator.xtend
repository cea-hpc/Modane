/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.ui

import fr.cea.modane.modane.ModaneModel
import fr.cea.modane.modane.ModanePackage
import fr.cea.modane.modaneproject.ModaneProject
import fr.cea.modane.modaneproject.PackagesContainer
import fr.cea.modane.sirius.ui.wizard.ProjectCreationOperation
import java.util.ArrayList
import org.eclipse.core.resources.IFile
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.viewers.IDecoration
import org.eclipse.jface.viewers.ILabelProviderListener
import org.eclipse.jface.viewers.ILightweightLabelDecorator
import org.eclipse.sirius.business.api.modelingproject.ModelingProject
import org.eclipse.ui.ISharedImages
import org.eclipse.ui.PlatformUI

import static extension fr.cea.modane.sirius.services.Utils.*

class ErrorDecorator implements ILightweightLabelDecorator
{
	static val ErrorOverlay = PlatformUI.workbench.sharedImages.getImageDescriptor(ISharedImages.IMG_DEC_FIELD_ERROR)
	static val WarningOverlay = PlatformUI.workbench.sharedImages.getImageDescriptor(ISharedImages.IMG_DEC_FIELD_WARNING)

	val listeners = new ArrayList<ILabelProviderListener>

	override decorate(Object element, IDecoration decoration) 
	{
		switch element.status
		{
			case Status::Error : decoration.addOverlay(ErrorOverlay)
			case Status::Warning : decoration.addOverlay(WarningOverlay)
			default : {}
		}		
	}
	
	override addListener(ILabelProviderListener listener) 
	{
		listeners += listener
	}
	
	override dispose() 
	{
	}
	
	override isLabelProperty(Object element, String property) 
	{
		false
	}
	
	override removeListener(ILabelProviderListener listener) 
	{
		listeners -= listener
	}
	
	private def getStatus(Object o)
	{
		switch o
		{
			PackagesContainer : o.status
			EObject case o.eClass.EPackage == ModanePackage::eINSTANCE : o.status
			IFile case o.fileExtension == ProjectCreationOperation::MODANE_PROJECT_FILE_EXTENSION : o.status
			default : Status::Ok
		}
	}

	private def getStatus(IFile file)
	{
		var status = Status::Ok
		val modelingProject = ModelingProject::asModelingProject(file.project);
		if (modelingProject !== null && modelingProject.some)
		{
			val session = modelingProject.get().getSession();
			if (session !== null)
			{
				val resource = session.semanticResources.findFirst[x | x.URI !== null  && x.URI.toPlatformString(false) == file.fullPath.toString]
				if (resource !== null)
				{
					val modaneProject = resource.contents.get(0) as ModaneProject
					status = modaneProject.status
				}
			}
		}	
		return status
	}
	
	private def getStatus(PackagesContainer pc)
	{
		pc.eAllContents.filter(ModaneModel).toIterable.status
	}
		
	private def getStatus(Iterable<? extends EObject> l)
	{
		var warningExists = false
		for (o : l)
		{
			switch o.status
			{
				case Status::Error : return Status::Error
				case Status::Warning : warningExists = true
				default : {}
			}
		}	
		if (warningExists) return Status::Warning
		else return Status::Ok
	}
	
	/** ici o.eClass.ePackage = Modane.Package  */	
	private def getStatus(EObject o)
	{
		if (o.hasError)
			return Status::Error
		else if (o.hasWarning)
			return Status::Warning
		else
			return Status::Ok
	}
	
	private enum Status
	{
		Error,
		Warning,
		Ok	
	}
}