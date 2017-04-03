package com.daidonef.pointofsale;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.ui.Model;

public class CheckingInformation {
	
	public static String login(Model model) {
		
		model.addAttribute("wrongLogin", "Username or password is invalid!<br>"
				+ "Please try again!");
		
		return "login";
	}
	
	public static String employee(List<Employee> employees, 
			String password, Model model, HttpSession session) {
		if (employees.size() == 0) {
			return login(model);
		}
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		Employee employee = employees.get(0);
		
		if (passwordEncryptor.checkPassword(password, employee.getPassword())) {
			session.setAttribute("employee", employee);
			
			if (employee.getUserName().equals("Admin")) {
				model.addAttribute("owner", GettingInformation.toOwnerPage());
			}
			return "searchcustomer";
		}
		
		return login(model);
	}
	
	public static boolean noCustomerAccount(String userName) {
		
		List<Account> accounts = DAOAccount.getAccount(Query.gettingAccount(userName));
		if (accounts.size() == 0) {
			return false;
		}
		
		return true;
	}
	
	public static boolean oneCustomerAccount(String userName) {
		
		List<Account> accounts = DAOAccount.getAccount(Query.gettingAccount(userName));
		if (accounts.size() == 0) {
			return true;
		}
		
		return false;
	}
	
	public static boolean noEmployee(String userName) {
		
		List<Employee> employees = DAOEmployee.getEmployee(Query.gettingEmployees(userName));
		if (employees.size() == 0) {
			return false;
		}
		
		return true;
	}
	
	public static boolean oneProduct(int productNumber) {
		
		List<Product> products = DAOProduct.getProduct(Query.gettingProduct(productNumber));
		if (products.size() == 0) {
			return true;
		}
		
		return false;
	}
	
	public static boolean oneProduct(String productName) {
		
		List<Product> products = DAOProduct.getProduct(Query.gettingProductByName(productName));
		if (products.size() == 0) {
			return false;
		}
		
		return true;
	}

}
