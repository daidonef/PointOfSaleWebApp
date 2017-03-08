package com.daidonef.pointofsale;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class Query {
	
	public static String gettingEmployees(String un) {
		return "FROM Employee WHERE (username = '" + un + "')";
	}

}
