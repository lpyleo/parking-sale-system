<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>后台管理系统</title>
    <!-- Bootstrap Styles-->
    <link href="<%=path%>/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="<%=path%>/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="<%=path%>/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="<%=path%>/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>

<body>
<div id="wrapper">
    <nav class="navbar navbar-default top-navbar" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<%=path%>/Da/index.jsp"><i class="fa fa-comments"></i> <strong>后台管理 </strong></a>
        </div>

        <ul class="nav navbar-top-links navbar-right">

            <!-- /.dropdown -->

            <!-- /.dropdown -->

            <!-- /.dropdown -->

            <!-- /.dropdown -->
        </ul>
    </nav>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div id="sideNav" href=""><i class="fa fa-caret-right"></i></div>
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">

                <li>
                    <a class="active-menu" href="#"><i class="fa fa-dashboard"></i> 入驻申请审批</a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="<%=path%>/Da/approvalFileList.jsp">已审核文件</a>
                        </li>
                        <li>
                            <a href="<%=path%>/Da/unapprovalFileList.jsp">未审核文件</a>

                        </li>
                    </ul>
                </li>
                <li>
                    <a href="<%=path%>/Da/developerlist.jsp"><i class="fa fa-desktop"></i> 开发商信息处理</a>
                </li>

                <li>
                    <a href="admininfo.jsp"><i class="fa fa-table"></i> 个人信息</a>
                </li>



            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">





            <!-- /. ROW  -->



            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            详细
                        </div>
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h1 class="panel-title" style="font-size: 30px">个人信息</h1>
                            </div>
                            <table class="table" style="font-size: 30px">
                                <th >编号</th>
                                <th>姓名</th>
                                <th>性别</th>
                                <th>年龄</th>
                                <th>联系电话</th>
                                <th>余额</th>
                                <tr>
                                    <td>${administrators.administratorsId}</td>
                                    <td>${administrators.administratorsName}</td>
                                    <td>${administrators.administratorsSex}</td>
                                    <td>${administrators.administratorsAge}</td>
                                    <td>${administrators.administratorsPhone}</td>
                                    <td>${administrators.money}</td>
                                </tr>

                            </table>
                        </div>
                    </div>
                </div>
            </div>







            <!-- /. ROW  -->


            <div class="tlinks">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
            <!-- /. ROW  -->
            <footer><p>Copyright &copy; 2016.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p></footer>
        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- jQuery Js -->
<script src="<%=path%>/assets/js/jquery-1.10.2.js"></script>
<!-- Bootstrap Js -->
<script src="<%=path%>/assets/js/bootstrap.min.js"></script>

<!-- Metis Menu Js -->
<script src="<%=path%>/assets/js/jquery.metisMenu.js"></script>
<!-- Morris Chart Js -->
<script src="<%=path%>/assets/js/morris/raphael-2.1.0.min.js"></script>
<script src="<%=path%>/assets/js/morris/morris.js"></script>


<script src="../assets/js/easypiechart.js"></script>
<script src="../assets/js/easypiechart-data.js"></script>


<!-- Custom Js -->
<script src="../assets/js/custom-scripts.js"></script>


<style>
    .copyrights{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}
</style>
<div class="copyrights" id="links20210126">
    Collect from <a href="http://www.cssmoban.com/"  title="网站模板">模板之家</a>
    <a href="http://cooco.net.cn/" title="组卷网">组卷网</a>
</div>

</body>

</html>