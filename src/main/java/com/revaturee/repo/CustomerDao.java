package com.revaturee.repo;

import com.revaturee.models.Customer;
import com.revaturee.models.User;

public interface CustomerDao {
	
	//create customer in table
	//boolean insertCustomerDetails(Customer customer);

	boolean insertDetailsByUsername(String username);
	
	boolean insertCustomerDetails(User u, Customer customer);

	//int selectCustomerID(String username);
	//

}
