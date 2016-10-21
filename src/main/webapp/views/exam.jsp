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
                        <form id="selectgradeForm" class="signup-form" action = "getExpressions.do">
                        	 <div class="form-group">
                        	 <input name="gradename" id="gradename" type="text" class="sel" placeholder="请填写考试名称：" onblur="validatorGradeName()">
                        	 <td><div id="accDiv"></div></td>
                        	 
                        	 <select id="expnum" class="sel" name="expnum">
									<option value="10">请选择考试题数,默认：10</option>
									<option value="10">10</option>
									<option value="20">20</option>
									<option value="50">50</option>
									<option value="100">100</option>
							</select>
								
							 <select id="graderank" class="sel" name="graderank">
								<option value="0">请选择考试级别,默认：一级-青铜</option>
								<option value="1">一级-青铜</option>
								<option value="2">二级-白银</option>
								<option value="3">三级-黄金</option>
								<option value="4">四级-白金</option>
								<option value="5">五级-钻石</option>
								<option value="6">六级-最强王者</option>
								<option value="7">七级-超凡大师</option>
							</select>
							
							<input type="submit" class="btn btn-cta btn-cta-primary" value="开始考试">
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
<!-- <script>
/* $.validator.setDefaults({
    //submitHandler: function() {
     // alert("提交事件!");
    //}
}); */
$().ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	  $("#selectgradeForm").validate({
	    rules: {
	      gradename: {
	        required: true,
	      },
	      graderank: {
		    required: true,
		  }
	    },
	    messages: {
	      gradename: {
	        required: "请输入考试名称",
	      },
	    graderank: {
		    required: "请输入考试等级",
		  }
	    }
	});
});
</script>
 -->  
<script type="text/javascript">
function validatorGradeName(){
	//alert("aaaaa");
	 var gradename=document.getElementById("gradename").value;
	 if(gradename == "")
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
			    	 document.getElementById("accDiv").innerHTML = "考试名称已经使用";
		    	}  
	  		}            
	        });   
	}		
</script>
	
</body>
</html>