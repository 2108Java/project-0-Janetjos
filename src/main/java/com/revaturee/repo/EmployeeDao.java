package com.revaturee.repo;

public interface EmployeeDao {
	
	List<TransactionLog> selectTransactionLog();
	
	boolean approveUserAccount();
	
	List<Accounts> selectCustomerAccountList();

}
