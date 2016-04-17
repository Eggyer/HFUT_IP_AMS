<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <title>Login System</title>
    <!--CSS -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="css/form-elements.css">
    <link rel="stylesheet" href="css/index-style.css">
    <!--ico-->
    <link rel="shortcut icon" href="ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72"   href="ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed"  href="ico/apple-touch-icon-57-precomposed.png">
    <!--Script-->
    <script type="text/javascript"  src="jquery/jquery-2.2.2.js" ></script>
    <script type="text/javascript"  src="bootstrap/js/bootstrap.js" ></script>
    <script type="text/javascript"  src="jquery/jquery.backstretch.js" ></script>
    <script type="text/javascript"  src="js/login_scripts.js" ></script>
</head>

  <body>
<nav class="navbar navbar-inverse navbar-fixed-top" >
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
					data-target="#navbar" aria-expanded="false" aria-controls="navbar" >
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a href="/system/index.jsp" class="navbar-brand">考勤管理系统</a>
		</div>
		<div class="collapse navbar-collapse" id="navbar">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value='/teacher/teacherIndex.jsp'/>">主页</a></li>
				<li>
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
					   aria-haspopup="true" aria-expanded="false">修改信息<span class="caret"></span></a>
					<ul class="dropdown-menu dropdown-menu-inverse">
						<li><a href="<c:url value='/teacher/changeInfo.jsp'/>">修改个人信息</a></li>
						<li><a href="<c:url value='/teacher/changePassword.jsp'/>">修改密码</a></li>
					</ul>
				</li>
				<li><a href="<c:url value='/teacher/queryCourse.jsp'/>">开设课程</a></li>
				<li><a href="<c:url value='/teacher/queryCttime.jsp'/>">已开课程</a></li>
				<li><a href="<c:url value='/teacher/queryGrade.jsp'/>">成绩及缺勤</a></li>
				<li><a href="<c:url value='/Exit'/>">退出</a></li>
			</ul>
		</div>
	</div>
</nav>
      <div class="modal fade" id="myModal">
          <div class="modal-dialog">
              <div class="modal-content">
                  <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                      <h4 class="modal-title">提示信息</h4>
                  </div>
                  <div class="modal-body">
                      <p>操作成功&hellip;</p>
                  </div>
                  <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  </div>
              </div><!-- /.modal-content -->
          </div><!-- /.modal-dialog -->
      </div><!-- /.modal -->
      <script type="text/javascript">
          jQuery("#myModal").modal("show");
      </script>
  </body>
</html>
