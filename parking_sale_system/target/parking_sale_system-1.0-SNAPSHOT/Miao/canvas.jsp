<%--
  Created by IntelliJ IDEA.
  User: kbdnzzzzz
  Date: 2021/12/12
  Time: 15:58
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

    <style>
        canvas {
            border: 1px solid #e6e6e6;
        }
        .sub {
            display: none;
        }
    </style>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
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

        <form action="${pageContext.request.contextPath}/user/sign" id="fileup" method="POST" >
            <div class="container" style="text-align: center">
                <ul class="input_radio">
                    <li>
                        <label for="huabi">
                            <input type="radio" name="tool" id="huabi" checked>
                            <span class="option-label">画笔</span>
                        </label>
                    </li>
                    <li>
                        <label for="shuazi">
                            <input type="radio" name="tool" id="shuazi">
                            <span class="option-label">刷子</span>
                        </label>
                    </li>
                    <li>
                        <label for="penqiang">
                            <input type="radio" name="tool" id="penqiang">
                            <span class="option-label">喷枪</span>
                        </label>
                    </li>
                    <li>
                        <label for="xiangpi">
                            <input type="radio" name="tool" id="xiangpi">
                            <span class="option-label">橡皮</span>
                        </label>
                    </li>
                </ul>
                <div class="sub">
                    <select>
                        <option>rect</option>
                        <option>circle</option>
                    </select>
                    <label>大小(px)</label><input value = '10' class="size">
                </div>
            </div>
            <div style="text-align: center">
                <canvas width = "800" height = "600"></canvas>
            </div>
            <input type="text" id="tmd" name="filett" style="display: none">
            <input type="text" id="orderId" name="orderId" style="display: none" value="${orderid}">
            <div class="row mb-md">
                <div class="form-group" style="text-align: center">
                    <input id="savefile" class="btn btn-primary" name="保存" type="button" value="保存">
                </div>
            </div>
        </form>

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

<script type="text/javascript">var basePath = "${pageContext.request.contextPath}";</script>
<script>
    let myFiles = [];
    var form=document.getElementById("fileup");
    var uploadFile = new FormData(form);
    (function() {
        var tool = 'huabi';
        var size = 10; // 橡皮大小
        var sub = $('.sub');
        var flag = false;
        var shape = 'rect'; // 橡皮形状

        $('.container').onclick = function(event) {
            var id = event.target.id;
            switch(id) {
                case 'huabi':
                    tool = 'huabi';
                    flag = false;
                    break;
                case 'shuazi':
                    tool = 'shuazi';
                    flag = false;
                    break;
                case 'penqiang':
                    tool = 'penqiang';
                    flag = false;
                    break;
                case 'xiangpi':
                    tool = 'xiangpi';
                    flag = true;
                    break;
            }
            if (flag) {
                sub.style.display = 'block';
            } else {
                sub.style.display = 'none';
            }
        }

        $('select').onchange = function() {
            shape = this.value;
        }

        $('.size').oninput = function() {
            size = this.value;
        }

        var x,y;
        var canvas = $('canvas');
        var ctx = canvas.getContext("2d");

        canvas.onmousedown = function(event) {
            x = event.clientX - this.offsetLeft;
            y = event.clientY - this.offsetTop;

            document.onmousemove = function(event) {
                var x1 = event.clientX - canvas.offsetLeft;
                var y1 = event.clientY - canvas.offsetTop;
                switch(tool) {
                    case 'huabi':
                        huabi(x, y, x1, y1, ctx);
                        break;
                    case 'shuazi':
                        shuazi(x, y, x1, y1, ctx);
                        break;
                    case 'penqiang':
                        penqiang(x, y, ctx);
                        break;
                    case 'xiangpi':
                        xiangpi(x, y, x1, y1, ctx, size, shape);
                        break;
                }
                x = x1;
                y = y1;
            }
        }

        $('#savefile').onclick= function(event) {
            var myFile;
            myFile = canvas.toDataURL("image/png");
            var timestamp = new Date();
            var fileOfBlob = dataURLtoFile(myFile, timestamp+'.jpg');
            uploadFile.append('file', fileOfBlob);
            document.getElementById("tmd").value = myFile;
            document.getElementById('fileup').submit();
        }

        document.onmouseup = function() {
            this.onmousemove = null;
        }

    })();

    function $(selector) {
        return document.querySelector(selector);
    }


    function uploadFiles(){
        //使用ajax提交form表单
        $.ajax({
            url: '${pageContext.request.contextPath}/user/sign',
            type: 'POST',
            data: uploadFile,
            async: false,
            cache: true,
            contentType: false, //不设置内容类型
            processData: false, //不处理数据
            error: function () {
                alert("上传失败！");
            }
        });
        // alert("7869986失败！");
    }
    function saveimg(myFiles,canvas){
        var myFile;
        myFile = canvas.toDataURL("image/png");
        var timestamp =makeid();
        // alert(myFile);
        myFiles.push(dataURLtoFile(myFile, timestamp+'.jpg'));
    }

    function signupload(myFile){
        //使用ajax提交form表单
        var form=document.getElementById("file");
        var uploadFile = new FormData(form);
        var fileOfBlob = myFile.pop();
        uploadFile.append('file', fileOfBlob);
        $.ajax({
            url: basePath+"/user/sign",
            type: 'POST',
            data: uploadFile,
            async: false,
            cache: true,
            contentType: false, //不设置内容类型
            processData: false, //不处理数据
            error: function () {
                alert("上传失败！");
            }
        });
        alert(myFile);

    }

    function huabi(startX, startY, endX, endY, ctx) {
        ctx.beginPath();
        ctx.globalAlpha = 1;
        ctx.lineWidth = 2;
        ctx.strokeStyle = "#000";
        ctx.moveTo(startX, startY);
        ctx.lineTo(endX, endY);
        ctx.closePath();
        ctx.stroke();
    }

    function shuazi(startX, startY, endX, endY, ctx) {
        ctx.beginPath();
        ctx.globalAlpha = 1;
        ctx.lineWidth = 10;
        ctx.strokeStyle = "#000";
        ctx.moveTo(startX, startY);
        ctx.lineTo(endX, endY);
        ctx.closePath();
        ctx.stroke();
    }

    function penqiang(startX, startY, ctx) {
        for(var i = 0; i < 10; i++){
            var randomNum = Math.random()*15;
            ctx.fillStyle = '#000';
            ctx.beginPath();
            ctx.globalAlpha = 0.5;
            ctx.arc(startX + randomNum, startY + randomNum, 1, 0, 2 * Math.PI);
            ctx.fill();
        }
    }

    function xiangpi(startX, startY, endX, endY, ctx, size, shape) {
        ctx.beginPath();
        ctx.globalAlpha = 1;
        switch(shape) {
            case 'rect':
                ctx.lineWidth = size;
                ctx.strokeStyle = "#fff";
                ctx.moveTo(startX, startY);
                ctx.lineTo(endX, endY);
                ctx.closePath();
                ctx.stroke();
                break;
            case 'circle':
                ctx.fillStyle = "#fff";
                ctx.arc(startX, startY, size, 0, 2 * Math.PI);
                ctx.fill();
                break;
        }
    }

    //将base64转换为文件
    function dataURLtoFile(dataurl, filename) {
        var arr = dataurl.split(','), mime = arr[0].match(/:(.*?);/)[1],
            bstr = atob(arr[1]), n = bstr.length, u8arr = new Uint8Array(n);
        while(n--){
            u8arr[n] = bstr.charCodeAt(n);
        }
        return new File([u8arr], filename, {type:mime});
    }

</script>

</body>
</html>