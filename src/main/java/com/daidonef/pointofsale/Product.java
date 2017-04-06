package com.daidonef.pointofsale;

public class Product {
	
	private int productID;
	private String productName;
	private double price;
	private String type;
	private String description;
	
	public Product() {
		
	}
	
	public Product(String productName, double price, String type, String description) {
		this.productName = productName;
		this.price = price;
		this.type = type;
		this.description = description;
	}

	public Product(int productID, String productName, double price, String type, String description) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.type = type;
		this.description = description;
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

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
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

	public void setType(String type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
