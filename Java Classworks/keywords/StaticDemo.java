package com.csscorp.keywords;

public class StaticDemo {

	public static int c;
	static {
		c=5;
	}
	private int a;
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public StaticDemo() {
		
	}
	public StaticDemo(int a) {
		
	}
}

