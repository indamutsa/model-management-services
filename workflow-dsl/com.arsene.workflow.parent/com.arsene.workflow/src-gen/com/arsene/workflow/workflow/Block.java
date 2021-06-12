/**
 * generated by Xtext 2.25.0
 */
package com.arsene.workflow.workflow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.arsene.workflow.workflow.Block#getStatements <em>Statements</em>}</li>
 *   <li>{@link com.arsene.workflow.workflow.Block#getReturnStatement <em>Return Statement</em>}</li>
 * </ul>
 *
 * @see com.arsene.workflow.workflow.WorkflowPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends EObject
{
  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link com.arsene.workflow.workflow.Statement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see com.arsene.workflow.workflow.WorkflowPackage#getBlock_Statements()
   * @model containment="true"
   * @generated
   */
  EList<Statement> getStatements();

  /**
   * Returns the value of the '<em><b>Return Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return Statement</em>' containment reference.
   * @see #setReturnStatement(Return)
   * @see com.arsene.workflow.workflow.WorkflowPackage#getBlock_ReturnStatement()
   * @model containment="true"
   * @generated
   */
  Return getReturnStatement();

  /**
   * Sets the value of the '{@link com.arsene.workflow.workflow.Block#getReturnStatement <em>Return Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return Statement</em>' containment reference.
   * @see #getReturnStatement()
   * @generated
   */
  void setReturnStatement(Return value);

} // Block