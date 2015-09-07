<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ page session="false" %>

<html>
<head>
<title>Registration</title>
</head>
<body>
    <div align="center">
        <form:form action="registration2" method="post" commandName="registerUser">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Register</h2></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><form:input path="fname" /></td>
                    <td><form:errors path="fname" cssclass="error"></form:errors></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><form:input path="lname" /></td>
                    <td><form:errors path="lname" cssclass="error"></form:errors></td>
                </tr> 
                 <tr>
                    <td>Email Id:</td>
                    <td><form:input path="emailId" /></td>
                    <td><form:errors path="emailId" cssclass="error"></form:errors></td>
                </tr>
                  <tr>
                    <td>Address Line1:</td>
                    <td><form:input path="addressLine1" /></td>
                    <td><form:errors path="addressLine1" cssclass="error"></form:errors></td>
                </tr>
                <tr>
                    <td>Address Line2:</td>
                    <td><form:input path="addressLine2" /></td>
                    <td><form:errors path="addressLine2" cssclass="error"></form:errors></td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td><form:input path="city" /></td>
                    <td><form:errors path="city" cssclass="error"></form:errors></td>
                </tr>
                <tr>
                    <td>State:</td>
                    <td><form:input path="state" /></td>
                    <td><form:errors path="state" cssclass="error"></form:errors></td>
                </tr>
                <tr>
                    <td>Country:</td>
                    <td><form:input path="country" /></td>
                    <td><form:errors path="country" cssclass="error"></form:errors></td>
                </tr>
                <tr>
                    <td>Pincode:</td>
                    <td><form:input path="pincode" /></td>
                    <td><form:errors path="pincode" cssclass="error"></form:errors></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" /></td>
                    <td><form:errors path="password" cssclass="error"></form:errors></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
                </tr>     
            </table>
            </form:form>
    </div>
</body>
</html>