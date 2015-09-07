<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page session="false" %>


<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hi ${User.fname}  
</h1>

 <form:form action="Superuser" method="post" commandName="selectedProduct">
<table border="1">
 <tr>
                    <td colspan="6" align="center"><h2>Product Details</h2></td>
                </tr>
<tr>
<th></th>
<th>Product Id</th>
<th>Product Name </th>
<th>Quantity</th>
<th>Department Id</th>
<th>Price</th>
<th>Product Description</th>
</tr>
<tbody> 
 <c:forEach items="${Productlist}" var="product">
    <tr>
      <td><form:checkbox path="productId" value="${product.pId}"/></td>
      <td>${product.pId}</td>
      <td>${product.pName}</td>
      <td>${product.quantity}</td>
      <td>${product.depID}</td>
      <td>${product.price}</td>
      <td>${product.prodDes}</td>
    </tr>
  </c:forEach>
  <input type="submit" value="Delete Product"> 
  </tbody> 
  </form:form>
<form:form action="registerProd1" method="post" commandName="registerProd">
        <input type="submit" value="AddProduct">
        </form:form>
</table>

<table border="1">
 <tr>
                    <td colspan="12" align="center"><h2>User Details</h2></td>
                </tr>
<tr>
<th>First Name</th>
<th>Last Name </th>
<th>Email Id</th>
<th>Address Line1</th>
<th>Address Line2</th>
<th>City</th>
<th>State</th>
<th>Country</th>
<th>Pincode</th>

</tr>
<tbody> 
 <c:forEach items="${Userlist}" var="product">
    <tr>
          <td>${product.fname}</td>
      <td>${product.lname}</td>
      <td>${product.emailId}</td>
      <td>${product.addressLine1}</td>
      <td>${product.addressLine2}</td>
      <td>${product.city}</td>
      <td>${product.state}</td>
      <td>${product.country}</td>
      <td>${product.pincode}</td>
    </tr>
  </c:forEach> 
  </tbody> 
  
<table border="1">
 <tr>
                    <td colspan="12" align="center"><h2>Admin Details</h2></td>
                </tr>
<tr>
<th>First Name</th>
<th>Last Name </th>
<th>Email Id</th>
<th>Address Line1</th>
<th>Address Line2</th>
<th>City</th>
<th>State</th>
<th>Country</th>
<th>Pincode</th>

</tr>
<tbody> 
 <c:forEach items="${Adminlist}" var="product">
    <tr>
          <td>${product.fname}</td>
      <td>${product.lname}</td>
      <td>${product.emailId}</td>
      <td>${product.addressLine1}</td>
      <td>${product.addressLine2}</td>
      <td>${product.city}</td>
      <td>${product.state}</td>
      <td>${product.country}</td>
      <td>${product.pincode}</td>
    </tr>
  </c:forEach> 
  <form:form action="registerAdmin1" method="post" commandName="registerAdmin">
        <input type="submit" value="AddAdmin">
        </form:form>
  </tbody> 
</body>
</html>