package fr.cea.modane.compare;

import java.util.Collections;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.ide.ui.dependency.IDependencyProvider;
import org.eclipse.emf.ecore.resource.URIConverter;

public class ModaneDependencyProvider implements IDependencyProvider {

	@Override
	public boolean apply(URI uri) {
		return "modane".equals(uri.fileExtension());
	}

	@Override
	public Set<URI> getDependencies(URI uri, URIConverter uriConverter) {
		if (uri.isPlatformResource()) {
			String projectName = uri.segment(1);
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			try {
				for (IResource member : project.members()) {
					if ("modaneprj".equals(member.getFileExtension())) {
						return Collections.singleton(URI.createURI("platform:/resource/" + projectName + '/' + member.getName()));
					}
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return Collections.emptySet();
	}

}
