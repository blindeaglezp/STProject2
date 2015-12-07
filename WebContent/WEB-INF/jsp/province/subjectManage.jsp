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
<title>科目管理</title>
<meta name="Keywords" content="">
<meta name="description" content="">
<link rel="StyleSheet"
	href="<%=request.getContextPath()%>/css/dtree.css" type="text/css" />
<link rel="StyleSheet" href="<%=request.getContextPath()%>/css/p1.css"
	type="text/css" />
</head>
<body onload="province_initLeft();">

	<jsp:include page="/public/top.jsp"></jsp:include>
	<jsp:include page="/public/provinceLeft.jsp"></jsp:include>
	<div class="right">
		<div class="handle">
			<select class="sel_class" onchange="selClassQuerySubAndReg();">
				<option disabled selected>选择类</option>
				<c:forEach items="${classes }" var="subClass">
					<option value="${subClass }">${subClass }</option>
				</c:forEach>
			</select> <select class="sel_regulation" onchange="selRegQuerySubAndItem();">
				<option disabled selected>选择款</option>
			</select> <select class="sel_item" onchange="selItemQuerySubject();">
				<option disabled selected>选择项</option>
			</select>
			<button type="button" class="addSubject">添加科目</button>
		</div>
		<table border="1" class="tab_subject">
			<tr>
				<th></th>
				<th>类</th>
				<th>款</th>
				<th>项</th>
				<th>科目名</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${subjects }" var="subject" varStatus="s">
				<tr class="tab_content">
					<td>${s.count }</td>
					<td>${subject.SBJ_Class }</td>
					<td>${subject.SBJ_Regulation }</td>
					<td>${subject.SBJ_Item }</td>
					<td class="td_userName">${subject.SBJ_Name }</td>
					<td>
						<button type="button" class="btn_deleteSubject"
							value="${subject.SBJ_ID }">删除</button> |
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="gray"></div>
	<div id="addSubject" class="pop">
		<div class="title">
			添加科目<a href="javascript:void(0);" class="close">X</a>
		</div>
		<div class="content">
			<div class="empty_f"></div>
			<p class="test"></p>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;类<input type="text" class="subClass txt" />
			</p>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;款<input type="text"
					class="subRegulation txt" />
			</p>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;项<input type="text" class="subItem txt" />
			</p>
			<p>
				科目<input type="text" class="subName txt" />
			</p>
			<input type="button" class="btn_addSubject btn_submit" value="提交" />
		</div>
	</div>

	<div id="updateSubject" class="pop">
		<div class="title">
			修改科目<a href="javascript:void(0);" class="close">X</a>
		</div>
		<div class="content">
			<div class="empty_f"></div>
			<p class="test"></p>
			<p>
				类<input type="text" class="class txt" disabled />
			</p>
			<p>
				款<input type="text" class="regulation txt" disabled />
			</p>
			<p>
				项<input type="text" class="item txt" disabled />
			</p>
			<input type="hidden" class="itemId" />
			<p>
				科目<input type="text" class="subjectName txt" />
			</p>
			<input type="button" class="btn_updateSubject btn_submit" value="提交" />
		</div>
	</div>



	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/dtree.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/p2.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/public.js"></script>

</body>
</html>