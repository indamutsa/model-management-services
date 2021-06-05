package com.arsene.workflow.typing;

import com.arsene.workflow.validation.WorkflowModelUtil;
import com.arsene.workflow.workflow.And;
import com.arsene.workflow.workflow.BoolConstant;
import com.arsene.workflow.workflow.Comparison;
import com.arsene.workflow.workflow.Equality;
import com.arsene.workflow.workflow.Expression;
import com.arsene.workflow.workflow.IntConstant;
import com.arsene.workflow.workflow.MethodInvocation;
import com.arsene.workflow.workflow.Minus;
import com.arsene.workflow.workflow.MulOrDiv;
import com.arsene.workflow.workflow.Not;
import com.arsene.workflow.workflow.Or;
import com.arsene.workflow.workflow.Plus;
import com.arsene.workflow.workflow.StringConstant;
import com.arsene.workflow.workflow.Variable;
import com.arsene.workflow.workflow.VariableRef;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Arrays;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class WorkflowTypeComputer {
  public static final StringType STRING_TYPE = new StringType();
  
  public static final IntType INT_TYPE = new IntType();
  
  public static final BoolType BOOL_TYPE = new BoolType();
  
  public static final ParameterType PARAM_TYPE = new ParameterType();
  
  @Inject
  @Extension
  private WorkflowModelUtil _workflowModelUtil;
  
  @Inject
  private IResourceScopeCache cache;
  
  public boolean isStringType(final ExpressionsType type) {
    return Objects.equal(type, WorkflowTypeComputer.STRING_TYPE);
  }
  
  public boolean isIntType(final ExpressionsType type) {
    return (type == WorkflowTypeComputer.INT_TYPE);
  }
  
  public boolean isBoolType(final ExpressionsType type) {
    return (type == WorkflowTypeComputer.BOOL_TYPE);
  }
  
  public boolean isParamType(final ExpressionsType type) {
    return (type == WorkflowTypeComputer.PARAM_TYPE);
  }
  
  protected ExpressionsType _typeFor(final Expression e) {
    ExpressionsType _switchResult = null;
    boolean _matched = false;
    if (e instanceof StringConstant) {
      _matched=true;
      _switchResult = WorkflowTypeComputer.STRING_TYPE;
    }
    if (!_matched) {
      if (e instanceof IntConstant) {
        _matched=true;
        _switchResult = WorkflowTypeComputer.INT_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof BoolConstant) {
        _matched=true;
        _switchResult = WorkflowTypeComputer.BOOL_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof Not) {
        _matched=true;
        _switchResult = WorkflowTypeComputer.BOOL_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof MulOrDiv) {
        _matched=true;
        _switchResult = WorkflowTypeComputer.INT_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof Minus) {
        _matched=true;
        _switchResult = WorkflowTypeComputer.INT_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof Comparison) {
        _matched=true;
        _switchResult = WorkflowTypeComputer.BOOL_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof Equality) {
        _matched=true;
        _switchResult = WorkflowTypeComputer.BOOL_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof And) {
        _matched=true;
        _switchResult = WorkflowTypeComputer.BOOL_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof Or) {
        _matched=true;
        _switchResult = WorkflowTypeComputer.BOOL_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof MethodInvocation) {
        _matched=true;
        _switchResult = WorkflowTypeComputer.STRING_TYPE;
      }
    }
    return _switchResult;
  }
  
  protected ExpressionsType _typeFor(final Plus e) {
    ExpressionsType _xblockexpression = null;
    {
      final ExpressionsType leftType = this.typeFor(e.getLeft());
      Expression _right = e.getRight();
      ExpressionsType _typeFor = null;
      if (_right!=null) {
        _typeFor=this.typeFor(_right);
      }
      final ExpressionsType rightType = _typeFor;
      ExpressionsType _xifexpression = null;
      if ((this.isStringType(leftType) || this.isStringType(rightType))) {
        _xifexpression = WorkflowTypeComputer.STRING_TYPE;
      } else {
        _xifexpression = WorkflowTypeComputer.INT_TYPE;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected ExpressionsType _typeFor(final VariableRef varRef) {
    boolean _equals = varRef.getVariable().getTypeName().equals("string");
    if (_equals) {
      return WorkflowTypeComputer.STRING_TYPE;
    } else {
      boolean _equals_1 = varRef.getVariable().getTypeName().equals("number");
      if (_equals_1) {
        return WorkflowTypeComputer.INT_TYPE;
      } else {
        boolean _equals_2 = varRef.getVariable().getTypeName().equals("boolean");
        if (_equals_2) {
          return WorkflowTypeComputer.BOOL_TYPE;
        }
      }
    }
    boolean _isVariableDefinedBefore = this._workflowModelUtil.isVariableDefinedBefore(varRef);
    boolean _not = (!_isVariableDefinedBefore);
    if (_not) {
      return null;
    } else {
      final Variable variable = varRef.getVariable();
      Pair<String, Variable> _mappedTo = Pair.<String, Variable>of("type", variable);
      final Provider<ExpressionsType> _function = () -> {
        return this.typeFor(variable.getExpression());
      };
      return this.cache.<ExpressionsType>get(_mappedTo, variable.eResource(), _function);
    }
  }
  
  public ExpressionsType typeFor(final Expression e) {
    if (e instanceof Plus) {
      return _typeFor((Plus)e);
    } else if (e instanceof VariableRef) {
      return _typeFor((VariableRef)e);
    } else if (e != null) {
      return _typeFor(e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
}
