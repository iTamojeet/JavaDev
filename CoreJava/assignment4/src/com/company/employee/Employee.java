package com.company.employee;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// Base class for all employeees in the company
class Employee {
	protected long employeeId;
	protected String employeeName;
	protected String employeeAddress;
	protected long employeePhone;
	protected double basicSalary;
	protected double specialAllowance = 250.80;
	protected double hra = 1000.50;

	// Overoaded constructor of class employee
	public Employee(long id, String name, String address, long phone) {
		this.employeeId = id;
		this.employeeName = name;
		this.employeeAddress = address;
		this.employeePhone = phone;
	}

	public Employee(long id, String name, String address, long phone, double salary) {
		this(id, name, address, phone);
		this.basicSalary = salary;
	}

	public void calculateSalary() {
		double salary = basicSalary + (basicSalary * specialAllowance / 100) + (basicSalary * hra / 100);
		System.out.println("Salary of " + employeeName + ": " + salary);
	}

	public void calculateTransportAllowance() {
		double transportAllowance = 0.1 * basicSalary;
		System.out.println("Transport Allowance of " + employeeName + ": " + transportAllowance);
	}
}