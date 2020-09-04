/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package arcane;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arcane.Annotation#getMsg <em>Msg</em>}</li>
 *   <li>{@link arcane.Annotation#getKind <em>Kind</em>}</li>
 *   <li>{@link arcane.Annotation#getLevel <em>Level</em>}</li>
 *   <li>{@link arcane.Annotation#getXpathExpr <em>Xpath Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see arcane.ArcanePackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends EObject {
	/**
	 * Returns the value of the '<em><b>Msg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Msg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Msg</em>' attribute.
	 * @see #setMsg(String)
	 * @see arcane.ArcanePackage#getAnnotation_Msg()
	 * @model required="true"
	 * @generated
	 */
	String getMsg();

	/**
	 * Sets the value of the '{@link arcane.Annotation#getMsg <em>Msg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Msg</em>' attribute.
	 * @see #getMsg()
	 * @generated
	 */
	void setMsg(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(String)
	 * @see arcane.ArcanePackage#getAnnotation_Kind()
	 * @model required="true"
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link arcane.Annotation#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * The literals are from the enumeration {@link arcane.AnnotationLevels}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see arcane.AnnotationLevels
	 * @see #setLevel(AnnotationLevels)
	 * @see arcane.ArcanePackage#getAnnotation_Level()
	 * @model required="true"
	 * @generated
	 */
	AnnotationLevels getLevel();

	/**
	 * Sets the value of the '{@link arcane.Annotation#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see arcane.AnnotationLevels
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(AnnotationLevels value);

	/**
	 * Returns the value of the '<em><b>Xpath Expr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xpath Expr</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xpath Expr</em>' attribute.
	 * @see #setXpathExpr(String)
	 * @see arcane.ArcanePackage#getAnnotation_XpathExpr()
	 * @model
	 * @generated
	 */
	String getXpathExpr();

	/**
	 * Sets the value of the '{@link arcane.Annotation#getXpathExpr <em>Xpath Expr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xpath Expr</em>' attribute.
	 * @see #getXpathExpr()
	 * @generated
	 */
	void setXpathExpr(String value);

} // Annotation
