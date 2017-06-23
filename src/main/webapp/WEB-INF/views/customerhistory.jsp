<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer History</title>
<link rel="stylesheet" href="resources/style.css">
</head>
<body>

<divnav>
	<form name="home" class="navprofile" action="http://localhost:8080/pointofsale/" method="get">
		<input type="submit" class="inside" value="Home">
	</form>
	
	<form name="login" class="navprofile" action="login" method="post">
		<input type="submit" class="inside" value="Login">
	</form>
	
	<form name="customerSearch" class="navprofile" action="searchcustomer" method="post">
		<input type="submit" class="inside" value="Customer Search">
	</form>
	
	<form name="inputProduct" class="navprofile" action="inputproduct" method="post">
		<input type="submit" class="inside" value="Input Product">
	</form>
</divnav>

<h1>Customer History</h1>

<!-- Need to clean up table so it looks and the double var have two decimal places -->

<p>
	<table align="center">
		<tr>
			<th>Date</th>
			<th>Product Number</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Quantity</th>
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
				<td>${history.date }</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<c:forEach items="${ahProducts }" var="ahProduct">
					<c:choose>
						<c:when test="${history.historyID == ahProduct.historyID }">
						<tr>
							<td></td>
							<td>${ahProduct.productID }</td>
							<td>${ahProduct.productName }</td>
							<td><fmt:formatNumber type="number" minFractionDigits="2" value="${ahProduct.price }"/></td>
							<td>${ahProduct.quantity }</td>
						</tr>
						</c:when>
					</c:choose>
				</c:forEach>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><fmt:formatNumber type="number" minFractionDigits="2" value="${history.grandTotal }"/></td>
				<td>${history.paymentType }</td>
				<td>
					<c:if test="${history.cashPayment != 0 }">
						<fmt:formatNumber type="number" minFractionDigits="2" value="${history.cashPayment }"/>
					</c:if>
				</td>
				<td>
					<c:if test="${history.change != 0 }">
						<fmt:formatNumber type="number" minFractionDigits="2" value="${history.change }"/>
					</c:if>
				</td>
				<td>${history.creditDate }</td>
				<td>
					<c:if test="${history.creditCardNumber != 0 }">
						<c:set var = "CCNumber" value = "${history.creditCardNumber }"/>
      					<c:set var = "CCNumber" value = "${fn:substring(CCNumber, 12, 16)}" />
      					<c:set var = "CCNumber" value = "****-****-****-${CCNumber }" />
      					${CCNumber }
					</c:if>
				</td>
				<td>
					<c:if test="${history.securityCode != 0 }">
						${history.securityCode }
					</c:if>
				</td>
				<td>
					<c:if test="${history.checkNumber != 0 }">
						${history.checkNumber }
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</p>
</body>
</html>