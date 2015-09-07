<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ page session="false" %>

<html>
<head>
<title>New Admin</title>
</head>
<body>
    <div align="center">
        <form:form action="registerAdmin2" method="post" commandName="registerAdmin">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Register Admin</h2></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><form:input path="fname" /></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><form:input path="lname" /></td>
                </tr> 
                 <tr>
                    <td>Email Id:</td>
                    <td><form:input path="emailId" /></td>
                </tr>
                  <tr>
                    <td>Address Line1:</td>
                    <td><form:input path="addressLine1" /></td>
                </tr>
                <tr>
                    <td>Address Line2:</td>
                    <td><form:input path="addressLine2" /></td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td><form:input path="city" /></td>
                </tr>
                <tr>
                    <td>State:</td>
                    <td><form:input path="state" /></td>
                </tr>
                <tr>
                    <td>Country:</td>
                    <td><form:input path="country" /></td>
                </tr>
                <tr>
                    <td>Pincode:</td>
                    <td><form:input path="pincode" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" /></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register Admin" /></td>
                </tr>     
            </table>
            </form:form>
    </div>
</body>
</html>