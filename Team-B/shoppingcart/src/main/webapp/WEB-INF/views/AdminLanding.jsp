<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Landing Page</title>
</head>
<body>
	<p>
		Hello admin!
		<%=session.getAttribute("emailId")%></p>

	<h4>${error}</h4>

	<div
		style="position: absolute; top: 0; right: 0; width: 100px; text-align: right;">
		<p>
			<b>Welcome ${Name}</b>
		</p>
	</div>


	<table border="3">
		<thead>
			<tr>UserList
			</tr>
			<tr>
				<th>User FirstName</th>
				<th>User LastName</th>
				<th>EmailId</th>

			</tr>
		</thead>

		<tbody>
			<c:forEach items="${UserList}" var="users">
				<tr>
					<td>${users.firstName}</td>
					<td>${users.lastName}</td>
					<td>${users.emailId}</td>


				</tr>
			</c:forEach>
		</tbody>
	</table>




	<table border="3">
		<thead>
			<tr>Admin List
			</tr>
			<tr>
				<th>Admin FirstName</th>
				<th>Admin LastName</th>
				<th>EmailId</th>

			</tr>
		</thead>

		<tbody>
			<c:forEach items="${AdminList}" var="users">
				<tr>
					<td>${users.firstName}</td>
					<td>${users.lastName}</td>
					<td>${users.emailId}</td>


				</tr>
			</c:forEach>
		</tbody>
	</table>


	<form action="createAdmin">
		<input type="submit" value="Add admin" />
	</form>



	<form:form action="productDeleteSubmit" method="post"
		commandName="productDeleteForm">
		<table border="3">
			<thead>
				<tr>Product List
				</tr>
				<tr>
					<th></th>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Quantity</th>


				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Productlist}" var="users">
					<tr>
						<td><input type="checkbox" name="prodList"
							value="${users.prodId}">
						<td>${users.prodId}</td>
						<td>${users.prodName}</td>
						<td>${users.price}</td>
						<td>${users.quantity}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="submit" value="Delete Product" />
		<input type="hidden" value=<%=session.getAttribute("emailId")%>
			name="session" />
	</form:form>


	<form:form method="POST" action="ProductForm" commandName="prodForm">
		<!-- <p> New User? Sign up here! </p> -->
		<input type="submit" value="Add Product" />
	</form:form>


	<form action="/shoppingcart">
		<input type="submit" value="Logout" />
	</form>



</body>
</html>