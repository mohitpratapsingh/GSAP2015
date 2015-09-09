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
	<div align="center">
		<h2>
			<div align="center"><font color="red">${Message}</div>
		</h2>

 		<div id="DemoDelete">
 		</div>
		<table border="1" bgcolor="#F5FFFF">
			<form:form action="Superuser" method="post" commandName="selectedProduct">
			 	<tr>
			    	<td colspan="7" align="center"><h2>Product Details</h2></td>
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
					      <td><form:checkbox path="productIds" value="${product.pId}"/></td>
					      <td>${product.pId}</td>
					      <td>${product.pName}</td>
					      <td>${product.quantity}</td>
					      <td>${product.depID}</td>
					      <td>${product.price}</td>
					      <td>${product.prodDes}</td>
					    </tr>
					  </c:forEach>
					  <td colspan="4" align="center">
					  	<!-- <input type="submit" value="Delete Product" onClick="deleteCheck()"> -->
					  	<input type="submit" value="Delete Product" >
					  </td>  
				  </form:form>
				  <td colspan="3" align="center">
					  <form:form action="registerProd1" method="post" commandName="registerProd">
					        <input type="submit" value="AddProduct">
					  </form:form>
				  </td>
		        </tbody>
		</table>
	<br>
	<br>
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
		</table>
	  <br>
	  <br>
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
				  <tr>
				  	<td colspan=9 align="center" >
					<form:form action="registerAdmin1" method="post" commandName="registerAdmin">
				   		 <input type="submit" value="AddAdmin">
					 </form:form>
				     </td>
				  </tr>
			  </tbody> 
  	</div>
	</body>
</html>

<!-- <script>
function deleteCheck() {
    if("${product.pId}"==0) {
    	document.getElementById("DemoDelete").innerHTML = "Choose one Product";
    }
    else
    	document.getElementById("DemoDelete").innerHTML = "Choose one Product";
}

</script> -->