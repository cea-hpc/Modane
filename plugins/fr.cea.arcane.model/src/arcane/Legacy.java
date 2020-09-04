/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Legacy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.Legacy#getOriginNamespace <em>Origin Namespace</em>}</li>
 *   <li>{@link arcane.Legacy#getProvider <em>Provider</em>}</li>
 *   <li>{@link arcane.Legacy#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getLegacy()
 * @model
 * @generated
 */
public interface Legacy extends PropertyOrArgumentType, PackagedElement {
	/**
	 * Returns the value of the '<em><b>Origin Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin Namespace</em>' attribute.
	 * @see #setOriginNamespace(String)
	 * @see arcane.ArcanePackage#getLegacy_OriginNamespace()
	 * @model
	 * @generated
	 */
	String getOriginNamespace();

	/**
	 * Sets the value of the '{@link arcane.Legacy#getOriginNamespace <em>Origin Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin Namespace</em>' attribute.
	 * @see #getOriginNamespace()
	 * @generated
	 */
	void setOriginNamespace(String value);

	/**
	 * Returns the value of the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider</em>' attribute.
	 * @see #setProvider(String)
	 * @see arcane.ArcanePackage#getLegacy_Provider()
	 * @model
	 * @generated
	 */
	String getProvider();

	/**
	 * Sets the value of the '{@link arcane.Legacy#getProvider <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider</em>' attribute.
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(String value);

	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(String)
	 * @see arcane.ArcanePackage#getLegacy_File()
	 * @model required="true"
	 * @generated
	 */
	String getFile();

	/**
	 * Sets the value of the '{@link arcane.Legacy#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(String value);

} // Legacy
