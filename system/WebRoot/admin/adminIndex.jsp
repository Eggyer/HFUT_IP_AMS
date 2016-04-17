<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminIndex.jsp' starting page</title>
    <base href="<%=basePath%>">
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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
	<!--JavaScript-->
	<script src="${pageContext.request.contextPath}/jquery/jquery-2.2.2.js"  type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js" type="text/javascript"></script>
  </head>
<body>
     <nav class="navbar navbar-default navbar-fixed-top"  id="nav_bg_cl">
        <div class="container" id="contain" role="navigation" >
            <div class="navbar-header" class="navbar-brand ">
           		
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#ul1" aria-expanded="false" aria-controls="navbar" >
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"  ></span>
                    <span class="icon-bar"  ></span>
                    <span class="icon-bar" ></span>
                </button>
                <div class="navbar-brand" >
                	<img src="${pageContext.request.contextPath}/images/logo.png" style=";margin:0px; padding:0px ; position:fixed;top:0.3%"/>
                </div>
            </div>
            <div class="collapse navbar-collapse" id="ul1" style="background-color:#000; margin-left:3.5%;padding-top:0%;" >
                <ul class="nav navbar-nav navbar-left">
               		<li><a href="#" id="fond_black1">考勤管理系统</a></li>
					<li><a href="<c:url value='/admin/addCourse.jsp'/>" id="fond_black">添加课程</a></li>
    				<li><a href="<c:url value='/AdminServlet?method=preAddStudent'/>" id="fond_black">添加学生</a></li>
    				<li><a href="<c:url value='/admin/addTeacher.jsp'/>" id="fond_black">添加老师</a></li>
    				<li><a href="<c:url value='/AdminServlet?method=preAddAssistant'/>" id="fond_black">添加导员</a></li>
    				<li><a href="<c:url value='/admin/addAcLinker.jsp'/>" id="fond_black">添加班级</a></li>
    				<li><a href="<c:url value='/admin/queryCourse.jsp'/>" id="fond_black">查询课程</a></li>
    				<li><a href="<c:url value='/admin/queryStudent.jsp'/>" id="fond_black">查询学生</a></li>
    				<li><a href="<c:url value='/admin/queryTeacher.jsp'/>" id="fond_black">查询老师</a></li>
    				<li><a href="<c:url value='/admin/queryAssistant.jsp'/>" id="fond_black">查询导员</a></li>
    				<li><a href="<c:url value='/admin/queryAcLinker.jsp'/>" id="fond_black">查询班级</a></li>
                </ul>
            </div>
        </div>       
    </nav>
    <img border='0' src="${pageContext.request.contextPath}/images/bg.jpg" width='100%' height='100%' style='position:fixed;left:0px;top:0px;z-index: -3'>
    <div style="width:100% ;height:100%; opacity:0.4;position:fixed;left:0px;top:0px;z-index:-1; background-color:#000">
    </div>
        
 <div class="container">
	<div class="starter-template">
		<h1 class="whitetext" style="color:white;">欢迎使用学生考勤管理系统</h1>
		<p class="lead whitetext" style="color:white;">
			您可以使用本系统开设课程，添加选课学生，查看所开课程，考试成绩及缺勤的详细情况，
			录入考试及平时成绩，设置考试，平时成绩所占比例。
		</p>
	</div>
</div>  
</html>
