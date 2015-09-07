<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring Form</title>
</head>
<body>

<h2>user login page</h2>
<form:form method="POST" action="userLoginSubmit"  commandName="loginForm">
   <table>
    <tr>
        <td><form:label path="emailId">Name</form:label></td>
        <td><form:input path="emailId" /></td>
         <td><form:errors path="emailId" cssclass="error"></form:errors></td> 
        
    </tr>
    <tr>
        <td><form:label path="passwrd">Password</form:label></td>
        <td><form:input type="password" path="passwrd" /></td>
         <td><form:errors path="passwrd" cssclass="error"></form:errors></td> 
        
    </tr>
    <tr>
  		<td></td>	  
        <td>
            <input type="submit" value="Submit"/>
        </td>
  
 
   <td>
          <input type="button" value="Register" onclick="window.location='register';" />
   </td>        
    </tr>
</table>  
</form:form>

</body>
</html>
