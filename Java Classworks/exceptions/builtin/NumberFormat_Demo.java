package com.csscorp.exceptions.builtin;

//Java program to demonstrate NumberFormatException
class  NumberFormat_Demo
{
 public static void main(String args[])
 {
	 System.out.println("Before exception");
	 
	 int num = Integer.parseInt ("asdsa") ;
	 
     /*try {
         // "akki" is not a number
         int num = Integer.parseInt ("asdsa") ;
         System.out.println(num);
         System.out.println("statement immediately after exception ");
     } catch(NumberFormatException e) {
         System.out.println("Number format exception");
     }*/
     
     System.out.println("rest of your program");
 }
}