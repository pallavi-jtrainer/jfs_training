package com.springpeople.projectx.sample;
// single - line comment
/*
 * to comment out a block of code*/

/***
 * Class Student
 * @author Pallavi Prasad
 */
public class Student {
	private int studentId;
	private String firstName;
	private String lastName;
	private int age;
	private static String school;
//	private final String email = "abc@gmail";
	private final String email;
	
	//static block
	static {
		school = "New School";
	}
	
	//initialization block
	{
		email = "abc@gmail";
	}
	
	public static class SchoolAddress {
		private int doorno;
		private String city;
		
		public String getCity() {
			return city;
		}
		
		public void setCity(String city) {
			this.city = city;
		}
		
		public int getDoorno() {
			return doorno;
		}
		
		public void setDoorno(int doorno) {
			this.doorno = doorno;
		}
		
		public static void printEmail() {
			System.out.println(school);
		}
		
	}
	
	
	/**
	 * method to accept data into object
	 * @param id represents studentId
	 * @param fName represents firstName
	 * @param lName represents lastName
	 * @param age represents age
	 */
	public void acceptData(int id, String fName, String lName, int age) {
		this.studentId = id;
		this.firstName = fName;
		this.lastName = lName;
		this.age = age;
	}
	
	/**
	 * prints data
	 */
	public void printData() {
		System.out.println("Student Details: Id -> " + this.studentId);
		System.out.println("First Name -> " + this.firstName);
		System.out.println("Last Name -> " + this.lastName);
		System.out.println("Age -> " + this.age);
		System.out.println("School -> " + school);
	}
	
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getStudentId() {
		return this.studentId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public static String getSchool() {
		return school;
	}
	
//	public static void setSchool(String school) {
//		Student.school = school;
//	}
	
	public Student() {
//		email="";
	}
	
	public Student(int studentId, String firstName, String lastName, int age) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
//		this.email = email;
	}
	
}
