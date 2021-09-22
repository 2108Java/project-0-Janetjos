package com.revaturee.repo;

import java.util.List;

import com.revaturee.models.Accounts;
import com.revaturee.models.Customer;
import com.revaturee.models.User;
import com.revaturee.util.ConnectionFactory;

public interface AccountsDao {
	
	//boolean insertAccount();
	
	List<Accounts> selectAccountDetails(String username, Accounts account, Customer customer);
	
	boolean updateAccountDeposit(String username, Customer customer, Accounts account, float deposit);
	
	boolean updateAccountWithdraw(String username, Customer customer, Accounts account, float withdraw);
	
	//updateMoneyTransfer();

	boolean insertCustomerAccount(Accounts account, User u, Customer customer);
	
		
	//List<Accounts> selectListByCustomerId(int id);
	
		
	//to view account details
	//List<Accounts> selectAccountDetails();
	
	//List<Accounts> selectTransactionLog();//may have to create another model for transaction log
	
	//transfer money
	//deduct or add money in the db and record it
	//List<Accounts> 
	
	//accept money
	//view transaction log and return boolean which calls a function to make the necessary changes to the account

}
