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
							<li><a href="info.jsp">个人信息</a></li>
							<li><a href="#" class="active-menu">修改密码</a></li>
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
							修改密码 <small>修改你的密码</small>
						</h1>
					</div>
				</div>
				<!-- /. ROW  -->


				<div class="row">

					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-heading">修改密码</div>
							<div class="panel-body">

								<form class="form-horizontal" role="form">
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">当前密码</label>
										<div class="col-sm-10">
											<input type="password" class="form-control" id="firstname"
												placeholder="当前密码">
										</div>
									</div>
									<div class="form-group">
										<label for="lastname" class="col-sm-2 control-label">新密码</label>
										<div class="col-sm-10">
											<input type="password" class="form-control" id="lastname"
												placeholder="新密码">
										</div>
									</div>
								<div class="form-group">
										<label for="lastname" class="col-sm-2 control-label">确认密码</label>
										<div class="col-sm-10">
											<input type="password" class="form-control" id="lastname"
												placeholder="确认密码">
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="submit" class="btn btn-success">确认</button>
										</div>
									</div>
								</form>

							</div>
						</div>
					</div>
				</div>
				<!-- /. ROW  -->
				<footer>
					<p>
						Copyright &copy; 2016.Company name All rights reserved.<a
							target="_blank" href=""></a>
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
