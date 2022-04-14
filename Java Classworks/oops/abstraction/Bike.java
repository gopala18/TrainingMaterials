package com.csscorp.oops.abstraction;

public abstract class Bike {
	private String color;
	private String type;

	public Bike(String color, String type) {
		super();
		this.color = color;
		this.type = type;
	}

	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void bikeDetails() {
		System.out.println("Color: " + color);
		System.out.println("Type: " + type);
	}

	// abstract method
	public abstract void price();
}
