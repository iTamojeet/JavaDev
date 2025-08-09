package haha.hehe;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// Current Account class
class CurrentAccount {
	protected String accountNumber;
	protected Double balance;

	CurrentAccount(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	// deposit or credit
	public void deposit(double amount) {
		balance += amount;
	}

	// withdraw or debit
	public void withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
		} else {
			System.out.println("Insufficient balance");
		}
	}

	public double getBalance() {
		return balance;
	}
}

//Savings Account class
class SavingsAccount extends CurrentAccount {
	public SavingsAccount(String accountNumber, double balance) {
		super(accountNumber, balance);
	}

}