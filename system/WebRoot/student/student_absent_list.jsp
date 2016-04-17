<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
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
	<script src="${pageContext.request.contextPath}/echarts/echarts.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/jquery/jquery.backstretch.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/login_scripts.js" type="text/javascript"></script>

	<title>缺勤列表</title>
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
				<li><a href="<c:url value='/student/student_index.jsp'/>">主页</a></li>
				<li>
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
					   aria-haspopup="true" aria-expanded="false">查询 <span class="caret"></span></a>
					<ul class="dropdown-menu dropdown-menu-inverse">
						<li><a href="<c:url value='/StudentServlet?method=query_course_info'/>">查询课表</a></li>
						<li><a href="<c:url value='/StudentServlet?method=query_grade_info'/>">查询成绩</a></li>
						<li><a href="<c:url value='/StudentServlet?method=query_absent_info'/>">缺勤情况</a></li>
					</ul>
				</li>
				<li><a href="<c:url value='/student/student_info.jsp'/>">个人信息</a></li>
				<li><a href="<c:url value='/student/student_modify_password.jsp'/>">修改密码</a></li>
				<li><a href="/system/index.jsp">退出</a></li>
			</ul>
		</div>
	</div>
</nav>
<hr>
<div class="container">
	<div class="row">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="centerh">
						<strong>缺勤总况</strong>
						<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#data_view">
							可视化数据
						</button>
					</h4>
				</div>
				<div class="table table-responsive">
					<table class="table table-striped table-hover" id="data_table">
						<thead>
						<tr>
							<td>学期</td>
							<td>总次数</td>
						</tr>
						</thead>
						<tbody>
						<c:forEach items = "${requestScope.absent_info_map }" var = "entry" >
							<tr>
								<td>${entry.key }</td>
								<td>${entry.value }</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<hr>
			<div class="panel panel-default">
				<div class="panel-heading"><h4 class="centerh"><strong>缺勤详情</strong></h4></div>
				<div class="panel-body">

				</div>

				<div class="table table-responsive">
					<table class="table table-striped table-hover">
						<thead>
						<tr>
							<td>学期</td>
							<td>课程名称</td>
							<td>缺勤次数</td>
						</tr>
						</thead>
						<tbody>
						<c:forEach items = "${requestScope.absent_info_list }" var = "absent_info">
							<tr>
								<td>${absent_info.term }</td>
								<td>${absent_info.cname }</td>
								<td>${absent_info.absent }</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
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
				<div id="data_chart" style="height: 400px;width: 330px; margin: auto "></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var myChart = echarts.init(document.getElementById("data_chart"));
	var table = jQuery("#data_table");
	var table_body = table.children().last() ;
	var trs = table_body.children();
	var terms = new Array();
	var counts = new Array();
	for(var i = 0 ; i < trs.length;i++)
	{
		var td1 = trs.eq(i).children().first();
		terms.push(td1.html());
		var td2 = trs.eq(i).children().last();
		counts.push(td2.html());
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
			data:terms
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
