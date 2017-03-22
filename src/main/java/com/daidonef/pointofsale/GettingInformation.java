package com.daidonef.pointofsale;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.ui.Model;

public class GettingInformation {
	
	public static String employee(String userName, String password,
			Model model, HttpSession session){
		
		List<Employee> employees = DAOEmployee.getEmployee(Query.gettingEmployees(userName));
		
		return CheckingInformation.employee(employees, password, model, session);
	}
	
	public static Account account(String userName, HttpServletRequest request) {
		
		return DAOAccount.getAccount(Query.gettingAccount(userName)).get(0);
	}
	
	public static String toOwnerPage() {
		return "<form name='ownerPage' action='ownerpage' method='post'>"
				+ "<br><input type='submit' value='OwnerPage'></form>";
	}
	
	public static Product product(int productNumber) {
		
		return DAOProduct.getProduct(Query.gettingProduct(productNumber)).get(0);
	}

}
