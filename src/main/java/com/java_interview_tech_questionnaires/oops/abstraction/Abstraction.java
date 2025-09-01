package com.java_interview_tech_questionnaires.oops.abstraction;

/**
 * @author RavikantS on Sept 01, 2025
 */
public class Abstraction {
//	DEFINITION: Abstraction means showing only the important things and hiding the details.
//              Think of driving a car: you only see the steering, pedals, and buttons, but you don’t worry about how the engine works.
//	DEFINITION: Abstraction is an object-oriented programming concept that hides the implementation details of a class and shows only the essential features to the user.
//	            It focuses on what an object does, not how it does it.

//	NOTE: Achieved with the help of interfaces.
	public interface AbstractionInterface {
		void execute();
	}
	
	public static class AbstractionInterfaceImpl implements AbstractionInterface {
		
		@Override
		public void execute() {
			System.out.println("Implementation of the method declared in Interface!!!");
		}
	}
	
	public static void main(String[] args) {
//		NOTE: Creating object of implementation and storing it into interface reference.
		AbstractionInterface abs = new AbstractionInterfaceImpl();
		abs.execute();
	}
}
