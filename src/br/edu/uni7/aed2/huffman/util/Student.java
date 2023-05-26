package br.edu.uni7.aed2.huffman.util;

public class Student {
	private String enrollment;
	private String name;
	
	public Student() {}

	public Student(String enrollment, String name) {
		super();
		this.enrollment = enrollment;
		this.name = name;
	}

	public String getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "{" + enrollment + ", " + name + "}";
	}
}
