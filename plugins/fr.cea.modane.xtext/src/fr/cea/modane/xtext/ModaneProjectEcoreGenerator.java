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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.mwe2.ecore.EcoreGenerator;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

import com.google.common.base.Function;

/**
 * This implementation allows to generate custom classes in src folder instead of src-gen folder.
 * This implementation considers that generateCustomClasses = true.
 * It also considers the default generation is done in src-gen folder.
 */
public class ModaneProjectEcoreGenerator extends EcoreGenerator {

	private static Logger log = Logger.getLogger(ModaneProjectEcoreGenerator.class);

	@Override
	protected Function<String, String> getTypeMapper() {
		return new ModaneMapper();
	}

	protected final class ModaneMapper implements Function<String, String> {
		public String apply(String from) {
			if (from.startsWith("fr.cea.modane")) {
				String customClassName = from + "Custom";
				String fromPath = from.replace('.', '/');
				for(String srcgenPath: srcPaths) {
					String srcPath = srcgenPath;
					srcPath = srcPath.replace("src-gen", "src");
					URI createURI = URI.createURI(srcPath+"/"+fromPath+"Custom.java");
					if (URIConverter.INSTANCE.exists(createURI, null)) {
						return customClassName;
					}
					if (from.endsWith("Impl")) {
						generate(from,customClassName,createURI);
						return customClassName;
					}
				}
				if (getClass().getClassLoader().getResourceAsStream(fromPath + "Custom.class") != null) {
					return customClassName;
				}
			}
			return null;
		}
	}

	@Override
	public void invoke(IWorkflowContext ctx) {
		try {
			Object privateMethod = getPrivateMethod("getResourceSet");
			if (!(privateMethod instanceof ResourceSet)) {
				log.error("Error accessing ResourceSet");
				return;
			}
			ResourceSet resSet = (ResourceSet) privateMethod;
			Object genModelPath = getPrivateField("genModel");
			if (!(genModelPath instanceof String)) {
				log.error("Error accessing genModel");
				return;
			}
			Resource resource = resSet.getResource(URI.createURI((String)genModelPath), true);
			final GenModel genModel = (GenModel) resource.getContents().get(0);
			genModel.setCanGenerate(true);
			genModel.reconcile();
			createGenModelSetup().registerGenModel(genModel);

			Generator generator = new Generator();
			generator.getAdapterFactoryDescriptorRegistry().addDescriptor(GenModelPackage.eNS_URI,
					new GeneratorAdapterDescriptor(getTypeMapper(), getLineDelimiter()));
			generator.setInput(genModel);

			Diagnostic diagnostic = generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE,
					new BasicMonitor());

			if (diagnostic.getSeverity() != Diagnostic.OK)
				log.info(diagnostic);

			Object generateEdit = getPrivateField("generateEdit");
			if (generateEdit != null && ((Boolean)generateEdit).booleanValue()) {
				Diagnostic editDiag = generator.generate(genModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE,
						new BasicMonitor());
				if (editDiag.getSeverity() != Diagnostic.OK)
					log.info(editDiag);
			}
			Object generateEditor = getPrivateField("generateEdit");
			if (generateEditor != null && ((Boolean)generateEditor).booleanValue()) {
				Diagnostic editorDiag = generator.generate(genModel, GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE,
						new BasicMonitor());
				if (editorDiag.getSeverity() != Diagnostic.OK)
					log.info(editorDiag);
			}
		} catch (Exception e) {
			log.error("Error during generation", e);
		}
	}

	@Override
	protected String copyright() {
		return 	"/*******************************************************************************\n"+
				 " * Copyright (c) 2021 CEA\n"+
				 " * This program and the accompanying materials are made available under the\n"+
				 " * terms of the Eclipse Public License 2.0 which is available at\n"+
				 " * http://www.eclipse.org/legal/epl-2.0.\n"+
				 " *\n"+
				 " * SPDX-License-Identifier: EPL-2.0\n"+
				 " * Contributors: see AUTHORS file\n"+
				 " *******************************************************************************/";
	}

	private Object getPrivateField(String field) throws NoSuchFieldException, IllegalAccessException {
		Field privateStringField = EcoreGenerator.class.getDeclaredField(field);
		privateStringField.setAccessible(true);
		return privateStringField.get(this);
	}

	private Object getPrivateMethod(String method) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Method privateStringMethod = EcoreGenerator.class.getDeclaredMethod(method, new Class<?>[0]);
		privateStringMethod.setAccessible(true);
		return privateStringMethod.invoke(this, new Object[0]);
	}
}
