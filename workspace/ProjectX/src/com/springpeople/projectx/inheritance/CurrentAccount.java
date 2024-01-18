package com.springpeople.projectx.inheritance;

public class CurrentAccount extends Account{
	private final String accountType = "Current Account";
	
	public String getAccountType() {
		return accountType;
	}
	
	@Override
	public void depositAmount(double amt) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public double showBalance() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void withdraw(double amt) {
		// TODO Auto-generated method stub
		
	}
}
