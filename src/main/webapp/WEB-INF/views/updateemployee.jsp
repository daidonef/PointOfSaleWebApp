<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee</title>
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
	
	<form name="ownerPage" class="navprofile" action="ownerpage" method="post">
		<input type="submit" class="inside" value="Owner Page">
	</form>
</divnav>

<h1>Update Employee</h1>

<div>
	<form name="updateEmployee" onsubmit="return validation()" action="ownerpage" method="post">

		<input type="hidden" name="employeeID" class="inside" value="${employee.ID}">
		<br>Username: <input type="text" class="inside" name="userNameUp" value="${employee.userName }"> 
		<br>First Name: <input type="text" class="inside" name="firstName" value="${employee.firstName }"> 
		<br>Last Name: <input type="text" class="inside" name="lastName" value="${employee.lastName }"> 
		<br>password: <input type="password" class="inside" name="password"> 
		<br>Phone Number: <input type="text" class="inside" name="phoneNumber" value="${employee.phoneNumber }"> 
		<br>Email: <input type="text" class="inside" name="email" value="${employee.email }"> 
		<br><br>
		
		<input type="submit" class='inside' value="Update Employee">
	</form>
</div>
<script>
//Need to inprove Phone Number and Email to validation.
		function validation() {

			var userName = document.forms["addEmployee"]["userName"].value;
			var firstName = document.forms["addEmployee"]["firstName"].value;
			var lastName = document.forms["addEmployee"]["lastName"].value;
			var password = document.forms["addEmployee"]["password"].value;
			var phoneNumber = document.forms["addEmployee"]["phoneNumber"].value;
			var email = document.forms["addEmployee"]["email"].value;

			var letters = /^[A-Za-z\s]+$/;
			var eVal = /\S+@\S+\.\S+/;
			var pnVal = /^[(]{0,1}[0-9]{3}[)]{0,1}[-\s\.]{0,1}[0-9]{3}[-\s\.]{0,1}[0-9]{4}$/;

			if (userName.length < 8) {
				alert("Username is too short! Need at least 8 characters!");
				return false;
			}

			if (firstName.length < 2) {
				alert("First name is too short!");
				return false;
			}

			if (letters.test(firstName) == false) {
				alert("First name can only have letters!");
				return false;
			}

			if (lastName.length < 2) {
				alert("Last name is too short!");
				return false;
			}

			if (letters.test(lastName) == false) {
				alert("Last name can only have letters!");
				return false;
			}

			if (password.length < 10) {
				alert("Password is too short! Must have at least 10 characters!");
				return false;
			}

			if (/\d/.test(password) === false) {
				alert("Password needs at least one digit!");
				return false;
			}

			if (/[a-z]/.test(password) === false) {
				alert("Password needs at least one lower case letter!");
				return false;
			}

			if (/[A-Z]/.test(password) === false) {
				alert("Password needs at least one upper case letter!");
				return false;
			}

			if (/[!@#$%^&*]/.test(password) === false) {
				alert("Password needs at least one special character!");
				return false;
			}

		}
	</script>
</body>
</html>