package com.revaturee.models;

import java.util.List;

public class Customer extends User{
	
	private int customerId;
	private String customerName;
	private String phoneNumber;
		//private List<Accounts> accountList;
	public Customer(){
		super();
	}
	
	public Customer(String username, String password, int customerID, String customerName, String phoneNumber) {
		super(username, password);
		this.customerId = customerId;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean createCustomerAccount(boolean b) {
		return b;
				
	}
	
		

}
