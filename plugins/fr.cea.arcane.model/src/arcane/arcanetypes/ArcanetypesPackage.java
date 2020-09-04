/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.arcanetypes;

import arcane.ArcanePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see arcane.arcanetypes.ArcanetypesFactory
 * @model kind="package"
 * @generated
 */
public interface ArcanetypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "arcanetypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://arcane.cea.fr/arcanetypes";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "arcanetypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArcanetypesPackage eINSTANCE = arcane.arcanetypes.impl.ArcanetypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link arcane.arcanetypes.impl.ArcaneTypesImpl <em>Arcane Types</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.arcanetypes.impl.ArcaneTypesImpl
	 * @see arcane.arcanetypes.impl.ArcanetypesPackageImpl#getArcaneTypes()
	 * @generated
	 */
	int ARCANE_TYPES = 0;

	/**
	 * The feature id for the '<em><b>Mesh Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCANE_TYPES__MESH_TYPES = 0;

	/**
	 * The feature id for the '<em><b>Simple Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCANE_TYPES__SIMPLE_TYPES = 1;

	/**
	 * The number of structural features of the '<em>Arcane Types</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCANE_TYPES_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link arcane.arcanetypes.impl.MeshTypeImpl <em>Mesh Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.arcanetypes.impl.MeshTypeImpl
	 * @see arcane.arcanetypes.impl.ArcanetypesPackageImpl#getMeshType()
	 * @generated
	 */
	int MESH_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_TYPE__NAME = ArcanePackage.PROPERTY_OR_ARGUMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_TYPE__DESCRIPTION = ArcanePackage.PROPERTY_OR_ARGUMENT_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_TYPE__USER_ENABLED = ArcanePackage.PROPERTY_OR_ARGUMENT_TYPE__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_TYPE__NAME_FR = ArcanePackage.PROPERTY_OR_ARGUMENT_TYPE__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_TYPE__ANNOTATIONS = ArcanePackage.PROPERTY_OR_ARGUMENT_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Used By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_TYPE__USED_BY = ArcanePackage.PROPERTY_OR_ARGUMENT_TYPE__USED_BY;

	/**
	 * The number of structural features of the '<em>Mesh Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_TYPE_FEATURE_COUNT = ArcanePackage.PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link arcane.arcanetypes.impl.ItemTypeImpl <em>Item Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.arcanetypes.impl.ItemTypeImpl
	 * @see arcane.arcanetypes.impl.ArcanetypesPackageImpl#getItemType()
	 * @generated
	 */
	int ITEM_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE__NAME = MESH_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE__DESCRIPTION = MESH_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE__USER_ENABLED = MESH_TYPE__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE__NAME_FR = MESH_TYPE__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE__ANNOTATIONS = MESH_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Used By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE__USED_BY = MESH_TYPE__USED_BY;

	/**
	 * The number of structural features of the '<em>Item Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE_FEATURE_COUNT = MESH_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link arcane.arcanetypes.impl.SimpleTypeImpl <em>Simple Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.arcanetypes.impl.SimpleTypeImpl
	 * @see arcane.arcanetypes.impl.ArcanetypesPackageImpl#getSimpleType()
	 * @generated
	 */
	int SIMPLE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE__NAME = ArcanePackage.PROPERTY_OR_ARGUMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE__DESCRIPTION = ArcanePackage.PROPERTY_OR_ARGUMENT_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE__USER_ENABLED = ArcanePackage.PROPERTY_OR_ARGUMENT_TYPE__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE__NAME_FR = ArcanePackage.PROPERTY_OR_ARGUMENT_TYPE__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE__ANNOTATIONS = ArcanePackage.PROPERTY_OR_ARGUMENT_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Used By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE__USED_BY = ArcanePackage.PROPERTY_OR_ARGUMENT_TYPE__USED_BY;

	/**
	 * The number of structural features of the '<em>Simple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE_FEATURE_COUNT = ArcanePackage.PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link arcane.arcanetypes.ArcaneTypes <em>Arcane Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arcane Types</em>'.
	 * @see arcane.arcanetypes.ArcaneTypes
	 * @generated
	 */
	EClass getArcaneTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link arcane.arcanetypes.ArcaneTypes#getMeshTypes <em>Mesh Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mesh Types</em>'.
	 * @see arcane.arcanetypes.ArcaneTypes#getMeshTypes()
	 * @see #getArcaneTypes()
	 * @generated
	 */
	EReference getArcaneTypes_MeshTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link arcane.arcanetypes.ArcaneTypes#getSimpleTypes <em>Simple Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Simple Types</em>'.
	 * @see arcane.arcanetypes.ArcaneTypes#getSimpleTypes()
	 * @see #getArcaneTypes()
	 * @generated
	 */
	EReference getArcaneTypes_SimpleTypes();

	/**
	 * Returns the meta object for class '{@link arcane.arcanetypes.ItemType <em>Item Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item Type</em>'.
	 * @see arcane.arcanetypes.ItemType
	 * @generated
	 */
	EClass getItemType();

	/**
	 * Returns the meta object for class '{@link arcane.arcanetypes.SimpleType <em>Simple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Type</em>'.
	 * @see arcane.arcanetypes.SimpleType
	 * @generated
	 */
	EClass getSimpleType();

	/**
	 * Returns the meta object for class '{@link arcane.arcanetypes.MeshType <em>Mesh Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mesh Type</em>'.
	 * @see arcane.arcanetypes.MeshType
	 * @generated
	 */
	EClass getMeshType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ArcanetypesFactory getArcanetypesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link arcane.arcanetypes.impl.ArcaneTypesImpl <em>Arcane Types</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.arcanetypes.impl.ArcaneTypesImpl
		 * @see arcane.arcanetypes.impl.ArcanetypesPackageImpl#getArcaneTypes()
		 * @generated
		 */
		EClass ARCANE_TYPES = eINSTANCE.getArcaneTypes();

		/**
		 * The meta object literal for the '<em><b>Mesh Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCANE_TYPES__MESH_TYPES = eINSTANCE.getArcaneTypes_MeshTypes();

		/**
		 * The meta object literal for the '<em><b>Simple Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCANE_TYPES__SIMPLE_TYPES = eINSTANCE.getArcaneTypes_SimpleTypes();

		/**
		 * The meta object literal for the '{@link arcane.arcanetypes.impl.ItemTypeImpl <em>Item Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.arcanetypes.impl.ItemTypeImpl
		 * @see arcane.arcanetypes.impl.ArcanetypesPackageImpl#getItemType()
		 * @generated
		 */
		EClass ITEM_TYPE = eINSTANCE.getItemType();

		/**
		 * The meta object literal for the '{@link arcane.arcanetypes.impl.SimpleTypeImpl <em>Simple Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.arcanetypes.impl.SimpleTypeImpl
		 * @see arcane.arcanetypes.impl.ArcanetypesPackageImpl#getSimpleType()
		 * @generated
		 */
		EClass SIMPLE_TYPE = eINSTANCE.getSimpleType();

		/**
		 * The meta object literal for the '{@link arcane.arcanetypes.impl.MeshTypeImpl <em>Mesh Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.arcanetypes.impl.MeshTypeImpl
		 * @see arcane.arcanetypes.impl.ArcanetypesPackageImpl#getMeshType()
		 * @generated
		 */
		EClass MESH_TYPE = eINSTANCE.getMeshType();

	}

} //ArcanetypesPackage
