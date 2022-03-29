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
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        已审批文件
                    </h1>
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <!--    Context Classes  -->
                                <div class="panel panel-default">
                                    <div class="alert alert-success">
                                        <strong>审批文件详情</strong>
                                    </div>
                                    <div class="col-xs-12">
                                        <form action="${pageContext.request.contextPath}/administrators/readfile" method="post" name="page">
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
                                                        <th>审批编号</th>
                                                        <th>开发商编号</th>
                                                        <th>开发商名字</th>
                                                        <th>审批状态</th>
                                                        <th>详情信息</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${examineApprovelist}" var="examineApprove" varStatus="status">
                                                    <tr>
                                                        <th>${examineApprove.id }</th>
                                                        <th>${examineApprove.developerId}</th>
                                                        <th>${examineApprove.developerName}</th>
                                                        <th><c:if test="${examineApprove.state==1}">未通过</c:if>
                                                            <c:if test="${examineApprove.state==2}">已通过</c:if>
                                                        </th>
                                                        <th><a style="color: #0b6cbc" data-toggle="modal" data-target="#${status.count}">查看</a></th>
                                                    </tr>
                                                    <div class="modal fade" id="${status.count}" tabindex="-1" role="dialog"
                                                         aria-labelledby="myModalLabel" aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <button type="button" class="close" data-dismiss="modal"
                                                                            aria-hidden="true">&times;
                                                                    </button>
                                                                    <h4 class="modal-title">申请信息</h4>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <div style="text-align: center">
                                                                        <img src="<%=path%>/file/${examineApprove.file}" alt="申请文件图片" class="img-thumbnail"  style="width:80%;height: 80%;">
                                                                    </div>
                                                                    <h2>文件信息</h2>

                                                                </div>


                                                                    <div class="modal-footer">
                                                                        <button class="btn btn-default" type="submit">
                                                                            <i class="icon-ok bigger-110"></i>
                                                                            确认
                                                                        </button>
                                                                        <button type="button" class="btn btn-default"
                                                                                data-dismiss="modal">关闭
                                                                        </button>
                                                                    </div>

                                                            </div><!-- /.modal-content -->
                                                        </div><!-- /.modal -->
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

</body>

</html>