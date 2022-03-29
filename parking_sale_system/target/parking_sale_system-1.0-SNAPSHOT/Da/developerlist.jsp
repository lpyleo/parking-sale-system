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
                            <a href="<%=path%>/Da/approvalFileList.jsp">历史文件</a>
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
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        开发商信息
                    </h1>
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <!--    Context Classes  -->
                                <div class="panel panel-default">
                                    <div class="alert alert-success">
                                        <strong>开发商信息详情</strong>
                                    </div>
                                    <div class="col-xs-12">
                                        <form action="${pageContext.request.contextPath}/administrators/developerinfo" method="post" name="page">
                                            <div class="form-group input-group col-xs-12 col-sm-8" style="float: left">
                                                <input type="hidden" id="pageNum" name="pageNum" value="${pageNum}">
                                                <input type="text" class="form-control" name="search">
                                                <span class="input-group-btn">
                                                    <button class="btn btn-default" type="submit"><i class="fa fa-search"></i>
                                                    </button>
                                                </span>
                                            </div>
                                            <div class="form-group col-xs-12 col-sm-2">
                                                <select name="pageSize" class="form-control">
                                                    <option value="${pageSize}" selected hidden>每页${pageSize}条</option>
                                                    <option value ="5">每页5条</option>
                                                    <option value ="10">每页10条</option>
                                                    <option value="20">每页20条</option>
                                                </select>
                                            </div>
                                            <div class="form-group col-xs-12 col-sm-1">
                                                <button class="btn btn-success" name="before" onclick="var p = document.getElementById('pageNum'); p.value=Number(p.value)-1;">上一页</button>
                                            </div>
                                            <div class="form-group col-xs-12 col-sm-1">
                                                <button class="btn btn-success" name="after" onclick="var p = document.getElementById('pageNum'); p.value=Number(p.value)+1;">下一页</button>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="panel-body">
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <thead>
                                                    <tr>
                                                        <th>开发商编号</th>
                                                        <th>开发商名称</th>
                                                        <th>开发商状态</th>
                                                        <th>权限操作</th>
                                                        <th>下线操作</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${developerlist}" var="developers" varStatus="status">
                                                    <tr>
                                                        <th>${developers.developerId }</th>
                                                        <th>${developers.developerName}</th>
                                                        <th>${developers.state}</th>
                                                        <th>
                                                            <c:if test="${developers.state=='封号'}">
                                                                <form action="${pageContext.request.contextPath}/administrators/seal" method="post" name="page">
                                                                    <input type="hidden" name="did" value="${developers.developerId }">
                                                                    <button onclick="fun()">解封</button>
                                                                </form>
                                                            </c:if>
                                                            <c:if test="${developers.state=='正常'}">
                                                                <form action="${pageContext.request.contextPath}/administrators/unseal" method="post" name="page">
                                                                    <input type="hidden" name="did" value="${developers.developerId }">
                                                                    <button onclick="fun()">封号</button>
                                                                </form>
                                                            </c:if>
                                                        </th>
                                                        <th>
                                                            <form action="${pageContext.request.contextPath}/administrators/offline" method="post" name="page">
                                                                <input type="hidden" name="did" value="${developers.developerId }">
                                                                <button onclick="fun()">下线</button>
                                                            </form>
                                                        </th>
                                                    </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                                <div class="center-block">当前第${pageNum}页</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--  end  Context Classes  -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <!-- /. ROW  -->
            <!-- /. ROW  -->
            <footer> </footer>
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
<script>
    function fun(){
        alert("操作成功");
    }
</script>
</body>

</html>