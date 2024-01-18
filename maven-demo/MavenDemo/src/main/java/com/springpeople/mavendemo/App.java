package com.springpeople.mavendemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.springpeople.mavendemo.entity.Courses;
import com.springpeople.mavendemo.entity.Students;
import com.springpeople.mavendemo.factory.CoursesFactory;
import com.springpeople.mavendemo.factory.StudentsFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	private void mainMenu() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in); 
		while(true) {
			System.out.println("1. Register Student");
			System.out.println("2. View All Courses");
			System.out.println("3. View all courses for a student");
			System.out.println("4. View all students for a course");
			System.out.println("5. Exit");
			System.out.println("Your Choice: ");
			try {
				int ch = sc.nextInt();
				
				switch(ch) {
				case 1:
					System.out.println("List of courses: ");
					List<Courses> courses = CoursesFactory.listAll();
					for(Courses c: courses) {
						System.out.println(c.toString());
					}
					System.out.println("Course id you want to register for: ");
					int courseId = sc.nextInt();
					System.out.println("Enter Name: ");
					String name = br.readLine();
					System.out.println("Enter email: ");
					String email = br.readLine();
					Students s = new Students(0, name, email);
					
					String str = StudentsFactory.registerStudent(s, courseId);
					System.out.println(str);
					break;
				case 2:
					List<Courses> allCourses = CoursesFactory.listAll();
					
					for(Courses c: allCourses) {
						System.out.println(c.toString());
					}
					break;
				case 3:
					System.out.println("Enter Your Id:");
					int sId = sc.nextInt();
					String sname = StudentsFactory.getStudentName(sId);
					List<Courses> myCourses = StudentsFactory.listAllCoursesForStudent(sId);
					System.out.println(sname + "'s Courses:");
					for(Courses c: myCourses) {
						System.out.println(c.toString());
					}
					break;
				case 4:
					System.out.println("Enter Course Id:");
					int cId = sc.nextInt();
					String cName = CoursesFactory.getCourseName(cId);
					List<Students> students = CoursesFactory.listAllStudentsForCourse(cId);
					System.out.println("Course Name: " + cName);
					for(Students s1: students) {
						System.out.println(s1.getStudentId() + " " + s1.getStudentName());
					}
					break;
				default:
					System.out.println("Exiting");
					Runtime.getRuntime().exit(0);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
    public static void main( String[] args )
    {
       App obj = new App();
       obj.mainMenu();
    }
}
