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
<body onload="javascript:projectTotal();">
        <jsp:include page="/public/top.jsp"></jsp:include>
        <jsp:include page="/public/provinceLeft.jsp"></jsp:include>
        <div class="right">
        <div class="projectRight">
        	<select class="sel_allCity pp_sel" onChange="queryCountyByCity();">
        		<option value="0" selected>选择市</option>
        		<c:forEach items="${citys }" var="city">
        			<option class="content" value="${city.cityName }">${city.cityName }</option>
        		</c:forEach>
        	</select>
        	<select class="sel_allCounty pp_sel" onChange="queryProjectByCondition();">
        		<option value="0" selected>选择县</option>
        	</select>
        	<select class="sel_allClass pp_sel" onchange="queryRegByClass();">
           		<option value="0" selected>选择类</option>
           		<c:forEach items="${subClasses }" var="subject">
           			<option value="${subject }">${subject }</option>
           		</c:forEach>
           	</select>
           	<select class="sel_allRegulation pp_sel" onchange="queryItemByReg();">
           		<option value="0" selected>选择款</option>
           	</select>
           	<select class="sel_allItem pp_sel" onchange="queryProjectByCondition();">
           		<option value="0" selected>选择项</option>
           	</select>
           	<input placeholder="文号" style="margin-top:10px;" class="provinceRfc" type="text"/>
        	<input placeholder="项目名" style="margin:10px 0 0 10px;" class="projectName" type="text"/>
               <div class="handle">
            	<button type="button" class="queryProjectByCondition" >查询</button>
                <button type="button" class="addProvinceProject" >添加项目</button>
           </div>
            <table border="1" class="tab_provinceProject">
                <tr>
                    <th rowspan="2"></th>
                    <th rowspan="2">市名</th>
                    <th rowspan="2">县名</th>
                    <th rowspan="2">项目文号</th>
                    <th rowspan="1" colspan="3">科目</th>
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
	                    <td>${proCitys[s.count-1] }</td>
	                    <td>${project.county_name_CPFK }</td>
	                    <td>${project.city_RFC_CPFK }</td>
	                    <td>${subjects[s.count-1].SBJ_Class }</td>
	                    <td>${subjects[s.count-1].SBJ_Regulation }</td>
	                    <td>${subjects[s.count-1].SBJ_Item }</td>
	                    <td>${project.project_Name }</td>
	                    <td class="countyBudget">${project.county_Budget }</td>
	                    <td class="countyCost">${project.county_Cost }</td>
	                    <td>${project.county_Percent }</td>
	                    <td>
	                        <button type="button">删除</button> |
	                        <button type="button">修改</button>
	                    </td>
	                </tr>
                </c:forEach>
                <c:forEach items="${provinceProjects }" var="project" varStatus="s">
	                <tr class="tab_content">
	                    <td>${s.count }</td>
	                    <td>${proCitys[s.count-1] }</td>
	                    <td></td>
	                    <td>${project.province_RFC_PPFK }</td>
	                    <td>${proSubjects[s.count-1].SBJ_Class }</td>
	                    <td>${proSubjects[s.count-1].SBJ_Regulation }</td>
	                    <td>${proSubjects[s.count-1].SBJ_Item }</td>
	                    <td>${project.project_Name }</td>
	                    <td class="countyBudget">${project.city_Local_Budget }</td>
	                    <td class="countyCost">${project.city_Local_Cost }</td>
	                    <td>${project.city_Local_Percent }</td>
	                    <td>
	                        <button type="button">删除</button> |
	                        <button type="button">修改</button>
	                    </td>
	                </tr>
                </c:forEach>
                <tr class="tab_count">
                	<td>合计</td>
                	<td></td><td></td><td></td><td></td><td></td><td></td><td></td>
                	<td class="budgetTotal"></td>
                	<td class="costTotal"></td>
                	<td class="percentTotal"></td>
                </tr>
            </table>
        </div>

    
    <div id="gray" class="addProvinceProjectGray"></div>
    <div id="addProvinceProject" class="pop2">
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
            <p>
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	合计<input type="text" class="totalBudget txt"/>
            </p>
            <p>
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	中央<input type="text" class="centreBudget txt"/>
            </p>
            <p>
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	省级<input type="text" class="provinceBudget txt"/>
            </p>
            <p>省级预算<input type="text" class="cityLocalBudget txt"/></p>
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
		            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;市<input type="text" class="city_assign"/>
		            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;县<input type="text" class="county_assign"/>
		            <br/>
		            预算指标<input type="text" class="other_budget"/>
            		&nbsp;&nbsp;&nbsp;支付数<input type="text" class="other_cost"/>
            		<br/>
            		支付进度<input type="text" class="other_percent txt"/>
	            </div>
            </div>
	        <input type="button" class="btn_addProvinceProject btn_submit" value="提交"/>
        </div>
    </div>
	</div>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/dtree.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/p4.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/public.js"></script>

</body>
</html>