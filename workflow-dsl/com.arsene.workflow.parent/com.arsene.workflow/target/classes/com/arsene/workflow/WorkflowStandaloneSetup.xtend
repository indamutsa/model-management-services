/*
 * generated by Xtext 2.25.0
 */
package com.arsene.workflow


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class WorkflowStandaloneSetup extends WorkflowStandaloneSetupGenerated {

	def static void doSetup() {
		new WorkflowStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
