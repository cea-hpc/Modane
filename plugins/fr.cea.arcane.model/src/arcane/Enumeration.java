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
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.Enumeration#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends PropertyOrArgumentType, PackagedElement {
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link arcane.EnumerationLiteral}.
	 * It is bidirectional and its opposite is '{@link arcane.EnumerationLiteral#getContainingEnumeration <em>Containing Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see arcane.ArcanePackage#getEnumeration_Literals()
	 * @see arcane.EnumerationLiteral#getContainingEnumeration
	 * @model opposite="containingEnumeration" containment="true" required="true"
	 * @generated
	 */
	EList<EnumerationLiteral> getLiterals();

} // Enumeration
