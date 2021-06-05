package com.arsene.workflow.tests;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.eclipse.xtext.xbase.testing.TemporaryFolder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(WorkflowInjectorProvider.class)
@SuppressWarnings("all")
public class WorkflowGeneratorTest {
  @Rule
  @Inject
  public TemporaryFolder temporaryFolder;
  
  @Inject
  @Extension
  private CompilationTestHelper _compilationTestHelper;
  
  @Inject
  @Extension
  private ReflectExtensions _reflectExtensions;
  
  @Test
  public void testEmptyProgddram() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
      };
      this._compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testVariable() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Define var arsene = \"Hello world\"");
      _builder.newLine();
      _builder.append("var hello = 2");
      _builder.newLine();
      _builder.append("Define var a = \"Thank you\"");
      _builder.newLine();
      _builder.append("var b = \"You are welcome\"");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("let arsene = \"Hello world\"");
      _builder_1.newLine();
      _builder_1.append("let hello = 2");
      _builder_1.newLine();
      _builder_1.append("let a = \"Thank you\"");
      _builder_1.newLine();
      _builder_1.append("let b = \"You are welcome\"");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void assignemnt() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("var a = 1");
      _builder.newLine();
      _builder.append("var b = 2");
      _builder.newLine();
      _builder.append("b = a");
      _builder.newLine();
      _builder.append("var c = b");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("let a = 1");
      _builder_1.newLine();
      _builder_1.append("let b = 2");
      _builder_1.newLine();
      _builder_1.append("b = a");
      _builder_1.newLine();
      _builder_1.append("let c = b");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDisplay() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("var a =5");
      _builder.newLine();
      _builder.append("print(a)");
      _builder.newLine();
      _builder.append("print(a + 2)");
      _builder.newLine();
      _builder.append("print( a <= 4)");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("let a = 5");
      _builder_1.newLine();
      _builder_1.append("window.printOutput(a)");
      _builder_1.newLine();
      _builder_1.append("window.printOutput(a + 2)");
      _builder_1.newLine();
      _builder_1.append("window.printOutput(a <= 4)");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIfStatement() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("if(4 == 4){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("print(\"Yes\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var b = 4");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var d = 5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var e = b + d");
      _builder.newLine();
      _builder.append("} else{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("print(\"No\")");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("if(4 === 4){");
      _builder_1.newLine();
      _builder_1.append("window.printOutput(\"Yes\")");
      _builder_1.newLine();
      _builder_1.append("let b = 4");
      _builder_1.newLine();
      _builder_1.append("let d = 5");
      _builder_1.newLine();
      _builder_1.append("let e = b + d");
      _builder_1.newLine();
      _builder_1.append("}else{");
      _builder_1.newLine();
      _builder_1.append("window.printOutput(\"No\")");
      _builder_1.newLine();
      _builder_1.append("}");
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLoopStatement() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("loop:if(i == 4){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("print(\"Yes\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("i = i + 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("let i = 0");
      _builder_1.newLine();
      _builder_1.append("while(i === 4){");
      _builder_1.newLine();
      _builder_1.append("window.printOutput(\"Yes\")");
      _builder_1.newLine();
      _builder_1.append("i = i + 1");
      _builder_1.newLine();
      _builder_1.append("}");
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMethodWithNoParameter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("function name(){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("print(\"Hello world\")");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("function name(){");
      _builder_1.newLine();
      _builder_1.append("window.printOutput(\"Hello world\")");
      _builder_1.newLine();
      _builder_1.append("}");
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMethodWithParameter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("function name(string : myName, number : c){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("print(\"Hello world\" + myName)");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if(4 == 4){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("print(\"Yes\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var b = 4");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var d = 5");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var e = b + d + c");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else{");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("print(\"No\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("function name(myName, c){");
      _builder_1.newLine();
      _builder_1.append("window.printOutput(\"Hello world\" + myName)");
      _builder_1.newLine();
      _builder_1.append("if(4 === 4){");
      _builder_1.newLine();
      _builder_1.append("window.printOutput(\"Yes\")");
      _builder_1.newLine();
      _builder_1.append("let b = 4");
      _builder_1.newLine();
      _builder_1.append("let d = 5");
      _builder_1.newLine();
      _builder_1.append("let e = b + d + c");
      _builder_1.newLine();
      _builder_1.append("}else{");
      _builder_1.newLine();
      _builder_1.append("window.printOutput(\"No\")");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void workflowTest() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Workflow myWorkflow type:parallel{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("step \"first step\"{");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var name = 5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("Execute myWorkflow()");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("function myWorkflow (\"parallel\") {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("function firststep {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("let name = 5");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("firststep()");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("myWorkflow()");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void workflowTestProgram() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("var arsene = \"\"");
      _builder.newLine();
      _builder.append("var etl = \"pre {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("parameterPassedFromJava.println();");
      _builder.newLine();
      _builder.append("}\t\t\t");
      _builder.newLine();
      _builder.append("rule Tree2Tree");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("transform s : Source!Tree");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("to t : Target!Tree {\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("t.label := \'CopyOf\' + s.label;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("t.children ::= s.children;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("\"");
      _builder.newLine();
      _builder.append("var hello = \"jdksjakdj\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("var name = \"Hello world\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("var a = \"\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function method(){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var a = 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return a");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("Workflow myWorkflow type:parallel{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("step \"first step\"{");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var name = 5");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var m = call method()");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("loop:if(i == 4){");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("print(\"Yes\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("i = i + 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("Execute myWorkflow()");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("let arsene = \"\"");
      _builder_1.newLine();
      _builder_1.append("let etl = \"pre {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("parameterPassedFromJava.println();");
      _builder_1.newLine();
      _builder_1.append("}\t\t\t");
      _builder_1.newLine();
      _builder_1.append("rule Tree2Tree");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("transform s : Source!Tree");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("to t : Target!Tree {\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("t.label := \'CopyOf\' + s.label;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("t.children ::= s.children;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\"");
      _builder_1.newLine();
      _builder_1.append("let hello = \"jdksjakdj\"");
      _builder_1.newLine();
      _builder_1.append("let name = \"Hello world\"");
      _builder_1.newLine();
      _builder_1.append("let a = \"\"");
      _builder_1.newLine();
      _builder_1.append("function method(){");
      _builder_1.newLine();
      _builder_1.append("let a = 2");
      _builder_1.newLine();
      _builder_1.append("return a}function myWorkflow (\"parallel\") {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("function firststep {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("let name = 5");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("let m = method()");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("let i = 0");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("while(i === 4){");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("window.printOutput(\"Yes\")");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("i = i + 1");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("firststep()");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("myWorkflow()");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
