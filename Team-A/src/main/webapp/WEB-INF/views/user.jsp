<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page session="false" %>


<html>
<head>
	<title>Home</title>
</head>
<body>
<div align="center">
<h1>
	Hi ${User.fname}  
</h1>

<br>
<br>
<h2>Product list</h2>
<table border="1">
<tr>
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
      <td>${product.pId}</td>
      <td>${product.pName}</td>
      <td>${product.quantity}</td>
      <td>${product.depID}</td>
      <td>${product.price}</td>
      <td>${product.prodDes}</td>
      <td><button type="button"  disabled/>ADD TO CART</td>
    </tr>
  </c:forEach> 
  </tbody> 

</table>
<form:form action="userinfo" method="get">
          
        <input type="submit" value="My profile">
        </form:form>
        </div>
</body>
</html>