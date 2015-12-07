<!-- 
	author:blindeagle
	version:1.0
	date:2015.11.29
 -->
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <head>
		<meta charset="utf-8" />
		<title>功能展示</title>
	<meta name="Keywords" content="">
    <meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="<%=request.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/font-awesome.min.css" />
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
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
</head>
<body onload="city_initLeft();">
		<jsp:include page="/public/top.jsp"></jsp:include>
        <div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<ul class="nav nav-list">
						<li>
							<a href="<%=request.getContextPath()%>/servlet/CityServlet?type=toIndex">
								<img src="<%=request.getContextPath()%>/assets/css/images/iconfont-home.png"  width="18" height="15"/>
								<span class="menu-text"> 首页 </span>
							</a>
						</li>

						<li>
							<a href="<%=request.getContextPath()%>/servlet/CityServlet?type=toUserManage">
								<img src="<%=request.getContextPath()%>/assets/css/images/iconfont-gerenzhongxin.png"  width="18" height="15"/>
								<span class="menu-text"> 用户管理 </span>
							</a>
						</li>

						<li>
							<a href="<%=request.getContextPath()%>/servlet/CityServlet?type=toCountyManage">
								<img src="<%=request.getContextPath()%>/assets/css/images/iconfont-category.png"  width="18" height="15"/>
								<span class="menu-text"> 县管理  </span>
							</a>
						</li>

						<li>
							<a href="<%=request.getContextPath()%>/servlet/CityServlet?type=toCityProjectManage" >
								<img src="<%=request.getContextPath()%>/assets/css/images/iconfont-category.png"  width="18" height="15"/>
								<span class="menu-text"> 市级项目管理 </span>
							</a>
						</li>

						<li>
							<a href="<%=request.getContextPath()%>/servlet/CityServlet?type=toCountyProjectManage">
								<img src="<%=request.getContextPath()%>/assets/css/images/iconfont-table.png"  width="18" height="15"/>
								<span class="menu-text"> 县级项目查看 </span>
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