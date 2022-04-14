package com.csscorp.exceptions.checkedunchecked;

//Unchecked are the exceptions that are not checked at compiled time.
//In Java exceptions under Error and RuntimeException classes are unchecked exceptions, 
//everything else under throwable is checked.
public class UncheckedExample {

	public static void main(String args[]) {
		int x = 0;
		int y = 10;
		try {
			int z = y / x;
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("other statements...");
	}
}
