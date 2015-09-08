<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Welcome</title>
</head>
<body>
<center>
<h4>
Welcome ${dataMap.get("user").getUserFname()}
</h4>
<table border="1">
<thead>
 <th colspan=4>Product List</th>
 <tr>
    <th>Product Name</th>
    <th>Product Price</th>
    <th>Product Category</th>
    <th>Product Image Name</th>
  </tr>
</thead>

 <tbody> 
 <c:forEach items="${dataMap['productList']}" var="product">
    <tr>
      <td>${product.pName}</td>
      <td>${product.price}</td>
      <td>${product.category}</td>
      <td>${product.imageName}</td>
      <td>
<input type="button" id="" value="Add to cart" disabled />

	</td>
    </tr>
  </c:forEach> 
  </tbody>
</table> 
</center>
</body>
</html>



