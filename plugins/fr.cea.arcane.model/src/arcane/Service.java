/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.Service#getType <em>Type</em>}</li>
 *   <li>{@link arcane.Service#getInterface <em>Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getService()
 * @model
 * @generated
 */
public interface Service extends ServiceOrModule, FuncContainer {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"CaseOption"</code>.
	 * The literals are from the enumeration {@link arcane.ServiceTypeList}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see arcane.ServiceTypeList
	 * @see #setType(ServiceTypeList)
	 * @see arcane.ArcanePackage#getService_Type()
	 * @model default="CaseOption" required="true"
	 * @generated
	 */
	ServiceTypeList getType();

	/**
	 * Sets the value of the '{@link arcane.Service#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see arcane.ServiceTypeList
	 * @see #getType()
	 * @generated
	 */
	void setType(ServiceTypeList value);

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link arcane.Interface#getRealisations <em>Realisations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' reference.
	 * @see #setInterface(Interface)
	 * @see arcane.ArcanePackage#getService_Interface()
	 * @see arcane.Interface#getRealisations
	 * @model opposite="realisations"
	 * @generated
	 */
	Interface getInterface();

	/**
	 * Sets the value of the '{@link arcane.Service#getInterface <em>Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' reference.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(Interface value);

} // Service
