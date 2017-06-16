<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Input Products</title>
<link rel="stylesheet" href="resources/style.css">
</head>
<body>
<h1>Input Products</h1>
<div2>
${wrongProduct }
</div2>
<div>
	<form name="customerHistory" action="customerhistory" method="post">
	
		<input type="submit" class="inside" value="Customer History">
	</form>
</div>
<div>
	<form name="inputProducts" onsubmit="return validation()" action="inputproduct" method="post">

		<br>Product Number: <input type="text" class="inside" name="productNumber"> 
		Quantity: <input type="text" class="inside" name="quantity"> <br>
		
		<input type="submit" class="inside" value="Add Product">
	</form>
</div>

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
			<td><fmt:formatNumber type="number" minFractionDigits="2" value="${total }"/></td>
		</tr>
		<tr>
			<td>Tax</td>
			<td></td>
			<td></td>
			<td><fmt:formatNumber type="number" minFractionDigits="2" value="${tax }"/></td>
		</tr>
		<tr>
			<td>Grand Total</td>
			<td></td>
			<td></td>
			<td><fmt:formatNumber type="number" minFractionDigits="2" value="${grandTotal }"/></td>
		</tr>
	</table>

<div>
	<form name="total" action="payment" method="post">

		<input type="submit" class="inside" value="Total">
	</form>
</div>

<script>
	function validation() {
		
		var productNumber = document.forms["inputProducts"]["productNumber"].value;
		var quantity = document.forms["inputProducts"]["quantity"].value;
		
		if (/\D/.test(productNumber)) {
			alert("Product Number needs to be a number!");
			return false;
		}
		
		if (/\D/.test(quantity)) {
			alert("Quantity needs to be a number!");
			return false;
		}
		
	}
</script>
</body>
</html>