<!-- 
	author:blindeagle
	version:1.0
	date:2015.11.29
 -->
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>市级项目管理</title>
<meta name="Keywords" content="">
<meta name="description" content="">

<link rel="StyleSheet" href="<%=request.getContextPath()%>/css/p1.css"
	type="text/css" />
<link rel="StyleSheet" href="<%=request.getContextPath()%>/css/p2.css"
	type="text/css" />
</head>
<body>

	<jsp:include page="/public/top.jsp"></jsp:include>
	<jsp:include page="/public/cityLeft.jsp"></jsp:include>
	<div class="projectRight">
		<div class="handle">
			<select class="sel_allClass pp_sel"
				onchange="queryRegByClass();">
				<option value="0" selected>选择类</option>
				<c:forEach items="${subjects }" var="subject">
					<option value="${subject.SBJ_Class }">${subject.SBJ_Class }</option>
				</c:forEach>
			</select> 
			<select class="sel_allRegulation pp_sel"
				onchange="queryItemByReg();">
				<option value="0" selected>选择款</option>
			</select> 
			<select class="sel_allItem pp_sel">
				<option value="0" selected>选择项</option>
			</select>
			<input style="float:left;margin:10px 0 0 10px;" type="text" class="cityRfc" placeholder="请输入文号"/>
			<input style="float:left;margin:10px 0 0 10px;" type="text" class="cityName" placeholder="请输入项目"/>
			<button style="float:left;margin:10px 0 0 20px;" type="button" class="queryCityProByCondition">查询</button>
			<button type="button" class="addCityProject">添加项目</button>
		</div>
		<table border="1" class="tab_cityProject">
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
			<c:forEach items="${provinceProjects }" var="project" varStatus="s">
				<tr class="tab_content">
					<td>${s.count }</td>
					<td>${project.province_RFC_PPFK }</td>
					<td>${subjects[s.count-1].SBJ_Class }</td>
					<td>${subjects[s.count-1].SBJ_Regulation }</td>
					<td>${subjects[s.count-1].SBJ_Item }</td>
					<td>${project.project_Name }</td>
					<td>${project.city_Local_Budget }</td>
					<td>${project.city_Local_Cost }</td>
					<td>${project.city_Local_Percent }</td>
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
		<div class="title">
			添加项目<a href="javascript:void(0);" class="close">X</a>
		</div>
		<table class="table" >
			<tr>
				<td id="text">市文号：</td>
				<td><input type="text" class="cityRfc txt"></td>

				<td id="text">类：</td>
				<td><input type="text" class="class txt"></td>
			</tr>
			<tr>
				<td id="text">款：</td>
				<td><input type="text" class="regulation txt"></td>

				<td id="text">项：</td>
				<td><input type="text" class="item txt"></td>
			</tr>
			<tr >
				<td id="text">项目名：</td>
				<td><input type="text" class="projectName txt"></td>
				<td id="text">预算指标：</td>
				<td><input type="text" class="totalBudget txt"></td>
			</tr>
			<tr>
				<td id="text">市级预算：</td>
				<td><input type="text" class="cityLocalBudget txt"></td>
				<td id="text">省文号：</td>
				<td><input type="text" class="provinceRfc txt"></td>
			</tr>
			<tr>
				<td id="text_d" class="add_assign">分配+</td>
			</tr>
			<tr class="item_assign">
					<td id="text">县：</td>
					<td><input type="text" class="county_assign"></td>
					<td id="text">预算指标：</td>
					<td><input type="text" class="other_budget"></td>
			</tr>
			<tr>
				<td colspan=4 style="text-align:center;">
				<input type="button" id="add_CityProject" class="btn_addCityProject btn_submit"  value="提交"/>
				</td>
			</tr>
		</table>
		
		<!-- <div class="content">
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
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
            &nbsp;&nbsp;&nbsp;
            <p>预算指标<input type="text" class="totalBudget txt"/></p>
            <p>市级预算<input type="text" class="cityLocalBudget txt"/></p>
            <p>
            	&nbsp;&nbsp;&nbsp;
            	支付数<input type="text" class="cityLocalCost txt"/>
            </p>
            
            <div class="div_assign">
	            <span class="title_assign">分配</span>
	            <div class="add_assign">+</div><br/>	
	            <br/>
	            <div class="item_assign">
		            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;县<input type="text" class="county_assign"/>
		            预算指标<input type="text" class="other_budget"/>
	            </div>
            </div>
	        <input type="button" class="btn_addCityProject btn_submit" value="提交"/>
        </div>	 -->
	</div>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/dtree.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/p3.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/p4.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/public.js"></script>

</body>
</html>