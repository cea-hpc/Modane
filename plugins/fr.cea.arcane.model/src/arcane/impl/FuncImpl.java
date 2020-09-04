/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import arcane.ArcanePackage;
import arcane.Argument;
import arcane.Func;
import arcane.FuncContainer;
import arcane.arcanetypes.ItemType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Func</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arcane.impl.FuncImpl#getSupport <em>Support</em>}</li>
 *   <li>{@link arcane.impl.FuncImpl#isParallel <em>Parallel</em>}</li>
 *   <li>{@link arcane.impl.FuncImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link arcane.impl.FuncImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link arcane.impl.FuncImpl#isItemTypeSpecialized <em>Item Type Specialized</em>}</li>
 *   <li>{@link arcane.impl.FuncImpl#getReturnArgument <em>Return Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FuncImpl extends FuncOrEntryPointImpl implements Func {
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
	 * The default value of the '{@link #isParallel() <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParallel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PARALLEL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isParallel() <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParallel()
	 * @generated
	 * @ordered
	 */
	protected boolean parallel = PARALLEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
	protected EList<Argument> args;

	/**
	 * The default value of the '{@link #isItemTypeSpecialized() <em>Item Type Specialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isItemTypeSpecialized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ITEM_TYPE_SPECIALIZED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isItemTypeSpecialized() <em>Item Type Specialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isItemTypeSpecialized()
	 * @generated
	 * @ordered
	 */
	protected boolean itemTypeSpecialized = ITEM_TYPE_SPECIALIZED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReturnArgument() <em>Return Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnArgument()
	 * @generated
	 * @ordered
	 */
	protected Argument returnArgument;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuncImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArcanePackage.Literals.FUNC;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArcanePackage.FUNC__SUPPORT, oldSupport, support));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.FUNC__SUPPORT, oldSupport, support));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isParallel() {
		return parallel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParallel(boolean newParallel) {
		boolean oldParallel = parallel;
		parallel = newParallel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.FUNC__PARALLEL, oldParallel, parallel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Argument> getArgs() {
		if (args == null) {
			args = new EObjectContainmentEList<Argument>(Argument.class, this, ArcanePackage.FUNC__ARGS);
		}
		return args;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuncContainer getContainer() {
		if (eContainerFeatureID() != ArcanePackage.FUNC__CONTAINER) return null;
		return (FuncContainer)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(FuncContainer newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer, ArcanePackage.FUNC__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(FuncContainer newContainer) {
		if (newContainer != eInternalContainer() || (eContainerFeatureID() != ArcanePackage.FUNC__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, ArcanePackage.FUNC_CONTAINER__FUNCS, FuncContainer.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.FUNC__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isItemTypeSpecialized() {
		return itemTypeSpecialized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemTypeSpecialized(boolean newItemTypeSpecialized) {
		boolean oldItemTypeSpecialized = itemTypeSpecialized;
		itemTypeSpecialized = newItemTypeSpecialized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.FUNC__ITEM_TYPE_SPECIALIZED, oldItemTypeSpecialized, itemTypeSpecialized));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Argument getReturnArgument() {
		return returnArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnArgument(Argument newReturnArgument, NotificationChain msgs) {
		Argument oldReturnArgument = returnArgument;
		returnArgument = newReturnArgument;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArcanePackage.FUNC__RETURN_ARGUMENT, oldReturnArgument, newReturnArgument);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnArgument(Argument newReturnArgument) {
		if (newReturnArgument != returnArgument) {
			NotificationChain msgs = null;
			if (returnArgument != null)
				msgs = ((InternalEObject)returnArgument).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ArcanePackage.FUNC__RETURN_ARGUMENT, null, msgs);
			if (newReturnArgument != null)
				msgs = ((InternalEObject)newReturnArgument).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ArcanePackage.FUNC__RETURN_ARGUMENT, null, msgs);
			msgs = basicSetReturnArgument(newReturnArgument, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.FUNC__RETURN_ARGUMENT, newReturnArgument, newReturnArgument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArcanePackage.FUNC__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer((FuncContainer)otherEnd, msgs);
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
			case ArcanePackage.FUNC__ARGS:
				return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
			case ArcanePackage.FUNC__CONTAINER:
				return basicSetContainer(null, msgs);
			case ArcanePackage.FUNC__RETURN_ARGUMENT:
				return basicSetReturnArgument(null, msgs);
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
			case ArcanePackage.FUNC__CONTAINER:
				return eInternalContainer().eInverseRemove(this, ArcanePackage.FUNC_CONTAINER__FUNCS, FuncContainer.class, msgs);
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
			case ArcanePackage.FUNC__SUPPORT:
				if (resolve) return getSupport();
				return basicGetSupport();
			case ArcanePackage.FUNC__PARALLEL:
				return isParallel();
			case ArcanePackage.FUNC__ARGS:
				return getArgs();
			case ArcanePackage.FUNC__CONTAINER:
				return getContainer();
			case ArcanePackage.FUNC__ITEM_TYPE_SPECIALIZED:
				return isItemTypeSpecialized();
			case ArcanePackage.FUNC__RETURN_ARGUMENT:
				return getReturnArgument();
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
			case ArcanePackage.FUNC__SUPPORT:
				setSupport((ItemType)newValue);
				return;
			case ArcanePackage.FUNC__PARALLEL:
				setParallel((Boolean)newValue);
				return;
			case ArcanePackage.FUNC__ARGS:
				getArgs().clear();
				getArgs().addAll((Collection<? extends Argument>)newValue);
				return;
			case ArcanePackage.FUNC__CONTAINER:
				setContainer((FuncContainer)newValue);
				return;
			case ArcanePackage.FUNC__ITEM_TYPE_SPECIALIZED:
				setItemTypeSpecialized((Boolean)newValue);
				return;
			case ArcanePackage.FUNC__RETURN_ARGUMENT:
				setReturnArgument((Argument)newValue);
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
			case ArcanePackage.FUNC__SUPPORT:
				setSupport((ItemType)null);
				return;
			case ArcanePackage.FUNC__PARALLEL:
				setParallel(PARALLEL_EDEFAULT);
				return;
			case ArcanePackage.FUNC__ARGS:
				getArgs().clear();
				return;
			case ArcanePackage.FUNC__CONTAINER:
				setContainer((FuncContainer)null);
				return;
			case ArcanePackage.FUNC__ITEM_TYPE_SPECIALIZED:
				setItemTypeSpecialized(ITEM_TYPE_SPECIALIZED_EDEFAULT);
				return;
			case ArcanePackage.FUNC__RETURN_ARGUMENT:
				setReturnArgument((Argument)null);
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
			case ArcanePackage.FUNC__SUPPORT:
				return support != null;
			case ArcanePackage.FUNC__PARALLEL:
				return parallel != PARALLEL_EDEFAULT;
			case ArcanePackage.FUNC__ARGS:
				return args != null && !args.isEmpty();
			case ArcanePackage.FUNC__CONTAINER:
				return getContainer() != null;
			case ArcanePackage.FUNC__ITEM_TYPE_SPECIALIZED:
				return itemTypeSpecialized != ITEM_TYPE_SPECIALIZED_EDEFAULT;
			case ArcanePackage.FUNC__RETURN_ARGUMENT:
				return returnArgument != null;
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
		result.append(" (parallel: ");
		result.append(parallel);
		result.append(", itemTypeSpecialized: ");
		result.append(itemTypeSpecialized);
		result.append(')');
		return result.toString();
	}

} //FuncImpl
