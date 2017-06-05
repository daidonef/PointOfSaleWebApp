package com.daidonef.pointofsale;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.ui.Model;

public class GettingInformation {
	
	//Gets the employees by username.
	public static String employee(String userName, String password,
			Model model, HttpSession session){
		
		List<Employee> employees = DAOEmployee.getEmployee(Query.gettingEmployees(userName));
		
		return CheckingInformation.employee(employees, password, model, session);
	}
	
	//Gets the customer account by username.
	public static Account account(String userName, HttpServletRequest request) {
		
		return DAOAccount.getAccount(Query.gettingAccount(userName)).get(0);
	}
	
	//The page link is for the owner or admin only.
	public static String toOwnerPage() {
		return "<form name='ownerPage' action='ownerpage' method='post'>"
				+ "<br><input type='submit' value='OwnerPage'></form>";
	}
	
	//Gets the product by product number.
	public static Product product(int productNumber) {
		
		return DAOProduct.getProduct(Query.gettingProduct(productNumber)).get(0);
	}
	
	//Gets the sub total for the products the customer is buying.
	public static double total (ArrayList<Product> products, ArrayList<Integer> quantity) {
		
		double total = 0;
		for (int i = 0; i < products.size(); i++) {
			total = total + (products.get(i).getPrice()) * (quantity.get(i));
		}	
		return BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	//Gets employee by employee number.
	public static Employee employee(HttpServletRequest request) {
		
		Employee employee = DAOEmployee.getEmployee(Query.gettingEmployeeByNumber(
				Integer.parseInt(request.getParameter("updateEmployee")))).get(0);
		
		return employee;	
	}
	
	//Creates cash object.
	public static Cash cash(HttpServletRequest request, HttpSession session) {
		
		Cash cash = new Cash((Double) session.getAttribute("total"), 
				Double.parseDouble(request.getParameter("customerCash")));
		
		return cash;
	}
	
	//Creates CreditCard object.
	public static CreditCard creditCard(HttpServletRequest request, HttpSession session) {
		
		 CreditCard creditCard = new CreditCard((Double) session.getAttribute(
				 "total"), Long.parseLong(request.getParameter("creditCardNumber")), 
				 Integer.parseInt(request.getParameter("securityCode")), date(request));
		
		return creditCard;
	}
	
	//Gets the date from the webpage and formates it into the Date Class.
	public static Date date(HttpServletRequest request) {
		
		String[] brokenDates = request.getParameter("date").split("/");
		Date date = new Date(Integer.parseInt(brokenDates[2]) - 1900, Integer.parseInt(
				brokenDates[0]) - 1, Integer.parseInt(brokenDates[1]));
		
		return date;
	}
	
	//Creates Check object.
	public static Check check(HttpServletRequest request, HttpSession session) {
		
		Check check = new Check((Double)session.getAttribute("total"), 
				Integer.parseInt(request.getParameter("checkNumber")), request.getParameter(
						"checkName"), date(request));
		
		return check;
	}
	
	//Gets AccountHistory by the accountID.
	public static List<AccountHistory> accountHistory(HttpSession session) {
		return DAOAccountHistory.getAccountHistory(Query.gettingAccountHistory(
				((Account)session.getAttribute("account")).getID()));
	}
	
	//Gets AHProduct (short of Account History Products) by the accountID.
	public static List<AHProducts> ahProducts(HttpSession session) {
		return DAOAHProducts.getAHProducts(Query.gettingAHProducts(
				((Account)session.getAttribute("account")).getID()));
	}

}
