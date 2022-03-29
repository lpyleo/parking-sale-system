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
    <title>后台管理员登录</title>
    <!-- 引入css、js -->
    <link rel="stylesheet" href="<%=path%>/assets/css/index.css">
    <script src="<%=path%>/assets/js/index.js"></script>
</head>
<body>
<!-- 搭建结构 -->
<div class="container switch">
    <!-- 注册页面 -->
    <div class="container-form container-signup">
        <form action="${pageContext.request.contextPath}/administrators/register" class="form" method="post">
            <h2 class="form-title">注册</h2>
            <input type="text" placeholder="用户名" class="input" name="adminName">
            <input type="password" placeholder="密码" class="input" name="adminPassword">
            <button class="submit">注册</button>
        </form>
    </div>
    <!-- 登录页面 -->
    <div class="container-form container-signin">
        <form action="${pageContext.request.contextPath}/administrators/login" class="form" method="post">
            <h2 class="form-title">登录</h2>
            <input type="text" placeholder="用户名" class="input" name="adminName">
            <input type="password" placeholder="密码" class="input" name="adminPassword">
            <a href="javascript:void(0);">忘记密码?</a>
            <button class="submit">登录</button>
        </form>
    </div>
    <!-- 覆盖层 -->
    <div class="container-overlay">
        <div class="overlay">
            <div class="overlay-slide overlay-left">
                <button class="submit" id="goSignIn">登录</button>
            </div>
            <div class="overlay-slide overlay-right">
                <button class="submit" id="goSignUp">注册</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<!-- 结构搭建完成 -->
