<%--
  Created by IntelliJ IDEA.
  User: kbdnzzzzz
  Date: 2021/12/14
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String path = request.getContextPath(); %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>orderlist</title>

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

        <c:if test="${orderFinalState==1}">
            <div id="fade1" class="black_overlay1"></div>
            <div id="light1" class="fh5co-feature white_content2" onclick = "document.getElementById('light1').style.display='none';document.getElementById('fade1').style.display='none'">

                <div style="margin-top: 75px;text-align: center">
                    <i style="font-size: 30px;">余额不足！</i>
                </div>

            </div>
        </c:if>

        <c:if test="${orderFinalState==2}">
            <div id="fade1" class="black_overlay1"></div>
            <div id="light1" class="fh5co-feature white_content2" onclick = "document.getElementById('light1').style.display='none';document.getElementById('fade1').style.display='none'">

                <div style="margin-top: 75px;text-align: center">
                    <i style="font-size: 30px;">成功！</i>
                </div>

            </div>
        </c:if>

        <c:if test="${orderFinalState==3}">
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
                                    <li class="active"><a href="${pageContext.request.contextPath}/user/userorder?userid=${userid}">订单中心</a></li>
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
                                        <h2 class="heading-title">${username}'s Order</h2>
                                        <p class="fh5co-lead"><i class="icon-heart3"></i><i class="icon-heart3"></i><i class="icon-heart3"></i></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </aside>

        <div id="fh5co-about">

            <div class="container">
                <div class="row">
                    <c:forEach items="${orderlist}" var="order" varStatus="status">
                        <div class="col-sm-6 text-center animate-box" data-animate-effect="fadeIn">
                            <div class="fh5co-staff">
                                <img class="img-responsive" src="<%=path%>/img/${order.parkingSpaceId}.jpg" alt=" ">
                                <c:if test="${order.state==1}"><span class="list-prop1">待处理</span></c:if>
                                <c:if test="${order.state==2}"><span class="list-prop2">签名阶段</span></c:if>
                                <c:if test="${order.state==3}"><span class="list-prop3">尾款阶段</span></c:if>
                                <c:if test="${order.state==4}"><span class="list-prop4">订单完成</span></c:if>
                                <c:if test="${order.state==5}"><span class="list-prop4">订单取消</span></c:if>
                                <c:if test="${order.state==6}"><span class="list-prop4">订单超时</span></c:if>
                                <p>orderID:${order.orderId}</p>
                                <p>parkingspaceID:${order.parkingSpaceId}</p>
                                <p>finalPrice:${order.finalPrice}</p>
                                <p>order time:<fmt:formatDate value="${order.orderTime}" pattern="yyyy/MM/dd"/></p>
                                <p>generated time:<fmt:formatDate value="${order.finalPaymentTime}" pattern="yyyy/MM/dd"/></p>
                                <p class="fh5co-social-icons">
                                    <a href="#"><i class="icon-twitter2"></i></a>
                                    <a href="#"><i class="icon-facebook2"></i></a>
                                    <a href="#"><i class="icon-instagram"></i></a>
                                    <a href="#"><i class="icon-dribbble2"></i></a>
                                    <a href="#"><i class="icon-youtube"></i></a>
                                </p>
                                <p>
                                    <c:if test="${order.state==2}"><a class="btn btn-primary btn-outline" data-toggle="modal" data-target="#${order.orderId}">查看合同</a></c:if>
                                    <c:if test="${order.state==2}"><a class="btn btn-primary btn-outline" href="${pageContext.request.contextPath}/user/canvasUp?orderid=${order.orderId}">签订合同</a></c:if>
                                    <c:if test="${order.state==4||order.state==3}"><a class="btn btn-primary btn-outline" data-toggle="modal" data-target="#${order.orderId}">查看合同及签名</a></c:if>
                                    <a class="btn btn-primary btn-outline" href="${pageContext.request.contextPath}/user/parkspace?parkid=${order.parkingSpaceId}">车位详情</a>
                                    <c:if test="${order.state==3}"><a class="btn btn-primary btn-outline" href="${pageContext.request.contextPath}/administrators/FinishOrder?OrderId=${order.orderId}&userId=${order.contractSignatory}">完成订单</a></c:if>
                                    <c:if test="${order.state<=3}"><a class="btn btn-primary btn-outline" href="${pageContext.request.contextPath}/administrators/CancelOrder?OrderId=${order.orderId}">取消订单</a></c:if>
                                </p>

                            </div>
                        </div>
                        <div class="modal fade" id="${order.orderId}" tabindex="-1" role="dialog"
                             aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-hidden="true">&times;
                                        </button>
                                        <h4 class="modal-title">合同详情</h4>
                                    </div>
                                    <br>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-12 col-xs-12" style="text-align: center">
                                            <h4>合同：</h4>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div style="text-align: center">
                                            <img src="<%=path%>/contract/${order.orderId}.jpg" alt="合同图片" class="img-thumbnail"  style="width:80%;height: 80%;">
                                        </div>
                                    </div>
                                    <c:if test="${order.state==4||order.state==3}">
                                    <br>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-12 col-xs-12" style="text-align: center">
                                            <h4>签名：</h4>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div style="text-align: center">
                                            <img src="<%=path%>/sign/${order.orderId}.jpg" alt="签名图片" class="img-thumbnail"  style="width:80%;height: 80%;">
                                        </div>
                                    </div>
                                    </c:if>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">关闭
                                        </button>
                                    </div>
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal -->
                        </div>
                    </c:forEach>
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


