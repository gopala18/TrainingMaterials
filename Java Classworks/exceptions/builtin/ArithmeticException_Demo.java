package com.csscorp.exceptions.builtin;

//Java program to demonstrate ArithmeticException
class ArithmeticException_Demo {

	public int div(int a, int b) {
		return a/ b;
	}

	public static void main(String args[]) {

		try {
			int result = new ArithmeticException_Demo().div(10, 0);
			System.out.println("Result = " + result);
		} catch (ArithmeticException ae) {
			// System.out.println ("Can't divide a number by 0");
			ae.printStackTrace();

		}
	}
}