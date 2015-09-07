<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Welcome</title>
</head>
<body>
<h4>
Welcome ${dataMap.get("user").getUserFname()}
</h4>
<table border="1">
<thead>
 <tr>Product List</tr>
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
    </tr>
  </c:forEach> 
  </tbody>
</table> 
</body>
</html>



