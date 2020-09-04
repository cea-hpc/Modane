/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.impl;

import arcane.ArcanePackage;
import arcane.Legacy;
import arcane.PackagedElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Legacy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arcane.impl.LegacyImpl#getContainingPackage <em>Containing Package</em>}</li>
 *   <li>{@link arcane.impl.LegacyImpl#getOriginNamespace <em>Origin Namespace</em>}</li>
 *   <li>{@link arcane.impl.LegacyImpl#getProvider <em>Provider</em>}</li>
 *   <li>{@link arcane.impl.LegacyImpl#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LegacyImpl extends PropertyOrArgumentTypeImpl implements Legacy {
	/**
	 * The default value of the '{@link #getOriginNamespace() <em>Origin Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGIN_NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOriginNamespace() <em>Origin Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginNamespace()
	 * @generated
	 * @ordered
	 */
	protected String originNamespace = ORIGIN_NAMESPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected String provider = PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected String file = FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LegacyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArcanePackage.Literals.LEGACY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public arcane.Package getContainingPackage() {
		if (eContainerFeatureID() != ArcanePackage.LEGACY__CONTAINING_PACKAGE) return null;
		return (arcane.Package)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingPackage(arcane.Package newContainingPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainingPackage, ArcanePackage.LEGACY__CONTAINING_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingPackage(arcane.Package newContainingPackage) {
		if (newContainingPackage != eInternalContainer() || (eContainerFeatureID() != ArcanePackage.LEGACY__CONTAINING_PACKAGE && newContainingPackage != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.LEGACY__CONTAINING_PACKAGE, newContainingPackage, newContainingPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOriginNamespace() {
		return originNamespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginNamespace(String newOriginNamespace) {
		String oldOriginNamespace = originNamespace;
		originNamespace = newOriginNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.LEGACY__ORIGIN_NAMESPACE, oldOriginNamespace, originNamespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvider(String newProvider) {
		String oldProvider = provider;
		provider = newProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.LEGACY__PROVIDER, oldProvider, provider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFile() {
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFile(String newFile) {
		String oldFile = file;
		file = newFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.LEGACY__FILE, oldFile, file));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArcanePackage.LEGACY__CONTAINING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainingPackage((arcane.Package)otherEnd, msgs);
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
			case ArcanePackage.LEGACY__CONTAINING_PACKAGE:
				return basicSetContainingPackage(null, msgs);
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
			case ArcanePackage.LEGACY__CONTAINING_PACKAGE:
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
			case ArcanePackage.LEGACY__CONTAINING_PACKAGE:
				return getContainingPackage();
			case ArcanePackage.LEGACY__ORIGIN_NAMESPACE:
				return getOriginNamespace();
			case ArcanePackage.LEGACY__PROVIDER:
				return getProvider();
			case ArcanePackage.LEGACY__FILE:
				return getFile();
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
			case ArcanePackage.LEGACY__CONTAINING_PACKAGE:
				setContainingPackage((arcane.Package)newValue);
				return;
			case ArcanePackage.LEGACY__ORIGIN_NAMESPACE:
				setOriginNamespace((String)newValue);
				return;
			case ArcanePackage.LEGACY__PROVIDER:
				setProvider((String)newValue);
				return;
			case ArcanePackage.LEGACY__FILE:
				setFile((String)newValue);
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
			case ArcanePackage.LEGACY__CONTAINING_PACKAGE:
				setContainingPackage((arcane.Package)null);
				return;
			case ArcanePackage.LEGACY__ORIGIN_NAMESPACE:
				setOriginNamespace(ORIGIN_NAMESPACE_EDEFAULT);
				return;
			case ArcanePackage.LEGACY__PROVIDER:
				setProvider(PROVIDER_EDEFAULT);
				return;
			case ArcanePackage.LEGACY__FILE:
				setFile(FILE_EDEFAULT);
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
			case ArcanePackage.LEGACY__CONTAINING_PACKAGE:
				return getContainingPackage() != null;
			case ArcanePackage.LEGACY__ORIGIN_NAMESPACE:
				return ORIGIN_NAMESPACE_EDEFAULT == null ? originNamespace != null : !ORIGIN_NAMESPACE_EDEFAULT.equals(originNamespace);
			case ArcanePackage.LEGACY__PROVIDER:
				return PROVIDER_EDEFAULT == null ? provider != null : !PROVIDER_EDEFAULT.equals(provider);
			case ArcanePackage.LEGACY__FILE:
				return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
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
				case ArcanePackage.LEGACY__CONTAINING_PACKAGE: return ArcanePackage.PACKAGED_ELEMENT__CONTAINING_PACKAGE;
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
				case ArcanePackage.PACKAGED_ELEMENT__CONTAINING_PACKAGE: return ArcanePackage.LEGACY__CONTAINING_PACKAGE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (originNamespace: ");
		result.append(originNamespace);
		result.append(", provider: ");
		result.append(provider);
		result.append(", file: ");
		result.append(file);
		result.append(')');
		return result.toString();
	}

} //LegacyImpl
