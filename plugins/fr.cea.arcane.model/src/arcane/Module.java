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
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.Module#getEntryPoints <em>Entry Points</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getModule()
 * @model
 * @generated
 */
public interface Module extends ServiceOrModule {
	/**
	 * Returns the value of the '<em><b>Entry Points</b></em>' containment reference list.
	 * The list contents are of type {@link arcane.EntryPoint}.
	 * It is bidirectional and its opposite is '{@link arcane.EntryPoint#getContainingModule <em>Containing Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Points</em>' containment reference list.
	 * @see arcane.ArcanePackage#getModule_EntryPoints()
	 * @see arcane.EntryPoint#getContainingModule
	 * @model opposite="containingModule" containment="true"
	 * @generated
	 */
	EList<EntryPoint> getEntryPoints();

} // Module
