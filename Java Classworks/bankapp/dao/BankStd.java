package com.csscorp.bankapp.dao;

import com.csscorp.bankapp.exception.AccountNotFoundException;
import com.csscorp.bankapp.exception.InsufficientFundException;

public interface BankStd {

	public boolean withdraw(String accountNo,double amount)throws AccountNotFoundException,InsufficientFundException;
	public boolean deposit(String accountNo,double amount)throws AccountNotFoundException;
	public boolean transfer(String fromAccountNo,String toAccountNo,double amount)throws AccountNotFoundException, InsufficientFundException;
}
