<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width,initial-scale=1">
      <meta http-equiv="pragma" content="no-cache">
      <meta http-equiv="cache-control" content="no-cache">
      <meta http-equiv="expires" content="0">
      <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
      <meta http-equiv="description" content="This is my page">
      <title>Login System</title>
      <!--CSS -->
      <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
      <link rel="stylesheet" href="font-awesome/css/font-awesome.css">
      <link rel="stylesheet" href="css/form-elements.css">
      <link rel="stylesheet" href="css/index-style.css">
      <!--ico-->
      <link rel="shortcut icon" href="ico/favicon.png">
      <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72"   href="ico/apple-touch-icon-72-precomposed.png">
      <link rel="apple-touch-icon-precomposed"  href="ico/apple-touch-icon-57-precomposed.png">
      <!--Script-->
      <script type="text/javascript"  src="jquery/jquery-2.2.2.js" ></script>
      <script type="text/javascript"  src="bootstrap/js/bootstrap.js" ></script>
      <script type="text/javascript"  src="jquery/jquery.backstretch.js" ></script>
      <script type="text/javascript"  src="js/login_scripts.js" ></script>
  </head>

  <body>
  <div class="top-content">
      <div class="inner-bg">
          <div class="container">
              <div class="row">
                  <div class="col-sm-8 col-sm-offset-2 text">
                      <h1><strong>考勤管理系统</strong></h1>
                      <div class="description">
                          <p>
                              这是一个管理考勤及其相关信息的网站，您可以通过选择不同的身份，来使用不同的功能，
                              您也可以点击
                              <a href="http://azmind.com">github hfut Attendance Management System</a>关注我们的项目，以便您贡献代码或
                              阅读我们提供的文档以便在系统上进行二次开发。
                          </p>
                      </div>
                  </div>
              </div>
              <div class="row">
                  <div class="col-sm-6 col-sm-offset-3 form-box">
                      <div class="form-top">

                          <div class="form-top-left">
                              <h3>请先登入</h3>
                              <p>输入用户名和密码：</p>
                          </div>
                          <div class="form-top-right">
                              <i class="fa fa-lock"></i>
                          </div>
                      </div>

                      <div class="form-bottom">
                          <form action="<c:url value = '/LoginServlet'/>" method="post"
                                target="_top" class="login-form" role="form">
                              <div class="form-group row">
                                  <div class="col-sm-3 col-sm-offset-2">
                                      <label for="student" class="radio-inline">
                                          <input type="radio" name="usertype" value="student" id="student"/>
                                          学生
                                      </label>
                                  </div>
                                  <div class="col-sm-3">
                                      <label for="teacher" class="radio-inline">
                                          <input type="radio" name="usertype" value="teacher" id="teacher"/>
                                          教师
                                      </label>
                                  </div>
                                  <div class="col-sm-3">
                                      <label for="assistant" class="radio-inline">
                                          <input type="radio" name="usertype" value="assistant" id="assistant"/>
                                          导员
                                      </label>
                                  </div>
                              </div>
                              <div class="form-group">
                                  <label for="inputusername" class="sr-only">用户名:</label>
                                  <input type="text" name="userid" id="inputusername"
                                         class="form-control form-username" placeholder="Username..">
                              </div>
                              <div class="form-group">
                                  <label for="inputpassword" class="sr-only">密码：</label>
                                  <input type="password" name="userpassword" id="inputpassword"
                                         class="form-control form-password" placeholder="Password..">
                                     <span id="helpBlock" class="help-block">${msg }</span>

                              </div>
                       <%--       <div class="form-group">
                                  <label for="inputverifycode" class="sr-only">验证码：</label>
                                  <input type="text" name="verifycode" id="inputverifycode"
                                         class="form-control form-username" placeholder="VerifyCode">
                                  <span id="helpBlock" class="help-block">${msg }</span>
                              </div>--%>
                              <button type="submit" class="btn">登入</button>
                          </form>
                      </div>
                  </div>
              </div>
              <div class="row">
                  <div class="col-sm-6 col-sm-offset-3 social-login">
                      <h3>通过其他方式登入</h3>
                      <div class="social-login-buttons">
                          <a href="#" class="btn btn-link-2"><i class="fa fa-facebook"></i> Facebook</a>
                          <a href="#" class="btn btn-link-2"><i class="fa fa-twitter"></i> Twitter</a>
                          <a href="#" class="btn btn-link-2"><i class="fa fa-google-plus"></i> Google Plus</a>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
  </body>
</html>


