<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login</h1>

<p>${wrongLogin}</p>

<p>
	<form name="searchCustomer" action="searchcustomer" method="post">

		<br>Username: <input type="text" class="inside" name="userName"> 
		<br>Password: <input type="password" class="inside" name="password"> <br>
		<br>
		
		<input type="submit" value="Login">
	</form>
</p>
</body>
</html>