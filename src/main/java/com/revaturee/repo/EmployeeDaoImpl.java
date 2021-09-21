package com.revaturee.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revaturee.models.Accounts;
import com.revaturee.models.TransactionLog;
import com.revaturee.util.ConnectionFactory;

public class EmployeeDaoImpl implements EmployeeDao{
	
	ConnectionFactory connectionFactory = new ConnectionFactory();

	@Override
	public List<TransactionLog> selectTransactionLog(int id) {
		String sql = "SELECT * FROM TRANSACTION_LOG WHERE fk_customer_ID = ?";
		//Customer customer;
		List<TransactionLog> customerTransactionLog = new ArrayList<>();
		
		try {
			Connection connection = connectionFactory.getConnection();
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				customerTransactionLog.add(
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
	
	
	
	@Override
	public boolean approveUserAccount(int id, boolean approval) {
		
		return false;
	}

	@Override
	public List<Accounts> selectCustomerAccountList(int id) {
		String sql = "SELECT * FROM ACCOUNT_LIST WHERE fk_customer_ID = ?";
		//Customer customer;
		List<Accounts> accountList = new ArrayList<>();
		
		try {
			Connection connection = connectionFactory.getConnection();
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				accountList.add(
						new Accounts(rs.getInt("Account_Number"),
								rs.getFloat("Balance"), 
								rs.getString("Account_Type"))
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accountList;
		return null;
	}

}
