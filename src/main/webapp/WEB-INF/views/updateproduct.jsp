<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product</title>
</head>
<body>
<h1>Update Product</h1>

<p>
	<form name="updateProduct" onsubmit="return validation()" action="ownerpage" method="post">
	
		<input type="hidden" name="porductID" class="inside" value="${product.productID}">
		<br>Product Name: <input type="text" name="productNameUp" class="inside" value="${product.productName}"> 
		<br>Price: <input type="text" name="price" class="inside" value="${product.price}"> 
		<br>Type: <input type="text" name="type" class="inside" value="${product.type }"> 
		<br>Description: <input type="text" name="description" class="inside" value="${product.description }">
		<br><br>
		<input type="submit" class="inside" value="Update Product">	
	</form>
</p>

</body>
</html>