package com.springpeople.projectx.inheritance;

public class PermanentEmployee extends Employee {
	
	@Override
	public void demoMethod() {
		int sum = 2 + 4;
		System.out.println("In derived: sum = " + sum);
	}
	
}
