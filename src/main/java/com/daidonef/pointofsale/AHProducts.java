package com.daidonef.pointofsale;

public class AHProducts {
	
	private int ahProductsID;
	private int accountID;
	private int historyID;
	private int productID;
	private String productName;
	private double price;
	private int quantity;
	
	public AHProducts() {
	
	}

	public AHProducts(int historyID, int accountID, int productID, String productName, double price, 
			int quantity) {
		this.historyID = historyID;
		this.accountID = accountID;
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public int getAhProductsID() {
		return ahProductsID;
	}
	
	public int getAccountID() {
		return accountID;
	}

	public int getHistoryID() {
		return historyID;
	}

	public int getProductID() {
		return productID;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setAhProductsID(int ahProductsID) {
		this.ahProductsID = ahProductsID;
	}
	
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public void setHistoryID(int historyID) {
		this.historyID = historyID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
