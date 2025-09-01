package com.java_interview_tech_questionnaires.oops.encapsulation;

/**
 * @author RavikantS on Sept 01, 2025
 */
public class Encapsulation {
//	DEFINITION: Encapsulation means hiding the details and allowing controlled access.
//              Think of it like a medicine capsule: the contents are hidden inside, and you only interact with the capsule, not the raw medicine.
//	DEFINITION: Binding and wrapping up the variables and methods inside a container.
	
	// NOTE: Instance variable of the class.
	private Integer id;
	// NOTE: Class / Static variable of the class.
	private String name;
	
	// NOTE: Instance method of the class.
	public void print() {
		System.out.println("Encapsulation class method invoked!!!");
	}
	
	// NOTE: Class / Static method of the class.
	public static void printClass() {
		System.out.println("Encapsulation class method invoked!!!");
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public static void main(String[] args) {
		System.out.println(new Encapsulation());
	}
}
