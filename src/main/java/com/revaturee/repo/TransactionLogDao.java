package com.revaturee.repo;

import java.util.List;

import com.revaturee.models.TransactionLog;

public interface TransactionLogDao {
	
	boolean insertTransactionDetails();
	
	List<TransactionLog> selectTransactionList();

}
