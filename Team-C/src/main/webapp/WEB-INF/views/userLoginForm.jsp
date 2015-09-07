<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>user login  Form</title>
</head>
<style>
/* body {background-color:lightgray}
h2   {color:blue} */
p    {color:red}
</style>
<body>

<center>

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
          <center>  <input type="submit" value="Submit"/>  </center>
        </td>
  
 </tr>
 <tr>
 <td/>
   <td>
     <center>    <input type="button" value="Register" onclick="window.location='register';" /></center> 
   </td>        
    </tr>
</table>  
</form:form>
<c:set var="message" value="${dataMap.get(\"message\")}"/>
<c:if test="${(message!=null)}">
<p color="red"> <c:out value="${message}"/></p>
</c:if>
</center>
</body>
</html>
