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
    <title>用户管理</title>
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
            <div class="handle">
            	<select class="sel_city" onchange="selCityQueryUserAndCounty();">
            		<option disabled selected>选择市</option>
            		<c:forEach items="${citys }" var="city">
            			<option value="${city.cityName }">${city.cityName }</option>
            		</c:forEach>
            	</select>
            	<select class="sel_county" onchange="selCountyQueryUser();">
            		<option disabled selected>选择县</option>
            	</select>
                <button type="button" class="addUser">添加用户</button>
            </div>
            <table border="1" class="tab_user">
                <tr>
                    <th></th>
                    <th>市</th>
                    <th>县</th>
                    <th>用户名</th>
                    <th>用户级别</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${users }" var="user" varStatus="s">
	                <tr class="tab_content">
	                    <td>${s.count }</td>
	                    <td>${user.user_City_Name }</td>
	                    <td>${user.user_County_Name }</td>
	                    <td class="td_userName">${user.user_Name }</td>
	                    <td>${user.user_Level }</td>
	                    <td>
	                        <button type="button" value="${user.user_Name }" class="btn_deleteCityUser">删除</button> |
	                        <button type="button" value="${user.user_Name }" class="btn_updateCityUser">修改</button>
	                    </td>
	                </tr>
                </c:forEach>
            </table>
        </div>
        <jsp:include page="/public/bottom.jsp"></jsp:include>
    </div>

    <div id="gray"></div>
    <div id="addUser" class="pop">
        <div class="title">添加用户<a href="javascript:void(0);" class="close">X</a></div>
        <div class="content">
            <div class="empty_f"></div>
            <p class="test"></p>
            <select class="sel_city">
            	<option disabled selected>选择市</option>
            </select>
            <input type="hidden" class="cityId"/>
            <p>用户<input type="text" class="userName txt"/></p>
            <p>密码<input type="password" class="password txt"/></p>
            <input type="button" class="btn_addUser btn_submit" value="提交"/>
        </div>
    </div>
    
    <div id="updateUser" class="pop">
        <div class="title">修改用户<a href="javascript:void(0);" class="close">X</a></div>
        <div class="content">
            <div class="empty_f"></div>
            <p class="test"></p>
            <p>市名<input type="text" class="cityName txt" disabled/></p>
            <p>县名<input type="text" class="countyName txt" disabled/></p>
            <input type="hidden" class="userId"/>
            <p>用户<input type="text" class="userName txt"/></p>
            <input type="button" class="btn_updateUser btn_submit" value="提交"/>
        </div>
    </div>

    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/dtree.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/p1.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/public.js"></script>

</body>
</html>