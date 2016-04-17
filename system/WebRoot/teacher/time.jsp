<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/commen.css">

    <!--JavaScript-->
    <script src="${pageContext.request.contextPath}/jquery/jquery-2.2.2.js"  type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/jquery/jquery.backstretch.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/login_scripts.js" type="text/javascript"></script>

    <title>时间</title>
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
              <div class="col-sm-8 col-sm-offset-2">
                  <div class="panel panel-default">
                      <div class="panel-heading"><h4 class="centerh"><strong>选择课程</strong></h4></div>
                      <div class="table table-responsive">
                          <table class="table table-bordered table-striped table-hover">
                              <tr>
                                  <td>&nbsp;</td>
                                  <td>周一</td>
                                  <td>周二</td>
                                  <td>周三</td>
                                  <td>周四</td>
                                  <td>周五</td>
                                  <td>周六</td>
                                  <td>周日</td>
                              </tr>
                              <tr>
                                  <td>1</td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct11.courseID}&crClass=${ct11.courseClass}&crWe=1&crTi=1">
                                          ${ct11.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct21.courseID}&crClass=${ct21.courseClass}&crWe=2&crTi=1">
                                          ${ct21.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct31.courseID}&crClass=${ct31.courseClass}&crWe=3&crTi=1">
                                          ${ct31.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct41.courseID}&crClass=${ct41.courseClass}&crWe=4&crTi=1">
                                          ${ct41.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct51.courseID}&crClass=${ct51.courseClass}&crWe=5&crTi=1">
                                          ${ct51.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct61.courseID}&crClass=${ct61.courseClass}&crWe=6&crTi=1">
                                          ${ct61.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct71.courseID}&crClass=${ct71.courseClass}&crWe=7&crTi=1">
                                          ${ct71.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                              </tr>
                              <tr>
                                  <td>2</td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct12.courseID}&crClass=${ct12.courseClass}&crWe=1&crTi=2">
                                          ${ct12.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct22.courseID}&crClass=${ct22.courseClass}&crWe=2&crTi=2">
                                          ${ct22.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct32.courseID}&crClass=${ct32.courseClass}&crWe=3&crTi=2">
                                          ${ct32.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct42.courseID}&crClass=${ct42.courseClass}&crWe=4&crTi=2">
                                          ${ct42.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct52.courseID}&crClass=${ct52.courseClass}&crWe=5&crTi=2">
                                          ${ct52.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct62.courseID}&crClass=${ct62.courseClass}&crWe=6&crTi=2">
                                          ${ct62.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct72.courseID}&crClass=${ct72.courseClass}&crWe=7&crTi=2">
                                          ${ct72.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                              </tr>
                              <tr>
                                  <td>3</td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct13.courseID}&crClass=${ct13.courseClass}&crWe=1&crTi=3">
                                          ${ct13.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct23.courseID}&crClass=${ct23.courseClass}&crWe=2&crTi=3">
                                          ${ct23.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct33.courseID}&crClass=${ct33.courseClass}&crWe=3&crTi=3">
                                          ${ct33.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct43.courseID}&crClass=${ct43.courseClass}&crWe=4&crTi=3">
                                          ${ct43.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct53.courseID}&crClass=${ct53.courseClass}&crWe=5&crTi=3">
                                          ${ct53.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct63.courseID}&crClass=${ct63.courseClass}&crWe=6&crTi=3">
                                          ${ct63.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct73.courseID}&crClass=${ct73.courseClass}&crWe=7&crTi=3">
                                          ${ct73.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                              </tr>
                              <tr>
                                  <td>4</td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct14.courseID}&crClass=${ct14.courseClass}&crWe=1&crTi=4">
                                          ${ct14.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct24.courseID}&crClass=${ct24.courseClass}&crWe=2&crTi=4">
                                          ${ct24.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct34.courseID}&crClass=${ct34.courseClass}&crWe=3&crTi=4">
                                          ${ct34.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct44.courseID}&crClass=${ct44.courseClass}&crWe=4&crTi=4">
                                          ${ct44.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct54.courseID}&crClass=${ct54.courseClass}&crWe=5&crTi=4">
                                          ${ct54.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct64.courseID}&crClass=${ct64.courseClass}&crWe=6&crTi=4">
                                          ${ct64.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct74.courseID}&crClass=${ct74.courseClass}&crWe=7&crTi=4">
                                          ${ct74.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                              </tr>
                              <tr>
                                  <td>5</td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct15.courseID}&crClass=${ct15.courseClass}&crWe=1&crTi=5">
                                          ${ct15.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct25.courseID}&crClass=${ct25.courseClass}&crWe=2&crTi=5">
                                          ${ct25.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct35.courseID}&crClass=${ct35.courseClass}&crWe=3&crTi=5">
                                          ${ct35.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct45.courseID}&crClass=${ct45.courseClass}&crWe=4&crTi=5">
                                          ${ct45.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct55.courseID}&crClass=${ct55.courseClass}&crWe=5&crTi=5">
                                          ${ct55.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct65.courseID}&crClass=${ct65.courseClass}&crWe=6&crTi=5">
                                          ${ct65.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct75.courseID}&crClass=${ct75.courseClass}&crWe=7&crTi=5">
                                          ${ct75.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                              </tr>
                              <tr>
                                  <td>6</td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct16.courseID}&crClass=${ct16.courseClass}&crWe=1&crTi=6">
                                          ${ct16.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct26.courseID}&crClass=${ct26.courseClass}&crWe=2&crTi=6">
                                          ${ct26.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct36.courseID}&crClass=${ct36.courseClass}&crWe=3&crTi=6">
                                          ${ct36.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct46.courseID}&crClass=${ct46.courseClass}&crWe=4&crTi=6">
                                          ${ct46.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct56.courseID}&crClass=${ct56.courseClass}&crWe=5&crTi=6">
                                          ${ct56.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct66.courseID}&crClass=${ct66.courseClass}&crWe=6&crTi=6">
                                          ${ct66.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct76.courseID}&crClass=${ct76.courseClass}&crWe=7&crTi=6">
                                          ${ct76.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                              </tr>
                              <tr>
                                  <td>7</td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct17.courseID}&crClass=${ct17.courseClass}&crWe=1&crTi=7">
                                          ${ct17.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct27.courseID}&crClass=${ct27.courseClass}&crWe=2&crTi=7">
                                          ${ct27.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct37.courseID}&crClass=${ct37.courseClass}&crWe=3&crTi=7">
                                          ${ct37.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct47.courseID}&crClass=${ct47.courseClass}&crWe=4&crTi=7">
                                          ${ct47.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct57.courseID}&crClass=${ct57.courseClass}&crWe=5&crTi=7">
                                          ${ct57.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct67.courseID}&crClass=${ct67.courseClass}&crWe=6&crTi=7">
                                          ${ct67.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct77.courseID}&crClass=${ct77.courseClass}&crWe=7&crTi=7">
                                          ${ct77.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                              </tr>
                              <tr>
                                  <td>8</td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct18.courseID}&crClass=${ct18.courseClass}&crWe=1&crTi=8">
                                          ${ct18.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct28.courseID}&crClass=${ct28.courseClass}&crWe=2&crTi=8">
                                          ${ct28.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct38.courseID}&crClass=${ct38.courseClass}&crWe=3&crTi=8">
                                          ${ct38.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct48.courseID}&crClass=${ct48.courseClass}&crWe=4&crTi=8">
                                          ${ct48.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct58.courseID}&crClass=${ct58.courseClass}&crWe=5&crTi=8">
                                          ${ct58.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct68.courseID}&crClass=${ct68.courseClass}&crWe=6&crTi=8">
                                          ${ct68.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                                  <td>
                                      <a href="<c:url value='TeacherServlet'/>?method=preAddAbsent&crID=${ct78.courseID}&crClass=${ct78.courseClass}&crWe=7&crTi=8">
                                          ${ct78.courseName}
                                      </a>
                                      &nbsp;
                                  </td>
                              </tr>
                          </table>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </body>
</html>
