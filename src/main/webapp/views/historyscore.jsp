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
	<script src="js/date.js"></script>
</head>
<body>
<%@ include file="systemplateheader.jsp"%>       
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            小学生四则运算 <small>成绩查询系统 V1.0</small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
               
            <div class="row" >
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <form name="reg_testdate" class="signup-form" action="getGradeSelect.do" method="post">
	                            <div class="form-group history">
	                           		 开始日期：
	                            	<input id="d11" name="starttime" type="text" onClick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
	                            	
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									结束日期：
	                            	<input id="d11" name="endtime" type="text" onClick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									难度：
		                            <select class="sel" name="graderank">
										<option value="">请选择难度系数</option>
										<option value="一级-青铜">一级-青铜</option>
										<option value="二级-白银">二级-白银</option>
										<option value="三级-黄金">三级-黄金</option>
										<option value="四级-白金">四级-白金</option>
										<option value="五级-钻石">五级-钻石</option>
										<option value="六级-最强王者">六级-最强王者</option>
										<option value="七级-超凡大师">七级-超凡大师</option>
										</select>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									模式：
		                            <select class="sel" name="grademodel">
										<option value="">请选择模式</option>
										<option value="考试">考试</option>
										<option value="练习">练习</option>
									</select>
	                            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                           		<input name="" type="submit" value="查询" class="btn">
	                        	</div>
                       		</form>
                        </div>
                        
                         
                        <div class="panel-body">
                            <div class="table-responsive" style="overflow-x:hidden;">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>序号</th>
                                            <th>模式</th>
                                            <th>名称</th>
                                            <th>难度</th>
                                            <th>分数</th>
                                            <th>正确个数</th>
                                            <th>错误个数</th>
                                            <th>正确率</th>
                                            <th>答题时间</th>
                                            <th>日期</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                    <c:forEach var="grade" items="${gradelist}" varStatus="stat">
                                        <tr class="odd gradeX">
                                            <th>${grade.gradeid}</th>
                                            <th>${grade.grademodel}</th>
                                            <th>${grade.gradename}</th>
                                            <td>${grade.graderank}</td>
                                            <td>${grade.grade}</td>
                                            <td>${grade.graderightnum}</td>
                                            <td>${grade.gradeerrornum}</td>
                                             <td>${grade.graderate}</td>
                                             <td>${grade.gradetime}</td>
                                            <td>${grade.gradedate}</td>
                                           
                                        </tr>
                                    </c:forEach>
                                        
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
                <!-- /. ROW  -->
            
        </div>
               <footer><p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p></footer>
    </div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
     <script src="My97DatePicker/WdatePicker.js"></script>
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
   
</body>
</html>
