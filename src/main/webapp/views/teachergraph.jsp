<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"></base>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>历史记录</title>
</head>
<body>
	<%@ include file="teacherheader.jsp"%>
	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-header">
						成绩统计 <small>统计学生的练习情况</small>
					</h1>
				</div>
			</div>
			
			<!-- /. ROW  -->
			<div class="row">
				<div class="panel panel-success">
								<div class="panel-heading">
									<h3 class="panel-title">
										<span class="glyphicon glyphicon-user"></span> 学生信息
									</h3>
								</div>
								<div class="panel-body">

									<table class="table">
										<tr>
											<td>学号</td>
											<td>xx</td>
										</tr>
										<tr>
											<td>姓名</td>
											<td>1</td>
										</tr>
										<tr>
											<td>练习总量</td>
											<td>1v0</td>
										</tr>
										<tr>
											<td>正确率</td>
											<td>0</td>
										</tr>
									</table>
								</div>
							</div>	
			</div>		
			<!-- /. ROW  -->

			<!-- /. 练习记录  -->
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">练习记录</div>
					<div class="panel-body">
						<div id="line-chart-test"></div>
					</div>
				</div>
			</div>

			<!-- /. 考试记录  -->
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">考试记录</div>
					<div class="panel-body">
						<div id="line-chart-exam"></div>
					</div>
				</div>
			</div>

			<!-- /. 考试记录  -->
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">正确题型比例</div>
					<div class="panel-body">
						<div id="donut-chart-type-percent"></div>
					</div>
				</div>
			</div>

			<footer>
				<p>
					Copyright &copy; 2016.Company name All rights reserved.<a
						target="_blank" href="">xxx</a>
				</p>
			</footer>
		</div>
	</div>
	<!-- /. PAGE INNER  -->

	<!-- /. PAGE WRAPPER  -->
	<!-- /. WRAPPER  -->

	<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script src="js/jquery-1.10.2.js"></script>
	<!-- Bootstrap Js -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Metis Menu Js -->
	<script src="js/jquery.metisMenu.js"></script>
	<!-- Morris Chart Js -->
	<script src="js/morris/raphael-2.1.0.min.js"></script>
	<script src="js/morris/morris.js"></script>
	<!-- Custom Js -->
	<script src="js/custom-scripts.js"></script>

	<script>
		//折线图，练习记录
		new Morris.Line({
			// ID of the element in which to draw the chart.
			element : 'line-chart-test',
			// Chart data records -- each entry in this array corresponds to a point on
			// the chart.
			data : [ {
				year : '2008-01-01',
				sum : 10,
				right : 8
			}, {
				year : '2009-01-01',
				sum : 12,
				right : 8
			}, {
				year : '2010-01-01',
				sum : 22,
				right : 15
			}, {
				year : '2011-01-01',
				sum : 25,
				right : 18
			}, {
				year : '2012-01-01',
				sum : 32,
				right : 29
			} ],
			// The name of the data record attribute that contains x-values.
			xkey : 'year',
			// A list of names of data record attributes that contain y-values.
			ykeys : [ 'sum', 'right' ],
			// Labels for the ykeys -- will be displayed when you hover over the
			// chart.
			labels : [ '题目总数', '正确数量' ],

			xLabels : "month",

			resize : true,
		});
	</script>
	<script>
		//折线图，考试记录
		new Morris.Line({
			// ID of the element in which to draw the chart.
			element : 'line-chart-exam',
			// Chart data records -- each entry in this array corresponds to a point on
			// the chart.
			data : [ {
				year : '2008-01-01',
				sum : 100,
				right : 80
			}, {
				year : '2009-01-01',
				sum : 120,
				right : 80
			}, {
				year : '2010-01-01',
				sum : 202,
				right : 150
			}, {
				year : '2011-01-01',
				sum : 205,
				right : 108
			}, {
				year : '2012-01-01',
				sum : 320,
				right : 290
			} ],
			// The name of the data record attribute that contains x-values.
			xkey : 'year',
			// A list of names of data record attributes that contain y-values.
			ykeys : [ 'sum', 'right' ],
			// Labels for the ykeys -- will be displayed when you hover over the
			// chart.
			labels : [ '题量', '正确' ],

			xLabels : "month",
			
			resize : true,
		});
	</script>
	<script>
		/*
		 *题型比例，饼图
		 */
		Morris.Donut({
			element : 'donut-chart-type-percent',
			data : [ {
				label : "加法数量",
				value : 30.5
			}, {
				label : "减法数量",
				value : 25.5
			}, {
				label : "乘法数量",
				value : 20
			}, {
				label : "除法数量",
				value : 20
			} ]
		
		
		});
	</script>
</body>
</html>
