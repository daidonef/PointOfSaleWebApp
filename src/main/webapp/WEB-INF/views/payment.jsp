<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
<link rel="stylesheet" href="resources/style.css">
</head>
<body>

<divnav>
	<form name="home" class="navproduct" action="http://localhost:8080/pointofsale/" method="get">
		<input type="submit" class="inside" value="Home">
	</form>
	
	<form name="login" class="navproduct" action="login" method="post">
		<input type="submit" class="inside" value="Login">
	</form>
	
	<form name="customerSearch" class="navproduct" action="searchcustomer" method="post">
		<input type="submit" class="inside" value="Customer Search">
	</form>
	
	<form name="customerHistory" class="navproduct" action="customerhistory" method="post">
		<input type="submit" class="inside" value="Customer History">
	</form>
	
	<form name="inputProduct" class="navproduct" action="inputproduct" method="post">
		<input type="submit" class="inside" value="Input Product">
	</form>
</divnav>

<h1>Payment</h1>

<div2>${incorrectPayment }</div2>

<div>Sub Total: ${subTotal }
<br>Tax: ${tax }
<br>Grand Total: ${grandTotal }</div>

<div>
	<form name="paymentType" onsubmit="return payValidation()" action="payment" method="post">
		<br>Payment Type:
		<br>Cash: <input type="radio" name="paymentType" value="cash">
		<br>Credit Card: <input type="radio" name="paymentType" value="creditCard">
		<br>Check: <input type="radio" name="paymentType" value="check">
		
		<input type="submit" class="inside" value="submit">
	</form>
</div>

<div>
	<form name="paymentInformation" onsubmit="return validation()" action="receipt" method="post">
		${paymentForm }
	</form>
</div>

<script>

	function validation() {
		
		var letters = /^[A-Za-z\s]+$/;
		
		if (document.forms["paymentInformation"]["customerCash"] != undefined) {
			
			var customerCash = document.forms["paymentInformation"]["customerCash"].value;
			
			if (customerCash.length === 0) {
				alert("Please input number for Customer Cash!");
				return false;
			}
			
			if (/\D/.test(customerCash)) {
				alert("Please input number for Customer Cash!");
				return false;
			}
			return true;
		}
		
		if (document.forms["paymentInformation"]["creditCardNumber"] != undefined) {
			
			var creditCardNumber = document.forms["paymentInformation"]["creditCardNumber"].value;
			var securityCode = document.forms["paymentInformation"]["securityCode"].value;
			var date = document.forms["paymentInformation"]["date"].value;
			
			if (creditCardNumber.length != 16 || /\D/.test(creditCardNumber)) {
				alert("Credit Card Number needs to be 16 numbers long.");
				return false;
			}
			if (securityCode.length < 3 || /\D/.test(securityCode)) {
				alert("Security Code needs to be at least 3 numbers long.");
				return false;
			}
			if (date.length != 10) {
				alert("Date must be in xx/xx/xxxx format.");
				return false;
			}
			if (/^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/.test(date) === false) {
				alert("Date must be in xx/xx/xxxx format.");
				return false;
			}
			return true;
		}
		
		if (document.forms["paymentInformation"]["checkNumber"] != undefined) {
			
			var date = document.forms["paymentInformation"]["date"].value;
			var checkNumber = document.forms["paymentInformation"]["checkNumber"].value;
			var checkName = document.forms["paymentInformation"]["checkName"].value;
			
			if (checkNumber.length === 0) {
				alert("Please input the check number!");
				return false;
			}
			if (/\D/.test(checkNumber)) {
				alert("Check Number must only be numbers!");
				return false;
			}
			if (checkName.length < 5) {
				alert("Please input your full name!");
				return false;
			}
			if (letters.test(checkName) === false) {
				alert("Name can only be letters!");
				return false;
			}
			if (date.length != 10) {
				alert("Date must be in xx/xx/xxxx format.");
				return false;
			}
			if (/^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/.test(date) === false) {
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