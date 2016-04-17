<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base target="main">
    <title>My JSP 'top.jsp' starting page</title>
    
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
  	<h1>学生考勤管理系统</h1>
    <a href="<c:url value='/StudentServlet?method=query_course_info'/>">查询课表</a>
    <a href="<c:url value='/StudentServlet?method=query_grade_info'/>">查询成绩</a>　　
    <a href="<c:url value='/StudentServlet?method=query_absent_info'/>">缺勤情况</a>
    <a href="<c:url value='/student/student_info.jsp'/>">个人信息</a>　
    <a href="<c:url value='/student/student_modify_password.jsp'/>">修改密码</a>　
   	<a href="<c:url value='/student/student_choose_course.jsp'/>"></a>　　
  </body>
</html>
