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
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.Package#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends PackagedElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link arcane.PackagedElement}.
	 * It is bidirectional and its opposite is '{@link arcane.PackagedElement#getContainingPackage <em>Containing Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see arcane.ArcanePackage#getPackage_Elements()
	 * @see arcane.PackagedElement#getContainingPackage
	 * @model opposite="containingPackage" containment="true"
	 * @generated
	 */
	EList<PackagedElement> getElements();

} // Package
