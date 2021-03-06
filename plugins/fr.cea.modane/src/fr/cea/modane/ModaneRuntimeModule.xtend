/*
 * generated by Xtext 2.11.0
 */
package fr.cea.modane

import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.naming.IQualifiedNameProvider

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class ModaneRuntimeModule extends AbstractModaneRuntimeModule 
{
	def Class<? extends IOutputConfigurationProvider> bindIOutputConfigurationProvider()
	{
		typeof(ModaneOutputConfigurationProvider)
	}

	override Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider()
	{
		typeof(ModaneQualifiedNameProvider)
	}
	
}
