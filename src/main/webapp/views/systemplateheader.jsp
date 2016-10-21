<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<!-- Bootstrap Styles-->
<link href="css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<!-- Morris Chart Styles-->
 <link href="js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<!--谷歌字体加载-->
<!-- <link href='http://fonts.useso.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' /> -->
<!-- TABLE STYLES-->
<link href="css/dataTables.bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default top-navbar" role="navigation">
		</nav>
		<!--/. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">

					<li><a href="index.jsp" class="active-menu"><i
							class="fa fa-table"></i>返回主页</a></li>
					<li><a href="testpage.do"><i class="fa fa-edit"></i>练习系统</a></li>


					<li><a href="exampage.do"><i class="fa fa-sitemap"></i>考试系统</a></li>
					<li><a href="index.jsp#portfolio"><i class="fa fa-fw fa-file"></i>学习系统</a></li>
					<li><a href="getStuGrade.do"><i class="fa fa-desktop"></i>成绩查询</a>
					</li>
					<li><a href="getStuGrade2.do"><i class="fa fa-bar-chart-o"></i>统计分析</a></li>
					
					<li><a href="getStuMsg.do"><i class="fa fa-qrcode"></i>用户<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="getStuMsg.do">个人中心</a></li>
							<li><a href="views/password.jsp">修改密码</a></li>
							<li><a href="#">任务</a></li>
						</ul></li>

				</ul>

			</div>

		</nav>
		<!-- /. NAV SIDE  -->
</body>
</html>