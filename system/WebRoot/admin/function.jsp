<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base target="main">
    
    <title>My JSP 'function.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
   <body style="text-align: center;">
  	<h1>管理者系统</h1>
    <a href="<c:url value='/admin/addCourse.jsp'/>">添加课程</a>
    <a href="<c:url value='/AdminServlet?method=preAddStudent'/>">添加学生</a>
    <a href="<c:url value='/admin/addTeacher.jsp'/>">添加老师</a>
    <a href="<c:url value='/AdminServlet?method=preAddAssistant'/>">添加导员</a>
    <a href="<c:url value='/admin/addAcLinker.jsp'/>">添加班级</a>
    <br>
    <a href="<c:url value='/admin/queryCourse.jsp'/>">查询课程</a>
    <a href="<c:url value='/admin/queryStudent.jsp'/>">查询学生</a>
    <a href="<c:url value='/admin/queryTeacher.jsp'/>">查询老师</a>
    <a href="<c:url value='/admin/queryAssistant.jsp'/>">查询导员</a>
    <a href="<c:url value='/admin/queryAcLinker.jsp'/>">查询班级</a>
  </body>
</html>
