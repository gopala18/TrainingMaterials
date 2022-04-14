package com.csscorp.datetime;

import java.time.LocalDate;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		Date today=new Date();
		System.out.println(today);
		
		LocalDate ltoday=LocalDate.now();
		System.out.println(ltoday);
		
		System.out.println(ltoday.minusDays(4));
		System.out.println(ltoday.plusDays(4));
		
	}

}
