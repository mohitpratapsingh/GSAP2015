<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Welcome</title>
</head>
<body>
	<center>
		<h4>Welcome ${dataMap.get("user").getUserFname()}</h4>


		<form method="GET" action="productSearch">
			<table border="1">
				<tr>
					<td><label>Find Your Product By Category</label></td>
					<td><input type="text" name="category" /></td>
					<td><input type="submit" value="Search" /></td>
				</tr>
			</table>
		</form>



		<br> <br>
		<table border="1">
			<thead>
				<th colspan=4>Product List</th>
				<tr>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Category</th>
					<th>Product brand</th>
					<th>Product quantity</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${dataMap['productList']}" var="product">
					<tr>
						<td>${product.pName}</td>
						<td>${product.price}</td>
						<td>${product.category}</td>
						<td>${product.brand}</td>
						<td>${product.quantity}</td>
						<td><input type="button" id="" value="Add to cart"  />

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>



