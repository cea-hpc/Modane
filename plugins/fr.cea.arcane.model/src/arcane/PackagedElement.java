/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Packaged Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.PackagedElement#getContainingPackage <em>Containing Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getPackagedElement()
 * @model abstract="true"
 * @generated
 */
public interface PackagedElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Containing Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link arcane.Package#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Package</em>' container reference.
	 * @see #setContainingPackage(arcane.Package)
	 * @see arcane.ArcanePackage#getPackagedElement_ContainingPackage()
	 * @see arcane.Package#getElements
	 * @model opposite="elements" transient="false"
	 * @generated
	 */
	arcane.Package getContainingPackage();

	/**
	 * Sets the value of the '{@link arcane.PackagedElement#getContainingPackage <em>Containing Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Package</em>' container reference.
	 * @see #getContainingPackage()
	 * @generated
	 */
	void setContainingPackage(arcane.Package value);

} // PackagedElement
