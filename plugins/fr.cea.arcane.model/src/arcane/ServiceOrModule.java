/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Or Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.ServiceOrModule#getVersion <em>Version</em>}</li>
 *   <li>{@link arcane.ServiceOrModule#getAxlFilePath <em>Axl File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getServiceOrModule()
 * @model abstract="true"
 * @generated
 */
public interface ServiceOrModule extends PropertyContainer {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see arcane.ArcanePackage#getServiceOrModule_Version()
	 * @model default="1.0" required="true"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link arcane.ServiceOrModule#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Axl File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axl File Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axl File Path</em>' attribute.
	 * @see #setAxlFilePath(String)
	 * @see arcane.ArcanePackage#getServiceOrModule_AxlFilePath()
	 * @model required="true"
	 * @generated
	 */
	String getAxlFilePath();

	/**
	 * Sets the value of the '{@link arcane.ServiceOrModule#getAxlFilePath <em>Axl File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axl File Path</em>' attribute.
	 * @see #getAxlFilePath()
	 * @generated
	 */
	void setAxlFilePath(String value);

} // ServiceOrModule
