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
	
	public static String gettingProductByName(String productName){
		return "FROM Product WHERE (productname = '" + productName + "')";
	}
	
	public static String searchingProduct(String productName){
		return "FROM Product WHERE (productname like '%" + productName + "%')";
	}
	
	public static String searchingEmployee(String employeeName){
		return "FROM Employee WHERE (firstname like '%" + employeeName 
				+ "%') or (lastname like '%" + employeeName + "%')";
	}
	
	public static String gettingEmployeeByNumber(int employeeNumber){
		return "FROM Employee WHERE (id = " + employeeNumber + ")";
	}
	
	public static String gettingAccountHistory(int accountID){
		return "FROM AccountHistory WHERE (accountid = " + accountID + ")";
	}
	
	public static String gettingAHProducts(int accountID){
		return "FROM AHProducts WHERE (accountid = " + accountID + ")";
	}

}
