<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
	<script src="${pageContext.request.contextPath}/echarts/echarts.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/login_scripts.js" type="text/javascript"></script>
	<titile>查询学生成绩及缺勤</titile>
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
		  <div class="col-sm-12 ">
			  <div class="panel panel-default">
				  <div class="panel-heading">
					  <h4 class="centerh">
						  <strong>成绩及缺勤信息</strong>
						  <button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#data_view">
							  可视化数据
						  </button>
					  </h4>
				  </div>
				  <div class="panel-body">
					  <div class="table table-responsive">
						  <table class="table table-bordered table-striped table-hover" id="absent_table">
							  <tr>
								<th>课程编码</th>
								  <th>课程名称</th>
								  <th>开课班级</th>
								  <th>开课学期</th>
								  <th>缺勤次数</th>
								  <th>学生学号</th>
								  <th>学生姓名</th>
								<th>平时成绩</th>
								<th>考试成绩</th>
								<th>总成绩</th>
							</tr>
	
							<c:forEach items="${requestScope.grList}" var="grList">
							<tr>
								<td>${grList.courseID}</td>
								<td>${grList.courseName}</td>
								<td>${grList.courseClass}</td>
								<td>${grList.term}</td>
								<td>${grList.absent}</td>
								<td>${grList.studentID}</td>
								<td>${grList.studentName}</td>
								<td>${grList.ordinary}</td>
								<td>${grList.exam}</td>
								<td>${grList.total}</td>
							</tr>
							</c:forEach>
						  </table>
					  </div>
				  </div>
			  </div>
		  </div>
	  </div>
  </div>
  <div class="modal fade" id="data_view">
	  <div class="modal-dialog">
		  <div class="modal-content">
			  <div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					  <span aria-hidden="true">&times</span>
				  </button>
				  <h4 class="modal-title">缺勤情况</h4>
			  </div>
			  <div class="modal-body">
				  <div id="data_chart" style="height: 400px;width: 330px; margin: auto"></div>
			  </div>
			  <div class="modal-footer">
				  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			  </div>
		  </div>
	  </div>
  </div>

  <script type="text/javascript">

	  var myChart = echarts.init(document.getElementById("data_chart"));
	  var table = jQuery("#absent_table");
	  var table_body = table.children().last();
	  var trs = table_body.children();
	  var students = new Array();
	  var counts = new Array();
	  for(var i = 1 ; i < trs.length;i++)
	  {
		  var td2 = trs.eq(i).children().eq(4);
		  if(td2.html()>0)
		  {
			  counts.push(td2.html());
			  var td1 = trs.eq(i).children().eq(6);
			  students.push(td1.html());
		  }
		  if(trs.eq(i).children().eq(9).html()<60)
		  {
			  trs.eq(i).addClass("danger");
		  }
	  }
	  var option={
		  title:{
			  text:"缺勤情况柱状图"
		  },
		  tooltip:{},
		  legend:{
			  data:['次数']
		  },
		  xAxis:{
			  data:students
		  },
		  yAxis:{},
		  series:[{
			  name:'次数',
			  type:"bar",
			  data:counts
		  }]
	  };
	  myChart.setOption(option);
  </script>
  </body>
</html>
