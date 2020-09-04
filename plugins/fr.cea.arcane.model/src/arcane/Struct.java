/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Struct</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.Struct#getParents <em>Parents</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getStruct()
 * @model
 * @generated
 */
public interface Struct extends PropertyOrArgumentType, PropertyContainer {
	/**
	 * Returns the value of the '<em><b>Parents</b></em>' reference list.
	 * The list contents are of type {@link arcane.Struct}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parents</em>' reference list.
	 * @see arcane.ArcanePackage#getStruct_Parents()
	 * @model
	 * @generated
	 */
	EList<Struct> getParents();

} // Struct
