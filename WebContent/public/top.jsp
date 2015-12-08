<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>功能展示</title>
    <meta name="Keywords" content="">
    <meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
		<link href="<%=request.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->

		<!-- fonts -->

		<link rel="stylesheet" href="<%=request.getContextPath() %>//http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

		<!-- ace styles -->

		<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/ace.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="<%=request.getContextPath() %>/assets/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="<%=request.getContextPath() %>/assets/js/html5shiv.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body>
			<div class="navbar navbar-default" id="navbar">
				<script type="text/javascript">
					try{ace.settings.check('navbar' , 'fixed')}catch(e){}
				</script>

				<div class="navbar-container" id="navbar-container">
					<div class="navbar-header pull-left">
						<a href="#" class="navbar-brand">
							<small>
								山西省财政厅
							</small>
						</a><!-- /.brand -->
					</div><!-- /.navbar-header -->

					<div class="navbar-header pull-right" role="navigation">
						<ul class="nav ace-nav">
							<li class="light-blue">
								<a data-toggle="dropdown" href="<%=request.getContextPath() %>/servlet/LoginServlet?type=quit" class="dropdown-toggle">
									<img class="nav-user-photo" src="<%=request.getContextPath() %>/assets/avatars/user.jpg" alt="Jason's Photo" />
									<small >退出</small>
								</a>
							</li>
						</ul><!-- /.ace-nav -->
					</div><!-- /.navbar-header -->
				</div><!-- /.container -->
			</div>

		<!-- basic scripts -->
		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=request.getContextPath() %>/assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='<%=request.getContextPath() %>/assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
<![endif]-->
		<script src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js" type="text/javascript"></script>
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



