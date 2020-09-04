/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.impl;

import arcane.Annotation;
import arcane.AnnotationLevels;
import arcane.ArcaneFactory;
import arcane.ArcanePackage;
import arcane.ArgDirection;
import arcane.Argument;
import arcane.EntryPoint;
import arcane.EntryPointLocation;
import arcane.EntryPointProperty;
import arcane.Enumeration;
import arcane.EnumerationLiteral;
import arcane.Func;
import arcane.FuncContainer;
import arcane.FuncOrEntryPoint;
import arcane.Interface;
import arcane.Legacy;
import arcane.Module;
import arcane.NamedElement;
import arcane.PackagedElement;
import arcane.Property;
import arcane.PropertyContainer;
import arcane.PropertyOrArgument;
import arcane.PropertyOrArgumentType;
import arcane.Service;
import arcane.ServiceOrModule;
import arcane.ServiceTypeList;
import arcane.Struct;
import arcane.Variable;
import arcane.VariableMultiplicity;

import arcane.arcanetypes.ArcanetypesPackage;

import arcane.arcanetypes.impl.ArcanetypesPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArcanePackageImpl extends EPackageImpl implements ArcanePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass funcEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyOrArgumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyOrArgumentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceOrModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entryPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass funcOrEntryPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packagedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass argumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass legacyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass funcContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum serviceTypeListEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum entryPointLocationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum entryPointPropertyEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variableMultiplicityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum argDirectionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum annotationLevelsEEnum = null;

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
	 * @see arcane.ArcanePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ArcanePackageImpl() {
		super(eNS_URI, ArcaneFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ArcanePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ArcanePackage init() {
		if (isInited) return (ArcanePackage)EPackage.Registry.INSTANCE.getEPackage(ArcanePackage.eNS_URI);

		// Obtain or create and register package
		ArcanePackageImpl theArcanePackage = (ArcanePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ArcanePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ArcanePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ArcanetypesPackageImpl theArcanetypesPackage = (ArcanetypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ArcanetypesPackage.eNS_URI) instanceof ArcanetypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ArcanetypesPackage.eNS_URI) : ArcanetypesPackage.eINSTANCE);

		// Create package meta-data objects
		theArcanePackage.createPackageContents();
		theArcanetypesPackage.createPackageContents();

		// Initialize created meta-data
		theArcanePackage.initializePackageContents();
		theArcanetypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theArcanePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ArcanePackage.eNS_URI, theArcanePackage);
		return theArcanePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunc() {
		return funcEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunc_Support() {
		return (EReference)funcEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunc_Parallel() {
		return (EAttribute)funcEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunc_Args() {
		return (EReference)funcEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunc_Container() {
		return (EReference)funcEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunc_ItemTypeSpecialized() {
		return (EAttribute)funcEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunc_ReturnArgument() {
		return (EReference)funcEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyOrArgument() {
		return propertyOrArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyOrArgument_Type() {
		return (EReference)propertyOrArgumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyOrArgument_DefaultValue() {
		return (EAttribute)propertyOrArgumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyOrArgument_LowerBound() {
		return (EAttribute)propertyOrArgumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyOrArgument_UpperBound() {
		return (EAttribute)propertyOrArgumentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyOrArgumentType() {
		return propertyOrArgumentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyOrArgumentType_UsedBy() {
		return (EReference)propertyOrArgumentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Description() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_UserEnabled() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_NameFr() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedElement_Annotations() {
		return (EReference)namedElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModule() {
		return moduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_EntryPoints() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Type() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Interface() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceOrModule() {
		return serviceOrModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceOrModule_Version() {
		return (EAttribute)serviceOrModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceOrModule_AxlFilePath() {
		return (EAttribute)serviceOrModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntryPoint() {
		return entryPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntryPoint_Location() {
		return (EAttribute)entryPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntryPoint_Property() {
		return (EAttribute)entryPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntryPoint_ContainingModule() {
		return (EReference)entryPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackage() {
		return packageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackage_Elements() {
		return (EReference)packageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStruct() {
		return structEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStruct_Parents() {
		return (EReference)structEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumeration() {
		return enumerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumeration_Literals() {
		return (EReference)enumerationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFuncOrEntryPoint() {
		return funcOrEntryPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuncOrEntryPoint_InVariables() {
		return (EReference)funcOrEntryPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuncOrEntryPoint_OutVariables() {
		return (EReference)funcOrEntryPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuncOrEntryPoint_CalledFuncs() {
		return (EReference)funcOrEntryPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterface() {
		return interfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_Parents() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_Children() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_Realisations() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Multiplicity() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_Type() {
		return (EReference)variableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_Support() {
		return (EReference)variableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Dump() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Restore() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_ExecutionDepend() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_NeedSync() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Abstract() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackagedElement() {
		return packagedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackagedElement_ContainingPackage() {
		return (EReference)packagedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArgument() {
		return argumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArgument_Direction() {
		return (EAttribute)argumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLegacy() {
		return legacyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLegacy_OriginNamespace() {
		return (EAttribute)legacyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLegacy_Provider() {
		return (EAttribute)legacyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLegacy_File() {
		return (EAttribute)legacyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationLiteral() {
		return enumerationLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumerationLiteral_ContainingEnumeration() {
		return (EReference)enumerationLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFuncContainer() {
		return funcContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuncContainer_Funcs() {
		return (EReference)funcContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProperty_ContainingContainer() {
		return (EReference)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_Msg() {
		return (EAttribute)annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_Kind() {
		return (EAttribute)annotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_Level() {
		return (EAttribute)annotationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_XpathExpr() {
		return (EAttribute)annotationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyContainer() {
		return propertyContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyContainer_Properties() {
		return (EReference)propertyContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getServiceTypeList() {
		return serviceTypeListEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEntryPointLocation() {
		return entryPointLocationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEntryPointProperty() {
		return entryPointPropertyEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVariableMultiplicity() {
		return variableMultiplicityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getArgDirection() {
		return argDirectionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAnnotationLevels() {
		return annotationLevelsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArcaneFactory getArcaneFactory() {
		return (ArcaneFactory)getEFactoryInstance();
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
		funcEClass = createEClass(FUNC);
		createEReference(funcEClass, FUNC__SUPPORT);
		createEAttribute(funcEClass, FUNC__PARALLEL);
		createEReference(funcEClass, FUNC__ARGS);
		createEReference(funcEClass, FUNC__CONTAINER);
		createEAttribute(funcEClass, FUNC__ITEM_TYPE_SPECIALIZED);
		createEReference(funcEClass, FUNC__RETURN_ARGUMENT);

		propertyOrArgumentEClass = createEClass(PROPERTY_OR_ARGUMENT);
		createEReference(propertyOrArgumentEClass, PROPERTY_OR_ARGUMENT__TYPE);
		createEAttribute(propertyOrArgumentEClass, PROPERTY_OR_ARGUMENT__DEFAULT_VALUE);
		createEAttribute(propertyOrArgumentEClass, PROPERTY_OR_ARGUMENT__LOWER_BOUND);
		createEAttribute(propertyOrArgumentEClass, PROPERTY_OR_ARGUMENT__UPPER_BOUND);

		propertyOrArgumentTypeEClass = createEClass(PROPERTY_OR_ARGUMENT_TYPE);
		createEReference(propertyOrArgumentTypeEClass, PROPERTY_OR_ARGUMENT_TYPE__USED_BY);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__DESCRIPTION);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__USER_ENABLED);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME_FR);
		createEReference(namedElementEClass, NAMED_ELEMENT__ANNOTATIONS);

		moduleEClass = createEClass(MODULE);
		createEReference(moduleEClass, MODULE__ENTRY_POINTS);

		serviceEClass = createEClass(SERVICE);
		createEAttribute(serviceEClass, SERVICE__TYPE);
		createEReference(serviceEClass, SERVICE__INTERFACE);

		serviceOrModuleEClass = createEClass(SERVICE_OR_MODULE);
		createEAttribute(serviceOrModuleEClass, SERVICE_OR_MODULE__VERSION);
		createEAttribute(serviceOrModuleEClass, SERVICE_OR_MODULE__AXL_FILE_PATH);

		entryPointEClass = createEClass(ENTRY_POINT);
		createEAttribute(entryPointEClass, ENTRY_POINT__LOCATION);
		createEAttribute(entryPointEClass, ENTRY_POINT__PROPERTY);
		createEReference(entryPointEClass, ENTRY_POINT__CONTAINING_MODULE);

		packageEClass = createEClass(PACKAGE);
		createEReference(packageEClass, PACKAGE__ELEMENTS);

		structEClass = createEClass(STRUCT);
		createEReference(structEClass, STRUCT__PARENTS);

		enumerationEClass = createEClass(ENUMERATION);
		createEReference(enumerationEClass, ENUMERATION__LITERALS);

		funcOrEntryPointEClass = createEClass(FUNC_OR_ENTRY_POINT);
		createEReference(funcOrEntryPointEClass, FUNC_OR_ENTRY_POINT__IN_VARIABLES);
		createEReference(funcOrEntryPointEClass, FUNC_OR_ENTRY_POINT__OUT_VARIABLES);
		createEReference(funcOrEntryPointEClass, FUNC_OR_ENTRY_POINT__CALLED_FUNCS);

		interfaceEClass = createEClass(INTERFACE);
		createEReference(interfaceEClass, INTERFACE__PARENTS);
		createEReference(interfaceEClass, INTERFACE__CHILDREN);
		createEReference(interfaceEClass, INTERFACE__REALISATIONS);

		variableEClass = createEClass(VARIABLE);
		createEAttribute(variableEClass, VARIABLE__MULTIPLICITY);
		createEReference(variableEClass, VARIABLE__TYPE);
		createEReference(variableEClass, VARIABLE__SUPPORT);
		createEAttribute(variableEClass, VARIABLE__DUMP);
		createEAttribute(variableEClass, VARIABLE__RESTORE);
		createEAttribute(variableEClass, VARIABLE__EXECUTION_DEPEND);
		createEAttribute(variableEClass, VARIABLE__NEED_SYNC);
		createEAttribute(variableEClass, VARIABLE__ABSTRACT);

		packagedElementEClass = createEClass(PACKAGED_ELEMENT);
		createEReference(packagedElementEClass, PACKAGED_ELEMENT__CONTAINING_PACKAGE);

		argumentEClass = createEClass(ARGUMENT);
		createEAttribute(argumentEClass, ARGUMENT__DIRECTION);

		legacyEClass = createEClass(LEGACY);
		createEAttribute(legacyEClass, LEGACY__ORIGIN_NAMESPACE);
		createEAttribute(legacyEClass, LEGACY__PROVIDER);
		createEAttribute(legacyEClass, LEGACY__FILE);

		enumerationLiteralEClass = createEClass(ENUMERATION_LITERAL);
		createEReference(enumerationLiteralEClass, ENUMERATION_LITERAL__CONTAINING_ENUMERATION);

		funcContainerEClass = createEClass(FUNC_CONTAINER);
		createEReference(funcContainerEClass, FUNC_CONTAINER__FUNCS);

		propertyEClass = createEClass(PROPERTY);
		createEReference(propertyEClass, PROPERTY__CONTAINING_CONTAINER);

		annotationEClass = createEClass(ANNOTATION);
		createEAttribute(annotationEClass, ANNOTATION__MSG);
		createEAttribute(annotationEClass, ANNOTATION__KIND);
		createEAttribute(annotationEClass, ANNOTATION__LEVEL);
		createEAttribute(annotationEClass, ANNOTATION__XPATH_EXPR);

		propertyContainerEClass = createEClass(PROPERTY_CONTAINER);
		createEReference(propertyContainerEClass, PROPERTY_CONTAINER__PROPERTIES);

		// Create enums
		serviceTypeListEEnum = createEEnum(SERVICE_TYPE_LIST);
		entryPointLocationEEnum = createEEnum(ENTRY_POINT_LOCATION);
		entryPointPropertyEEnum = createEEnum(ENTRY_POINT_PROPERTY);
		variableMultiplicityEEnum = createEEnum(VARIABLE_MULTIPLICITY);
		argDirectionEEnum = createEEnum(ARG_DIRECTION);
		annotationLevelsEEnum = createEEnum(ANNOTATION_LEVELS);
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
		ArcanetypesPackage theArcanetypesPackage = (ArcanetypesPackage)EPackage.Registry.INSTANCE.getEPackage(ArcanetypesPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theArcanetypesPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		funcEClass.getESuperTypes().add(this.getFuncOrEntryPoint());
		propertyOrArgumentEClass.getESuperTypes().add(this.getNamedElement());
		propertyOrArgumentTypeEClass.getESuperTypes().add(this.getNamedElement());
		moduleEClass.getESuperTypes().add(this.getServiceOrModule());
		serviceEClass.getESuperTypes().add(this.getServiceOrModule());
		serviceEClass.getESuperTypes().add(this.getFuncContainer());
		serviceOrModuleEClass.getESuperTypes().add(this.getPropertyContainer());
		entryPointEClass.getESuperTypes().add(this.getFuncOrEntryPoint());
		packageEClass.getESuperTypes().add(this.getPackagedElement());
		structEClass.getESuperTypes().add(this.getPropertyOrArgumentType());
		structEClass.getESuperTypes().add(this.getPropertyContainer());
		enumerationEClass.getESuperTypes().add(this.getPropertyOrArgumentType());
		enumerationEClass.getESuperTypes().add(this.getPackagedElement());
		funcOrEntryPointEClass.getESuperTypes().add(this.getNamedElement());
		interfaceEClass.getESuperTypes().add(this.getPropertyOrArgumentType());
		interfaceEClass.getESuperTypes().add(this.getFuncContainer());
		interfaceEClass.getESuperTypes().add(this.getPropertyContainer());
		variableEClass.getESuperTypes().add(this.getPackagedElement());
		packagedElementEClass.getESuperTypes().add(this.getNamedElement());
		argumentEClass.getESuperTypes().add(this.getPropertyOrArgument());
		legacyEClass.getESuperTypes().add(this.getPropertyOrArgumentType());
		legacyEClass.getESuperTypes().add(this.getPackagedElement());
		enumerationLiteralEClass.getESuperTypes().add(this.getNamedElement());
		funcContainerEClass.getESuperTypes().add(this.getPackagedElement());
		propertyEClass.getESuperTypes().add(this.getPropertyOrArgument());
		propertyContainerEClass.getESuperTypes().add(this.getPackagedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(funcEClass, Func.class, "Func", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunc_Support(), theArcanetypesPackage.getItemType(), null, "support", null, 0, 1, Func.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunc_Parallel(), ecorePackage.getEBoolean(), "parallel", "true", 1, 1, Func.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunc_Args(), this.getArgument(), null, "args", null, 0, -1, Func.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunc_Container(), this.getFuncContainer(), this.getFuncContainer_Funcs(), "container", null, 1, 1, Func.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunc_ItemTypeSpecialized(), ecorePackage.getEBoolean(), "itemTypeSpecialized", "false", 0, 1, Func.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunc_ReturnArgument(), this.getArgument(), null, "returnArgument", null, 0, 1, Func.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyOrArgumentEClass, PropertyOrArgument.class, "PropertyOrArgument", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyOrArgument_Type(), this.getPropertyOrArgumentType(), this.getPropertyOrArgumentType_UsedBy(), "type", null, 1, 1, PropertyOrArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyOrArgument_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 0, 1, PropertyOrArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyOrArgument_LowerBound(), ecorePackage.getEInt(), "lowerBound", null, 1, 1, PropertyOrArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyOrArgument_UpperBound(), ecorePackage.getEInt(), "upperBound", null, 1, 1, PropertyOrArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyOrArgumentTypeEClass, PropertyOrArgumentType.class, "PropertyOrArgumentType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyOrArgumentType_UsedBy(), this.getPropertyOrArgument(), this.getPropertyOrArgument_Type(), "usedBy", null, 0, -1, PropertyOrArgumentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_UserEnabled(), ecorePackage.getEBoolean(), "userEnabled", "false", 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_NameFr(), ecorePackage.getEString(), "nameFr", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedElement_Annotations(), this.getAnnotation(), null, "annotations", null, 0, -1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModule_EntryPoints(), this.getEntryPoint(), this.getEntryPoint_ContainingModule(), "entryPoints", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getService_Type(), this.getServiceTypeList(), "type", "CaseOption", 1, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_Interface(), this.getInterface(), this.getInterface_Realisations(), "interface", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceOrModuleEClass, ServiceOrModule.class, "ServiceOrModule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceOrModule_Version(), ecorePackage.getEString(), "version", "1.0", 1, 1, ServiceOrModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceOrModule_AxlFilePath(), ecorePackage.getEString(), "axlFilePath", null, 1, 1, ServiceOrModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entryPointEClass, EntryPoint.class, "EntryPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntryPoint_Location(), this.getEntryPointLocation(), "location", null, 1, 1, EntryPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntryPoint_Property(), this.getEntryPointProperty(), "property", "None", 1, 1, EntryPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntryPoint_ContainingModule(), this.getModule(), this.getModule_EntryPoints(), "containingModule", null, 1, 1, EntryPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageEClass, arcane.Package.class, "Package", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackage_Elements(), this.getPackagedElement(), this.getPackagedElement_ContainingPackage(), "elements", null, 0, -1, arcane.Package.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structEClass, Struct.class, "Struct", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStruct_Parents(), this.getStruct(), null, "parents", null, 0, -1, Struct.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerationEClass, Enumeration.class, "Enumeration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumeration_Literals(), this.getEnumerationLiteral(), this.getEnumerationLiteral_ContainingEnumeration(), "literals", null, 1, -1, Enumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(funcOrEntryPointEClass, FuncOrEntryPoint.class, "FuncOrEntryPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFuncOrEntryPoint_InVariables(), this.getVariable(), null, "inVariables", null, 0, -1, FuncOrEntryPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFuncOrEntryPoint_OutVariables(), this.getVariable(), null, "outVariables", null, 0, -1, FuncOrEntryPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFuncOrEntryPoint_CalledFuncs(), this.getFunc(), null, "calledFuncs", null, 0, -1, FuncOrEntryPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceEClass, Interface.class, "Interface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterface_Parents(), this.getInterface(), this.getInterface_Children(), "parents", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_Children(), this.getInterface(), this.getInterface_Parents(), "children", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_Realisations(), this.getService(), this.getService_Interface(), "realisations", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariable_Multiplicity(), this.getVariableMultiplicity(), "multiplicity", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariable_Type(), theArcanetypesPackage.getSimpleType(), null, "type", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariable_Support(), theArcanetypesPackage.getItemType(), null, "support", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariable_Dump(), ecorePackage.getEBoolean(), "dump", "true", 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariable_Restore(), ecorePackage.getEBoolean(), "restore", "true", 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariable_ExecutionDepend(), ecorePackage.getEBoolean(), "executionDepend", "false", 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariable_NeedSync(), ecorePackage.getEBoolean(), "needSync", "true", 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariable_Abstract(), ecorePackage.getEBoolean(), "abstract", "false", 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packagedElementEClass, PackagedElement.class, "PackagedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackagedElement_ContainingPackage(), this.getPackage(), this.getPackage_Elements(), "containingPackage", null, 0, 1, PackagedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(argumentEClass, Argument.class, "Argument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArgument_Direction(), this.getArgDirection(), "direction", null, 1, 1, Argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(legacyEClass, Legacy.class, "Legacy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLegacy_OriginNamespace(), ecorePackage.getEString(), "originNamespace", null, 0, 1, Legacy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLegacy_Provider(), ecorePackage.getEString(), "provider", null, 0, 1, Legacy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLegacy_File(), ecorePackage.getEString(), "file", null, 1, 1, Legacy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerationLiteralEClass, EnumerationLiteral.class, "EnumerationLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumerationLiteral_ContainingEnumeration(), this.getEnumeration(), this.getEnumeration_Literals(), "containingEnumeration", null, 1, 1, EnumerationLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(funcContainerEClass, FuncContainer.class, "FuncContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFuncContainer_Funcs(), this.getFunc(), this.getFunc_Container(), "funcs", null, 0, -1, FuncContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProperty_ContainingContainer(), this.getPropertyContainer(), this.getPropertyContainer_Properties(), "containingContainer", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnnotation_Msg(), ecorePackage.getEString(), "msg", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotation_Kind(), ecorePackage.getEString(), "kind", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotation_Level(), this.getAnnotationLevels(), "level", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotation_XpathExpr(), ecorePackage.getEString(), "xpathExpr", null, 0, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyContainerEClass, PropertyContainer.class, "PropertyContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyContainer_Properties(), this.getProperty(), this.getProperty_ContainingContainer(), "properties", null, 0, -1, PropertyContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(serviceTypeListEEnum, ServiceTypeList.class, "ServiceTypeList");
		addEEnumLiteral(serviceTypeListEEnum, ServiceTypeList.APPLICATION);
		addEEnumLiteral(serviceTypeListEEnum, ServiceTypeList.SESSION);
		addEEnumLiteral(serviceTypeListEEnum, ServiceTypeList.SUB_DOMAIN);
		addEEnumLiteral(serviceTypeListEEnum, ServiceTypeList.CASE_OPTION);

		initEEnum(entryPointLocationEEnum, EntryPointLocation.class, "EntryPointLocation");
		addEEnumLiteral(entryPointLocationEEnum, EntryPointLocation.COMPUTE_LOOP);
		addEEnumLiteral(entryPointLocationEEnum, EntryPointLocation.ON_MESH_CHANGED);
		addEEnumLiteral(entryPointLocationEEnum, EntryPointLocation.ON_MESH_REFINEMENT);
		addEEnumLiteral(entryPointLocationEEnum, EntryPointLocation.INIT);
		addEEnumLiteral(entryPointLocationEEnum, EntryPointLocation.CONTINUE_INIT);
		addEEnumLiteral(entryPointLocationEEnum, EntryPointLocation.START_INIT);
		addEEnumLiteral(entryPointLocationEEnum, EntryPointLocation.RESTORE);
		addEEnumLiteral(entryPointLocationEEnum, EntryPointLocation.BUILD);
		addEEnumLiteral(entryPointLocationEEnum, EntryPointLocation.EXIT);

		initEEnum(entryPointPropertyEEnum, EntryPointProperty.class, "EntryPointProperty");
		addEEnumLiteral(entryPointPropertyEEnum, EntryPointProperty.NONE);
		addEEnumLiteral(entryPointPropertyEEnum, EntryPointProperty.AUTO_LOAD_BEGIN);
		addEEnumLiteral(entryPointPropertyEEnum, EntryPointProperty.AUTO_LOAD_END);

		initEEnum(variableMultiplicityEEnum, VariableMultiplicity.class, "VariableMultiplicity");
		addEEnumLiteral(variableMultiplicityEEnum, VariableMultiplicity.SCALAR);
		addEEnumLiteral(variableMultiplicityEEnum, VariableMultiplicity.ARRAY);
		addEEnumLiteral(variableMultiplicityEEnum, VariableMultiplicity.ARRAY2);

		initEEnum(argDirectionEEnum, ArgDirection.class, "ArgDirection");
		addEEnumLiteral(argDirectionEEnum, ArgDirection.IN);
		addEEnumLiteral(argDirectionEEnum, ArgDirection.OUT);

		initEEnum(annotationLevelsEEnum, AnnotationLevels.class, "AnnotationLevels");
		addEEnumLiteral(annotationLevelsEEnum, AnnotationLevels.ERROR);
		addEEnumLiteral(annotationLevelsEEnum, AnnotationLevels.WARNING);
		addEEnumLiteral(annotationLevelsEEnum, AnnotationLevels.FILTERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// Technical
		createTechnicalAnnotations();
	}

	/**
	 * Initializes the annotations for <b>Technical</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createTechnicalAnnotations() {
		String source = "Technical";		
		addAnnotation
		  (getService_Type(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getServiceOrModule_Version(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getEntryPoint_Property(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getVariable_Dump(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getVariable_Restore(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getVariable_ExecutionDepend(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getVariable_NeedSync(), 
		   source, 
		   new String[] {
		   });
	}

} //ArcanePackageImpl
