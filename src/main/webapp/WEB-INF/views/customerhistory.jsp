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

<!-- Need to clean up table so it looks and the double var have two decimal places -->

<p>
	<table align="center">
		<tr>
			<th>Product Number</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Quantity</th>
			<th>Date</th>
			<th>Grand Total</th>
			<th>Payment Type</th>
			<th>Cash Payment</th>
			<th>Change</th>
			<th>Credit Card Date</th>
			<th>Credit Card Number</th>
			<th>Secutity Code</th>
			<th>Check Number</th>
		</tr>
		<c:forEach items="${customerHistory }" var="history">
			<tr>
				<c:forEach items="${ahProducts }" var="ahProduct">
					<c:choose>
						<c:when test="${history.historyID == ahProduct.historyID }">
						<tr>
							<td>${ahProduct.productID }</td>
							<td>${ahProduct.productName }</td>
							<td>${ahProduct.price }</td>
							<td>${ahProduct.quantity }</td>
						</tr>
						</c:when>
					</c:choose>
				</c:forEach>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>${history.date }</td>
				<td>${history.grandTotal }</td>
				<td>${history.paymentType }</td>
				<td>${history.cashPayment }</td>
				<td>${history.change }</td>
				<td>${history.creditDate }</td>
				<td>${history.creditCardNumber }</td>
				<td>${history.securityCode }</td>
				<td>${history.checkNumber }</td>
			</tr>
		</c:forEach>
	</table>
</p>
</body>
</html>