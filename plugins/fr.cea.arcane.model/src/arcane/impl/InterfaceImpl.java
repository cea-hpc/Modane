/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.impl;

import arcane.ArcanePackage;
import arcane.Func;
import arcane.FuncContainer;
import arcane.Interface;
import arcane.PackagedElement;
import arcane.Property;
import arcane.PropertyContainer;
import arcane.Service;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arcane.impl.InterfaceImpl#getContainingPackage <em>Containing Package</em>}</li>
 *   <li>{@link arcane.impl.InterfaceImpl#getFuncs <em>Funcs</em>}</li>
 *   <li>{@link arcane.impl.InterfaceImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link arcane.impl.InterfaceImpl#getParents <em>Parents</em>}</li>
 *   <li>{@link arcane.impl.InterfaceImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link arcane.impl.InterfaceImpl#getRealisations <em>Realisations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceImpl extends PropertyOrArgumentTypeImpl implements Interface {
	/**
	 * The cached value of the '{@link #getFuncs() <em>Funcs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuncs()
	 * @generated
	 * @ordered
	 */
	protected EList<Func> funcs;

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
	protected EList<Interface> parents;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> children;

	/**
	 * The cached value of the '{@link #getRealisations() <em>Realisations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealisations()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> realisations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArcanePackage.Literals.INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public arcane.Package getContainingPackage() {
		if (eContainerFeatureID() != ArcanePackage.INTERFACE__CONTAINING_PACKAGE) return null;
		return (arcane.Package)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingPackage(arcane.Package newContainingPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainingPackage, ArcanePackage.INTERFACE__CONTAINING_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingPackage(arcane.Package newContainingPackage) {
		if (newContainingPackage != eInternalContainer() || (eContainerFeatureID() != ArcanePackage.INTERFACE__CONTAINING_PACKAGE && newContainingPackage != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.INTERFACE__CONTAINING_PACKAGE, newContainingPackage, newContainingPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Func> getFuncs() {
		if (funcs == null) {
			funcs = new EObjectContainmentWithInverseEList<Func>(Func.class, this, ArcanePackage.INTERFACE__FUNCS, ArcanePackage.FUNC__CONTAINER);
		}
		return funcs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentWithInverseEList<Property>(Property.class, this, ArcanePackage.INTERFACE__PROPERTIES, ArcanePackage.PROPERTY__CONTAINING_CONTAINER);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getParents() {
		if (parents == null) {
			parents = new EObjectWithInverseResolvingEList.ManyInverse<Interface>(Interface.class, this, ArcanePackage.INTERFACE__PARENTS, ArcanePackage.INTERFACE__CHILDREN);
		}
		return parents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseResolvingEList.ManyInverse<Interface>(Interface.class, this, ArcanePackage.INTERFACE__CHILDREN, ArcanePackage.INTERFACE__PARENTS);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getRealisations() {
		if (realisations == null) {
			realisations = new EObjectWithInverseResolvingEList<Service>(Service.class, this, ArcanePackage.INTERFACE__REALISATIONS, ArcanePackage.SERVICE__INTERFACE);
		}
		return realisations;
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
			case ArcanePackage.INTERFACE__CONTAINING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainingPackage((arcane.Package)otherEnd, msgs);
			case ArcanePackage.INTERFACE__FUNCS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFuncs()).basicAdd(otherEnd, msgs);
			case ArcanePackage.INTERFACE__PROPERTIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProperties()).basicAdd(otherEnd, msgs);
			case ArcanePackage.INTERFACE__PARENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParents()).basicAdd(otherEnd, msgs);
			case ArcanePackage.INTERFACE__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
			case ArcanePackage.INTERFACE__REALISATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRealisations()).basicAdd(otherEnd, msgs);
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
			case ArcanePackage.INTERFACE__CONTAINING_PACKAGE:
				return basicSetContainingPackage(null, msgs);
			case ArcanePackage.INTERFACE__FUNCS:
				return ((InternalEList<?>)getFuncs()).basicRemove(otherEnd, msgs);
			case ArcanePackage.INTERFACE__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case ArcanePackage.INTERFACE__PARENTS:
				return ((InternalEList<?>)getParents()).basicRemove(otherEnd, msgs);
			case ArcanePackage.INTERFACE__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case ArcanePackage.INTERFACE__REALISATIONS:
				return ((InternalEList<?>)getRealisations()).basicRemove(otherEnd, msgs);
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
			case ArcanePackage.INTERFACE__CONTAINING_PACKAGE:
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
			case ArcanePackage.INTERFACE__CONTAINING_PACKAGE:
				return getContainingPackage();
			case ArcanePackage.INTERFACE__FUNCS:
				return getFuncs();
			case ArcanePackage.INTERFACE__PROPERTIES:
				return getProperties();
			case ArcanePackage.INTERFACE__PARENTS:
				return getParents();
			case ArcanePackage.INTERFACE__CHILDREN:
				return getChildren();
			case ArcanePackage.INTERFACE__REALISATIONS:
				return getRealisations();
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
			case ArcanePackage.INTERFACE__CONTAINING_PACKAGE:
				setContainingPackage((arcane.Package)newValue);
				return;
			case ArcanePackage.INTERFACE__FUNCS:
				getFuncs().clear();
				getFuncs().addAll((Collection<? extends Func>)newValue);
				return;
			case ArcanePackage.INTERFACE__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case ArcanePackage.INTERFACE__PARENTS:
				getParents().clear();
				getParents().addAll((Collection<? extends Interface>)newValue);
				return;
			case ArcanePackage.INTERFACE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends Interface>)newValue);
				return;
			case ArcanePackage.INTERFACE__REALISATIONS:
				getRealisations().clear();
				getRealisations().addAll((Collection<? extends Service>)newValue);
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
			case ArcanePackage.INTERFACE__CONTAINING_PACKAGE:
				setContainingPackage((arcane.Package)null);
				return;
			case ArcanePackage.INTERFACE__FUNCS:
				getFuncs().clear();
				return;
			case ArcanePackage.INTERFACE__PROPERTIES:
				getProperties().clear();
				return;
			case ArcanePackage.INTERFACE__PARENTS:
				getParents().clear();
				return;
			case ArcanePackage.INTERFACE__CHILDREN:
				getChildren().clear();
				return;
			case ArcanePackage.INTERFACE__REALISATIONS:
				getRealisations().clear();
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
			case ArcanePackage.INTERFACE__CONTAINING_PACKAGE:
				return getContainingPackage() != null;
			case ArcanePackage.INTERFACE__FUNCS:
				return funcs != null && !funcs.isEmpty();
			case ArcanePackage.INTERFACE__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case ArcanePackage.INTERFACE__PARENTS:
				return parents != null && !parents.isEmpty();
			case ArcanePackage.INTERFACE__CHILDREN:
				return children != null && !children.isEmpty();
			case ArcanePackage.INTERFACE__REALISATIONS:
				return realisations != null && !realisations.isEmpty();
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
				case ArcanePackage.INTERFACE__CONTAINING_PACKAGE: return ArcanePackage.PACKAGED_ELEMENT__CONTAINING_PACKAGE;
				default: return -1;
			}
		}
		if (baseClass == FuncContainer.class) {
			switch (derivedFeatureID) {
				case ArcanePackage.INTERFACE__FUNCS: return ArcanePackage.FUNC_CONTAINER__FUNCS;
				default: return -1;
			}
		}
		if (baseClass == PropertyContainer.class) {
			switch (derivedFeatureID) {
				case ArcanePackage.INTERFACE__PROPERTIES: return ArcanePackage.PROPERTY_CONTAINER__PROPERTIES;
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
				case ArcanePackage.PACKAGED_ELEMENT__CONTAINING_PACKAGE: return ArcanePackage.INTERFACE__CONTAINING_PACKAGE;
				default: return -1;
			}
		}
		if (baseClass == FuncContainer.class) {
			switch (baseFeatureID) {
				case ArcanePackage.FUNC_CONTAINER__FUNCS: return ArcanePackage.INTERFACE__FUNCS;
				default: return -1;
			}
		}
		if (baseClass == PropertyContainer.class) {
			switch (baseFeatureID) {
				case ArcanePackage.PROPERTY_CONTAINER__PROPERTIES: return ArcanePackage.INTERFACE__PROPERTIES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //InterfaceImpl
