package com.daidonef.pointofsale;

import java.util.ArrayList;
import java.util.Date;
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
	
	public static double total (ArrayList<Product> products, ArrayList<Integer> quantity) {
		
		double total = 0;
		for (int i = 0; i < products.size(); i++) {
			total = total + (products.get(i).getPrice()) * (quantity.get(i));
		}
		
		return total;
	}
	
	public static Employee employee(HttpServletRequest request) {
		
		Employee employee = DAOEmployee.getEmployee(Query.gettingEmployeeByNumber(
				Integer.parseInt(request.getParameter("updateEmployee")))).get(0);
		
		return employee;	
	}
	
	public static Cash cash(HttpServletRequest request, HttpSession session) {
		
		Cash cash = new Cash(Double.parseDouble((String) session.getAttribute("total")), 
				Double.parseDouble(request.getParameter("customerCash")));
		
		return cash;
	}
	
	public static CreditCard creditCard(HttpServletRequest request, HttpSession session) {
		
		 CreditCard creditCard = new CreditCard(Double.parseDouble((String)session.getAttribute(
				 "total")), Long.parseLong(request.getParameter("creditCardNumber")), 
				 Integer.parseInt(request.getParameter("securityCode")), date(request));
		
		return creditCard;
	}
	
	public static Date date(HttpServletRequest request) {
		
		String[] brokenDates = request.getParameter("date").split("/");
		//Date might have a problem, need to test.
		Date date = new Date(Integer.parseInt(brokenDates[2]), Integer.parseInt(brokenDates[0]),
				Integer.parseInt(brokenDates[1]));
		
		return date;
	}
	
	public static Check check(HttpServletRequest request, HttpSession session) {
		
		Check check = new Check(Double.parseDouble((String)session.getAttribute("total")), 
				Integer.parseInt(request.getParameter("checkNumber")), request.getParameter(
						"checkName"), date(request));
		
		return check;
	}

}
