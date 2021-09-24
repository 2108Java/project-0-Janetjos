package com.revaturee.service;

import java.util.List;

import com.revaturee.models.Accounts;
import com.revaturee.models.Customer;
import com.revaturee.models.TransactionLog;
import com.revaturee.models.User;

public interface Service {



	boolean createAccount(Customer customer, User u);

	List<Accounts> viewBalance(Accounts account, User u, Customer customer);

	boolean transferMoney(Customer customer, float deposit, User u, Accounts account);

	boolean acceptMoney(float withdraw, User u, Customer customer, Accounts account);

	List<TransactionLog> viewTransactionLog(Accounts account, User u, Customer customer);

	List<TransactionLog> viewAllTransactionLog(User u);

	List<Accounts> viewAccounts(User u, Customer customer, Accounts account);

	boolean approveAccount(User u, Customer customer);

	boolean logDepositTransaction(Customer customer, float transferAmount, User u, Accounts account);

	boolean logWithdrawalTransaction(Customer customer, float transferAmount, User u, Accounts account);

	boolean createCustomerAccount(Accounts account, User u, Customer customer);

	boolean createUser(User u);



}
