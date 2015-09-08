<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>user registration Form</title>
    <style>
    /* body {background-color:lightgray}
h2   {color:blue} */
p    {color:red}
    </style>>
</head>
<body>
<center>
<h2>user registration form</h2>
<form:form method="POST" action="userRegistration"  commandName="registerForm">
   <table>
    <tr>
        <td><form:label path="emailId">Username (email )</form:label></td>
        <td><form:input path="emailId" /></td>
         <td><form:errors path="emailId" cssclass="error"></form:errors></td> 
        <c:set var="message" value="${response}"/>
	<c:if test="${(message!=null)}">
	<p color="red"> <c:out value="${message}"/></p>
	</c:if>
        
    </tr>
    <tr>
        <td><form:label path="passwrd">Password</form:label></td>
        <td><form:input type="password" path="passwrd" /></td>
        <td><form:errors path="passwrd" cssclass="error"></form:errors></td> 
        
    </tr>
    <tr>
        <td><form:label path="userFname">First Name</form:label></td>
        <td><form:input path="userFname" /></td>
        <td><form:errors path="userFname" cssclass="error"></form:errors></td> 
        
    </tr>
    <tr>
        <td><form:label path="userLname">Last Name</form:label></td>
        <td><form:input path="userLname" /></td>
        <td><form:errors path="userLname" cssclass="error"></form:errors></td> 
        
    </tr>
     <tr>
        <td><form:label path="phoneNumber">Phone Number</form:label></td>
        <td><form:input path="phoneNumber" /></td>
         <td><form:errors path="phoneNumber" cssclass="error"></form:errors></td> 
        
    </tr>
     <tr>
        <td><form:label path="gender">Gender</form:label></td>
        <td><form:radiobutton path="gender"  value="Female"/>
		<form:label path="gender">Female</form:label></td>
        <td><form:radiobutton path="gender"  value="Male"/>
        <form:label path="gender">Male</form:label></td>    
    </tr>
     <tr>
        <td><form:label path="addressLine1">Address Line1</form:label></td>
        <td><form:input path="addressLine1" /></td>
        <td><form:errors path="addressLine1" cssclass="error"></form:errors></td> 
        
    </tr>
     <tr>
        <td><form:label path="addressLine2">Address Line2</form:label></td>
        <td><form:select path="addressLine2">
        			<%-- <form:option value="NONE" label="--- Select ---" /> --%>
					<form:options items="${stateList}" />
		</form:select></td>
		
    </tr>
    
    <tr>
        <td colspan="3">
        <center>
            <input type="submit" value="Submit"/>
          </center>
        </td>
    </tr>
</table>  
</form:form>
</center>
</body>
</html>
