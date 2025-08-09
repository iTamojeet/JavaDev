package haha.hehe;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// this class contains the overridden toString() method
class Student {
	private String name;
	private int rollNo;
	private int age;

	public Student(String name, int rollNo, int age) {
		this.name = name;
		this.rollNo = rollNo;
		this.age = age;
	}

	public String toString() {
		return "Student [Name=" + name + ", RollNo=" + rollNo + ", Age=" + age + "]";
	}
}