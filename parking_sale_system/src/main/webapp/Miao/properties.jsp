<%--
  Created by IntelliJ IDEA.
  User: kbdnzzzzz
  Date: 2021/12/18
  Time: 15:48
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
    <title>properties</title>


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

    <style>
        .pagination-zan {
            margin: 0;
            border-radius: 4px;
        }

        .pagination-zan li > a, .pagination-zan li > span {
            color: #E6E6FA;
            border: 2px solid rgb(107, 105, 214);
            background-color: rgba(255, 255, 255, 0.1);
            margin-left: 10px;
            border-radius: 4px;
        }

        .pagination-zan li > a:hover, .pagination-zan li > span:hover {
            color: white;
            border: 2px solid rgb(107, 105, 214);
            background-color: rgb(107, 105, 214);
            -webkit-transition: all .3s ease;
            -moz-transition: all .3s ease;
            -o-transition: all .3s ease;
            transition: all .3s ease;
        }

        .pagination-zan .active a, .pagination-zan .active span {
            color: white;
            border: 2px solid rgb(107, 105, 214);
            background-color: rgb(107, 105, 214);
            -webkit-transition: all .3s ease;
            -moz-transition: all .3s ease;
            -o-transition: all .3s ease;
            transition: all .3s ease;
        }

        .pagination-zan .active a:hover, .pagination-zan .active span:hover {
            color: white;
            border: 2px solid rgb(107, 105, 214);
            background-color: rgb(107, 105, 214);
            -webkit-transition: all .3s ease;
            -moz-transition: all .3s ease;
            -o-transition: all .3s ease;
            transition: all .3s ease;
            cursor: not-allowed;
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

        <header id="fh5co-header-section" class="sticky-banner">
            <div class="container">
                <div class="nav-header">
                    <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle dark"><i></i></a>
                    <h1 id="fh5co-logo"><a href="index.html"><i class="icon-home"></i>Parking Space</a></h1>
                    <!-- START #fh5co-menu-wrap -->
                    <nav id="fh5co-menu-wrap" role="navigation">
                        <ul class="sf-menu" id="fh5co-primary-menu">
                            <li><a href="${pageContext.request.contextPath}/Miao/index.jsp">Home</a></li>
                            <li  class="active"><a href="${pageContext.request.contextPath}/user/manageparkingSpace?pageNum=${userpage}">Properties</a></li>
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
                                        <h2 class="heading-title">Properties</h2>
                                        <p class="fh5co-lead"><i class="icon-heart3"></i><i class="icon-heart3"></i><i class="icon-heart3"></i></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </aside>

        <div id="fh5co-properties" class="fh5co-section-gray">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
                        <h3>Newest Properties</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Velit est facilis maiores, perspiciatis accusamus asperiores sint consequuntur debitis.</p>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${parklist}" var="park" varStatus="status">
                        <div class="col-md-6 animate-box">
                            <div class="property">
                                <a href="${pageContext.request.contextPath}/user/parkspace?parkid=${park.id}" class="fh5co-property" style="background-image: url(<%=path%>/img/${park.id}.jpg);">
                                    <span class="status">
                                        <c:if test="${park.state==1}">Sale</c:if>
                                        <c:if test="${park.state==2}">Reservation</c:if>
                                        <c:if test="${park.state==3}">Sold</c:if>
                                    </span>
                                    <ul class="list-details">
                                        <li>${park.id} ft sq<li>
                                        <li>${park.views} views</li>
                                    </ul>
                                </a>
                                <div class="property-details">
                                    <h3>Properties Near in Beach</h3>
                                    <span class="price">￥${park.price}</span>
                                    <p>Residential Quarters Id:${park.residentialQuartersId}</p>
                                    <span class="address"><i class="icon-map"></i>Thomas Street, St. Louis, ${park.address}, CN</span>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <div id="zan-page" class="clearfix">
                    <ul class="pagination pagination-zan pull-right">
                        <c:if test="${pageNum!=1}"><li><a href="${pageContext.request.contextPath}/user/manageparkingSpace?pageNum=${pageNum-1}">«</a></li></c:if>
                        <c:forEach var="i" begin="1" end="${maxpage}" step="1">
                            <c:if test="${pageNum==i}"><li class='active'><span>${i}</span></li></c:if>
                            <c:if test="${pageNum!=i}"><li><a href="${pageContext.request.contextPath}/user/manageparkingSpace?pageNum=${i}"><span>${i}</span></a></li></c:if>
                        </c:forEach>
                        <c:if test="${pageNum!=maxpage}"><li><a href="${pageContext.request.contextPath}/user/manageparkingSpace?pageNum=${pageNum+1}">&raquo;</a></li></c:if>
                    </ul>
                </div>
            </div>
        </div>

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


