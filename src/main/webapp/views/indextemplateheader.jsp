<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="css/freelancer.css" rel="stylesheet">

<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<!-- <link href="http://fonts.useso.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
<link href="http://fonts.useso.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
 -->
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Plugin JavaScript -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="js/classie.js"></script>
<script src="js/cbpAnimatedHeader.js"></script>

<!-- Contact Form JavaScript -->
<script src="js/jqBootstrapValidation.js"></script>
<script src="js/contact_me.js"></script>

<!-- Custom Theme JavaScript -->
<script src="js/freelancer.js"></script>
</head>
<body id="page-top" class="index">
<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="login_top">
			<ul class="nav navbar-nav navbar-right">
			<c:if test="${student==null}"> 
  				<li><a href="#" data-toggle="modal" data-target="#myModal">登陆</a></li>
				<li><a href="#" data-toggle="modal" data-target="#myModal1">注册</a></li>
				<li><a href="#">&nbsp;</a></li>
			</c:if> 
			<c:if test="${student!=null}"> 
    			<li><a href="#" >aaa欢迎！</a></li>
				<li><a href="#" >学生：</a></li>
				<li><a href="#" >${student.stunick}</a></li>
				<li><a href="signup.do" >退出</a></li>
				<li><a href="#" >&nbsp; </a></li>
				
			</c:if> 
			</ul>
		</div>
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="../index.jsp#page-top">小学生四则运算</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right ul_top">
				<li class="hidden">
					<a href="#page-top"></a>
				</li>
				<li class="page-scroll">
					<a href="index.jsp">主页</a>
				</li>
				<li class="page-scroll">
					<a href="views/test.jsp#test-anchor">练习模块</a>
				</li>
				<li class="page-scroll">
					<a href="views/exam.jsp#exam-anchor">考试模块</a>
				</li>
				<li class="page-scroll">
					<a href="views/index.jsp#portfolio">学习模块</a>
				</li>
					<li class="page-scroll">
					<a href="getStuMsg.do">个人信息</a>
				</li>
				<li class="page-scroll">
					<a href="#contact">联系我们</a>
				</li>
				
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<!--signin-->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-content modal-info">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
						</div>
						<div class="modal-body real-spa">
							<div class="login-grids">
								<div class="login">
									<div class="login-right">
										<form action="#" method="post">
											<h3>用户登录</h3>
											<input type="text" name="Email" value="请输入用户名或邮箱" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入用户名或邮箱';}" required="">	
											<input type="password" name="Password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="">	
											<h4><a href="#">忘记密码</a> / <a href="#">创建新密码</a></h4>
											<div class="single-bottom">
												<input type="checkbox"  id="brand" value="">
												<label for="brand"><span></span>记住我</label>
											</div>
											<input type="submit" value="确认" >
										</form>
									</div>
								</div>
								<!-- <p>By logging in you agree to our <a href="#">Terms</a> and <a href="#">Conditions</a> and <a href="#">Privacy Policy</a></p> -->
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--signin-->
			<!--Register-->
			<div class="modal fade" id="myModal1" tabindex="-1" role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-content modal-info">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
						</div>
						<div class="modal-body real-spa">
							<div class="login-grids">
								<div class="login">
									<div class="login-right">
										<form action="#" method="post">
											<h3>Register </h3>
											<input type="text" name="Name" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}" required="">
											<input type="text" name="Phone" value="Mobile number" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Mobile number';}" required="">
											<input type="text" name="Email" value="Email id" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email id';}" required="">	
											<input type="password" name="Password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="">	
											
											<input type="submit" value="Register Now" >
										</form>
									</div>
									<div class="clearfix"></div>								
								</div>
								<p>By logging in you agree to our <a href="#">Terms</a> and <a href="#">Conditions</a> and <a href="#">Privacy Policy</a></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		<!--Register-->
<!-- Header -->
</body>
</html>