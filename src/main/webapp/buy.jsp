<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Buy</title>
</head>
<body>
Product ID: <c:out value="${product.productId}"/>
<br>
Name: <c:out value="${product.productName}"/>
<br>
Description: <c:out value="${product.productDescription}"/>
<br>
Image: <c:out value="${product.productImage}"/>
<br>
Price: <c:out value="${product.productPrice}"/>
<br>
<form action="Success.jsp" method="post">
First name: <input type="text" name="firstName"/>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>
