<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>缺勤信息</title>
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
				<li><a href="<c:url value='/assistant/assistant_index.jsp'/>">主页</a></li>
				<li>
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
					   aria-haspopup="true" aria-expanded="false">查询 <span class="caret"></span></a>
					<ul class="dropdown-menu dropdown-menu-inverse">
						<li><a href="<c:url value='/AssistantServlet?method=load_choose_class&method_path=query_absent_info'/>">缺勤情况</a></li>
						<li><a href="<c:url value='/AssistantServlet?method=load_choose_class&method_path=query_grade_info'/>">学生成绩</a></li>
					</ul>
				</li>
				<li><a href="<c:url value='/AssistantServlet?method=load_choose_class&method_path=edit_absent_info'/>">修改缺勤信息</a></li>
				<li><a href="<c:url value='/AssistantServlet?method=query_assistant_info'/>">个人信息</a></li>
				<li><a href="<c:url value='/assistant/assistant_modify_password.jsp'/>">修改密码</a></li>
				<li><a href="/system/index.jsp">退出</a></li>
			</ul>
		</div>
	</div>
</nav>
<hr>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="centerh">
						<strong>缺勤列表</strong>
						<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#data_view">
							可视化数据
						</button>
					</h4>
				</div>
				<div class="table-bordered">
					<table class="table table-striped table-hover table-bordered" id="absent_table">
						<thead>
						<tr>
							<td><strong>&nbsp;学&nbsp;号&nbsp;</strong></td>
							<td><strong>&nbsp;姓&nbsp;名&nbsp;&nbsp;&nbsp;</strong></td>

							<c:forEach items = "${requestScope.course_list }" var = "course">
								<td>${course }</td>
							</c:forEach>
							<td><strong>总计</strong></td>
						</tr>
						</thead>
						<tbody>
						<c:forEach items = "${requestScope.student_absent_list }" var = "absent_list">
							<tr>
								<c:forEach items="${absent_list }" var = "absent" varStatus = "vs">
									<c:if test="${vs.first }">
										<td>${absent.student_id }</td>
										<td>${absent.student_name }</td>
									</c:if>
									<td>${absent.absent }</td>
									<c:if test="${vs.last }">
										<td>${absent.absent_total }</td>
									</c:if>
								</c:forEach>
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
	for(var i = 0 ; i < trs.length;i++)
	{
		var td2 = trs.eq(i).children().last();
		if(td2.html()>0)
		{
			counts.push(td2.html());
			var td1 = trs.eq(i).children().eq(1);
			students.push(td1.html());
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
