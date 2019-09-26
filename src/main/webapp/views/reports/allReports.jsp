<%@ page import="java.util.ArrayList" %>
<%@ page import="com.franco.vm.bean.SaleBean" %>
<%@ page import="com.franco.vm.controllers.reports.PublishReportsServlet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.franco.vm.model.Sale" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sales</title>
    <link rel="stylesheet" href="../../css/styles.css">
    <link href="./js/main.js" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
</head>
<body>
<br><br><br>

<br><br>
<h1 style="text-align: center">Reports</h1>

<table class="table table-bordered" style="margin-left: 15%;width:70%">
    <thead>
    <tr>
        <th scope="col">Sale Id</th>
        <th scope="col">Date</th>
        <th scope="col">Product</th>
        <th scope="col">Quantity Bought</th>
        <%--<th scope="col"></th>--%>
        <th scope="col">Total Amount</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sales}" var="sale">
        <tr>
            <td>${sale.id}</td>
            <td>${sale.date}</td>
            <td>${sale.product}</td>
            <td>${sale.quantity}</td>

            <td>${sale.amount}</td>

        </tr>

    </c:forEach>
    </tbody>
</table>

<div style="margin-left: 30%">
    <a href="/index.jsp"><button class="btn btn-outline-info" type="reset">Back</button></a>
</div>
<br><br>

</body>
</html>

</body>
</html>
