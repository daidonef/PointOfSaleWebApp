<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
<h1>Payment</h1>

<p>${incorrectPayment }</p>

<p>Sub Total: ${subTotal }</p>

<p>
	<form name="paymentType" onsubmit="return payValidation()" action="payment" method="post">
		<br>Payment Type:
		<br>Cash: <input type="radio" name="paymentType" value="cash">
		<br>Credit Card: <input type="radio" name="paymentType" value="creditCard">
		<br>Check: <input type="radio" name="paymentType" value="check">
		
		<input type="submit" value="submit">
	</form>
</p>

<p>
	<form name="paymentInformation" onsubmit="return validation()" action="receipt" method="post">
		${paymentForm }
	</form>
</p>

<script>

	//Something is wrong with this validation need to debug it.
	//I think it has something to do with what a blank input is.
	//Need to think about the logic and the way javascript compares things.
	function validation() {
		
		var customerCash = null;
		var creditCardNumber = null;
		var securityCode = null;
		var date = null;
		var checkNumber = null;
		var checkName = null;
		
		customerCash = document.forms["paymentInformation"]["customerCash"].value;
		creditCardNumber = document.forms["paymentInformation"]["creditCardNumber"].value;
		securityCode = document.forms["paymentInformation"]["securityCode"].value;
		date = document.forms["paymentInformation"]["date"].value;
		checkNumber = document.forms["paymentInformation"]["checkNumber"].value;
		checkName = document.forms["paymentInformation"]["checkName"].value;
		
		var letters = /^[A-Za-z\s]+$/;
		
		if (customerCash != null) {
			if (/\D/.test(customerCash)) {
				alert("Please input number for Customer Cash!");
				return false;
			}
			return true;
		}
		
		if (creditCardNumber != null) {
			if (creditCardNumber.length != 16 || /\D/.test(creditCardNumber)) {
				alert("Credit Card Number needs to be 16 numbers long.");
				return false;
			}
			if (securityCode.length < 3 || /\D/.test(securityCode)) {
				alert("Security Code needs to be at least 3 numbers long.");
				return false;
			}
			if (/^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/.test(date)) {
				alert("Date must be in xx/xx/xxxx formate");
				return false;
			}
			return true;
		}
		
		if (checkNumber != null) {
			if (/\D/.test(checkNumber)) {
				alert("Check Number must only be numbers!");
				return false;
			}
			if (letters.test(checkName) === false) {
				alert("Name can only be letters!");
				return false;
			}
			if (/^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/.test(date)) {
				alert("Date must be in xx/xx/xxxx formate");
				return false;
			}
			return true;
		}
		alert("Please insert information for payment!")
		return false;
	}
	
	function payValidation() {
		
		for (i = 0; i < paymentType.length; ++ i)
	    {
	        if (paymentType[i].checked) {
	        	return true;	
	        }
	    }
		alert("Please select your payment type!")
	    return false;
		
	}
</script>

</body>
</html>