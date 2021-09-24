package com.revaturee.views;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revaturee.models.Accounts;
import com.revaturee.models.Customer;
import com.revaturee.models.TransactionLog;
import com.revaturee.models.User;
import com.revaturee.service.Authenticate;
import com.revaturee.service.AuthenticateImpl;
import com.revaturee.service.Service;
import com.revaturee.service.ServiceImpl;


public class PresentationImpl implements Presentation{
	
	User u = new User();
	
	Service service = new ServiceImpl();
	
	private Authenticate auth = new AuthenticateImpl();
	
	Accounts account = new Accounts();
	Customer customer = new Customer();
	
		
	Scanner sc = new Scanner(System.in);
	
		
	private static final Logger loggy = Logger.getLogger(PresentationImpl.class);
	
	public PresentationImpl(Authenticate auth) {
		this.auth = auth;
	}

	public PresentationImpl() {
		// TODO Auto-generated constructor stub
	}

	public User loginMenu() {
		loggy.info("User sees login application");
		System.out.println("Please choose one of the following:");
		System.out.println("(1)Register");
		System.out.println("(2)Login");
		String option = sc.nextLine();
		
		switch(option) {
		case "1":
			System.out.println("Username");
			String username = sc.nextLine();
			u.setUsername(username);
			System.out.println("Password");
			String password = sc.nextLine();
			u.setPassword(password);
			service.createUser(u);
			break;
		case "2":
			System.out.println("Username");
			String loginUsername = sc.nextLine();
			u.setUsername(loginUsername);
			System.out.println("Password");
			String loginPassword = sc.nextLine();
			u.setPassword(loginPassword);
			
			boolean authenticated = auth.authenticate(loginUsername, loginPassword);
			
						
			if(authenticated) {
				
				u = auth.getUser(loginUsername);
				
			}else {
				System.out.println("You are not authenticated");
				System.out.println("Try again");
			}
		
			
		}
	
		
		return u;
		
		
		
	}
	

	public void customerDisplay(User u) {
		
		boolean runningOne = true;
	
		
		
		
		
		
		while(runningOne) {
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
		switch(option) {
		case "1":
			System.out.println("Enter name:");
			String custName = sc.nextLine();
			System.out.println("Enter phone number:");
			String custPhone = sc.nextLine();
			customer.setCustomerName(custName);
			customer.setPhoneNumber(custPhone);
			boolean b = service.createAccount(customer, u);		
			break;
		case "2":
			System.out.println("Enter account number:");
			int accNumber = sc.nextInt();
			account.setAccountNumber(accNumber);
			prettyDisplayAccounts(service.viewBalance(account, u, customer));
			break;
		case "3":
			System.out.println("Enter account number:");
			int depAccount = sc.nextInt();
			account.setAccountNumber(depAccount);
			System.out.println("Enter amount you wish to deposit:");
			float deposit = sc.nextFloat();
			boolean bTwo = service.transferMoney(customer, deposit, u, account);
			boolean bOne = service.logDepositTransaction(customer, deposit, u, account);
			break;
		case "4":
			System.out.println("Enter account number:");
			int withAccount = sc.nextInt();
			account.setAccountNumber(withAccount);
			System.out.println("Enter amount you wish to withdraw:");
			float withdraw = sc.nextFloat();
			boolean bThree = service.acceptMoney(withdraw, u, customer, account);
			service.logWithdrawalTransaction(customer, withdraw, u, account);
			break;
		case "5":
			System.out.println("Enter account number:");
			int accountNumber = sc.nextInt();
			account.setAccountNumber(accountNumber);
			prettyDisplayTransactionLog(service.viewTransactionLog(account, u, customer));
			
			break;
			
		case "6":
			//System.out.println("Enter account number:");
			//int acNumber = sc.nextInt();
			//account.setAccountNumber(acNumber);
			System.out.println("Enter Checking or Savings:");
			String accType = sc.nextLine();
			account.setAccountType(accType);
			boolean bFour = service.createCustomerAccount(account, u, customer);
			break;
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
		
		
		
		boolean runningOne = true;
		while(runningOne) {
			System.out.println("Employee Menu:");
			System.out.println("Select what you want to do");
			System.out.println("(1)View log of all transactions");
			System.out.println("(2)View customer's bank accounts");
			System.out.println("(3)Approve account registration");
			System.out.println("(0)Exit Menu");

			
			String option = sc.nextLine();
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
		//boolean login = true;
		//User user = new User();
		//while(login) {
			//u = loginMenu();
			//if(u != null) {
				//login = false;
			//}
			
		//}
		
				
		
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
				boolean loginCust = true;
				//User user = new User();
				while(loginCust) {
					u = loginMenu();
					if(u != null) {
						loginCust = false;
					}
					
				}
				customerDisplay(u);
				break;
			
			case "2":
				System.out.println("Employee Menu");
				boolean loginEmp = true;
				//User user = new User();
				while(loginEmp) {
					u = loginMenu();
					if(u != null) {
						loginEmp = false;
					}
					
				}
				
				employeeDisplay(u);
				break;
			case "0":
				running = false;
				System.out.println("Exit!");
				break;
			
			}
		
		}
		
	}

}


