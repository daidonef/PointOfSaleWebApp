<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
<h1>Update Employee</h1>

<p>
	<form name="updateEmployee" onsubmit="return validation()" action="ownerpage" method="post">

		<input type="hidden" name="employeeID" class="inside" value="${employee.ID}">
		<br>Username: <input type="text" class="inside" name="userNameUp" value="${employee.userName }"> 
		<br>First Name: <input type="text" class="inside" name="firstName" value="${employee.firstName }"> 
		<br>Last Name: <input type="text" class="inside" name="lastName" value="${employee.lastName }"> 
		<br>password: <input type="password" class="inside" name="password"> 
		<br>Phone Number: <input type="text" class="inside" name="phoneNumber" value="${employee.phoneNumber }"> 
		<br>Email: <input type="text" class="inside" name="email" value="${employee.email }"> 
		<br><br>
		
		<input type="submit" value="Update Employee">
	</form>
</p>

</body>
</html>