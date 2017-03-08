package com.daidonef.pointofsale;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.ui.Model;

public class GettingInformation {
	
	public static String employee(String userName, String password,
			Model model, HttpSession session){
		
		List<Employee> employees = DAOEmployee.getEmployee(Query.gettingEmployees(userName));
		
		return CheckingInformation.employee(employees, password, model, session);
	}

}
