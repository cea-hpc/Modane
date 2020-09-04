package fr.cea.modane.compare;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.ide.hook.AbstractResourceSetHooks;
import org.eclipse.emf.compare.ide.hook.IResourceSetHook;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * This hook is used to do a resolve all on the resourceset before the comparison is made
 * @author sthibaudeau
 *
 */
public class ResolveAllResourceSetHook extends AbstractResourceSetHooks implements IResourceSetHook {

	public ResolveAllResourceSetHook() {
	}

	
	@Override
	public boolean isHookFor(Collection<? extends URI> uris) {
		return true;
	}
	
	@Override
	public void postLoadingHook(ResourceSet resourceSet, Collection<? extends URI> uris) {
		super.postLoadingHook(resourceSet, uris);
		EcoreUtil.resolveAll(resourceSet);
	}
}
