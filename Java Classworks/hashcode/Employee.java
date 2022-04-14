package com.csscorp.hashcode;

public class Employee {

	private int empID;
	private String name;
	private String designation;
	
	
	@Override
	public int hashCode() {
		return empID;
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
		if (empID != other.empID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "\nEmployee [empID=" + empID + ", name=" + name + ", designation=" + designation + "]";
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Employee(int empID, String name, String designation) {
		super();
		this.empID = empID;
		this.name = name;
		this.designation = designation;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
