<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Form</title>
</head>
<body>


	<h4>${error}</h4>
	<div align="center">
		<form:form action="ProductSubmit" method="post"
			commandName="prodFormSubmit">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Product Form</h2></td>
				</tr>
				<tr>
					<td>Product Name:</td>

					<td><form:input path="prodName" /></td>
					<%-- <td><form:errors path="firstName" cssclass="error"></form:errors></td>  --%>
				</tr>
				<tr>
					<td>Product Price:</td>
					<td><form:input path="price" /></td>
				</tr>
				<tr>
					<td>Quantity:</td>
					<td><form:input path="quantity" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
				<input type="hidden" value=<%=session.getAttribute("emailId")%>
					name="session" />
			</table>
		</form:form>



		<form:form method="post" action="adminLanding">
			<input type="hidden" value=<%=session.getAttribute("emailId")%>
				name="session" />
			<input type="submit" value="Cancel" />
		</form:form>
</body>
</html>