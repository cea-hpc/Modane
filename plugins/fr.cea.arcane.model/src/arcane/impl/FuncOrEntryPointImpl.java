/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane.impl;

import arcane.ArcanePackage;
import arcane.Func;
import arcane.FuncOrEntryPoint;
import arcane.Variable;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Func Or Entry Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link arcane.impl.FuncOrEntryPointImpl#getInVariables <em>In Variables</em>}</li>
 *   <li>{@link arcane.impl.FuncOrEntryPointImpl#getOutVariables <em>Out Variables</em>}</li>
 *   <li>{@link arcane.impl.FuncOrEntryPointImpl#getCalledFuncs <em>Called Funcs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FuncOrEntryPointImpl extends NamedElementImpl implements FuncOrEntryPoint {
	/**
	 * The cached value of the '{@link #getInVariables() <em>In Variables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> inVariables;

	/**
	 * The cached value of the '{@link #getOutVariables() <em>Out Variables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> outVariables;

	/**
	 * The cached value of the '{@link #getCalledFuncs() <em>Called Funcs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalledFuncs()
	 * @generated
	 * @ordered
	 */
	protected EList<Func> calledFuncs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuncOrEntryPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArcanePackage.Literals.FUNC_OR_ENTRY_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getInVariables() {
		if (inVariables == null) {
			inVariables = new EObjectResolvingEList<Variable>(Variable.class, this, ArcanePackage.FUNC_OR_ENTRY_POINT__IN_VARIABLES);
		}
		return inVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getOutVariables() {
		if (outVariables == null) {
			outVariables = new EObjectResolvingEList<Variable>(Variable.class, this, ArcanePackage.FUNC_OR_ENTRY_POINT__OUT_VARIABLES);
		}
		return outVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Func> getCalledFuncs() {
		if (calledFuncs == null) {
			calledFuncs = new EObjectResolvingEList<Func>(Func.class, this, ArcanePackage.FUNC_OR_ENTRY_POINT__CALLED_FUNCS);
		}
		return calledFuncs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArcanePackage.FUNC_OR_ENTRY_POINT__IN_VARIABLES:
				return getInVariables();
			case ArcanePackage.FUNC_OR_ENTRY_POINT__OUT_VARIABLES:
				return getOutVariables();
			case ArcanePackage.FUNC_OR_ENTRY_POINT__CALLED_FUNCS:
				return getCalledFuncs();
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
			case ArcanePackage.FUNC_OR_ENTRY_POINT__IN_VARIABLES:
				getInVariables().clear();
				getInVariables().addAll((Collection<? extends Variable>)newValue);
				return;
			case ArcanePackage.FUNC_OR_ENTRY_POINT__OUT_VARIABLES:
				getOutVariables().clear();
				getOutVariables().addAll((Collection<? extends Variable>)newValue);
				return;
			case ArcanePackage.FUNC_OR_ENTRY_POINT__CALLED_FUNCS:
				getCalledFuncs().clear();
				getCalledFuncs().addAll((Collection<? extends Func>)newValue);
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
			case ArcanePackage.FUNC_OR_ENTRY_POINT__IN_VARIABLES:
				getInVariables().clear();
				return;
			case ArcanePackage.FUNC_OR_ENTRY_POINT__OUT_VARIABLES:
				getOutVariables().clear();
				return;
			case ArcanePackage.FUNC_OR_ENTRY_POINT__CALLED_FUNCS:
				getCalledFuncs().clear();
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
			case ArcanePackage.FUNC_OR_ENTRY_POINT__IN_VARIABLES:
				return inVariables != null && !inVariables.isEmpty();
			case ArcanePackage.FUNC_OR_ENTRY_POINT__OUT_VARIABLES:
				return outVariables != null && !outVariables.isEmpty();
			case ArcanePackage.FUNC_OR_ENTRY_POINT__CALLED_FUNCS:
				return calledFuncs != null && !calledFuncs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FuncOrEntryPointImpl
