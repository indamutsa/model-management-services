/**
 * generated by Xtext 2.25.0
 */
package com.arsene.workflow.workflow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.arsene.workflow.workflow.PrimitiveType#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link com.arsene.workflow.workflow.PrimitiveType#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see com.arsene.workflow.workflow.WorkflowPackage#getPrimitiveType()
 * @model
 * @generated
 */
public interface PrimitiveType extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Name</em>' attribute.
   * @see #setTypeName(String)
   * @see com.arsene.workflow.workflow.WorkflowPackage#getPrimitiveType_TypeName()
   * @model
   * @generated
   */
  String getTypeName();

  /**
   * Sets the value of the '{@link com.arsene.workflow.workflow.PrimitiveType#getTypeName <em>Type Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' attribute.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.arsene.workflow.workflow.WorkflowPackage#getPrimitiveType_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.arsene.workflow.workflow.PrimitiveType#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // PrimitiveType
