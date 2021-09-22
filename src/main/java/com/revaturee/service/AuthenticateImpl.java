package com.revaturee.service;



import com.revaturee.models.User;


import com.revaturee.repo.CustomerDao;
import com.revaturee.repo.UserDao;

public class AuthenticateImpl implements Authenticate{

	
	private UserDao userDao;
	
	private CustomerDao customerDao;
	
	public AuthenticateImpl(UserDao uDao, CustomerDao customerDao) {
		// TODO Auto-generated constructor stub
		this.userDao = uDao;
		this.customerDao = customerDao;
	}

	
	
	@Override
	public boolean authenticate(String username, String password) {
		User u = getUser(username);
		boolean success = false;
		if(u.getUsername().equals(username) && u.getPassword().equals(password));
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

	//@Override
	//public User createAccount(String username) {
		// TODO Auto-generated method stub
	//	User u = userDao.selectUserByUsername(username);
		
		//account.createCustomerAccount(accountDao.insertAccountByCustomerID(customerDao.selectCustomerID(u.getUsername())));
		
		//return u;
		
	//}

	//@Override
	//public User retrieveAccountDetails(String username) {
		
		//User u = userDao.selectUserByUsername(username);
		
		//account.retrieveCustomerAccountDetails(accountDao.selectAccountDetails(customerDao.selectCustomerID(u.getUsername())));
		
		//return u;
	//}

	//@Override
	//public User changeBalanceDeposit(String username) {
		//User u = userDao.selectUserByUsername(username);
		
		//account.depositMoney(accountDao.updateAccountDeposit(customerDao.selectCustomerID(u.getUsername())));
		
		//return u;
		
	//}

	
}
