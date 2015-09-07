<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Product form</title>
</head>
<body>
<center>
<h2>Product</h2>
<form:form method="POST" action="addProduct"  commandName="addProductForm">
   <table>
    <tr>
        <td><form:label path="pName">Product Name</form:label></td>
        <td><form:input path="pName" /></td>
         <td><form:errors path="pName" cssclass="error"></form:errors></td> 
    </tr>
    <tr>
        <td><form:label path="price">Price</form:label></td>
        <td><form:input path="price" /></td>
         <td><form:errors path="price" cssclass="error"></form:errors></td> 
    </tr>
    <tr>
        <td><form:label path="category">Category</form:label></td>
        <td><form:select path="category">
        			<form:option value="NONE" label="--- Select ---" />
					<form:options items="${categoryList}" />
		</form:select></td>
    </tr>
    <tr>
        <td><form:label path="imageName">Image Name</form:label></td>
        <td><form:input path="imageName" /></td>
         <td><form:errors path="imageName" cssclass="error"></form:errors></td> 
    </tr>
    
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
        <tr>
    
        <td colspan="3"><center>
            <input type="button" value="Back" onclick="window.location='productBack';" />
            
             </center>
        </td>
    
    </tr>
</table>  
</form:form>
</center>
</body>
</html>
