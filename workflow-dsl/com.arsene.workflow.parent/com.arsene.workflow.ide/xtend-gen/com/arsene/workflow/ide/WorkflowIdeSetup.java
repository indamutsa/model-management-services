/**
 * generated by Xtext 2.25.0
 */
package com.arsene.workflow.ide;

import com.arsene.workflow.WorkflowRuntimeModule;
import com.arsene.workflow.WorkflowStandaloneSetup;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class WorkflowIdeSetup extends WorkflowStandaloneSetup {
  @Override
  public Injector createInjector() {
    WorkflowRuntimeModule _workflowRuntimeModule = new WorkflowRuntimeModule();
    WorkflowIdeModule _workflowIdeModule = new WorkflowIdeModule();
    return Guice.createInjector(Modules2.mixin(_workflowRuntimeModule, _workflowIdeModule));
  }
}
