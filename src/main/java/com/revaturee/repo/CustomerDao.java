package com.revaturee.repo;

import com.revaturee.models.Customer;

public interface CustomerDao {
	
	//create customer in table
	//boolean insertCustomerDetails(Customer customer);

	boolean insertDetailsByUsername(String username);

	int selectCustomerID(String username);
	//

}
