package com.csscorp.hashcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashcodeDemo {
	public static void main(String[] args) {
		List<Employee> employees=new ArrayList<Employee>();
		
		
		
		Employee e1=new Employee(123,"Gopi","Trainer");
		Employee e2=new Employee(123,"Gopi","Trainer");
		Employee e3=new Employee(123,"Gopi","Trainer");
		
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e3.hashCode());
		
		
		System.out.println(employees.toString());
		
		Set<Employee> employeeSet=new HashSet<>();
		employeeSet.addAll(employees);
		System.out.println(employeeSet);
	}
}
