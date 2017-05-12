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
			//Test to see if the ArrayList can be greater than 10.
			products = (ArrayList<Product>) session.getAttribute("product");
			quantity = (ArrayList<Integer>) session.getAttribute("quantity");
			products.add(GettingInformation.product(Integer.parseInt(request.getParameter(
					"productNumber"))));
			quantity.add(Integer.parseInt(request.getParameter("quantity")));
		} else {
			products = new ArrayList<Product>();
			products.add(GettingInformation.product(Integer.parseInt(request.getParameter(
				"productNumber"))));
			quantity = new ArrayList<Integer>();
			int quan = Integer.parseInt(request.getParameter("quantity"));
			quantity.add(quan);
		}
		
		session.setAttribute("product", products);
		session.setAttribute("quantity", quantity);
		model.addAttribute("products", products);
		model.addAttribute("quantities", quantity);
		session.setAttribute("total", GettingInformation.total(products, quantity));
		model.addAttribute("total", session.getAttribute("total"));
	}
	
	public static Product addProductToData(HttpServletRequest request) {
		
		Product product = new Product(request.getParameter("productName"), 
				Double.parseDouble(request.getParameter("price")), request.getParameter("type"),
				request.getParameter("description"));
		
		DAOProduct.addProduct(product);
		
		return product;
	}
	
	public static Product updateProduct(HttpServletRequest request) {
		
		Product product = new Product(Integer.parseInt(request.getParameter("productID")), 
				request.getParameter("productNameUp"), Double.parseDouble(request.getParameter("price")), 
				request.getParameter("type"), request.getParameter("description"));
		
		DAOProduct.updateProduct(product);
		
		return product;
	}
	
	public static Employee updateEmployee(HttpServletRequest request) {
		
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String password = passwordEncryptor.encryptPassword(request.getParameter("password"));
		
		Employee employee = new Employee(Integer.parseInt(request.getParameter("employeeID")), 
				request.getParameter("userNameUp"), request.getParameter("firstName"), 
				request.getParameter("lastName"), password, Long.parseLong(request.getParameter("phoneNumber")), 
				request.getParameter("email"));
		
		DAOEmployee.updateEmployee(employee);
		
		return employee;
	}
	
	public static Cash paymentCash(HttpServletRequest request, HttpSession session) {
		
		Account account = (Account) session.getAttribute("account");
		Cash cash = GettingInformation.cash(request, session);
		
		AccountHistory accountHistory = new AccountHistory(account.getID(), cash.getTotal(),
				(String)session.getAttribute("paymentType"), cash.getCash(), cash.getChange());
		
		saveAccountHistory(accountHistory, session);
		
		return cash;
	}
	
	public static CreditCard paymentCreditCard(HttpServletRequest request, HttpSession session) {
		
		Account account = (Account) session.getAttribute("account");
		CreditCard creditCard = GettingInformation.creditCard(request, session);
		
		AccountHistory accountHistory = new AccountHistory(account.getID(), creditCard.getTotal(),
				(String)session.getAttribute("paymentType"), creditCard.getCreditCardNumber(),
				creditCard.getSecurityCode());
		
		saveAccountHistory(accountHistory, session);
		
		return creditCard;
	}
	
	public static Check paymentCheck(HttpServletRequest request, HttpSession session) {
		
		Account account = (Account) session.getAttribute("account");
		Check check = GettingInformation.check(request, session);
		
		AccountHistory accountHistory = new AccountHistory(account.getID(), check.getTotal(),
				(String)session.getAttribute("paymentType"), check.getCheckNumber());
		
		saveAccountHistory(accountHistory, session);
		
		return check;
	}
	
	//Stores info for each products customer buys with that account history.
	public static void saveAccountHistory(AccountHistory accountHistory, HttpSession session) {
		
		int historyID = DAOAccountHistory.addAccountHistory(accountHistory);
		ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("product");
		ArrayList<Integer> quantities = (ArrayList<Integer>) session.getAttribute("quantity");
		
		for(int i=0; i<products.size(); i++) {
			Product product = products.get(i);
			AHProducts ahProducts = new AHProducts(historyID, 
					((Account)session.getAttribute("account")).getID(), product.getProductID(), 
					product.getProductName(), product.getPrice(), quantities.get(i));
			DAOAHProducts.addAHProducts(ahProducts);
		}
	
	}

}
