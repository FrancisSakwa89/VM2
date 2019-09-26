<html>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="includes/navbar.jsp"%>
<html>
<head>
    <title>Home</title>
    <%--    <link rel="stylesheet" href="./css/styles.css">--%>
    <%--    <link rel="stylesheet" href="./css/homejsp.css">--%>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%--<script type="text/javascript">--%>
        <%--var  ws;--%>
        <%--function connectToServer() {--%>
            <%--var ws = new WebSocket("ws://localhost:8080/VendMachine2/chat/"+document.getElementById("phone").value)--%>
            <%--ws.onopen = function (event) {--%>
                <%--alert("connection established...")--%>
            <%--};--%>
            <%--ws.onclose = function (event) {--%>
                <%----%>
            <%--}--%>
        <%--}--%>


    <%--</script>--%>

    <!------ Include the above in your HEAD tag ---------->
</head>
<body>
<br><br><br><br>
<%--<h2>Simple chat Application</h2>--%>
<%--<input type="text" name="phone" id="phone" placeholder="phone number">--%>
<%--<input type="submit" value="connect" onclick="connectToServer();"/>--%>
<section class="wrapper fixed-top">
    <div class="overlays"></div>
    <div class="container h-80">
        <div class="row h-80 justify-content-between align-items-center">
            <div class="col-lg-12">
                <div class="text-center">
                    <%--<a href="logout"><button class="btn btn-outline-primary" type="submit">Logout</button></a>--%>
                    <a href="saleProduct"><button class="btn btn-outline-primary" type="submit">Buy Product</button></a>
                    <a href="add-product"><button class="btn btn-outline-primary" type="submit">Add Product</button></a>
                    <a href="add-stock"><button class="btn btn-outline-primary" type="submit">Add Stock</button></a>
                    <a href="all-products"><button class="btn btn-outline-primary" type="submit">All products</button></a>
                    <a href="all-stock"><button class="btn btn-outline-primary" type="submit">View Stock</button></a>
                    <a href="report"><button class="btn btn-outline-primary" type="submit">Reports</button></a>

                </div>


            </div>
        </div>
    </div>
</section>
<br><br><br><br>
<br><br>
<footer class="page-footer font-small blue pt-4">

    <br><br><br><br><br><br><br><br>

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
        <a href="https://francissakwa89.github.io/"> Sakwa Francis</a>
    </div>
    <!-- Copyright -->

</footer>

<script>
    $(window).scroll(function(){
        if( $(this).scrollTop()>50){

            // $('.navbar').css('background','#263238');


        }
    });
</script>


<style>
    body{
        height:100vh;
        font-family: 'Roboto Condensed', sans-serif;
    }

    .wrapper{
        background-position:center;
        background-size:cover;
        background-repeat:no-repeat;
        width:100%;
        height:100vh;
        position:static;
        color:white;


    }
    .overlays{
        position:absolute;
        left: 0;
        top: 0;
        right: 0;
        bottom: 0;
        opacity: .8;
        /*background: rgb(13, 13, 14);*/
    }


    @keyframes mymove {
        from {
            left:  100px;
            height: 0px;
            opacity: 0;
            border-bottom:0px;
        }
        to {
            height: auto;

        }
    }





</style>


</body>
</html>
