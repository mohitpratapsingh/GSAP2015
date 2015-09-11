<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page session="false" %>

<html>
<head>
<title>My profile</title>
</head>
<body>
    <div align="center">
            <table border="0">
                <tr>
                    <td>First Name:</td>
                    <td>${UserProf.fname}</td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td>${UserProf.lname}</td>
                </tr> 
                 <tr>
                    <td>Email Id:</td>
                    <td>${UserProf.emailId}</td>
                </tr>
                  <tr>
                    <td>Address Line1:</td>
                    <td>${UserProf.addressLine1}</td>
                </tr>
                <tr>
                    <td>Address Line2:</td>
                    <td>${UserProf.addressLine2}</td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td>${UserProf.city}</td>
                </tr>
                <tr>
                    <td>State:</td>
                    <td>${UserProf.state}</td>
                </tr>
                <tr>
                    <td>Country:</td>
                    <td>${UserProf.country}</td>
                </tr>
                <tr>
                    <td>Pincode:</td>
                    <td>${UserProf.pincode}</td>
                </tr>    
            </table>
            <!-- <a type="button" href="login">Back</a> -->
            <input type="button" onclick="history.back();" value="Back">
    </div>
</body>
</html>