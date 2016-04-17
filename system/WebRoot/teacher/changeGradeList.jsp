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
	<script src="${pageContext.request.contextPath}/js/teacher.js" type="text/javascript"></script>
	<script type="text/javascript">
		function add() {
			var bool = true;
			var orid = document.getElementById("orid");
			if(orid.value>1||orid.value<0)
			{
			   var error = document.getElementById("error");
			   error.innerHTML = "比例填写不对应在0-1之间";
			   bool = false;
			}
    			<c:forEach items="${requestScope.grList}" var="grList">
        			var ex${grList.studentID} = document.getElementById("ex${grList.studentID}");
        			var or${grList.studentID} = document.getElementById("or${grList.studentID}");
        			if(ex${grList.studentID}.value==""||or${grList.studentID}.value=="")
        			{
        				bool = false;
        	   			var totalla${grList.studentID} = document.getElementById("totalla${grList.studentID}");
        	    			totalla${grList.studentID}.innerHTML = "成绩没有输入";
        			}
    			</c:forEach>
			if(bool) {
				$("form").submit();
			}
		}
	</script>
<style type="text/css">
	.error {color:red;}
</style>
	<title>录入学生成绩</title>
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
				<div class="col-sm-12">
					<div class="panel panel-default">
						<div class="panel-heading"><h4 class="centerh"><strong>录入成绩</strong></h4></div>
						<form action="<c:url value='/TeacherServlet'/>" method="post">
							<input type="hidden" name="method" value="changeGrade"/>
							<div class="form-group">
								<label for="orid">输入平时成绩所占比例</label>
								<input type="text" name="or" id="orid" onchange="getGrade()" />
								<apan class="help-block" id="orhelp"></apan>
							</div>
							<div class="table table-responsive">
								<table class="table table-bordered table-striped table-hover" id="grade_table">
									<tr>
										<th>学生学号</th>
										<th>课程编码</th>
										<th>课程名称</th>
										<th>开课班级</th>
										<th>缺勤次数</th>
										<th>平时成绩</th>
										<th>考试成绩</th>
										<th>总成绩</th>
									</tr>
									<c:forEach items="${requestScope.grList}" var="grList">
										<tr>
											<td><input type="hidden" name="stID" value="${grList.studentID}"/>${grList.studentID}</td>
											<td><input type="hidden" name="crID" value="${grList.courseID}"/>${grList.courseID}</td>
											<td><input type="hidden" name="crName" value="${grList.courseName}"/>${grList.courseName}</td>
											<td><input type="hidden" name="crClass" value="${grList.courseClass}"/>${grList.courseClass}</td>
											<td>${grList.absent}</td>
											<td><input type="text" name="ordinary" id="or${grList.studentID}" onchange="getGrade()"/></td>
											<td><input type="text" name="exam" id="ex${grList.studentID}" onchange="getGrade()"/></td>
											<td><label id="totalla${grList.studentID}"></label></td>
										</tr>
										<script type="text/javascript">
											var orid = document.getElementById("orid");
											var ex${grList.studentID} = document.getElementById("ex${grList.studentID}");
											var or${grList.studentID} = document.getElementById("or${grList.studentID}");
											var totalla${grList.studentID} = document.getElementById("totalla${grList.studentID}");
											var totalid${grList.studentID} = document.getElementById("totalid${grList.studentID}");
											ex${grList.studentID}.onblur = function()
											{
												if(orid.value>1||orid.value<0)
												{
													var error = document.getElementById("error");
													error.innerHTML = "比例填写不对应在0-1之间";
												}
												else if(ex${grList.studentID}.value==0&&or${grList.studentID}.value==0)
												{
													totalla${grList.studentID}.innerHTML="成绩没输入";
												}
												else
												{
													var total = 0;
													var exgr = ex${grList.studentID}.value-0;
													var orgr = or${grList.studentID}.value-0;
													total = exgr*(1-orid.value) + orgr*(orid.value-0);
													totalla${grList.studentID}.innerHTML = total;
													totalid${grList.studentID}.value = total-'0';
												}

											}
										</script>
									</c:forEach>
								</table>
							</div>
							<div class="form-group">
								<input type="button" value="提交"  onclick="add()" class="btn btn-default btn-sm"/>
								<input type="reset" value="重置" class="btn btn-default btn-sm"/>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
  </body>
</html>
