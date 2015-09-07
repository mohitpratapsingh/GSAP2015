<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
admin
</h1>
<h2>
Welcome ${dataMap.get("user").getUserFname()}
</h2>



<table border="1"  id="productTable" >
<thead>
 <tr>Product List</tr>
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

<!-- 

// Alternate method using DOM for checkboxes

<script type="text/javascript">
 
        var tab = document.getElementById("productTable");
        if (tab != null) {
            for (var i = 0; i < tab.rows.length; i++) {
                for (var j = 0; j < tab.rows[i].cells.length; j++)
                    tab.rows[i].cells[0].onclick = function () { getval(this); };
            }
        }
 
        function getval(cel) {
        	//alert(cel.innerHTML);
        	//if(cel.checked)
        		alert(cel.checked);
        }
</script> -->


</body>
</html>
