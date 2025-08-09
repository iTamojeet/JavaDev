package com.company.employee;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// this class contains main method and calls the calculateSalary, calculateTransportAllowance methods
public class InheritanceActivity {
	public static void main(String[] args) {
		// Manager object
		Manager manager = new Manager(126534, "Peter", "Chennai India", 237844, 65000);
		// Traineee object
		Trainee trainee = new Trainee(29846, "Jack", "Mumbai India", 442085, 45000);

		manager.calculateSalary();
		trainee.calculateSalary();

		manager.calculateTransportAllowance();
		trainee.calculateTransportAllowance();
	}
}