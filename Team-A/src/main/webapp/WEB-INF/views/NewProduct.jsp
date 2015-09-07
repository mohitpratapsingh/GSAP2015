<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ page session="false" %>

<html>
<head>
<title>New Product</title>
</head>
<body>
    <div align="center">
        <form:form action="registerProd2" method="post" commandName="registerProd">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Register Product</h2></td>
                </tr>
                <tr>
                    <td>Product Id</td>
                    <td><form:input path="pId" /></td>
                </tr>
                <tr>
                    <td>Product Name:</td>
                    <td><form:input path="pName" /></td>
                </tr> 
                 <tr>
                    <td>Department Id:</td>
                    <td><form:input path="depID" /></td>
                </tr>
                  <tr>
                    <td>Quantity:</td>
                    <td><form:input path="quantity" /></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><form:input path="price" /></td>
                </tr>
                <tr>
                    <td>Product Descritption:</td>
                    <td><form:input path="prodDes" /></td>
                </tr>

                
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Add Product" /></td>
                </tr>     
            </table>
            </form:form>
    </div>
</body>
</html>