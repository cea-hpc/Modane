package fr.cea.modane.validation

import fr.cea.modane.modane.ModaneElement
import fr.cea.modane.modane.ModaneModel
import fr.cea.modane.modane.ModanePackage
import fr.cea.modane.modane.NamedElement
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.eclipse.xtext.validation.Check

class UniqueNameValidator extends AbstractModaneValidator
{
	public static val DUPLICATE_NAME = "DuplicateName"
	static def getUniqueNameMsg(String objectName) { "Il existe déjà un élement portant le nom " + objectName }

	@Check
	def dispatch checkUniqueName(ModaneElement it)
	{
		return checkUniqueNames(ModanePackage.Literals.NAMED_ELEMENT__NAME)
	}

	@Check
	def dispatch checkUniqueName(NamedElement it)
	{
		if (eContainer.eContents.filter(class).exists[e | e!==it && e.name==name])
		{
			error(getUniqueNameMsg(name), ModanePackage.Literals.NAMED_ELEMENT__NAME, DUPLICATE_NAME)
			return false
		}
		return true
	}

	private def <T extends EObject> checkUniqueNames(T t, EStructuralFeature f)
	{
		val name = SimpleAttributeResolver.NAME_RESOLVER.apply(t)
		val module = EcoreUtil2.getContainerOfType(t, ModaneModel)
		if (module !== null)
		{
			val contents = EcoreUtil2.getAllContentsOfType(module, t.class)
			for (tx : contents)
			{
				val tx_name = SimpleAttributeResolver.NAME_RESOLVER.apply(tx)
				if (tx_name.equals(name) && tx !== t)
				{
					error(getUniqueNameMsg(name), f, DUPLICATE_NAME)
					return false
				}
			}
			return true
		}
	}
}