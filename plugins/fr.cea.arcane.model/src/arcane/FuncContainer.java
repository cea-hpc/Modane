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
 * A representation of the model object '<em><b>Func Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.FuncContainer#getFuncs <em>Funcs</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getFuncContainer()
 * @model abstract="true"
 * @generated
 */
public interface FuncContainer extends PackagedElement {
	/**
	 * Returns the value of the '<em><b>Funcs</b></em>' containment reference list.
	 * The list contents are of type {@link arcane.Func}.
	 * It is bidirectional and its opposite is '{@link arcane.Func#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Funcs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Funcs</em>' containment reference list.
	 * @see arcane.ArcanePackage#getFuncContainer_Funcs()
	 * @see arcane.Func#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<Func> getFuncs();

} // FuncContainer
