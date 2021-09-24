package com.revaturee.service;

import java.util.List;

import com.revaturee.models.Accounts;
import com.revaturee.models.Customer;
import com.revaturee.models.TransactionLog;
import com.revaturee.models.User;
import com.revaturee.repo.AccountsDao;
import com.revaturee.repo.AccountsDaoImpl;
import com.revaturee.repo.CustomerDao;
import com.revaturee.repo.CustomerDaoImpl;
import com.revaturee.repo.EmployeeDao;
import com.revaturee.repo.EmployeeDaoImpl;
import com.revaturee.repo.TransactionLogDao;
import com.revaturee.repo.TransactionLogDaoImpl;
import com.revaturee.repo.UserDao;
import com.revaturee.repo.UserDaoImpl;

public class ServiceImpl implements Service{
	
	UserDao userDao = new UserDaoImpl();
	AccountsDao accountDao = new AccountsDaoImpl();
	CustomerDao customerDao = new CustomerDaoImpl();
	EmployeeDao employeeDao = new EmployeeDaoImpl();
	TransactionLogDao transactionLogDao = new TransactionLogDaoImpl();
	
	
	public ServiceImpl(AccountsDao accountDao, CustomerDao customerDao, EmployeeDao employeeDao, TransactionLogDao transactionLogDao) {
		this.accountDao = accountDao;
		this.customerDao = customerDao;
		this.employeeDao = employeeDao;
		this.transactionLogDao = transactionLogDao;
	}

	public ServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createAccount(Customer customer, User u) {
		return customerDao.insertCustomerDetails(u, customer);
	
	}

	@Override
	public List<Accounts> viewBalance(Accounts account, User u, Customer customer) {
		return accountDao.selectAccountDetails(u.getUsername(), account, customer);
		
	}

	@Override
	
	public boolean transferMoney(Customer customer, float deposit, User u, Accounts account) {
		return accountDao.updateAccountDeposit(u.getUsername(), customer, account, deposit);
		
	}

	@Override
	public boolean acceptMoney(float withdraw, User u, Customer customer, Accounts account) {
		
		if (account.getBalance() > withdraw) {
			return accountDao.updateAccountWithdraw(u.getUsername(), customer, account, withdraw);
		}else {
			return false;
		}
	}

	@Override
	public List<TransactionLog> viewTransactionLog(Accounts account, User u, Customer customer) {
		return transactionLogDao.selectTransactionList(account, u, customer);
		
	}

	@Override
	public List<TransactionLog> viewAllTransactionLog(User u) {
		return  transactionLogDao.selectAllTransactionList(u);
		
	}

	@Override
	public List<Accounts> viewAccounts(User u, Customer customer, Accounts account) {
		return accountDao.selectAccountDetails(u.getUsername(), account, customer);
		
	}


	@Override
	public boolean approveAccount(User u, Customer customer) {
		return employeeDao.approveUserAccount(u, customer);
		
	}

	

	@Override
	public boolean logDepositTransaction(Customer customer, float transferAmount, User u, Accounts account) {
		return transactionLogDao.insertDepositTransactionDetails(customer, transferAmount, u, account);
		
	}

	
	
	@Override
	public boolean logWithdrawalTransaction(Customer customer, float transferAmount, User u, Accounts account) {
		return transactionLogDao.insertWithdrawalTransactionDetails(customer, transferAmount, u, account);
		
	}

	@Override
	public boolean createCustomerAccount(Accounts account, User u, Customer customer) {
		return accountDao.insertCustomerAccount(account, u, customer);
	}

	@Override
	public boolean createUser(User u) {
		return userDao.insertUser(u);
	}
	
	
	
	

}
