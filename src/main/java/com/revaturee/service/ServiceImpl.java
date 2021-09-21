package com.revaturee.service;

import com.revaturee.repo.BankDao;

public class ServiceImpl implements Service{
	
	BankDao database;
	
	public ServiceImpl(BankDao database) {
		this.database = database;
		
	}

	@Override
	public void addAccount(String customerName, String mailingAddress, String residentialAddress, String phoneNumber) {
		// TODO Auto-generated method stub
		return database.insertNewAccount();				
		
	}

	@Override
	public void viewBalance() {
		// TODO Auto-generated method stub
		return database.selectBalance();
	}

	@Override
	public void transferMoney() {
		// TODO Auto-generated method stub
		return database.insertMoneyTransfer();
	}

	@Override
	public void acceptMoney() {
		// TODO Auto-generated method stub
		return database.insertMoney();
	}

	@Override
	public void viewTransactionLog() {
		// TODO Auto-generated method stub
		return database.selectTransactionLog();
	}

	@Override
	public void viewCustomerDetails() {
		// TODO Auto-generated method stub
		return database.selectCustomerDetails();
	}

	@Override
	public void transactionApproval() {
		// TODO Auto-generated method stub
		return database.insertTransactionStatemnt();
	}

	@Override
	public void accountApproval() {
		// TODO Auto-generated method stub
		return database.insertAccountApproval();
	}

}
