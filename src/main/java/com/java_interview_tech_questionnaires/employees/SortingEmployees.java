package com.java_interview_tech_questionnaires.employees;

import com.java_interview_tech_questionnaires.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author RavikantS on Sept 10, 2025
 */
public class SortingEmployees {
	public static void main(String[] args) {
		List<Employee> empList = List.of(
				new Employee(15L, "Prajjwal", 1600000D, "Engineering", 29),
				new Employee(12L, "Ravi", 1500000D, "Engineering", 28),
				new Employee(14L, "Smriti", 1800000D, "Engineering", 45),
				new Employee(13L, "Nira", 1200000D, "Engineering", 25),
				new Employee(11L, "Neha", 1200000D, "Engineering", 45)
		);
		
		List<Employee> sortedWithStreams = empList.stream().sorted(Comparator.comparing(Employee::id).thenComparing(Employee::age)).toList();
		System.out.println("Using streams");
		sortedWithStreams.forEach(System.out::println);
		
		ArrayList<Employee> sortWithListMethod = new ArrayList<>(empList);
		sortWithListMethod.sort(Comparator.comparing(Employee::id).thenComparing(Employee::age));
		System.out.println("Using sort method");
		sortWithListMethod.forEach(System.out::println);
		
		List<Employee> sortedWithTraditionally = new ArrayList<>(empList);
		for (int i = 0; i < sortedWithTraditionally.size(); ++i) {
			for (int j = 0; j < sortedWithTraditionally.size() - 1; ++j) {
				Employee iEmp = sortedWithTraditionally.get(j);
				Employee jEmp = sortedWithTraditionally.get(j + 1);
				if (iEmp.age() > jEmp.age() || (iEmp.id()==jEmp.id() && iEmp.age() > jEmp.age())) {
					sortedWithTraditionally.set(j, jEmp);
					sortedWithTraditionally.set(j + 1, iEmp);
				}
			}
		}
		System.out.println("Using for loop");
		sortedWithTraditionally.forEach(System.out::println);
		
	}
}
