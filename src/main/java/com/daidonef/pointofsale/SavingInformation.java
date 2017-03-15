package com.daidonef.pointofsale;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class SavingInformation {
	
	public static Account newAccount(HttpServletRequest request) {
		
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String password = passwordEncryptor.encryptPassword(request.getParameter("password"));
		
		Account account = new Account(request.getParameter("userName"), 
				request.getParameter("firstName"), request.getParameter("lastName"), password, 
				Integer.parseInt(request.getParameter("phoneNumber")), 
				request.getParameter("email"));
		
		return account;
	}

}
