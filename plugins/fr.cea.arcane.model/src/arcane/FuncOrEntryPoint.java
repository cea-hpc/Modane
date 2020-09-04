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
 * A representation of the model object '<em><b>Func Or Entry Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.FuncOrEntryPoint#getInVariables <em>In Variables</em>}</li>
 *   <li>{@link arcane.FuncOrEntryPoint#getOutVariables <em>Out Variables</em>}</li>
 *   <li>{@link arcane.FuncOrEntryPoint#getCalledFuncs <em>Called Funcs</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getFuncOrEntryPoint()
 * @model abstract="true"
 * @generated
 */
public interface FuncOrEntryPoint extends NamedElement {
	/**
	 * Returns the value of the '<em><b>In Variables</b></em>' reference list.
	 * The list contents are of type {@link arcane.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Variables</em>' reference list.
	 * @see arcane.ArcanePackage#getFuncOrEntryPoint_InVariables()
	 * @model
	 * @generated
	 */
	EList<Variable> getInVariables();

	/**
	 * Returns the value of the '<em><b>Out Variables</b></em>' reference list.
	 * The list contents are of type {@link arcane.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Variables</em>' reference list.
	 * @see arcane.ArcanePackage#getFuncOrEntryPoint_OutVariables()
	 * @model
	 * @generated
	 */
	EList<Variable> getOutVariables();

	/**
	 * Returns the value of the '<em><b>Called Funcs</b></em>' reference list.
	 * The list contents are of type {@link arcane.Func}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Funcs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Called Funcs</em>' reference list.
	 * @see arcane.ArcanePackage#getFuncOrEntryPoint_CalledFuncs()
	 * @model
	 * @generated
	 */
	EList<Func> getCalledFuncs();

} // FuncOrEntryPoint
