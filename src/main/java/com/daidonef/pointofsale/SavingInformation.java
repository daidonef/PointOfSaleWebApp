package com.daidonef.pointofsale;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.ui.Model;

public class SavingInformation {
	
	//Puts the variables to create a new Account.
	public static Account newAccount(HttpServletRequest request) {
		
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String password = passwordEncryptor.encryptPassword(request.getParameter("password"));
		
		Account account = new Account(request.getParameter("userName"), 
				request.getParameter("firstName"), request.getParameter("lastName"), password, 
				Long.parseLong(GettingInformation.replacePhoneNumber(request.getParameter(
						"phoneNumber"))), 
				request.getParameter("email"));
		
		return account;
	}
	
	//Puts the variables to create a new Employee.
	public static Employee newEmployee(HttpServletRequest request) {
		
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String password = passwordEncryptor.encryptPassword(request.getParameter("password"));
		
		Employee employee = new Employee(request.getParameter("userName"), 
				request.getParameter("firstName"), request.getParameter("lastName"), password, 
				Long.parseLong(GettingInformation.replacePhoneNumber(request.getParameter(
						"phoneNumber"))), 
				request.getParameter("email"));
		
		return employee;
	}
	
	//Adds products and the quantity of each that the customer is buying.
	public static void addProduct(Model model, HttpServletRequest request, HttpSession session) {
		
		ArrayList<Product> products;
		ArrayList<Integer> quantity;
		//For when there is already a product list started.
		if (session.getAttribute("product") != null) {
			products = (ArrayList<Product>) session.getAttribute("product");
			quantity = (ArrayList<Integer>) session.getAttribute("quantity");
			products.add(GettingInformation.product(Integer.parseInt(request.getParameter(
					"productNumber"))));
			quantity.add(Integer.parseInt(request.getParameter("quantity")));
		//Starts a new product list only when one is not already started.
		} else {
			products = new ArrayList<Product>();
			products.add(GettingInformation.product(Integer.parseInt(request.getParameter(
				"productNumber"))));
			quantity = new ArrayList<Integer>();
			int quan = Integer.parseInt(request.getParameter("quantity"));
			quantity.add(quan);
		}
		
		//Use session to store product and quantity list and displays totals and tax.
		storeTotalInfo(model, session, products, quantity);
	}
	
	//Use session to store product and quantity list and displays totals and tax.
	private static void storeTotalInfo (Model model, HttpSession session, 
			ArrayList<Product> products, ArrayList<Integer> quantity) {
		
		session.setAttribute("product", products);
		session.setAttribute("quantity", quantity);
		model.addAttribute("products", products);
		model.addAttribute("quantities", quantity);
		session.setAttribute("total", GettingInformation.total(products, quantity));
		model.addAttribute("total", session.getAttribute("total"));
		model.addAttribute("tax", GettingInformation.tax(session));
		model.addAttribute("grandTotal", GettingInformation.grandTotal(session));
		
	}
	
	//Adds new product to database.
	public static Product addProductToData(HttpServletRequest request) {
		
		Product product = new Product(request.getParameter("productName"), 
				Double.parseDouble(request.getParameter("price")), request.getParameter("type"),
				request.getParameter("description"));
		
		DAOProduct.addProduct(product);
		
		return product;
	}
	
	//Updates product to database.
	public static Product updateProduct(HttpServletRequest request) {
		
		Product product = new Product(Integer.parseInt(request.getParameter("productID")), 
				request.getParameter("productNameUp"), Double.parseDouble(request.getParameter("price")), 
				request.getParameter("type"), request.getParameter("description"));
		
		DAOProduct.updateProduct(product);
		
		return product;
	}
	
	//Updates employee information to database.
	public static Employee updateEmployee(HttpServletRequest request) {
		
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String password = passwordEncryptor.encryptPassword(request.getParameter("password"));
		
		Employee employee = new Employee(Integer.parseInt(request.getParameter("employeeID")), 
				request.getParameter("userNameUp"), request.getParameter("firstName"), 
				request.getParameter("lastName"), password, Long.parseLong(
						GettingInformation.replacePhoneNumber(request.getParameter("phoneNumber"))), 
				request.getParameter("email"));
		
		DAOEmployee.updateEmployee(employee);
		
		return employee;
	}
	
	//Adds AccountHistory to database for cash payment.
	public static Cash paymentCash(HttpServletRequest request, HttpSession session) {
		
		Account account = (Account) session.getAttribute("account");
		Cash cash = GettingInformation.cash(request, session);
		Date todayDate = new Date();
		
		AccountHistory accountHistory = new AccountHistory(account.getID(), todayDate, 
				cash.getTotal(), (String)session.getAttribute("paymentType"), cash.getCash(), 
				cash.getChange());
		
		saveAccountHistory(accountHistory, session);
		
		return cash;
	}
	
	//Adds AccountHistory to database for credit card payment.
	public static CreditCard paymentCreditCard(HttpServletRequest request, HttpSession session) {
		
		Account account = (Account) session.getAttribute("account");
		CreditCard creditCard = GettingInformation.creditCard(request, session);
		Date todayDate = new Date();
		
		AccountHistory accountHistory = new AccountHistory(account.getID(), todayDate, 
				creditCard.getTotal(), (String)session.getAttribute("paymentType"), 
				creditCard.getDate(), creditCard.getCreditCardNumber(), 
				creditCard.getSecurityCode());
		
		saveAccountHistory(accountHistory, session);
		
		return creditCard;
	}
	
	//Adds AccountHistory to database for check payment.
	public static Check paymentCheck(HttpServletRequest request, HttpSession session) {
		
		Account account = (Account) session.getAttribute("account");
		Check check = GettingInformation.check(request, session);
		Date todayDate = new Date();
		
		AccountHistory accountHistory = new AccountHistory(account.getID(), todayDate, 
				check.getTotal(), (String)session.getAttribute("paymentType"), 
				check.getCheckNumber());
		
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
