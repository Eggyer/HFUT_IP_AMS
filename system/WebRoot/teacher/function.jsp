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
  	<h1>教师系统</h1> 
    <a href="<c:url value='/teacher/changeInfo.jsp'/>" >修改个人信息</a><!--  -->
    <a href="<c:url value='/teacher/changePassword.jsp'/>" >修改密码</a><!--  -->
    <a href="<c:url value='/teacher/queryCourse.jsp'/>" >查询所有课程</a><!--  -->
    <a href="<c:url value='/teacher/queryCttime.jsp'/>" >查询开设课程</a>
    <a href="<c:url value='/teacher/queryGrade.jsp'/>" >查询成绩</a>
</body>
</html>
