<%--
  Created by IntelliJ IDEA.
  User: 95243
  Date: 2021/11/23
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>开发商登录</title>
    <!-- 引入css、js -->
    <link rel="stylesheet" href="<%=path%>/assets/css/index.css">
    <script src="<%=path%>/assets/js/index.js"></script>
</head>
<body>
<%
    String mess=(String)session.getAttribute("message");
    if("".equals(mess)  || mess==null){

    }
    else{%>
<script type="text/javascript">
    alert("<%=mess%>");
</script>
<% session.setAttribute("message", "");}%>
<!-- 搭建结构 -->
<div class="container switch">
    <!-- 注册页面 -->
    <div class="container-form container-signup">
        <form class="form" style="background: #fbf2e3" method="post" action="${pageContext.request.contextPath}/developer/examine" enctype="multipart/form-data">
            <h2 class="form-title">入驻申请</h2>
            <input type="email" placeholder="Email" class="input" name="developer_id">
            <input type="text" placeholder="Name" class="input" name="developer_name">
            <input type="file" class="input" name="file">
            <p style="border-top: #cccccc 1px solid">公司营业执照</p>
            <button class="submit">申请</button>
        </form>
    </div>
    <!-- 登录页面 -->
    <div class="container-form container-signin">
        <form class="form" style="background: #fbf2e3" action="${pageContext.request.contextPath}/developer/login" method="post">
            <h2 class="form-title">登录</h2>
            <input type="text" placeholder="User" class="input" name="username">
            <input type="password" placeholder="Password" class="input" name="password">
            <a href="javascript:void(0);">forgot your password?</a>
            <button class="submit">登录</button>
        </form>
    </div>
    <!-- 覆盖层 -->
    <div class="container-overlay">
        <div class="overlay">
            <div class="overlay-slide overlay-left">
                <button class="submit" id="goSignIn">sign in</button>
            </div>
            <div class="overlay-slide overlay-right">
                <button class="submit" id="goSignUp">sign up</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<!-- 结构搭建完成 -->
