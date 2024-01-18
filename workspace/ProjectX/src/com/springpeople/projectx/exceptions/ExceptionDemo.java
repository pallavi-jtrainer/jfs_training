package com.springpeople.projectx.exceptions;

import java.io.IOException;

public class ExceptionDemo {
	public float divide(int a, int b) throws IOException {
		if (b == 0) {
			throw new ArithmeticException("Divide By Zero");
		} else
			return a / b;
	}
	
	public void checkAge(int age) throws ValidAgeException {
		if (age < 18) {
			throw new ValidAgeException("Ineligible to vote");
		} else {
			System.out.println("Can vote");
		}
	}
}
