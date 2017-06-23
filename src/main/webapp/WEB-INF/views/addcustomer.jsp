<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
<link rel="stylesheet" href="resources/style.css">
</head>
<body>

<divnav>
	<form name="home" class="navcustomer" action="http://localhost:8080/pointofsale/" method="get">
		<input type="submit" class="inside" value="Home">
	</form>
	
	<form name="login" class="navcustomer" action="login" method="post">
		<input type="submit" class="inside" value="Login">
	</form>
	
	<form name="customerSearch" class="navcustomer" action="searchcustomer" method="post">
		<input type="submit" class="inside" value="Customer Search">
	</form>
</divnav>

<h1>Add Customer</h1>

<div>
	<form name="addCustomer" onsubmit="return validation()" action="inputproduct" method="post">

		<br>Username: <input type="text" class="inside" name="userName"> 
		<br>First Name: <input type="text" class="inside" name="firstName"> 
		<br>Last Name: <input type="text" class="inside" name="lastName"> 
		<br>password: <input type="password" class="inside" name="password"> 
		<br>Phone Number: <input type="text" class="inside" name="phoneNumber"> 
		<br>Email: <input type="text" class="inside" name="email"> 
		<br><br>
		
		<input type="submit" class="inside" value="Add Customer">
	</form>
</div>

<script>
//Make better email validation later.
//Fit code to deal with phone number that input non numbers like (/ or -)
		function validation() {

			var userName = document.forms["addCustomer"]["userName"].value;
			var firstName = document.forms["addCustomer"]["firstName"].value;
			var lastName = document.forms["addCustomer"]["lastName"].value;
			var password = document.forms["addCustomer"]["password"].value;
			var phoneNumber = document.forms["addCustomer"]["phoneNumber"].value;
			var email = document.forms["addCustomer"]["email"].value;

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
			
			if (pnVal.test(phoneNumber) === false) {
				alert("Phone number needs to be a full phone number!");
				return false;
			}
			
			if (eVal.test(email) === false) {
				alert("Email needs to be a real email!");
				return false;
			}

		}
	</script>

</body>
</html>