package com.revaturee;


import com.revaturee.repo.CustomerDao;
import com.revaturee.repo.CustomerDaoImpl;
import com.revaturee.repo.UserDao;
import com.revaturee.repo.UserDaoImpl;
import com.revaturee.service.Authenticate;
import com.revaturee.service.AuthenticateImpl;
import com.revaturee.views.Presentation;
import com.revaturee.views.PresentationImpl;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDao uDao = new UserDaoImpl();
		CustomerDao customerDao = new CustomerDaoImpl();
		
		Authenticate auth = new AuthenticateImpl(uDao,customerDao);
		
		Presentation presentation = new PresentationImpl(auth);
		
		
		//Presentation presentation = new PresentationImpl();
		presentation.display();

	}

}
