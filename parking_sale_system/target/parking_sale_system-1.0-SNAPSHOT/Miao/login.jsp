<%--
  Created by IntelliJ IDEA.
  User: kbdnzzzzz
  Date: 2021/12/5
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>用户登陆注册</title>
    <link href="<%=path%>/Miao/css2/style2.css" rel="stylesheet">
    <style type="text/css">
        .input_radio{
            text-align: center;
        }
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
    </style>
</head>
<body>
    <div class="login-box">
        <form action="${pageContext.request.contextPath}/user/login" method="POST" class="login-form">
            <h1>Welcome</h1>
            <input class="txtb" type="text" name="username" placeholder="Username" />
            <input class="txtb" type="password" name="password" placeholder="Password" />
            <input class="login-btn" type="submit" name="" value="Login" />
        </form>
        <div class="show-register-btn">
            -> register for account
        </div>
    </div>

    <div class="register-box">
        <div class="hide-register-btn">
            +
        </div>
        <form action="${pageContext.request.contextPath}/user/register" method="POST" class="register-form">
            <h1>Register</h1>
            <input class="txtb" type="text" name="username" placeholder="Username" />
            <input class="txtb" type="text" name="phone" placeholder="Phonenumber" />
            <input class="txtb" type="text" name="Email" placeholder="Email" />
            <ul class="input_radio">
                <li>
                    <label for="male">
                        <input id="male" name="sex" type="radio" value="男" checked="checked">
                        <span class="option-label">男</span>
                    </label>
                </li>
                <li>
                    <label for="female">
                        <input id="female" name="sex" value="女" type="radio">
                        <span class="option-label">女</span>
                    </label>
                </li>
            </ul>
            <input class="txtb" type="password" name="password" placeholder="Password" />
            <input class="txtb" type="text" name="invitee" placeholder="invitee" />
            <input class="register-btn" type="submit" name="" value="register" />
        </form>
    </div>

    <script type="text/javascript">
        function hasClass(element, clssname) {
            return element.className.match(new RegExp('(\\s|^)' + clssname + '(\\s|$)'))
        }
        function addClass(element, clssname) {
            if (!this.hasClass(element, clssname)) element.className += ' ' + clssname
        }
        function removeClass(element, clssname) {
            if (hasClass(element, clssname)) {
                var reg = new RegExp('(\\s|^)' + clssname + '(\\s|$)')
                element.className = element.className.replace(reg, ' ')
            }
        }
        function toggleClass(element, clssname) {
            if (hasClass(element, clssname)) {
                removeClass(element, clssname)
            } else {
                addClass(element, clssname)
            }
        }
        var registerBox = document.getElementsByClassName('register-box')
        var showBtn2 = document.getElementsByClassName('show-register-btn')
        var hideBtn2 = document.getElementsByClassName('hide-register-btn')
        showBtn2[0].addEventListener('click', function() {
            toggleClass(registerBox[0], 'showed')
        })
        hideBtn2[0].addEventListener('click', function() {
            toggleClass(registerBox[0], 'showed')
        })
    </script>
</body>
</html>
