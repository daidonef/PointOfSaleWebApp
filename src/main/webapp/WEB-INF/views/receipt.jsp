<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Receipt</title>
</head>
<body>
<h1>Customer Receipt</h1>

<p>
	<table align="center">
		<tr>
			<th>Product</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<c:forEach items="${products }" var="product" varStatus="status">
			<tr>
				<td>${product.productName }</td>
				<td>${product.price }</td>
				<td>${quantities[status.index]}</td>
			</tr>
		</c:forEach>
	</table>
</p>

<p>
	SubTotal: ${cash.subTotal }${creditCard.subTotal }${check.subTotal }
	<br>Tax: ${cash.tax }${creditCard.tax }${check.tax }
	<br>GrandTotal: ${cash.total }${creditCard.total }${check.total }
	${cashCash }${cash.cash }
	${changeCash }${cash.change }
	${creditCardCode }${creditCard.securityCode }
	${checkNumber }${check.checkNumber }
</p>

<p>
	<form name="nextCustomer" action="searchcustomer" method="post">

		<input type="submit" value="nextCustomer">
	</form>
</p>
</body>
</html>