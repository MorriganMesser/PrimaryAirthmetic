<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>用户信息</title>
</head>
<body>
	<%@ include file="teacherheader.jsp"%>

	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-header">
						个人中心 <small>这里是你的个人空间</small>
					</h1>
				</div>
			</div>
			<!-- /. ROW  -->


			<div class="row">

				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">用户信息</div>

						<div class="panel-body">

							<div class="panel panel-success">
								<div class="panel-heading">
									<h3 class="panel-title">
										<span class="glyphicon glyphicon-user"></span> 用户
									</h3>
								</div>
								<div class="panel-body">

									<table class="table">
										<tr>
											<td>用户名</td>
											<td>xx</td>
										</tr>
										<tr>
											<td>账户年龄</td>
											<td>1</td>
										</tr>
									</table>
								</div>
							</div>

							
							<div class="panel panel-info">
								<div class="panel-heading">
									<h3 class="panel-title">
										<span class="glyphicon glyphicon-heart"></span> 综合
									</h3>
								</div>
								<div class="panel-body">
									<table class="table table-hover">
										<tr>
											<td>學生人數</td>
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
						target="_blank" href="">xxx</a>
				</p>
			</footer>
		</div>
		<!-- /. PAGE INNER  -->
	</div>
	<!-- /. PAGE WRAPPER  -->

	<!-- /. WRAPPER  -->
	<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script src="js/jquery-1.10.2.js"></script>
	<!-- Bootstrap Js -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Metis Menu Js -->
	<script src="js/jquery.metisMenu.js"></script>
	<!-- Custom Js -->
	<script src="js/custom-scripts.js"></script>

</body>
</html>
