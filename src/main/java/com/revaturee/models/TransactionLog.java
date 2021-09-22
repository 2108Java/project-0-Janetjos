package com.revaturee.models;

public class TransactionLog {
	
	private String accountNumber;
	private float transferAmount;
	private float amount;
	
	
	public TransactionLog(String accountNumber, float transferAmount, float amount) {
		super();
		this.accountNumber = accountNumber;
		this.transferAmount = transferAmount;
		this.amount = amount;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public float getTransferAmount() {
		return transferAmount;
	}


	public void setTransferAmount(float transferAmount) {
		this.transferAmount = transferAmount;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
		

}
