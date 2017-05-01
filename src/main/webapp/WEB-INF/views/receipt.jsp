<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Receipt</title>
</head>
<body>
<h1>Customer Receipt</h1>

<p>
	SubTotal: ${cash.subTotal }${creditCard.subTotal }${check.subTotal }
	<br>Tax: ${cash.tax }${creditCard.tax }${check.tax }
	<br>GrandTotal: ${cash.total }${creditCard.total }${check.total }
	<br>Cash: ${cash.cash }
	<br>Change: ${cash.change }
	<br>Security Code: ${creditCard.securityCode }
	<br>Check Number: ${check.checkNumber }
</p>

<p>
	<form name="nextCustomer" action="searchcustomer" method="post">

		<input type="submit" value="nextCustomer">
	</form>
</p>
</body>
</html>