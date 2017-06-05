package com.daidonef.pointofsale;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Payment {
	
	private double subTotal;
	final private double TAX = 0.06;
	private double tax;
	private double total;
	
	public Payment(double subTotal) {
		this.subTotal = subTotal;
		tax = this.subTotal * TAX;
		total = this.subTotal + tax;
		twoDecimal();
	}

	public double getSubTotal() {
		return subTotal;
	}

	public double getTAX() {
		return TAX;
	}

	public double getTax() {
		return tax;
	}

	public double getTotal() {
		return total;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public void twoDecimal() {
		
		subTotal = BigDecimal.valueOf(subTotal).setScale(2, RoundingMode.HALF_UP).doubleValue();
		tax =  BigDecimal.valueOf(tax).setScale(2, RoundingMode.HALF_UP).doubleValue();
		total =  BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP).doubleValue();	
	}
	
}
