package com.revaturee.repo;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revaturee.models.Accounts;
import com.revaturee.models.Customer;
import com.revaturee.models.TransactionLog;
import com.revaturee.models.User;
import com.revaturee.util.ConnectionFactory;

public class TransactionLogDaoImpl implements TransactionLogDao{
	
	ConnectionFactory connectionFactory = new ConnectionFactory();

	//We will be passing Customer ID here
	@Override
	public boolean insertDepositTransactionDetails(Customer customer, float transferAmount, User u, Accounts account) {
		boolean success = false;
		
		
		String sql = "INSERT INTO TRANSACTION_LOG VALUES (?,?,?)";
		
		PreparedStatement ps;
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
						
			ps.setString(1, account.getAccountNumber());
			ps.setFloat(2, transferAmount);
			ps.setFloat(3, account.getBalance() + transferAmount);
		
			ps.execute();		
			
			success = true;
			
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
			
	}

	@Override
	public List<TransactionLog> selectTransactionList(String accountNumber, User u, Customer customer) {
		String sql = "SELECT * FROM TRANSACTION_LOG WHERE fk_user_name = ?";
		
				
		List<TransactionLog> transactionList = new ArrayList<>();
		
		try {
			Connection connection = connectionFactory.getConnection();
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, u.getUsername());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				transactionList.add(
						new TransactionLog(rs.getString("Account_Number"),
								rs.getFloat("Transfer_Amount"), 
								rs.getFloat("Amount"))
								
								
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transactionList;
		
	}

	

	@Override
	public List<TransactionLog> selectAllTransactionList(User u) {
		String sql = "SELECT * FROM TRANSACTION_LOG";
		
		
		List<TransactionLog> transactionList = new ArrayList<>();
		
		try {
			Connection connection = connectionFactory.getConnection();
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				transactionList.add(
						new TransactionLog(rs.getString("Account_Number"),
								rs.getFloat("Transfer_Amount"), 
								rs.getFloat("Amount"))
								
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transactionList;
		
			
	}

	@Override
	public boolean insertWithdrawalTransactionDetails(Customer customer, float transferAmount, User u, Accounts account) {
		boolean success = false;
		
		
		String sql = "INSERT INTO TRANSACTION_LOG VALUES (?,?,?)";
		
		PreparedStatement ps;
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
						
			ps.setString(1, account.getAccountNumber());
			ps.setFloat(2, transferAmount);
			ps.setFloat(3, account.getBalance() - transferAmount);
		
			ps.execute();		
			
			success = true;
			
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
		
	}

}
