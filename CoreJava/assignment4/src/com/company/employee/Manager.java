package com.company.employee;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// Class for manager details
class Manager extends Employee {
	public Manager(long id, String name, String address, long phone, double salary) {
		super(id, name, address, phone, salary);
	}

	public void calculateTransportAllowance() {
		double transportAllowance = 0.15 * basicSalary;
		System.out.println("Transport Allowance of " + employeeName + ": " + transportAllowance);
	}
}