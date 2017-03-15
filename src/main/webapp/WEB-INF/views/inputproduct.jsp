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
	<form name="inputProducts" action="inputproduct" method="post">

		<br>ProductNumber <input type="text" name="productNumber"> 
		Quantity: <input type="text" name="Quantity"> <br>
		
		<input type="submit" value="Add Product">
	</form>
</p>

<p>
	<form name="total" action="payment" method="post">

		<input type="submit" value="Total">
	</form>
</p>
</body>
</html>