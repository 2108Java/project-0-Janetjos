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
import com.revaturee.util.ConnectionFactory;

public class TransactionLogDaoImpl implements TransactionLogDao{
	
	ConnectionFactory connectionFactory = new ConnectionFactory();

	//We will be passing Customer ID here
	@Override
	public boolean insertTransactionDetails(TransactionLog log) {
		boolean success = false;
		
		
		String sql = "INSERT INTO TRANSACTION_LOG VALUES (?,?,?)";
		
		PreparedStatement ps;
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			LocalDate date = java.time.LocalDate.now();  
			
			ps.setInt(1, log.getFromAccountNumber());
			ps.setInt(2, log.getToAccountNumber());
			ps.setFloat(3, log.getAmount());
			ps.setDate(4, date);//Maybe try converting to String
			ps.execute();		
			
			success = true;
			
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
			
	}

	@Override
	public List<TransactionLog> selectTransactionList(int id) {
		String sql = "SELECT * FROM TRANSACTION_LOG WHERE fk_customer_ID = ?";
		
				
		List<TransactionLog> transactionList = new ArrayList<>();
		
		try {
			Connection connection = connectionFactory.getConnection();
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				transactionList.add(
						new TransactionLog(rs.getInt("From_Account_Number"),
								rs.getInt("To_Account_Number"), 
								rs.getFloat("Amount"),
								rs.getBoolean("Status"),
								rs.getFloat("Date"))
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accountList;
		
	}

}
