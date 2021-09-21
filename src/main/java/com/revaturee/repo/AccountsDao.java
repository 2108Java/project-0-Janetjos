package com.revaturee.repo;

import java.util.List;

import com.revaturee.models.Accounts;
import com.revaturee.util.ConnectionFactory;

public interface AccountsDao {
	
	//boolean insertAccount();
	
	selectAccountDetails();
	
	updateAccountDeposit();
	
	updateAccountWithdraw();
	
	updateMoneyTransfer();

	boolean insertAccountByCustomerID(int customerID);
	
		
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
