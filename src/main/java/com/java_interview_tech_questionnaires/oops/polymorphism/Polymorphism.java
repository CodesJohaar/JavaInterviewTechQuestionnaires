package com.java_interview_tech_questionnaires.oops.polymorphism;

/**
 * @author RavikantS on Sept 01, 2025
 */
public class Polymorphism {
//	DEFINITION: One name, many forms.
//	DEFINITION: Polymorphism means one thing, many forms.
//              The same method name can do different things depending on the object.
//              Think of a person: they can walk, run, or dance depending on the situation, but the action “move” is the same.

//	NOTE: There are 2 types of polymorphism i.e. 1) Compile time and 2) Runtime

//	NOTE: 1) Compile time (Overloading : Same method name but different method signature)
//	         Can only be achieved within the class.
	private void add(Integer a, Integer b) {
		System.out.println("Overloading sum of 2 numbers : " + (a + b));
	}
//	NOTE: Overloading the above defined method.
	private void add(Integer a, Integer b, Integer c) {
		System.out.println("Overloading sum of 3 numbers : " + (a + b + c));
	}
	
//	NOTE: 2) Runtime (Overriding : Redefining the method instructions)
//	         Can only be achieved with the help of inheritance between the classes.
	public static class Parent {
		public void print() {
			System.out.println("Runtime Polymorphism from Parent class!!!");
		}
	}
	
	public static class Child extends Parent {
//		NOTE: Overriding the implementation of print() defined in Parent class.
		public void print() {
			System.out.println("Runtime polymorphism from Child class!!!");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Overloading Examples : ");
		Polymorphism polymorphism = new Polymorphism();
		polymorphism.add(2, 3);
		polymorphism.add(2, 5, 1);
		System.out.println("\nOverriding Examples : ");
		Parent parent = new Child();
//		NOTE: It will decide which print method will get called during runtime.
		parent.print();
//		NOTE: Bonus Example
//	    Polymorphism can also be achieved in class level using inheritance.
		parent = new ChildTwo();
//		NOTE: Now the same parent reference is having multiple forms at Runtime.
		parent.print();
//		NOTE: Below code is also valid, representing Runtime Polymorphism at class level.
		parent = new Parent();
		parent.print();
	}
//	NOTE: Another class extending Parent to understand Bonus Example mentioned in Main method.
	public static class ChildTwo extends Parent {
		public void print() {
			System.out.println("Runtime Polymorphism at class level!!!");
		}
	}
	
}
