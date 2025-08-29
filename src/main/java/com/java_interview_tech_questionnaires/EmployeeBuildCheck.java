package com.java_interview_tech_questionnaires;

/**
 * @author RavikantS on Aug 06, 2025
 */
public record EmployeeBuildCheck(Long id, String name, Double salary, String department) {
	public static EmployeeBuildCheckBuilder builder() {
		return new EmployeeBuildCheckBuilder();
	}
 
	public static class EmployeeBuildCheckBuilder {
		private Long id;
		private String name;
		private Double salary = 50000.0;
		private String department;
		
		public EmployeeBuildCheckBuilder id(Long id) {
			this.id = id;
			return this;
		}
		
		public EmployeeBuildCheckBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public EmployeeBuildCheckBuilder salary(Double salary) {
			this.salary = salary;
			return this;
		}
		
		public EmployeeBuildCheckBuilder department(String department) {
			this.department = department;
			return this;
		}
		
		public EmployeeBuildCheck build() {
			return new EmployeeBuildCheck(this.id, this.name, this.salary, this.department);
		}
		
	}
}
