package com.revaturee.repo;

import java.util.List;

import com.revaturee.models.Accounts;
import com.revaturee.models.Customer;
import com.revaturee.models.TransactionLog;
import com.revaturee.models.User;

public interface TransactionLogDao {
	
	boolean insertDepositTransactionDetails(Customer customer, float transferAmount, User u, Accounts account);
	
	boolean insertWithdrawalTransactionDetails(Customer customer, float transferAmount, User u, Accounts account);
	
	List<TransactionLog> selectTransactionList(String accountNumber, User u, Customer customer);
	
	List<TransactionLog> selectAllTransactionList(User u);

}
