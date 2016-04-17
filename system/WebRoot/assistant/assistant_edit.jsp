<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <title>编辑个信息</title>
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
	  <script src="${pageContext.request.contextPath}/jquery/jquery-2.2.2.js"  type="text/javascript"></script>
	  <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js" type="text/javascript"></script>
	  <script src="${pageContext.request.contextPath}/jquery/jquery.backstretch.js" type="text/javascript"></script>
	  <script src="${pageContext.request.contextPath}/js/onesindex.js" type="text/javascript"></script>

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
				  <li><a href="<c:url value='/assistant/assistant_index.jsp'/>">主页</a></li>
				  <li>
					  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
						 aria-haspopup="true" aria-expanded="false">查询 <span class="caret"></span></a>
					  <ul class="dropdown-menu dropdown-menu-inverse">
						  <li><a href="<c:url value='/AssistantServlet?method=load_choose_class&method_path=query_absent_info'/>">缺勤情况</a></li>
						  <li><a href="<c:url value='/AssistantServlet?method=load_choose_class&method_path=query_grade_info'/>">学生成绩</a></li>
					  </ul>
				  </li>
				  <li><a href="<c:url value='/AssistantServlet?method=load_choose_class&method_path=edit_absent_info'/>">修改缺勤信息</a></li>
				  <li><a href="<c:url value='/AssistantServlet?method=query_assistant_info'/>">个人信息</a></li>
				  <li><a href="<c:url value='/assistant/assistant_modify_password.jsp'/>">修改密码</a></li>
				  <li><a href="/system/index.jsp">退出</a></li>
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
						<div class="panel-title"><h4 class="centerh"><strong>修改个人信息</strong></h4></div>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-sm-8 col-sm-offset-3">
								<form action="<c:url value='/AssistantServlet'/>" method="post" class="form-horizontal" role="form">
									<input type = "hidden" name = "method" value = "edit_info"/>
									<div class="form-group">
										<label for="inputEmail" class="col-sm-2 control-label">Email</label>
										<div class="col-sm-5">
											<input type="email" id="inputEmail" name="asEmail" placeholder = "${assistant.asEmail }"
												   aria-describedby="helpBlock"/>
											<span id="helpBlock" class="help-block">如：xxx@126.com</span>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-10 col-sm-offset-2">
											<button type="submit" class="btn btn-default btn-sm ">完成</button>
										</div>
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
