/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.xtext;

import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor;
import org.eclipse.xtext.xtext.generator.XtextGenerator;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class ModaneXtextGenerator extends XtextGenerator {

	public ModaneXtextGenerator() {
		new XtextStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ModaneCustomEcoreXtextRuntimeModule());
			}
		}.createInjectorAndDoEMFRegistration();
	}

	private class ModaneCustomEcoreXtextRuntimeModule extends XtextRuntimeModule {
		@Override
		public void configureIXtext2EcorePostProcessor(Binder binder) {
			try {
				Class.forName("org.eclipse.xtend.expression.ExecutionContext");
				binder.bind(IXtext2EcorePostProcessor.class).to(ModaneXtext2EcorePostProcessor.class);
			} catch (ClassNotFoundException e) {
			}
		}
	}
}
