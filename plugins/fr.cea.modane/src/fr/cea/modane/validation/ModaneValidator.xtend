/*******************************************************************************
 * Copyright (c) 2020 CEA
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors: see AUTHORS file
 *******************************************************************************/
package fr.cea.modane.validation

import com.google.inject.Inject
import fr.cea.modane.Utils
import fr.cea.modane.modane.Arg
import fr.cea.modane.modane.ArgDefinition
import fr.cea.modane.modane.Direction
import fr.cea.modane.modane.EntryPoint
import fr.cea.modane.modane.Enumeration
import fr.cea.modane.modane.EnumerationLiteral
import fr.cea.modane.modane.Function
import fr.cea.modane.modane.FunctionItemType
import fr.cea.modane.modane.Interface
import fr.cea.modane.modane.Item
import fr.cea.modane.modane.ItemGroup
import fr.cea.modane.modane.ItemGroupType
import fr.cea.modane.modane.ItemType
import fr.cea.modane.modane.Legacy
import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.ModaneModel
import fr.cea.modane.modane.ModanePackage
import fr.cea.modane.modane.Module
import fr.cea.modane.modane.NamedElement
import fr.cea.modane.modane.OverrideFunction
import fr.cea.modane.modane.Pty
import fr.cea.modane.modane.Reference
import fr.cea.modane.modane.Service
import fr.cea.modane.modane.ServiceOrModule
import fr.cea.modane.modane.ServiceType
import fr.cea.modane.modane.SimpleType
import fr.cea.modane.modane.UnitTestFunction
import fr.cea.modane.modane.VarDefinition
import fr.cea.modane.modane.VarReference
import fr.cea.modane.modane.Variable
import fr.cea.modane.modane.VariableMultiplicity
import java.util.ArrayList
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.validation.Check

import static extension fr.cea.modane.InterfaceExtensions.*
import static extension fr.cea.modane.ModaneElementExtensions.*
import static extension fr.cea.modane.ModaneStringExtensions.*
import static extension fr.cea.modane.Utils.*

class ModaneValidator extends UniqueNameValidator
{
	public static val IMPLEMENT_FUNCTIONS = 'ImplementFunctions'

	@Inject
	IScopeProvider scopeProvider
	/* ----- REGLES DE NOMMAGE ----- */

	public static val INVALID_NAME = 'InvalidName'

	public static val NAME_STARTS_UPPERCASE_SEPARATOR_UPPERCASE = "Le nom doit commencer par une majuscule et utiliser les majuscules comme séparateur"
	public static val NAME_STARTS_LOWERCASE_SEPARATOR_UPPERCASE = "Le nom doit commencer par une minuscule et utiliser les majuscules comme séparateur"
	public static val NAME_LOWERCASE_SEPARATOR_UNDERSCORE = "Le nom doit être en minuscules et utiliser '_' comme séparateur"
	public static val INTERFACE_NAME_NOT_START_WITH_I = "Le nom ne doit pas commencer par 'I'"
	public static val VARS_RESERVED_NAME = "'vars' est un nom de paramètre réservé"
	public static val UNIQUE_NAME_FOR_OPERATIONS = "Deux opérations ne peuvent pas avoir le même nom" 
	public static val MODEL_ALREADY_EXIST = "Un modèle de même nom existe déjà"

	@Check
	def checkName(NamedElement it)
	{
		switch it
		{
			ModaneElement : return checkNameStartUppercaseSeparatorUppercase
			Function : return checkNameStartLowercaseSeparatorUppercase
			EntryPoint : return checkNameStartLowercaseSeparatorUppercase
			UnitTestFunction : return checkNameStartLowercaseSeparatorUppercase
			EnumerationLiteral: return checkNameStartUppercaseSeparatorUppercase
			default : return checkNameLowercaseSeparatorUnderscore
		}
	}

	private def checkNameStartUppercaseSeparatorUppercase(NamedElement it)
	{
		if (name.nullOrEmpty || !name.startByUc || name.containsSeparator)
		{
			error(NAME_STARTS_UPPERCASE_SEPARATOR_UPPERCASE, ModanePackage.Literals::NAMED_ELEMENT__NAME, INVALID_NAME, name.separateWithUpperCase)
			return false
		}
		return true
	}

	private def checkNameStartLowercaseSeparatorUppercase(NamedElement it)
	{
		if (name.nullOrEmpty || name.startByUc || name.containsSeparator)
		{
			error(NAME_STARTS_LOWERCASE_SEPARATOR_UPPERCASE, ModanePackage.Literals::NAMED_ELEMENT__NAME, INVALID_NAME, name.separateWithUpperCase.toFirstLower)		
			return false
		}
		return true
	}

	private def checkNameLowercaseSeparatorUnderscore(NamedElement it)
	{
		if (name.nullOrEmpty || name.containsUC)
		{
			error(NAME_LOWERCASE_SEPARATOR_UNDERSCORE, ModanePackage.Literals::NAMED_ELEMENT__NAME, INVALID_NAME, name.separateWithDefault)
			return false
		}
		return true
	}

	@Check
	def checkInterfaceNameNotStartWithI(Interface it)
	{
		if (name.length > 1 && name.startsWith('I') && Character::isUpperCase(name.charAt(1)))
		{
			error(INTERFACE_NAME_NOT_START_WITH_I, ModanePackage.Literals::NAMED_ELEMENT__NAME, INVALID_NAME, name.substring(1))
			return false
		}
		return true
	}

	@Check
	def checkVarsReservedName(Arg it)
	{
		if (name == 'vars')
		{
			error(VARS_RESERVED_NAME, ModanePackage.Literals::NAMED_ELEMENT__NAME)
			return false
		}
		return true
	}

	/**
	 * Le validateur Xtext ne vérifie l'unicité des noms qu'au sein d'une resource donnée.
	 * Cette méthode parcourt les resources accessibles dans le resourceSet pour effectuer la vérification.
	 * Pas besoin d'implémenter cette méthode dans Sirius (impossible de créer 2 packages de même nom au même niveau)
	 */
	@Check
	def checkModelAlreadyExist(ModaneModel it)
	{
		for (m : Utils::getAllElementsOfType(scopeProvider, it, ModanePackage::eINSTANCE.modaneModel).filter[x | x.eResource != eResource])
		{
			if ((m as ModaneModel).name == name)
			{
				error(m.eResource.URI.lastSegment + ' : ' + MODEL_ALREADY_EXIST, ModanePackage.Literals::MODANE_MODEL__NAME)
				return false
			}
		}
		return true
	}

	/**
	 * Dans un module/service, il ne faut pas avoir une fonction de même nom qu'une override.
	 * Dans un module, il ne faut pas avoir une fonction (override ou non) de même nom qu'un point d'entrée.
	 */	 
	@Check
	def checkUniqueNameForOperationsOnServiceOrModule(ServiceOrModule it)
	{
		val functionNames = new ArrayList<String>
		functions.forEach[functionNames += name]
		functionNames.retainAll(overrideFuncs.map[func.name])
		if (!functionNames.empty)
		{
			error(functionNames.join(', ') + ' : ' + UNIQUE_NAME_FOR_OPERATIONS, ModanePackage.Literals::NAMED_ELEMENT__NAME)
			return false
		}
		return true
	}

	@Check
	def checkUniqueNameForOperationsOnModule(Module it)
	{
		val functionAndOverrideNames = new ArrayList<String>
		functions.forEach[functionAndOverrideNames += name]
		overrideFuncs.forEach[functionAndOverrideNames += func.name]
		functionAndOverrideNames.retainAll(entryPoints.map[name])
		if (!functionAndOverrideNames.empty)
		{
			error(functionAndOverrideNames.join(', ') + ' : ' + UNIQUE_NAME_FOR_OPERATIONS, ModanePackage.Literals::NAMED_ELEMENT__NAME)
			return false
		}
		return true
	}

	/* ----- FONCTIONS ----- */

	public static val RETURN_VOID = 'ReturnVoid'
	public static val INCORRECT_DEFAULT_VALUE = 'IncorrectDefaultValue'

	public static val SUPPORT_FUNCTION_RETURN_VOID = "Une fonction avec support doit retourner void"
	public static val NO_VAR_ON_INTERFACE_FUNCTION = "Une fonction d'une interface ne peut pas référencer de variable"
	public static val FUNCTION_REALLY_OVERRIDE = "Fonction n'appartenant à aucune des interfaces"
	public static val ONLY_IN_ARG_HAS_DEFAULT_VALUE = "Seul un argument IN peut avoir une valeur par défaut"
	public static val ENUMERATION_ARG_DEFAULT_VALUE = "Valeur par défaut incorrecte"

	@Check
	def checkSupportFunctionReturnVoid(Function it)
	{
		if (type !== null && support != FunctionItemType::NO_ITEM)
		{
			error(SUPPORT_FUNCTION_RETURN_VOID, ModanePackage.Literals::FUNCTION__TYPE, RETURN_VOID)
			return false
		}
		return true
	}

	@Check
	def checkNoVarOnInterfaceFunction(Function it)
	{
		if (eContainer instanceof Interface && !vars.empty)
		{
			error(NO_VAR_ON_INTERFACE_FUNCTION, ModanePackage.Literals::FUNCTION__VARS)
			return false
		}
		return true
	}

	@Check
	def checkFunctionReallyOverride(OverrideFunction it)
	{
		if (!allInterfaces.contains(func.eContainer))
		{
			error(FUNCTION_REALLY_OVERRIDE, ModanePackage.Literals::OVERRIDE_FUNCTION__FUNC)
			return false
		}
		return true
	}

	@Check
	def checkOnlyInArgHasDefaultValue(ArgDefinition it)
	{
		if (!defaultValue.nullOrEmpty && direction != Direction::IN)
		{
			error(ONLY_IN_ARG_HAS_DEFAULT_VALUE, ModanePackage.Literals::ARG_DEFINITION__DEFAULT_VALUE, INCORRECT_DEFAULT_VALUE)
			return false
		}
		return true
	}

	@Check
	def checkEnumerationArgDefaultValue(ArgDefinition it)
	{
		if (!defaultValue.nullOrEmpty && type instanceof Reference && (type as Reference).target instanceof Enumeration)
		{
			val enum = (type as Reference).target as Enumeration
			if (!enum.literals.exists[x | x.name == defaultValue])
				error(ENUMERATION_ARG_DEFAULT_VALUE, ModanePackage.Literals::ARG_DEFINITION__DEFAULT_VALUE, INCORRECT_DEFAULT_VALUE)
			return false
		}
		return true
	}

	// Useful for EEF Properties View, no @Check needed
//	def checkArgsName(Function it) { args.empty || args.forall[checkName] }
//	def checkVarsReservedName(Function it) { args.empty || args.forall[checkVarsReservedName] }
//	def checkOnlyInArgsHaveDefaultValue(Function it) { args.empty || args.filter(ArgDefinition).forall[checkOnlyInArgHasDefaultValue] }

	/* ----- SERVICES ET MODULES ----- */

	public static val MUST_IMPLEMENT_INTERFACE_FUNCTIONS = "Les fonctions des interfaces doivent être implémentées"

	@Check
	def checkMustImplementInterfaceFunctions(ServiceOrModule it) 
	{
		for (i : interfaces)
		{
			for (f : i.allFunctions)
				if (!overrideFuncs.exists[o | o.func == f]) 
				{
					error(MUST_IMPLEMENT_INTERFACE_FUNCTIONS, ModanePackage.Literals::NAMED_ELEMENT__NAME, IMPLEMENT_FUNCTIONS)
					return false
				}
		}
		return true
	}

	/* ----- FRENCH NAME ----- */

	public static val UNIQUE_NAME_FR = "Deux 'French Name' ne peuvent pas être identiques"
	
	/*
	 * Dans Magicdraw, on vérifie l'unicité du nameFr dans le package.
	 * Mais en fait, il faut vérifier :
	 *   - que deux modules n'ont pas le même nameFr
	 *   - que deux services singleton n'ont pas le même nameFr
	 *   - que deux propriétés d'un objet n'ont pas le même nameFr
	 *   - que deux litéraux d'un énuméré n'ont pas le même nameFr
	 */
	@Check
	def checkUniqueNameFr(ServiceOrModule it)
	{
		if (!namefr.nullOrEmpty && !(it instanceof Service && !(it as Service).singleton))
		{
			for (o : Utils::getAllElementsOfType(scopeProvider, it, ModanePackage::eINSTANCE.serviceOrModule))
			{
				val sorm = o as ServiceOrModule
				if (sorm != it && sorm.namefr == namefr)
				{
					error(sorm.model.name + "::" + sorm.name + " : " + ModaneValidator.UNIQUE_NAME_FR, ModanePackage.Literals::SERVICE_OR_MODULE__NAMEFR)
					return false
				}
			}
		}
		return true
	}

	@Check
	def checkUniqueNameFr(Pty p)
	{
		if (!p.namefr.nullOrEmpty)
		{
			val props = (p.eContainer as ModaneElement).props
			if (props !== null)
			{
				val match = props.findFirst[x | p !== x && p.namefr == x.namefr]
				if (match !== null)
				{
					error(match.name + " : " + ModaneValidator.UNIQUE_NAME_FR, ModanePackage.Literals::PTY__NAMEFR)
					return false
				}
			}
		}
		return true
	}

	@Check
	def checkUniqueNameFr(EnumerationLiteral e)
	{
		if (!e.namefr.nullOrEmpty)
		{
			val match = (e.eContainer as Enumeration).literals.findFirst[x | e !== x && e.namefr == x.namefr]
			if (match !== null)
			{
				error(match.name + " : " + ModaneValidator.UNIQUE_NAME_FR, ModanePackage.Literals::ENUMERATION_LITERAL__NAMEFR)
				return false
			}
		}
		return true
	}

	/* ----- PROPERTIES ----- */

	public static val PTYORARGTYPE_NOT_NOITEM = "Types 'NoItem' et 'NoItemGroup' invalides dans ce contexte"
	public static val CONSISTENT_PTY_AND_ENUM_CATEGORY = "Valeur invalide car l'énuméré n'a aucun litéral de cette catégorie"
	public static val CORRECT_PTY_DEFAULT_VALUE = "Valeur par défaut invalide (NomDeModele.Nom pour un service)"

	@Check
	def checkCorrectPtyDefaultValue(Pty it)
	{
		if (defaultValue !== null)
		{
			if (defaultValue == '')
			{
				error(CORRECT_PTY_DEFAULT_VALUE, ModanePackage.Literals::PTY__DEFAULT_VALUE)
				return false
			}
			else if (type instanceof Reference && (type as Reference).target instanceof Interface)
			{
				val interf = (type as Reference).target as Interface
				val services = Utils::getAllElementsOfType(scopeProvider, it, ModanePackage::eINSTANCE.service).filter(Service)

				val service = services.findFirst[s | s.model.name + '.' + s.name == defaultValue]
				if (service === null)
				{
					error(CORRECT_PTY_DEFAULT_VALUE, ModanePackage.Literals::PTY__DEFAULT_VALUE)
					return false
				}
				else if (!service.interfaces.contains(interf))
				{
					error(CORRECT_PTY_DEFAULT_VALUE, ModanePackage.Literals::PTY__DEFAULT_VALUE)
					return false
				}
				else if (service.type == ServiceType::SUBDOMAIN)
				{
					error(CORRECT_PTY_DEFAULT_VALUE, ModanePackage.Literals::PTY__DEFAULT_VALUE)
					return false
				}
			}
		}
		return true
	}

	@Check
	def checkConsistentPtyAndEnumCategory(Pty it)
	{
		if (type instanceof Reference && (type as Reference).target instanceof Enumeration)
		{
			val e = (type as Reference).target as Enumeration
			for (i : 0..<categories.size)
			{
				val c = categories.get(i)
				if (!e.literals.exists[l | l.categories.contains(c)])
				{
					error(CONSISTENT_PTY_AND_ENUM_CATEGORY, ModanePackage.Literals::PTY__CATEGORIES,i)
					return false
				}
			}
		}
		return true
	}

	// Pas besoin d'implémenter cette méthode dans Sirius (liste déroulante filtrée)
	@Check
	def checkPtyOrArgTypeNotNoItem(Item it)
	{
		if (type == ItemType::NO_ITEM)
		{
			error(PTYORARGTYPE_NOT_NOITEM, ModanePackage.Literals::ITEM__TYPE)
			return false
		}
		return true
	}

	// Pas besoin d'implémenter cette méthode dans Sirius (liste déroulante filtrée)
	@Check
	def checkPtyOrArgTypeNotNoItem(ItemGroup it)
	{
		if (type == ItemGroupType::NO_ITEM_GROUP)
		{
			error(PTYORARGTYPE_NOT_NOITEM, ModanePackage.Literals::ITEM_GROUP__TYPE)
			return false
		}
		return true
	}

	/* ----- VARIABLES ----- */

	public static val PARTICLE_VARIABLE_MUST_HAVE_FAMILY = "Une variable particulaire doit préciser sa famille"
	public static val DOF_VARIABLE_MUST_HAVE_FAMILY = "Une variable DoF doit préciser sa famille"
	public static val SAME_SUPPORT_ON_VARIABLE_AND_FAMILY = "La famille et la variable doivent avoir le même support"
	public static val ONLY_DOF_OR_PARTICLE_CAN_HAVE_FAMILY = "Seules les variables particulaires ou DoF peuvent avoir une famille dans la version actuelle d'Arcane"

	@Check
	def checkParticleVariableMustHaveFamily(Variable it)
	{ 
		if (support == ItemType::PARTICLE && family === null)
		{
			error(PARTICLE_VARIABLE_MUST_HAVE_FAMILY, ModanePackage.Literals.VARIABLE__FAMILY)
			return false
		}
		return true
	}

	@Check
	def checkDoFVariableMustHaveFamily(Variable it)
	{ 
		if (support == ItemType::DO_F && family === null)
		{
			error(DOF_VARIABLE_MUST_HAVE_FAMILY, ModanePackage.Literals.VARIABLE__FAMILY)
			return false
		}
		return true
	}

	@Check
	def checkSameSupportOnVariableAndFamily(Variable it)
	{ 
		if (family !== null && support !== family.support)
		{
			error(SAME_SUPPORT_ON_VARIABLE_AND_FAMILY, ModanePackage.Literals.VARIABLE__FAMILY)
			return false
		}
		return true
	}

	@Check
	def checkOnlyDoFOrParticleCanHaveFamily(Variable it)
	{ 
		if (support != ItemType::DO_F && support != ItemType::PARTICLE && family !== null)
		{
			error(ONLY_DOF_OR_PARTICLE_CAN_HAVE_FAMILY, ModanePackage.Literals.VARIABLE__FAMILY)
			return false
		}
		return true
	}

	@Check
	def checkType(Variable v) { return checkVariableType(new VariableValidatorVariable(v)) }

	@Check
	def checkType(VarDefinition v) { return checkVariableType(new VarDefinitionValidatorVariable(v)) }

	private def checkVariableType(ValidatorVariable it)
	{
		if (type == SimpleType::STRING)
		{
			if (support != ItemType::NO_ITEM)
			{
				error("Variable invalide : pas de support possible avec le type String", supportLiteral)
				return false
			}
			if (multiplicity == VariableMultiplicity::ARRAY2)
			{
				error("Variable invalide : Array2 impossible avec le type String", multiplicityLiteral)
				return false
			}
		}

		return true
	}

	@Check
	def checkSupport(Variable v) { return checkVariableSupport(new VariableValidatorVariable(v)) }

	@Check
	def checkSupport(VarDefinition v) { return checkVariableSupport(new VarDefinitionValidatorVariable(v)) }

	private def checkVariableSupport(ValidatorVariable it)
	{

		if (support == ItemType::ITEM || support == ItemType::ALL_ENV_CELL || support == ItemType::COMPONENT_CELL)
		{
			error("Support de variable invalide : " + support.literal, supportLiteral)
			return false
		}

		if (support != ItemType::NO_ITEM && multiplicity == VariableMultiplicity::ARRAY2)
		{
			error("Variable invalide : Array2 impossible avec un support", multiplicityLiteral)
			return false
		}
		
		return true
	}

	@Check
	def multipleIdenticalVarRef(EntryPoint ep) { return multipleIdenticalVarRef(ep.vars, ModanePackage.Literals.ENTRY_POINT__VARS) }

	@Check
	def multipleIdenticalVarRef(Function f)
	{
		val vars =  f.vars.filter(VarReference)
		return multipleIdenticalVarRef(vars, ModanePackage.Literals.FUNCTION__VARS)
	}

	@Check
	def multipleIdenticalVarRef(OverrideFunction f) { return multipleIdenticalVarRef(f.vars, ModanePackage.Literals.OVERRIDE_FUNCTION__VARS) }

	private def multipleIdenticalVarRef(Iterable<VarReference> vars, EReference literal)
	{
		var ok = true
		for (i : 0..<vars.length)
		{
			val v1 = vars.get(i)
			if (vars.exists[v2 | v1 != v2 && v1.direction == v2.direction && v1.variable == v2.variable])
			{
				warning("La variable '" + v1.variable.name + "' est référencée plusieurs fois en '" + v1.direction.literal + "'", literal, i)
				ok = false
			}
		}
		return ok
	}

	/* ----- LEGACY ----- */

	public static val ORIGIN_FILE_NOT_EMPTY = "Le champ 'Origin File' doit être renseigné"

	@Check
	def checkOriginFileNotEmpty(Legacy it)
	{
		if (originFile.nullOrEmpty)
		{
			error(ORIGIN_FILE_NOT_EMPTY, ModanePackage.Literals::LEGACY__ORIGIN_FILE, INVALID_NAME)
			return false
		}
		return true
	}

	/* ----- UNIT TEST FONCTIONS ----- */

	public static val LABEL_NOT_EMPTY = "Le label doit être renseigné"

	@Check
	def checkLabelNotEmpty(UnitTestFunction it)
	{
		if (label.nullOrEmpty)
		{
			error(LABEL_NOT_EMPTY, ModanePackage.Literals.UNIT_TEST_FUNCTION__LABEL)
			return false
		}
		return true
	}

	/*---------------------------------------------------- */

	override protected error(String message, EStructuralFeature feature, int index, String code, String... issueData)
	{
		try
		{
			super.error(message, feature, index, code, issueData)
		}
		catch (Exception exception) {}
	}
}
