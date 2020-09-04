/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.arcanetypes.impl;

import arcane.arcanetypes.ArcaneTypes;
import arcane.arcanetypes.ArcanetypesPackage;
import arcane.arcanetypes.MeshType;
import arcane.arcanetypes.SimpleType;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arcane Types</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arcane.arcanetypes.impl.ArcaneTypesImpl#getMeshTypes <em>Mesh Types</em>}</li>
 *   <li>{@link arcane.arcanetypes.impl.ArcaneTypesImpl#getSimpleTypes <em>Simple Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArcaneTypesImpl extends EObjectImpl implements ArcaneTypes {
	/**
	 * The cached value of the '{@link #getMeshTypes() <em>Mesh Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeshTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<MeshType> meshTypes;

	/**
	 * The cached value of the '{@link #getSimpleTypes() <em>Simple Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<SimpleType> simpleTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArcaneTypesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArcanetypesPackage.Literals.ARCANE_TYPES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MeshType> getMeshTypes() {
		if (meshTypes == null) {
			meshTypes = new EObjectContainmentEList<MeshType>(MeshType.class, this, ArcanetypesPackage.ARCANE_TYPES__MESH_TYPES);
		}
		return meshTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SimpleType> getSimpleTypes() {
		if (simpleTypes == null) {
			simpleTypes = new EObjectContainmentEList<SimpleType>(SimpleType.class, this, ArcanetypesPackage.ARCANE_TYPES__SIMPLE_TYPES);
		}
		return simpleTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArcanetypesPackage.ARCANE_TYPES__MESH_TYPES:
				return ((InternalEList<?>)getMeshTypes()).basicRemove(otherEnd, msgs);
			case ArcanetypesPackage.ARCANE_TYPES__SIMPLE_TYPES:
				return ((InternalEList<?>)getSimpleTypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArcanetypesPackage.ARCANE_TYPES__MESH_TYPES:
				return getMeshTypes();
			case ArcanetypesPackage.ARCANE_TYPES__SIMPLE_TYPES:
				return getSimpleTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ArcanetypesPackage.ARCANE_TYPES__MESH_TYPES:
				getMeshTypes().clear();
				getMeshTypes().addAll((Collection<? extends MeshType>)newValue);
				return;
			case ArcanetypesPackage.ARCANE_TYPES__SIMPLE_TYPES:
				getSimpleTypes().clear();
				getSimpleTypes().addAll((Collection<? extends SimpleType>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ArcanetypesPackage.ARCANE_TYPES__MESH_TYPES:
				getMeshTypes().clear();
				return;
			case ArcanetypesPackage.ARCANE_TYPES__SIMPLE_TYPES:
				getSimpleTypes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ArcanetypesPackage.ARCANE_TYPES__MESH_TYPES:
				return meshTypes != null && !meshTypes.isEmpty();
			case ArcanetypesPackage.ARCANE_TYPES__SIMPLE_TYPES:
				return simpleTypes != null && !simpleTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArcaneTypesImpl
