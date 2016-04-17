<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta lang="zh-CN">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--CSS-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/starter-template.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/commen.css">

	<!--JavaScript-->
	<script src="${pageContext.request.contextPath}/jquery/jquery-2.2.2.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/input-check.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/jquery/jquery.backstretch.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/onesindex.js" type="text/javascript"></script>

	<title>修改密码</title>
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
	  <hr>
	  <div class="container">
		  <div class="row">
			  <div class="col-sm-6 col-sm-offset-3">
				  <div class="panel panel-default">
					  <div class="panel-heading">
						  <div class="panel-title"><h4 class="centerh"><strong>修改密码</strong></h4></div>
					  </div>
					  <div class="panel-body">
						  <div class="row">
							  <div class="col-sm-10">
								  <form action="<c:url value='/TeacherServlet'/>" method="post">
									  <input type="hidden" name="method" value="changePassword">
									  <div class="form-group" id="inputPasswordFormgroup">
										  <label for="inputPassword" class="col-sm-3 col-sm-offset-3 control-label">请输入新密码</label>
										  <div class="col-sm-4">
											  <input type="password" name="tcPassword" placeholder="请输入..." id="inputPassword">
											  <span id="helpBlock" class="help-block">长度8-16位，字母，数字，符号至少包含两种</span>
										  </div>
									  </div>
									  <div class="form-group" id="reinputPasswordFormgroup">
										  <label for="inputPassword" class="col-sm-3 col-sm-offset-3 control-label">再次输入密码</label>
										  <div class="col-sm-4">
											  <input type="password" name="tcPassword2" id="reinputPassword">
											  <span id="helpBlock" class="help-block">请保证两次输入密码相同</span>
										  </div>
									  </div>
									  <div class="row">
										  <button type="button" class="btn btn-default btn-sm col-sm-offset-7"
												  onclick="checkPassword()">完成
										  </button>
									  </div>
								  </form>
							  </div>
						  </div>
					  </div>
				  </div>
			  </div>
		  </div>
	  </div>
  </body>
</html>
