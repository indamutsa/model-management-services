package com.arsene.workflow.typing

import com.arsene.workflow.validation.WorkflowModelUtil
import com.arsene.workflow.workflow.And
import com.arsene.workflow.workflow.BoolConstant
import com.arsene.workflow.workflow.Comparison
import com.arsene.workflow.workflow.Equality
import com.arsene.workflow.workflow.Expression
import com.arsene.workflow.workflow.IntConstant
import com.arsene.workflow.workflow.Minus
import com.arsene.workflow.workflow.MulOrDiv
import com.arsene.workflow.workflow.Not
import com.arsene.workflow.workflow.Or
import com.arsene.workflow.workflow.Plus
import com.arsene.workflow.workflow.StringConstant
import com.arsene.workflow.workflow.VariableRef
import com.google.inject.Inject
import org.eclipse.xtext.util.IResourceScopeCache
import com.arsene.workflow.workflow.Parameter
import com.arsene.workflow.workflow.MethodInvocation

class WorkflowTypeComputer {
	public static val STRING_TYPE = new StringType
	public static val INT_TYPE = new IntType
	public static val BOOL_TYPE = new BoolType
	public static val PARAM_TYPE = new ParameterType

	@Inject extension WorkflowModelUtil
	@Inject IResourceScopeCache cache

	def isStringType(ExpressionsType type) {
		type == STRING_TYPE
	}

	def isIntType(ExpressionsType type) {
		type === INT_TYPE
	}

	def isBoolType(ExpressionsType type) {
		type === BOOL_TYPE
	}

	def isParamType(ExpressionsType type) {
		type === PARAM_TYPE
	}

	def dispatch ExpressionsType typeFor(Expression e) {
		switch (e) {
			StringConstant: STRING_TYPE
			IntConstant: INT_TYPE
			BoolConstant: BOOL_TYPE
			Not: BOOL_TYPE
			MulOrDiv: INT_TYPE
			Minus: INT_TYPE
			Comparison: BOOL_TYPE
			Equality: BOOL_TYPE
			And: BOOL_TYPE
			Or: BOOL_TYPE
			MethodInvocation: STRING_TYPE
		}
	}

	def dispatch ExpressionsType typeFor(Plus e) {

		val leftType = e.left.typeFor
		val rightType = e.right?.typeFor
		if (leftType.isStringType || rightType.isStringType)
			STRING_TYPE
		else
			INT_TYPE
	}

	def dispatch ExpressionsType typeFor(VariableRef varRef) {
		if (varRef.variable.typeName.equals("string"))
			return STRING_TYPE
		else if (varRef.variable.typeName.equals("number"))
			return INT_TYPE
		else if (varRef.variable.typeName.equals("boolean"))
			return BOOL_TYPE

		if (!varRef.isVariableDefinedBefore)
			return null

		else {
			val variable = varRef.variable
			// use a pair as the key, not to conflict with the
			// use of cache we make in ExpressionsModelUtil
			return cache.get("type" -> variable, variable.eResource) [
				variable.expression.typeFor
			]
		}
	}
//
//	def dispatch ExpressionsType typeFor(Parameter param) {
//		if(param.eContainer instanceof MethodInvocation)
//			return PARAM_TYPE
//		else
//			return null
//			
//	}
}
