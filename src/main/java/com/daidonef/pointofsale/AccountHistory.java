package com.daidonef.pointofsale;

public class AccountHistory {
	
	private int historyID;
	private int accountID;
	private double grandTotal;
	private String paymentType;
	private double cashPayment;
	private double change;
	private long creditCardNumber;
	private int securityCode;
	private int checkNumber;
	
	public AccountHistory() {
		
	}
	
	public AccountHistory(int accountID, double grandTotal, String paymentType, double cashPayment, double change) {
		this.accountID = accountID;
		this.grandTotal = grandTotal;
		this.paymentType = paymentType;
		this.cashPayment = cashPayment;
		this.change = change;
	}

	public AccountHistory(int accountID, double grandTotal, String paymentType, long creditCardNumber,
			int securityCode) {
		this.accountID = accountID;
		this.grandTotal = grandTotal;
		this.paymentType = paymentType;
		this.creditCardNumber = creditCardNumber;
		this.securityCode = securityCode;
	}
	
	public AccountHistory(int accountID, double grandTotal, String paymentType, int checkNumber) {
		this.accountID = accountID;
		this.grandTotal = grandTotal;
		this.paymentType = paymentType;
		this.checkNumber = checkNumber;
	}

	public int getHistoryID() {
		return historyID;
	}

	public int getAccountID() {
		return accountID;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public String getPaymentType() {
		return paymentType;
	}
	
	public double getCashPayment() {
		return cashPayment;
	}
	
	public double getChange() {
		return change;
	}
	
	public long getCreditCardNumber() {
		return creditCardNumber;
	}
	
	public int getSecurityCode() {
		return securityCode;
	}
	
	public int getCheckNumber() {
		return checkNumber;
	}

	public void setHistoryID(int historyID) {
		this.historyID = historyID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public void setCashPayment(double cashPayment) {
		this.cashPayment = cashPayment;
	}
	
	public void setChange(double change) {
		this.change = change;
	}
	
	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	
	public void setCheckNumber(int checkNumber) {
		this.checkNumber = checkNumber;
	}

}
