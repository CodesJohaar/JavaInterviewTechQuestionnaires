package com.java_interview_tech_questionnaires;

/**
 * @author RavikantS on Sept 04, 2025
 */
public abstract class AbstractClass {
	
	protected static <M> void print(M message) {
		print(message, "");
	}
	
	protected static <M, R> void print(M message, R input) {
		System.out.println(message + " : " + input);
	}
	
	protected static <M, S> void printErr(M errMessage) {
		printErr(errMessage, "");
	}
	
	protected static <M, S> void printErr(M errMessage, S stackTrace) {
		System.err.println(errMessage + " : " + stackTrace);
	}
}
