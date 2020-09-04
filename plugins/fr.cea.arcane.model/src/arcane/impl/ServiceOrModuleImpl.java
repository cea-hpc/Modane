/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.impl;

import arcane.ArcanePackage;
import arcane.ServiceOrModule;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Or Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arcane.impl.ServiceOrModuleImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link arcane.impl.ServiceOrModuleImpl#getAxlFilePath <em>Axl File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ServiceOrModuleImpl extends PropertyContainerImpl implements ServiceOrModule {
	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = "1.0";

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAxlFilePath() <em>Axl File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxlFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String AXL_FILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAxlFilePath() <em>Axl File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxlFilePath()
	 * @generated
	 * @ordered
	 */
	protected String axlFilePath = AXL_FILE_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceOrModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArcanePackage.Literals.SERVICE_OR_MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.SERVICE_OR_MODULE__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAxlFilePath() {
		return axlFilePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxlFilePath(String newAxlFilePath) {
		String oldAxlFilePath = axlFilePath;
		axlFilePath = newAxlFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.SERVICE_OR_MODULE__AXL_FILE_PATH, oldAxlFilePath, axlFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArcanePackage.SERVICE_OR_MODULE__VERSION:
				return getVersion();
			case ArcanePackage.SERVICE_OR_MODULE__AXL_FILE_PATH:
				return getAxlFilePath();
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
			case ArcanePackage.SERVICE_OR_MODULE__VERSION:
				setVersion((String)newValue);
				return;
			case ArcanePackage.SERVICE_OR_MODULE__AXL_FILE_PATH:
				setAxlFilePath((String)newValue);
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
			case ArcanePackage.SERVICE_OR_MODULE__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case ArcanePackage.SERVICE_OR_MODULE__AXL_FILE_PATH:
				setAxlFilePath(AXL_FILE_PATH_EDEFAULT);
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
			case ArcanePackage.SERVICE_OR_MODULE__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case ArcanePackage.SERVICE_OR_MODULE__AXL_FILE_PATH:
				return AXL_FILE_PATH_EDEFAULT == null ? axlFilePath != null : !AXL_FILE_PATH_EDEFAULT.equals(axlFilePath);
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
		result.append(" (version: ");
		result.append(version);
		result.append(", axlFilePath: ");
		result.append(axlFilePath);
		result.append(')');
		return result.toString();
	}

} //ServiceOrModuleImpl
