<%--
  Created by IntelliJ IDEA.
  User: kbdnzzzzz
  Date: 2021/12/19
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>parkinglist</title>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="favicon.ico">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,300' rel='stylesheet' type='text/css'>

    <!-- Animate.css -->
    <link rel="stylesheet" href="<%=path%>/Miao/css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="<%=path%>/Miao/css/icomoon.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="<%=path%>/Miao/css/bootstrap.css">
    <!-- Superfish -->
    <link rel="stylesheet" href="<%=path%>/Miao/css/superfish.css">
    <!-- Flexslider  -->
    <link rel="stylesheet" href="<%=path%>/Miao/css/flexslider.css">
    <!-- Magnific Popup -->
    <link rel="stylesheet" href="<%=path%>/Miao/css/magnific-popup.css">
    <!-- Date Picker -->
    <link rel="stylesheet" href="<%=path%>/Miao/css/bootstrap-datepicker.min.css">
    <!-- CS Select -->
    <link rel="stylesheet" href="<%=path%>/Miao/css/cs-select.css">
    <link rel="stylesheet" href="<%=path%>/Miao/css/cs-skin-border.css">

    <link rel="stylesheet" href="<%=path%>/Miao/css/style.css">


    <link rel="stylesheet" href="<%=path%>/Miao/css/style2.css">

    <style type="text/css">
        .black_overlay{
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: black;
            z-index:1001;
            -moz-opacity: 0.8;
            opacity:.80;
            filter: alpha(opacity=88);
        }
        .black_overlay1{
            /*display: none;*/
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: black;
            z-index:1001;
            -moz-opacity: 0.8;
            opacity:.80;
            filter: alpha(opacity=88);
        }
        .white_content {
            display: none;
            position: absolute;
            top: 25%;
            left: 25%;
            width: 55%;
            height: 50%;
            padding: 20px;
            border: 1px solid #17e7a4;
            /*background-color: white;*/
            z-index:1002;
            overflow: auto;
        }
        .white_content2 {
            /*display: none;*/
            position: absolute;
            top: 10%;
            left: 35%;
            width: 30%;
            height: 10%;
            padding: 20px;
            border: 1px solid #17e7a4;
            /*background-color: white;*/
            z-index:1002;
            overflow: auto;
        }
        .turnoff {
            float: left;
            width: 10%;
            display: block;
            color: white;
            margin-bottom: 10px;
        }
        .turnoff:hover {
            color: #17e7a4;
        }
    </style>

    <!-- Modernizr JS -->
    <script src="<%=path%>/Miao/js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="<%=path%>/Miao/js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div id="fh5co-wrapper">
    <div id="fh5co-page">

        <c:if test="${orderstate==1}">
            <div id="fade1" class="black_overlay1"></div>
            <div id="light1" class="fh5co-feature white_content2" onclick = "document.getElementById('light1').style.display='none';document.getElementById('fade1').style.display='none'">

                <div style="margin-top: 75px;text-align: center">
                    <i style="font-size: 30px;">余额不足！</i>
                </div>

            </div>
        </c:if>

        <c:if test="${orderstate==2}">
            <div id="fade1" class="black_overlay1"></div>
            <div id="light1" class="fh5co-feature white_content2" onclick = "document.getElementById('light1').style.display='none';document.getElementById('fade1').style.display='none'">

                <div style="margin-top: 75px;text-align: center">
                    <i style="font-size: 30px;">成功！</i>
                </div>

            </div>
        </c:if>

        <c:if test="${orderstate==3}">
            <div id="fade1" class="black_overlay1"></div>
            <div id="light1" class="fh5co-feature white_content2" onclick = "document.getElementById('light1').style.display='none';document.getElementById('fade1').style.display='none'">

                <div style="margin-top: 75px;text-align: center">
                    <i style="font-size: 30px;">失败！</i>
                </div>

            </div>
        </c:if>

        <header id="fh5co-header-section" class="sticky-banner">
            <div class="container">
                <div class="nav-header">
                    <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle dark"><i></i></a>
                    <h1 id="fh5co-logo"><a href="index.html"><i class="icon-home"></i>Parking Space</a></h1>
                    <!-- START #fh5co-menu-wrap -->
                    <nav id="fh5co-menu-wrap" role="navigation">
                        <ul class="sf-menu" id="fh5co-primary-menu">
                            <li><a href="${pageContext.request.contextPath}/Miao/index.jsp">Home</a></li>
                            <li><a href="${pageContext.request.contextPath}/user/manageparkingSpace?pageNum=${userpage}">Properties</a></li>
                            <li><a href="${pageContext.request.contextPath}/Miao/contact.jsp">Contact</a></li>
                            <%
                                String username=(String)session.getAttribute("username");
                                if("".equals(username)  || username==null){
                                    out.println("<li><a href=\"login.jsp\">登录</a></li>");
                                }
                                else{%>
                            <li><a href="${pageContext.request.contextPath}/user/personalinfo?userid=${userid}" class="fh5co-sub-ddown">Hi,${username}!</a>
                                <ul class="fh5co-sub-menu">
                                    <li><a href="${pageContext.request.contextPath}/user/personalinfo?userid=${userid}">个人中心</a></li>
                                    <li><a href="${pageContext.request.contextPath}/user/bankcard?userid=${userid}">钱包</a></li>
                                    <li><a href="${pageContext.request.contextPath}/user/bankcard?userid=${userid}">银行卡</a></li>
                                    <li><a href="${pageContext.request.contextPath}/user/userorder?userid=${userid}">订单中心</a></li>
                                    <li><a href="${pageContext.request.contextPath}/user/selectcoupon?userid=${userid}">优惠券</a></li>
                                </ul>
                            </li>
                            <% session.setAttribute("user", username);}%>

                        </ul>
                    </nav>
                </div>
            </div>
        </header>

        <!-- end:header-top -->

        <aside id="fh5co-hero" class="js-fullheight">
            <div class="flexslider js-fullheight">
                <ul class="slides">
                    <li style="background-image: url(<%=path%>/Miao/images/img_bg_3.jpg);">
                        <div class="overlay"></div>
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-md-8 col-md-offset-2 text-center js-fullheight slider-text">
                                    <div class="slider-text-inner">
                                        <h2 class="heading-title">${parkspace.id}</h2>
                                        <p class="fh5co-lead"><i class="icon-heart3"></i><i class="icon-heart3"></i><i class="icon-heart3"></i></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </aside>

        <main id="fh5co-main" role="main">
            <div class="container pb-lg">

                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <div class="fh5co-heading text-center">
                            <h2 class="fh5co-heading-uppercase">Description</h2>
                            <h3 class="fh5co-heading-intro mb-md">www一个很好的车位www</h3>

                            <h2 class="fh5co-heading-uppercase">Share this parkingspace</h2>
                            <ul class="fh5co-social">
                                <li><a href="#"><i class="ti-facebook"></i> Facebook</a></li>
                                <li><a href="#"><i class="ti-twitter-alt"></i> Twitter</a></li>
                                <li><a href="#"><i class="ti-google"></i> GooglePlus</a></li>
                                <li><a href="#"><i class="ti-pinterest"></i> Pinterest</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- END .row -->
                <div class="row">
                    <div class="col-md-12 mb-lg" >
                        <figure>
                            <img src="<%=path%>/img/${parkspace.id}.jpg" class="img-responsive" alt="Project Title here" style="text-align: center">
                        </figure>
                    </div>
                </div>
                <!-- END .row -->


                <!-- END .row -->
                <div class="row mb-md">
                    <div class="col-md-12 text-center">
                        <p>
                            price:${parkspace.price}
                        </p>
                    </div>
                    <div class="form-group" style="text-align: center">
                        <c:if test="${parkspace.state==1}"><button class="btn btn-primary"><a style="color: #fff;" href="${pageContext.request.contextPath}/administrators/GenerateOrder?parkingSpaceId=${parkspace.id}&contractSignatory=${userid}&contractInitiator=${developerid}">Buy!</a></button></c:if>
                        <c:if test="${parkspace.state==2}"><button class="btn btn-primary" disabled>In Reservation!</button></c:if>
                        <c:if test="${parkspace.state==3}"><button class="btn btn-primary" disabled>Sold Out!</button></c:if>
                    </div>
                </div>

            </div>


        </main>
        <!-- fh5co-blog-section -->

        <footer>
            <div id="footer">
                <div class="container">
                    <div class="row row-bottom-padded-md">
                        <div class="col-md-3">
                            <h3 class="section-title">About Homestate</h3>
                            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics.</p>
                        </div>

                        <div class="col-md-3 col-md-push-1">
                            <h3 class="section-title">Links</h3>
                            <ul>
                                <li><a href="#">Home</a></li>
                                <li><a href="#">Properties</a></li>
                                <li><a href="#">Agent</a></li>
                                <li><a href="#">Blog</a></li>
                                <li><a href="#">API</a></li>
                                <li><a href="#">FAQ / Contact</a></li>
                            </ul>
                        </div>

                        <div class="col-md-3">
                            <h3 class="section-title">Information</h3>
                            <ul>
                                <li><a href="#">Terms &amp; Condition</a></li>
                                <li><a href="#">License</a></li>
                                <li><a href="#">Privacy &amp; Policy</a></li>
                                <li><a href="#">Contact Us</a></li>
                            </ul>
                        </div>
                        <div class="col-md-3">
                            <h3 class="section-title">Newsletter</h3>
                            <p>Subscribe for our newsletter</p>
                            <form class="form-inline" id="fh5co-header-subscribe">
                                <div class="row">
                                    <div class="col-md-12 col-md-offset-0">
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="email" placeholder="Enter your email">
                                            <button type="submit" class="btn btn-default"><i class="icon-paper-plane"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <p class="fh5co-social-icons">
                                <a href="#"><i class="icon-twitter2"></i></a>
                                <a href="#"><i class="icon-facebook2"></i></a>
                                <a href="#"><i class="icon-instagram"></i></a>
                                <a href="#"><i class="icon-dribbble2"></i></a>
                                <a href="#"><i class="icon-youtube"></i></a>
                            </p>
                            <p>Copyright 2021  <a href="#">Module</a>. All Rights Reserved. <br>Made with <i class="icon-heart3"></i> by <a href="https://github.com/YM-huang" target="_blank">Miao</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>



    </div>
    <!-- END fh5co-page -->

</div>
<!-- END fh5co-wrapper -->

<!-- jQuery -->


<script src="<%=path%>/Miao/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="<%=path%>/Miao/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="<%=path%>/Miao/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="<%=path%>/Miao/js/jquery.waypoints.min.js"></script>
<script src="<%=path%>/Miao/js/sticky.js"></script>
<!-- Superfish -->
<script src="<%=path%>/Miao/js/hoverIntent.js"></script>
<script src="<%=path%>/Miao/js/superfish.js"></script>
<!-- Flexslider -->
<script src="<%=path%>/Miao/js/jquery.flexslider-min.js"></script>
<!-- Date Picker -->
<script src="<%=path%>/Miao/js/bootstrap-datepicker.min.js"></script>
<!-- CS Select -->
<script src="<%=path%>/Miao/js/classie.js"></script>
<script src="<%=path%>/Miao/js/selectFx.js"></script>


<!-- Main JS -->
<script src="<%=path%>/Miao/js/main.js"></script>

</body>
</html>
