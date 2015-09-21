<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>user registration Form</title>
    <style>
    /* body {background-color:lightgray}
h2   {color:blue} */
p    {color:red}
    </style>
</head>
<body>
<center>
<h2>user registration form</h2>
<form:form method="POST" action="userRegistration"  commandName="registerForm">
   <table>
    <tr>
        <td><form:label path="emailId">Username (email )</form:label></td>
        <td><form:input path="emailId" id="email"/></td>
         <td><form:errors path="emailId" cssclass="error"></form:errors></td> 
         <p color="red"> ${regResponse}</p>
<%--         <c:set var="message" value="${response}"/>
	<c:if test="${(message!=null)}">
	<p color="red"> <c:out value="${message}"/></p>
	</c:if> --%>
        
    </tr>
    <tr>
        <td><form:label path="passwrd">Password</form:label></td>
        <td><form:input type="password" path="passwrd" id="pass"/></td>
        <td><form:errors path="passwrd" cssclass="error"></form:errors></td> 
        
    </tr>
    <tr>
        <td><form:label path="userFname">First Name</form:label></td>
        <td><form:input path="userFname" id="fname"/></td>
        <td><form:errors path="userFname" cssclass="error"></form:errors></td> 
        
    </tr>
    <tr>
        <td><form:label path="userLname">Last Name</form:label></td>
        <td><form:input path="userLname" id="lname"/></td>
        <td><form:errors path="userLname" cssclass="error"></form:errors></td> 
        
    </tr>
     <tr>
        <td><form:label path="phoneNumber">Phone Number</form:label></td>
        <td><form:input path="phoneNumber" id="phone"/></td>
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
        <td><form:input path="addressLine1" id="al1"/></td>
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
            <input type="submit" value="SUBMIT" onclick="return checkUser()"/>
          </center>
        </td>
    </tr>
</table>  
</form:form>
</center>
<script type="text/javascript">
function checkUser() {

    var email = document.getElementById('email');
    var pass= document.getElementById('pass');
    var fname = document.getElementById('fname');
    var lname = document.getElementById('lname');
    var phone = document.getElementById('phone');
    var al1 = document.getElementById('al1');
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    
    
    if(email.value==null)
    	alert('Please enter an email address');
    else if (!filter.test(email.value)) {
    alert('Please provide a valid email address');
    email.focus;
    return false;
	 }
    
    else if(pass.value==null||pass.value=="")
    	{
    	alert('Please enter password');
    	return false;
    	}
    
    else if(fname.value==null||fname.value=="")
	{
	alert('Please enter firstname');
	return false;
	}
    else if(lname.value==null||lname.value=="")
	{
	alert('Please enter lastname');
	return false;
	}
    else if(phone.value==null||phone.value=="")
	{
	alert('Please enter Phone Number');
	return false;
	}

    else if(al1.value==null||al1.value=="")
	{
	alert('Please enter Address Line 1');
	return false;
	}

}

</script>



</body>
</html>
