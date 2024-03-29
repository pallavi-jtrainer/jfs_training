package com.springpeople.projectx.inheritance;

import java.util.Objects;

public class Employee {
	private int empId;
	private String empName;
	private String deptName;
	private double salary;
	private EmployeeStatus status;
	
	public class Address {
		private int doorno;
		private String street;
		private String city;
		private String state;
		public int getDoorno() {
			return doorno;
		}
		public void setDoorno(int doorno) {
			this.doorno = doorno;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		@Override
		public String toString() {
			return "Address [doorno=" + doorno + ", street=" + street + ", city=" + city + ", state=" + state + "]";
		}
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(deptName, empId, empName, salary);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(deptName, other.deptName) && empId == other.empId
				&& Objects.equals(empName, other.empName)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", deptName=" + deptName + ", salary=" + salary
				+ "]";
	}
	
	public Employee() {
		
	}
	
	public Employee(int empId, String empName, String deptName, double salary) {
		this.empId = empId;
		this.empName = empName;
		this.deptName = deptName;
		this.salary = salary;
	}
	
	public final void finalMethod() {
		System.out.println("Final method in base");
	}
	
	public final void finalMethod(String msg) {
		
	}
	
	public void demoMethod() {
		System.out.println("This is a demo method in base");
	}
	
	public static void staticMethod() {
		System.out.println("Static method in base");
	}
	
	public static void staticMethod(String msg) {
		System.out.println(msg);
	}
	
}
