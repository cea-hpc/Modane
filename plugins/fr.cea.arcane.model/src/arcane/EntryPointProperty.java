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
 * A representation of the literals of the enumeration '<em><b>Entry Point Property</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see arcane.ArcanePackage#getEntryPointProperty()
 * @model
 * @generated
 */
public enum EntryPointProperty implements Enumerator {
	/**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(0, "None", "None"),

	/**
	 * The '<em><b>Auto Load Begin</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTO_LOAD_BEGIN_VALUE
	 * @generated
	 * @ordered
	 */
	AUTO_LOAD_BEGIN(1, "AutoLoadBegin", "AutoLoadBegin"),

	/**
	 * The '<em><b>Auto Load End</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTO_LOAD_END_VALUE
	 * @generated
	 * @ordered
	 */
	AUTO_LOAD_END(2, "AutoLoadEnd", "AutoLoadEnd");

	/**
	 * The '<em><b>None</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>None</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @model name="None"
	 * @generated
	 * @ordered
	 */
	public static final int NONE_VALUE = 0;

	/**
	 * The '<em><b>Auto Load Begin</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Auto Load Begin</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUTO_LOAD_BEGIN
	 * @model name="AutoLoadBegin"
	 * @generated
	 * @ordered
	 */
	public static final int AUTO_LOAD_BEGIN_VALUE = 1;

	/**
	 * The '<em><b>Auto Load End</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Auto Load End</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUTO_LOAD_END
	 * @model name="AutoLoadEnd"
	 * @generated
	 * @ordered
	 */
	public static final int AUTO_LOAD_END_VALUE = 2;

	/**
	 * An array of all the '<em><b>Entry Point Property</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EntryPointProperty[] VALUES_ARRAY =
		new EntryPointProperty[] {
			NONE,
			AUTO_LOAD_BEGIN,
			AUTO_LOAD_END,
		};

	/**
	 * A public read-only list of all the '<em><b>Entry Point Property</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EntryPointProperty> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Entry Point Property</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EntryPointProperty get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EntryPointProperty result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Entry Point Property</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EntryPointProperty getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EntryPointProperty result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Entry Point Property</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EntryPointProperty get(int value) {
		switch (value) {
			case NONE_VALUE: return NONE;
			case AUTO_LOAD_BEGIN_VALUE: return AUTO_LOAD_BEGIN;
			case AUTO_LOAD_END_VALUE: return AUTO_LOAD_END;
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
	private EntryPointProperty(int value, String name, String literal) {
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
	
} //EntryPointProperty
