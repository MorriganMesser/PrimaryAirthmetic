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
                        <p class="summary">说明：请选择练习难度、模式后进入练习系统。</p>
                        <form class="signup-form" action="testExp.do">
                            <div class="form-group">
	                            <select class="sel" name="rank">
									<option value="">请选择练习级别</option>
									<option value="">一级-青铜</option>
									<option value="">二级-白银</option>
									<option value="">三级-黄金</option>
								</select>
                            </div>
                            <div class="form-group">
	                            <select class="sel" name="rankmethod">
									<option value="">请选择练习模式</option>
									<option value="">加法</option>
									<option value="">减法</option>
									<option value="">乘法</option>
									<option value="">除法</option>
									<option value="">加减混合运算</option>
									<option value="">乘除混合运算</option>
									<option value="">加减乘除混合运算</option>
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