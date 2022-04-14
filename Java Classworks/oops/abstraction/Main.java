package com.csscorp.oops.abstraction;



public class Main {
	public static void main(String[] args) {
		Bike splender=new Hero("Black","with gear",50000.00);
		splender.bikeDetails();
		splender.price();
		Bike trigger=new Honda("Red","with gear");
		trigger.bikeDetails();
		trigger.price();
		
	}
}
