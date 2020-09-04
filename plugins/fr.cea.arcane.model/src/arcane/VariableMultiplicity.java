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
 * A representation of the literals of the enumeration '<em><b>Variable Multiplicity</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see arcane.ArcanePackage#getVariableMultiplicity()
 * @model
 * @generated
 */
public enum VariableMultiplicity implements Enumerator {
	/**
	 * The '<em><b>Scalar</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCALAR_VALUE
	 * @generated
	 * @ordered
	 */
	SCALAR(0, "Scalar", "Scalar"),

	/**
	 * The '<em><b>Array</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARRAY_VALUE
	 * @generated
	 * @ordered
	 */
	ARRAY(1, "Array", "Array"),

	/**
	 * The '<em><b>Array2</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARRAY2_VALUE
	 * @generated
	 * @ordered
	 */
	ARRAY2(2, "Array2", "Array2");

	/**
	 * The '<em><b>Scalar</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Scalar</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCALAR
	 * @model name="Scalar"
	 * @generated
	 * @ordered
	 */
	public static final int SCALAR_VALUE = 0;

	/**
	 * The '<em><b>Array</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Array</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARRAY
	 * @model name="Array"
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY_VALUE = 1;

	/**
	 * The '<em><b>Array2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Array2</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARRAY2
	 * @model name="Array2"
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY2_VALUE = 2;

	/**
	 * An array of all the '<em><b>Variable Multiplicity</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final VariableMultiplicity[] VALUES_ARRAY =
		new VariableMultiplicity[] {
			SCALAR,
			ARRAY,
			ARRAY2,
		};

	/**
	 * A public read-only list of all the '<em><b>Variable Multiplicity</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<VariableMultiplicity> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Variable Multiplicity</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariableMultiplicity get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VariableMultiplicity result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variable Multiplicity</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariableMultiplicity getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VariableMultiplicity result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variable Multiplicity</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariableMultiplicity get(int value) {
		switch (value) {
			case SCALAR_VALUE: return SCALAR;
			case ARRAY_VALUE: return ARRAY;
			case ARRAY2_VALUE: return ARRAY2;
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
	private VariableMultiplicity(int value, String name, String literal) {
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
	
} //VariableMultiplicity
