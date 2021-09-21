package com.revaturee.views;

import java.util.Scanner;

import com.revaturee.models.User;
import com.revaturee.service.Authenticate;
import com.revaturee.service.AuthenticateImpl;
import com.revaturee.service.Service;


public class PresentationImpl implements Presentation{
	
	private Authenticate auth = new AuthenticateImpl();
	
	Service service;
	
	Scanner sc = new Scanner(System.in);
	
	//Employee methods
	
	//Menu for registering for an account
	public void registerMenu() {
		System.out.println("Registering for an account");
		System.out.println("Enter customer name:");
		String customerName = sc.nextLine();
		System.out.println("Enter mailing address:");
		String mailingAddress = sc.nextLine();
		System.out.println("Enter residential address:");
		String residentialAddress = sc.nextLine();
		System.out.println("Enter phone number:");
		String phoneNumber = sc.nextLine();
		//System.out.println("Is credit card required?");
		service.addAccount(customerName, mailingAddress, residentialAddress, phoneNumber);
				
	}
	
	//Menu for viewing account balance
	//--takes user or customer object and return appropriate result
	public void viewAccountBalanceMenu() {
		System.out.println("Enter the account number:");
		String accNumber = sc.nextLine();
		//return accNumber; -- calls method in service layer to retrieve account details		
	}
	
	//Menu for transferring money from cusomer's account
	//--takes user or account and return appropriate result
	public void transferMoneyMenu() {
		System.out.println("Enter the from account:");
		String fromAcount = sc.nextLine();
		System.out.println("Enter the destination account:");
		String toAcount = sc.nextLine();
		//boolean success = service.transferMoney(fromAccount,toAccount)
		//must add the transaction to the transaction log -- call the appropriate method
				
	}
	
	//Menu for accepting money (Not sure how this method works)
	//Add query in database -> view row in table -> customer can accept payment -> calls deposit method	
	public void acceptMoneyMenu() {
		System.out.println();
	}
	
	//Menu for viewing transaction log
	//takes user or account object as input and return transaction log(list)
	//public void viewTransactionLogMenu() {
		//System.out.println("");
	//}
	
	
	//Employee methods
	//Menu for approving transaction
	//takes in user object
	//public void approveTransactionMenu() {
		//System.out.println("");
	//}
	
	//Take in employee user object
	//calls approve method in service layer
	public void approveAccountMenu() {
		System.out.println("Please enter account number:");
		String accountNumber = sc.nextLine();
	}
	
	
	
	public User loginMenu() {
		System.out.println("Please login");
		System.out.println("Username");
		String username = sc.nextLine();
		System.out.println("Password");
		String password = sc.nextLine();
		
		boolean authenticated = auth.authenticate(username, password);
		
		User u = null;
		
		if(authenticated) {
			
			u = auth.getUser(username);
			
		}else {
			System.out.println("You are not authenticated");
			System.out.println("Try again");
		}
		
		return u;
		
	}

	public int customerDisplay(User u) {
		System.out.println("Existing Customer Display");
		System.out.println("Select what you want to do");
		System.out.println("(1)Create account");//Individual,Joint,Starting balance
		System.out.println("(2)View Balance");
		//System.out.println("(3)Withdraw & deposit to account");
		System.out.println("(3)Transfer money");
		System.out.println("(4)Accept money transfer");
		System.out.println("(5)View transaction log");
		
		int option = sc.nextInt();
		
		switch(option) {
		case 1:
			service.addAccount();
			break;
		case 2:
			service.viewBalance();
			break;
		case 3:
			service.transferMoney();
			break;
		case 4:
			service.acceptMoney();
			break;
		case 5:
			service.viewTransactionLog();
			break;
		}
		
		return option;
				
	}
	
	public int employeeDisplay(User u) {
		System.out.println("Existing Customer Display");
		System.out.println("Select what you want to do");
		System.out.println("(1)View customer details");
		System.out.println("(2) Approve or reject accounts");
		
		int option = sc.nextInt();
		
		switch(option) {
		case 1:
			service.viewCustomerDetails();
			break;
		case 2:
			service.transactionApproval();
			break;
		case 3:
			service.accountApproval();
			break;
		
		}
		
		return option;
				
	}
		
	@Override
	public void display() {
		// TODO Auto-generated method stub
		//need to implement the below code inside while loop
		boolean login = true;
		User user = null;
		while(login) {
			user = loginMenu();
			if(user != null) {
				login = false;
			}
			
		}
		
			
		
		boolean running = true;
		
		while(running) {
				
			System.out.println("Welcome to the application");
			System.out.println("Please select one of the following:");
			System.out.println("(1)Customer");
			System.out.println("(2)Employee");
		
			int userType = sc.nextInt();
		
			switch(userType) {
			case 1:
				System.out.println("Customer Menu");
				customerDisplay(user);
				break;
			
			case 2:
				System.out.println("Employee Menu");
				employeeDisplay(user);
				break;
			
			}
		
		}
		
	}

}


