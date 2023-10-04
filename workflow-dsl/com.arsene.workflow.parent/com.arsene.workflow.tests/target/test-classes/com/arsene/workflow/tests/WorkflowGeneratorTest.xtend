package com.arsene.workflow.tests

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.xbase.testing.TemporaryFolder
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import com.google.inject.Inject

@RunWith(XtextRunner)
@InjectWith(WorkflowInjectorProvider)
class WorkflowGeneratorTest {
	@Rule
	@Inject public TemporaryFolder temporaryFolder
	@Inject extension CompilationTestHelper
	@Inject extension ReflectExtensions

	@Test
	def void testEmptyProgddram() {
		'''
		'''.compile[]
	}

	@Test
	def void testVariable() {
		'''
			Define var arsene = "Hello world"
			var hello = 2
			Define var a = "Thank you"
			var b = "You are welcome"
		'''.assertCompilesTo(
		'''
			let arsene = "Hello world"
			let hello = 2
			let a = "Thank you"
			let b = "You are welcome"
		''')
	}

	@Test
	def void assignemnt() {
		'''
			var a = 1
			var b = 2
			b = a
			var c = b
		'''.assertCompilesTo(
			'''
				let a = 1
				let b = 2
				b = a
				let c = b
			'''
		)
	}

	@Test
	def void testDisplay() {
		'''
			var a =5
			print(a)
			print(a + 2)
			print( a <= 4)
		'''.assertCompilesTo(
			'''
				let a = 5
				window.printOutput(a)
				window.printOutput(a + 2)
				window.printOutput(a <= 4)
			'''
		)
	}

	@Test
	def void testIfStatement() {
		'''
			if(4 == 4){
				print("Yes")
				var b = 4
				var d = 5
				var e = b + d
			} else{
				print("No")
			}
		'''.assertCompilesTo(
			'''
			if(4 === 4){
			window.printOutput("Yes")
			let b = 4
			let d = 5
			let e = b + d
			}else{
			window.printOutput("No")
			}'''
		)
	}

	@Test
	def void testLoopStatement() {
		'''
			var i = 0
			loop:if(i == 4){
				print("Yes")
				i = i + 1
			}
		'''.assertCompilesTo(
			'''
			let i = 0
			while(i === 4){
			window.printOutput("Yes")
			i = i + 1
			}'''
		)
	}

	@Test
	def void testMethodWithNoParameter() {
		'''
			function name(){
				print("Hello world")
			}
		'''.assertCompilesTo(
			'''
			function name(){
			window.printOutput("Hello world")
			}'''
		)
	}

	@Test
	def void testMethodWithParameter() {
		'''
			function name(string : myName, number : c){
				print("Hello world" + myName)
				
				if(4 == 4){
					print("Yes")
					var b = 4
					var d = 5
					var e = b + d + c
				} else{
					print("No")
				}
			}
		'''.assertCompilesTo(
			'''
			function name(myName, c){
			window.printOutput("Hello world" + myName)
			if(4 === 4){
			window.printOutput("Yes")
			let b = 4
			let d = 5
			let e = b + d + c
			}else{
			window.printOutput("No")
			}
			}'''
		)
	}

	@Test
	def void workflowTest() {
		'''
			Workflow myWorkflow type:parallel{
				step "first step"{
					var name = 5
				}
			}
			Execute myWorkflow()
		'''.assertCompilesTo(
			'''
				function myWorkflow ("parallel") {
					function firststep {
					let name = 5
					}
					firststep()
				}
				myWorkflow()
			'''
		)
	}

	@Test
	def void workflowTestProgram() {
		'''
			var arsene = ""
			var etl = "pre {
				parameterPassedFromJava.println();
			}			
			rule Tree2Tree
				transform s : Source!Tree
				to t : Target!Tree {	
				t.label := 'CopyOf' + s.label;
				t.children ::= s.children;
			}
			"
			var hello = "jdksjakdj"
			
			var name = "Hello world"
			
			var a = ""
			
			function method(){
				var a = 2
				return a
			}
			
			Workflow myWorkflow type:parallel{
				step "first step"{
					var name = 5
					var m = call method()
					var i = 0
					loop:if(i == 4){
						print("Yes")
						i = i + 1
					}
				}
			}
			Execute myWorkflow()
		'''.assertCompilesTo(
		'''
			let arsene = ""
			let etl = "pre {
				parameterPassedFromJava.println();
			}			
			rule Tree2Tree
				transform s : Source!Tree
				to t : Target!Tree {	
				t.label := 'CopyOf' + s.label;
				t.children ::= s.children;
			}
			"
			let hello = "jdksjakdj"
			let name = "Hello world"
			let a = ""
			function method(){
			let a = 2
			return a}function myWorkflow ("parallel") {
				function firststep {
				let name = 5
				let m = method()
				let i = 0
				while(i === 4){
				window.printOutput("Yes")
				i = i + 1
				}
				}
				firststep()
			}
			myWorkflow()
		'''
		)
	}
}
