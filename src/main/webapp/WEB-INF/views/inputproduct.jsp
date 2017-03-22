<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Input Products</title>
</head>
<body>
<h1>Input Products</h1>
<p>
${wrongProduct }
</p>
<p>
	<form name="inputProducts" action="inputproduct" method="post">

		<br>Product Name: <input type="text" name="productName"> 
		Quantity: <input type="text" name="quantity"> <br>
		
		<input type="submit" value="Add Product">
	</form>
</p>
<p>
	<table align="center">
		<tr>
			<th>Product</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<c:forEach items="${product }" var="product">
		<c:forEach items="${quantity }" var="quantity">
			<tr>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${quantity }</td>
			</tr>
		</c:forEach>
		</c:forEach>
	</table>
</p>

<p>
	<form name="total" action="payment" method="post">

		<input type="submit" value="Total">
	</form>
</p>
</body>
</html>