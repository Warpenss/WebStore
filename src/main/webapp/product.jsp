<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Add New Product</title>
</head>
<body>
<form action="ProductController" method="post">
    <fieldset>
        <div>
            <label>Product ID</label> <input type="text"
                                             name="productId"
                                             value="<c:out value="${product.productId}" />"
                                             readonly="readonly"
                                             placeholder="Product ID" />
        </div>
        <div>
            <label>Name</label> <input type="text"
                                       name="productName"
                                       value="<c:out value="${product.productName}" />"
                                       placeholder="productName" />
        </div>
        <div>
            <label >Description</label> <input type="text"
                                               name="productDescription"
                                               value="<c:out value="${product.productDescription}" />"
                                               placeholder="productDescription" />
        </div>
        <div>
            <label>Image</label> <input type="text"
                                        name="productImage"
                                        value="<c:out value="${product.productImage}" />"
                                        placeholder="productImage" />
        </div>
        <div>
            <label>Price</label> <input type="text"
                                        name="productPrice"
                                        value="<c:out value="${product.productPrice}" />"
                                        placeholder="productPrice" />
        </div>
        <div>
            <input type="submit" value="Submit" />
        </div>
    </fieldset>
</form>
</body>
</html>