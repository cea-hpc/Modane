/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.EntryPoint#getLocation <em>Location</em>}</li>
 *   <li>{@link arcane.EntryPoint#getProperty <em>Property</em>}</li>
 *   <li>{@link arcane.EntryPoint#getContainingModule <em>Containing Module</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getEntryPoint()
 * @model
 * @generated
 */
public interface EntryPoint extends FuncOrEntryPoint {
	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * The literals are from the enumeration {@link arcane.EntryPointLocation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see arcane.EntryPointLocation
	 * @see #setLocation(EntryPointLocation)
	 * @see arcane.ArcanePackage#getEntryPoint_Location()
	 * @model required="true"
	 * @generated
	 */
	EntryPointLocation getLocation();

	/**
	 * Sets the value of the '{@link arcane.EntryPoint#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see arcane.EntryPointLocation
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(EntryPointLocation value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' attribute.
	 * The default value is <code>"None"</code>.
	 * The literals are from the enumeration {@link arcane.EntryPointProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' attribute.
	 * @see arcane.EntryPointProperty
	 * @see #setProperty(EntryPointProperty)
	 * @see arcane.ArcanePackage#getEntryPoint_Property()
	 * @model default="None" required="true"
	 * @generated
	 */
	EntryPointProperty getProperty();

	/**
	 * Sets the value of the '{@link arcane.EntryPoint#getProperty <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' attribute.
	 * @see arcane.EntryPointProperty
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(EntryPointProperty value);

	/**
	 * Returns the value of the '<em><b>Containing Module</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link arcane.Module#getEntryPoints <em>Entry Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Module</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Module</em>' container reference.
	 * @see #setContainingModule(Module)
	 * @see arcane.ArcanePackage#getEntryPoint_ContainingModule()
	 * @see arcane.Module#getEntryPoints
	 * @model opposite="entryPoints" required="true" transient="false"
	 * @generated
	 */
	Module getContainingModule();

	/**
	 * Sets the value of the '{@link arcane.EntryPoint#getContainingModule <em>Containing Module</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Module</em>' container reference.
	 * @see #getContainingModule()
	 * @generated
	 */
	void setContainingModule(Module value);

} // EntryPoint
