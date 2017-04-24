package com.daidonef.pointofsale;

import java.util.Date;

public class CreditCard extends Payment{
	
	private long creditCardNumber;
	private int securityCode;
	private Date date;
	
	public CreditCard(double subTotal, long creditCardNumber, int securityCode, Date date) {
		super(subTotal);
		this.creditCardNumber = creditCardNumber;
		this.securityCode = securityCode;
		this.date = date;
	}

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public Date getDate() {
		return date;
	}

	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
