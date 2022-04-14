package com.csscorp.bankapp.dto;

import java.util.HashSet;
import java.util.Set;

import com.csscorp.bankapp.dao.BankStd;
import com.csscorp.bankapp.exception.AccountNotFoundException;
import com.csscorp.bankapp.exception.InsufficientFundException;

public class Bank implements BankStd {

	private String IFSCcode;
	private String branch;
	private String name;
	//private BankAccount[] bankAccounts = new BankAccount[3];
	private Set<BankAccount> bankAccounts=new HashSet<>();
	
	public static int index;
	static {
		index=-1;
	}
	public String getIFSCcode() {
		return IFSCcode;
	}

	public void setIFSCcode(String iFSCcode) {
		IFSCcode = iFSCcode;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public /*BankAccount[]*/ Set<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(Set<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public Bank(String iFSCcode, String branch, String name, Set<BankAccount> bankAccounts) {
		super();
		IFSCcode = iFSCcode;
		this.branch = branch;
		this.name = name;
		this.bankAccounts = bankAccounts;
	}

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bank [IFSCcode=" + IFSCcode + ", branch=" + branch + ", name=" + name + ", bankAccounts="
				+ bankAccounts.toString() + "]";
	}

	public boolean createAccount(String accountName,double balance) /*throws BankAccountOverFlowException*/ {
		boolean createAccountFlag=false;
		/*index=index+1;
		if(index>=3) {
			throw new BankAccountOverFlowException();
		}else*/
			//this.bankAccounts[index]=new BankAccount(accountName,balance);
		BankAccount newAccount=new BankAccount(accountName,balance);
		bankAccounts.add(newAccount);
		
		if(bankAccounts.contains(newAccount))
			createAccountFlag=true;
			return createAccountFlag;
	}
	public Bank(String iFSCcode, String branch, String name) {
		super();
		IFSCcode = iFSCcode;
		this.branch = branch;
		this.name = name;
	}

	public BankAccount checkAccount(String accountNo) throws AccountNotFoundException{
		BankAccount foundAccount = null;
		for (BankAccount account : bankAccounts) {
			if (account.getAccountNo().equals(accountNo)) {
				foundAccount = account;
				break;
			}
		}
		if(foundAccount==null) {
			throw new AccountNotFoundException("custom error message");
		}
		
		return foundAccount;
	}

	@Override
	public boolean withdraw(String accountNo, double amount) throws AccountNotFoundException, InsufficientFundException{
		boolean withdrawFlag = false;
		BankAccount foundAccount=this.checkAccount(accountNo);
		if(foundAccount!=null) {
			if(foundAccount.getBalance()>=amount) {
				foundAccount.setBalance(foundAccount.getBalance()-amount);
				withdrawFlag=true;
			}else
				throw new InsufficientFundException();
		}
		return withdrawFlag;
	}

	@Override
	public boolean deposit(String accountNo, double amount)throws AccountNotFoundException {
		boolean depositFlag = false;
		BankAccount foundAccount = this.checkAccount(accountNo);
		
		if (foundAccount != null) {
			double balance = foundAccount.getBalance();
			foundAccount.setBalance(balance + amount);
			depositFlag = true;
		}

		return depositFlag;
	}

	@Override
	public boolean transfer(String fromAccountNo, String toAccountNo, double amount)throws AccountNotFoundException, InsufficientFundException {
		boolean transferFlag=false;
		boolean withdrawFlag=this.withdraw(fromAccountNo, amount);
		
		boolean depositFlag=this.deposit(toAccountNo, amount);
		if(withdrawFlag & depositFlag) {
			transferFlag=true;
		}
		return transferFlag;
	}

}
