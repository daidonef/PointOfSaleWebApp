<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Search</title>
</head>
<body>
<h1>Customer Search</h1>

<p>
	<form name="customerSearch" action="inputproduct" method="post">

		<input type="submit" value="Search Customer">
	</form>
</p>

<p>
	<form name="addCustomer" action="addcustomer" method="post">

		<br> <input type="text" name="search"> <br>
		
		<input type="submit" value="Add Customer">
	</form>
</p>
</body>
</html>