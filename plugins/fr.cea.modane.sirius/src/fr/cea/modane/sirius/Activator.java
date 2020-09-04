/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.sirius;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import fr.cea.modane.sirius.fragmentation.FragmentationModelChangeTrigger;
import fr.cea.modane.sirius.fragmentation.FragmentationNotificationFilter;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
    // The plug-in ID
    public static final String PLUGIN_ID = "fr.cea.modane.sirius";
    public static final String MODELS_PACKAGE = "models";
    
    // The shared instance
    private static Activator plugin;
    private static Set<Viewpoint> viewpoints; 

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
      super.start(context);
	  plugin = this;
	  viewpoints = new HashSet<Viewpoint>();
	  Set<Viewpoint> modaneVPs = ViewpointRegistry.getInstance().registerFromPlugin(PLUGIN_ID + "/description/modane.odesign");
	  viewpoints.addAll(modaneVPs);
	  installFragmentation();
    }
    
    /**
     * Install a local trigger when a new session is created
     */
    private void installFragmentation() {
    	SessionManager.INSTANCE.addSessionsListener(new SessionManagerListener.Stub() {
			@Override
			public void notifyAddSession(Session newSession) {
				newSession.getEventBroker().addLocalTrigger(new FragmentationNotificationFilter(), new FragmentationModelChangeTrigger());
			}
		});
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
	plugin = null;
	if (viewpoints != null) {
	    for (final Viewpoint viewpoint: viewpoints) {
		ViewpointRegistry.getInstance().disposeFromPlugin(viewpoint);
	    }
	    viewpoints.clear();
	    viewpoints = null; 
	}
	super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
	return plugin;
    }
}
