package com.revaturee.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revaturee.models.Accounts;
import com.revaturee.models.Customer;
import com.revaturee.models.TransactionLog;
import com.revaturee.models.User;
import com.revaturee.util.ConnectionFactory;

public class EmployeeDaoImpl implements EmployeeDao{
	
	ConnectionFactory connectionFactory = new ConnectionFactory();

	@Override
	public List<TransactionLog> selectTransactionLog(User u, Customer customer) {
		String sql = "SELECT * FROM TRANSACTION_LOG WHERE fk_user_name = ?";
		//Customer customer;
		List<TransactionLog> customerTransactionLog = new ArrayList<>();
		
		try {
			Connection connection = connectionFactory.getConnection();
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, u.getUsername());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				customerTransactionLog.add(
						new TransactionLog(rs.getString("Account_Number"),
								rs.getFloat("Transfer_Amount"), 
								rs.getFloat("Current_Amount"))
								
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customerTransactionLog;
		
	}
	
	
	
	@Override
	public boolean approveUserAccount(User u, Customer customer) {
		
		boolean success = false;
		
		
		String sql = "UPDATE CUSTOMER set Approval_Status_By_Employee = ? WHERE Customer_ID = ?";
		
		PreparedStatement ps;
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			ps.setBoolean(1, true);
			ps.setInt(2, customer.getCustomerId());
				
			ps.execute();		
			
			success = true;
			
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
		
		
		
	}

	@Override
	public List<Accounts> selectCustomerAccountList(User u, Customer customer) {
		String sql = "SELECT * FROM ACCOUNT_LIST WHERE fk_user_name = ?";
		//Customer customer;
		List<Accounts> accountList = new ArrayList<>();
		
		try {
			Connection connection = connectionFactory.getConnection();
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, u.getUsername());
			
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
		
	}

}
