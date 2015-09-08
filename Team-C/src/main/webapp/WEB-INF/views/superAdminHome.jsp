<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>

</head>
<center>
<body>
<h2 color="green">
Welcome ${dataMap.get("user").getUserFname()}
</h2>

<h3 color="blue"> ${prodMsg}</h3>
<h3><p id="notSelected"></h3>

<p1>
<table border="1">
<thead>
 <tr><h2>Product List</h2></tr>
 <tr>
 	<th>selection</th>
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
  </tbody>
</table> 
</p1>
</br>
<table>
<tr></tr>
<tr>
<td>
<input type="button" value="Add Product" onclick="window.location='addProductForm';" />
</td>
<td>
<button onclick="delProduct()">Delete product</button>
</td>
</tr></table>
<p2/>
<p2/>
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
</p2>
</p3>
<table border="1">
<thead>
 <tr><h2>Admin List</h2></tr>
 <tr>
    <th>Name</th>
    <th>Email ID</th>
   <!--  <th>Address</th> -->
<!--     <th>Phone number</th>
    <th>Gender</th> -->
  </tr>
</thead>

 <tbody> 
 <c:forEach items="${dataMap.get(\"adminList\")}" var="admin">
    <tr>
    <td><input type="checkbox" id="cbox" value="${admin.getEmailId()}"  onclick="onCheckbox2 (this)" /></td>
      <td>${admin.getUserFname()} ${admin.getUserLname()}</td>
      <td>${admin.getEmailId()}</td>
       
    </tr>
  </c:forEach> 
  </tbody>
</table>
<table>
<tr></tr>
<tr>
<td>
<input type="button" value="Add Admin" onclick="window.location='adminRegForm';" />
</td>
<td>
<input type="button" id="delAdmin" value="Delete Admin"  onclick="delAdmin()" />

</td>
</tr></table> 
</p3>

<script type="text/javascript">
/* var checker = document.getElementById('cbox');
var sendbtn = document.getElementById('delAdmin'); */
var userNameList=[];
 function onCheckbox2(checkbox) {
	 //if(sendbtn.disabled== false){sendbtn.disabled = false;}
  		
  if (checkbox.checked) 
  {
	  userNameList.push(checkbox.value);
  }
  else 
  {
  		var index;
  		for(i=0;i<userNameList.length;i++)
  		{
  			if(userNameList[i]==checkbox.value)
  			index=i;
  		}
  		if(index > -1)
  			userNameList.splice(index,1);
  }
  
  
};

function delAdmin() {
	
	if(userNameList.length)
		window.location.href = "deleteAdmin?userNameList=" + userNameList;
	else 
		alert("no item selected");
}


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
        	if(test.length){window.location = "deleteProduct?prodIductList=" +test;
                }		
        	else 
        		//document.getElementById("notSelected").innerHTML="No Items selected!";
        	alert("no item selected")

        }
      
      
    </script>


</body>
</center>
</html>
