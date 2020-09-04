/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.generator.cpp

import fr.cea.modane.modane.Struct
import java.util.Collection
import org.eclipse.xtext.generator.IFileSystemAccess

import static extension fr.cea.modane.ModaneElementExtensions.*
import static extension fr.cea.modane.generator.cpp.PtyExtensions.*
import static extension fr.cea.modane.generator.cpp.ReferenceableExtensions.*

class StructExtensions 
{
	static def compile(Struct it, IFileSystemAccess fsa, Collection<String> cmakeFiles)
	{
		val context = GenerationContext::Current
		context.newFile(outputPath, referencedFileName, true, false)
		cmakeFiles += referencedFileName
		context.addContent(interfaceContent)
		context.addContent(GenerationContext::Separator)
		context.addContent(developerClassContent)
		context.generate(fsa)
	}

	private static def getInterfaceContent(Struct it)
	'''
		/*!
		 * \brief Interface représentant la structure «name»
		 * «description»
		 */
		class «referencedName»
		«FOR parent : parents BEFORE ': ' SEPARATOR ', '»
		public «parent.referencedNameWithNs»
		«ENDFOR»
		{
		 public:
		  «referencedName»() {}
		  virtual ~«referencedName»() {}

		 public:
		  «FOR p : properties»
		  «p.abstractGetterContent»
		  «IF p.needHasAccessor»«p.abstractHasAccessorContent»«ENDIF»
		  «ENDFOR»
		};
	'''	
	
	private static def getDeveloperClassContent(Struct it)
	'''
		/*!
		 * Classe représentant la structure «name»
		 * «description»
		 */
		class «developerName»
		: public «referencedName»
		«FOR p : parents»
		, public «p.developerNameWithNs»
		«ENDFOR»
		{
		 public:  // ***** CONSTRUCTEUR & DESTRUCTEUR
		  «developerName»()
		  «FOR p : properties BEFORE ': ' SEPARATOR '\n, '»«p.fieldName»(«p.initValue»)«ENDFOR»
		  {}
		  virtual ~«developerName»() {}

		 public:  // ***** ACCESSEURS
		«FOR p : properties SEPARATOR '\n'»
		    «p.getGetterContent('''return «p.fieldName»;''', true)»
		    «p.getSetterContent('''«p.fieldName» = value;''')»
		  «IF p.needHasAccessor»«p.getHasAccessorContent('''return true;''', true)»«ENDIF»
		«ENDFOR»
		«FOR parent : parents»
		  «FOR p : parent.properties SEPARATOR '\n'»
		      «p.getGetterContent('''return «parent.name»::«p.getterName»();''', true)»
		      «p.getSetterContent('''«parent.name»::«p.setterName»(value) ;''')»
		    «IF p.needHasAccessor»«p.getHasAccessorContent('''return «parent.name»::«p.hasName»();''', true)»«ENDIF»
		  «ENDFOR»
		«ENDFOR»

		 protected:  // ***** ATTRIBUTS
		  «FOR p : properties SEPARATOR '\n'»«p.attrTypeName» «p.fieldName»;«ENDFOR»
		};
	'''
	
 	private static def getDeveloperNameWithNs(Struct it)
 	{
		val context = GenerationContext::Current
		context.addInclude(outputPath, developerFileName)
		if (nsName != context.nsName && !context.isAUsedNs(nsName))
			'::' + nsName + '::' + developerName
		else
			developerName	
 	}

	/** La structure dans le même fichier .h que son interface */
 	private static def getDeveloperFileName(Struct it) { referencedFileName }
 	private static def getDeveloperName(Struct it) { name }
}