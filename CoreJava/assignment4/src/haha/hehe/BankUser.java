package haha.hehe;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// this is the class that creates user objects or bank accounts...
class BankUser {
	public static void main(String[] args) {
		System.out.println("Create a Bank Account (A/c No. SBI007) with initial balance of ₹1000:");
		CurrentAccount SBI007 = new CurrentAccount("SBI007", 1000);
		System.out.println("Deposit ₹200");
		SBI007.deposit(200);
		System.out.println("Withdraw ₹700");
		SBI007.withdraw(700);
		System.out.println("Current balance ₹" + SBI007.getBalance());
	}

}