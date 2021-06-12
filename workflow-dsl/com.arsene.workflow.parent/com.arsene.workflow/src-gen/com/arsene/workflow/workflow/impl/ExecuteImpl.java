/**
 * generated by Xtext 2.25.0
 */
package com.arsene.workflow.workflow.impl;

import com.arsene.workflow.workflow.Execute;
import com.arsene.workflow.workflow.Workflow;
import com.arsene.workflow.workflow.WorkflowPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.arsene.workflow.workflow.impl.ExecuteImpl#getWorkflow <em>Workflow</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExecuteImpl extends MinimalEObjectImpl.Container implements Execute
{
  /**
   * The cached value of the '{@link #getWorkflow() <em>Workflow</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorkflow()
   * @generated
   * @ordered
   */
  protected Workflow workflow;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExecuteImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return WorkflowPackage.Literals.EXECUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Workflow getWorkflow()
  {
    if (workflow != null && workflow.eIsProxy())
    {
      InternalEObject oldWorkflow = (InternalEObject)workflow;
      workflow = (Workflow)eResolveProxy(oldWorkflow);
      if (workflow != oldWorkflow)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.EXECUTE__WORKFLOW, oldWorkflow, workflow));
      }
    }
    return workflow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Workflow basicGetWorkflow()
  {
    return workflow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setWorkflow(Workflow newWorkflow)
  {
    Workflow oldWorkflow = workflow;
    workflow = newWorkflow;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.EXECUTE__WORKFLOW, oldWorkflow, workflow));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case WorkflowPackage.EXECUTE__WORKFLOW:
        if (resolve) return getWorkflow();
        return basicGetWorkflow();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case WorkflowPackage.EXECUTE__WORKFLOW:
        setWorkflow((Workflow)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case WorkflowPackage.EXECUTE__WORKFLOW:
        setWorkflow((Workflow)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case WorkflowPackage.EXECUTE__WORKFLOW:
        return workflow != null;
    }
    return super.eIsSet(featureID);
  }

} //ExecuteImpl