package com.arsene.workflow.tests

import com.arsene.workflow.typing.ExpressionsType
import com.arsene.workflow.typing.WorkflowTypeComputer
import com.arsene.workflow.workflow.Expression
import com.arsene.workflow.workflow.WorkflowProgramModel
import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static com.arsene.workflow.typing.WorkflowTypeComputer.*

import static extension org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(WorkflowInjectorProvider)
class WorkflowTypeComputerTest {
	@Inject extension ParseHelper<WorkflowProgramModel>
	@Inject extension WorkflowTypeComputer

	@Test def void intConstant() { "10".assertEvalType(INT_TYPE) }

	@Test def void stringConstant() { "'foo'".assertEvalType(STRING_TYPE) }

	@Test def void boolConstant() { "true".assertEvalType(BOOL_TYPE) }

	@Test def void notExp() { "!true".assertEvalType(BOOL_TYPE) }

	@Test def void multiExp() { "1 * 2".assertEvalType(INT_TYPE) }

	@Test def void divExp() { "1 / 2".assertEvalType(INT_TYPE) }

	@Test def void minusExp() { "1 - 2".assertEvalType(INT_TYPE) }

	@Test def void comparisonExp() { "1 < 2".assertEvalType(BOOL_TYPE) }

	@Test def void equalityExp() { "1 == 2".assertEvalType(BOOL_TYPE) }

	@Test def void andExp() { "true and false".assertEvalType(BOOL_TYPE) }

	@Test def void orExp() { "true or false".assertEvalType(BOOL_TYPE) }

	@Test def void numericPlus() { "1 + 2".assertEvalType(INT_TYPE) }

	@Test def void stringPlus() { "'a' + 'b'".assertEvalType(STRING_TYPE) }

	@Test def void numAndStringPlus() { "'a' + 2".assertEvalType(STRING_TYPE) }

	@Test def void numAndStringPlus2() { "2 + 'a'".assertEvalType(STRING_TYPE) }

	@Test def void boolAndStringPlus() { "'a' + true".assertEvalType(STRING_TYPE) }

	@Test def void boolAndStringPlus2() { "false + 'a'".assertEvalType(STRING_TYPE) }

	@Test def void incompletePlusRight() { "1 + ".assertEvalType(INT_TYPE) }

	@Test def void varWithExpression() { "var i = 0".assertType1(INT_TYPE) }

	@Test def void varRef() { "var i = 0 print(i)".assertType(INT_TYPE) }

//	@Test def void varRefToVarDefinedAfter() { "var i = j var j = i".assertType(null) }

	@Test def void testIsInt() {
		(WorkflowTypeComputer.INT_TYPE).isIntType.assertTrue
	}

	@Test def void testIsString() {
		(WorkflowTypeComputer.STRING_TYPE).isStringType.assertTrue
	}

	@Test def void testIsBool() {
		(WorkflowTypeComputer.BOOL_TYPE).isBoolType.assertTrue
	}

	@Test def void testNotIsInt() {
		(WorkflowTypeComputer.STRING_TYPE).isIntType.assertFalse
	}

	@Test def void testNotIsString() {
		(WorkflowTypeComputer.INT_TYPE).isStringType.assertFalse
	}

	@Test def void testNotIsBool() {
		(WorkflowTypeComputer.INT_TYPE).isBoolType.assertFalse
	}

	def assertEvalType(CharSequence input, ExpressionsType expectedType) {
		("print(" + input + ")").assertType(expectedType)
	}

	def assertType(CharSequence input, ExpressionsType expectedType) {
		input.parse.features.last.statement.print.expression.assertType(expectedType)
	}

	def assertType1(CharSequence input, ExpressionsType expectedType) {
		input.parse.features.last.statement.variabl.expression.assertType(expectedType)
	}

	def assertType(Expression e, ExpressionsType expectedType) {
		expectedType.assertSame(e.typeFor)
	}

}
