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
	//Accounts account = new Accounts();
	
	ConnectionFactory connectionFactory = new ConnectionFactory();

	//CHECK return type, input and DAO connection
	@Override
	public boolean insertCustomerAccount(Accounts account, User u, Customer customer) {
		boolean success = false;
		
				
		String sql = "INSERT INTO ACCOUNT_LIST (Balance,Account_Type,fk_user_name) VALUES (cast(? as float), ?,?);";
		
		PreparedStatement ps;
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			ps.setFloat(1, (float) 1000.00);
			ps.setString(2, account.getAccountType());
			ps.setString(3, u.getUsername());			
				
			ps.execute();		
			
			success = true;
			
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
		
	}
	
	
	

	@Override
	public List<Accounts> selectAccountDetails(String username, Accounts account, Customer customer) {
		String sql = "SELECT * FROM ACCOUNT_LIST WHERE fk_user_name = ?";
		
		List<Accounts> accountList = new ArrayList<>();
		
		try {
			Connection connection = connectionFactory.getConnection();
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, username);
			
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
	
	

	@Override
	public boolean updateAccountDeposit(String username, Customer customer, Accounts account, float deposit) {
		boolean success = false;
		
		
		String sql = "UPDATE ACCOUNT_LIST SET BALANCE = ? WHERE ACCOUNT_NUMBER = ?";
		
		PreparedStatement ps;
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			ps.setFloat(1, account.getBalance() + deposit);
			ps.setInt(2, account.getAccountNumber());
				
			ps.execute();		
			
			success = true;
			
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
		
				
	}
	
	

	@Override
	public boolean updateAccountWithdraw(String username, Customer customer, Accounts account, float withdraw) {
		boolean success = false;
		
		
		String sql = "UPDATE ACCOUNT_LIST SET BALANCE = ? WHERE ACCOUNT_NUMBER = ?";
		
		PreparedStatement ps;
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			ps.setFloat(1, account.getBalance() - withdraw);
			ps.setInt(2, account.getAccountNumber());
			
			ps.execute();		
			
			success = true;
			
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
		
		
		
	}
	
	
	
	

}
