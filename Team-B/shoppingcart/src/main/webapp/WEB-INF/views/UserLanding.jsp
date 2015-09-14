<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Landing page</title>
</head>
<body>
	<p>Welcome user!
	<p>
	<h4>${error}</h4>
	<table border="3">
		<thead>
			<tr>Product List
			</tr>
			<tr>
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Quantity</th>


			</tr>
		</thead>

		<tbody>
			<c:forEach items="${Productlist}" var="users">
				<tr>
					<td>${users.prodId}</td>
					<td>${users.prodName}</td>
					<td>${users.price}</td>
					<td>${users.quantity}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form action="/shoppingcart">
		<input type="submit" value="Logout" />
	</form>


</body>
</html>