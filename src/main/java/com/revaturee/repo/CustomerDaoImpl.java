package com.revaturee.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revaturee.models.Accounts;
import com.revaturee.models.Customer;
import com.revaturee.models.User;
import com.revaturee.util.ConnectionFactory;

public class CustomerDaoImpl implements CustomerDao{
	
	ConnectionFactory connectionFactory = new ConnectionFactory();

	//insertDetailsByUsername(String username)
	@Override
	public boolean insertDetailsByUsername(String username) {
		
		Customer customer = new Customer();
		
		boolean success = false;
		
		
		
		String sql = "INSERT INTO CUSTOMER (CUSTOMER_NAME, CUSTOMER_PHONENUMBER, APPROVAL_STATUS_BY_EMPLOYEE, FK_USER_NAME)VALUES(?,?,?,?)";
		
		PreparedStatement ps;
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			//ps.setInt(1, customer.getCustomerId()); Need to remove if it works
			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getPhoneNumber());
			ps.setBoolean(3, false);
			ps.setString(4, username);
				
			ps.execute();		
			
			success = true;
			
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean insertCustomerDetails(User u, Customer customer) {
		
		boolean success = false;
		
		
		
		String sql = "INSERT INTO CUSTOMER (CUSTOMER_NAME, CUSTOMER_PHONENUMBER, APPROVAL_STATUS_BY_EMPLOYEE, FK_USER_NAME)VALUES(?,?,?,?)";
		
		PreparedStatement ps;
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			//ps.setInt(1, customer.getCustomerId()); Need to remove if it works
			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getPhoneNumber());
			ps.setBoolean(3, false);
			ps.setString(4, u.getUsername());
				
			ps.execute();		
			
			success = true;
			
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
		
	}

	//@Override
	//public int selectCustomerID(String username) {
		
		//int customerId = 0;
		
		//String sql = "SELECT CUSTOMER_ID FROM CUSTOMER WHERE fk_user_name = ?";
		//Customer customer;
		//List<Accounts> accountList = new ArrayList<>();
		
		//try {
			//Connection connection = connectionFactory.getConnection();
			
			//PreparedStatement ps = connection.prepareStatement(sql);
			
			//ps.setString(1, username);
			
			//ResultSet rs = ps.executeQuery();
			
			//while(rs.next()) {
				//customerId = rs.getInt("CUSTOMER_ID");
								
			//}
			
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		
		//return customerId;
	//}

		
		
}
