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
				<div class="login_top">
			<ul class="nav navbar-nav navbar-right">
			<c:if test="${student==null}"> 
  				<li><a href="#" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-user"></span>  甜某某</a></li>
				<li><a href="#" data-toggle="modal" data-target="#myModal1">退出</a></li>
				<li><a href="#">&nbsp;</a></li>
			</c:if>
			</ul>
		</div>
		</nav>
		<!--/. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">

					<li><a href="#" class="active-menu"><i
							class="fa fa-table"></i>待定..</a></li>
					<li><a href="teacherstudent.jsp"><i class="fa fa-desktop"></i>学生查询</a>
					<li><a href="teacherscore.jsp"><i class="fa fa-desktop"></i>成绩查询</a>
					</li>
					<li><a href="teachergraph.jsp"><i class="fa fa-bar-chart-o"></i>成绩统计</a></li>
					<li><a href="teacherinfo.jsp"><i class="fa fa-qrcode"></i>用户<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="teacherinfo.jsp">个人中心</a></li>
							<li><a href="views/password.jsp">修改密码</a></li>
						</ul></li>

				</ul>

			</div>

		</nav>
		<!-- /. NAV SIDE  -->
</body>
</html>