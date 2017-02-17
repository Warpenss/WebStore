<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
    <head>
        <title>WarpWebStore</title>
    </head>

    <body>
        <sql:setDataSource var="mysql"
                           driver="com.mysql.cj.jdbc.Driver"
                           url="jdbc:mysql://localhost/store_db"
                           user="root"
                           password="wasd12"/>

        <sql:query var="query" dataSource="${mysql}">
            SELECT * FROM products;
        </sql:query>

    <table>
        <tr>
            <th>Vendor Code</th>
            <th>Product Name</th>
            <th>Description</th>
            <th>Image</th>
            <th>Price</th>
        </tr>

        <c:forEach var="row" items="${query.rows}">
            <tr>
                <td><c:out value="${row.id}"/></td>
                <td><c:out value="${row.name}"/></td>
                <td><c:out value="${row.description}"/></td>
                <td><c:out value="${row.image}"/></td>
                <td><c:out value="${row.price}"/></td>
            </tr>
        </c:forEach>
    </table>
    </body>
</html>
