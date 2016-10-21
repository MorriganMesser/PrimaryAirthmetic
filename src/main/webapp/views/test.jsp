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
                        <form class="signup-form" action="testExp.do" id="selecttestForm">
                            <div class="form-group">
                            <input name="testname" id="testname" type="text" class="sel" placeholder="请填写练习名称：" onblur="validatorGradeName()">
                            <td><div id="accDiv"></div></td>
	                            <select class="sel" name="testrank">
									<option value="1">请选择练习级别,默认：一级-青铜</option>
									<option value="1">一级-青铜</option>
									<option value="2">二级-白银</option>
									<option value="3">三级-黄金</option>
									<option value="4">四级-白金</option>
									<option value="5">五级-钻石</option>
									<option value="6">六级-最强王者</option>
									<option value="7">七级-超凡大师</option>
								</select>
                          
	                            <select class="sel" name="testmethod">
									<option value="0">请选择练习模式,默认：加法</option>
									<option value="0">加法运算</option>
									<option value="1">加减混合运算</option>
									<option value="2">加减乘混合运算</option>
									<option value="3">加减乘除混合运算</option>
								</select>
	                            <select id="expnum" class="sel" name="expnum">
									<option value="10">请选择考试题数,默认：10</option>
									<option value="10">10</option>
									<option value="20">20</option>
									<option value="50">50</option>
									<option value="100">100</option>
								</select>
                            <input type="submit" class="btn btn-cta btn-cta-primary" value="开始练习">
                              </div>
                        </form><!--//signup-form-->
                    </div><!--//contianer-->
                </div><!--//signup-->
                </div>
</header>

<%@ include file="indextemplatefooter.jsp"%>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script>
/* $.validator.setDefaults({
    //submitHandler: function() {
     // alert("提交事件!");
    //}
}); */
$().ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	  $("#selecttestForm").validate({
	    rules: {
	      testname: {
	        required: true,
	      },
	      testrank: {
		    required: true,
		  }
	    },
	    messages: {
	      testname: {
	        required: "请输入考试名称",
	      },
	      testrank: {
		    required: "请输入考试等级",
		  }
	    }
	});
});
</script>
<script type="text/javascript">
function validateTestName(){
	//alert("aaaaa");
	 var gradename=document.getElementById("testname").value;
	 if(testname == "")
	 {
		 document.getElementById("accDiv").innerHTML = "考试名称不能空";
	 	return;
	 }
	 $.ajax({
	 		type: "POST",    
	         url: "valiGradeNames.do",    
	         data: "gradename="+gradename,
	         dataType:"json",//返会值的类型
	         success: function(data){
	        	// alert(data)
			   if(data){
				   //alert("用户名不可用") 
			    	 document.getElementById("accDiv").innerHTML = "";
			    }else{   
			    	//alert("用户名可用")
			    	 document.getElementById("accDiv").innerHTML = "练习名称已经使用";
		    	}  
	  		}            
	        });   
	}		
</script>
	
</body>
</html>