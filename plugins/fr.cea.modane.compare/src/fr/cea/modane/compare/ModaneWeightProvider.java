package fr.cea.modane.compare;

import org.eclipse.emf.compare.match.eobject.EcoreWeightProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import fr.cea.modane.modane.ModanePackage;

public class ModaneWeightProvider extends EcoreWeightProvider {
	@Override
	public int getWeight(EStructuralFeature feature) {
		if (feature == ModanePackage.Literals.OVERRIDE_FUNCTION__FUNC) {
			return UNLIKELY_TO_MATCH;
		}
		return super.getWeight(feature);
	}

	@Override
	public int getParentWeight(EObject a) {
		return super.getParentWeight(a);
	}

	@Override
	public int getContainingFeatureWeight(EObject a) {
		return super.getContainingFeatureWeight(a);
	}
}
