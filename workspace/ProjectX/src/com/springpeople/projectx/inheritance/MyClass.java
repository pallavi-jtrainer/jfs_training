package com.springpeople.projectx.inheritance;

public class MyClass implements MyInterface, Interface2{

	@Override
	public void method1() {
		Animal obj = new Animal() {
			
			@Override
			public void displayData() {
				// TODO Auto-generated method stub
				
			}
		};
		
		obj.displayData();
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2(String msg) {
		// TODO Auto-generated method stub
		
	}

	

}
