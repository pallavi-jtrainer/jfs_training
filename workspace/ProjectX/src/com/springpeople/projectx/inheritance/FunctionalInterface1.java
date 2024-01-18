package com.springpeople.projectx.inheritance;

@FunctionalInterface
public interface FunctionalInterface1 {
	public default void defaultMethod() {
		System.out.println("Inside interface default method");
	}
	
	public static void staticMethod() {
		System.out.println("Inside interface static method");
	}
	
	public void add(int a, int b);
}
