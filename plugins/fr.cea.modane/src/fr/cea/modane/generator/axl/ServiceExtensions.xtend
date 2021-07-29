/*******************************************************************************
 * Copyright (c) 2021 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.axl

import com.google.inject.Inject
import fr.cea.modane.modane.Service
import fr.cea.modane.modane.Struct
import fr.cea.modane.modane.UnitTestFunction
import java.util.HashMap

import static extension fr.cea.modane.ModaneElementExtensions.*
import static extension fr.cea.modane.ModaneStringExtensions.*
import static extension fr.cea.modane.PtyExtensions.*

class ServiceExtensions extends fr.cea.modane.ServiceExtensions
{
	@Inject extension DescriptionUtils
	@Inject extension PtyExtensions
	@Inject extension VariableExtensions

	def CharSequence getContent(Service it)
	'''
		«val encounteredStructs = new HashMap<Struct, Integer>»
		<service name="«name»" version="1.0" «IF !nsName.empty»namespace-name="«nsName»" «ENDIF»type="«type.literal»"«IF singleton» singleton="true"«ENDIF»>
		  «description.formatDescription»
		  «FOR c : categories»
		  <userclass>«c.name»</userclass>
		  «ENDFOR»
		  «IF (namefr !== null && namefr != '')»<name lang='fr'>«namefr.separateWith('-')»</name>«ENDIF»
		  «FOR i : interfaces»<interface name="«i.referencedNameWithNs»"/>«ENDFOR»
		  «FOR i : parentInterfaces»<interface name="«i.referencedNameWithNs»" inherited="false"/>«ENDFOR»
		  «IF !unitTestFunctions.empty»«testsStartTag»«FOR f : unitTestFunctions»«f.content»«ENDFOR»</tests>«ENDIF»
		  <variables>«FOR v : allVariables»«v.content»«ENDFOR»</variables>
		  <options>«FOR pty : allProperties.filter(p | p.concrete)»«pty.getContent(encounteredStructs)»«ENDFOR»</options>
		</service>
	'''

	private def getTestsStartTag(Service it)
	{
		var startTag = '<tests'
		if (classSetUp) startTag = startTag + ' class-set-up="setUpForClass"'
		if (testSetUp) startTag = startTag + ' test-set-up="setUp"'
		if (classTearDown) startTag = startTag + ' class-tear-down="tearDownForClass"'
		if (testTearDown) startTag = startTag + ' test-tear-down="tearDown"'
		return startTag + '>'
	}

	private def getContent(UnitTestFunction it)
	'''
		<test name="«label»" method-name="«name»"/>
	'''
}