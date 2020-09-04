/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.Argument#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getArgument()
 * @model
 * @generated
 */
public interface Argument extends PropertyOrArgument {
	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link arcane.ArgDirection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see arcane.ArgDirection
	 * @see #setDirection(ArgDirection)
	 * @see arcane.ArcanePackage#getArgument_Direction()
	 * @model required="true"
	 * @generated
	 */
	ArgDirection getDirection();

	/**
	 * Sets the value of the '{@link arcane.Argument#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see arcane.ArgDirection
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(ArgDirection value);

} // Argument
