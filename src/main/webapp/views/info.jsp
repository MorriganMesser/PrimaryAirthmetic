<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Dream</title>
<!-- Bootstrap Styles-->
<link href="../css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="../css/font-awesome.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="../css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<link href='http://fonts.useso.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default top-navbar" role="navigation">

		</nav>
		<!--/. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">

					<li><a href="../index.jsp" class=""><i class="fa fa-table"></i>返回主页</a>
					</li>
					<li><a href="#"><i class="fa fa-edit"></i>练习系统</a></li>


					<li><a href="exam.jsp" class=""><i class="fa fa-sitemap"></i>考试系统</a>
					</li>
					<li><a href="#"><i class="fa fa-fw fa-file"></i>学习系统</a></li>
					<li><a href="#"><i class="fa fa-dashboard"></i>提交试卷</a></li>
					<li><a href="#"><i class="fa fa-desktop"></i>成绩查询</a></li>
					<li><a href="chart.html"><i class="fa fa-bar-chart-o"></i>统计分析</a>
					</li>



					<li><a href="#"><i class="fa fa-sitemap"></i>用户 <span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="#" class="active-menu">个人信息</a></li>
							<li><a href="password.jsp">修改密码</a></li>
							<li><a href="#">Second Level Link</a></li>
						</ul></li>

				</ul>
			</div>

		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">
							用户信息 <small>这里是你的账户信息</small>
						</h1>
					</div>
				</div>
				<!-- /. ROW  -->


				<div class="row">

					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-heading">用户信息</div>

							<div class="panel-body">
								<table class="table">
									<tr>
										<td>用户名</td>
										<td>200</td>
									</tr>
									<tr>
										<td>账户年龄</td>
										<td>400</td>
									</tr>
								</table>

								<div class="panel panel-primary">
									<div class="panel-heading">
										<h3 class="panel-title">用户名</h3>
									</div>
									<div class="panel-body">aa</div>
								</div>

								<div class="panel panel-primary">
									<div class="panel-heading">
										<h3 class="panel-title">练习记录</h3>
									</div>
									<div class="panel-body">
										<table class="table">
											<tr>
												<td>答题总数</td>
												<td>0</td>
											</tr>
											<tr>
												<td>正确总数</td>
												<td>0</td>
											</tr>
											<tr>
												<td>正确率</td>
												<td>0</td>
											</tr>
										</table>
									</div>
								</div>
								<div class="panel panel-primary">
									<div class="panel-heading">
										<h3 class="panel-title">综合</h3>
									</div>
									<div class="panel-body">
										<table class="table">
											<tr>
												<td>擅长题型</td>
												<td>0</td>
											</tr>
											<tr>
												<td>不擅长题型</td>
												<td>0</td>
											</tr>

										</table>
									</div>
								</div>


							</div>
						</div>
					</div>
				</div>
				<!-- /. ROW  -->
				<footer>
					<p>
						Copyright &copy; 2016.Company name All rights reserved.<a
							target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
					</p>
				</footer>
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
	<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script src="../js/jquery-1.10.2.js"></script>
	<!-- Bootstrap Js -->
	<script src="../js/bootstrap.min.js"></script>
	<!-- Metis Menu Js -->
	<script src="../js/jquery.metisMenu.js"></script>
	<!-- Custom Js -->
	<script src="../js/custom-scripts.js"></script>

</body>
</html>
