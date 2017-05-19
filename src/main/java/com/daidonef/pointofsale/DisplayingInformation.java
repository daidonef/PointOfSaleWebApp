package com.daidonef.pointofsale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public class DisplayingInformation {
	
	public static void cashForm(Model model) {
		
		model.addAttribute("paymentForm", "<br>Cash: <input type='text' name='customerCash'>"
				+ "<br><input type='submit' value='submit'>");
	}
	
	public static void creditCardForm(Model model) {
		
		model.addAttribute("paymentForm", "<br>Credit Card Number: <input type='text' "
				+ "name='creditCardNumber'><br>Security Code: <input type='text' name="
				+ "'securityCode'><br>Expiration Date: <input type='text' name="
				+ "'date'><br><input type='submit' value='submit'>");
	}
	
	public static void checkForm(Model model) {
		
		model.addAttribute("paymentForm", "<br>Check Number: <input type='text' name="
				+ "'checkNumber'><br>Name: <input type='text' name='checkName'><br>Date: "
				+ "<input type='text' name='date'><br><input type='submit' value='submit'>");
	}
	
	public static void incorrectCashPayment(Model model) {
		
		model.addAttribute("incorrectPayment", "Not enough cash for the payment!");
	}
	
	public static void incorrectCheckPayment(Model model) {
		
		model.addAttribute("incorrectPayment", "Either the name is wrong or the date!");
	}

}
