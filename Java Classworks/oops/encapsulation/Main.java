package com.csscorp.oops.encapsulation;

public class Main {
	public static void main(String[] args) {

		
		int a=10;
		Encapsulation encapsulation=new Encapsulation(1,19,"Java batch");
		
//		encapsulation.setDay(1);
//		encapsulation.setBatchName("Java Batch");
//		encapsulation.setNoOfTrainees(19);
		
    
		System.out.println("Day: "+encapsulation.getDay());
		System.out.println(encapsulation.getBatchName());
		System.out.println(encapsulation.getNoOfTrainees());
	}
}
