package com.revaturee.views;

import java.util.List;
import java.util.Scanner;

import com.revaturee.models.Accounts;
import com.revaturee.models.Customer;
import com.revaturee.models.TransactionLog;
import com.revaturee.models.User;
import com.revaturee.service.Authenticate;
import com.revaturee.service.AuthenticateImpl;
import com.revaturee.service.Service;


public class PresentationImpl implements Presentation{
	
	private Authenticate auth;
	
	Accounts account = new Accounts();
	Customer customer = new Customer();
	
	Service service;
	
	Scanner sc = new Scanner(System.in);
	
		
	//private static final Logger loggy = Logger.getLogger(PresentationImpl.class);
	
	public PresentationImpl(Authenticate auth) {
		this.auth = auth;
	}

	public User loginMenu() {
		//loggy.info("User sees login application");
		System.out.println("Please login");
		System.out.println("Username");
		String username = sc.nextLine();
		System.out.println("Password");
		String password = sc.nextLine();
		
		boolean authenticated = auth.authenticate(username, password);
		
		User u = new User();
		
		if(authenticated) {
			
			u = auth.getUser(username);
			
		}else {
			System.out.println("You are not authenticated");
			System.out.println("Try again");
		}
		
		return u;
		
	}

	public void customerDisplay(User u) {
		System.out.println("Existing Customer Display");
		System.out.println("Select what you want to do");
		System.out.println("(1)Register for an account");
		System.out.println("(2)View balance");
		System.out.println("(3)Deposit money");
		System.out.println("(4)Withdraw money");
		System.out.println("(5)View transaction log");
		System.out.println("(6)Create account with starting balance");
		System.out.println("(0)Exit Menu");
		
		
		
		String option = sc.nextLine();
		boolean runningOne = true;
		while(runningOne) {
		switch(option) {
		case "1":
			System.out.println("Enter name:");
			String custName = sc.nextLine();
			System.out.println("Enter phone number:");
			String custPhone = sc.nextLine();
			customer.setCustomerName(custName);
			customer.setPhoneNumber(custPhone);
			service.createAccount(customer, u);		
			break;
		case "2":
			System.out.println("Enter account number:");
			String accNumber = sc.nextLine();
			account.setAccountNumber(accNumber);
			prettyDisplayAccounts(service.viewBalance(account, u, customer));
			break;
		case "3":
			System.out.println("Enter amount you wish to deposit:");
			float deposit = sc.nextFloat();
			service.transferMoney(customer, deposit, u, account);
			service.logDepositTransaction(customer, deposit, u, account);
			break;
		case "4":
			System.out.println("Enter amount you wish to withdraw:");
			float withdraw = sc.nextFloat();
			service.acceptMoney(withdraw, u, customer, account);
			service.logWithdrawalTransaction(customer, withdraw, u, account);
			break;
		case "5":
			System.out.println("Enter account number:");
			String accountNumber = sc.nextLine();
			prettyDisplayTransactionLog(service.viewTransactionLog(accountNumber, u, customer));
			
			break;
			
		case "6":
			System.out.println("Enter account number:");
			String acNumber = sc.nextLine();
			account.setAccountNumber(acNumber);
			System.out.println("Enter Checking or Savings:");
			String accType = sc.nextLine();
			account.setAccountType(accType);
			service.createCustomerAccount(account, u, customer);
		case "0":
			runningOne = false;
			System.out.println("Exit!");
			break;
		
		
		}
		
		
		}		
	}
	
	private void prettyDisplayAccounts(List<Accounts> viewBalance) {
		for (int i = 0; i < viewBalance.size(); i++) {
            System.out.println(viewBalance.get(i));
        }
		
	}

	private void prettyDisplayTransactionLog(List<TransactionLog> viewTransactionLog) {
		  for (int i = 0; i < viewTransactionLog.size(); i++) {
	            System.out.println(viewTransactionLog.get(i));
	        }
		
	}

	public void employeeDisplay(User u) {
		
		Customer customer = new Customer();
		
		System.out.println("Employee Menu:");
		System.out.println("Select what you want to do");
		System.out.println("(1)View log of all transactions");
		System.out.println("(2)View customer's bank accounts");
		System.out.println("(3)Approve account registration");
		System.out.println("(0)Exit Menu");

		
		String option = sc.nextLine();
		
		boolean runningOne = true;
		while(runningOne) {
		switch(option) {
		case "1":
			prettyDisplayTransactionLog(service.viewAllTransactionLog(u));
			break;
		case "2":
			System.out.println("Enter customer ID:");
			int id = sc.nextInt();
			customer.setCustomerId(id);
			prettyDisplayAccounts(service.viewAccounts(u, customer, account));
			break;
		case "3":
			System.out.println("Enter customer ID:");
			int id_1 = sc.nextInt();
			customer.setCustomerId(id_1);
			service.approveAccount(u, customer);
			break;
		case "4":
			System.out.println("Exit!");
			break;
		case "0":
			runningOne = false;
			System.out.println("Exit!");
			break;
		
		}
		
		}
				
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
			System.out.println("(0)Exit the application");

		
			String userType = sc.nextLine();
		
			switch(userType) {
			case "1":
				System.out.println("Customer Menu");
				customerDisplay(user);
				break;
			
			case "2":
				System.out.println("Employee Menu");
				employeeDisplay(user);
				break;
			case "0":
				running = false;
				System.out.println("Exit!");
				break;
			
			}
		
		}
		
	}

}


