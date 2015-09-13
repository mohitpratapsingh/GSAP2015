<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin register</title>
</head>
<body>


	<h4>${error}</h4>
	<div align="center">
		<form:form action="registerAdmin" method="post"
			commandName="adminForm">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Admin Registration</h2></td>
				</tr>
				<tr>
					<td>First Name:</td>

					<td><form:input path="firstName" /></td>
					<td><form:errors path="firstName" cssclass="error"></form:errors></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><form:label path="emailId">
							Email-Id
							</form:label></td>

					<td><form:input path="emailId" /></td>
					<td><form:errors path="emailId" cssclass="error"></form:errors></td>
				</tr>
				<td><form:label path="password">
						Password
					</form:label></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssclass="error"></form:errors></td>
				</tr>
				<tr>
				<tr>
					<td>Address:</td>
					<td><form:input path="address" /></td>
					<td><form:errors path="address" cssclass="error"></form:errors></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register" /></td>

				</tr>
			</table>
			<input type="hidden" value=<%=session.getAttribute("emailId")%>
				name="session" />
		</form:form>

		<form:form method="post" action="adminLanding">
			<input type="hidden" value=<%=session.getAttribute("emailId")%>
				name="session" />
			<input type="submit" value="Cancel" />
		</form:form>
	</div>

</body>
</html>