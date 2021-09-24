package com.revaturee.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revaturee.models.User;
import com.revaturee.util.ConnectionFactory;

public class UserDaoImpl implements UserDao{
	
	ConnectionFactory connectionFactory = new ConnectionFactory();

	@Override
	public User selectUserByUsername(String username) {
		String sql = "SELECT * FROM users_table where username = ?";
		
		PreparedStatement ps;
		User u = new User();
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//u.setId(rs.getInt("user_ID"));
				//u.setName(rs.getInt("user_name"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				
			}
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public boolean insertUser(User u) {
		boolean success = false;
		
		
		String sql = "INSERT INTO USERS_TABLE VALUES (?,?)";
		
		PreparedStatement ps;
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());			
				
			ps.execute();		
			
			success = true;
			
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
		
	}

}
