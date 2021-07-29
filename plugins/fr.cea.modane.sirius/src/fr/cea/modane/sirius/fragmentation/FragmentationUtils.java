/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius.fragmentation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;

import fr.cea.modane.modane.ModaneModel;
import fr.cea.modane.modaneproject.Package;
import fr.cea.modane.sirius.Activator;

public class FragmentationUtils 
{
	private static final String MODANE_FILE_EXTENSION = "modane";
	private static final String AIRD_FILE_EXTENSION = "aird";

	public static boolean isControlled(EObject object) 
	{
    	EObject parent = object.eContainer();
    	Resource resource = object.eResource();
    	return resource != null && parent != null && resource != parent.eResource();
    }
	
    /**
     * Return the URI for the XText resource containing the model
     * @param model
     * @return
     */
    public static URI getSemanticURI(ModaneModel model) 
    { 
    	return getTargetURI(model, MODANE_FILE_EXTENSION);
    }
    
    /**
     * Return the URI for the Aird resource attached to the model
     * @param model
     * @return
     */
    public static URI getAirdURI(ModaneModel model) 
    {
    	return getTargetURI(model, AIRD_FILE_EXTENSION);
    }
    
    private static URI getTargetURI(ModaneModel model , String fileExtension) 
    {
    	Session session = new EObjectQuery(model).getSession();
    	URI mainAirdURI = session.getSessionResource().getURI();
    	
    	String uriAsString = mainAirdURI.toString();
    	// Remove last segment
    	int lastSlash = uriAsString.lastIndexOf('/');
    	uriAsString = uriAsString.substring(0, lastSlash + 1);
    	
    	// Append path for model
     	uriAsString += Activator.MODELS_PACKAGE + "/" +  getFileNameWithoutExtension(model) + "." + fileExtension;
    	
    	return URI.createURI(uriAsString);
    }
    
    private static String getFileNameWithoutExtension(ModaneModel model) 
    {
    	// Path of a model is path of its namespace concatenated with its name
    	Package container = (Package)model.eContainer();
    	return container.getFullyQualifiedName();
    }
}
