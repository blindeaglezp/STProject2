<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<div class="sidebar" id="sidebar">
		<script type="text/javascript">
			try {
				ace.settings.check('sidebar', 'fixed')
			} catch (e) {
			}
		</script>

		<ul class="nav nav-list">
			<li><a
				href="<%=request.getContextPath()%>/servlet/ProvinceServlet?type=toIndex">
					<img
					src="<%=request.getContextPath()%>/assets/css/images/iconfont-home.png"
					width="18" height="15" /> <span class="menu-text"> 首页 </span>
			</a></li>

			<li><a
				href="<%=request.getContextPath()%>/servlet/ProvinceServlet?type=toUserManage">
					<img
					src="<%=request.getContextPath()%>/assets/css/images/iconfont-gerenzhongxin.png"
					width="18" height="15" /> <span class="menu-text"> 用户管理 </span>
			</a></li>

			<li><a
				href="<%=request.getContextPath()%>/servlet/ProvinceServlet?type=toCityManage"
				class="dropdown-toggle"> <img
					src="<%=request.getContextPath()%>/assets/css/images/iconfont-category.png"
					width="20" height="15" /> <span class="menu-text"> 市区管理 </span>
			</a></li>

			<li><a
				href="<%=request.getContextPath()%>/servlet/ProvinceServlet?type=toSubjectManage"
				class="dropdown-toggle"> <img
					src="<%=request.getContextPath()%>/assets/css/images/iconfont-category.png"
					width="20" height="15" /> <span class="menu-text"> 科目管理 </span>
			</a></li>

			<li><a
				href="<%=request.getContextPath()%>/servlet/ProvinceServlet?type=toProjectManage"
				class="dropdown-toggle"> <img
					src="<%=request.getContextPath()%>/assets/css/images/iconfont-table.png"
					width="20" height="15" /> <span class="menu-text"> 项目管理 </span>
			</a></li>
		</ul>
		<!-- /.nav-list -->
	</div>


	<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/typeahead-bs2.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.slimscroll.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.easy-pie-chart.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.sparkline.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/flot/jquery.flot.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/flot/jquery.flot.pie.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/flot/jquery.flot.resize.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace-elements.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/ace.min.js"></script>

</body>
</html>