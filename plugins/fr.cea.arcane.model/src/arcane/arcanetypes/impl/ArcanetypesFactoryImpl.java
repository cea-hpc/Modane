/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.arcanetypes.impl;

import arcane.arcanetypes.*;

import org.eclipse.emf.ecore.EClass;
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
public class ArcanetypesFactoryImpl extends EFactoryImpl implements ArcanetypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ArcanetypesFactory init() {
		try {
			ArcanetypesFactory theArcanetypesFactory = (ArcanetypesFactory)EPackage.Registry.INSTANCE.getEFactory(ArcanetypesPackage.eNS_URI);
			if (theArcanetypesFactory != null) {
				return theArcanetypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ArcanetypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArcanetypesFactoryImpl() {
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
			case ArcanetypesPackage.ARCANE_TYPES: return createArcaneTypes();
			case ArcanetypesPackage.ITEM_TYPE: return createItemType();
			case ArcanetypesPackage.SIMPLE_TYPE: return createSimpleType();
			case ArcanetypesPackage.MESH_TYPE: return createMeshType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArcaneTypes createArcaneTypes() {
		ArcaneTypesImpl arcaneTypes = new ArcaneTypesImpl();
		return arcaneTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemType createItemType() {
		ItemTypeImpl itemType = new ItemTypeImpl();
		return itemType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleType createSimpleType() {
		SimpleTypeImpl simpleType = new SimpleTypeImpl();
		return simpleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeshType createMeshType() {
		MeshTypeImpl meshType = new MeshTypeImpl();
		return meshType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArcanetypesPackage getArcanetypesPackage() {
		return (ArcanetypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ArcanetypesPackage getPackage() {
		return ArcanetypesPackage.eINSTANCE;
	}

} //ArcanetypesFactoryImpl
