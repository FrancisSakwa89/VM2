<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 9/25/19
  Time: 7:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/includes/navbar.jsp"%>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Title</title>
</head>
<body>
<br><br><br><br><br>

<form action="saleProduct" method="post" style="margin-left: 35%;width:50%">

        <div class="group">
            <input type="number" required name="id">
            <span class="highlight"></span>
            <span class="bar"></span>
            <label>Product Id</label>
        </div>

            <div class="group">
                <input type="number" required name="quantity">
                <span class="highlight"></span>
                <span class="bar"></span>
                <label>Quantity</label>
            </div>

            <br>
             <h3>Enter Cash</h3>
    <br><br><br>
            <div class="group">
                <input type="number" required name="1000">
                <span class="highlight"></span>
                <span class="bar"></span>
                <label>How many one thousand notes?</label>
            </div>


            <br>
            <div class="group">
                <input type="number" required name="500">
                <span class="highlight"></span>
                <span class="bar"></span>
                <label>How many five hundred notes?</label>
            </div>

            <div class="group">
                <input type="number" required name="200">
                <span class="highlight"></span>
                <span class="bar"></span>
                <label>How many two hundred notes?</label>
            </div>

            <div class="group">
                <input type="number" required name="100">
                <span class="highlight"></span>
                <span class="bar"></span>
                <label>How many one hundred notes?</label>
            </div>

            <div class="group">
                <input type="number" required name="50">
                <span class="highlight"></span>
                <span class="bar"></span>
                <label>How many fifty notes?</label>
            </div>

    <div class="group">
        <input type="number" required name="20">
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>How many twenty bob coins</label>
    </div>

    <div class="group">
        <input type="number" required name="10">
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>How many ten bob coins?</label>
    </div>

    <div class="group">
        <input type="number" required name="5">
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>How many five bob coins</label>
    </div>

    <div class="group">
        <input type="number" required name="1">
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>How many one bob coins?</label>
    </div>

            <br>
            <button class="btn-save btn btn-success btn-sm" type="submit">Purchase</button>
            <button class="btn-cancel btn btn-danger btn-sm" type="reset">Cancel</button>
        </form>


    </div>
</form>


<script>
    $(".dropdown-menu li a").click(function(){
        var selText = $(this).text();
        $(this).parents('.btn-group').find('.dropdown-toggle').html(selText+' <span class="caret"></span>');
    });
    document.addEventListener('DOMContentLoaded', function() {
        var elems = document.querySelectorAll('select');
        var instances = M.FormSelect.init(elems, options);
    });

    // Or with jQuery

    $(document).ready(function(){
        $('select').formSelect();
    });

</script>


<style>
    * { box-sizing:border-box; }

    /* basic stylings ------------------------------------------ */
    body 				 { background:url(https://scotch.io/wp-content/uploads/2014/07/61.jpg); }
    .container 		{
        font-family:'Roboto';
        width:600px;
        margin:30px auto 0;
        display:block;
        background:#FFF;
        padding:10px 50px 50px;
    }
    h2 		 {
        text-align:center;
        margin-bottom:50px;
    }
    h2 small {
        font-weight:normal;
        color:#888;
        display:block;
    }
    .footer 	{ text-align:center; }
    .footer a  { color:#53B2C8; }

    /* form starting stylings ------------------------------- */
    .group 			  {
        position:relative;
        margin-bottom:45px;
    }
    input 				{
        font-size:18px;
        padding:10px 10px 10px 5px;
        display:block;
        width:300px;
        border:none;
        border-bottom:1px solid #757575;
    }
    input:focus 		{ outline:none; }

    /* LABEL ======================================= */
    label 				 {
        color:#999;
        font-size:18px;
        font-weight:normal;
        position:absolute;
        pointer-events:none;
        left:5px;
        top:10px;
        transition:0.2s ease all;
        -moz-transition:0.2s ease all;
        -webkit-transition:0.2s ease all;
    }

    /* active state */
    input:focus ~ label, input:valid ~ label 		{
        top:-20px;
        font-size:14px;
        color:#5264AE;
    }

    /* BOTTOM BARS ================================= */
    .bar 	{ position:relative; display:block; width:300px; }
    .bar:before, .bar:after 	{
        content:'';
        height:2px;
        width:0;
        bottom:1px;
        position:absolute;
        background:#5264AE;
        transition:0.2s ease all;
        -moz-transition:0.2s ease all;
        -webkit-transition:0.2s ease all;
    }
    .bar:before {
        left:50%;
    }
    .bar:after {
        right:50%;
    }

    /* active state */
    input:focus ~ .bar:before, input:focus ~ .bar:after {
        width:50%;
    }

    /* HIGHLIGHTER ================================== */
    .highlight {
        position:absolute;
        height:60%;
        width:100px;
        top:25%;
        left:0;
        pointer-events:none;
        opacity:0.5;
    }

    /* active state */
    input:focus ~ .highlight {
        -webkit-animation:inputHighlighter 0.3s ease;
        -moz-animation:inputHighlighter 0.3s ease;
        animation:inputHighlighter 0.3s ease;
    }

    /* ANIMATIONS ================ */
    @-webkit-keyframes inputHighlighter {
        from { background:#5264AE; }
        to 	{ width:0; background:transparent; }
    }
    @-moz-keyframes inputHighlighter {
        from { background:#5264AE; }
        to 	{ width:0; background:transparent; }
    }
    @keyframes inputHighlighter {
        from { background:#5264AE; }
        to 	{ width:0; background:transparent; }
    }

</style>

</body>
</html>
