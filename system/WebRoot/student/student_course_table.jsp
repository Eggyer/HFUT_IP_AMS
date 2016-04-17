<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	  <script src="${pageContext.request.contextPath}/jquery/jquery-2.2.2.js"  type="text/javascript"></script>
	  <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js" type="text/javascript"></script>
	  <script src="${pageContext.request.contextPath}/jquery/jquery.backstretch.js" type="text/javascript"></script>
	  <script src="${pageContext.request.contextPath}/js/login_scripts.js" type="text/javascript"></script>

	  <title>个人课表</title>
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
				  <li><a href="<c:url value='/student/student_index.jsp'/>">主页</a></li>
				  <li>
					  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
						 aria-haspopup="true" aria-expanded="false">查询 <span class="caret"></span></a>
					  <ul class="dropdown-menu dropdown-menu-inverse">
						  <li><a href="<c:url value='/StudentServlet?method=query_course_info'/>">查询课表</a></li>
						  <li><a href="<c:url value='/StudentServlet?method=query_grade_info'/>">查询成绩</a></li>
						  <li><a href="<c:url value='/StudentServlet?method=query_absent_info'/>">缺勤情况</a></li>
					  </ul>
				  </li>
				  <li><a href="<c:url value='/student/student_info.jsp'/>">个人信息</a></li>
				  <li><a href="<c:url value='/student/student_modify_password.jsp'/>">修改密码</a></li>
				  <li><a href="<c:url value='/Exit'/>">退出</a></li>
			  </ul>
		  </div>
	  </div>
  </nav>
  <hr style="color: GrayText">
	  <div class="container">
		  <div class="row">
			  <div class="col-sm-10 col-sm-offset-1">
			 	 <div class="panel panel-default">

					  <div class="panel-heading"><h4 class="centerh"><strong>个人课表</strong></h4></div>
					  <div class="table table-responsive">
						  <table class="table table-striped table-hover table-condensed table-bordered
						  mytable1">
							  <thead>
							  <tr>
								  <td><strong>星期一</strong></td>
								  <td><strong>星期二</strong></td>
								  <td><strong>星期三</strong></td>
								  <td><strong>星期四</strong></td>
								  <td><strong>星期五</strong></td>
								  <td><strong>星期六</strong></td>
								  <td><strong>星期七</strong></td>
							  </tr>
							  </thead>
							  <tbody>
							  <tr>
								  <td id = "week1_1">${requestScope.week1_1 }</td>
								  <td id = "week2_1">${requestScope.week2_1 }</td>
								  <td id = "week3_1">${requestScope.week3_1 }</td>
								  <td id = "week4_1">${requestScope.week4_1 }</td>
								  <td id = "week5_1">${requestScope.week5_1 }</td>
								  <td id = "week6_1">${requestScope.week6_1 }</td>
								  <td id = "week7_1">${requestScope.week7_1 }</td>
							  </tr>

							  <tr >
								  <td id = "week1_2">${requestScope.week1_2 }</td>
								  <td id = "week2_2">${requestScope.week2_2 }</td>
								  <td id = "week3_2">${requestScope.week3_2 }</td>
								  <td id = "week4_2">${requestScope.week4_2 }</td>
								  <td id = "week5_2">${requestScope.week5_2 }</td>
								  <td id = "week6_2">${requestScope.week6_2 }</td>
								  <td id = "week7_2">${requestScope.week7_2 }</td>
							  </tr>

							  <tr >
								  <td id = "week1_3">${requestScope.week1_3 }</td>
								  <td id = "week2_3">${requestScope.week2_3 }</td>
								  <td id = "week3_3">${requestScope.week3_3 }</td>
								  <td id = "week4_3">${requestScope.week4_3 }</td>
								  <td id = "week5_3">${requestScope.week5_3 }</td>
								  <td id = "week6_3">${requestScope.week6_3 }</td>
								  <td id = "week7_3">${requestScope.week7_3 }</td>
							  </tr>

							  <tr>
								  <td id = "week1_4">${requestScope.week1_4 }</td>
								  <td id = "week2_4">${requestScope.week2_4 }</td>
								  <td id = "week3_4">${requestScope.week3_4 }</td>
								  <td id = "week4_4">${requestScope.week4_4 }</td>
								  <td id = "week5_4">${requestScope.week5_4 }</td>
								  <td id = "week6_4">${requestScope.week6_4 }</td>
								  <td id = "week7_4">${requestScope.week7_4 }</td>
							  </tr>

							  <tr>
								  <td id = "week1_5">${requestScope.week1_5 }</td>
								  <td id = "week2_5">${requestScope.week2_5 }</td>
								  <td id = "week3_5">${requestScope.week3_5 }</td>
								  <td id = "week4_5">${requestScope.week4_5 }</td>
								  <td id = "week5_5">${requestScope.week5_5 }</td>
								  <td id = "week6_5">${requestScope.week6_5 }</td>
								  <td id = "week7_5">${requestScope.week7_5 }</td>
							  </tr>

							  <tr>
								  <td id = "week1_6">${requestScope.week1_6 }</td>
								  <td id = "week2_6">${requestScope.week2_6 }</td>
								  <td id = "week3_6">${requestScope.week3_6 }</td>
								  <td id = "week4_6">${requestScope.week4_6 }</td>
								  <td id = "week5_6">${requestScope.week5_6 }</td>
								  <td id = "week6_6">${requestScope.week6_6 }</td>
								  <td id = "week7_6">${requestScope.week7_6 }</td>
							  </tr>

							  <tr>
								  <td id = "week1_7">${requestScope.week1_7 }</td>
								  <td id = "week2_7">${requestScope.week2_7 }</td>
								  <td id = "week3_7">${requestScope.week3_7 }</td>
								  <td id = "week4_7">${requestScope.week4_7 }</td>
								  <td id = "week5_7">${requestScope.week5_7 }</td>
								  <td id = "week6_7">${requestScope.week6_7 }</td>
								  <td id = "week7_7">${requestScope.week7_7 }</td>
							  </tr>

							  <tr>
								  <td id = "week1_8">${requestScope.week1_8 }</td>
								  <td id = "week2_8">${requestScope.week2_8 }</td>
								  <td id = "week3_8">${requestScope.week3_8 }</td>
								  <td id = "week4_8">${requestScope.week4_8 }</td>
								  <td id = "week5_8">${requestScope.week5_8 }</td>
								  <td id = "week6_8">${requestScope.week6_8 }</td>
								  <td id = "week7_8">${requestScope.week7_8 }</td>
							  </tr>
							  </tbody>
						  </table>
					  </div>
				  </div>
			  </div>
		  </div>
	  </div>
  </body>
</html>
