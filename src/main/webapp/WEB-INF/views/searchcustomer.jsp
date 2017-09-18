<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Search</title>
<link rel="stylesheet" href="resources/style.css">
</head>
<body>

<divnav>
	<form name="home" class="navsearch" action="http://localhost:8080/pointofsale/" method="get">
		<input type="submit" class="inside" value="Home">
	</form>
	
	<form name="login" class="navsearch" action="login" method="post">
		<input type="submit" class="inside" value="Login">
	</form>
</divnav>

<h1>Customer Search</h1>

<div2>
	${notFound }
</div2>
<div>
	<form name="customerSearch" action="inputproduct" method="post">

		<br> <input type="search" class="inside" name="search" placeholder="search"> <br>
		
		<input type="submit" class="inside" value="Search Customer">
	</form>
</div>

<div>
	<form name="addCustomer" action="addcustomer" method="post">
		
		<input type="submit" class="inside" value="Add Customer">
	</form>
</div>

<div>${owner}</div>
</body>
</html>