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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>练习模块</title>
<link href="css/exam.css" rel="stylesheet">
</head>
<body id="page-top" class="index">
<%@ include file="indextemplateheader.jsp"%>
<header>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<img class="img-responsive" src="img/profile.png" alt="">
				<div class="intro-text">
					<span class="name">小学生四则运算 练习系统</span>
					<hr class="star-light">
				</div>
			</div>
		</div>
	</div>
	<div class="fixed-container">
                <div class="signup">
                    <div class="container_type text-center">
                    <a name="test-anchor" id="test-anchor" > </a>
                        <h3 class="title">答题入口</h3>
                        <p class="summary">说明：请填写练习名称，选择练习难度、模式后进入练习系统。</p>
                        <form class="signup-form" action="testExp.do">
                            <div class="form-group">
                            <input name="gradename" id="testname" type="text" class="sel" placeholder="请填写练习名称：">
	                            <select class="sel" name="testrank">
									<option value="0">请选择考试级别</option>
									<option value="1">一级-青铜</option>
									<option value="2">二级-白银</option>
									<option value="3">三级-黄金</option>
									<option value="4">四级-白金</option>
									<option value="5">五级-钻石</option>
									<option value="6">六级-最强王者</option>
									<option value="7">七级-超凡大师</option>
								</select>
                            </div>
                            <div class="form-group">
	                            <select class="sel" name="testmethod">
									<option value="">请选择练习模式</option>
									<option value="0">加法</option>
									<option value="1">减法</option>
									<option value="2">乘法</option>
									<option value="3">除法</option>
									<option value="3">加减混合运算</option>
									<option value="3">乘除混合运算</option>
									<option value="3">加减乘除混合运算</option>
								</select>
                            </div>
                            <div class="form-group">
	                            <select id="expnum" class="sel" name="expnum">
									<option value="10">请选择考试题数,默认：10</option>
									<option value="10">10</option>
									<option value="20">20</option>
									<option value="50">50</option>
									<option value="100">100</option>
								</select>
                            </div>
                            <input type="submit" class="btn btn-cta btn-cta-primary" value="开始练习">
                        </form><!--//signup-form-->
                    </div><!--//contianer-->
                </div><!--//signup-->
                </div>
</header>

<%@ include file="indextemplatefooter.jsp"%>
</body>
</html>