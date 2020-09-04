/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.impl;

import arcane.Annotation;
import arcane.AnnotationLevels;
import arcane.ArcanePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arcane.impl.AnnotationImpl#getMsg <em>Msg</em>}</li>
 *   <li>{@link arcane.impl.AnnotationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link arcane.impl.AnnotationImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link arcane.impl.AnnotationImpl#getXpathExpr <em>Xpath Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationImpl extends EObjectImpl implements Annotation {
	/**
	 * The default value of the '{@link #getMsg() <em>Msg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMsg()
	 * @generated
	 * @ordered
	 */
	protected static final String MSG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMsg() <em>Msg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMsg()
	 * @generated
	 * @ordered
	 */
	protected String msg = MSG_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected String kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final AnnotationLevels LEVEL_EDEFAULT = AnnotationLevels.ERROR;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected AnnotationLevels level = LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getXpathExpr() <em>Xpath Expr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXpathExpr()
	 * @generated
	 * @ordered
	 */
	protected static final String XPATH_EXPR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXpathExpr() <em>Xpath Expr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXpathExpr()
	 * @generated
	 * @ordered
	 */
	protected String xpathExpr = XPATH_EXPR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArcanePackage.Literals.ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMsg(String newMsg) {
		String oldMsg = msg;
		msg = newMsg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.ANNOTATION__MSG, oldMsg, msg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(String newKind) {
		String oldKind = kind;
		kind = newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.ANNOTATION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationLevels getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(AnnotationLevels newLevel) {
		AnnotationLevels oldLevel = level;
		level = newLevel == null ? LEVEL_EDEFAULT : newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.ANNOTATION__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXpathExpr() {
		return xpathExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXpathExpr(String newXpathExpr) {
		String oldXpathExpr = xpathExpr;
		xpathExpr = newXpathExpr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArcanePackage.ANNOTATION__XPATH_EXPR, oldXpathExpr, xpathExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArcanePackage.ANNOTATION__MSG:
				return getMsg();
			case ArcanePackage.ANNOTATION__KIND:
				return getKind();
			case ArcanePackage.ANNOTATION__LEVEL:
				return getLevel();
			case ArcanePackage.ANNOTATION__XPATH_EXPR:
				return getXpathExpr();
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
			case ArcanePackage.ANNOTATION__MSG:
				setMsg((String)newValue);
				return;
			case ArcanePackage.ANNOTATION__KIND:
				setKind((String)newValue);
				return;
			case ArcanePackage.ANNOTATION__LEVEL:
				setLevel((AnnotationLevels)newValue);
				return;
			case ArcanePackage.ANNOTATION__XPATH_EXPR:
				setXpathExpr((String)newValue);
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
			case ArcanePackage.ANNOTATION__MSG:
				setMsg(MSG_EDEFAULT);
				return;
			case ArcanePackage.ANNOTATION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ArcanePackage.ANNOTATION__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case ArcanePackage.ANNOTATION__XPATH_EXPR:
				setXpathExpr(XPATH_EXPR_EDEFAULT);
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
			case ArcanePackage.ANNOTATION__MSG:
				return MSG_EDEFAULT == null ? msg != null : !MSG_EDEFAULT.equals(msg);
			case ArcanePackage.ANNOTATION__KIND:
				return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
			case ArcanePackage.ANNOTATION__LEVEL:
				return level != LEVEL_EDEFAULT;
			case ArcanePackage.ANNOTATION__XPATH_EXPR:
				return XPATH_EXPR_EDEFAULT == null ? xpathExpr != null : !XPATH_EXPR_EDEFAULT.equals(xpathExpr);
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
		result.append(" (msg: ");
		result.append(msg);
		result.append(", kind: ");
		result.append(kind);
		result.append(", level: ");
		result.append(level);
		result.append(", xpathExpr: ");
		result.append(xpathExpr);
		result.append(')');
		return result.toString();
	}

} //AnnotationImpl
