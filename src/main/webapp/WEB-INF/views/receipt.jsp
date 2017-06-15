<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Receipt</title>
<link rel="stylesheet" href="resources/style.css">
</head>
<body>
<h1>Customer Receipt</h1>

	<table align="center">
		<tr>
			<th>Product</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Total</th>
		</tr>
		<c:forEach items="${products }" var="product" varStatus="status">
			<tr>
				<td>${product.productName }</td>
				<td>${product.price }</td>
				<td>${quantities[status.index]}</td>
			</tr>
		</c:forEach>
		<tr>
			<td>Sub Total</td>
			<td></td>
			<td></td>
			<td><fmt:formatNumber type="number" minFractionDigits="2" value="${cash.subTotal }
				${creditCard.subTotal }${check.subTotal }"/></td>
		</tr>
		<tr>
			<td>Tax</td>
			<td></td>
			<td></td>
			<td><fmt:formatNumber type="number" minFractionDigits="2" value="${cash.tax }
				${creditCard.tax }${check.tax }"/></td>
		</tr>
		<tr>
			<td>Grand Total</td>
			<td></td>
			<td></td>
			<td><fmt:formatNumber type="number" minFractionDigits="2" value="${cash.total }
				${creditCard.total }${check.total }"/></td>
		</tr>
	</table>
	
<!-- Not sure if I want to add to table or not -->
<div>
	${cashCash }${cash.cash }
	${changeCash }${cash.change }
	${creditCardCode }${creditCard.securityCode }
	${checkNumber }${check.checkNumber }
</div>

<div>
	<form name="nextCustomer" action="searchcustomer" method="post">

		<input type="submit" class="inside" value="nextCustomer">
	</form>
</div>
</body>
</html>