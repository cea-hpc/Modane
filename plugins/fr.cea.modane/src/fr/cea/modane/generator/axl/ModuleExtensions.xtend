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
import fr.cea.modane.modane.Module
import fr.cea.modane.modane.Struct
import java.util.HashMap

import static extension fr.cea.modane.ModaneElementExtensions.*
import static extension fr.cea.modane.ModaneStringExtensions.*
import static extension fr.cea.modane.ModuleExtensions.*
import static extension fr.cea.modane.PtyExtensions.*
import static extension fr.cea.modane.generator.axl.EntryPointExtensions.*

class ModuleExtensions
{
	@Inject extension DescriptionUtils
	@Inject extension PtyExtensions
	@Inject extension VariableExtensions

	def CharSequence getContent(Module it)
	'''
		«val encounteredStructs = new HashMap<Struct, Integer>»
		<module name="«name»" version="1.0" «IF !nsName.empty»namespace-name="«nsName»" «ENDIF»autoload="false">
		  «description.formatDescription»
		  «FOR c : categories»
		  <userclass>«c.name»</userclass>
		  «ENDFOR»
		  «IF (namefr !== null && namefr != '')»<name lang='fr'>«namefr.separateWith('-')»</name>«ENDIF»
		  «FOR i : interfaces»<interface name="«i.referencedNameWithNs»"/>«ENDFOR»
		  <variables>«FOR v : allVariables»«v.content»«ENDFOR»</variables>
		  <entry-points>«FOR ep : entryPoints»«ep.content»«ENDFOR»</entry-points>
		  <options>«FOR pty : allProperties.filter(p | p.concrete)»«pty.getContent(encounteredStructs)»«ENDFOR»</options>
		</module>
	'''
}