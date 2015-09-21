<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title>admin Home</title>
</head>
<body>
<center>
<h2>
Welcome ${dataMap.get("user").getUserFname()}
</h2>
<h3 color="blue"> ${prodMsg}</h3>

<table border="1"  id="productTable" >
<thead>
 <th>Product List</th>
 <tr>
 	<th>Selection</th>
    <th>Product Name</th>
    <th>Product Price</th>
    <th>Product Category</th>
    <th>Product Image Name</th>
  </tr>
</thead>

 <tbody> 
 <c:forEach items="${dataMap.get(\"productList\")}" var="product">
    <tr>
      <td><input type="checkbox" name="products" value="${product.getpId()}" style="cursor: pointer;" onclick="onChangeCheckbox (this)" /></td>
      <td>${product.getpName()}</td>
      <td>${product.getPrice()}</td>
      <td>${product.getCategory()}</td>
      <td>${product.getImageName()}</td>
    </tr>
  </c:forEach> 
  <td>
<input type="button" value="Add Product" onclick="window.location='addProductForm';" />
</td>
<td>
<button onclick="delProduct()">Delete product</button>
</td>
  </tbody>
</table> 
<p/>
<p/>
<table border="1">
<thead>
 <th><h2>User List</h2></th>
 <tr>
    <th>Name</th>
    <th>Email ID</th>
    <th>Address</th>
    <th>Phone number</th>
    <th>Gender</th>
  </tr>
</thead>

 <tbody> 
 <c:forEach items="${dataMap.get(\"userList\")}" var="user">
    <tr>
      <td>${user.getUserFname()} ${user.getUserLname()}</td>
      <td>${user.getEmailId()}</td>
      <td>${user.getAddressLine1()} ${user.getAddressLine2()}</td>
      <td>${user.getPhoneNumber()}</td>
      <td>${user.getGender()}</td>
    </tr>
  </c:forEach> 
  </tbody>
</table> 

<script type="text/javascript">

var test=[];

        function onChangeCheckbox (checkbox) {
            if (checkbox.checked) 
            {
               test.push(checkbox.value);
            }
            
            else 
            {
            		var index;
            		for(i=0;i<test.length;i++)
            		{
            			if(test[i]==checkbox.value)
            			index=i;
            		}
            		if(index > -1)
            		test.splice(index,1);
            }
       	}
        
      function delProduct() {
        	
    	  window.location = "deleteProduct?prodIductList=" +test;

        }
    </script>
</body>
</center>
</html>
