<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer History</title>
</head>
<body>
<h1>Customer History</h1>
<p>
	<table align="center">
		<tr>
			<th>Grand Total</th>
			<th>Payment Type</th>
			<th>Cash Payment</th>
			<th>Change</th>
			<th>Credit Card Number</th>
			<th>Secutity Code</th>
			<th>Check Number</th>
		</tr>
		<c:forEach items="${customerHistory }" var="history">
			<tr>
				<td>${history.grandTotal }</td>
				<td>${history.paymentType }</td>
				<td>${history.cashPayment }</td>
				<td>${history.change }</td>
				<td>${history.creditCardNumber }</td>
				<td>${history.securityCode }</td>
				<td>${history.checkNumber }</td>
			</tr>
		</c:forEach>
	</table>
</p>
</body>
</html>