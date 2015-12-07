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
    <title>市级项目管理</title>
    <meta name="Keywords" content="">
    <meta name="description" content="">
    <link rel="StyleSheet" href="<%=request.getContextPath() %>/css/dtree.css" type="text/css" />
    <link rel="StyleSheet" href="<%=request.getContextPath() %>/css/p1.css" type="text/css" />
    <link rel="StyleSheet" href="<%=request.getContextPath() %>/css/p2.css" type="text/css" />
</head>
<body>
   
        <jsp:include page="/public/top.jsp"></jsp:include>
        <jsp:include page="/public/cityLeft.jsp"></jsp:include>
        <div class="projectRight">
            <div class="handle">
            	<select class="sel_allPPFK pp_sel" onChange="queryProjectByProvinceRFC();">
	        		<option disabled selected>选择文号</option>
	        		<c:forEach items="${provinceRfcs }" var="rfc">
	        			<option value="${rfc.province_RFC }">${rfc.province_RFC }</option>
	        		</c:forEach>
	        	</select>
	        	<select class="sel_allClass pp_sel" onchange="queryProjectBySubClass();">
	           		<option disabled selected>选择类</option>
	           		<c:forEach items="${subjects }" var="subject">
	           			<option value="${subject.SBJ_Class }">${subject.SBJ_Class }</option>
	           		</c:forEach>
	           	</select>
	           	<select class="sel_allRegulation pp_sel" onchange="selRegQuerySubAndItem();">
	           		<option disabled selected>选择款</option>
	           		<c:forEach items="${subjects }" var="subject">
	           			<option value="${subject.SBJ_Regulation }">${subject.SBJ_Regulation }
	           		</c:forEach>
	           	</select>
	           	<select class="sel_allItem pp_sel" onchange="selItemQuerySubject();">
	           		<option disabled selected>选择项</option>
	           		<c:forEach items="${subjects }" var="subject">
	           			<option value="${subject.SBJ_Item }">${subject.SBJ_Item }</option>
	           		</c:forEach>
	           	</select>
                <button type="button" class="addCityProject">添加项目</button>
            </div>
            <table border="1" class="tab_cityProject">
                <tr>
                    <th rowspan="3"></th>
                    <th rowspan="3">项目文号</th>
                    <th rowspan="2" colspan="3">科目</th>
                    <th rowspan="3">项目名</th>
                    <th rowspan="2" colspan="3">预算指标</th>
                    <th colspan="6">支付情况</th>
                    <th rowspan="3">支付进度</th>
                    <th rowspan="3">操作</th>
                </tr>
                <tr>
                    <th colspan="3">支付文号</th>
                    <th colspan="3">下发文号</th>
                </tr>
                <tr>
                    <th>类</th>
                    <th>款</th>
                    <th>项</th>
                    <th>合计</th>
                    <th>中央</th>
                    <th>省级</th>
                    <th>预算指标</th>
                    <th>支付数</th>
                    <th>支付进度</th>
                    <th>预算指标</th>
                    <th>支付数</th>
                    <th>支付进度</th>
                </tr>
                <c:forEach items="${projects }" var="project" varStatus="s">
	                <tr class="tab_content">
	                    <td>${s.count }</td>
	                    <td>${project.province_RFC_PPFK }</td>
	                    <td>${subjects[s.count-1].SBJ_Class }</td>
	                    <td>${subjects[s.count-1].SBJ_Regulation }</td>
	                    <td>${subjects[s.count-1].SBJ_Item }</td>
	                    <td>${project.project_Name }</td>
	                    <td>${project.total_Budget }</td>
	                    <td>${project.centre_Budget }</td>
	                    <td>${project.province_Budget }</td>
	                    <td>${project.city_Local_Budget }</td>
	                    <td>${project.city_Local_Cost }</td>
	                    <td>${project.city_Local_Percent }</td>
	                    <td>${project.county_Budget }</td>
	                    <td>${project.county_Cost }</td>
	                    <td>${project.county_Percent }%</td>
	                    <td></td>
	                    <td>
	                        <button type="button">删除</button> |
	                        <button type="button">修改</button>
	                    </td>
	                </tr>
                </c:forEach>
            </table>
        </div>

    
    <div id="gray" class="addProvinceProjectGray"></div>
    <div id="addCityProject" class="pop2">
        <div class="title">添加项目<a href="javascript:void(0);" class="close">X</a></div>
        <div class="content">
            <div class="empty_f"></div>
            <p>
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	文号<input type="text" class="cityRfc txt"/>
            </p>
            <p>
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	类<input type="text" class="class txt"/>
            </p>
            <p>
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	款<input type="text" class="regulation txt"/>
            </p>
            <p>
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	项<input type="text" class="item txt"/>
            </p>
            <p>
            	&nbsp;&nbsp;&nbsp;
            	项目名<input type="text" class="projectName txt"/>
            </p>
            <p>预算指标<input type="text" class="totalBudget txt"/></p>
            <p>市级预算<input type="text" class="cityLocalBudget txt"/></p>
            <p>
            	&nbsp;&nbsp;&nbsp;
            	支付数<input type="text" class="cityLocalCost txt"/>
            </p>
            <p>支付进度<input type="text" class="cityLocalPercent txt"/></p>
            <div class="div_assign">
	            <span class="title_assign">分配</span>
	            <div class="add_assign">+</div><br/>	
	            <br/>
	            <div class="item_assign">
		            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;县<input type="text" class="county_assign"/>
		            <br/>
		            预算指标<input type="text" class="other_budget"/>
            		&nbsp;&nbsp;&nbsp;支付数<input type="text" class="other_cost"/>
            		<br/>
            		支付进度<input type="text" class="other_percent txt"/>
	            </div>
            </div>
	        <input type="button" class="btn_addCityProject btn_submit" value="提交"/>
        </div>
    </div>

    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/dtree.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/p3.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/p4.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/public.js"></script>

</body>
</html>