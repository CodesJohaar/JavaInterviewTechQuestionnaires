package com.java_interview_tech_questionnaires;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author RavikantS on Aug 22, 2025
 */
public class StudentAvgMarks {
	public static class StudentMarks {
		private Integer id;
		private Integer marks;
		public StudentMarks() {
			this.id = null;
			this.marks = null;
		}
		public StudentMarks(Integer id, Integer marks) {
			this.id = id;
			this.marks = marks;
		}
		
		public static StudentMarksBuilder builder() {
			return new StudentMarksBuilder();
		}
		
		public Integer getId() {
			return id;
		}
		
		public void setId(Integer id) {
			this.id = id;
		}
		
		public Integer getMarks() {
			return marks;
		}
		
		public void setMarks(Integer marks) {
			this.marks = marks;
		}
		
		public static class StudentMarksBuilder {
			private Integer id;
			private Integer marks;
			public StudentMarksBuilder id(Integer id) {
				this.id = id;
				return this;
			}
			public StudentMarksBuilder marks(Integer marks) {
				this.marks = marks;
				return this;
			}
			public StudentMarks build() {
				return new StudentMarks(this.id, this.marks);
			}
		}
	}
	
	public static void main(String[] args) {
		List<StudentMarks> studentMarks = getStudentMarksBuilder();
		Map<Integer, Double> collect = studentMarks.stream().collect(
				Collectors.groupingBy(StudentMarks::getId, Collectors.averagingDouble(StudentMarks::getMarks)));
		System.out.println(collect);
		System.out.println(List.of(2, 4, 5, 14, 5, 2));
		List<Integer[]> stuMarks = List.of(
				new Integer[] {102, 85},
				new Integer[] {101, 65},
				new Integer[] {102, 75},
				new Integer[] {101, 95});
		Map<Integer, Double> collect1 = stuMarks.stream()
				.sorted(Comparator.comparing(arr -> arr[0]))
				.collect(Collectors.groupingBy(arr -> arr[0],
						Collectors.averagingDouble(arr -> arr[1])));
		System.out.println(collect1);
	}
	
	private static List<StudentMarks> getStudentMarksBuilder() {
		return List.of(
				StudentMarks.builder().id(101).marks(90).build(),
				StudentMarks.builder().id(101).marks(89).build(),
				StudentMarks.builder().id(102).marks(79).build(),
				StudentMarks.builder().id(102).marks(59).build(),
				StudentMarks.builder().id(101).marks(66).build(),
				StudentMarks.builder().id(102).marks(74).build(),
				StudentMarks.builder().id(101).marks(45).build(),
				StudentMarks.builder().id(102).marks(52).build(),
				StudentMarks.builder().id(101).marks(51).build(),
				StudentMarks.builder().id(102).marks(83).build());
	}

//	@NotNull
//	private static List<StudentMarks> getStudentMarks() {
//		StudentAvgMarks parentObj = new StudentAvgMarks();
//		return List.of(
//				parentObj.new StudentMarks(101, 90),
//				parentObj.new StudentMarks(101, 89),
//				parentObj.new StudentMarks(102, 79),
//				parentObj.new StudentMarks(102, 59),
//				parentObj.new StudentMarks(101, 66),
//				parentObj.new StudentMarks(102, 74),
//				parentObj.new StudentMarks(101, 45),
//				parentObj.new StudentMarks(102, 52),
//				parentObj.new StudentMarks(101, 51),
//				parentObj.new StudentMarks(102, 83));
//	}
}
