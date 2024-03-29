/*
 * strings are immutable
 * strings are objects
 * strings are array of characters
 * 
 */


package com.springpeople.projectx.strings;

import java.util.StringTokenizer;

public class StringsDemo {

	public void method1() {
		String str = "This is a string";
		str = "This is also a string";
		String str1 = new String("This is a string using constructor");
		
//		str = str.concat(str1);
//		String[] array = str.split(" ");
//		for(String s: array) {
//			System.out.println(s);
//		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		
		StringTokenizer st = new StringTokenizer(str1, "a");
		int count = st.countTokens();
		System.out.println(count);
		
		while(st.hasMoreElements()) {
			System.out.println(st.nextToken());
		}
		
	}
}
