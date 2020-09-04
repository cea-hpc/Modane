/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane;

import arcane.arcanetypes.ItemType;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Func</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.Func#getSupport <em>Support</em>}</li>
 *   <li>{@link arcane.Func#isParallel <em>Parallel</em>}</li>
 *   <li>{@link arcane.Func#getArgs <em>Args</em>}</li>
 *   <li>{@link arcane.Func#getContainer <em>Container</em>}</li>
 *   <li>{@link arcane.Func#isItemTypeSpecialized <em>Item Type Specialized</em>}</li>
 *   <li>{@link arcane.Func#getReturnArgument <em>Return Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getFunc()
 * @model
 * @generated
 */
public interface Func extends FuncOrEntryPoint {
	/**
	 * Returns the value of the '<em><b>Support</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Support</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Support</em>' reference.
	 * @see #setSupport(ItemType)
	 * @see arcane.ArcanePackage#getFunc_Support()
	 * @model
	 * @generated
	 */
	ItemType getSupport();

	/**
	 * Sets the value of the '{@link arcane.Func#getSupport <em>Support</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Support</em>' reference.
	 * @see #getSupport()
	 * @generated
	 */
	void setSupport(ItemType value);

	/**
	 * Returns the value of the '<em><b>Parallel</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parallel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parallel</em>' attribute.
	 * @see #setParallel(boolean)
	 * @see arcane.ArcanePackage#getFunc_Parallel()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isParallel();

	/**
	 * Sets the value of the '{@link arcane.Func#isParallel <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parallel</em>' attribute.
	 * @see #isParallel()
	 * @generated
	 */
	void setParallel(boolean value);

	/**
	 * Returns the value of the '<em><b>Args</b></em>' containment reference list.
	 * The list contents are of type {@link arcane.Argument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Args</em>' containment reference list.
	 * @see arcane.ArcanePackage#getFunc_Args()
	 * @model containment="true"
	 * @generated
	 */
	EList<Argument> getArgs();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link arcane.FuncContainer#getFuncs <em>Funcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(FuncContainer)
	 * @see arcane.ArcanePackage#getFunc_Container()
	 * @see arcane.FuncContainer#getFuncs
	 * @model opposite="funcs" required="true" transient="false"
	 * @generated
	 */
	FuncContainer getContainer();

	/**
	 * Sets the value of the '{@link arcane.Func#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(FuncContainer value);

	/**
	 * Returns the value of the '<em><b>Item Type Specialized</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item Type Specialized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item Type Specialized</em>' attribute.
	 * @see #setItemTypeSpecialized(boolean)
	 * @see arcane.ArcanePackage#getFunc_ItemTypeSpecialized()
	 * @model default="false"
	 * @generated
	 */
	boolean isItemTypeSpecialized();

	/**
	 * Sets the value of the '{@link arcane.Func#isItemTypeSpecialized <em>Item Type Specialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item Type Specialized</em>' attribute.
	 * @see #isItemTypeSpecialized()
	 * @generated
	 */
	void setItemTypeSpecialized(boolean value);

	/**
	 * Returns the value of the '<em><b>Return Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Argument</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Argument</em>' containment reference.
	 * @see #setReturnArgument(Argument)
	 * @see arcane.ArcanePackage#getFunc_ReturnArgument()
	 * @model containment="true"
	 * @generated
	 */
	Argument getReturnArgument();

	/**
	 * Sets the value of the '{@link arcane.Func#getReturnArgument <em>Return Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Argument</em>' containment reference.
	 * @see #getReturnArgument()
	 * @generated
	 */
	void setReturnArgument(Argument value);

} // Func
