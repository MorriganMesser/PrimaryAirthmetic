<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>历史记录</title>
</head>
<body>
	<%@ include file="systemplateheader.jsp"%>
	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-header">
						历史数据 <small>统计你的练习情况</small>
					</h1>
				</div>
			</div>
			<!-- /. ROW  -->

			<div class="row">


				<div class="col-md-6 col-sm-12 col-xs-12">
					<div class="panel panel-default">
						<div class="panel-heading">Bar Chart</div>
						<div class="panel-body">
							<div id="morris-bar-chart"></div>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12">
					<div class="panel panel-default">
						<div class="panel-heading">Area Chart</div>
						<div class="panel-body">
							<div id="morris-area-chart"></div>
						</div>
					</div>
				</div>

			</div>
			<!-- /. ROW  -->
			<div class="row">

				<div class="col-md-6 col-sm-12 col-xs-12">
					<div class="panel panel-default">
						<div class="panel-heading">Donut Chart</div>
						<div class="panel-body">
							<div id="morris-line-chart"></div>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12">
					<div class="panel panel-default">
						<div class="panel-heading">Line Chart</div>
						<div class="panel-body">
							<div id="morris-donut-chart"></div>
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
	</div>
	<!-- /. PAGE INNER  -->

	<!-- /. PAGE WRAPPER  -->
	<!-- /. WRAPPER  -->

	<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script src="../js/jquery-1.10.2.js"></script>
	<!-- Bootstrap Js -->
	<script src="../js/bootstrap.min.js"></script>
	<!-- Metis Menu Js -->
	<script src="../js/jquery.metisMenu.js"></script>
	<!-- Morris Chart Js -->
	<script src="../js/morris/raphael-2.1.0.min.js"></script>
	<script src="../js/morris/morris.js"></script>
	<!-- Custom Js -->
	<script src="../js/custom-scripts.js"></script>

</body>
</html>
