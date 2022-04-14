package com.csscorp.bankapp.exception;

public class AccountNotFoundException extends Exception {

	private String errMsg = "Account Not Found...!";

	public AccountNotFoundException() {

	}

	public AccountNotFoundException(String msg) {
		this.errMsg = msg;
	}

	@Override
	public String getMessage() {

		return this.errMsg;
	}

}
