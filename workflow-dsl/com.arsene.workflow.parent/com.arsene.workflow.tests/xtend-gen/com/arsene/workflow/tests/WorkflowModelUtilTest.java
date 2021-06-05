package com.arsene.workflow.tests;

import com.arsene.workflow.validation.WorkflowModelUtil;
import com.arsene.workflow.workflow.Expression;
import com.arsene.workflow.workflow.Feature;
import com.arsene.workflow.workflow.Variable;
import com.arsene.workflow.workflow.VariableRef;
import com.arsene.workflow.workflow.WorkflowProgramModel;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(WorkflowInjectorProvider.class)
@SuppressWarnings("all")
public class WorkflowModelUtilTest {
  @Inject
  @Extension
  private ParseHelper<WorkflowProgramModel> _parseHelper;
  
  @Inject
  @Extension
  private WorkflowModelUtil _workflowModelUtil;
  
  @Test
  public void testIsVariableDefinedBeforeTrue() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("print(i)");
    _builder.newLine();
    this.assertVariableDefinedBefore(_builder, true);
  }
  
  @Test
  public void testIsVariableDefinedBeforeFalse() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = i");
    _builder.newLine();
    this.assertVariableDefinedBefore(_builder, false);
  }
  
  @Test
  public void testIsVariableDefinedBeforeWhenVariableUndefined() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("print(i)");
    _builder.newLine();
    this.assertVariableDefinedBefore(_builder, false);
  }
  
  private void assertVariableDefinedBefore(final CharSequence input, final boolean expected) {
    try {
      final Variable variable = IterableExtensions.<Feature>last(this._parseHelper.parse(input).getFeatures()).getStatement().getVariabl();
      boolean _xifexpression = false;
      if (((variable instanceof Variable) && (variable.getExpression() instanceof VariableRef))) {
        Expression _expression = variable.getExpression();
        String _name = ((VariableRef) _expression).getVariable().getName();
        String _name_1 = ((Variable) variable).getName();
        _xifexpression = (_name != _name_1);
      } else {
        boolean _xifexpression_1 = false;
        Expression _expression_1 = IterableExtensions.<Feature>last(this._parseHelper.parse(input).getFeatures()).getStatement().getPrint().getExpression();
        if ((_expression_1 instanceof VariableRef)) {
          Expression _expression_2 = IterableExtensions.<Feature>last(this._parseHelper.parse(input).getFeatures()).getStatement().getPrint().getExpression();
          _xifexpression_1 = this._workflowModelUtil.isVariableDefinedBefore(((VariableRef) _expression_2));
        } else {
          _xifexpression_1 = false;
        }
        _xifexpression = _xifexpression_1;
      }
      Assert.assertEquals(Boolean.valueOf(expected), Boolean.valueOf(_xifexpression));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
