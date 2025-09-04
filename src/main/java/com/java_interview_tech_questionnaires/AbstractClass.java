package com.java_interview_tech_questionnaires;

/**
 * @author RavikantS on Sept 04, 2025
 */
public abstract class AbstractClass {
	
	protected static void print(String message) {
		print(message, "");
	}
	
	protected static <R> void print(String message, R input) {
		System.out.println(message + " : " + input);
	}
	
	protected static void printErr(String errMessage) {
		System.err.println(errMessage);
	}
}
