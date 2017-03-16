package com.daidonef.pointofsale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		
		request.getSession(true).invalidate();
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		
		request.getSession(true).invalidate();
		
		return "login";
	}
	
	@RequestMapping(value = "/searchcustomer", method = RequestMethod.POST)
	public String searchCustomer(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("employee") == null) {
			
			if(request.getParameter("userName") == null) {
				return CheckingInformation.login(model);
			} else {
				return GettingInformation.employee(request.getParameter("userName"), 
						request.getParameter("password"), model, session);
			}
		}
		
		Employee employee = (Employee)session.getAttribute("employee");
		if (employee.getUserName().equals("Admin")) {
			model.addAttribute("owner", GettingInformation.toOwnerPage());
		}
		
		return "searchcustomer";
		
	}
	
	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public String addCustomer(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		if (session.getAttribute("employee") ==  null) {
			return "login";
		}
		
		return "addcustomer";
	}
	
	@RequestMapping(value = "/inputproduct", method = RequestMethod.POST)
	public String inputProduct(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		if (session.getAttribute("employee") ==  null) {
			return "login";
		}
		
		Account account;
		
		if (session.getAttribute("account") == null) {
		
			if (request.getParameter("search") == null) {
				if (CheckingInformation.noCustomerAccount(request.getParameter("userName"))) {
					return "addcustomer";
				}
				account = SavingInformation.newAccount(request);
				DAOAccount.addAccount(account);
				session.setAttribute("account", account);
			} else {
				if (CheckingInformation.oneCustomerAccount(request.getParameter("userName"))) {
					model.addAttribute("notFound", "Customer not found!<br>Please try again!");
					return "searchCustomer";
				}
				account = GettingInformation.account(request.getParameter("userName"), request);
				session.setAttribute("account", account);
			}
		}
		//To add different products store the information in an ArrayList and put that
		//ArrayList in a session and then adding it to the ArrayList and adding it to
		//a Table in the jsp.
		//Storing it in the database only should happen when they chick total.
		//Need to clear the ArrayList after it is stored.
		
		return "inputproduct";
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String payment(Model model) {
		
		
		
		return "payment";
	}
	
	@RequestMapping(value = "/receipt", method = RequestMethod.POST)
	public String receipt(Model model) {
		
		return "receipt";
	}
	
	//Add way for owner to update and delete employees.
	@RequestMapping(value = "/ownerpage", method = RequestMethod.POST)
	public String ownerPage(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		
		if (request.getParameter("userName") != null) {
			if (CheckingInformation.noEmployee(request.getParameter("userName"))) {
				model.addAttribute("employed", "User Name for New Employee already exist!<br>"
						+ "Please try another User Name!");
				return "ownerpage";
			}
			Employee employee = SavingInformation.newEmployee(request);
			DAOEmployee.addEmployee(employee);
			
			model.addAttribute("employee", employee);
		}
		
		return "ownerpage";
	}
	
}