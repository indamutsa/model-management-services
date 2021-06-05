package com.arsene.workflow.validation;

import com.arsene.workflow.workflow.VariableRef;
import com.google.inject.Inject;
import org.eclipse.xtext.util.IResourceScopeCache;

@SuppressWarnings("all")
public class WorkflowModelUtil {
  @Inject
  private IResourceScopeCache cache;
  
  public boolean isVariableDefinedBefore(final VariableRef varRef) {
    String _name = varRef.getVariable().getName();
    return (_name != null);
  }
}
