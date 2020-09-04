/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Service Type List</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see arcane.ArcanePackage#getServiceTypeList()
 * @model
 * @generated
 */
public enum ServiceTypeList implements Enumerator {
	/**
	 * The '<em><b>Application</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #APPLICATION_VALUE
	 * @generated
	 * @ordered
	 */
	APPLICATION(0, "Application", "Application"),

	/**
	 * The '<em><b>Session</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SESSION_VALUE
	 * @generated
	 * @ordered
	 */
	SESSION(1, "Session", "Session"),

	/**
	 * The '<em><b>Sub Domain</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUB_DOMAIN_VALUE
	 * @generated
	 * @ordered
	 */
	SUB_DOMAIN(2, "SubDomain", "SubDomain"),

	/**
	 * The '<em><b>Case Option</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CASE_OPTION_VALUE
	 * @generated
	 * @ordered
	 */
	CASE_OPTION(3, "CaseOption", "CaseOption");

	/**
	 * The '<em><b>Application</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Application</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #APPLICATION
	 * @model name="Application"
	 * @generated
	 * @ordered
	 */
	public static final int APPLICATION_VALUE = 0;

	/**
	 * The '<em><b>Session</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Session</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SESSION
	 * @model name="Session"
	 * @generated
	 * @ordered
	 */
	public static final int SESSION_VALUE = 1;

	/**
	 * The '<em><b>Sub Domain</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sub Domain</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUB_DOMAIN
	 * @model name="SubDomain"
	 * @generated
	 * @ordered
	 */
	public static final int SUB_DOMAIN_VALUE = 2;

	/**
	 * The '<em><b>Case Option</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Case Option</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CASE_OPTION
	 * @model name="CaseOption"
	 * @generated
	 * @ordered
	 */
	public static final int CASE_OPTION_VALUE = 3;

	/**
	 * An array of all the '<em><b>Service Type List</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ServiceTypeList[] VALUES_ARRAY =
		new ServiceTypeList[] {
			APPLICATION,
			SESSION,
			SUB_DOMAIN,
			CASE_OPTION,
		};

	/**
	 * A public read-only list of all the '<em><b>Service Type List</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ServiceTypeList> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Service Type List</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServiceTypeList get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServiceTypeList result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Service Type List</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServiceTypeList getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServiceTypeList result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Service Type List</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServiceTypeList get(int value) {
		switch (value) {
			case APPLICATION_VALUE: return APPLICATION;
			case SESSION_VALUE: return SESSION;
			case SUB_DOMAIN_VALUE: return SUB_DOMAIN;
			case CASE_OPTION_VALUE: return CASE_OPTION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ServiceTypeList(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ServiceTypeList
