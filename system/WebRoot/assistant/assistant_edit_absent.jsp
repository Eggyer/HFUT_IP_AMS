<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <title>编辑缺勤信息</title>
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

  </head>
  	<script type="text/javascript">
    		function add()
    		{
    			var bool = true;
    			if(!$('input[name="testradio"]:checked').val())
    			{
    	  		   bool = false;
    	   		   var error1 = document.getElementById("error1");
    	   		   error1.innerHTML="没有选择课程";
    			}
    			if(!$(":checkbox[name=student]").is(':checked'))
    			{
    			   bool = false;
    			   var error2 = document.getElementById("error2");
    			   error2.innerHTML="没有添加学生不能提交";
    			}
    			if(bool)    	
    			{
    			   $("form").submit();
    			}
    		}
	</script>
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
					  <li><a href="<c:url value='/Exit'/>">退出</a></li>
				  </ul>
			  </div>
		  </div>
	  </nav>
	  <hr>
	  <div class="container">
		  <div class="row">
			  <div class="col-sm-8 col-sm-offset-2" >
				  <div class="panel panel-default">
					  <div class="panel-heading">
						  <div class="panel-title"><h3 class="centerh">修改缺勤信息</h3></div>
					  </div>
					  <div class="panel-body">
						  <div class="row">
							  <div class="col-sm-12">
								  <form action="<c:url value = '/AssistantServlet'/>" method = "post">
									  <input type = "hidden" name = "method" value = "update_absent_info">
									  <input type = "hidden" name = "student_class" value = "${requestScope.student_class }" />
									  <div class="input-group">
										  <label for="inputadd" class="checkbox-inline">
											  <input type = "radio" name = "add_reduce" value = "+" checked ="checked" id="inputadd"/>
											  <strong>添加缺勤</strong>
										  </label>
										  <label for="inputreduce" class="checkbox-inline">
											  <input type = "radio" name = "add_reduce" value = "-" id="inputreduce"/>
											  <strong>减少缺勤</strong>
										  </label>
									  </div>
									  <hr>
									  <div class="table table-responsive">
										  <table class="table table-bordered table-striped table-hover table-responsive">
											  <thead>
											  <td><strong>课程名称</strong></td>
											  <td><strong>选择</strong></td>
											  </thead>
											  <tr>
												  <td class="col-sm-6">早操</td>
												  <td class="col-sm-6">
													  <label for="inpute">
														  <input type = "radio" name = "course" value = "exercise_absent" id="inpute"/>
													  </label>
												  </td>
											  </tr>
											  <c:forEach items = "${requestScope.course_list }" var = "course">
												  <tr>
													  <td>${course.course_name }</td>
													  <td><input type = "radio" name = "course" value = "${course.course_id }"/></td>
												  </tr>
											  </c:forEach>
										  </table>
									  </div>
									  <span id="error1" >&nbsp;</span>
									  <hr>
									  <div class="table table-responsive">
										  <table class="table table-bordered table-striped table-hover">
											  <tr	>
												  <td><strong>班级</strong></td>
												  <td><strong>学号</strong></td>
												  <td><strong>姓名</strong></td>
												  <td><strong>选择</strong></td>
											  </tr>
											  <c:forEach items = "${requestScope.student_list }" var = "student">
												  <tr>
													  <td>${student.stClass }</td>
													  <td>${student.stID }</td>
													  <td>${student.stName }</td>
													  <td><input type = "checkbox" name = "student" value = "${student.stID }"/></td>
												  </tr>
											  </c:forEach>
										  </table>
									  </div>
									  <span id="error2" >&nbsp;</span>
									  <input type= "submit" value = "提交" class="btn btn-default btn-sm">
								  </form>
							  </div>
						  </div>
					  </div>
				  </div>
			  </div>
		  </div>
		  </div>
	  </div>
  </body>
</html>















