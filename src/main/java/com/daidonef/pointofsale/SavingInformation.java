package com.daidonef.pointofsale;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.ui.Model;

public class SavingInformation {
	
	public static Account newAccount(HttpServletRequest request) {
		
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String password = passwordEncryptor.encryptPassword(request.getParameter("password"));
		
		Account account = new Account(request.getParameter("userName"), 
				request.getParameter("firstName"), request.getParameter("lastName"), password, 
				Long.parseLong(request.getParameter("phoneNumber")), 
				request.getParameter("email"));
		
		return account;
	}
	
	public static Employee newEmployee(HttpServletRequest request) {
		
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String password = passwordEncryptor.encryptPassword(request.getParameter("password"));
		
		Employee employee = new Employee(request.getParameter("userName"), 
				request.getParameter("firstName"), request.getParameter("lastName"), password, 
				Long.parseLong(request.getParameter("phoneNumber")), 
				request.getParameter("email"));
		
		return employee;
	}
	
	public static void addProduct(Model model, HttpServletRequest request, HttpSession session) {
		
		ArrayList<Product> products;
		ArrayList<Integer> quantity;
		if (session.getAttribute("product") != null) {
			products = (ArrayList<Product>) session.getAttribute("product");
			quantity = (ArrayList<Integer>) session.getAttribute("quantity");
		} else {
			products = null;
			quantity = null;
		}
		
		products.add(GettingInformation.product(Integer.parseInt(request.getParameter(
				"productNumber"))));
		quantity.add(Integer.parseInt(request.getParameter("quantity")));
		
		session.setAttribute("product", products);
		session.setAttribute("quantity", quantity);
		model.addAttribute("product", products);
		model.addAttribute("quantity", quantity);
	}
	
	public static Product addProductToData(HttpServletRequest request) {
		
		Product product = new Product(request.getParameter("productName"), 
				Double.parseDouble(request.getParameter("price")), request.getParameter("type"),
				request.getParameter("description"));
		
		DAOProduct.addProduct(product);
		
		return product;
	}

}
