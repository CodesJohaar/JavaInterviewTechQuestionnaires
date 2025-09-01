package com.java_interview_tech_questionnaires;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author RavikantS on Aug 04, 2025
 */
public class EmpCountBySalary {
	public static void main(String[] args) {
		List<Employee> employees = List.of(
				new Employee(11L, "Ravi", 5013240.9, "Accounting"),
				new Employee(12L, "Sagar", 5013250.9, "Engineering"),
				new Employee(13L, "Rohit", 501540.9, "Engineering"),
				new Employee(14L, "Neelam", 13240.9, "Accounting"),
				new Employee(15L, "Rajgir", 5040.9, "Education")
		);
		
		Map<String, List<Employee>> collect1 = employees.stream()
				.filter(emp -> emp.salary() > 50_000).sorted(Comparator.comparing(Employee::salary))
				.collect(Collectors.groupingBy(Employee::department));
		collect1.forEach((k, v) -> v.forEach(System.out::println));
		
		List<Employee> list1 = employees.stream().sorted(Comparator.comparing(Employee::name)
						.thenComparing(Comparator.comparingDouble(Employee::salary).reversed()))
				.toList();
		
		
		Map<Double, Long> collect = employees.stream().sorted(Comparator.comparingDouble(Employee::salary))
				.collect(Collectors.groupingBy(Employee::salary, Collectors.counting()));
		System.out.println(collect);
		
		List<Employee> list = employees.stream()
				.sorted(Comparator.comparingDouble(Employee::salary).reversed())
				.limit(2).toList();
		list.forEach(emp -> System.out.println(emp.toString()));
		
		EmployeeBuildCheck build = EmployeeBuildCheck.builder().id(12L).name("Ravi").salary(1000000.0).department("Engineering").build();
		System.out.println(build.toString());
		
		// select d.dept_name, count(e.emp_id) as emp_count from department d left join employees e on d.id = e.dept_id group by dept_name;
	}
}
