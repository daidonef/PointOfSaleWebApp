package com.daidonef.pointofsale;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		//Sets these session variables to null for a new customer, but keeps employee
		//logged in.
		session.setAttribute("account", null);
		session.setAttribute("total", null);
		session.setAttribute("product", null);
		
		//Only happens when employee is not already logged in.
		if (session.getAttribute("employee") == null) {
			
			if(request.getParameter("userName") == null) {
				return CheckingInformation.login(model);
			} else {
				return GettingInformation.employee(request.getParameter("userName"), 
						request.getParameter("password"), model, session);
			}
		}
		
		//For when the admin is logged in, will allow admin to another page for adding, 
		//deleting, or changing information within the database.
		if (((Employee)session.getAttribute("employee")).getUserName().equals("Admin")) {
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
		
		//Getting the user account.
		if (session.getAttribute("account") == null) {
			//For when customers are being added to the database.
			if (request.getParameter("search") == null) {
				//Used to see if username inputed by customer is already in the database, and
				//if so customer will need to pick another username.
				if (CheckingInformation.noCustomerAccount(request.getParameter("userName"))) {
					return "addcustomer";
				}
				//Adds new customer to the database.
				account = SavingInformation.newAccount(request);
				DAOAccount.addAccount(account);
				account = DAOAccount.getAccount(Query.gettingAccount(account.getUserName()))
						.get(0);
				session.setAttribute("account", account);
			//When searching for a customer already in the database.
			} else {
				//For when the customer is not found within the database.
				if (CheckingInformation.oneCustomerAccount(request.getParameter("search"))) {
					model.addAttribute("notFound", "Customer not found!<br>Please try again!");
					return "searchcustomer";
				}
				account = GettingInformation.account(request.getParameter("search"), request);
				session.setAttribute("account", account);
			}
		}
		
		//Getting the products and quantities stored that the customer wants to buy.
		if (request.getParameter("productNumber") != null) {
			if (CheckingInformation.oneProduct(Integer.parseInt(request.getParameter(
					"productNumber")))){
				model.addAttribute("wrongProduct", "You entered the wrong product.");
				return "inputproduct";
			}
			SavingInformation.addProduct(model, request, session);
		}
		
		return "inputproduct";
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String payment(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		if (session.getAttribute("employee") ==  null) {
			return "login";
		}
		
		if(session.getAttribute("total") == null) {
			return "inputproduct";
		}
		
		if (request.getParameter("paymentType") != null) {
			
			session.setAttribute("paymentType", request.getParameter("paymentType"));
			
			if (request.getParameter("paymentType").equals("cash")) {
				DisplayingInformation.cashForm(model);
			}
		
			if (request.getParameter("paymentType").equals("creditCard")) {
				DisplayingInformation.creditCardForm(model);
			}
		
			if (request.getParameter("paymentType").equals("check")) {
				DisplayingInformation.checkForm(model);
			}
		}
		model.addAttribute("subTotal", session.getAttribute("total"));
		model.addAttribute("tax", GettingInformation.tax(session));
		model.addAttribute("grandTotal", GettingInformation.grandTotal(session));
		
		return "payment";
	}
	
	@RequestMapping(value = "/receipt", method = RequestMethod.POST)
	public String receipt(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		if (session.getAttribute("employee") ==  null) {
			return "login";
		}
		
		if (request.getParameter("customerCash") != null) {
			
			if (GettingInformation.cash(request, session).incorrectAmount()) {
				DisplayingInformation.incorrectCashPayment(model);
				model.addAttribute("subTotal", session.getAttribute("total"));
				return "payment";
			}
			model.addAttribute("cash", SavingInformation.paymentCash(request, session));
			model.addAttribute("cashCash", "<br>Cash: ");
			model.addAttribute("changeCash", "<br>Change: ");
		}
		
		if (request.getParameter("creditCardNumber") != null) {
			if (GettingInformation.creditCard(request, session).incorrectDate()) {
				DisplayingInformation.incorrectCreditCardPayment(model);
				model.addAttribute("subTotal", session.getAttribute("total"));
				return "payment";
			}
			model.addAttribute("creditCard", SavingInformation.paymentCreditCard(
					request, session));
			model.addAttribute("creditCardCode", "<br>Security Code: ");
		}
		
		if (request.getParameter("checkNumber") != null) {
			if (GettingInformation.check(request, session).incorrectCheck(
					(Account)session.getAttribute("account")) || GettingInformation.check(
							request, session).incorrectDate()) {
				DisplayingInformation.incorrectCheckPayment(model);
				model.addAttribute("subTotal", session.getAttribute("total"));
				return "payment";
			}
			model.addAttribute("check", SavingInformation.paymentCheck(request, session));
			model.addAttribute("checkNumber", "<br>Check Number: ");
		}
		
		model.addAttribute("products", session.getAttribute("product"));
		model.addAttribute("quantities", session.getAttribute("quantity"));
		
		return "receipt";
	}
	
	@RequestMapping(value = "/ownerpage", method = RequestMethod.POST)
	public String ownerPage(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		Employee owner = (Employee) session.getAttribute("employee");
		
		//For the owner only, can change or add owner username to code.
		if (owner.getUserName().equals("Admin")) {
			
		} else {
			return "home";
		}
		
		if (request.getParameter("productName") != null) {
			if (CheckingInformation.oneProduct(request.getParameter("productName"))) {
				model.addAttribute("productExist", "Product is already in the system!");
				return "ownerpage";
			}
			model.addAttribute("productAdded", SavingInformation.addProductToData(request)
					.getProductName());
			model.addAttribute("productAdded2", " product was added");
			return "ownerpage";
		}
		
		if (request.getParameter("searchProduct") != null) {
			model.addAttribute("products", DAOProduct.getProduct(Query.searchingProduct(
					request.getParameter("searchProduct"))));
		}
		
		if (request.getParameter("productID") != null) {
			model.addAttribute("productUpdated", SavingInformation.updateProduct(request));
			model.addAttribute("productUpdated2", " Product Updated");
		}
		
		if (request.getParameter("deleteProduct") != null) {
			model.addAttribute("productDeleted", DAOProduct.deleteProduct(Integer.parseInt(
					request.getParameter("deleteProduct"))));
			model.addAttribute("productDeleted2", " Product Deleted");
		}
		
		if (request.getParameter("searchEmployee") != null) {
			model.addAttribute("employees", DAOEmployee.getEmployee(Query.searchingEmployee(
					request.getParameter("searchEmployee"))));
		}
		
		if (request.getParameter("employeeID") != null) {
			model.addAttribute("employeeUpdated", SavingInformation.updateEmployee(request));
			model.addAttribute("employeeUpdated2", " Employee Updated");
		}
		
		if (request.getParameter("deleteEmployee") != null) {
			model.addAttribute("employeeDeleted", DAOEmployee.deleteEmployee(Integer.parseInt(
					request.getParameter("deleteEmployee"))));
			model.addAttribute("employeeDeleted2", " Employee Deleted");
		}
		
		if (request.getParameter("userName") != null) {
			if (CheckingInformation.noEmployee(request.getParameter("userName"))) {
				model.addAttribute("employed", "User Name for New Employee already exist!<br>"
						+ "Please try another User Name!");
				return "ownerpage";
			}
			Employee employee = SavingInformation.newEmployee(request);
			DAOEmployee.addEmployee(employee);
			
			model.addAttribute("employee", employee);
			model.addAttribute("employee2", " employee added");
		}
		
		return "ownerpage";
	}
	
	@RequestMapping(value = "/updateproduct", method = RequestMethod.POST)
	public String updateProduct(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		Employee owner = (Employee) session.getAttribute("employee");
		
		if (owner.getUserName().equals("Admin")) {
			
		} else {
			return "home";
		}
		
		model.addAttribute("product", GettingInformation.product(Integer.parseInt(
				request.getParameter("updateProduct"))));
		
		return "updateproduct";
	}
	
	@RequestMapping(value = "/updateemployee", method = RequestMethod.POST)
	public String updateEmployee(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		Employee owner = (Employee) session.getAttribute("employee");
		
		if (owner.getUserName().equals("Admin")) {
			
		} else {
			return "home";
		}
		
		model.addAttribute("employee", GettingInformation.employee(request));
		
		return "updateemployee";
	}
	
	//The Java and MySQL works but need to make the table cleaner.
	@RequestMapping(value = "/customerhistory", method = RequestMethod.POST)
	public String customerHistory(Model model, HttpServletRequest request){
		
		HttpSession session = request.getSession(true);
		if (session.getAttribute("employee") ==  null) {
			return "login";
		}
		
		model.addAttribute("customerHistory", GettingInformation.accountHistory(session));
		model.addAttribute("ahProducts", GettingInformation.ahProducts(session));
		
		return "customerhistory";
	}
	
}