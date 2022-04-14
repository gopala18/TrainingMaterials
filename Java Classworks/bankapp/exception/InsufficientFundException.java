package com.csscorp.bankapp.exception;

public class InsufficientFundException extends Exception{

	private String errMsg="Insufficient fund in your account...!";
	
	public InsufficientFundException() {
		
	}
	public InsufficientFundException(String msg) {
		this.errMsg=msg;
	}
	@Override
	public String getMessage() {
		
		return this.errMsg;
	}
	
	
}

