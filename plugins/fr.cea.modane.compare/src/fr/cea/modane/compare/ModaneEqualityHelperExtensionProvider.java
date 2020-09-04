package fr.cea.modane.compare;

import org.eclipse.emf.compare.match.eobject.EqualityHelperExtensionProvider;
import org.eclipse.emf.compare.utils.IEqualityHelper;
import org.eclipse.emf.ecore.EObject;

import fr.cea.modane.compare.match.ModaneMatcher;

public class ModaneEqualityHelperExtensionProvider implements EqualityHelperExtensionProvider {

	private ModaneMatcher modaneMatcher = null;
	
	public ModaneEqualityHelperExtensionProvider() {
		modaneMatcher = new ModaneMatcher();
	}

	@Override
	public SpecificMatch matchingEObjects(EObject object1, EObject object2, IEqualityHelper equalityHelper) {
		return modaneMatcher.matchingEObjects(object1, object2, equalityHelper);
	}

}
