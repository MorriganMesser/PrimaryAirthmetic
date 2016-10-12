<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="333" onsubmit="return submessage(this)" method="post" name="form1">
			<table border="1" width="500" cellspacing="1" cellpadding="3" align="left" bordercolor="#326598" >
				<tr>
					<td colspan="7" bgcolor="#FEA817">
						[align=center]
							<font color="#FFFFFF"><b>用户注册</b> </font>
						[/align]
					</td>
				</tr>
				<tr>
					<td>
						用户名
					</td>
					<td>
						<input name="uname" id="username" type="text" class="form_text" size="20" onblur="validatorloginName()">      
					</td>
					<td><div id="accDiv"></div></td>
				</tr>
				
				<tr>
					<td>
						登陆密码
					</td>
					<td>
						<input type="password" name="upwd">
					</td>
				</tr>
				<tr>
					<td>
						确认密码
					</td>
					<td>
						<input type="password" name="upwd1">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="提交">
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
					</form>

<script src="js/jquery.js"></script>
<script type="text/javascript">
function validatorloginName(){
	 var loginName=document.getElementById("username").value;
	 if(loginName == "")
	 {
		 document.getElementById("accDiv").innerHTML = "用户名不能空";
	 	return;
	 }
	 $.ajax({
	 		type: "POST",    
	         url: "validateName.do",    
	         data: "loginName="+loginName,
	         dataType:"json",//返会值的类型
	         success: function(data){
			   if(data){
				   //alert("用户名不可用") 
			    	 document.getElementById("accDiv").innerHTML = "用户名已存在";
			    }else{   
			    	//alert("用户名可用")
			    	 document.getElementById("accDiv").innerHTML = "用户名可用";
		    	}  
	  		}            
	        });   
	}		


</script>

</body>
</html>