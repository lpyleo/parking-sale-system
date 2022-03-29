<%--
  Created by IntelliJ IDEA.
  User: kbdnzzzzz
  Date: 2021/12/9
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Personalpage</title>


    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="favicon.ico">

    <!-- <link href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,600,400italic,700' rel='stylesheet' type='text/css'> -->

    <!-- Animate.css -->
    <link rel="stylesheet" href="<%=path%>/Miao/personal/css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="<%=path%>/Miao/personal/css/icomoon.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="<%=path%>/Miao/personal/css/bootstrap.css">
    <!-- Theme style  -->
    <link rel="stylesheet" href="<%=path%>/Miao/personal/css/style.css">

    <style type="text/css">
        .input_radio li {
            display: inline-block;
            position: relative;
            list-style: none;
            margin-right: 10px;
        }
        .input_radio input[type="radio"] {
            display: none;
        }
        .input_radio span {
            padding: 0 12px;
            display: inline-block;
            background: #F4F4F4;
            border: 1px solid #F4F4F4;
            border-radius: 4px;
            line-height: 28px;
            text-align: center;
            color: #2D333B;
            cursor: pointer;
        }
        .input_radio input:checked+span {
            background: rgba(93,142,216,0.16);
            border-color: #17e7a4;
            color: #17e7a4;
        }
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
    <script src="<%=path%>/Miao/personal/js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="<%=path%>/Miao/personal/js/respond.min.js"></script>
    <![endif]-->

</head>
<body style="background-image: url(<%=path%>/Miao/personal/images/bg_img.jpg);">

<%--<%--%>
<%--    Date d = new Date();--%>
<%--    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");--%>
<%--    String now = df.format(d);--%>
<%--    long nowdate = d.getTime();--%>
<%--%>--%>

<div id="fh5co-main">
    <div class="fh5co-tab-wrap">
        <ul class="fh5co-tab-menu">
            <li <c:if test="${state==1}">class="active"</c:if>><a href="#" data-tab="1"><span class="icon icon-glass"></span><span class="menu-text">Profile</span></a></li>
            <li <c:if test="${state==2}">class="active"</c:if>><a href="#" data-tab="2"><span class="icon icon-graduation-cap"></span><span class="menu-text">Info</span></a></li>
            <li <c:if test="${state==3}">class="active"</c:if>><a href="#" data-tab="3"><span class="icon icon-black-tie"></span><span class="menu-text">Property</span></a></li>
            <li <c:if test="${state==4}">class="active"</c:if>><a href="#" data-tab="4" data-pie="yes"><span class="icon icon-fighter-jet"></span><span class="menu-text">Coupon</span></a></li>
        </ul>
        <div class="fh5co-tab-content <c:if test="${state==1}">active</c:if>" data-content="1">
            <div class="fh5co-content-inner text-center">
                <div class="row row-bottom-padded-sm">
                    <div class="col-md-12">
                        <figure>
                            <img src="<%=path%>/Miao/personal/images/profile_img.png">
                        </figure>
                        <h1>${user.userName}</h1>
                    </div>
                </div>
                <ul class="fh5co-social">
                    <li><a href="#"><i class="icon-envelope"></i></a></li>
                    <li><a href="#"><i class="icon-twitter"></i></a></li>
                    <li><a href="#"><i class="icon-instagram"></i></a></li>
                    <li><a href="#"><i class="icon-google"></i></a></li>
                    <li><a href="#"><i class="icon-linkedin"></i></a></li>
                </ul>
            </div>
        </div>
        <div class="fh5co-tab-content <c:if test="${state==2}">active</c:if>" data-content="2">
            <div class="fh5co-content-inner">
                <div class="row">
                    <div class="col-md-12">
                        <p>Basic info:</p>
                        <form action="${pageContext.request.contextPath}/user/updateuserinfo" method="POST">
                            <div class="fh5co-feature">
                                <div class="fh5co-icon">
                                    <i class="icon-user"></i>
                                </div>
                                <div class="fh5co-text">
                                    <h2>昵称</h2>
                                    </br>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="${user.userName}" name="username">
                                    </div>
                                    </br>
                                </div>
                            </div>

                            <div class="fh5co-feature">
                                <div class="fh5co-icon">
                                    <i class="icon-user"></i>
                                </div>
                                <div class="fh5co-text">
                                    <h2>电话</h2>
                                    </br>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="${user.userPhone}" name="userphone">
                                    </div>
                                    </br>
                                </div>
                            </div>

                            <div class="fh5co-feature">
                                <div class="fh5co-icon">
                                    <i class="icon-user"></i>
                                </div>
                                <div class="fh5co-text">
                                    <h2>邮箱</h2>
                                    </br>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="${user.userIdentity}"  name="useremail">
                                        <input type="text" class="form-control" value="${user.userIdentity}"  name="userid" style="display: none">
                                    </div>
                                    </br>
                                </div>
                            </div>

                            <div class="fh5co-feature">
                                <div class="fh5co-icon">
                                    <i class="icon-joomla"></i>
                                </div>
                                <div class="fh5co-text">
                                    <h2>性别</h2>
                                    <!--									<label class="radio-inline"><input type="radio" name="optradio" checked>男</label>-->
                                    <!--									<label class="radio-inline"><input type="radio" name="optradio">女</label>-->
                                    </br>
                                    <ul class="input_radio">
                                        <li>
                                            <label for="male">
                                                <input id="male" name="sex" type="radio" value="男" <c:if test="${\"男\".equals(user.userSex)}">checked="checked"</c:if>>
                                                <span class="option-label">男</span>
                                            </label>
                                        </li>
                                        <li>
                                            <label for="female">
                                                <input id="female" name="sex" value="女" type="radio" <c:if test="${\"女\".equals(user.userSex)}">checked="checked"</c:if>>
                                                <span class="option-label">女</span>
                                            </label>
                                        </li>
                                    </ul>
                                    </br>
                                </div>
                            </div>

                            <div class="fh5co-feature">
                                <div class="fh5co-icon">
                                    <i class="icon-graduation-cap"></i>
                                </div>
                                <div class="fh5co-text">
                                    <h2>住址</h2>
                                    <div class="form-group row">
                                        <div class="col-xs-4">
                                            <label for="ex1" style="font-size: 15px">小区:</label>
                                            <input class="form-control" id="ex1" type="text" placeholder="${user.userResidentialQuarters}"  name="userquarter">
                                        </div>
                                        <div class="col-xs-4">
                                            <label for="ex2" style="font-size: 15px">楼:</label>
                                            <input class="form-control" id="ex2" type="text" placeholder="${user.userBuildingNumber}"  name="userbuilding">
                                        </div>
                                        <div class="col-xs-3">
                                            <label for="ex3" style="font-size: 15px">房间号:</label>
                                            <input class="form-control" id="ex3" type="text" placeholder="${user.userHouseNumber}"  name="userhouse">
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="fh5co-feature">
                                </br>
                                <div class="form-group" style="text-align: center">
                                    <input type="submit" value="Save Change" class="btn btn-primary">
                                </div>
                                </br>
                            </div>

                            <c:if test="${updatestate==1}">
                                <div id="fade1" class="black_overlay1"></div>
                                <div id="light1" class="fh5co-feature white_content2">
                                    <div class="turnoff">
                                        <i class="icon-power-off" onclick = "document.getElementById('light1').style.display='none';document.getElementById('fade1').style.display='none'"></i>
                                    </div>

                                    <div style="margin-top: 75px;text-align: center">
                                        <i style="font-size: 30px;">修改成功！</i>
                                    </div>

                                </div>
                            </c:if>

                            <c:if test="${updatestate==2}">
                                <div id="fade2" class="black_overlay1"></div>
                                <div id="light2" class="fh5co-feature white_content2">
                                    <div class="turnoff">
                                        <i class="icon-power-off" onclick = "document.getElementById('light2').style.display='none';document.getElementById('fade2').style.display='none'"></i>
                                    </div>

                                    <div style="margin-top: 75px;text-align: center">
                                        <i style="font-size: 30px;">修改失败！</i>
                                    </div>

                                </div>
                            </c:if>
                        </form>

                    </div>

                </div>
            </div>
        </div>
        <div class="fh5co-tab-content <c:if test="${state==3}">active</c:if>" data-content="3">
            <div class="fh5co-content-inner">
                <div class="row">
                    <div class="col-md-12">

                        <h4>My Bankcard:</h4>

                        <c:forEach items="${bankcardlist}" var="bankcard" varStatus="status">
                            <div class="fh5co-feature">
                                <div class="fh5co-icon">
                                    <i class="icon-cc-paypal"></i>
                                </div>
                                <div class="fh5co-text">
                                    <h2>${bankcard.bank}</h2>
                                    <p>${bankcard.bankcardId}</p>
                                </div>
                            </div>
                        </c:forEach>


                        <div class="fh5co-feature">
                            <div class="form-group" style="text-align: center">
                                <input type="submit" value="Add More" class="btn btn-primary" onclick = "document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">
                            </div>
                            </br>
                        </div>

                        <div id="light" class="fh5co-feature white_content">
                            <form action="${pageContext.request.contextPath}/user/addbankcard" method="POST">
                                <div class="turnoff">
                                    <i class="icon-power-off" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'"></i>
                                </div>
                                <div class="form-group" style="display: none">
                                    <input type="text" class="form-control" name="userid" value="${user.userIdentity}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="银行" name="bank">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="银行卡号" name="bankcardid">
                                </div>
                                <br>
                                <div class="form-group" style="text-align: center">
                                    <input type="submit" value="add" class="btn btn-primary">
                                </div>
                            </form>
                        </div>

                        <c:if test="${insertstate==1}">
                            <div id="fade1" class="black_overlay1"></div>
                            <div id="light1" class="fh5co-feature white_content2">
                                    <div class="turnoff">
                                        <i class="icon-power-off" onclick = "document.getElementById('light1').style.display='none';document.getElementById('fade1').style.display='none'"></i>
                                    </div>

                                    <div style="margin-top: 75px;text-align: center">
                                        <i style="font-size: 30px;">插入成功！</i>
                                    </div>

                            </div>
                        </c:if>

                        <c:if test="${insertstate==2}">
                            <div id="fade2" class="black_overlay1"></div>
                            <div id="light2" class="fh5co-feature white_content2">
                                <div class="turnoff">
                                    <i class="icon-power-off" onclick = "document.getElementById('light2').style.display='none';document.getElementById('fade2').style.display='none'"></i>
                                </div>

                                <div style="margin-top: 75px;text-align: center">
                                    <i style="font-size: 30px;">插入失败！</i>
                                </div>

                            </div>
                        </c:if>

                        <div id="fade" class="black_overlay"></div>

                        <h4>My Balance:</h4>
                        <div class="fh5co-feature">
                            <div class="fh5co-icon">
                                <i class="icon-user-plus"></i>
                            </div>
                            <div class="fh5co-text">
                                <h2>账户余额</h2>
                                <p>${user.money}</p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="fh5co-tab-content <c:if test="${state==4}">active</c:if>" data-content="4">
            <div class="fh5co-content-inner">
                <div class="row">
                    <div class="col-md-12">
                        <p>My Coupon:</p>
                    </div>
                    <c:forEach items="${couponlist}" var="coupon" varStatus="status">
                        <div class="col-md-6 col-sm-6 col-xs-12 text-center">
                            <a href="${pageContext.request.contextPath}/user/userorder?userid=${user.userIdentity}"><div class="chart" data-percent="${coupon.percent}"><span><strong>${coupon.couponContent}</strong>${coupon.percent}%</span></div></a>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>
    </div>
    <footer id="fh5co-footer">
        <div class="row">
            <div class="col-md-6 col-md-offset-3 text-center">
                <small>
                    <p>Copyright 2021  <a href="#">Module</a>. All Rights Reserved. <br>Made with <i class="icon-heart3"></i> by <a href="https://github.com/YM-huang" target="_blank">Miao</a></p>
                </small>
            </div>
        </div>
    </footer>
</div>

<!-- jQuery -->
<script src="<%=path%>/Miao/personal/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="<%=path%>/Miao/personal/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="<%=path%>/Miao/personal/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="<%=path%>/Miao/personal/js/jquery.waypoints.min.js"></script>
<!-- Easy PieChart -->
<script src="<%=path%>/Miao/personal/js/jquery.easypiechart.min.js"></script>
<!-- MAIN JS -->
<script src="<%=path%>/Miao/personal/js/main.js"></script>

</body>
</html>


