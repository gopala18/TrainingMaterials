package com.csscorp.keywords;

public class Main {
	public static void main(String[] args) {
		StaticDemo sd=new StaticDemo();
		sd.setA(10);
		System.out.println(sd.c);
		sd.c=40;
		
		System.out.println(sd.getA());
		
		StaticDemo sd1=new StaticDemo();
		sd1.setA(100);
		System.out.println(sd1.getA());
		System.out.println(sd1.c);
	}

}
