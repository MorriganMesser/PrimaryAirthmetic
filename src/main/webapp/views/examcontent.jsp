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
    <title>考试答题模式</title>
	
</head>
<body>
   <%@ include file="systemplateheader.jsp"%> 
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            小学生四则运算 <small>在线考试系统 V1.0</small>
                        </h1>
                        
                    </div>
                </div> 
                 <!-- /. ROW  -->
               
            <div class="row" >
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	 当前级别：一级-青铜
                            	 <!-- 根据点击提交的级别，进行相应的修改 -->
                            	 <div class="time">
							        <span id="t_d">倒计时：</span>
							        <span id="t_h">00时</span>
							        <span id="t_m">00分</span>
							        <span id="t_s">00秒</span>
							        &nbsp;&nbsp;&nbsp;
							    </div>
                        </div>
                        
                         
                        <div class="panel-body">
                            <div class="table-responsive" style="overflow-x:hidden;">
                            <form action="judgeExpressions.do">
                            
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>题号</th>
                                            <th>题目</th>
                                            <th>答案</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                     <c:forEach var="explist" items="${explist}" varStatus="stat">
                                        <tr class="odd gradeX">
                                            <td>${explist.expid}</td>
                                            <td>${explist.expvalue}</td>
                                            <td><input type="text" name="result"></td>
                                        </tr>
                                     </c:forEach>
                                    </tbody>
                                </table>
                                <input type="submit" value="提交试卷">
                                </form>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
                <!-- /. ROW  -->
            
        </div>
               <footer><p>Copyright &copy; 2016.Goliath All rights reserved.</p></footer>
    </div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="js/jquery.js"></script>
      <!-- Bootstrap Js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="js/jquery.metisMenu.js"></script>
     <!-- DATA TABLE SCRIPTS -->
    <script src="js/jquery.dataTables.js"></script>
    <script src="js/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
    </script>
         <!-- Custom Js -->
    <script src="js/custom-scripts.js"></script>
    <script type="text/javascript">
    $(document).ready( function() {
		 *      $('#example').dataTable( {
		 *        "displayStart": 10
		 *      } );
		 *    } )
    </script>
    
    <script>
   function GetRTime(){
       var EndTime= new Date('2016/10/01 00:00:00');
       //结束时间，获取点击“开始考试”的系统时间。
       var NowTime = new Date();
       var t =EndTime.getTime() - NowTime.getTime();
       var d=Math.floor(t/1000/60/60/24);
       var h=Math.floor(t/1000/60/60%24);
       var m=Math.floor(t/1000/60%60);
       var s=Math.floor(t/1000%60);

       document.getElementById("t_h").innerHTML = h + "时";
       document.getElementById("t_m").innerHTML = m + "分";
       document.getElementById("t_s").innerHTML = s + "秒";
   }
   setInterval(GetRTime,0);
</script>
<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS_HTML">
</script> 
</body>
</html>
