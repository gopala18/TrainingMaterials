package com.csscorp.bankapp.dto;

public class BankAccountOverFlowException extends Exception {

	private String errMsg="BankAccount array overflow... Unable to create a new account...";
	
	public BankAccountOverFlowException() {
		
	}
	public BankAccountOverFlowException(String err) {
		this.errMsg=err;
		
	}
	@Override
	public String getMessage() {
		return this.errMsg;
	}
}
