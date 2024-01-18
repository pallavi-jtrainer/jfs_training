package com.springpeople.projectx.inheritance;

public class InterfaceImpl{
	public void method1() {
		FunctionalInterface1 fn = (int a, int b) -> {
			System.out.println(a + b);
		};
		fn.add(3, 5);
	}

}
