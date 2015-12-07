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
    <title>市管理</title>
    <meta name="Keywords" content="">
    <meta name="description" content="">
    <link rel="StyleSheet" href="<%=request.getContextPath() %>/css/dtree.css" type="text/css" />
    <link rel="StyleSheet" href="<%=request.getContextPath() %>/css/p1.css" type="text/css" />
</head>
<body onload="province_initLeft();">
        	<jsp:include page="/public/top.jsp"></jsp:include>
        	<jsp:include page="/public/provinceLeft.jsp"></jsp:include>
        <div class="right">
            <div class="handle">
                <button type="button" class="addCity">添加市</button>
            </div>
            <table border="1" class="tab_city">
                <tr>
                    <th></th>
                    <th>市名</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${citys }" var="city" varStatus="s">
	                <tr class="tab_content">
	                    <td>${s.count }</td>
	                    <td class="td_cityName">${city.cityName }</td>
	                    <td>
	                        <button type="button" value="${city.cityID }" class="btn_deleteCity">删除</button> |
	                        <button type="button" value="${city.cityID }" class="updateCity">修改</button>
	                    </td>
	                </tr>
                </c:forEach>
            </table>
        </div>
        
    <div id="gray"></div>
    <div id="addCity" class="pop">
        <div class="title">添加市<a href="javascript:void(0);" class="close">X</a></div>
        <div class="content">
            <div class="empty_f"></div>
            <p class="test"></p>
            <p>省名<input type="text" class="provinceName txt" value="山西省" disabled/></p>
            <p>市名<input type="text" class="cityName txt"/></p>
            <input type="button" class="btn_addCity btn_submit" value="提交"/>
        </div>
    </div>
    <div id="updateCity" class="pop">
        <div class="title">修改市<a href="javascript:void(0);" class="close">X</a></div>
        <div class="content">
            <div class="empty_f"></div>
            <p class="test"></p>
            <p>省名<input type="text" class="provinceName txt" value="山西省" disabled/></p>
            <input type="hidden" class="cityId"/>
            <p>市名<input type="text" class="cityName txt"/></p>
            <input type="button" class="btn_updateCity btn_submit" value="提交"/>
        </div>
    </div>

    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/dtree.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/p1.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/public.js"></script>

</body>
</html>