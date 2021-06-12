/**
 * generated by Xtext 2.25.0
 */
package com.arsene.workflow.workflow.impl;

import com.arsene.workflow.workflow.Expression;
import com.arsene.workflow.workflow.Variable;
import com.arsene.workflow.workflow.WorkflowPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.arsene.workflow.workflow.impl.VariableImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link com.arsene.workflow.workflow.impl.VariableImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.arsene.workflow.workflow.impl.VariableImpl#isArray <em>Array</em>}</li>
 *   <li>{@link com.arsene.workflow.workflow.impl.VariableImpl#getLength <em>Length</em>}</li>
 *   <li>{@link com.arsene.workflow.workflow.impl.VariableImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link com.arsene.workflow.workflow.impl.VariableImpl#getMethodInvocation <em>Method Invocation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableImpl extends MinimalEObjectImpl.Container implements Variable
{
  /**
   * The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeName()
   * @generated
   * @ordered
   */
  protected static final String TYPE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeName()
   * @generated
   * @ordered
   */
  protected String typeName = TYPE_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #isArray() <em>Array</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isArray()
   * @generated
   * @ordered
   */
  protected static final boolean ARRAY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isArray() <em>Array</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isArray()
   * @generated
   * @ordered
   */
  protected boolean array = ARRAY_EDEFAULT;

  /**
   * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLength()
   * @generated
   * @ordered
   */
  protected static final int LENGTH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLength()
   * @generated
   * @ordered
   */
  protected int length = LENGTH_EDEFAULT;

  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Expression expression;

  /**
   * The cached value of the '{@link #getMethodInvocation() <em>Method Invocation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodInvocation()
   * @generated
   * @ordered
   */
  protected Expression methodInvocation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableImpl()
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
    return WorkflowPackage.Literals.VARIABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getTypeName()
  {
    return typeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTypeName(String newTypeName)
  {
    String oldTypeName = typeName;
    typeName = newTypeName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.VARIABLE__TYPE_NAME, oldTypeName, typeName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.VARIABLE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isArray()
  {
    return array;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setArray(boolean newArray)
  {
    boolean oldArray = array;
    array = newArray;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.VARIABLE__ARRAY, oldArray, array));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getLength()
  {
    return length;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLength(int newLength)
  {
    int oldLength = length;
    length = newLength;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.VARIABLE__LENGTH, oldLength, length));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.VARIABLE__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExpression(Expression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.VARIABLE__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.VARIABLE__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.VARIABLE__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getMethodInvocation()
  {
    return methodInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMethodInvocation(Expression newMethodInvocation, NotificationChain msgs)
  {
    Expression oldMethodInvocation = methodInvocation;
    methodInvocation = newMethodInvocation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.VARIABLE__METHOD_INVOCATION, oldMethodInvocation, newMethodInvocation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setMethodInvocation(Expression newMethodInvocation)
  {
    if (newMethodInvocation != methodInvocation)
    {
      NotificationChain msgs = null;
      if (methodInvocation != null)
        msgs = ((InternalEObject)methodInvocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.VARIABLE__METHOD_INVOCATION, null, msgs);
      if (newMethodInvocation != null)
        msgs = ((InternalEObject)newMethodInvocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.VARIABLE__METHOD_INVOCATION, null, msgs);
      msgs = basicSetMethodInvocation(newMethodInvocation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.VARIABLE__METHOD_INVOCATION, newMethodInvocation, newMethodInvocation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case WorkflowPackage.VARIABLE__EXPRESSION:
        return basicSetExpression(null, msgs);
      case WorkflowPackage.VARIABLE__METHOD_INVOCATION:
        return basicSetMethodInvocation(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case WorkflowPackage.VARIABLE__TYPE_NAME:
        return getTypeName();
      case WorkflowPackage.VARIABLE__NAME:
        return getName();
      case WorkflowPackage.VARIABLE__ARRAY:
        return isArray();
      case WorkflowPackage.VARIABLE__LENGTH:
        return getLength();
      case WorkflowPackage.VARIABLE__EXPRESSION:
        return getExpression();
      case WorkflowPackage.VARIABLE__METHOD_INVOCATION:
        return getMethodInvocation();
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
      case WorkflowPackage.VARIABLE__TYPE_NAME:
        setTypeName((String)newValue);
        return;
      case WorkflowPackage.VARIABLE__NAME:
        setName((String)newValue);
        return;
      case WorkflowPackage.VARIABLE__ARRAY:
        setArray((Boolean)newValue);
        return;
      case WorkflowPackage.VARIABLE__LENGTH:
        setLength((Integer)newValue);
        return;
      case WorkflowPackage.VARIABLE__EXPRESSION:
        setExpression((Expression)newValue);
        return;
      case WorkflowPackage.VARIABLE__METHOD_INVOCATION:
        setMethodInvocation((Expression)newValue);
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
      case WorkflowPackage.VARIABLE__TYPE_NAME:
        setTypeName(TYPE_NAME_EDEFAULT);
        return;
      case WorkflowPackage.VARIABLE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case WorkflowPackage.VARIABLE__ARRAY:
        setArray(ARRAY_EDEFAULT);
        return;
      case WorkflowPackage.VARIABLE__LENGTH:
        setLength(LENGTH_EDEFAULT);
        return;
      case WorkflowPackage.VARIABLE__EXPRESSION:
        setExpression((Expression)null);
        return;
      case WorkflowPackage.VARIABLE__METHOD_INVOCATION:
        setMethodInvocation((Expression)null);
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
      case WorkflowPackage.VARIABLE__TYPE_NAME:
        return TYPE_NAME_EDEFAULT == null ? typeName != null : !TYPE_NAME_EDEFAULT.equals(typeName);
      case WorkflowPackage.VARIABLE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case WorkflowPackage.VARIABLE__ARRAY:
        return array != ARRAY_EDEFAULT;
      case WorkflowPackage.VARIABLE__LENGTH:
        return length != LENGTH_EDEFAULT;
      case WorkflowPackage.VARIABLE__EXPRESSION:
        return expression != null;
      case WorkflowPackage.VARIABLE__METHOD_INVOCATION:
        return methodInvocation != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (typeName: ");
    result.append(typeName);
    result.append(", name: ");
    result.append(name);
    result.append(", array: ");
    result.append(array);
    result.append(", length: ");
    result.append(length);
    result.append(')');
    return result.toString();
  }

} //VariableImpl