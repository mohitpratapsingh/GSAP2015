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
        <td><form:input path="emailId" id="Email"/></td>
    </tr>
    <tr>
        <td><form:label path="passwrd">Password</form:label></td>
        <td><form:input type="password" path="passwrd" id="pass" /></td>
    </tr>
    <tr>
        <td><form:label path="userFname">First Name</form:label></td>
        <td><form:input path="userFname" id="fname" /></td>
    </tr>
    <tr>
        <td><form:label path="userLname">Last Name</form:label></td>
        <td><form:input path="userLname" id="lname"/></td>
    </tr>
    
    <tr>
        <td colspan="3"><center>
            <input type="submit" value="Submit" onclick="return checkEmail()"/>
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
<script type="text/javascript">
function checkEmail() {

    var email = document.getElementById('Email');
    var pass = document.getElementById('pass');
    var fname = document.getElementById('fname');
    var lname = document.getElementById('lname');
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
}

</script>

</body>
</html>
