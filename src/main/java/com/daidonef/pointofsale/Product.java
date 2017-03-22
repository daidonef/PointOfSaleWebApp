package com.daidonef.pointofsale;

public class Product {
	
	private int productID;
	private String productName;
	private double price;
	private String type;
	private String description;
	
	public Product() {
		
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
