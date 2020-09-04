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
 * A representation of the model object '<em><b>Property Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.PropertyContainer#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getPropertyContainer()
 * @model abstract="true"
 * @generated
 */
public interface PropertyContainer extends PackagedElement {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link arcane.Property}.
	 * It is bidirectional and its opposite is '{@link arcane.Property#getContainingContainer <em>Containing Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see arcane.ArcanePackage#getPropertyContainer_Properties()
	 * @see arcane.Property#getContainingContainer
	 * @model opposite="containingContainer" containment="true"
	 * @generated
	 */
	EList<Property> getProperties();

} // PropertyContainer
