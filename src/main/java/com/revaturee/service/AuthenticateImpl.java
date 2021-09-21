package com.revaturee.service;

import com.revaturee.models.Accounts;
import com.revaturee.models.Customer;
import com.revaturee.models.User;
import com.revaturee.repo.AccountsDao;
import com.revaturee.repo.BankDao;
import com.revaturee.repo.CustomerDao;
import com.revaturee.repo.UserDao;

public class AuthenticateImpl implements Authenticate{

	private Customer customer;
	private UserDao userDao;
	private Accounts account;
	private CustomerDao customerDao;
	private AccountsDao accountDao;
	
	
	@Override
	public boolean authenticate(String username, String password) {
		User u = getUser(username);
		boolean success = false;
		if(!(u == null) && u.getPassword().equals(password));
		return success;
	}
	
	//Registering for an account - need to refine more 

	@Override
	public User getUser(String username) {
		User u = userDao.selectUserByUsername(username);
		
				
		u.setCustomerDetails(customerDao.insertDetailsByUsername(u.getUsername()));
		
		return u;
		
		//account.setAccountList(bankDao.selectActivityByUserId(u.getId()));
		//return u;
	}
	
	//Create account with starting balance -- create a method to method to retrieve customer ID from username in CustomerDao

	@Override
	public void createAccount(String username) {
		// TODO Auto-generated method stub
		User u = userDao.selectUserByUsername(username);
		
		customer.createCustomerAccount(accountDao.insertAccountByCustomerID(customerDao.selectCustomerID(u.getUsername())));
		
	}

	
}
