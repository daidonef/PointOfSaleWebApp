<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Owner Page</title>
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

<h1>Owner Page</h1>

<div2>${employed }</div2>
<div>${employee.userName }${employee2}
${employeeUpdated.userName }${employeeUpdated2 }
${employeeDeleted.userName }${employeeDeleted2 }</div>

<div2>${productExist }</div2>
<div>${productAdded}${productAdded2}
${productUpdated.productName }${productUpdated2 }
${productDeleted.productName }${productDeleted2 }</div>

<div>
	<form name ="searchProduct" action="ownerpage" method="post">
		
		<br>Search Product: <input type="search" class="inside" name="searchProduct"
		placeholder="Search">
		
		<input type="submit" class="inside" value="Search Product">
	</form>
</div>
<table>
	<tr>
		<th>Product Number</th>
		<th>Product Name</th>
		<th>Price</th>
		<th>Type</th>
		<th>Description</th>
	</tr>
	<c:forEach items="${products }" var="product">
		<tr>
			<td>${product.productID }</td>
			<td>${product.productName }</td>
			<td>${product.price }</td>
			<td>${product.type }</td>
			<td>${product.description }</td>
			<td><form name="updateProduct" action="updateproduct" method="post">
						<input type="hidden" name="updateProduct" value="${product.productID}"> 
						<input type="submit" class="inside" value="Update Product">
					</form></td>
				<td><form name="deleteProduct" action="ownerpage" method="post">
						<br>
						<input type="hidden" name="deleteProduct" value="${product.productID}"> 
						<input type="submit" class="inside" value="Delete Product">
					</form></td>
		</tr>
	</c:forEach>
</table>

<div>
	<form name="addProduct" onsubmit="return prodValidation()" action="ownerpage" method="post">
	
		<br>Product Name: <input type="text" class='inside' name="productName">
		<br>Price: <input type="text" class='inside' name="price">
		<br>Type: <input type="text" class='inside' name="type">
		<br>Description <input type="text" class='inside' name="description">
	
		<input type="submit" class='inside' value="Add Product">
	</form>
</div>

<div>
	<form name ="searchEmployee" action="ownerpage" method="post">
		
		<br>Search Employee: <input type="text" class='inside' name="searchEmployee">
		
		<input type="submit" class='inside' value="Search Employee">
	</form>
</div>

<table>
	<tr>
		<th>Employee Number</th>
		<th>Username</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Phone Number</th>
		<th>Email</th>
	</tr>
	<c:forEach items="${employees}" var="employee">
		<tr>
			<td>${employee.ID }</td>
			<td>${employee.userName }</td>
			<td>${employee.firstName }</td>
			<td>${employee.lastName }</td>
			<td>${employee.phoneNumber }</td>
			<td>${employee.email }</td>
			<td><form name="updateEmployee" action="updateemployee" method="post">
						<input type="hidden" name="updateEmployee" value="${employee.ID}"> 
						<input type="submit" class="inside" value="Update Employee">
					</form></td>
				<td><form name="deleteEmployee" action="ownerpage" method="post">
						<br>
						<input type="hidden" name="deleteEmployee" value="${employee.ID}"> 
						<input type="submit" class="inside" value="Delete Employee">
					</form></td>
		</tr>
	</c:forEach>
</table>


<div>
	<form name="addEmployee" onsubmit="return validation()" action="ownerpage" method="post">

		<br>Username: <input type="text" class="inside" name="userName"> 
		<br>First Name: <input type="text" class="inside" name="firstName"> 
		<br>Last Name: <input type="text" class="inside" name="lastName"> 
		<br>password: <input type="password" class="inside" name="password"> 
		<br>Phone Number: <input type="text" class="inside" name="phoneNumber"> 
		<br>Email: <input type="text" class="inside" name="email"> 
		<br><br>
		
		<input type="submit" class='inside' value="Add Employee">
	</form>
</div>

<script>

	function prodValidation() {
			
		var productName = document.forms["addProduct"]["productName"].value;
		var price = document.forms["addProduct"]["price"].value;
		var type = document.forms["addProduct"]["type"].value;
		var description = document.forms["addProduct"]["description"].value;
		
		var letters = /^[A-Za-z\s]+$/;
		
		if (productName.length === 0) {
			alert("Need to input a product name!");
			return false;
		}
		if (price.length === 0) {
			alert("Need to input a price!");
			return false;
		}
		if (/^(\d*([.,](?=\d{3}))?\d+)+((?!\2)[.,]\d\d)?$/.test(price)) {
			alert("Need to input proper price value!");
			return false;
		}
		if (type.length === 0) {
			alert("Need to input a type!");
			return false;
		}
		if (description.length === 0) {
			alert("Need to input a description!");
			return false;
		}
		
	}
	
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