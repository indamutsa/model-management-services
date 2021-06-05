package com.arsene.workflow.tests

import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import com.arsene.workflow.workflow.WorkflowProgramModel
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import com.arsene.workflow.validation.WorkflowModelUtil
import com.arsene.workflow.workflow.VariableRef
import org.junit.Test

import static extension org.junit.Assert.*
import com.arsene.workflow.workflow.Variable

@RunWith(XtextRunner)
@InjectWith(WorkflowInjectorProvider)
class WorkflowModelUtilTest {
	@Inject extension ParseHelper<WorkflowProgramModel>
	@Inject extension WorkflowModelUtil

//	@Test def void variablesBeforeVariable() {
//		'''
//			print(true)    // (0)
//			var i = 0    // (1)
//			print(i + 10)    // (2)
//			var j = i    // (3)
//			print(i + j)    // (4)
//		'''.parse => [
//			assertVariablesDefinedBefore(0, "")
//			assertVariablesDefinedBefore(1, "")
//			assertVariablesDefinedBefore(2, "i")
//			assertVariablesDefinedBefore(3, "i")
//			assertVariablesDefinedBefore(4, "i,j")
//		]
//	}

	@Test def testIsVariableDefinedBeforeTrue() {
		'''
			var i = 0
			print(i)
		'''.assertVariableDefinedBefore(true)
	}

	@Test def testIsVariableDefinedBeforeFalse() {
		'''
			var i = i
		'''.assertVariableDefinedBefore(false)
	}

	@Test def testIsVariableDefinedBeforeWhenVariableUndefined() {
		'''
			print(i)
		'''.assertVariableDefinedBefore(false)
	}

//	def private void assertVariablesDefinedBefore(WorkflowProgramModel model, int elemIndex,
//		CharSequence expectedVars) {
//
//		expectedVars.assertEquals(
//			model.features.get(elemIndex).variablesDefinedBefore.map[name].join(",")
//		)
//	}

	def private void assertVariableDefinedBefore(CharSequence input, boolean expected) {
		val variable = input.parse.features.last.statement.variabl
		expected.assertEquals(
			if (variable instanceof Variable && variable.expression instanceof VariableRef)
				( variable.expression as VariableRef).variable.name !==
					(variable as Variable).name
			else {
				if (input.parse.features.last.statement.print.expression instanceof VariableRef)
					(input.parse.features.last.statement.print.expression as VariableRef).isVariableDefinedBefore
				else
					false
			}
		)
	}
//
//	@Test
//	def void testVarExists() {
//		'''
//			var i = i
//		'''.parse => [
//			val exp = features.last.statement
//			if (exp instanceof Variable)
//				print("Yes *****" + (exp as Variable).name)
//			else
//				print("No " + (exp as VariableRef))
//		]
//	}
}
