/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.impl;

import arcane.ArcanePackage;
import arcane.EntryPoint;
import arcane.EntryPointLocation;
import arcane.EntryPointProperty;
import arcane.Module;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arcane.impl.EntryPointImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link arcane.impl.EntryPointImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link arcane.impl.EntryPointImpl#getContainingModule <em>Containing Module</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntryPointImpl extends FuncOrEntryPointImpl implements EntryPoint {
	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final EntryPointLocation LOCATION_EDEFAULT = EntryPointLocation.COMPUTE_LOOP;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected EntryPointLocation location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected static final EntryPointProperty PROPERTY_EDEFAULT = EntryPointProperty.NONE;

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected EntryPointProperty property = PROPERTY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArcanePackage.Literals.ENTRY_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryPointLocation getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(EntryPointLocation newLocation) {
		EntryPointLocation oldLocation = location;
		location = newLocation == null ? LOCATION_EDEFAULT : newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.ENTRY_POINT__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryPointProperty getProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(EntryPointProperty newProperty) {
		EntryPointProperty oldProperty = property;
		property = newProperty == null ? PROPERTY_EDEFAULT : newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.ENTRY_POINT__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module getContainingModule() {
		if (eContainerFeatureID() != ArcanePackage.ENTRY_POINT__CONTAINING_MODULE) return null;
		return (Module)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingModule(Module newContainingModule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainingModule, ArcanePackage.ENTRY_POINT__CONTAINING_MODULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingModule(Module newContainingModule) {
		if (newContainingModule != eInternalContainer() || (eContainerFeatureID() != ArcanePackage.ENTRY_POINT__CONTAINING_MODULE && newContainingModule != null)) {
			if (EcoreUtil.isAncestor(this, newContainingModule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingModule != null)
				msgs = ((InternalEObject)newContainingModule).eInverseAdd(this, ArcanePackage.MODULE__ENTRY_POINTS, Module.class, msgs);
			msgs = basicSetContainingModule(newContainingModule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.ENTRY_POINT__CONTAINING_MODULE, newContainingModule, newContainingModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArcanePackage.ENTRY_POINT__CONTAINING_MODULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainingModule((Module)otherEnd, msgs);
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
			case ArcanePackage.ENTRY_POINT__CONTAINING_MODULE:
				return basicSetContainingModule(null, msgs);
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
			case ArcanePackage.ENTRY_POINT__CONTAINING_MODULE:
				return eInternalContainer().eInverseRemove(this, ArcanePackage.MODULE__ENTRY_POINTS, Module.class, msgs);
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
			case ArcanePackage.ENTRY_POINT__LOCATION:
				return getLocation();
			case ArcanePackage.ENTRY_POINT__PROPERTY:
				return getProperty();
			case ArcanePackage.ENTRY_POINT__CONTAINING_MODULE:
				return getContainingModule();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ArcanePackage.ENTRY_POINT__LOCATION:
				setLocation((EntryPointLocation)newValue);
				return;
			case ArcanePackage.ENTRY_POINT__PROPERTY:
				setProperty((EntryPointProperty)newValue);
				return;
			case ArcanePackage.ENTRY_POINT__CONTAINING_MODULE:
				setContainingModule((Module)newValue);
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
			case ArcanePackage.ENTRY_POINT__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case ArcanePackage.ENTRY_POINT__PROPERTY:
				setProperty(PROPERTY_EDEFAULT);
				return;
			case ArcanePackage.ENTRY_POINT__CONTAINING_MODULE:
				setContainingModule((Module)null);
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
			case ArcanePackage.ENTRY_POINT__LOCATION:
				return location != LOCATION_EDEFAULT;
			case ArcanePackage.ENTRY_POINT__PROPERTY:
				return property != PROPERTY_EDEFAULT;
			case ArcanePackage.ENTRY_POINT__CONTAINING_MODULE:
				return getContainingModule() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (location: ");
		result.append(location);
		result.append(", property: ");
		result.append(property);
		result.append(')');
		return result.toString();
	}

} //EntryPointImpl
