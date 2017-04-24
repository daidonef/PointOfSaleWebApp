package com.daidonef.pointofsale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public class DisplayingInformation {
	
	public static void cashForm(Model model, HttpServletRequest request, HttpSession session) {
		
		model.addAttribute("paymentForm", "<br>Cash: <input type='text' name='customerCash'>"
				+ "<br><input type='submit' value='submit'>");
	}
	
	public static void CreditCardForm(Model model, HttpServletRequest request, 
			HttpSession session) {
		
		model.addAttribute("paymentForm", "<br>Credit Card Number: <input type='text' "
				+ "name='creditCardNumber'><br>Security Code: <input type='text' name="
				+ "'securityCode'><br>Expiration Date: <input type='text' name="
				+ "'date'><br><input type='submit' value='submit'>");
	}
	
	public static void CheckForm(Model model, HttpServletRequest request, HttpSession session) {
		
		model.addAttribute("paymentForm", "<br>Check Number: <input type='text' name="
				+ "'checkNumber'><br>Name: <input type='text' name='checkName'><br>Date: "
				+ "<input type='text' name='date'><br><input type='submit' value='submit'>");
	}

}
