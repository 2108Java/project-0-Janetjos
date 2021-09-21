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

public class AccountsDaoImpl implements AccountsDao{
	Accounts account = new Accounts();
	
	ConnectionFactory connectionFactory = new ConnectionFactory();

	//CHECK return type, input and DAO connection
	@Override
	public boolean insertAccountByCustomerID(int customerID) {
		boolean success = false;
		
				
		String sql = "INSERT INTO ACCOUNT_LIST VALUES (?,?,?) WHERE fk_customer_ID = ?";//Implement starting balance
		
		PreparedStatement ps;
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			ps.setInt(1, account.getAccountNumber());
			ps.setFloat(2, account.getBalance());
			ps.setString(3, account.getAccountType());
			ps.setInt(4, customerID);			
				
			ps.execute();		
			
			success = true;
			
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
		
	}
	
	
	

	@Override
	public List<Accounts> selectAccountDetails(int id) {
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
		
	}
	
	//Take care of functionality in the service layer, pass in both ID and final balance value

	@Override
	public boolean updateAccountDeposit(int id, float newBalance) {
		boolean success = false;
		
		
		String sql = "UPDATE ACCOUNT_LIST SET BALANCE = ? WHERE fk_customer_ID = ?";//Implement starting balance
		
		PreparedStatement ps;
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			ps.setFloat(1, newBalance);
			ps.setInt(2, id);
				
			ps.execute();		
			
			success = true;
			
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
		
				
	}
	
	//Take care of functionality in the service layer, pass in both ID and final balance value. See if we can combine the above two methods

	@Override
	public boolean updateAccountWithdraw(int id, float newBalance) {
		boolean success = false;
		
		
		String sql = "UPDATE ACCOUNT_LIST SET BALANCE = ? WHERE fk_customer_ID = ?";//Implement starting balance
		
		PreparedStatement ps;
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			ps.setFloat(1, newBalance);
			ps.setInt(2, id);
				
			ps.execute();		
			
			success = true;
			
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
		
		
		
	}
	
	//Don't think it belongs in this Implementation

	@Override
	public void updateMoneyTransfer() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
