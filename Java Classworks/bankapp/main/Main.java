package com.csscorp.bankapp.main;

import com.csscorp.bankapp.dto.Bank;

public class Main {
	public static void main(String[] args) {

		Bank axisBank = new Bank("Axis100", "Tambaram", "Axis");

		axisBank.createAccount("Charles", 10000);
		axisBank.createAccount("John", 500);
		axisBank.createAccount("prakash", 5000);
		

		System.out.println(axisBank.toString());

	}
}
