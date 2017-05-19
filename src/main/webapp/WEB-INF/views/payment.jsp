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
	<form name="paymentType" action="payment" method="post">
		<br>Payment Type:
		<br>Cash: <input type="radio" name="paymentType" value="cash">
		<br>Credit Card: <input type="radio" name="paymentType" value="creditCard">
		<br>Check: <input type="radio" name="paymentType" value="check">
		
		<input type="submit" value="submit">
	</form>
</p>

<p>
	<form name="paymentInfomation" action="receipt" method="post">
		${paymentForm }
	</form>
</p>

<!-- Need to add different payments to come up based on the Payment Type -->
</body>
</html>