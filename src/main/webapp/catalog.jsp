<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Show All Products</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>Product ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Image</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <td><c:out value="${product.productId}" /></td>
            <td><c:out value="${product.productName}" /></td>
            <td><c:out value="${product.productDescription}" /></td>
            <td><c:out value="${product.productImage}" /></td>
            <td><c:out value="${product.productPrice}" /></td>
            <td><a href="ProductController?action=buy&productId=<c:out value="${product.productId }"/>">Buy</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
    <a href="ProductController?action=insert">Add Product</a>
</p>
</body>
</html>