/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.impl;

import arcane.ArcanePackage;
import arcane.PackagedElement;
import arcane.Property;
import arcane.PropertyContainer;
import arcane.Struct;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Struct</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arcane.impl.StructImpl#getContainingPackage <em>Containing Package</em>}</li>
 *   <li>{@link arcane.impl.StructImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link arcane.impl.StructImpl#getParents <em>Parents</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructImpl extends PropertyOrArgumentTypeImpl implements Struct {
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> properties;

	/**
	 * The cached value of the '{@link #getParents() <em>Parents</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParents()
	 * @generated
	 * @ordered
	 */
	protected EList<Struct> parents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArcanePackage.Literals.STRUCT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public arcane.Package getContainingPackage() {
		if (eContainerFeatureID() != ArcanePackage.STRUCT__CONTAINING_PACKAGE) return null;
		return (arcane.Package)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingPackage(arcane.Package newContainingPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainingPackage, ArcanePackage.STRUCT__CONTAINING_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingPackage(arcane.Package newContainingPackage) {
		if (newContainingPackage != eInternalContainer() || (eContainerFeatureID() != ArcanePackage.STRUCT__CONTAINING_PACKAGE && newContainingPackage != null)) {
			if (EcoreUtil.isAncestor(this, newContainingPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingPackage != null)
				msgs = ((InternalEObject)newContainingPackage).eInverseAdd(this, ArcanePackage.PACKAGE__ELEMENTS, arcane.Package.class, msgs);
			msgs = basicSetContainingPackage(newContainingPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.STRUCT__CONTAINING_PACKAGE, newContainingPackage, newContainingPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentWithInverseEList<Property>(Property.class, this, ArcanePackage.STRUCT__PROPERTIES, ArcanePackage.PROPERTY__CONTAINING_CONTAINER);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Struct> getParents() {
		if (parents == null) {
			parents = new EObjectResolvingEList<Struct>(Struct.class, this, ArcanePackage.STRUCT__PARENTS);
		}
		return parents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArcanePackage.STRUCT__CONTAINING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainingPackage((arcane.Package)otherEnd, msgs);
			case ArcanePackage.STRUCT__PROPERTIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProperties()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArcanePackage.STRUCT__CONTAINING_PACKAGE:
				return basicSetContainingPackage(null, msgs);
			case ArcanePackage.STRUCT__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ArcanePackage.STRUCT__CONTAINING_PACKAGE:
				return eInternalContainer().eInverseRemove(this, ArcanePackage.PACKAGE__ELEMENTS, arcane.Package.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArcanePackage.STRUCT__CONTAINING_PACKAGE:
				return getContainingPackage();
			case ArcanePackage.STRUCT__PROPERTIES:
				return getProperties();
			case ArcanePackage.STRUCT__PARENTS:
				return getParents();
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
			case ArcanePackage.STRUCT__CONTAINING_PACKAGE:
				setContainingPackage((arcane.Package)newValue);
				return;
			case ArcanePackage.STRUCT__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case ArcanePackage.STRUCT__PARENTS:
				getParents().clear();
				getParents().addAll((Collection<? extends Struct>)newValue);
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
			case ArcanePackage.STRUCT__CONTAINING_PACKAGE:
				setContainingPackage((arcane.Package)null);
				return;
			case ArcanePackage.STRUCT__PROPERTIES:
				getProperties().clear();
				return;
			case ArcanePackage.STRUCT__PARENTS:
				getParents().clear();
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
			case ArcanePackage.STRUCT__CONTAINING_PACKAGE:
				return getContainingPackage() != null;
			case ArcanePackage.STRUCT__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case ArcanePackage.STRUCT__PARENTS:
				return parents != null && !parents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == PackagedElement.class) {
			switch (derivedFeatureID) {
				case ArcanePackage.STRUCT__CONTAINING_PACKAGE: return ArcanePackage.PACKAGED_ELEMENT__CONTAINING_PACKAGE;
				default: return -1;
			}
		}
		if (baseClass == PropertyContainer.class) {
			switch (derivedFeatureID) {
				case ArcanePackage.STRUCT__PROPERTIES: return ArcanePackage.PROPERTY_CONTAINER__PROPERTIES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == PackagedElement.class) {
			switch (baseFeatureID) {
				case ArcanePackage.PACKAGED_ELEMENT__CONTAINING_PACKAGE: return ArcanePackage.STRUCT__CONTAINING_PACKAGE;
				default: return -1;
			}
		}
		if (baseClass == PropertyContainer.class) {
			switch (baseFeatureID) {
				case ArcanePackage.PROPERTY_CONTAINER__PROPERTIES: return ArcanePackage.STRUCT__PROPERTIES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //StructImpl
