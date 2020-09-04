/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.arcanetypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see arcane.arcanetypes.ArcanetypesPackage
 * @generated
 */
public interface ArcanetypesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArcanetypesFactory eINSTANCE = arcane.arcanetypes.impl.ArcanetypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Arcane Types</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arcane Types</em>'.
	 * @generated
	 */
	ArcaneTypes createArcaneTypes();

	/**
	 * Returns a new object of class '<em>Item Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Item Type</em>'.
	 * @generated
	 */
	ItemType createItemType();

	/**
	 * Returns a new object of class '<em>Simple Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Type</em>'.
	 * @generated
	 */
	SimpleType createSimpleType();

	/**
	 * Returns a new object of class '<em>Mesh Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mesh Type</em>'.
	 * @generated
	 */
	MeshType createMeshType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ArcanetypesPackage getArcanetypesPackage();

} //ArcanetypesFactory
