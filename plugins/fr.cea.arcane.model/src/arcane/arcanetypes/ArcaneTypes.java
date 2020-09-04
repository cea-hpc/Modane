/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.arcanetypes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arcane Types</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.arcanetypes.ArcaneTypes#getMeshTypes <em>Mesh Types</em>}</li>
 *   <li>{@link arcane.arcanetypes.ArcaneTypes#getSimpleTypes <em>Simple Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.arcanetypes.ArcanetypesPackage#getArcaneTypes()
 * @model
 * @generated
 */
public interface ArcaneTypes extends EObject {
	/**
	 * Returns the value of the '<em><b>Mesh Types</b></em>' containment reference list.
	 * The list contents are of type {@link arcane.arcanetypes.MeshType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mesh Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mesh Types</em>' containment reference list.
	 * @see arcane.arcanetypes.ArcanetypesPackage#getArcaneTypes_MeshTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<MeshType> getMeshTypes();

	/**
	 * Returns the value of the '<em><b>Simple Types</b></em>' containment reference list.
	 * The list contents are of type {@link arcane.arcanetypes.SimpleType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Types</em>' containment reference list.
	 * @see arcane.arcanetypes.ArcanetypesPackage#getArcaneTypes_SimpleTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<SimpleType> getSimpleTypes();

} // ArcaneTypes
