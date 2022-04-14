package com.csscorp.oops.abstraction;

public class Hero extends Bike{
	private double price;
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Hero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hero(String color, String type) {
		super(color, type);
		// TODO Auto-generated constructor stub
	}

	public Hero(String color, String type, double price) {
		super(color, type);
		this.price = price;
	}

	@Override
	public void price() {
		System.out.println("Price: "+this.getPrice());
		
	}
		
	
}
