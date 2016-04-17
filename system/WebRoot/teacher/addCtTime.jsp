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

    <script type="text/javascript" src="<c:url value='/js/ajaxutils.js'/>"></script>
    <title>填写开课信息</title>

    <script type="text/javascript">
    var judge;
    window.onload = function() {
        var crClass = document.getElementById("crClassid");
        var span = document.getElementById("crClassError");
            /*
            1. ajax
            */
        crClass.onblur = function()
        {
            ajax(
                {
                    url:"<c:url value='/TeacherServlet'/>?method=judgecrClass"+"&crClass="+crClass.value,
                    type:"text",
                    callback:function(data) {
                        if(data=="0")
                            {
                            judge = 0;
                              span.innerHTML = "";
                            }
                        else {
                            judge = 1;
                            span.innerHTML = "课程班级已存在";
                        }
                    }
                }
            );
        };
    };
        function add() {
            var termre1 = /20\d\d\-20\d\d\-\u4e0a/;
            var termre2 = /20\d\d\-20\d\d\-\u4e0b/;
            var timere1 = /\d{4}/;
            $(".error").text("");
            var bool = true;
            if(!$(":text[name=crClass]").val()) {
                $("#crClassError").text("课程班级不能为空");
                bool = false;
            }
            if(!(timere1.test($(":text[name=crClass]").val())))
            {
                $("#crClassError").html("请输入正学的班级");
                bool = false;
            }
            if(!$(":text[name=term]").val()) {
                $("#termError").text("开课学期不能为空");
                bool = false;
            }
            if(!((termre1.test($(":text[name=term]").val()))||(termre2.test($(":text[name=term]").val()))))
            {
                $("#termError").text("输入符合规范的学期");
                bool = false;
            }
            if(
                    (!$(":checkbox[name=mon]").is(':checked'))&&
                    (!$(":checkbox[name=tu]").is(':checked'))&&
                    (!$(":checkbox[name=we]").is(':checked'))&&
                    (!$(":checkbox[name=th]").is(':checked'))&&
                    (!$(":checkbox[name=fr]").is(':checked'))&&
                    (!$(":checkbox[name=sa]").is(':checked'))&&
                    (!$(":checkbox[name=su]").is(':checked'))
              )
            {
                $("#timeError").text("没有选择开课时间");
                bool = false;
            }
            if(judge == 1)
            {
                $("#crClassError").text("课程班级已存在");
                bool = false;
            }
            if(bool) {
                $("form").submit();
            }
        }

    </script>
    <style type="text/css">
        .error {color:red;}
    </style>

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
            <div class="col-sm-8 col-sm-offset-2" >
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="panel-title"><h3 class="centerh">开设课程</h3></div>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-12">
                                <form action="<c:url value='/TeacherServlet'/>" method="post">
                                    <input type="hidden" name="method" value="addCtTime"/>
                                    <input type="hidden" name="crID" value="${cr.crID }"/>
                                    <div class="form-inline">
                                        <div class="form-group" id="formgroupclass">
                                            <label for="crClassid">课程班级</label>
                                            <input type="text" name="crClass" id="crClassid"/>
                                            <label id="crClassError" class="error">&nbsp;</label>
                                            <span id="helpBlock" class="help-block">四位阿拉伯数字，如0001</span>
                                        </div>
                                        <div class="form-group">
                                            <label for="crTermid">开课学期</label>
                                            <input type="text" name="term" id="crTermid">
                                            <label id="termError" class="error">&nbsp;</label>
                                            <span id="helpBlock2" class="help-block inline">如2014-2015-上</span>
                                            <!-- 缺一个形如····格式 -->
                                        </div>
                                    </div>
                                    <div class="table table-responsive">
                                        <table class="table table-bordered table-striped table-hover">
                                            <tr>
                                                <td>周一</td>
                                                <td>周二</td>
                                                <td>周三</td>
                                                <td>周四</td>
                                                <td>周五</td>
                                                <td>周六</td>
                                                <td>周日</td>
                                            </tr>
                                            <tr>
                                                <td><input type="checkbox" name="mon" value="1" />1</td>
                                                <td><input type="checkbox" name="tu" value="1" />1</td>
                                                <td><input type="checkbox" name="we" value="1" />1</td>
                                                <td><input type="checkbox" name="th" value="1" />1</td>
                                                <td><input type="checkbox" name="fr" value="1" />1</td>
                                                <td><input type="checkbox" name="sa" value="1" />1</td>
                                                <td><input type="checkbox" name="su" value="1" />1</td>
                                            </tr>
                                            <tr>
                                                <td><input type="checkbox" name="mon" value="2" />2</td>
                                                <td><input type="checkbox" name="tu" value="2" />2</td>
                                                <td><input type="checkbox" name="we" value="2" />2</td>
                                                <td><input type="checkbox" name="th" value="2" />2</td>
                                                <td><input type="checkbox" name="fr" value="2" />2</td>
                                                <td><input type="checkbox" name="sa" value="2" />2</td>
                                                <td><input type="checkbox" name="su" value="2" />2</td>
                                            </tr>
                                            <tr>
                                                <td><input type="checkbox" name="mon" value="3" />3</td>
                                                <td><input type="checkbox" name="tu" value="3" />3</td>
                                                <td><input type="checkbox" name="we" value="3" />3</td>
                                                <td><input type="checkbox" name="th" value="3" />3</td>
                                                <td><input type="checkbox" name="fr" value="3" />3</td>
                                                <td><input type="checkbox" name="sa" value="3" />3</td>
                                                <td><input type="checkbox" name="su" value="3" />3</td>
                                            </tr>
                                            <tr>
                                                <td><input type="checkbox" name="mon" value="4" />4</td>
                                                <td><input type="checkbox" name="tu" value="4" />4</td>
                                                <td><input type="checkbox" name="we" value="4" />4</td>
                                                <td><input type="checkbox" name="th" value="4" />4</td>
                                                <td><input type="checkbox" name="fr" value="4" />4</td>
                                                <td><input type="checkbox" name="sa" value="4" />4</td>
                                                <td><input type="checkbox" name="su" value="4" />4</td>
                                            </tr>
                                            <tr>
                                                <td><input type="checkbox" name="mon" value="5" />5</td>
                                                <td><input type="checkbox" name="tu" value="5" />5</td>
                                                <td><input type="checkbox" name="we" value="5" />5</td>
                                                <td><input type="checkbox" name="th" value="5" />5</td>
                                                <td><input type="checkbox" name="fr" value="5" />5</td>
                                                <td><input type="checkbox" name="sa" value="5" />5</td>
                                                <td><input type="checkbox" name="su" value="5" />5</td>
                                            </tr>
                                            <tr>
                                                <td><input type="checkbox" name="mon" value="6" />6</td>
                                                <td><input type="checkbox" name="tu" value="6" />6</td>
                                                <td><input type="checkbox" name="we" value="6" />6</td>
                                                <td><input type="checkbox" name="th" value="6" />6</td>
                                                <td><input type="checkbox" name="fr" value="6" />6</td>
                                                <td><input type="checkbox" name="sa" value="6" />6</td>
                                                <td><input type="checkbox" name="su" value="6" />6</td>
                                            </tr>
                                            <tr>
                                                <td><input type="checkbox" name="mon" value="7" />7</td>
                                                <td><input type="checkbox" name="tu" value="7" />7</td>
                                                <td><input type="checkbox" name="we" value="7" />7</td>
                                                <td><input type="checkbox" name="th" value="7" />7</td>
                                                <td><input type="checkbox" name="fr" value="7" />7</td>
                                                <td><input type="checkbox" name="sa" value="7" />7</td>
                                                <td><input type="checkbox" name="su" value="7" />7</td>
                                            </tr>
                                            <tr>
                                                <td><input type="checkbox" name="mon" value="8" />8</td>
                                                <td><input type="checkbox" name="tu" value="8" />8</td>
                                                <td><input type="checkbox" name="we" value="8" />8</td>
                                                <td><input type="checkbox" name="th" value="8" />8</td>
                                                <td><input type="checkbox" name="fr" value="8" />8</td>
                                                <td><input type="checkbox" name="sa" value="8" />8</td>
                                                <td><input type="checkbox" name="su" value="8" />8</td>
                                            </tr>
                                        </table>
                                    </div>
                                    <label id="timeError" class="error">&nbsp;</label>
                                    <input type="button" value="开设课程" class="btn btn-default btn-sm" onclick="add()"/>
                                    <input type="reset" value="重置" class="btn btn-default btn-sm"/>
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
