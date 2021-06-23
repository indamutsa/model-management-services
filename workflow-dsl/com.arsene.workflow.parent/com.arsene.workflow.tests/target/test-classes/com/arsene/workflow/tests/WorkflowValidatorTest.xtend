package com.arsene.workflow.tests

import com.arsene.workflow.workflow.WorkflowProgramModel
import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith


import com.arsene.workflow.typing.ExpressionsType
import com.arsene.workflow.workflow.WorkflowPackage
import com.arsene.workflow.validation.WorkflowValidator

import static extension org.junit.Assert.*
import static com.arsene.workflow.typing.WorkflowTypeComputer.*

@RunWith(XtextRunner)
@InjectWith(WorkflowInjectorProvider)
class WorkflowValidatorTest {

	@Inject extension ParseHelper<WorkflowProgramModel>
	@Inject extension ValidationTestHelper

	@Test
	def void testForwardReferenceInExpression() {
		'''
			var i = 1 
			print(j + 1) 
			var j = 10
		'''.parse.assertNoErrors
		
//		 => [
//			assertError(
//				WorkflowPackage.eINSTANCE.variable,
//				WorkflowValidator.FORWARD_REFERENCE,
//				"variable forward reference not allowed: 'j'"
//			)
//			
//			// since j cannot be referred, its type is null in j+1
////			assertError(
////				WorkflowPackage.eINSTANCE.expression,
////				WorkflowValidator.TYPE_MISMATCH,
////				"null type"
////			)
//			// check that they are the only errors
////			2.assertEquals(validate.size)
//		]
	}

	

	@Test
	def void testNoForwardReference() {
		'''var j = 10 var i = 10 var c = i + j'''.parse.assertNoErrors
	}
	
		@Test
	def void testNoForwardReferencePrime() {
		'''var j = 10 var i = j'''.parse.assertNoErrors
	}

	@Test
	def void testWrongNotType() {
		"!10".assertType(INT_TYPE, BOOL_TYPE)
	}
	
	@Test
	def void testWrongMulOrDivType() {
		"10 * true".assertType(BOOL_TYPE, INT_TYPE)
		"'10' / 10".assertType(STRING_TYPE, INT_TYPE)
	}

	@Test
	def void testWrongMinusType() {
		"10 - true".assertType(BOOL_TYPE, INT_TYPE)
		"'10' - 10".assertType(STRING_TYPE, INT_TYPE)
	}

	@Test
	def void testWrongAndType() {
		"10 and true".assertType(INT_TYPE, BOOL_TYPE)
		"false and '10'".assertType(STRING_TYPE, BOOL_TYPE)
	}

	@Test
	def void testWrongOrType() {
		"10 or true".assertType(INT_TYPE, BOOL_TYPE)
		"false or '10'".assertType(STRING_TYPE, BOOL_TYPE)
	}

	@Test
	def void testWrongEqualityType() {
		"10 == true".assertSameType(INT_TYPE, BOOL_TYPE)
		"false != '10'".assertSameType(BOOL_TYPE, STRING_TYPE)
	}

	@Test
	def void testWrongComparisonType() {
		"10 < '1'".assertSameType(INT_TYPE, STRING_TYPE)
		"'10' > 10".assertSameType(STRING_TYPE, INT_TYPE)
	}

	@Test
	def void testWrongBooleanComparison() {
		"10 < true".assertNotBooleanType
		"false > 0".assertNotBooleanType
		"false > true".assertNotBooleanType
	}

	@Test
	def void testWrongBooleanPlus() {
		"10 + true".assertNotBooleanType
		"false + 0".assertNotBooleanType
		"false + true".assertNotBooleanType
	}
	
	def void assertType(CharSequence input, 
			ExpressionsType expectedWrongType,
			ExpressionsType expectedActualType) {
		("print(" + input + ")").parse.
			assertError(WorkflowPackage.eINSTANCE.expression,
				WorkflowValidator.TYPE_MISMATCH,
				"expected " + expectedActualType
					+ " type, but was " + expectedWrongType)
	}

	def void assertSameType(CharSequence input, 
			ExpressionsType expectedLeft,
			ExpressionsType expectedRight) {
		("print(" + input + ")").parse.
			assertError(WorkflowPackage.eINSTANCE.expression,
				WorkflowValidator.TYPE_MISMATCH,
				"expected the same type, but was " + expectedLeft + ", " +
				expectedRight)
	}

	def void assertNotBooleanType(CharSequence input) {
		("print(" + input + ")").parse.
			assertError(WorkflowPackage.eINSTANCE.expression,
				WorkflowValidator.TYPE_MISMATCH,
				"cannot be boolean")
	}
}
