<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
<h1>Payment</h1>

<p>
	<form name="paymentType" action="receipt" method="post">

		<br>Payment Type: <input type="text" name="paymentType"> 
		
		<input type="submit" value="submit">
	</form>
</p>

<!-- Need to add different payments to come up based on the Payment Type -->
</body>
</html>