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
    <a href="<c:url value='/AssistantServlet?method=load_choose_class&method_path=edit_absent_info'/>">增加缺勤次数</a>
    <a href="<c:url value='/AssistantServlet?method=load_choose_class&method_path=query_grade_info'/>">查询学生成绩</a>　　
    <a href="<c:url value='/AssistantServlet?method=load_choose_class&method_path=query_absent_info'/>">查询缺勤情况</a>
    <a href="<c:url value='/AssistantServlet?method=query_assistant_info'/>">个人信息</a>　
    <a href="<c:url value='/assistant/assistant_modify_password.jsp'/>">修改密码</a>　
  </body>
</html>
