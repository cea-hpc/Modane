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
 * A representation of the model object '<em><b>Property Or Argument Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.PropertyOrArgumentType#getUsedBy <em>Used By</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getPropertyOrArgumentType()
 * @model abstract="true"
 * @generated
 */
public interface PropertyOrArgumentType extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Used By</b></em>' reference list.
	 * The list contents are of type {@link arcane.PropertyOrArgument}.
	 * It is bidirectional and its opposite is '{@link arcane.PropertyOrArgument#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used By</em>' reference list.
	 * @see arcane.ArcanePackage#getPropertyOrArgumentType_UsedBy()
	 * @see arcane.PropertyOrArgument#getType
	 * @model opposite="type"
	 * @generated
	 */
	EList<PropertyOrArgument> getUsedBy();
} // PropertyOrArgumentType
