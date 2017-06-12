package com.daidonef.pointofsale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public class DisplayingInformation {
	
	public static void cashForm(Model model) {
		
		model.addAttribute("paymentForm", "<br>Cash: <input type='text' class='inside' "
				+ "name='customerCash'><br><input type='submit' class='inside' value='submit'>");
	}
	
	public static void creditCardForm(Model model) {
		
		model.addAttribute("paymentForm", "<br>Credit Card Number: <input type='text' class='inside' "
				+ "name='creditCardNumber'><br>Security Code: <input type='text' class='inside' name="
				+ "'securityCode'><br>Expiration Date: <input type='text' class='inside' name="
				+ "'date'><br><input type='submit' class='inside' value='submit'>");
	}
	
	public static void checkForm(Model model) {
		
		model.addAttribute("paymentForm", "<br>Check Number: <input type='text' class='inside' name="
				+ "'checkNumber'><br>Name: <input type='text' class='inside' name='checkName'><br>Date: "
				+ "<input type='text' class='inside' name='date'><br><input type='submit' class='inside' "
				+ "value='submit'>");
	}
	
	public static void incorrectCashPayment(Model model) {
		
		model.addAttribute("incorrectPayment", "Not enough cash for the payment!");
	}
	
	public static void incorrectCreditCardPayment(Model model) {
		
		model.addAttribute("incorrectPayment", "The date of credit card is incorrect!");
	}
	
	public static void incorrectCheckPayment(Model model) {
		
		model.addAttribute("incorrectPayment", "Either the name is wrong or the date!");
	}

}
