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
 * A representation of the literals of the enumeration '<em><b>Entry Point Location</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see arcane.ArcanePackage#getEntryPointLocation()
 * @model
 * @generated
 */
public enum EntryPointLocation implements Enumerator {
	/**
	 * The '<em><b>Compute Loop</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPUTE_LOOP_VALUE
	 * @generated
	 * @ordered
	 */
	COMPUTE_LOOP(0, "ComputeLoop", "ComputeLoop"),

	/**
	 * The '<em><b>On Mesh Changed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ON_MESH_CHANGED_VALUE
	 * @generated
	 * @ordered
	 */
	ON_MESH_CHANGED(1, "OnMeshChanged", "OnMeshChanged"),

	/**
	 * The '<em><b>On Mesh Refinement</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ON_MESH_REFINEMENT_VALUE
	 * @generated
	 * @ordered
	 */
	ON_MESH_REFINEMENT(2, "OnMeshRefinement", "OnMeshRefinement"),

	/**
	 * The '<em><b>Init</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INIT_VALUE
	 * @generated
	 * @ordered
	 */
	INIT(3, "Init", "Init"),

	/**
	 * The '<em><b>Continue Init</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTINUE_INIT_VALUE
	 * @generated
	 * @ordered
	 */
	CONTINUE_INIT(4, "ContinueInit", "ContinueInit"),

	/**
	 * The '<em><b>Start Init</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START_INIT_VALUE
	 * @generated
	 * @ordered
	 */
	START_INIT(5, "StartInit", "StartInit"),

	/**
	 * The '<em><b>Restore</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESTORE_VALUE
	 * @generated
	 * @ordered
	 */
	RESTORE(6, "Restore", "Restore"),

	/**
	 * The '<em><b>Build</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUILD_VALUE
	 * @generated
	 * @ordered
	 */
	BUILD(7, "Build", "Build"),

	/**
	 * The '<em><b>Exit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXIT_VALUE
	 * @generated
	 * @ordered
	 */
	EXIT(8, "Exit", "Exit");

	/**
	 * The '<em><b>Compute Loop</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Compute Loop</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPUTE_LOOP
	 * @model name="ComputeLoop"
	 * @generated
	 * @ordered
	 */
	public static final int COMPUTE_LOOP_VALUE = 0;

	/**
	 * The '<em><b>On Mesh Changed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>On Mesh Changed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ON_MESH_CHANGED
	 * @model name="OnMeshChanged"
	 * @generated
	 * @ordered
	 */
	public static final int ON_MESH_CHANGED_VALUE = 1;

	/**
	 * The '<em><b>On Mesh Refinement</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>On Mesh Refinement</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ON_MESH_REFINEMENT
	 * @model name="OnMeshRefinement"
	 * @generated
	 * @ordered
	 */
	public static final int ON_MESH_REFINEMENT_VALUE = 2;

	/**
	 * The '<em><b>Init</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Init</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INIT
	 * @model name="Init"
	 * @generated
	 * @ordered
	 */
	public static final int INIT_VALUE = 3;

	/**
	 * The '<em><b>Continue Init</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Continue Init</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTINUE_INIT
	 * @model name="ContinueInit"
	 * @generated
	 * @ordered
	 */
	public static final int CONTINUE_INIT_VALUE = 4;

	/**
	 * The '<em><b>Start Init</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Start Init</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #START_INIT
	 * @model name="StartInit"
	 * @generated
	 * @ordered
	 */
	public static final int START_INIT_VALUE = 5;

	/**
	 * The '<em><b>Restore</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Restore</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESTORE
	 * @model name="Restore"
	 * @generated
	 * @ordered
	 */
	public static final int RESTORE_VALUE = 6;

	/**
	 * The '<em><b>Build</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Build</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUILD
	 * @model name="Build"
	 * @generated
	 * @ordered
	 */
	public static final int BUILD_VALUE = 7;

	/**
	 * The '<em><b>Exit</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Exit</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXIT
	 * @model name="Exit"
	 * @generated
	 * @ordered
	 */
	public static final int EXIT_VALUE = 8;

	/**
	 * An array of all the '<em><b>Entry Point Location</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EntryPointLocation[] VALUES_ARRAY =
		new EntryPointLocation[] {
			COMPUTE_LOOP,
			ON_MESH_CHANGED,
			ON_MESH_REFINEMENT,
			INIT,
			CONTINUE_INIT,
			START_INIT,
			RESTORE,
			BUILD,
			EXIT,
		};

	/**
	 * A public read-only list of all the '<em><b>Entry Point Location</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EntryPointLocation> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Entry Point Location</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EntryPointLocation get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EntryPointLocation result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Entry Point Location</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EntryPointLocation getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EntryPointLocation result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Entry Point Location</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EntryPointLocation get(int value) {
		switch (value) {
			case COMPUTE_LOOP_VALUE: return COMPUTE_LOOP;
			case ON_MESH_CHANGED_VALUE: return ON_MESH_CHANGED;
			case ON_MESH_REFINEMENT_VALUE: return ON_MESH_REFINEMENT;
			case INIT_VALUE: return INIT;
			case CONTINUE_INIT_VALUE: return CONTINUE_INIT;
			case START_INIT_VALUE: return START_INIT;
			case RESTORE_VALUE: return RESTORE;
			case BUILD_VALUE: return BUILD;
			case EXIT_VALUE: return EXIT;
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
	private EntryPointLocation(int value, String name, String literal) {
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
	
} //EntryPointLocation
