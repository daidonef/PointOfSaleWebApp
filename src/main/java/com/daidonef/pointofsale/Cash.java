package com.daidonef.pointofsale;

public class Cash extends Payment{
	
	private double cash;
	private double change;
	
	public Cash(double subTotal, double cash) {
		super(subTotal);
		this.cash = cash;
		change = cash - getTotal();
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

}
