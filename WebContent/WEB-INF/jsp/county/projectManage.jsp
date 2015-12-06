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
                <button type="button" class="addCountyProject">添加项目</button>
            </div>
            <table border="1" class="tab_countyProject">
                <tr>
                    <th rowspan="2"></th>
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
                <c:forEach items="${cityProjects }" var="project" varStatus="s">
	                <tr class="tab_content">
	                    <td>${s.count }</td>
	                    <td>${project.city_RFC_CPFK }</td>
	                    <td>${subjects[s.count-1].SBJ_Class }</td>
	                    <td>${subjects[s.count-1].SBJ_Regulation }</td>
	                    <td>${subjects[s.count-1].SBJ_Item }</td>
	                    <td>${project.project_Name }</td>
	                    <td>${project.county_Budget }</td>
	                    <td>${project.county_Cost }</td>
	                    <td>${project.county_Percent }</td>
	                    <td>
	                        <button type="button">删除</button> |
	                        <button type="button">修改</button>
	                    </td>
	                </tr>
                </c:forEach>
            </table>
            <div class="pageNum">
        		<button type="button" class="pageBtn">第一页</button>
        		<button type="button" class="pageBtn">最后一页</button>
        		<button type="button" class="pageBtn">上一页</button>
        		<button type="button" class="pageBtn">下一页</button>
        	</div>
        </div>
        <jsp:include page="/public/bottom.jsp"></jsp:include>
    </div>

    <div id="gray"></div>
    <div id="addCountyProject" class="pop">
        <div class="title">添加项目<a href="javascript:void(0);" class="close">X</a></div>
        <div class="content">
            <div class="empty_f"></div>
            <p>
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	文号<input type="text" class="cityRfc txt"/>
            </p>
            <p>
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	类<input type="text" class="class txt"/>
            </p>
            <p>
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	款<input type="text" class="regulation txt"/>
            </p>
            <p>
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	项<input type="text" class="item txt"/>
            </p>
            <p>
            	&nbsp;&nbsp;&nbsp;
            	项目名<input type="text" class="projectName txt"/>
            </p>
            <p>预算指标<input type="text" class="countyBudget txt"/></p>
            <p>
            	&nbsp;&nbsp;&nbsp;
            	支付数<input type="text" class="countyCost txt"/>
            </p>
            <input type="button" class="btn_addCountyProject btn_submit" value="提交"/>
        </div>
    </div>
    
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/dtree.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/p3.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/public.js"></script>

</body>
</html>