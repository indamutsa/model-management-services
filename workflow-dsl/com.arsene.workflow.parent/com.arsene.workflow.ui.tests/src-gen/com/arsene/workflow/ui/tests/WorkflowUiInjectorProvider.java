/*
 * generated by Xtext 2.25.0
 */
package com.arsene.workflow.ui.tests;

import com.arsene.workflow.ui.internal.WorkflowActivator;
import com.google.inject.Injector;
import org.eclipse.xtext.testing.IInjectorProvider;

public class WorkflowUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return WorkflowActivator.getInstance().getInjector("com.arsene.workflow.Workflow");
	}

}
