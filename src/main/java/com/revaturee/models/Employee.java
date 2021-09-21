package com.revaturee.models;

public class Employee extends User{
	
	private int employeeID;
	private String employeeName;
	private String employeepPhoneNumber;
	
	public Employee() {
		super();
	}
	
		
	public Employee(String username, String password, int employeeID, String employeeName, String employeepPhoneNumber) {
		super(username, password);
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeepPhoneNumber = employeepPhoneNumber;
	}


	public int getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getEmployeepPhoneNumber() {
		return employeepPhoneNumber;
	}


	public void setEmployeepPhoneNumber(String employeepPhoneNumber) {
		this.employeepPhoneNumber = employeepPhoneNumber;
	}
	
	

}
