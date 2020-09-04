/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.impl;

import arcane.ArcanePackage;
import arcane.Enumeration;
import arcane.EnumerationLiteral;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arcane.impl.EnumerationLiteralImpl#getContainingEnumeration <em>Containing Enumeration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationLiteralImpl extends NamedElementImpl implements EnumerationLiteral {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArcanePackage.Literals.ENUMERATION_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration getContainingEnumeration() {
		if (eContainerFeatureID() != ArcanePackage.ENUMERATION_LITERAL__CONTAINING_ENUMERATION) return null;
		return (Enumeration)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingEnumeration(Enumeration newContainingEnumeration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainingEnumeration, ArcanePackage.ENUMERATION_LITERAL__CONTAINING_ENUMERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingEnumeration(Enumeration newContainingEnumeration) {
		if (newContainingEnumeration != eInternalContainer() || (eContainerFeatureID() != ArcanePackage.ENUMERATION_LITERAL__CONTAINING_ENUMERATION && newContainingEnumeration != null)) {
			if (EcoreUtil.isAncestor(this, newContainingEnumeration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingEnumeration != null)
				msgs = ((InternalEObject)newContainingEnumeration).eInverseAdd(this, ArcanePackage.ENUMERATION__LITERALS, Enumeration.class, msgs);
			msgs = basicSetContainingEnumeration(newContainingEnumeration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.ENUMERATION_LITERAL__CONTAINING_ENUMERATION, newContainingEnumeration, newContainingEnumeration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArcanePackage.ENUMERATION_LITERAL__CONTAINING_ENUMERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainingEnumeration((Enumeration)otherEnd, msgs);
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
			case ArcanePackage.ENUMERATION_LITERAL__CONTAINING_ENUMERATION:
				return basicSetContainingEnumeration(null, msgs);
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
			case ArcanePackage.ENUMERATION_LITERAL__CONTAINING_ENUMERATION:
				return eInternalContainer().eInverseRemove(this, ArcanePackage.ENUMERATION__LITERALS, Enumeration.class, msgs);
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
			case ArcanePackage.ENUMERATION_LITERAL__CONTAINING_ENUMERATION:
				return getContainingEnumeration();
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
			case ArcanePackage.ENUMERATION_LITERAL__CONTAINING_ENUMERATION:
				setContainingEnumeration((Enumeration)newValue);
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
			case ArcanePackage.ENUMERATION_LITERAL__CONTAINING_ENUMERATION:
				setContainingEnumeration((Enumeration)null);
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
			case ArcanePackage.ENUMERATION_LITERAL__CONTAINING_ENUMERATION:
				return getContainingEnumeration() != null;
		}
		return super.eIsSet(featureID);
	}

} //EnumerationLiteralImpl
