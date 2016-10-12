<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试模块</title>
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
					<span class="name">小学生四则运算 考试系统</span>
					<hr class="star-light">
				</div>
			</div>
		</div>
	</div>
	<div class="fixed-container">
                <div class="signup">
                    <div class="container_type text-center">
                    <a name="exam-anchor" id="exam-anchor" > </a>
                        <h3 class="title">答题入口</h3>
                        <p class="summary">考试说明：考试难度分别为初级、中级、高级。请选择考试级别后进入考试答题系统。</p>
                        <form class="signup-form" action = "getExpressions.do">
                            <div class="form-group">
	                            <select class="sel" name="graderank">
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
                            <input type="submit" class="btn btn-cta btn-cta-primary" value="开始考试">
                        </form><!--//signup-form-->
                    </div><!--//contianer-->
                </div><!--//signup-->
                </div>
</header>

<%@ include file="indextemplatefooter.jsp"%>
</body>
</html>