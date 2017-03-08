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
			return "searchcustomer";
		}
		
		
		return "";
	}

}
