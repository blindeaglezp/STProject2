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
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>功能展示</title>
    <meta name="Keywords" content="">
    <meta name="description" content="">
    <link rel="StyleSheet" href="<%=request.getContextPath() %>/css/dtree.css" type="text/css" />
    <link rel="StyleSheet" href="<%=request.getContextPath() %>/css/p1.css" type="text/css" />
</head>
<body onload="city_initLeft();">
    <div class="container">
        <jsp:include page="/public/top.jsp"></jsp:include>
        <jsp:include page="/public/left.jsp"></jsp:include>
        <div class="right">
        	<ul class="ul_function">
        		<li><a href="<%=request.getContextPath()%>/servlet/CityServlet?type=toUserManage">用户管理</a></li>
        		<li><a href="<%=request.getContextPath()%>/servlet/CityServlet?type=toCountyManage">县管理</a></li>
        		<li><a href="<%=request.getContextPath()%>/servlet/CityServlet?type=toCountyProjectManage">县级项目查看</a></li>
        		<li><a href="<%=request.getContextPath()%>/servlet/CityServlet?type=toCityProjectManage">市级项目管理</a></li>
        	</ul>
        </div>
        <jsp:include page="/public/bottom.jsp"></jsp:include>
    </div>

    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/dtree.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/public.js"></script>

</body>
</html>