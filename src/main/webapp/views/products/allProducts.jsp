<%@ page import="java.util.ArrayList" %>
<%@ page import="com.franco.vm.bean.ProductBean" %>
<%@ page import="com.franco.vm.bean.ProductBeanI" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.franco.vm.model.Product" %>


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

<br><br>
<table class="table table-bordered" style="margin-left: 25%;width:50%">
    <thead>
    <tr>
        <th scope="col">ProductId</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.unitPrice}</td>
            <td><a href="update-product?productId=${product.id}" ><button class="btn btn-outline-primary" type="submit">Edit</button></a>
                <a href="delete-product?productId=${product.id}" ><button class="btn btn-outline-danger" type="submit">Delete</button></a></td>


        </tr>

    </c:forEach>
    </tbody>
</table>
<div style="margin-left: 30%">
    <a href="add-product" ><button class="btn btn-outline-success" type="submit">Add product</button></a>
    <a href="/index.jsp"><button class="btn btn-outline-dark" type="reset">Back</button></a>
</div>
</body>
</html>
