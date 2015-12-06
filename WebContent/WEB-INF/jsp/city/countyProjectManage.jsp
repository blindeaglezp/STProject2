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
<body onload="javascript:county_projectTotal();">
    <div class="container">
        <jsp:include page="/public/top.jsp"></jsp:include>
        <div class="projectRight">
        	<div class="handle">
        		<select class="sel_allCounty pp_sel" onChange="queryProjectByCondition();">
	        		<option disabled selected>选择县</option>
	        		<c:forEach items="${citys }" var="city">
	        			<option value="${city.cityName }">${city.cityName }</option>
	        		</c:forEach>
	        	</select>
	        	<select class="sel_allPPFK pp_sel" onChange="queryProjectByCondition();">
	        		<option disabled selected>选择文号</option>
	        		<c:forEach items="${provinceRfcs }" var="rfc">
	        			<option value="${rfc.province_RFC }">${rfc.province_RFC }</option>
	        		</c:forEach>
	        	</select>
	        	<select class="sel_allProName pp_sel" onChange="queryProjectByCondition();">
	        		<option disabled selected>选择项目</option>
	        		<c:forEach items="${provinceRfcs }" var="rfc">
	        			<option value="${rfc.province_Id }">${rfc.province_RFC }</option>
	        		</c:forEach>
	        	</select>
	        	<select class="sel_allClass pp_sel" onchange="queryProjectByCondition();">
	           		<option disabled selected>选择类</option>
	           		<c:forEach items="${subjects }" var="subject">
	           			<option value="${subject.SBJ_Class }">${subject.SBJ_Class }</option>
	           		</c:forEach>
	           	</select>
	           	<select class="sel_allRegulation pp_sel" onchange="queryProjectByCondition();">
	           		<option disabled selected>选择款</option>
	           		<c:forEach items="${subjects }" var="subject">
	           			<option value="${subject.SBJ_Regulation }">${subject.SBJ_Regulation }
	           		</c:forEach>
	           	</select>
	           	<select class="sel_allItem pp_sel" onchange="queryProjectByCondition();">
	           		<option disabled selected>选择项</option>
	           		<c:forEach items="${subjects }" var="subject">
	           			<option value="${subject.SBJ_Item }">${subject.SBJ_Item }</option>
	           		</c:forEach>
	           	</select>
            </div>
            <table border="1" class="tab_cityProject">
                <tr>
                    <th rowspan="2"></th>
                    <th rowspan="2">县名</th>
                    <th rowspan="2">省文号</th>
                    <th colspan="3">科目</th>
                    <th rowspan="2">项目名</th>
                    <th rowspan="2">预算指标</th>
                    <th rowspan="2">支付数</th>
                    <th rowspan="2">支付进度</th>
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
	                    <td class="countyBudget">${project.county_Budget }</td>
	                    <td class="countyCost">${project.county_Cost }</td>
	                    <td>${project.county_Percent }%</td>
	                </tr>
                </c:forEach>
                <tr class="tab_count">
                	<td>合计</td>
                	<td></td><td></td><td></td><td></td><td></td><td></td>
                	<td class="budgetTotal"></td>
                	<td class="costTotal"></td>
                	<td class="percentTotal"></td>
                </tr>
            </table>
        </div>
        <jsp:include page="/public/bottom.jsp"></jsp:include>
    </div>

    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/dtree.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/p3.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/p4.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/public.js"></script>

</body>
</html>