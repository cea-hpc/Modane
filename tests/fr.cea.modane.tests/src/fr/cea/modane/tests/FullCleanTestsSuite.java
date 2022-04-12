/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.tests;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@Categories.IncludeCategory(FullCleanTests.class)
@SuiteClasses({ AbstractVarTestCase.class, EnumTestCase.class, InheritanceTestCase.class, IWithoutSTestCase.class, MicroHydroTestCase.class, 
		ParameterTestCase.class, ParameterDefaultValueTestCase.class, PartialGenTestCase.class, PtyOnInterfaceTestCase.class, ServiceTestCase.class, StructTestCase.class,
		SupportTestCase.class, UnitTestTestCase.class, UnpackagedTestCase.class, VarTestCase.class })
public class FullCleanTestsSuite
{
}
