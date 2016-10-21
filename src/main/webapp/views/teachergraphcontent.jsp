<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="edu.tju.goliath.entity.Grade" import="java.util.List" import="java.text.SimpleDateFormat"%>
	
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
<title>历史记录</title>
</head>
<body>
	<%@ include file="teacherheader.jsp"%>
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

			<!-- /. ROW  -->

			<!-- /. 练习记录  -->
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">练习记录</div>
					<div class="panel-body">
						<div id="line-chart-test"></div>
					</div>
				</div>
			</div>

			<!-- /. 考试记录  -->
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">考试记录</div>
					<div class="panel-body">
						<div id="line-chart-exam"></div>
					</div>
				</div>
			</div>

			<!-- /. 考试记录  -->
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">正确率</div>
					<div class="panel-body">
						<div id="donut-chart-type-percent"></div>
					</div>
				</div>
			</div>

			<footer>
				<p>
					Copyright &copy; 2016.Company name All rights reserved.<a
						target="_blank" href="">xxx</a>
				</p>
			</footer>
		</div>
	</div>
	<!-- /. PAGE INNER  -->

	<!-- /. PAGE WRAPPER  -->
	<!-- /. WRAPPER  -->

	<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script src="js/jquery-1.10.2.js"></script>
	<!-- Bootstrap Js -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Metis Menu Js -->
	<script src="js/jquery.metisMenu.js"></script>
	<!-- Morris Chart Js -->
	<script src="js/morris/raphael-2.1.0.min.js"></script>
	<script src="js/morris/morris.js"></script>
	<!-- Custom Js -->
	<script src="js/custom-scripts.js"></script>

<%

		List<Grade> grade=(List<Grade>)session.getAttribute("gradelist");

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		//练习数据
		String[] year=new String[grade.size()];
		Integer[] sum=new Integer[grade.size()];
		Integer[] right=new Integer[grade.size()];
		int count=grade.size();
		for(int i=1,j=1;i<grade.size();i++)
		{
			if(grade.get(i).getGrademodel().toString().equals("练习"))
			{
				year[j] = sdf.format(grade.get(i).getGradedate());
				sum[j] = grade.get(i).getGradenums();
				right[j] = grade.get(i).getGraderightnum();
				
				j++;
				count=j;
			}
		}
		
		//考试数据
		String[] eyear=new String[grade.size()];
		Integer[] esum=new Integer[grade.size()];
		Integer[] eright=new Integer[grade.size()];
		int ecount=grade.size();
		for(int i=1,j=1;i<grade.size();i++)
		{
			if(grade.get(i).getGrademodel().toString().equals("考试"))
			{
				eyear[j] = sdf.format(grade.get(i).getGradedate());
				esum[j] = grade.get(i).getGradenums();
				eright[j] = grade.get(i).getGraderightnum();
				
				j++;
				ecount=j;
			}
		}
		
		//正确率
		Integer rc=0;//正确的数量
		Integer wc=0;
		for(int i=1;i<grade.size();i++)
		{

			if(!"".equals(grade.get(i).getGraderightnum()) && null!=grade.get(i).getGraderightnum())
				rc+=grade.get(i).getGraderightnum();
			if(!"".equals(grade.get(i).getGradenums()) && null!=grade.get(i).getGradenums() && 
					!"".equals(grade.get(i).getGraderightnum()) && null!=grade.get(i).getGraderightnum())
				wc=(grade.get(i).getGradenums())-(grade.get(i).getGraderightnum())+wc;

			
		}
%>
<script type="text/javascript">

		//折线图，练习记录
		new Morris.Line({
			// ID of the element in which to draw the chart.
			element : 'line-chart-test',
			// Chart data records -- each entry in this array corresponds to a point on
			// the chart.
			data : [ 
			
			   	 <%
				   if(year!=null)
				   {
				    for(int i=1;i<count;i++)
				    {
				  %>
				 
				  	{
				  		minute : '<%=year[i]%>',
				    	sum : <%=sum[i]%>,
						right :<%=right[i]%>
				  	},
				  
				  <%   
				  } 
				   }
				  %>
			
			 ],

			// The name of the data record attribute that contains x-values.
			xkey : 'minute',
			// A list of names of data record attributes that contain y-values.
			ykeys : [ 'sum', 'right' ],
			// Labels for the ykeys -- will be displayed when you hover over the
			// chart.
			labels : [ '题目总数', '正确数量' ],

			xLabels : "month",

			resize : true,
		});
	</script>
	<script>
		//折线图，考试记录
		new Morris.Line({
			// ID of the element in which to draw the chart.
			element : 'line-chart-exam',
			// Chart data records -- each entry in this array corresponds to a point on
			// the chart.
			data : [ 
			        <%
					   if(year!=null)
					   {
					    for(int i=1;i<ecount;i++)
					    {
					  %>
					 
					  	{
					  		minute : '<%=eyear[i]%>',
					    	sum : <%=esum[i]%>,
							right :<%=eright[i]%>
					  	},
					  
					  <%   
					  } 
					   }
					  %>   
			 ],
			// The name of the data record attribute that contains x-values.
			xkey : 'minute',
			// A list of names of data record attributes that contain y-values.
			ykeys : [ 'sum', 'right' ],
			// Labels for the ykeys -- will be displayed when you hover over the
			// chart.
			labels : [ '题量', '正确' ],

			xLabels : "month",
			
			resize : true,
		});
	</script>
	<script>
		/*
		 *题型比例，饼图
		 */
		Morris.Donut({
			element : 'donut-chart-type-percent',
			data : [ {
				label : "正确总数",
				value : <%=rc%>
			}, {
				label : "错误总数",
				value : <%=wc%>
			}, 
 ]		
		
		});
	</script>
</body>
</html>
