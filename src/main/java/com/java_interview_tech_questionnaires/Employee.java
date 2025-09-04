package com.java_interview_tech_questionnaires;

import java.util.Objects;

/**
 * @author RavikantS on Aug 05, 2025
 */
public record Employee(Long id, String name, Double salary, String department) {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
//		else if (obj instanceof Employee(Long comparingId, String comparingName, Double comparingSalary, String comparingDepartment))
		else if (obj instanceof Employee e)
			return Objects.equals(this.id, e.id) && Objects.equals(this.name, e.name)
					&& Objects.equals(this.salary, e.salary) && Objects.equals(this.department, e.department);
		else return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, salary, department);
	}
}
