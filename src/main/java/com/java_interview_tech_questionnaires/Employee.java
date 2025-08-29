package com.java_interview_tech_questionnaires;

import java.util.Objects;

/**
 * @author RavikantS on Aug 05, 2025
 */
public record Employee(Long id, String name, Double salary, String department) {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		else if (obj instanceof Employee(Long comparingId, String comparingName, Double comparingSalary, String comparingDepartment))
			return Objects.equals(this.id, comparingId) && Objects.equals(this.name, comparingName)
					&& Objects.equals(this.salary, comparingSalary) && Objects.equals(this.department, comparingDepartment);
		else return false;
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, salary, department);
	}
}
