package com.daidonef.pointofsale;

import java.util.Date;

public class Check extends Payment{
	
	private int checkNumber;
	private String name;
	private Date date;

	public Check(double subTotal, int checkNumber, String name, Date date) {
		super(subTotal);
		this.checkNumber = checkNumber;
		this.name = name;
		this.date = date;
	}

	public int getCheckNumber() {
		return checkNumber;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public void setCheckNumber(int checkNumber) {
		this.checkNumber = checkNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
