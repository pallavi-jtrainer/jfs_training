package com.springpeople.projectx.inheritance;

public class SavingsAccount extends Account{

	private final String accountType = "Savings Account";
	
	public String getAccountType() {
		return accountType;
	}
	
	@Override
	public void depositAmount(double amt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(double amt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double showBalance() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void showAccountDetails() {
		super.showAccountDetails();
		System.out.println("Account Type: " + accountType);
	}

}
