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
import arcane.Interface;
import arcane.Legacy;
import arcane.Module;
import arcane.Property;
import arcane.Service;
import arcane.ServiceTypeList;
import arcane.Struct;
import arcane.Variable;
import arcane.VariableMultiplicity;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArcaneFactoryImpl extends EFactoryImpl implements ArcaneFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ArcaneFactory init() {
		try {
			ArcaneFactory theArcaneFactory = (ArcaneFactory)EPackage.Registry.INSTANCE.getEFactory(ArcanePackage.eNS_URI);
			if (theArcaneFactory != null) {
				return theArcaneFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ArcaneFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArcaneFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ArcanePackage.FUNC: return createFunc();
			case ArcanePackage.MODULE: return createModule();
			case ArcanePackage.SERVICE: return createService();
			case ArcanePackage.ENTRY_POINT: return createEntryPoint();
			case ArcanePackage.PACKAGE: return createPackage();
			case ArcanePackage.STRUCT: return createStruct();
			case ArcanePackage.ENUMERATION: return createEnumeration();
			case ArcanePackage.INTERFACE: return createInterface();
			case ArcanePackage.VARIABLE: return createVariable();
			case ArcanePackage.ARGUMENT: return createArgument();
			case ArcanePackage.LEGACY: return createLegacy();
			case ArcanePackage.ENUMERATION_LITERAL: return createEnumerationLiteral();
			case ArcanePackage.PROPERTY: return createProperty();
			case ArcanePackage.ANNOTATION: return createAnnotation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ArcanePackage.SERVICE_TYPE_LIST:
				return createServiceTypeListFromString(eDataType, initialValue);
			case ArcanePackage.ENTRY_POINT_LOCATION:
				return createEntryPointLocationFromString(eDataType, initialValue);
			case ArcanePackage.ENTRY_POINT_PROPERTY:
				return createEntryPointPropertyFromString(eDataType, initialValue);
			case ArcanePackage.VARIABLE_MULTIPLICITY:
				return createVariableMultiplicityFromString(eDataType, initialValue);
			case ArcanePackage.ARG_DIRECTION:
				return createArgDirectionFromString(eDataType, initialValue);
			case ArcanePackage.ANNOTATION_LEVELS:
				return createAnnotationLevelsFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ArcanePackage.SERVICE_TYPE_LIST:
				return convertServiceTypeListToString(eDataType, instanceValue);
			case ArcanePackage.ENTRY_POINT_LOCATION:
				return convertEntryPointLocationToString(eDataType, instanceValue);
			case ArcanePackage.ENTRY_POINT_PROPERTY:
				return convertEntryPointPropertyToString(eDataType, instanceValue);
			case ArcanePackage.VARIABLE_MULTIPLICITY:
				return convertVariableMultiplicityToString(eDataType, instanceValue);
			case ArcanePackage.ARG_DIRECTION:
				return convertArgDirectionToString(eDataType, instanceValue);
			case ArcanePackage.ANNOTATION_LEVELS:
				return convertAnnotationLevelsToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Func createFunc() {
		FuncImpl func = new FuncImpl();
		return func;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module createModule() {
		ModuleImpl module = new ModuleImpl();
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryPoint createEntryPoint() {
		EntryPointImpl entryPoint = new EntryPointImpl();
		return entryPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public arcane.Package createPackage() {
		PackageImpl package_ = new PackageImpl();
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Struct createStruct() {
		StructImpl struct = new StructImpl();
		return struct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration createEnumeration() {
		EnumerationImpl enumeration = new EnumerationImpl();
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface createInterface() {
		InterfaceImpl interface_ = new InterfaceImpl();
		return interface_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Argument createArgument() {
		ArgumentImpl argument = new ArgumentImpl();
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Legacy createLegacy() {
		LegacyImpl legacy = new LegacyImpl();
		return legacy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteral createEnumerationLiteral() {
		EnumerationLiteralImpl enumerationLiteral = new EnumerationLiteralImpl();
		return enumerationLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceTypeList createServiceTypeListFromString(EDataType eDataType, String initialValue) {
		ServiceTypeList result = ServiceTypeList.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertServiceTypeListToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryPointLocation createEntryPointLocationFromString(EDataType eDataType, String initialValue) {
		EntryPointLocation result = EntryPointLocation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEntryPointLocationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryPointProperty createEntryPointPropertyFromString(EDataType eDataType, String initialValue) {
		EntryPointProperty result = EntryPointProperty.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEntryPointPropertyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableMultiplicity createVariableMultiplicityFromString(EDataType eDataType, String initialValue) {
		VariableMultiplicity result = VariableMultiplicity.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariableMultiplicityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArgDirection createArgDirectionFromString(EDataType eDataType, String initialValue) {
		ArgDirection result = ArgDirection.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArgDirectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationLevels createAnnotationLevelsFromString(EDataType eDataType, String initialValue) {
		AnnotationLevels result = AnnotationLevels.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAnnotationLevelsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArcanePackage getArcanePackage() {
		return (ArcanePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ArcanePackage getPackage() {
		return ArcanePackage.eINSTANCE;
	}

} //ArcaneFactoryImpl
