package com.csscorp.inheritance;

public class Employee extends Person{

	private int empID;
	private double salary;
	private String dept;
	private String designation;
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, int age, String phone, int empID, double salary, String dept, String designation) {
		super(name, age, phone);
		this.empID = empID;
		this.salary = salary;
		this.dept = dept;
		this.designation = designation;
	}
	@Override
	public String toString() {
		return super.toString()+"Employee [empID=" + empID + ", salary=" + salary + ", dept=" + dept + ", designation=" + designation
				+ "]";
	}
	
	
	 
	
		
}
