package com.daidonef.pointofsale;

public class AccountHistory {
	
	private int historyID;
	private int accountID;
	private String product;
	private double price;
	private int paymentType;
	
	public AccountHistory() {
		
	}

	public int getHistoryID() {
		return historyID;
	}

	public int getAccountID() {
		return accountID;
	}

	public String getProduct() {
		return product;
	}

	public double getPrice() {
		return price;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setHistoryID(int historyID) {
		this.historyID = historyID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

}
