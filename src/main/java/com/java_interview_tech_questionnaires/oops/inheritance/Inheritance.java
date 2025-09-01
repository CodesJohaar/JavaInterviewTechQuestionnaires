package com.java_interview_tech_questionnaires.oops.inheritance;

/**
 * @author RavikantS on Sept 01, 2025
 */
public class Inheritance {
//	DEFINITION: Inheritance is the process by which one class derives the attributes and methods of another, thereby supporting hierarchical classification and code reuse.
//	DEFINITION: Inheritance means one class can use the things (variables and methods) of another class without writing them again. 
//	            The class we borrow from is called the parent (superclass).
//              The class that borrows is called the child (subclass).
//              It’s like a child inheriting traits from their parents in real life.
	public static void main(String[] args) {
//      NOTE: Represents superclass.
		Parent p = new Parent();
//      NOTE: Represents subclass.
		Child c = new Child();
//		NOTE: Here, we are creating an object of Child class and storing it into Parent reference and is valid.
//		NOTE: Child object can be stored in Parent reference and is valid.
		Parent cp = new Child();
//		BUG: Parent object can't be stored in child reference.
//		NOTE: It violates the inheritance rules.
//		ERR: Child p1 = new Parent();
		
//		NOTE: Here, we are accessing the superclass member from parent reference and is valid.
		p.parentMethod();

//		NOTE: Here, we are accessing the functionalities of both Parent and Child classes using subclass reference,
//	          which is valid.
		c.parentMethod();
		c.childMethod();
		
//		BUG: Since the object is of parent class, reference doesn't have visibility to child functionalities.
//		ERR: p.childMethod();

//		BUG: Since we have created Child object but stored in Parent reference,
//		     the reference (Parent) doesn't have the visibility to Child functionalities.
//		ERR: cp.childMethod();
		cp.parentMethod();
	
	}
}
