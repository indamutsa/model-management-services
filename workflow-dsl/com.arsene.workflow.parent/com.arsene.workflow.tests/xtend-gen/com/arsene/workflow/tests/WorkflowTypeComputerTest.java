package com.arsene.workflow.tests;

import com.arsene.workflow.typing.ExpressionsType;
import com.arsene.workflow.typing.WorkflowTypeComputer;
import com.arsene.workflow.workflow.Expression;
import com.arsene.workflow.workflow.Feature;
import com.arsene.workflow.workflow.WorkflowProgramModel;
import com.google.inject.Inject;
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
public class WorkflowTypeComputerTest {
  @Inject
  @Extension
  private ParseHelper<WorkflowProgramModel> _parseHelper;
  
  @Inject
  @Extension
  private WorkflowTypeComputer _workflowTypeComputer;
  
  @Test
  public void intConstant() {
    this.assertEvalType("10", WorkflowTypeComputer.INT_TYPE);
  }
  
  @Test
  public void stringConstant() {
    this.assertEvalType("\'foo\'", WorkflowTypeComputer.STRING_TYPE);
  }
  
  @Test
  public void boolConstant() {
    this.assertEvalType("true", WorkflowTypeComputer.BOOL_TYPE);
  }
  
  @Test
  public void notExp() {
    this.assertEvalType("!true", WorkflowTypeComputer.BOOL_TYPE);
  }
  
  @Test
  public void multiExp() {
    this.assertEvalType("1 * 2", WorkflowTypeComputer.INT_TYPE);
  }
  
  @Test
  public void divExp() {
    this.assertEvalType("1 / 2", WorkflowTypeComputer.INT_TYPE);
  }
  
  @Test
  public void minusExp() {
    this.assertEvalType("1 - 2", WorkflowTypeComputer.INT_TYPE);
  }
  
  @Test
  public void comparisonExp() {
    this.assertEvalType("1 < 2", WorkflowTypeComputer.BOOL_TYPE);
  }
  
  @Test
  public void equalityExp() {
    this.assertEvalType("1 == 2", WorkflowTypeComputer.BOOL_TYPE);
  }
  
  @Test
  public void andExp() {
    this.assertEvalType("true and false", WorkflowTypeComputer.BOOL_TYPE);
  }
  
  @Test
  public void orExp() {
    this.assertEvalType("true or false", WorkflowTypeComputer.BOOL_TYPE);
  }
  
  @Test
  public void numericPlus() {
    this.assertEvalType("1 + 2", WorkflowTypeComputer.INT_TYPE);
  }
  
  @Test
  public void stringPlus() {
    this.assertEvalType("\'a\' + \'b\'", WorkflowTypeComputer.STRING_TYPE);
  }
  
  @Test
  public void numAndStringPlus() {
    this.assertEvalType("\'a\' + 2", WorkflowTypeComputer.STRING_TYPE);
  }
  
  @Test
  public void numAndStringPlus2() {
    this.assertEvalType("2 + \'a\'", WorkflowTypeComputer.STRING_TYPE);
  }
  
  @Test
  public void boolAndStringPlus() {
    this.assertEvalType("\'a\' + true", WorkflowTypeComputer.STRING_TYPE);
  }
  
  @Test
  public void boolAndStringPlus2() {
    this.assertEvalType("false + \'a\'", WorkflowTypeComputer.STRING_TYPE);
  }
  
  @Test
  public void incompletePlusRight() {
    this.assertEvalType("1 + ", WorkflowTypeComputer.INT_TYPE);
  }
  
  @Test
  public void varWithExpression() {
    this.assertType1("var i = 0", WorkflowTypeComputer.INT_TYPE);
  }
  
  @Test
  public void varRef() {
    this.assertType("var i = 0 print(i)", WorkflowTypeComputer.INT_TYPE);
  }
  
  @Test
  public void testIsInt() {
    Assert.assertTrue(this._workflowTypeComputer.isIntType(WorkflowTypeComputer.INT_TYPE));
  }
  
  @Test
  public void testIsString() {
    Assert.assertTrue(this._workflowTypeComputer.isStringType(WorkflowTypeComputer.STRING_TYPE));
  }
  
  @Test
  public void testIsBool() {
    Assert.assertTrue(this._workflowTypeComputer.isBoolType(WorkflowTypeComputer.BOOL_TYPE));
  }
  
  @Test
  public void testNotIsInt() {
    Assert.assertFalse(this._workflowTypeComputer.isIntType(WorkflowTypeComputer.STRING_TYPE));
  }
  
  @Test
  public void testNotIsString() {
    Assert.assertFalse(this._workflowTypeComputer.isStringType(WorkflowTypeComputer.INT_TYPE));
  }
  
  @Test
  public void testNotIsBool() {
    Assert.assertFalse(this._workflowTypeComputer.isBoolType(WorkflowTypeComputer.INT_TYPE));
  }
  
  public void assertEvalType(final CharSequence input, final ExpressionsType expectedType) {
    this.assertType((("print(" + input) + ")"), expectedType);
  }
  
  public void assertType(final CharSequence input, final ExpressionsType expectedType) {
    try {
      this.assertType(IterableExtensions.<Feature>last(this._parseHelper.parse(input).getFeatures()).getStatement().getPrint().getExpression(), expectedType);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertType1(final CharSequence input, final ExpressionsType expectedType) {
    try {
      this.assertType(IterableExtensions.<Feature>last(this._parseHelper.parse(input).getFeatures()).getStatement().getVariabl().getExpression(), expectedType);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertType(final Expression e, final ExpressionsType expectedType) {
    Assert.assertSame(expectedType, this._workflowTypeComputer.typeFor(e));
  }
}
