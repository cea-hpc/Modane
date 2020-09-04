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
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.Interface#getParents <em>Parents</em>}</li>
 *   <li>{@link arcane.Interface#getChildren <em>Children</em>}</li>
 *   <li>{@link arcane.Interface#getRealisations <em>Realisations</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getInterface()
 * @model
 * @generated
 */
public interface Interface extends PropertyOrArgumentType, FuncContainer, PropertyContainer {
	/**
	 * Returns the value of the '<em><b>Parents</b></em>' reference list.
	 * The list contents are of type {@link arcane.Interface}.
	 * It is bidirectional and its opposite is '{@link arcane.Interface#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parents</em>' reference list.
	 * @see arcane.ArcanePackage#getInterface_Parents()
	 * @see arcane.Interface#getChildren
	 * @model opposite="children"
	 * @generated
	 */
	EList<Interface> getParents();

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link arcane.Interface}.
	 * It is bidirectional and its opposite is '{@link arcane.Interface#getParents <em>Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see arcane.ArcanePackage#getInterface_Children()
	 * @see arcane.Interface#getParents
	 * @model opposite="parents"
	 * @generated
	 */
	EList<Interface> getChildren();

	/**
	 * Returns the value of the '<em><b>Realisations</b></em>' reference list.
	 * The list contents are of type {@link arcane.Service}.
	 * It is bidirectional and its opposite is '{@link arcane.Service#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realisations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realisations</em>' reference list.
	 * @see arcane.ArcanePackage#getInterface_Realisations()
	 * @see arcane.Service#getInterface
	 * @model opposite="interface"
	 * @generated
	 */
	EList<Service> getRealisations();

} // Interface
