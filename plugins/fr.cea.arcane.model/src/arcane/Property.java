/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.Property#getContainingContainer <em>Containing Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends PropertyOrArgument {

	/**
	 * Returns the value of the '<em><b>Containing Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link arcane.PropertyContainer#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Container</em>' container reference.
	 * @see #setContainingContainer(PropertyContainer)
	 * @see arcane.ArcanePackage#getProperty_ContainingContainer()
	 * @see arcane.PropertyContainer#getProperties
	 * @model opposite="properties" required="true" transient="false"
	 * @generated
	 */
	PropertyContainer getContainingContainer();

	/**
	 * Sets the value of the '{@link arcane.Property#getContainingContainer <em>Containing Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Container</em>' container reference.
	 * @see #getContainingContainer()
	 * @generated
	 */
	void setContainingContainer(PropertyContainer value);
} // Property
