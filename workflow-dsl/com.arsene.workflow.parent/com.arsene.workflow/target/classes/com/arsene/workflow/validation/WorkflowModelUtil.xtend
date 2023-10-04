package com.arsene.workflow.validation

import com.arsene.workflow.workflow.Expression
import com.arsene.workflow.workflow.Feature
import com.arsene.workflow.workflow.Variable
import com.arsene.workflow.workflow.VariableRef
import com.arsene.workflow.workflow.WorkflowProgramModel
import com.google.inject.Inject
import org.eclipse.xtext.util.IResourceScopeCache

import static extension org.eclipse.xtext.EcoreUtil2.*

class WorkflowModelUtil {
	@Inject IResourceScopeCache cache

	def isVariableDefinedBefore(VariableRef varRef) {
			
		varRef.variable.name !== null
		//varRef.variablesDefinedBefore.contains(varRef.variable)
	}

//	def variablesDefinedBefore(Expression e) {
//		e.getContainerOfType(Feature).variablesDefinedBefore
//	}
//
//	def variablesDefinedBefore(Feature containingElement) {	
//		cache.get(containingElement, containingElement.eResource) [
//			val allElements = (containingElement.eContainer as WorkflowProgramModel).features
//
//			allElements.subList(0,
//				allElements.indexOf(containingElement)
//			).typeSelect(Variable).toSet
//		]
//	}
}
