package com.java_interview_tech_questionnaires;

/**
 * @author RavikantS on Aug 06, 2025
 */
public class OuterInnerClassCheck {
	private String str = "Outer class variable";
	
	public class InnerClass {
		private void print() {
			System.out.println(str);
		}
	}
	
}
