<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Owner Page</title>
</head>
<body>
<h1>Owner Page</h1>

<p>${employed }</p>

<p>${productExist }</p>
<p>${productAdded}</p>

<p>
	<form name="addProduct" action="ownerpage" method="post">
	
		<br>Product Name: <input type="text" name="productName">
		<br>Price: <input type="text" name="price">
		<br>Type: <input type="text" name="type">
		<br>Description <input type="text" name="description">
	
		<input type="submit" value="Add Product">
	</form>
</p>

<p>
	<form name="addEmployee" onsubmit="return validation()" action="ownerpage" method="post">

		<br>Username: <input type="text" class="inside" name="userName"> 
		<br>First Name: <input type="text" class="inside" name="firstName"> 
		<br>Last Name: <input type="text" class="inside" name="lastName"> 
		<br>password: <input type="password" class="inside" name="password"> 
		<br>Phone Number: <input type="text" class="inside" name="phoneNumber"> 
		<br>Email: <input type="text" class="inside" name="email"> 
		<br><br>
		
		<input type="submit" value="Add Employee">
	</form>
</p>

<script>
//Need to add Phone Number and Email to validation.
		function validation() {

			var userName = document.forms["addEmployee"]["userName"].value;
			var firstName = document.forms["addEmployee"]["firstName"].value;
			var lastName = document.forms["addEmployee"]["lastName"].value;
			var password = document.forms["addEmployee"]["password"].value;

			var letters = /^[A-Za-z\s]+$/;

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