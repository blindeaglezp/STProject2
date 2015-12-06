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
    <title>项目管理</title>
    <meta name="Keywords" content="">
    <meta name="description" content="">
    <link rel="StyleSheet" href="<%=request.getContextPath() %>/css/dtree.css" type="text/css" />
    <link rel="StyleSheet" href="<%=request.getContextPath() %>/css/p1.css" type="text/css" />
    <link rel="StyleSheet" href="<%=request.getContextPath() %>/css/p2.css" type="text/css" />
</head>
<body>
    <div class="container">
        <jsp:include page="/public/top.jsp"></jsp:include>
        <div class="projectRight">
        	<div class="handle">
        		<button type="button" class="addCityProject">添加项目</button>
            </div>
            <table border="1" class="tab_cityProject">
                <tr>
                    <th rowspan="2"></th>
                    <th rowspan="2">县名</th>
                    <th rowspan="2">项目文号</th>
                    <th colspan="3">科目</th>
                    <th rowspan="2">项目名</th>
                    <th rowspan="2">预算指标</th>
                    <th rowspan="2">支付数</th>
                    <th rowspan="2">支付进度</th>
                    <th rowspan="2">操作</th>
                </tr>
                <tr>
                    <th>类</th>
                    <th>款</th>
                    <th>项</th>
                </tr>
                <c:forEach items="${projects }" var="project" varStatus="s">
	                <tr class="tab_content">
	                    <td>${s.count }</td>
	                    <td>${project.county_name_CPFK }</td>
	                    <td>${project.city_RFC_CPFK }</td>
	                    <td>${subjects[s.count-1].SBJ_Class }</td>
	                    <td>${subjects[s.count-1].SBJ_Regulation }</td>
	                    <td>${subjects[s.count-1].SBJ_Item }</td>
	                    <td>${project.project_Name }</td>
	                    <td>${project.county_Budget }</td>
	                    <td>${project.county_Cost }</td>
	                    <td>${project.county_Percent }%</td>
	                    <td>
	                        <button type="button" value="${project.project_Name }">删除</button> |
	                        <button type="button" value="${project.project_Name }">修改</button>
	                    </td>
	                </tr>
                </c:forEach>
            </table>
        </div>
        <jsp:include page="/public/bottom.jsp"></jsp:include>
    </div>

    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/dtree.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/p3.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/public.js"></script>

</body>
</html>