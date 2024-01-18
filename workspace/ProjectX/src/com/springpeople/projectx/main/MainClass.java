package com.springpeople.projectx.main;

import java.io.IOException;
import java.util.Scanner;

import com.springpeople.projectx.collections.CollectionsDemo;
import com.springpeople.projectx.exceptions.ExceptionDemo;
import com.springpeople.projectx.exceptions.ValidAgeException;
import com.springpeople.projectx.fileio.FilesDemo;
import com.springpeople.projectx.inheritance.Employee;
import com.springpeople.projectx.inheritance.PermanentEmployee;

//import java.util.Scanner;

import com.springpeople.projectx.sample.Student;
import com.springpeople.projectx.strings.StringsDemo;

public class MainClass {

	public static void main(String[] args) {
		CollectionsDemo obj = new CollectionsDemo();
		//obj.listDemo1();
	//	obj.linkedListDemo();
//		obj.priorityQDemo();
//		obj.setDemo1();
		obj.mapDemo1();
		
//		StringsDemo obj = new StringsDemo();
//		obj.method1();
		
		//FilesDemo obj = new FilesDemo();
		
		//obj.writeToFile();
		//obj.readFromFile();
		//obj.writeObjectToFile();
		//obj.readObjectFromFile();
		//obj.charStreamDemo();
		
		//ExceptionDemo obj = new ExceptionDemo();
		
//		float ans = obj.divide(12, 0);
//		System.out.println(ans);
		
//		try {
////			float ans = obj.divide(12, 4);
////		
////			System.out.println(ans);
//			
//			obj.checkAge(21);
//			
//		} catch(ArithmeticException ex) {
//			System.out.println("Exception occured: " + ex.getMessage());
//		} catch(ValidAgeException e) {
//			System.out.println(e.getMessage());
//		}
//		finally {
//			System.out.println("Done");
//		}
//	
		
//		PermanentEmployee emp = new PermanentEmployee();
//		emp.setEmpId(1);
//		emp.setEmpName("Employee1");
//		emp.setDeptName("Dept1");
//		emp.setSalary(23450.00);
//
//		emp.toString();
//		emp.demoMethod();
		
		//PermanentEmployee e = (PermanentEmployee)new Employee();
//		Employee e = new PermanentEmployee();
//		e.demoMethod();
//		
//		PermanentEmployee.staticMethod();
		
//		Employee e = new Employee(1, "Emp1", "dept", 23450.00);
//		Employee.Address addr = e.new Address();
//		addr.setDoorno(23);
//		addr.setStreet("10th Cross");
//		addr.setCity("Bangalore");
//		addr.setState("Karnataka");
//		System.out.println(e.getEmpId() + " " + e.getEmpName());
//		System.out.println(e.getDeptName() + " " + e.getSalary());
//		System.out.println(addr.toString());
//		
//		
//		
//		Student student = new Student();
//		student.acceptData(1, "Prithvi", "Raj", 24);
//		student.printData();
//		Student.SchoolAddress obj = new Student.SchoolAddress();
//		obj.setCity("Ban galore");
//		
//		Student student1 = new Student();
//		student1.setStudentId(2);
//		student1.setFirstName("Pallavi");
//		student1.setLastName("Prasad");
//		student1.setAge(22);
//		student1.printData();
		
		//Scanner sc = new Scanner(System.in);
		
		//datatype arrayname[] = new datatype[size];
//		int[] arr = new int[5];
//		
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = i + 10;
//		}
//		
//		System.out.println(arr);
//		
//		
//		System.out.println();
//		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		
//		System.out.println();
//		
//		for(int i: arr) {
//			System.out.println(i); 
//		}
		
//		Scanner sc = new Scanner(System.in);
//		//array of objects
//		Student[] studentsList = new Student[5];
//		
//		for(int i = 0; i < studentsList.length; i++) {
//			int id = sc.nextInt();
//			String fn = sc.next();
//			String ln = sc.next();
//			int age = sc.nextInt();
//			
//			studentsList[i] = new Student(id, fn, ln, age);
//		}
//		
//		for(Student s: studentsList) {
//			s.printData();
//		}
//		
//		Student s = new Student(1, "Student", "One", 23);
//		//Student.setSchool("Paychex");
//		s.printData();
//		System.out.println();
//		Student s1 = new Student(2, "Second", "Student", 22);
//		s1.printData();
		
	//	s.setSchool("New School");
//		s.printData();
//		s1.printData();
//		
		
		
	}

}
