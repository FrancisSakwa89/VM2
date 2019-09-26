<%@ page import="java.util.ArrayList" %>
<%@ page import="com.franco.vm.bean.StockBeanI" %>
<%@ page import="com.franco.vm.bean.StockBean" %>
<%@ page import="com.franco.vm.controllers.stock.StockListServlet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.franco.vm.model.Stock" %>



<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 9/26/19
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
</head>
<body>

<br><br><br><br><br>
<table class="table table-bordered" style="margin-left: 25%;width:50%">
    <thead>
    <tr>
        <th scope="col">StockId</th>
        <th scope="col">Product Name</th>
        <th scope="col">Quantity</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${stock}" var="stock">
        <tr>
            <td>${stock.id}</td>
            <td>${stock.StockBeanI.read(product).getName}</td>
            <td>${stock.quantity}</td>
            <td><a href="update-product?productId=${stock.id}" ><button class="btn btn-outline-primary" type="submit">Edit</button></a>
                <a href="delete-product?productId=${stock.id}" ><button class="btn btn-outline-danger" type="submit">Delete</button></a></td>


        </tr>

    </c:forEach>
    </tbody>
</table>
<div style="margin-left: 30%">
    <a href="add-product" ><button class="btn btn-outline-success" type="submit">Add Stock</button></a>
    <a href="/index.jsp"><button class="btn btn-outline-dark" type="reset">Back</button></a>
</div>
</body>
</html>
