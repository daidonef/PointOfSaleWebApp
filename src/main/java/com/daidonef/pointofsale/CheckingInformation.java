package com.daidonef.pointofsale;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.ui.Model;

public class CheckingInformation {
	
	//Shows when employee tries to login with an invalid username or password.
	public static String login(Model model) {
		
		model.addAttribute("wrongLogin", "Username or password is invalid!<br>"
				+ "Please try again!");
		
		return "login";
	}
	
	//Checks if the employee is logging in with correct username and password.
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
	
	//Return false when there are no customers with that username, and true when there are
	//one or more customers with that username.
	//Used to check if username is already in the system or not.
	public static boolean noCustomerAccount(String userName) {
		
		List<Account> accounts = DAOAccount.getAccount(Query.gettingAccount(userName));
		if (accounts.size() == 0) {
			return false;
		}
		
		return true;
	}
	
	//Returns true for when there are no customers with that username, and false when there
	//are one or more customers with that username.
	//Used to check if username is already in the system or not.
	public static boolean oneCustomerAccount(String userName) {
		
		List<Account> accounts = DAOAccount.getAccount(Query.gettingAccount(userName));
		if (accounts.size() == 0) {
			return true;
		}
		
		return false;
	}
	
	//Return false when there are no employee with that username, and true when there are
	//one or more employees with that username.
	//Used to check if username is already in the system or not.
	public static boolean noEmployee(String userName) {
		
		List<Employee> employees = DAOEmployee.getEmployee(Query.gettingEmployees(userName));
		if (employees.size() == 0) {
			return false;
		}
		
		return true;
	}
	
	//Returns true for when there are no products with that product number, and false when
	//there are one or more products with that product number.
	//Used to check if product number is already in the system or not.
	public static boolean oneProduct(int productNumber) {
		
		List<Product> products = DAOProduct.getProduct(Query.gettingProduct(productNumber));
		if (products.size() == 0) {
			return true;
		}
		
		return false;
	}
	
	//Returns false for when there are no products with that product name, and true when
	//there are one or more products with that product name.
	//Used to check if product name is already in the system or not.
	public static boolean oneProduct(String productName) {
		
		List<Product> products = DAOProduct.getProduct(Query.gettingProductByName(productName));
		if (products.size() == 0) {
			return false;
		}
		
		return true;
	}

}
