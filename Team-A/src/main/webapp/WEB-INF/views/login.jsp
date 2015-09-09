<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ page session="false" %>

<html>
<head>
<title>Login</title>
</head>
<body>
    <div align="center">
        <form:form action="login" method="post" commandName="userLogin">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Login</h2></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><form:input path="emailId" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" /></td>
                </tr>  
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Login" /></td>
                </tr>     
            </table>
        </form:form>
        
        <form:form action="registration1" method="post" commandName="register">
        <input type="submit" value="SignUp">
        </form:form>
    </div>
    <div align="center"><font color="red" weight="bold">${errorMessage}<br>${Message}</div>
</body>
</html>