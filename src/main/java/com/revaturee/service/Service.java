package com.revaturee.service;

public interface Service {

	void addAccount(String customerName, String mailingAddress, String residentialAddress, String phoneNumber);

	void viewBalance();

	void transferMoney();

	void acceptMoney();

	void viewTransactionLog();

	void viewCustomerDetails();

	void transactionApproval();

	void accountApproval();

}
