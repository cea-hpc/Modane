/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.arcanetypes.impl;

import arcane.ArcanePackage;

import arcane.arcanetypes.ArcaneTypes;
import arcane.arcanetypes.ArcanetypesFactory;
import arcane.arcanetypes.ArcanetypesPackage;
import arcane.arcanetypes.ItemType;
import arcane.arcanetypes.MeshType;
import arcane.arcanetypes.SimpleType;

import arcane.impl.ArcanePackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArcanetypesPackageImpl extends EPackageImpl implements ArcanetypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arcaneTypesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itemTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass meshTypeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see arcane.arcanetypes.ArcanetypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ArcanetypesPackageImpl() {
		super(eNS_URI, ArcanetypesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ArcanetypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ArcanetypesPackage init() {
		if (isInited) return (ArcanetypesPackage)EPackage.Registry.INSTANCE.getEPackage(ArcanetypesPackage.eNS_URI);

		// Obtain or create and register package
		ArcanetypesPackageImpl theArcanetypesPackage = (ArcanetypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ArcanetypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ArcanetypesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ArcanePackageImpl theArcanePackage = (ArcanePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ArcanePackage.eNS_URI) instanceof ArcanePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ArcanePackage.eNS_URI) : ArcanePackage.eINSTANCE);

		// Create package meta-data objects
		theArcanetypesPackage.createPackageContents();
		theArcanePackage.createPackageContents();

		// Initialize created meta-data
		theArcanetypesPackage.initializePackageContents();
		theArcanePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theArcanetypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ArcanetypesPackage.eNS_URI, theArcanetypesPackage);
		return theArcanetypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArcaneTypes() {
		return arcaneTypesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArcaneTypes_MeshTypes() {
		return (EReference)arcaneTypesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArcaneTypes_SimpleTypes() {
		return (EReference)arcaneTypesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getItemType() {
		return itemTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleType() {
		return simpleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeshType() {
		return meshTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArcanetypesFactory getArcanetypesFactory() {
		return (ArcanetypesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		arcaneTypesEClass = createEClass(ARCANE_TYPES);
		createEReference(arcaneTypesEClass, ARCANE_TYPES__MESH_TYPES);
		createEReference(arcaneTypesEClass, ARCANE_TYPES__SIMPLE_TYPES);

		itemTypeEClass = createEClass(ITEM_TYPE);

		simpleTypeEClass = createEClass(SIMPLE_TYPE);

		meshTypeEClass = createEClass(MESH_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ArcanePackage theArcanePackage = (ArcanePackage)EPackage.Registry.INSTANCE.getEPackage(ArcanePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		itemTypeEClass.getESuperTypes().add(this.getMeshType());
		simpleTypeEClass.getESuperTypes().add(theArcanePackage.getPropertyOrArgumentType());
		meshTypeEClass.getESuperTypes().add(theArcanePackage.getPropertyOrArgumentType());

		// Initialize classes and features; add operations and parameters
		initEClass(arcaneTypesEClass, ArcaneTypes.class, "ArcaneTypes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArcaneTypes_MeshTypes(), this.getMeshType(), null, "meshTypes", null, 0, -1, ArcaneTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArcaneTypes_SimpleTypes(), this.getSimpleType(), null, "simpleTypes", null, 0, -1, ArcaneTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(itemTypeEClass, ItemType.class, "ItemType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simpleTypeEClass, SimpleType.class, "SimpleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(meshTypeEClass, MeshType.class, "MeshType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //ArcanetypesPackageImpl
