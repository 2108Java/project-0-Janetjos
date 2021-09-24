package com.revaturee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.revaturee.models.Accounts;
import com.revaturee.models.Customer;
import com.revaturee.models.User;
import com.revaturee.service.Service;
import com.revaturee.service.ServiceImpl;

public class BankTest {
	
	boolean transactionStatus = false;
	User u = new User("Testuser","Testpass4");
	Customer c = new Customer(100,"TestName", "1345678");
	
	Service service = new ServiceImpl();
	//BankTest bankTest = new BankTest();
	
	Accounts account = new Accounts(1234, (float) 1000.00, "Savings");
	
	
@Test

	public void testCreateAccount() {
	
	boolean result = service.createAccount(c,u);
	
	assertEquals(true, result);
	
	}

	
@Test
	public void testCustomerAccountCreation() {
		
		boolean result = service.createCustomerAccount(account, u, c);
		
		assertEquals(true, result);
		
	}

	@Test
	public void testDeposit() {
		float deposit = (float)100.00;
		boolean result = service.transferMoney(c, deposit, u, account);
		transactionStatus = service.logDepositTransaction(c, deposit, u, account);
		assertEquals(true, result);
		
	}
	
	@Test
	public void testDepositInAccount() {
		float temp = (float)1100.00;
		float tempTwo = (float)account.getBalance();
		assertEquals(temp, tempTwo);
		
	}
	
	
	@Test
	public void checkTransactionLogStatus() {
		assertEquals(true, transactionStatus);
	}
	
	@Test
	public void testWithdraw() {
		float withdraw = (float)10.00;
		boolean result = service.acceptMoney(withdraw, u, c, account);
		assertEquals(true, result);
	}
	
	@Test
	public void testWithdrawInAccount() {
		float temp = (float) 1090.00;
		float tempTwo = account.getBalance();
		assertEquals(temp, tempTwo);
	}
	
	@Test
	public void testApproveAccount() {
		boolean result = service.approveAccount(u, c);
		assertEquals(true, result);
	}
	
	@Test
	public void testWithdrawFail() {
		float withdraw = (float)2100.00;
		boolean result = service.acceptMoney(withdraw, u, c, account);
		assertEquals(false, result);
	}
	
	@Test
	public void checkWithdrawFail() {
		float temp = (float) 1090.00;
		float tempTwo = account.getBalance();
		assertEquals(temp, tempTwo);		
	}
	
	
	
	
	
	
	
	


}
