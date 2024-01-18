package com.springpeople.projectx.inheritance;

public abstract class Account {
	private int accountNumber;
	private String accountName;
	private double balance;
	
	public String getAccountName() {
		return accountName;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public abstract void depositAmount(double amt);
	public abstract void withdraw(double amt);
	public abstract double showBalance();
	
	public void showAccountDetails() {
		System.out.println("Account #: " + accountNumber
				+ ", Name: " + accountName
				+ ", Current Balance: " + balance);
	}
	
}
