package com.daidonef.pointofsale;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cash extends Payment{
	
	private double cash;
	private double change;
	
	public Cash(double subTotal, double cash) {
		super(subTotal);
		this.cash = cash;
		change = cash - getTotal();
		change = BigDecimal.valueOf(change).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	public double getCash() {
		return cash;
	}

	public double getChange() {
		return change;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public void setChange(double change) {
		this.change = change;
	}
	
	public boolean incorrectAmount() {
		
		if (cash < getTotal()) {
			return true;
		}
		return false;
	}

}
