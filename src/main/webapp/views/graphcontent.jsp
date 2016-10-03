<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dream</title>
	<!-- Bootstrap Styles-->
    <link href="../css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="../css/font-awesome.css" rel="stylesheet" />
     <!-- Morris Chart Styles-->
    <link href="../js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- Custom Styles-->
    <link href="../css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='http://fonts.useso.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            

        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
					
                    <li>
                        <a href="../index.jsp" class=""><i class="fa fa-table"></i>返回主页</a>
                    </li>
                    <li>
                        <a href="#" class="active-menu"><i class="fa fa-edit"></i>练习系统</a>
                    </li>


                    <li>
                        <a href="exam.jsp" class=""><i class="fa fa-sitemap"></i>考试系统</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-file"></i>学习系统</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-dashboard"></i>提交试卷</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-desktop"></i>成绩查询</a>
                    </li>
					<li>
                        <a href="#"><i class="fa fa-bar-chart-o"></i>统计分析</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-qrcode"></i>个人信息</a>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
         <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            Charts <small>Show up your stats</small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
             
                <div class="row"> 
                    
                      
                               <div class="col-md-6 col-sm-12 col-xs-12">                     
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Bar Chart
                        </div>
                        <div class="panel-body">
                            <div id="morris-bar-chart"></div>
                        </div>
                    </div>            
                </div>
                      <div class="col-md-6 col-sm-12 col-xs-12">                     
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Area Chart
                        </div>
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
                        <div class="panel-heading">
                            Donut Chart
                        </div>
                        <div class="panel-body">
                            <div id="morris-line-chart"></div>
                        </div>
                    </div>            
                </div>
                      <div class="col-md-6 col-sm-12 col-xs-12">                     
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Line Chart
                        </div>
                        <div class="panel-body">                            
							<div id="morris-donut-chart"></div>
                        </div>
                    </div>            
                </div> 
                
           </div>
                 <!-- /. ROW  -->
				 <footer><p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p></footer>
				</div>
             <!-- /. PAGE INNER  -->
             <footer><p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p></footer>
    </div>
             <!-- /. PAGE INNER  -->
            </div>
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
