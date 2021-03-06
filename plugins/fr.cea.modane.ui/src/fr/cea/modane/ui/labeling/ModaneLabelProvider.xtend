/*
* generated by Xtext
*/
package fr.cea.modane.ui.labeling

import com.google.inject.Inject
import fr.cea.modane.modane.ModaneModel
import fr.cea.modane.modane.OverrideFunction
import fr.cea.modane.modane.VarReference
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
class ModaneLabelProvider extends DefaultEObjectLabelProvider 
{
	@Inject
	new(AdapterFactoryLabelProvider delegate) 
	{
		super(delegate);
	}

 	def text(ModaneModel model) 
 	{
 		if (model.eResource === null) super.text(model)
 		else model.eResource.URI.segments.last
	}
	
	def text(OverrideFunction it) { func.name }
	def text(VarReference it) { variable.name }
}
