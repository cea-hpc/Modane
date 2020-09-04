/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.impl;

import arcane.ArcanePackage;
import arcane.Variable;
import arcane.VariableMultiplicity;

import arcane.arcanetypes.ItemType;
import arcane.arcanetypes.SimpleType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arcane.impl.VariableImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link arcane.impl.VariableImpl#getType <em>Type</em>}</li>
 *   <li>{@link arcane.impl.VariableImpl#getSupport <em>Support</em>}</li>
 *   <li>{@link arcane.impl.VariableImpl#isDump <em>Dump</em>}</li>
 *   <li>{@link arcane.impl.VariableImpl#isRestore <em>Restore</em>}</li>
 *   <li>{@link arcane.impl.VariableImpl#isExecutionDepend <em>Execution Depend</em>}</li>
 *   <li>{@link arcane.impl.VariableImpl#isNeedSync <em>Need Sync</em>}</li>
 *   <li>{@link arcane.impl.VariableImpl#isAbstract <em>Abstract</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableImpl extends PackagedElementImpl implements Variable {
	/**
	 * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final VariableMultiplicity MULTIPLICITY_EDEFAULT = VariableMultiplicity.SCALAR;

	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected VariableMultiplicity multiplicity = MULTIPLICITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected SimpleType type;

	/**
	 * The cached value of the '{@link #getSupport() <em>Support</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupport()
	 * @generated
	 * @ordered
	 */
	protected ItemType support;

	/**
	 * The default value of the '{@link #isDump() <em>Dump</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDump()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DUMP_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDump() <em>Dump</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDump()
	 * @generated
	 * @ordered
	 */
	protected boolean dump = DUMP_EDEFAULT;

	/**
	 * The default value of the '{@link #isRestore() <em>Restore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRestore()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESTORE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRestore() <em>Restore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRestore()
	 * @generated
	 * @ordered
	 */
	protected boolean restore = RESTORE_EDEFAULT;

	/**
	 * The default value of the '{@link #isExecutionDepend() <em>Execution Depend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExecutionDepend()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXECUTION_DEPEND_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExecutionDepend() <em>Execution Depend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExecutionDepend()
	 * @generated
	 * @ordered
	 */
	protected boolean executionDepend = EXECUTION_DEPEND_EDEFAULT;

	/**
	 * The default value of the '{@link #isNeedSync() <em>Need Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNeedSync()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NEED_SYNC_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isNeedSync() <em>Need Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNeedSync()
	 * @generated
	 * @ordered
	 */
	protected boolean needSync = NEED_SYNC_EDEFAULT;

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArcanePackage.Literals.VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableMultiplicity getMultiplicity() {
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(VariableMultiplicity newMultiplicity) {
		VariableMultiplicity oldMultiplicity = multiplicity;
		multiplicity = newMultiplicity == null ? MULTIPLICITY_EDEFAULT : newMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.VARIABLE__MULTIPLICITY, oldMultiplicity, multiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (SimpleType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArcanePackage.VARIABLE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(SimpleType newType) {
		SimpleType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.VARIABLE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemType getSupport() {
		if (support != null && support.eIsProxy()) {
			InternalEObject oldSupport = (InternalEObject)support;
			support = (ItemType)eResolveProxy(oldSupport);
			if (support != oldSupport) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArcanePackage.VARIABLE__SUPPORT, oldSupport, support));
			}
		}
		return support;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemType basicGetSupport() {
		return support;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupport(ItemType newSupport) {
		ItemType oldSupport = support;
		support = newSupport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.VARIABLE__SUPPORT, oldSupport, support));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDump() {
		return dump;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDump(boolean newDump) {
		boolean oldDump = dump;
		dump = newDump;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.VARIABLE__DUMP, oldDump, dump));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRestore() {
		return restore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestore(boolean newRestore) {
		boolean oldRestore = restore;
		restore = newRestore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.VARIABLE__RESTORE, oldRestore, restore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExecutionDepend() {
		return executionDepend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionDepend(boolean newExecutionDepend) {
		boolean oldExecutionDepend = executionDepend;
		executionDepend = newExecutionDepend;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.VARIABLE__EXECUTION_DEPEND, oldExecutionDepend, executionDepend));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNeedSync() {
		return needSync;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNeedSync(boolean newNeedSync) {
		boolean oldNeedSync = needSync;
		needSync = newNeedSync;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.VARIABLE__NEED_SYNC, oldNeedSync, needSync));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.VARIABLE__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArcanePackage.VARIABLE__MULTIPLICITY:
				return getMultiplicity();
			case ArcanePackage.VARIABLE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ArcanePackage.VARIABLE__SUPPORT:
				if (resolve) return getSupport();
				return basicGetSupport();
			case ArcanePackage.VARIABLE__DUMP:
				return isDump();
			case ArcanePackage.VARIABLE__RESTORE:
				return isRestore();
			case ArcanePackage.VARIABLE__EXECUTION_DEPEND:
				return isExecutionDepend();
			case ArcanePackage.VARIABLE__NEED_SYNC:
				return isNeedSync();
			case ArcanePackage.VARIABLE__ABSTRACT:
				return isAbstract();
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
			case ArcanePackage.VARIABLE__MULTIPLICITY:
				setMultiplicity((VariableMultiplicity)newValue);
				return;
			case ArcanePackage.VARIABLE__TYPE:
				setType((SimpleType)newValue);
				return;
			case ArcanePackage.VARIABLE__SUPPORT:
				setSupport((ItemType)newValue);
				return;
			case ArcanePackage.VARIABLE__DUMP:
				setDump((Boolean)newValue);
				return;
			case ArcanePackage.VARIABLE__RESTORE:
				setRestore((Boolean)newValue);
				return;
			case ArcanePackage.VARIABLE__EXECUTION_DEPEND:
				setExecutionDepend((Boolean)newValue);
				return;
			case ArcanePackage.VARIABLE__NEED_SYNC:
				setNeedSync((Boolean)newValue);
				return;
			case ArcanePackage.VARIABLE__ABSTRACT:
				setAbstract((Boolean)newValue);
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
			case ArcanePackage.VARIABLE__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case ArcanePackage.VARIABLE__TYPE:
				setType((SimpleType)null);
				return;
			case ArcanePackage.VARIABLE__SUPPORT:
				setSupport((ItemType)null);
				return;
			case ArcanePackage.VARIABLE__DUMP:
				setDump(DUMP_EDEFAULT);
				return;
			case ArcanePackage.VARIABLE__RESTORE:
				setRestore(RESTORE_EDEFAULT);
				return;
			case ArcanePackage.VARIABLE__EXECUTION_DEPEND:
				setExecutionDepend(EXECUTION_DEPEND_EDEFAULT);
				return;
			case ArcanePackage.VARIABLE__NEED_SYNC:
				setNeedSync(NEED_SYNC_EDEFAULT);
				return;
			case ArcanePackage.VARIABLE__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
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
			case ArcanePackage.VARIABLE__MULTIPLICITY:
				return multiplicity != MULTIPLICITY_EDEFAULT;
			case ArcanePackage.VARIABLE__TYPE:
				return type != null;
			case ArcanePackage.VARIABLE__SUPPORT:
				return support != null;
			case ArcanePackage.VARIABLE__DUMP:
				return dump != DUMP_EDEFAULT;
			case ArcanePackage.VARIABLE__RESTORE:
				return restore != RESTORE_EDEFAULT;
			case ArcanePackage.VARIABLE__EXECUTION_DEPEND:
				return executionDepend != EXECUTION_DEPEND_EDEFAULT;
			case ArcanePackage.VARIABLE__NEED_SYNC:
				return needSync != NEED_SYNC_EDEFAULT;
			case ArcanePackage.VARIABLE__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
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
		result.append(" (multiplicity: ");
		result.append(multiplicity);
		result.append(", dump: ");
		result.append(dump);
		result.append(", restore: ");
		result.append(restore);
		result.append(", executionDepend: ");
		result.append(executionDepend);
		result.append(", needSync: ");
		result.append(needSync);
		result.append(", abstract: ");
		result.append(abstract_);
		result.append(')');
		return result.toString();
	}

} //VariableImpl
