/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane;

import arcane.arcanetypes.ItemType;
import arcane.arcanetypes.SimpleType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.Variable#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link arcane.Variable#getType <em>Type</em>}</li>
 *   <li>{@link arcane.Variable#getSupport <em>Support</em>}</li>
 *   <li>{@link arcane.Variable#isDump <em>Dump</em>}</li>
 *   <li>{@link arcane.Variable#isRestore <em>Restore</em>}</li>
 *   <li>{@link arcane.Variable#isExecutionDepend <em>Execution Depend</em>}</li>
 *   <li>{@link arcane.Variable#isNeedSync <em>Need Sync</em>}</li>
 *   <li>{@link arcane.Variable#isAbstract <em>Abstract</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends PackagedElement {
	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
	 * The literals are from the enumeration {@link arcane.VariableMultiplicity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' attribute.
	 * @see arcane.VariableMultiplicity
	 * @see #setMultiplicity(VariableMultiplicity)
	 * @see arcane.ArcanePackage#getVariable_Multiplicity()
	 * @model required="true"
	 * @generated
	 */
	VariableMultiplicity getMultiplicity();

	/**
	 * Sets the value of the '{@link arcane.Variable#getMultiplicity <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' attribute.
	 * @see arcane.VariableMultiplicity
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(VariableMultiplicity value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(SimpleType)
	 * @see arcane.ArcanePackage#getVariable_Type()
	 * @model required="true"
	 * @generated
	 */
	SimpleType getType();

	/**
	 * Sets the value of the '{@link arcane.Variable#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(SimpleType value);

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
	 * @see arcane.ArcanePackage#getVariable_Support()
	 * @model
	 * @generated
	 */
	ItemType getSupport();

	/**
	 * Sets the value of the '{@link arcane.Variable#getSupport <em>Support</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Support</em>' reference.
	 * @see #getSupport()
	 * @generated
	 */
	void setSupport(ItemType value);

	/**
	 * Returns the value of the '<em><b>Dump</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dump</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dump</em>' attribute.
	 * @see #setDump(boolean)
	 * @see arcane.ArcanePackage#getVariable_Dump()
	 * @model default="true"
	 * @generated
	 */
	boolean isDump();

	/**
	 * Sets the value of the '{@link arcane.Variable#isDump <em>Dump</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dump</em>' attribute.
	 * @see #isDump()
	 * @generated
	 */
	void setDump(boolean value);

	/**
	 * Returns the value of the '<em><b>Restore</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restore</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restore</em>' attribute.
	 * @see #setRestore(boolean)
	 * @see arcane.ArcanePackage#getVariable_Restore()
	 * @model default="true"
	 * @generated
	 */
	boolean isRestore();

	/**
	 * Sets the value of the '{@link arcane.Variable#isRestore <em>Restore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restore</em>' attribute.
	 * @see #isRestore()
	 * @generated
	 */
	void setRestore(boolean value);

	/**
	 * Returns the value of the '<em><b>Execution Depend</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Depend</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Depend</em>' attribute.
	 * @see #setExecutionDepend(boolean)
	 * @see arcane.ArcanePackage#getVariable_ExecutionDepend()
	 * @model default="false"
	 * @generated
	 */
	boolean isExecutionDepend();

	/**
	 * Sets the value of the '{@link arcane.Variable#isExecutionDepend <em>Execution Depend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Depend</em>' attribute.
	 * @see #isExecutionDepend()
	 * @generated
	 */
	void setExecutionDepend(boolean value);

	/**
	 * Returns the value of the '<em><b>Need Sync</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Need Sync</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Need Sync</em>' attribute.
	 * @see #setNeedSync(boolean)
	 * @see arcane.ArcanePackage#getVariable_NeedSync()
	 * @model default="true"
	 * @generated
	 */
	boolean isNeedSync();

	/**
	 * Sets the value of the '{@link arcane.Variable#isNeedSync <em>Need Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Need Sync</em>' attribute.
	 * @see #isNeedSync()
	 * @generated
	 */
	void setNeedSync(boolean value);

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see arcane.ArcanePackage#getVariable_Abstract()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link arcane.Variable#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

} // Variable
