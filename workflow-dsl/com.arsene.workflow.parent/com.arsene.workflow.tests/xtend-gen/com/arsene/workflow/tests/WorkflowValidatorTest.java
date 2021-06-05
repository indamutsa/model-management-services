package com.arsene.workflow.tests;

import com.arsene.workflow.typing.ExpressionsType;
import com.arsene.workflow.typing.WorkflowTypeComputer;
import com.arsene.workflow.validation.WorkflowValidator;
import com.arsene.workflow.workflow.WorkflowPackage;
import com.arsene.workflow.workflow.WorkflowProgramModel;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(WorkflowInjectorProvider.class)
@SuppressWarnings("all")
public class WorkflowValidatorTest {
  @Inject
  @Extension
  private ParseHelper<WorkflowProgramModel> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testForwardReferenceInExpression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("var i = 1 ");
      _builder.newLine();
      _builder.append("print(j + 1) ");
      _builder.newLine();
      _builder.append("var j = 10");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoForwardReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("var j = 10 var i = 10 var c = i + j");
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoForwardReferencePrime() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("var j = 10 var i = j");
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWrongNotType() {
    this.assertType("!10", WorkflowTypeComputer.INT_TYPE, WorkflowTypeComputer.BOOL_TYPE);
  }
  
  @Test
  public void testWrongMulOrDivType() {
    this.assertType("10 * true", WorkflowTypeComputer.BOOL_TYPE, WorkflowTypeComputer.INT_TYPE);
    this.assertType("\'10\' / 10", WorkflowTypeComputer.STRING_TYPE, WorkflowTypeComputer.INT_TYPE);
  }
  
  @Test
  public void testWrongMinusType() {
    this.assertType("10 - true", WorkflowTypeComputer.BOOL_TYPE, WorkflowTypeComputer.INT_TYPE);
    this.assertType("\'10\' - 10", WorkflowTypeComputer.STRING_TYPE, WorkflowTypeComputer.INT_TYPE);
  }
  
  @Test
  public void testWrongAndType() {
    this.assertType("10 and true", WorkflowTypeComputer.INT_TYPE, WorkflowTypeComputer.BOOL_TYPE);
    this.assertType("false and \'10\'", WorkflowTypeComputer.STRING_TYPE, WorkflowTypeComputer.BOOL_TYPE);
  }
  
  @Test
  public void testWrongOrType() {
    this.assertType("10 or true", WorkflowTypeComputer.INT_TYPE, WorkflowTypeComputer.BOOL_TYPE);
    this.assertType("false or \'10\'", WorkflowTypeComputer.STRING_TYPE, WorkflowTypeComputer.BOOL_TYPE);
  }
  
  @Test
  public void testWrongEqualityType() {
    this.assertSameType("10 == true", WorkflowTypeComputer.INT_TYPE, WorkflowTypeComputer.BOOL_TYPE);
    this.assertSameType("false != \'10\'", WorkflowTypeComputer.BOOL_TYPE, WorkflowTypeComputer.STRING_TYPE);
  }
  
  @Test
  public void testWrongComparisonType() {
    this.assertSameType("10 < \'1\'", WorkflowTypeComputer.INT_TYPE, WorkflowTypeComputer.STRING_TYPE);
    this.assertSameType("\'10\' > 10", WorkflowTypeComputer.STRING_TYPE, WorkflowTypeComputer.INT_TYPE);
  }
  
  @Test
  public void testWrongBooleanComparison() {
    this.assertNotBooleanType("10 < true");
    this.assertNotBooleanType("false > 0");
    this.assertNotBooleanType("false > true");
  }
  
  @Test
  public void testWrongBooleanPlus() {
    this.assertNotBooleanType("10 + true");
    this.assertNotBooleanType("false + 0");
    this.assertNotBooleanType("false + true");
  }
  
  public void assertType(final CharSequence input, final ExpressionsType expectedWrongType, final ExpressionsType expectedActualType) {
    try {
      this._validationTestHelper.assertError(this._parseHelper.parse((("print(" + input) + ")")), WorkflowPackage.eINSTANCE.getExpression(), 
        WorkflowValidator.TYPE_MISMATCH, 
        ((("expected " + expectedActualType) + " type, but was ") + expectedWrongType));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertSameType(final CharSequence input, final ExpressionsType expectedLeft, final ExpressionsType expectedRight) {
    try {
      this._validationTestHelper.assertError(this._parseHelper.parse((("print(" + input) + ")")), WorkflowPackage.eINSTANCE.getExpression(), 
        WorkflowValidator.TYPE_MISMATCH, 
        ((("expected the same type, but was " + expectedLeft) + ", ") + expectedRight));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertNotBooleanType(final CharSequence input) {
    try {
      this._validationTestHelper.assertError(this._parseHelper.parse((("print(" + input) + ")")), WorkflowPackage.eINSTANCE.getExpression(), 
        WorkflowValidator.TYPE_MISMATCH, 
        "cannot be boolean");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
