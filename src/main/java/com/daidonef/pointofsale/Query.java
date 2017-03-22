package com.daidonef.pointofsale;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class Query {
	
	public static String gettingEmployees(String un) {
		return "FROM Employee WHERE (username = '" + un + "')";
	}
	
	public static String gettingAccount(String un){
		return "FROM Account WHERE (username = '" + un + "')";
	}
	
	public static String gettingProduct(int productNumber){
		return "FROM Product WHERE (productid = " + productNumber + ")";
	}

}
