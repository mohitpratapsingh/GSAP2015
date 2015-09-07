<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>admin registration Form</title>
</head>
<body>
<center>
<h2>admin registration form</h2>
<form:form method="POST" action="adminRegistration"  commandName="adminForm">
   <table>
    <tr>
        <td><form:label path="emailId">Username ( email )</form:label></td>
        <td><form:input path="emailId" /></td>
    </tr>
    <tr>
        <td><form:label path="passwrd">Password</form:label></td>
        <td><form:input type="password" path="passwrd" /></td>
    </tr>
    <tr>
        <td><form:label path="userFname">First Name</form:label></td>
        <td><form:input path="userFname" /></td>
    </tr>
    <tr>
        <td><form:label path="userLname">Last Name</form:label></td>
        <td><form:input path="userLname" /></td>
    </tr>
    
    <tr>
        <td colspan="3"><center>
            <input type="submit" value="Submit"/>
            </center>
        </td>
    </tr>
        <tr>
    
        <td colspan="3"><center>
            <input type="button" value="Back" onclick="window.location='adminBack';" />
             </center>
        </td>
    
    </tr>
</table>  
</form:form>
</center>
</body>
</html>
