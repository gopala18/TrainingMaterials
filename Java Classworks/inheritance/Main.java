package com.csscorp.inheritance;

public class Main {

	public static void main(String[] args) {
		Employee emp=new Employee();
		emp.setEmpID(123);
		emp.setDept("training");
		emp.setDesignation("trainer");
		emp.setSalary(20000.00);
		
		
		emp.setName("James");
		emp.setAge(30);
		emp.setPhone("98785643");
		
		Address myAddress=new Address(13,"somestreet", "somevillage","somecity",45435434);
		emp.setAddress(myAddress);
		
		System.out.println(emp);
		
		
	}

}
