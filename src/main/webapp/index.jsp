<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>HOME</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="css/freelancer.css" rel="stylesheet">

<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="http://fonts.useso.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.useso.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

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
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="js/classie.js"></script>
<script src="js/cbpAnimatedHeader.js"></script>

<!-- Contact Form JavaScript -->
<script src="js/jqBootstrapValidation.js"></script>
<script src="js/contact_me.js"></script>

<!-- Custom Theme JavaScript -->
<script src="js/freelancer.js"></script>
</head>

<body id="page-top" class="index">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="login_top">
			<ul class="nav navbar-nav navbar-right">
			<c:if test="${student==null}"> 
  				<li><a href="#" data-toggle="modal" data-target="#myModal">登陆</a></li>
				<li><a href="#" data-toggle="modal" data-target="#myModal1">注册</a></li>
				<li><a href="#" data-toggle="modal" data-target="#myModal1">${student.stuname }</a></li>
			</c:if> 
			<c:if test="${student!=null}"> 
    			<li><a href="#" data-toggle="modal" data-target="#myModal">欢迎！</a></li>
				<li><a href="#" data-toggle="modal" data-target="#myModal1">学生：</a></li>
				<li><a href="#" data-toggle="modal" data-target="#myModal1">${student.stuname }</a></li>
			</c:if> 
			</ul>
		</div>
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#page-top">小学生四则运算</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right ul_top">
					<li class="hidden"><a href="#page-top"></a></li>
					<li class="page-scroll"><a href="#page-top">主页</a></li>
					<li class="page-scroll"><a href="#">个人信息</a></li>
					<li class="page-scroll"><a href="views/test.jsp">练习模块</a></li>
					<li class="page-scroll"><a href="views/exam.jsp">考试模块</a></li>
					<li class="page-scroll"><a href="#portfolio">学习模块</a></li>
					<li class="page-scroll"><a href="#contact">联系我们</a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<header>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<img class="img-responsive" src="img/profile.png" alt="">
					<div class="intro-text">
						<span class="name">小学生四则运算 评测系统</span>
						<hr class="star-light">
						<span class="skills">勿在浮沙筑高台，学好四则再登云。</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Portfolio Grid Section -->
	<section id="portfolio">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>九九乘法表</h2>
					<hr class="star-primary">
				</div>
			</div>

			<div class="">
				<!--    Context Classes  -->
				<div class="panel panel-default">

					<div class="panel-body">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>\</th>
										<th>一</th>
										<th>二</th>
										<th>三</th>
										<th>四</th>
										<th>五</th>
										<th>六</th>
										<th>七</th>
										<th>八</th>
										<th>九</th>
									</tr>
								</thead>
								<tbody>
									<tr class="success">
										<td>1</td>
										<td>1*1=1</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr class="info">
										<td>2</td>
										<td>1*2=2</td>
										<td>2*2=4</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr class="warning">
										<td>3</td>
										<td>1*3=3</td>
										<td>2*3=6</td>
										<td>3*3=9</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr class="danger">
										<td>4</td>
										<td>1*4=4</td>
										<td>2*4=8</td>
										<td>3*4=12</td>
										<td>4*4=16</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr class="success">
										<td>5</td>
										<td>1*5=5</td>
										<td>2*5=10</td>
										<td>3*5=15</td>
										<td>4*5=20</td>
										<td>5*5=25</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr class="info">
										<td>6</td>
										<td>1*6=6</td>
										<td>2*6=12</td>
										<td>3*6=18</td>
										<td>4*6=24</td>
										<td>5*6=30</td>
										<td>6*6=36</td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr class="warning">
										<td>7</td>
										<td>1*7=7</td>
										<td>2*7=14</td>
										<td>3*7=21</td>
										<td>4*7=28</td>
										<td>5*7=35</td>
										<td>6*7=42</td>
										<td>7*7=49</td>
										<td></td>
										<td></td>
									</tr>
									<tr class="danger">
										<td>8</td>
										<td>1*8=8</td>
										<td>2*8=16</td>
										<td>3*8=24</td>
										<td>4*8=32</td>
										<td>5*8=40</td>
										<td>6*8=48</td>
										<td>7*8=56</td>
										<td>8*8=64</td>
										<td></td>
									</tr>
									<tr class="success">
										<td>9</td>
										<td>1*9=9</td>
										<td>2*9=18</td>
										<td>3*9=27</td>
										<td>4*9=36</td>
										<td>5*9=45</td>
										<td>6*9=54</td>
										<td>7*9=63</td>
										<td>8*9=72</td>
										<td>9*9=81</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!--  end  Context Classes  -->
				<br> <br>
				<div class="row">
					<div class="col-lg-12 text-center">
						<h2>小学生算术技巧篇</h2>
						<hr class="star-primary">
					</div>
					<div class="col-sm-4 portfolio-item">
						<a href="#portfolioModal1" class="portfolio-link"
							data-toggle="modal">
							<div class="caption">
								<div class="caption-content">
									<i class="fa fa-search-plus fa-3x"></i>
								</div>
							</div> <img src="img/portfolio/cabin.png" class="img-responsive" alt="">
						</a>
					</div>
					<div class="col-sm-4 portfolio-item">
						<a href="#portfolioModal2" class="portfolio-link"
							data-toggle="modal">
							<div class="caption">
								<div class="caption-content">
									<i class="fa fa-search-plus fa-3x"></i>
								</div>
							</div> <img src="img/portfolio/cake.png" class="img-responsive" alt="">
						</a>
					</div>
					<div class="col-sm-4 portfolio-item">
						<a href="#portfolioModal3" class="portfolio-link"
							data-toggle="modal">
							<div class="caption">
								<div class="caption-content">
									<i class="fa fa-search-plus fa-3x"></i>
								</div>
							</div> <img src="img/portfolio/circus.png" class="img-responsive"
							alt="">
						</a>
					</div>
					<div class="col-sm-4 portfolio-item">
						<a href="#portfolioModal4" class="portfolio-link"
							data-toggle="modal">
							<div class="caption">
								<div class="caption-content">
									<i class="fa fa-search-plus fa-3x"></i>
								</div>
							</div> <img src="img/portfolio/game.png" class="img-responsive" alt="">
						</a>
					</div>
					<div class="col-sm-4 portfolio-item">
						<a href="#portfolioModal5" class="portfolio-link"
							data-toggle="modal">
							<div class="caption">
								<div class="caption-content">
									<i class="fa fa-search-plus fa-3x"></i>
								</div>
							</div> <img src="img/portfolio/safe.png" class="img-responsive" alt="">
						</a>
					</div>
					<div class="col-sm-4 portfolio-item">
						<a href="#portfolioModal6" class="portfolio-link"
							data-toggle="modal">
							<div class="caption">
								<div class="caption-content">
									<i class="fa fa-search-plus fa-3x"></i>
								</div>
							</div> <img src="img/portfolio/submarine.png" class="img-responsive"
							alt="">
						</a>
					</div>
				</div>
			</div>
	</section>

	<!-- About Section -->
	<section class="success" id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>四则混合运算儿歌</h2>
					<hr class="star-light">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-lg-offset-2">
					<p>通览全题定方案，细看是否能简便；</p>
				</div>
				<div class="col-lg-4">
					<p>从左到右脱式算，先乘除来后加减；</p>
				</div>
				<div class="col-lg-4 col-lg-offset-2">
					<p>括号依次小中大，先算里面后外面；</p>
				</div>
				<div class="col-lg-4">
					<p>横式计算竖检验，一步一查是关键。</p>
				</div>
			</div>
		</div>
	</section>

	<!-- Contact Section -->
	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>联系我们</h2>
					<hr class="star-primary">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
					<!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
					<form name="sentMessage" id="contactForm" novalidate>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label>姓名</label> <input type="text" class="form-control"
									placeholder="姓名" id="name" required
									data-validation-required-message="Please enter your name.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label>电子邮箱</label> <input type="email" class="form-control"
									placeholder="电子邮箱" id="email" required
									data-validation-required-message="Please enter your email address.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label>电话号码</label> <input type="tel" class="form-control"
									placeholder="电话号码" id="phone" required
									data-validation-required-message="Please enter your phone number.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label>信息</label>
								<textarea rows="5" class="form-control" placeholder="信息"
									id="message" required
									data-validation-required-message="Please enter a message."></textarea>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<br>
						<div id="success"></div>
						<div class="row">
							<div class="form-group col-xs-12">
								<button type="submit" class="btn btn-success btn-lg">发送</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>


	<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
	<div class="scroll-top page-scroll visible-xs visible-sm">
		<a class="btn btn-primary" href="#page-top"> <i
			class="fa fa-chevron-up"></i>
		</a>
	</div>

	<!-- Portfolio Modals -->
	<div class="portfolio-modal modal fade" id="portfolioModal1"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Project Title</h2>
							<hr class="star-primary">
							<img src="img/portfolio/cabin.png"
								class="img-responsive img-centered" alt="">
							<p>
								Use this area of the page to describe your project. The icon
								above is part of a free icon set by <a
									href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On
								their website, you can download their free set with 16 icons, or
								you can purchase the entire set with 146 icons for only $12!
							</p>
							<ul class="list-inline item-details">
								<li>Client: <strong><a href="http://sc.chinaz.com">Start
											Bootstrap</a> </strong>
								</li>
								<li>Date: <strong><a href="http://sc.chinaz.com">April
											2016</a> </strong>
								</li>
								<li>Service: <strong><a
										href="http://sc.chinaz.com">Web Development</a> </strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="portfolioModal2"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Project Title</h2>
							<hr class="star-primary">
							<img src="img/portfolio/cake.png"
								class="img-responsive img-centered" alt="">
							<p>
								Use this area of the page to describe your project. The icon
								above is part of a free icon set by <a
									href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On
								their website, you can download their free set with 16 icons, or
								you can purchase the entire set with 146 icons for only $12!
							</p>
							<ul class="list-inline item-details">
								<li>Client: <strong><a href="http://sc.chinaz.com">Start
											Bootstrap</a> </strong>
								</li>
								<li>Date: <strong><a href="http://sc.chinaz.com">April
											2016</a> </strong>
								</li>
								<li>Service: <strong><a
										href="http://sc.chinaz.com">Web Development</a> </strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="portfolioModal3"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Project Title</h2>
							<hr class="star-primary">
							<img src="img/portfolio/circus.png"
								class="img-responsive img-centered" alt="">
							<p>Use this area of the page to describe your project. The
								icon above is part of a free icon set Flat Icons. On their
								website, you can download their free set with 16 icons, or you
								can purchase the entire set with 146 icons for only $12!</p>
							<ul class="list-inline item-details">
								<li>Client: <strong><a href="http://sc.chinaz.com">Start
											Bootstrap</a> </strong>
								</li>
								<li>Date: <strong><a href="http://sc.chinaz.com">April
											2016</a> </strong>
								</li>
								<li>Service: <strong><a
										href="http://sc.chinaz.com">Web Development</a> </strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="portfolioModal4"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Project Title</h2>
							<hr class="star-primary">
							<img src="img/portfolio/game.png"
								class="img-responsive img-centered" alt="">
							<p>
								Use this area of the page to describe your project. The icon
								above is part of a free icon set by <a
									href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On
								their website, you can download their free set with 16 icons, or
								you can purchase the entire set with 146 icons for only $12!
							</p>
							<ul class="list-inline item-details">
								<li>Client: <strong><a href="http://sc.chinaz.com">Start
											Bootstrap</a> </strong>
								</li>
								<li>Date: <strong><a href="http://sc.chinaz.com">April
											2016</a> </strong>
								</li>
								<li>Service: <strong><a
										href="http://sc.chinaz.com">Web Development</a> </strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="portfolioModal5"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Project Title</h2>
							<hr class="star-primary">
							<img src="img/portfolio/safe.png"
								class="img-responsive img-centered" alt="">
							<p>
								Use this area of the page to describe your project. The icon
								above is part of a free icon set by <a
									href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On
								their website, you can download their free set with 16 icons, or
								you can purchase the entire set with 146 icons for only $12!
							</p>
							<ul class="list-inline item-details">
								<li>Client: <strong><a href="http://sc.chinaz.com">Start
											Bootstrap</a> </strong>
								</li>
								<li>Date: <strong><a href="http://sc.chinaz.com">April
											2016</a> </strong>
								</li>
								<li>Service: <strong><a
										href="http://sc.chinaz.com">Web Development</a> </strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="portfolioModal6"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Project Title</h2>
							<hr class="star-primary">
							<img src="img/portfolio/submarine.png"
								class="img-responsive img-centered" alt="">
							<p>
								Use this area of the page to describe your project. The icon
								above is part of a free icon set by <a
									href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On
								their website, you can download their free set with 16 icons, or
								you can purchase the entire set with 146 icons for only $12!
							</p>
							<ul class="list-inline item-details">
								<li>Client: <strong><a href="http://sc.chinaz.com">Start
											Bootstrap</a> </strong>
								</li>
								<li>Date: <strong><a href="http://sc.chinaz.com">April
											2016</a> </strong>
								</li>
								<li>Service: <strong><a
										href="http://sc.chinaz.com">Web Development</a> </strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<footer class="text-center">
		<div class="footer-below">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">Copyright &copy; 2016.Goliath All
						rights reserved.</div>
				</div>
			</div>
		</div>
	</footer>

	<!--signin-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content modal-info">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body real-spa">
					<div class="login-grids">
						<div class="login">
							<div class="login-right">
								<form action="login.do" method="post">
									<h3>用户登录</h3>
									<input type="text" name="nameoremail" placeholder="请输入用户名或邮箱">
									<input type="password" name="password" placeholder="密码">
									<div class="row"></div>
									<br /> <select class="form-control" name="type">
										<option value="学生">学生</option>
										<option value="教师">教师</option>
										<option value="家长">家长</option>
									</select>
									<h4>
										<a href="#">忘记密码</a> / <a href="#">创建新密码</a>
									</h4>
									<div class="single-bottom">
										<input type="checkbox" id="brand" value=""> <label
											for="brand"><span></span>记住我</label>
									</div>
									<input type="submit" value="确认">
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
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body real-spa">
					<div class="login-grids">
						<div class="login">
							<div class="login-right">
								<form action="register.do" id="loginForm" method="post">
									<h3>用户注册</h3>
									<input type="text" id="nick" name="nick" placeholder="昵称"> <input
										type="text" id="name" name="name" placeholder="用户名"> <input
										type="text" id="email" name="email" placeholder="邮箱"> <input
										type="password" id="password" name="password" placeholder="密码">

									<div class="row"></div>
									<br /> <select class="form-control" name="type">
										<option value="学生">学生</option>
										<option value="教师">教师</option>
										<option value="家长">家长</option>
									</select> <input type="submit" value="注册">
								</form>
							</div>
							<div class="clearfix"></div>
						</div>
						<p>
							By logging in you agree to our <a href="#">Terms</a> and <a
								href="#">Conditions</a> and <a href="#">Privacy Policy</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--Register-->
	
	
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script>
$.validator.setDefaults({
    submitHandler: function() {
      alert("提交事件!");
    }
});
$().ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	  $("#loginForm").validate({
	    rules: {
	      nick: {
	        required: true,
	        minlength: 2
	      },
	      name: {
		    required: true,
		    minlength: 2
		  },
	      password: {
	        required: true,
	        minlength: 5
	      },
	      email: {
	        required: true,
	        email: true
	      }
	    },
	    messages: {
	      nick: {
	        required: "请输入昵称",
	        minlength: "昵称必需由两个字母组成"
	      },
	      name: {
		        required: "请输入用户名",
		        minlength: "用户名必需由两个字母组成"
		      },
	      password: {
	        required: "请输入密码",
	        minlength: "密码长度不能小于 5 个字母"
	      },
	      email: "请输入一个正确的邮箱",
	    }
	});
});
</script>
	
	
</body>

</html>

