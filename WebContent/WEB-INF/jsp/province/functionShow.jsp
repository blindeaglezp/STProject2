<!-- 
	author:blindeagle
	version:1.0
	date:2015.11.29
 -->
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>功能展示</title>
	<meta name="Keywords" content="">
    <meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
		<link href="<%=request.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/ace.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<!-- inline styles related to this page -->
		<!-- ace settings handler -->
		<script src="<%=request.getContextPath() %>/assets/js/ace-extra.min.js"></script>
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>
			<jsp:include page="/public/top.jsp"></jsp:include>
				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<ul class="nav nav-list">
						<li>
							<a href="#">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 首页 </span>
							</a>
						</li>

						<li>
							<a href="<%=request.getContextPath()%>/servlet/ProvinceServlet?type=toUserManage"">
								<i class="icon-text-width"></i>
								<span class="menu-text"> 用户管理 </span>
							</a>
						</li>

						<li>
							<a href="<%=request.getContextPath()%>/servlet/ProvinceServlet?type=toCityManage"" class="dropdown-toggle">
								<i class="icon-desktop"></i>
								<span class="menu-text"> 市区管理 </span>
							</a>
						</li>

						<li>
							<a href="<%=request.getContextPath()%>/servlet/ProvinceServlet?type=toSubjectManage"" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text"> 科目管理 </span>
							</a>
						</li>

						<li>
							<a href="<%=request.getContextPath()%>/servlet/ProvinceServlet?type=toProjectManage"" class="dropdown-toggle">
								<i class="icon-edit"></i>
								<span class="menu-text"> 项目管理 </span>
							</a>
						</li>
					</ul><!-- /.nav-list -->
				</div>
		<script src="<%=request.getContextPath() %>/assets/js/bootstrap.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/typeahead-bs2.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/jquery.slimscroll.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/jquery.easy-pie-chart.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/jquery.sparkline.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/flot/jquery.flot.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/flot/jquery.flot.pie.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/flot/jquery.flot.resize.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/ace-elements.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/ace.min.js"></script>
</body>
</html>


<%-- <html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>功能展示</title>
    <meta name="Keywords" content="">
    <meta name="description" content="">
    <link rel="StyleSheet" href="<%=request.getContextPath() %>/css/dtree.css" type="text/css" />
    <link rel="StyleSheet" href="<%=request.getContextPath() %>/css/p1.css" type="text/css" />
</head>
<body onload="province_initLeft();">
    <div class="container">
        <jsp:include page="/public/top.jsp"></jsp:include>
        <jsp:include page="/public/left.jsp"></jsp:include>
        <div class="right">
        	<ul class="ul_function">
        		<li><a href="<%=request.getContextPath()%>/servlet/ProvinceServlet?type=toUserManage">用户管理</a></li>
        		<li><a href="<%=request.getContextPath()%>/servlet/ProvinceServlet?type=toSubjectManage">科目管理</a></li>
        		<li><a href="<%=request.getContextPath()%>/servlet/ProvinceServlet?type=toProjectManage">项目管理</a></li>
        		<li><a href="<%=request.getContextPath()%>/servlet/ProvinceServlet?type=toCityManage">市管理</a></li>
        	</ul>
        </div>
        <jsp:include page="/public/bottom.jsp"></jsp:include>
    </div>

    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/dtree.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/public.js"></script>

</body>
</html> --%>