package com.revaturee.repo;

import java.util.List;

import com.revaturee.models.Accounts;
import com.revaturee.models.Customer;
import com.revaturee.models.TransactionLog;
import com.revaturee.models.User;

public interface EmployeeDao {
	
	List<TransactionLog> selectTransactionLog(User u, Customer customer);
	
	List<Accounts> selectCustomerAccountList(User u, Customer customer);

	boolean approveUserAccount(User u, Customer customer);

}
