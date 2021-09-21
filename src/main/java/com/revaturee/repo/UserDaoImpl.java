package com.revaturee.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revaturee.models.User;
import com.revaturee.util.ConnectionFactory;

public class UserDaoImpl implements UserDao{
	
	ConnectionFactory connectionFactory;

	@Override
	public User selectUserByUsername(String username) {
		String sql = "SELECT * FROM users_table where username = ?";
		
		PreparedStatement ps;
		User u = null;
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

}
