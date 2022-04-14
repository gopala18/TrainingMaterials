package com.csscorp.bankapp.dto;

public class BankAccount {

	private String accountNo;
	private String accountName;
	private double balance;
	
	static int tempAcc=0;
	static {
		tempAcc=1000;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	/*public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}*/
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public BankAccount(/*String accountNo,*/ String accountName, double balance) {
		super();
		tempAcc++;
		this.accountNo = tempAcc+"";
		this.accountName = accountName;
		this.balance = balance;
	}
	public BankAccount() {
		tempAcc++;
		this.accountNo = tempAcc+"";
	}
	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", accountName=" + accountName + ", balance=" + balance + "]";
	}
	
	
}
