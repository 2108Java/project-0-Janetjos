package com.revaturee.models;

import java.util.List;

public class Accounts {
	
	private String accountNumber;
	private float balance;
	private String accountType; 
	private List<Accounts> accountDetails;
	
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Accounts(String accountNumber, float balance, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountType = accountType;
		
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public boolean createCustomerAccount(boolean b) {
		// TODO Auto-generated method stub
		return b;
		
	}
	public void retrieveCustomerAccountDetails(List<Accounts> accountDetails) {
		this.accountDetails = accountDetails;
		
	}
	
	public boolean depositMoney(boolean b) {
		
		return b;
		
	}
	

}
