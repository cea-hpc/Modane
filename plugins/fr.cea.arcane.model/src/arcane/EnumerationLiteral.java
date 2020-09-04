/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.EnumerationLiteral#getContainingEnumeration <em>Containing Enumeration</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getEnumerationLiteral()
 * @model
 * @generated
 */
public interface EnumerationLiteral extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Containing Enumeration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link arcane.Enumeration#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Enumeration</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Enumeration</em>' container reference.
	 * @see #setContainingEnumeration(Enumeration)
	 * @see arcane.ArcanePackage#getEnumerationLiteral_ContainingEnumeration()
	 * @see arcane.Enumeration#getLiterals
	 * @model opposite="literals" required="true" transient="false"
	 * @generated
	 */
	Enumeration getContainingEnumeration();

	/**
	 * Sets the value of the '{@link arcane.EnumerationLiteral#getContainingEnumeration <em>Containing Enumeration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Enumeration</em>' container reference.
	 * @see #getContainingEnumeration()
	 * @generated
	 */
	void setContainingEnumeration(Enumeration value);
} // EnumerationLiteral
