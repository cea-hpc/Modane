/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see arcane.ArcaneFactory
 * @model kind="package"
 * @generated
 */
public interface ArcanePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "arcane";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://arcane.cea.fr";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "arcane";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArcanePackage eINSTANCE = arcane.impl.ArcanePackageImpl.init();

	/**
	 * The meta object id for the '{@link arcane.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.NamedElementImpl
	 * @see arcane.impl.ArcanePackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__USER_ENABLED = 2;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME_FR = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__ANNOTATIONS = 4;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link arcane.impl.FuncOrEntryPointImpl <em>Func Or Entry Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.FuncOrEntryPointImpl
	 * @see arcane.impl.ArcanePackageImpl#getFuncOrEntryPoint()
	 * @generated
	 */
	int FUNC_OR_ENTRY_POINT = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_OR_ENTRY_POINT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_OR_ENTRY_POINT__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_OR_ENTRY_POINT__USER_ENABLED = NAMED_ELEMENT__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_OR_ENTRY_POINT__NAME_FR = NAMED_ELEMENT__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_OR_ENTRY_POINT__ANNOTATIONS = NAMED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>In Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_OR_ENTRY_POINT__IN_VARIABLES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Out Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_OR_ENTRY_POINT__OUT_VARIABLES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Called Funcs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_OR_ENTRY_POINT__CALLED_FUNCS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Func Or Entry Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_OR_ENTRY_POINT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link arcane.impl.FuncImpl <em>Func</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.FuncImpl
	 * @see arcane.impl.ArcanePackageImpl#getFunc()
	 * @generated
	 */
	int FUNC = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC__NAME = FUNC_OR_ENTRY_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC__DESCRIPTION = FUNC_OR_ENTRY_POINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC__USER_ENABLED = FUNC_OR_ENTRY_POINT__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC__NAME_FR = FUNC_OR_ENTRY_POINT__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC__ANNOTATIONS = FUNC_OR_ENTRY_POINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>In Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC__IN_VARIABLES = FUNC_OR_ENTRY_POINT__IN_VARIABLES;

	/**
	 * The feature id for the '<em><b>Out Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC__OUT_VARIABLES = FUNC_OR_ENTRY_POINT__OUT_VARIABLES;

	/**
	 * The feature id for the '<em><b>Called Funcs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC__CALLED_FUNCS = FUNC_OR_ENTRY_POINT__CALLED_FUNCS;

	/**
	 * The feature id for the '<em><b>Support</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC__SUPPORT = FUNC_OR_ENTRY_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parallel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC__PARALLEL = FUNC_OR_ENTRY_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Args</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC__ARGS = FUNC_OR_ENTRY_POINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC__CONTAINER = FUNC_OR_ENTRY_POINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Item Type Specialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC__ITEM_TYPE_SPECIALIZED = FUNC_OR_ENTRY_POINT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Return Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC__RETURN_ARGUMENT = FUNC_OR_ENTRY_POINT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Func</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_FEATURE_COUNT = FUNC_OR_ENTRY_POINT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link arcane.impl.PropertyOrArgumentImpl <em>Property Or Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.PropertyOrArgumentImpl
	 * @see arcane.impl.ArcanePackageImpl#getPropertyOrArgument()
	 * @generated
	 */
	int PROPERTY_OR_ARGUMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT__USER_ENABLED = NAMED_ELEMENT__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT__NAME_FR = NAMED_ELEMENT__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT__ANNOTATIONS = NAMED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT__DEFAULT_VALUE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT__LOWER_BOUND = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT__UPPER_BOUND = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Property Or Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link arcane.impl.PropertyOrArgumentTypeImpl <em>Property Or Argument Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.PropertyOrArgumentTypeImpl
	 * @see arcane.impl.ArcanePackageImpl#getPropertyOrArgumentType()
	 * @generated
	 */
	int PROPERTY_OR_ARGUMENT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT_TYPE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT_TYPE__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT_TYPE__USER_ENABLED = NAMED_ELEMENT__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT_TYPE__NAME_FR = NAMED_ELEMENT__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT_TYPE__ANNOTATIONS = NAMED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Used By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT_TYPE__USED_BY = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Or Argument Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link arcane.impl.PackagedElementImpl <em>Packaged Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.PackagedElementImpl
	 * @see arcane.impl.ArcanePackageImpl#getPackagedElement()
	 * @generated
	 */
	int PACKAGED_ELEMENT = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGED_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGED_ELEMENT__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGED_ELEMENT__USER_ENABLED = NAMED_ELEMENT__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGED_ELEMENT__NAME_FR = NAMED_ELEMENT__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGED_ELEMENT__ANNOTATIONS = NAMED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Containing Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGED_ELEMENT__CONTAINING_PACKAGE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Packaged Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGED_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link arcane.impl.PropertyContainerImpl <em>Property Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.PropertyContainerImpl
	 * @see arcane.impl.ArcanePackageImpl#getPropertyContainer()
	 * @generated
	 */
	int PROPERTY_CONTAINER = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTAINER__NAME = PACKAGED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTAINER__DESCRIPTION = PACKAGED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTAINER__USER_ENABLED = PACKAGED_ELEMENT__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTAINER__NAME_FR = PACKAGED_ELEMENT__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTAINER__ANNOTATIONS = PACKAGED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Containing Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTAINER__CONTAINING_PACKAGE = PACKAGED_ELEMENT__CONTAINING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTAINER__PROPERTIES = PACKAGED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTAINER_FEATURE_COUNT = PACKAGED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link arcane.impl.ServiceOrModuleImpl <em>Service Or Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.ServiceOrModuleImpl
	 * @see arcane.impl.ArcanePackageImpl#getServiceOrModule()
	 * @generated
	 */
	int SERVICE_OR_MODULE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OR_MODULE__NAME = PROPERTY_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OR_MODULE__DESCRIPTION = PROPERTY_CONTAINER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OR_MODULE__USER_ENABLED = PROPERTY_CONTAINER__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OR_MODULE__NAME_FR = PROPERTY_CONTAINER__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OR_MODULE__ANNOTATIONS = PROPERTY_CONTAINER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Containing Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OR_MODULE__CONTAINING_PACKAGE = PROPERTY_CONTAINER__CONTAINING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OR_MODULE__PROPERTIES = PROPERTY_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OR_MODULE__VERSION = PROPERTY_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Axl File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OR_MODULE__AXL_FILE_PATH = PROPERTY_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Service Or Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OR_MODULE_FEATURE_COUNT = PROPERTY_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link arcane.impl.ModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.ModuleImpl
	 * @see arcane.impl.ArcanePackageImpl#getModule()
	 * @generated
	 */
	int MODULE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__NAME = SERVICE_OR_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__DESCRIPTION = SERVICE_OR_MODULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__USER_ENABLED = SERVICE_OR_MODULE__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__NAME_FR = SERVICE_OR_MODULE__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ANNOTATIONS = SERVICE_OR_MODULE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Containing Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__CONTAINING_PACKAGE = SERVICE_OR_MODULE__CONTAINING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__PROPERTIES = SERVICE_OR_MODULE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__VERSION = SERVICE_OR_MODULE__VERSION;

	/**
	 * The feature id for the '<em><b>Axl File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__AXL_FILE_PATH = SERVICE_OR_MODULE__AXL_FILE_PATH;

	/**
	 * The feature id for the '<em><b>Entry Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ENTRY_POINTS = SERVICE_OR_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = SERVICE_OR_MODULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link arcane.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.ServiceImpl
	 * @see arcane.impl.ArcanePackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = SERVICE_OR_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DESCRIPTION = SERVICE_OR_MODULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__USER_ENABLED = SERVICE_OR_MODULE__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME_FR = SERVICE_OR_MODULE__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ANNOTATIONS = SERVICE_OR_MODULE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Containing Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__CONTAINING_PACKAGE = SERVICE_OR_MODULE__CONTAINING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PROPERTIES = SERVICE_OR_MODULE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__VERSION = SERVICE_OR_MODULE__VERSION;

	/**
	 * The feature id for the '<em><b>Axl File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__AXL_FILE_PATH = SERVICE_OR_MODULE__AXL_FILE_PATH;

	/**
	 * The feature id for the '<em><b>Funcs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__FUNCS = SERVICE_OR_MODULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__TYPE = SERVICE_OR_MODULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__INTERFACE = SERVICE_OR_MODULE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = SERVICE_OR_MODULE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link arcane.impl.EntryPointImpl <em>Entry Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.EntryPointImpl
	 * @see arcane.impl.ArcanePackageImpl#getEntryPoint()
	 * @generated
	 */
	int ENTRY_POINT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__NAME = FUNC_OR_ENTRY_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__DESCRIPTION = FUNC_OR_ENTRY_POINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__USER_ENABLED = FUNC_OR_ENTRY_POINT__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__NAME_FR = FUNC_OR_ENTRY_POINT__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__ANNOTATIONS = FUNC_OR_ENTRY_POINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>In Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__IN_VARIABLES = FUNC_OR_ENTRY_POINT__IN_VARIABLES;

	/**
	 * The feature id for the '<em><b>Out Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__OUT_VARIABLES = FUNC_OR_ENTRY_POINT__OUT_VARIABLES;

	/**
	 * The feature id for the '<em><b>Called Funcs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__CALLED_FUNCS = FUNC_OR_ENTRY_POINT__CALLED_FUNCS;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__LOCATION = FUNC_OR_ENTRY_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__PROPERTY = FUNC_OR_ENTRY_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Containing Module</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__CONTAINING_MODULE = FUNC_OR_ENTRY_POINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Entry Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT_FEATURE_COUNT = FUNC_OR_ENTRY_POINT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link arcane.impl.PackageImpl <em>Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.PackageImpl
	 * @see arcane.impl.ArcanePackageImpl#getPackage()
	 * @generated
	 */
	int PACKAGE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAME = PACKAGED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__DESCRIPTION = PACKAGED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__USER_ENABLED = PACKAGED_ELEMENT__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAME_FR = PACKAGED_ELEMENT__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__ANNOTATIONS = PACKAGED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Containing Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__CONTAINING_PACKAGE = PACKAGED_ELEMENT__CONTAINING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__ELEMENTS = PACKAGED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FEATURE_COUNT = PACKAGED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link arcane.impl.StructImpl <em>Struct</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.StructImpl
	 * @see arcane.impl.ArcanePackageImpl#getStruct()
	 * @generated
	 */
	int STRUCT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__NAME = PROPERTY_OR_ARGUMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__DESCRIPTION = PROPERTY_OR_ARGUMENT_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__USER_ENABLED = PROPERTY_OR_ARGUMENT_TYPE__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__NAME_FR = PROPERTY_OR_ARGUMENT_TYPE__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__ANNOTATIONS = PROPERTY_OR_ARGUMENT_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Used By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__USED_BY = PROPERTY_OR_ARGUMENT_TYPE__USED_BY;

	/**
	 * The feature id for the '<em><b>Containing Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__CONTAINING_PACKAGE = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__PROPERTIES = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__PARENTS = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Struct</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_FEATURE_COUNT = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link arcane.impl.EnumerationImpl <em>Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.EnumerationImpl
	 * @see arcane.impl.ArcanePackageImpl#getEnumeration()
	 * @generated
	 */
	int ENUMERATION = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NAME = PROPERTY_OR_ARGUMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__DESCRIPTION = PROPERTY_OR_ARGUMENT_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__USER_ENABLED = PROPERTY_OR_ARGUMENT_TYPE__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NAME_FR = PROPERTY_OR_ARGUMENT_TYPE__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__ANNOTATIONS = PROPERTY_OR_ARGUMENT_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Used By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__USED_BY = PROPERTY_OR_ARGUMENT_TYPE__USED_BY;

	/**
	 * The feature id for the '<em><b>Containing Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__CONTAINING_PACKAGE = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__LITERALS = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_FEATURE_COUNT = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link arcane.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.InterfaceImpl
	 * @see arcane.impl.ArcanePackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__NAME = PROPERTY_OR_ARGUMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__DESCRIPTION = PROPERTY_OR_ARGUMENT_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__USER_ENABLED = PROPERTY_OR_ARGUMENT_TYPE__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__NAME_FR = PROPERTY_OR_ARGUMENT_TYPE__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__ANNOTATIONS = PROPERTY_OR_ARGUMENT_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Used By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__USED_BY = PROPERTY_OR_ARGUMENT_TYPE__USED_BY;

	/**
	 * The feature id for the '<em><b>Containing Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__CONTAINING_PACKAGE = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Funcs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__FUNCS = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__PROPERTIES = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__PARENTS = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__CHILDREN = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Realisations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__REALISATIONS = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link arcane.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.VariableImpl
	 * @see arcane.impl.ArcanePackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = PACKAGED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__DESCRIPTION = PACKAGED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__USER_ENABLED = PACKAGED_ELEMENT__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME_FR = PACKAGED_ELEMENT__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ANNOTATIONS = PACKAGED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Containing Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__CONTAINING_PACKAGE = PACKAGED_ELEMENT__CONTAINING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__MULTIPLICITY = PACKAGED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = PACKAGED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Support</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__SUPPORT = PACKAGED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Dump</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__DUMP = PACKAGED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Restore</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__RESTORE = PACKAGED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Execution Depend</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__EXECUTION_DEPEND = PACKAGED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Need Sync</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NEED_SYNC = PACKAGED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ABSTRACT = PACKAGED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = PACKAGED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link arcane.impl.ArgumentImpl <em>Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.ArgumentImpl
	 * @see arcane.impl.ArcanePackageImpl#getArgument()
	 * @generated
	 */
	int ARGUMENT = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__NAME = PROPERTY_OR_ARGUMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__DESCRIPTION = PROPERTY_OR_ARGUMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__USER_ENABLED = PROPERTY_OR_ARGUMENT__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__NAME_FR = PROPERTY_OR_ARGUMENT__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__ANNOTATIONS = PROPERTY_OR_ARGUMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__TYPE = PROPERTY_OR_ARGUMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__DEFAULT_VALUE = PROPERTY_OR_ARGUMENT__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__LOWER_BOUND = PROPERTY_OR_ARGUMENT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__UPPER_BOUND = PROPERTY_OR_ARGUMENT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__DIRECTION = PROPERTY_OR_ARGUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_FEATURE_COUNT = PROPERTY_OR_ARGUMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link arcane.impl.LegacyImpl <em>Legacy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.LegacyImpl
	 * @see arcane.impl.ArcanePackageImpl#getLegacy()
	 * @generated
	 */
	int LEGACY = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEGACY__NAME = PROPERTY_OR_ARGUMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEGACY__DESCRIPTION = PROPERTY_OR_ARGUMENT_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEGACY__USER_ENABLED = PROPERTY_OR_ARGUMENT_TYPE__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEGACY__NAME_FR = PROPERTY_OR_ARGUMENT_TYPE__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEGACY__ANNOTATIONS = PROPERTY_OR_ARGUMENT_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Used By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEGACY__USED_BY = PROPERTY_OR_ARGUMENT_TYPE__USED_BY;

	/**
	 * The feature id for the '<em><b>Containing Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEGACY__CONTAINING_PACKAGE = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Origin Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEGACY__ORIGIN_NAMESPACE = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEGACY__PROVIDER = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEGACY__FILE = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Legacy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEGACY_FEATURE_COUNT = PROPERTY_OR_ARGUMENT_TYPE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link arcane.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.EnumerationLiteralImpl
	 * @see arcane.impl.ArcanePackageImpl#getEnumerationLiteral()
	 * @generated
	 */
	int ENUMERATION_LITERAL = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__USER_ENABLED = NAMED_ELEMENT__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__NAME_FR = NAMED_ELEMENT__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__ANNOTATIONS = NAMED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Containing Enumeration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__CONTAINING_ENUMERATION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link arcane.impl.FuncContainerImpl <em>Func Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.FuncContainerImpl
	 * @see arcane.impl.ArcanePackageImpl#getFuncContainer()
	 * @generated
	 */
	int FUNC_CONTAINER = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_CONTAINER__NAME = PACKAGED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_CONTAINER__DESCRIPTION = PACKAGED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_CONTAINER__USER_ENABLED = PACKAGED_ELEMENT__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_CONTAINER__NAME_FR = PACKAGED_ELEMENT__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_CONTAINER__ANNOTATIONS = PACKAGED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Containing Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_CONTAINER__CONTAINING_PACKAGE = PACKAGED_ELEMENT__CONTAINING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Funcs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_CONTAINER__FUNCS = PACKAGED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Func Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_CONTAINER_FEATURE_COUNT = PACKAGED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link arcane.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.PropertyImpl
	 * @see arcane.impl.ArcanePackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = PROPERTY_OR_ARGUMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DESCRIPTION = PROPERTY_OR_ARGUMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>User Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__USER_ENABLED = PROPERTY_OR_ARGUMENT__USER_ENABLED;

	/**
	 * The feature id for the '<em><b>Name Fr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME_FR = PROPERTY_OR_ARGUMENT__NAME_FR;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__ANNOTATIONS = PROPERTY_OR_ARGUMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TYPE = PROPERTY_OR_ARGUMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DEFAULT_VALUE = PROPERTY_OR_ARGUMENT__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__LOWER_BOUND = PROPERTY_OR_ARGUMENT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__UPPER_BOUND = PROPERTY_OR_ARGUMENT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Containing Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__CONTAINING_CONTAINER = PROPERTY_OR_ARGUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = PROPERTY_OR_ARGUMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link arcane.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.impl.AnnotationImpl
	 * @see arcane.impl.ArcanePackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 20;

	/**
	 * The feature id for the '<em><b>Msg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__MSG = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__KIND = 1;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__LEVEL = 2;

	/**
	 * The feature id for the '<em><b>Xpath Expr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__XPATH_EXPR = 3;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link arcane.ServiceTypeList <em>Service Type List</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.ServiceTypeList
	 * @see arcane.impl.ArcanePackageImpl#getServiceTypeList()
	 * @generated
	 */
	int SERVICE_TYPE_LIST = 22;

	/**
	 * The meta object id for the '{@link arcane.EntryPointLocation <em>Entry Point Location</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.EntryPointLocation
	 * @see arcane.impl.ArcanePackageImpl#getEntryPointLocation()
	 * @generated
	 */
	int ENTRY_POINT_LOCATION = 23;

	/**
	 * The meta object id for the '{@link arcane.EntryPointProperty <em>Entry Point Property</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.EntryPointProperty
	 * @see arcane.impl.ArcanePackageImpl#getEntryPointProperty()
	 * @generated
	 */
	int ENTRY_POINT_PROPERTY = 24;

	/**
	 * The meta object id for the '{@link arcane.VariableMultiplicity <em>Variable Multiplicity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.VariableMultiplicity
	 * @see arcane.impl.ArcanePackageImpl#getVariableMultiplicity()
	 * @generated
	 */
	int VARIABLE_MULTIPLICITY = 25;

	/**
	 * The meta object id for the '{@link arcane.ArgDirection <em>Arg Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.ArgDirection
	 * @see arcane.impl.ArcanePackageImpl#getArgDirection()
	 * @generated
	 */
	int ARG_DIRECTION = 26;


	/**
	 * The meta object id for the '{@link arcane.AnnotationLevels <em>Annotation Levels</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arcane.AnnotationLevels
	 * @see arcane.impl.ArcanePackageImpl#getAnnotationLevels()
	 * @generated
	 */
	int ANNOTATION_LEVELS = 27;


	/**
	 * Returns the meta object for class '{@link arcane.Func <em>Func</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Func</em>'.
	 * @see arcane.Func
	 * @generated
	 */
	EClass getFunc();

	/**
	 * Returns the meta object for the reference '{@link arcane.Func#getSupport <em>Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Support</em>'.
	 * @see arcane.Func#getSupport()
	 * @see #getFunc()
	 * @generated
	 */
	EReference getFunc_Support();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Func#isParallel <em>Parallel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parallel</em>'.
	 * @see arcane.Func#isParallel()
	 * @see #getFunc()
	 * @generated
	 */
	EAttribute getFunc_Parallel();

	/**
	 * Returns the meta object for the containment reference list '{@link arcane.Func#getArgs <em>Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Args</em>'.
	 * @see arcane.Func#getArgs()
	 * @see #getFunc()
	 * @generated
	 */
	EReference getFunc_Args();

	/**
	 * Returns the meta object for the container reference '{@link arcane.Func#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see arcane.Func#getContainer()
	 * @see #getFunc()
	 * @generated
	 */
	EReference getFunc_Container();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Func#isItemTypeSpecialized <em>Item Type Specialized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Item Type Specialized</em>'.
	 * @see arcane.Func#isItemTypeSpecialized()
	 * @see #getFunc()
	 * @generated
	 */
	EAttribute getFunc_ItemTypeSpecialized();

	/**
	 * Returns the meta object for the containment reference '{@link arcane.Func#getReturnArgument <em>Return Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Argument</em>'.
	 * @see arcane.Func#getReturnArgument()
	 * @see #getFunc()
	 * @generated
	 */
	EReference getFunc_ReturnArgument();

	/**
	 * Returns the meta object for class '{@link arcane.PropertyOrArgument <em>Property Or Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Or Argument</em>'.
	 * @see arcane.PropertyOrArgument
	 * @generated
	 */
	EClass getPropertyOrArgument();

	/**
	 * Returns the meta object for the reference '{@link arcane.PropertyOrArgument#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see arcane.PropertyOrArgument#getType()
	 * @see #getPropertyOrArgument()
	 * @generated
	 */
	EReference getPropertyOrArgument_Type();

	/**
	 * Returns the meta object for the attribute '{@link arcane.PropertyOrArgument#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see arcane.PropertyOrArgument#getDefaultValue()
	 * @see #getPropertyOrArgument()
	 * @generated
	 */
	EAttribute getPropertyOrArgument_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link arcane.PropertyOrArgument#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see arcane.PropertyOrArgument#getLowerBound()
	 * @see #getPropertyOrArgument()
	 * @generated
	 */
	EAttribute getPropertyOrArgument_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link arcane.PropertyOrArgument#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see arcane.PropertyOrArgument#getUpperBound()
	 * @see #getPropertyOrArgument()
	 * @generated
	 */
	EAttribute getPropertyOrArgument_UpperBound();

	/**
	 * Returns the meta object for class '{@link arcane.PropertyOrArgumentType <em>Property Or Argument Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Or Argument Type</em>'.
	 * @see arcane.PropertyOrArgumentType
	 * @generated
	 */
	EClass getPropertyOrArgumentType();

	/**
	 * Returns the meta object for the reference list '{@link arcane.PropertyOrArgumentType#getUsedBy <em>Used By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Used By</em>'.
	 * @see arcane.PropertyOrArgumentType#getUsedBy()
	 * @see #getPropertyOrArgumentType()
	 * @generated
	 */
	EReference getPropertyOrArgumentType_UsedBy();

	/**
	 * Returns the meta object for class '{@link arcane.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see arcane.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link arcane.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see arcane.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link arcane.NamedElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see arcane.NamedElement#getDescription()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Description();

	/**
	 * Returns the meta object for the attribute '{@link arcane.NamedElement#isUserEnabled <em>User Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Enabled</em>'.
	 * @see arcane.NamedElement#isUserEnabled()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_UserEnabled();

	/**
	 * Returns the meta object for the attribute '{@link arcane.NamedElement#getNameFr <em>Name Fr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Fr</em>'.
	 * @see arcane.NamedElement#getNameFr()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_NameFr();

	/**
	 * Returns the meta object for the containment reference list '{@link arcane.NamedElement#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see arcane.NamedElement#getAnnotations()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Annotations();

	/**
	 * Returns the meta object for class '{@link arcane.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see arcane.Module
	 * @generated
	 */
	EClass getModule();

	/**
	 * Returns the meta object for the containment reference list '{@link arcane.Module#getEntryPoints <em>Entry Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entry Points</em>'.
	 * @see arcane.Module#getEntryPoints()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_EntryPoints();

	/**
	 * Returns the meta object for class '{@link arcane.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see arcane.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Service#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see arcane.Service#getType()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Type();

	/**
	 * Returns the meta object for the reference '{@link arcane.Service#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interface</em>'.
	 * @see arcane.Service#getInterface()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Interface();

	/**
	 * Returns the meta object for class '{@link arcane.ServiceOrModule <em>Service Or Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Or Module</em>'.
	 * @see arcane.ServiceOrModule
	 * @generated
	 */
	EClass getServiceOrModule();

	/**
	 * Returns the meta object for the attribute '{@link arcane.ServiceOrModule#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see arcane.ServiceOrModule#getVersion()
	 * @see #getServiceOrModule()
	 * @generated
	 */
	EAttribute getServiceOrModule_Version();

	/**
	 * Returns the meta object for the attribute '{@link arcane.ServiceOrModule#getAxlFilePath <em>Axl File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Axl File Path</em>'.
	 * @see arcane.ServiceOrModule#getAxlFilePath()
	 * @see #getServiceOrModule()
	 * @generated
	 */
	EAttribute getServiceOrModule_AxlFilePath();

	/**
	 * Returns the meta object for class '{@link arcane.EntryPoint <em>Entry Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry Point</em>'.
	 * @see arcane.EntryPoint
	 * @generated
	 */
	EClass getEntryPoint();

	/**
	 * Returns the meta object for the attribute '{@link arcane.EntryPoint#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see arcane.EntryPoint#getLocation()
	 * @see #getEntryPoint()
	 * @generated
	 */
	EAttribute getEntryPoint_Location();

	/**
	 * Returns the meta object for the attribute '{@link arcane.EntryPoint#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property</em>'.
	 * @see arcane.EntryPoint#getProperty()
	 * @see #getEntryPoint()
	 * @generated
	 */
	EAttribute getEntryPoint_Property();

	/**
	 * Returns the meta object for the container reference '{@link arcane.EntryPoint#getContainingModule <em>Containing Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Module</em>'.
	 * @see arcane.EntryPoint#getContainingModule()
	 * @see #getEntryPoint()
	 * @generated
	 */
	EReference getEntryPoint_ContainingModule();

	/**
	 * Returns the meta object for class '{@link arcane.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see arcane.Package
	 * @generated
	 */
	EClass getPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link arcane.Package#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see arcane.Package#getElements()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_Elements();

	/**
	 * Returns the meta object for class '{@link arcane.Struct <em>Struct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Struct</em>'.
	 * @see arcane.Struct
	 * @generated
	 */
	EClass getStruct();

	/**
	 * Returns the meta object for the reference list '{@link arcane.Struct#getParents <em>Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parents</em>'.
	 * @see arcane.Struct#getParents()
	 * @see #getStruct()
	 * @generated
	 */
	EReference getStruct_Parents();

	/**
	 * Returns the meta object for class '{@link arcane.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see arcane.Enumeration
	 * @generated
	 */
	EClass getEnumeration();

	/**
	 * Returns the meta object for the containment reference list '{@link arcane.Enumeration#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see arcane.Enumeration#getLiterals()
	 * @see #getEnumeration()
	 * @generated
	 */
	EReference getEnumeration_Literals();

	/**
	 * Returns the meta object for class '{@link arcane.FuncOrEntryPoint <em>Func Or Entry Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Func Or Entry Point</em>'.
	 * @see arcane.FuncOrEntryPoint
	 * @generated
	 */
	EClass getFuncOrEntryPoint();

	/**
	 * Returns the meta object for the reference list '{@link arcane.FuncOrEntryPoint#getInVariables <em>In Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Variables</em>'.
	 * @see arcane.FuncOrEntryPoint#getInVariables()
	 * @see #getFuncOrEntryPoint()
	 * @generated
	 */
	EReference getFuncOrEntryPoint_InVariables();

	/**
	 * Returns the meta object for the reference list '{@link arcane.FuncOrEntryPoint#getOutVariables <em>Out Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Out Variables</em>'.
	 * @see arcane.FuncOrEntryPoint#getOutVariables()
	 * @see #getFuncOrEntryPoint()
	 * @generated
	 */
	EReference getFuncOrEntryPoint_OutVariables();

	/**
	 * Returns the meta object for the reference list '{@link arcane.FuncOrEntryPoint#getCalledFuncs <em>Called Funcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Called Funcs</em>'.
	 * @see arcane.FuncOrEntryPoint#getCalledFuncs()
	 * @see #getFuncOrEntryPoint()
	 * @generated
	 */
	EReference getFuncOrEntryPoint_CalledFuncs();

	/**
	 * Returns the meta object for class '{@link arcane.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see arcane.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for the reference list '{@link arcane.Interface#getParents <em>Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parents</em>'.
	 * @see arcane.Interface#getParents()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Parents();

	/**
	 * Returns the meta object for the reference list '{@link arcane.Interface#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see arcane.Interface#getChildren()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Children();

	/**
	 * Returns the meta object for the reference list '{@link arcane.Interface#getRealisations <em>Realisations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realisations</em>'.
	 * @see arcane.Interface#getRealisations()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Realisations();

	/**
	 * Returns the meta object for class '{@link arcane.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see arcane.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Variable#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see arcane.Variable#getMultiplicity()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Multiplicity();

	/**
	 * Returns the meta object for the reference '{@link arcane.Variable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see arcane.Variable#getType()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Type();

	/**
	 * Returns the meta object for the reference '{@link arcane.Variable#getSupport <em>Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Support</em>'.
	 * @see arcane.Variable#getSupport()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Support();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Variable#isDump <em>Dump</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dump</em>'.
	 * @see arcane.Variable#isDump()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Dump();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Variable#isRestore <em>Restore</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Restore</em>'.
	 * @see arcane.Variable#isRestore()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Restore();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Variable#isExecutionDepend <em>Execution Depend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Depend</em>'.
	 * @see arcane.Variable#isExecutionDepend()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_ExecutionDepend();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Variable#isNeedSync <em>Need Sync</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Need Sync</em>'.
	 * @see arcane.Variable#isNeedSync()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_NeedSync();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Variable#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see arcane.Variable#isAbstract()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Abstract();

	/**
	 * Returns the meta object for class '{@link arcane.PackagedElement <em>Packaged Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Packaged Element</em>'.
	 * @see arcane.PackagedElement
	 * @generated
	 */
	EClass getPackagedElement();

	/**
	 * Returns the meta object for the container reference '{@link arcane.PackagedElement#getContainingPackage <em>Containing Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Package</em>'.
	 * @see arcane.PackagedElement#getContainingPackage()
	 * @see #getPackagedElement()
	 * @generated
	 */
	EReference getPackagedElement_ContainingPackage();

	/**
	 * Returns the meta object for class '{@link arcane.Argument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Argument</em>'.
	 * @see arcane.Argument
	 * @generated
	 */
	EClass getArgument();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Argument#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see arcane.Argument#getDirection()
	 * @see #getArgument()
	 * @generated
	 */
	EAttribute getArgument_Direction();

	/**
	 * Returns the meta object for class '{@link arcane.Legacy <em>Legacy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Legacy</em>'.
	 * @see arcane.Legacy
	 * @generated
	 */
	EClass getLegacy();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Legacy#getOriginNamespace <em>Origin Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin Namespace</em>'.
	 * @see arcane.Legacy#getOriginNamespace()
	 * @see #getLegacy()
	 * @generated
	 */
	EAttribute getLegacy_OriginNamespace();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Legacy#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see arcane.Legacy#getProvider()
	 * @see #getLegacy()
	 * @generated
	 */
	EAttribute getLegacy_Provider();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Legacy#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see arcane.Legacy#getFile()
	 * @see #getLegacy()
	 * @generated
	 */
	EAttribute getLegacy_File();

	/**
	 * Returns the meta object for class '{@link arcane.EnumerationLiteral <em>Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Literal</em>'.
	 * @see arcane.EnumerationLiteral
	 * @generated
	 */
	EClass getEnumerationLiteral();

	/**
	 * Returns the meta object for the container reference '{@link arcane.EnumerationLiteral#getContainingEnumeration <em>Containing Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Enumeration</em>'.
	 * @see arcane.EnumerationLiteral#getContainingEnumeration()
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
	EReference getEnumerationLiteral_ContainingEnumeration();

	/**
	 * Returns the meta object for class '{@link arcane.FuncContainer <em>Func Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Func Container</em>'.
	 * @see arcane.FuncContainer
	 * @generated
	 */
	EClass getFuncContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link arcane.FuncContainer#getFuncs <em>Funcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Funcs</em>'.
	 * @see arcane.FuncContainer#getFuncs()
	 * @see #getFuncContainer()
	 * @generated
	 */
	EReference getFuncContainer_Funcs();

	/**
	 * Returns the meta object for class '{@link arcane.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see arcane.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the container reference '{@link arcane.Property#getContainingContainer <em>Containing Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Container</em>'.
	 * @see arcane.Property#getContainingContainer()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_ContainingContainer();

	/**
	 * Returns the meta object for class '{@link arcane.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see arcane.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Annotation#getMsg <em>Msg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Msg</em>'.
	 * @see arcane.Annotation#getMsg()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Msg();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Annotation#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see arcane.Annotation#getKind()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Kind();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Annotation#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see arcane.Annotation#getLevel()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Level();

	/**
	 * Returns the meta object for the attribute '{@link arcane.Annotation#getXpathExpr <em>Xpath Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xpath Expr</em>'.
	 * @see arcane.Annotation#getXpathExpr()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_XpathExpr();

	/**
	 * Returns the meta object for class '{@link arcane.PropertyContainer <em>Property Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Container</em>'.
	 * @see arcane.PropertyContainer
	 * @generated
	 */
	EClass getPropertyContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link arcane.PropertyContainer#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see arcane.PropertyContainer#getProperties()
	 * @see #getPropertyContainer()
	 * @generated
	 */
	EReference getPropertyContainer_Properties();

	/**
	 * Returns the meta object for enum '{@link arcane.ServiceTypeList <em>Service Type List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Service Type List</em>'.
	 * @see arcane.ServiceTypeList
	 * @generated
	 */
	EEnum getServiceTypeList();

	/**
	 * Returns the meta object for enum '{@link arcane.EntryPointLocation <em>Entry Point Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Entry Point Location</em>'.
	 * @see arcane.EntryPointLocation
	 * @generated
	 */
	EEnum getEntryPointLocation();

	/**
	 * Returns the meta object for enum '{@link arcane.EntryPointProperty <em>Entry Point Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Entry Point Property</em>'.
	 * @see arcane.EntryPointProperty
	 * @generated
	 */
	EEnum getEntryPointProperty();

	/**
	 * Returns the meta object for enum '{@link arcane.VariableMultiplicity <em>Variable Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Multiplicity</em>'.
	 * @see arcane.VariableMultiplicity
	 * @generated
	 */
	EEnum getVariableMultiplicity();

	/**
	 * Returns the meta object for enum '{@link arcane.ArgDirection <em>Arg Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Arg Direction</em>'.
	 * @see arcane.ArgDirection
	 * @generated
	 */
	EEnum getArgDirection();

	/**
	 * Returns the meta object for enum '{@link arcane.AnnotationLevels <em>Annotation Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Annotation Levels</em>'.
	 * @see arcane.AnnotationLevels
	 * @generated
	 */
	EEnum getAnnotationLevels();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ArcaneFactory getArcaneFactory();

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
		 * The meta object literal for the '{@link arcane.impl.FuncImpl <em>Func</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.FuncImpl
		 * @see arcane.impl.ArcanePackageImpl#getFunc()
		 * @generated
		 */
		EClass FUNC = eINSTANCE.getFunc();

		/**
		 * The meta object literal for the '<em><b>Support</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNC__SUPPORT = eINSTANCE.getFunc_Support();

		/**
		 * The meta object literal for the '<em><b>Parallel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNC__PARALLEL = eINSTANCE.getFunc_Parallel();

		/**
		 * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNC__ARGS = eINSTANCE.getFunc_Args();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNC__CONTAINER = eINSTANCE.getFunc_Container();

		/**
		 * The meta object literal for the '<em><b>Item Type Specialized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNC__ITEM_TYPE_SPECIALIZED = eINSTANCE.getFunc_ItemTypeSpecialized();

		/**
		 * The meta object literal for the '<em><b>Return Argument</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNC__RETURN_ARGUMENT = eINSTANCE.getFunc_ReturnArgument();

		/**
		 * The meta object literal for the '{@link arcane.impl.PropertyOrArgumentImpl <em>Property Or Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.PropertyOrArgumentImpl
		 * @see arcane.impl.ArcanePackageImpl#getPropertyOrArgument()
		 * @generated
		 */
		EClass PROPERTY_OR_ARGUMENT = eINSTANCE.getPropertyOrArgument();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_OR_ARGUMENT__TYPE = eINSTANCE.getPropertyOrArgument_Type();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_OR_ARGUMENT__DEFAULT_VALUE = eINSTANCE.getPropertyOrArgument_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_OR_ARGUMENT__LOWER_BOUND = eINSTANCE.getPropertyOrArgument_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_OR_ARGUMENT__UPPER_BOUND = eINSTANCE.getPropertyOrArgument_UpperBound();

		/**
		 * The meta object literal for the '{@link arcane.impl.PropertyOrArgumentTypeImpl <em>Property Or Argument Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.PropertyOrArgumentTypeImpl
		 * @see arcane.impl.ArcanePackageImpl#getPropertyOrArgumentType()
		 * @generated
		 */
		EClass PROPERTY_OR_ARGUMENT_TYPE = eINSTANCE.getPropertyOrArgumentType();

		/**
		 * The meta object literal for the '<em><b>Used By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_OR_ARGUMENT_TYPE__USED_BY = eINSTANCE.getPropertyOrArgumentType_UsedBy();

		/**
		 * The meta object literal for the '{@link arcane.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.NamedElementImpl
		 * @see arcane.impl.ArcanePackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__DESCRIPTION = eINSTANCE.getNamedElement_Description();

		/**
		 * The meta object literal for the '<em><b>User Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__USER_ENABLED = eINSTANCE.getNamedElement_UserEnabled();

		/**
		 * The meta object literal for the '<em><b>Name Fr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME_FR = eINSTANCE.getNamedElement_NameFr();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_ELEMENT__ANNOTATIONS = eINSTANCE.getNamedElement_Annotations();

		/**
		 * The meta object literal for the '{@link arcane.impl.ModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.ModuleImpl
		 * @see arcane.impl.ArcanePackageImpl#getModule()
		 * @generated
		 */
		EClass MODULE = eINSTANCE.getModule();

		/**
		 * The meta object literal for the '<em><b>Entry Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__ENTRY_POINTS = eINSTANCE.getModule_EntryPoints();

		/**
		 * The meta object literal for the '{@link arcane.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.ServiceImpl
		 * @see arcane.impl.ArcanePackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__TYPE = eINSTANCE.getService_Type();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__INTERFACE = eINSTANCE.getService_Interface();

		/**
		 * The meta object literal for the '{@link arcane.impl.ServiceOrModuleImpl <em>Service Or Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.ServiceOrModuleImpl
		 * @see arcane.impl.ArcanePackageImpl#getServiceOrModule()
		 * @generated
		 */
		EClass SERVICE_OR_MODULE = eINSTANCE.getServiceOrModule();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_OR_MODULE__VERSION = eINSTANCE.getServiceOrModule_Version();

		/**
		 * The meta object literal for the '<em><b>Axl File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_OR_MODULE__AXL_FILE_PATH = eINSTANCE.getServiceOrModule_AxlFilePath();

		/**
		 * The meta object literal for the '{@link arcane.impl.EntryPointImpl <em>Entry Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.EntryPointImpl
		 * @see arcane.impl.ArcanePackageImpl#getEntryPoint()
		 * @generated
		 */
		EClass ENTRY_POINT = eINSTANCE.getEntryPoint();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY_POINT__LOCATION = eINSTANCE.getEntryPoint_Location();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY_POINT__PROPERTY = eINSTANCE.getEntryPoint_Property();

		/**
		 * The meta object literal for the '<em><b>Containing Module</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY_POINT__CONTAINING_MODULE = eINSTANCE.getEntryPoint_ContainingModule();

		/**
		 * The meta object literal for the '{@link arcane.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.PackageImpl
		 * @see arcane.impl.ArcanePackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__ELEMENTS = eINSTANCE.getPackage_Elements();

		/**
		 * The meta object literal for the '{@link arcane.impl.StructImpl <em>Struct</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.StructImpl
		 * @see arcane.impl.ArcanePackageImpl#getStruct()
		 * @generated
		 */
		EClass STRUCT = eINSTANCE.getStruct();

		/**
		 * The meta object literal for the '<em><b>Parents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCT__PARENTS = eINSTANCE.getStruct_Parents();

		/**
		 * The meta object literal for the '{@link arcane.impl.EnumerationImpl <em>Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.EnumerationImpl
		 * @see arcane.impl.ArcanePackageImpl#getEnumeration()
		 * @generated
		 */
		EClass ENUMERATION = eINSTANCE.getEnumeration();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION__LITERALS = eINSTANCE.getEnumeration_Literals();

		/**
		 * The meta object literal for the '{@link arcane.impl.FuncOrEntryPointImpl <em>Func Or Entry Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.FuncOrEntryPointImpl
		 * @see arcane.impl.ArcanePackageImpl#getFuncOrEntryPoint()
		 * @generated
		 */
		EClass FUNC_OR_ENTRY_POINT = eINSTANCE.getFuncOrEntryPoint();

		/**
		 * The meta object literal for the '<em><b>In Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNC_OR_ENTRY_POINT__IN_VARIABLES = eINSTANCE.getFuncOrEntryPoint_InVariables();

		/**
		 * The meta object literal for the '<em><b>Out Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNC_OR_ENTRY_POINT__OUT_VARIABLES = eINSTANCE.getFuncOrEntryPoint_OutVariables();

		/**
		 * The meta object literal for the '<em><b>Called Funcs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNC_OR_ENTRY_POINT__CALLED_FUNCS = eINSTANCE.getFuncOrEntryPoint_CalledFuncs();

		/**
		 * The meta object literal for the '{@link arcane.impl.InterfaceImpl <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.InterfaceImpl
		 * @see arcane.impl.ArcanePackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '<em><b>Parents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__PARENTS = eINSTANCE.getInterface_Parents();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__CHILDREN = eINSTANCE.getInterface_Children();

		/**
		 * The meta object literal for the '<em><b>Realisations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__REALISATIONS = eINSTANCE.getInterface_Realisations();

		/**
		 * The meta object literal for the '{@link arcane.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.VariableImpl
		 * @see arcane.impl.ArcanePackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__MULTIPLICITY = eINSTANCE.getVariable_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__TYPE = eINSTANCE.getVariable_Type();

		/**
		 * The meta object literal for the '<em><b>Support</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__SUPPORT = eINSTANCE.getVariable_Support();

		/**
		 * The meta object literal for the '<em><b>Dump</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__DUMP = eINSTANCE.getVariable_Dump();

		/**
		 * The meta object literal for the '<em><b>Restore</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__RESTORE = eINSTANCE.getVariable_Restore();

		/**
		 * The meta object literal for the '<em><b>Execution Depend</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__EXECUTION_DEPEND = eINSTANCE.getVariable_ExecutionDepend();

		/**
		 * The meta object literal for the '<em><b>Need Sync</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__NEED_SYNC = eINSTANCE.getVariable_NeedSync();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__ABSTRACT = eINSTANCE.getVariable_Abstract();

		/**
		 * The meta object literal for the '{@link arcane.impl.PackagedElementImpl <em>Packaged Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.PackagedElementImpl
		 * @see arcane.impl.ArcanePackageImpl#getPackagedElement()
		 * @generated
		 */
		EClass PACKAGED_ELEMENT = eINSTANCE.getPackagedElement();

		/**
		 * The meta object literal for the '<em><b>Containing Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGED_ELEMENT__CONTAINING_PACKAGE = eINSTANCE.getPackagedElement_ContainingPackage();

		/**
		 * The meta object literal for the '{@link arcane.impl.ArgumentImpl <em>Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.ArgumentImpl
		 * @see arcane.impl.ArcanePackageImpl#getArgument()
		 * @generated
		 */
		EClass ARGUMENT = eINSTANCE.getArgument();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT__DIRECTION = eINSTANCE.getArgument_Direction();

		/**
		 * The meta object literal for the '{@link arcane.impl.LegacyImpl <em>Legacy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.LegacyImpl
		 * @see arcane.impl.ArcanePackageImpl#getLegacy()
		 * @generated
		 */
		EClass LEGACY = eINSTANCE.getLegacy();

		/**
		 * The meta object literal for the '<em><b>Origin Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEGACY__ORIGIN_NAMESPACE = eINSTANCE.getLegacy_OriginNamespace();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEGACY__PROVIDER = eINSTANCE.getLegacy_Provider();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEGACY__FILE = eINSTANCE.getLegacy_File();

		/**
		 * The meta object literal for the '{@link arcane.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.EnumerationLiteralImpl
		 * @see arcane.impl.ArcanePackageImpl#getEnumerationLiteral()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL = eINSTANCE.getEnumerationLiteral();

		/**
		 * The meta object literal for the '<em><b>Containing Enumeration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_LITERAL__CONTAINING_ENUMERATION = eINSTANCE.getEnumerationLiteral_ContainingEnumeration();

		/**
		 * The meta object literal for the '{@link arcane.impl.FuncContainerImpl <em>Func Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.FuncContainerImpl
		 * @see arcane.impl.ArcanePackageImpl#getFuncContainer()
		 * @generated
		 */
		EClass FUNC_CONTAINER = eINSTANCE.getFuncContainer();

		/**
		 * The meta object literal for the '<em><b>Funcs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNC_CONTAINER__FUNCS = eINSTANCE.getFuncContainer_Funcs();

		/**
		 * The meta object literal for the '{@link arcane.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.PropertyImpl
		 * @see arcane.impl.ArcanePackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Containing Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__CONTAINING_CONTAINER = eINSTANCE.getProperty_ContainingContainer();

		/**
		 * The meta object literal for the '{@link arcane.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.AnnotationImpl
		 * @see arcane.impl.ArcanePackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Msg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__MSG = eINSTANCE.getAnnotation_Msg();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__KIND = eINSTANCE.getAnnotation_Kind();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__LEVEL = eINSTANCE.getAnnotation_Level();

		/**
		 * The meta object literal for the '<em><b>Xpath Expr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__XPATH_EXPR = eINSTANCE.getAnnotation_XpathExpr();

		/**
		 * The meta object literal for the '{@link arcane.impl.PropertyContainerImpl <em>Property Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.impl.PropertyContainerImpl
		 * @see arcane.impl.ArcanePackageImpl#getPropertyContainer()
		 * @generated
		 */
		EClass PROPERTY_CONTAINER = eINSTANCE.getPropertyContainer();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CONTAINER__PROPERTIES = eINSTANCE.getPropertyContainer_Properties();

		/**
		 * The meta object literal for the '{@link arcane.ServiceTypeList <em>Service Type List</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.ServiceTypeList
		 * @see arcane.impl.ArcanePackageImpl#getServiceTypeList()
		 * @generated
		 */
		EEnum SERVICE_TYPE_LIST = eINSTANCE.getServiceTypeList();

		/**
		 * The meta object literal for the '{@link arcane.EntryPointLocation <em>Entry Point Location</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.EntryPointLocation
		 * @see arcane.impl.ArcanePackageImpl#getEntryPointLocation()
		 * @generated
		 */
		EEnum ENTRY_POINT_LOCATION = eINSTANCE.getEntryPointLocation();

		/**
		 * The meta object literal for the '{@link arcane.EntryPointProperty <em>Entry Point Property</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.EntryPointProperty
		 * @see arcane.impl.ArcanePackageImpl#getEntryPointProperty()
		 * @generated
		 */
		EEnum ENTRY_POINT_PROPERTY = eINSTANCE.getEntryPointProperty();

		/**
		 * The meta object literal for the '{@link arcane.VariableMultiplicity <em>Variable Multiplicity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.VariableMultiplicity
		 * @see arcane.impl.ArcanePackageImpl#getVariableMultiplicity()
		 * @generated
		 */
		EEnum VARIABLE_MULTIPLICITY = eINSTANCE.getVariableMultiplicity();

		/**
		 * The meta object literal for the '{@link arcane.ArgDirection <em>Arg Direction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.ArgDirection
		 * @see arcane.impl.ArcanePackageImpl#getArgDirection()
		 * @generated
		 */
		EEnum ARG_DIRECTION = eINSTANCE.getArgDirection();

		/**
		 * The meta object literal for the '{@link arcane.AnnotationLevels <em>Annotation Levels</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arcane.AnnotationLevels
		 * @see arcane.impl.ArcanePackageImpl#getAnnotationLevels()
		 * @generated
		 */
		EEnum ANNOTATION_LEVELS = eINSTANCE.getAnnotationLevels();

	}

} //ArcanePackage
