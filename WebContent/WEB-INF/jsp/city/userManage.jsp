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
<body onload="city_initLeft();">
   
        <jsp:include page="/public/top.jsp"></jsp:include>
         <div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<ul class="nav nav-list">
						<li>
							<a href="<%=request.getContextPath()%>/servlet/CityServlet?type=toIndex">
								<img src="<%=request.getContextPath()%>/assets/css/images/iconfont-home.png"  width="18" height="15"/>
								<span class="menu-text"> 首页 </span>
							</a>
						</li>

						<li>
							<a href="<%=request.getContextPath()%>/servlet/CityServlet?type=toUserManage">
								<img src="<%=request.getContextPath()%>/assets/css/images/iconfont-gerenzhongxin.png"  width="18" height="15"/>
								<span class="menu-text"> 用户管理 </span>
							</a>
						</li>

						<li>
							<a href="<%=request.getContextPath()%>/servlet/CityServlet?type=toCountyManage">
								<img src="<%=request.getContextPath()%>/assets/css/images/iconfont-category.png"  width="18" height="15"/>
								<span class="menu-text"> 县管理  </span>
							</a>
						</li>

						<li>
							<a href="<%=request.getContextPath()%>/servlet/CityServlet?type=toCityProjectManage" >
								<img src="<%=request.getContextPath()%>/assets/css/images/iconfont-category.png"  width="18" height="15"/>
								<span class="menu-text"> 市级项目管理 </span>
							</a>
						</li>

						<li>
							<a href="<%=request.getContextPath()%>/servlet/CityServlet?type=toCountyProjectManage">
								<img src="<%=request.getContextPath()%>/assets/css/images/iconfont-table.png"  width="18" height="15"/>
								<span class="menu-text"> 县级项目查看 </span>
							</a>
						</li>
					</ul><!-- /.nav-list -->
				</div>
		<script src="<%=request.getContextPath() %>/assets/js/bootstrap.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/typeahead-bs2.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/jquery.slimscroll.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/jquery.easy-pie-chart.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/jquery.sparkline.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/flot/jquery.flot.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/flot/jquery.flot.pie.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/flot/jquery.flot.resize.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/ace-elements.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/ace.min.js"></script>
        
        <div class="right">
            <div class="handle">
            	<select class="sel_county" onchange="city_selCountyQueryUser();">
            		<option disabled selected>选择县</option>
            		<c:forEach items="${countys }" var="county">
            			<option value="${county.county_Name }">${county.county_Name }</option>
            		</c:forEach>
            	</select>
                <button type="button" class="addUser btn_addCountyUser">添加用户</button>
            </div>
            <table border="1" class="tab_user">
                <tr>
                    <th></th>
                    <th>县</th>
                    <th>用户名</th>
                    <th>用户级别</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${users }" var="user" varStatus="s">
	                <tr class="tab_content">
	                    <td>${s.count }</td>
	                    <td>${user.user_County_Name }</td>
	                    <td class="td_userName">${user.user_Name }</td>
	                    <td>${user.user_Level }</td>
	                    <td>
	                        <button type="button" class="btn_deleteCountyUser" value="${user.user_Name }">删除</button> |
	                        <button type="button" class="btn_updateCountyUser" value="${user.user_Name }">修改</button>
	                    </td>
	                </tr>
                </c:forEach>
            </table>
        </div>


    <div id="gray"></div>
    <div id="addCountyUser" class="pop">
        <div class="title">添加用户<a href="javascript:void(0);" class="close">X</a></div>
        <div class="content">
            <div class="empty_f"></div>
            <p class="test"></p>
            <select class="sel_county txt">
            	<option disabled selected>选择县</option>
            </select>
            <p>用户<input type="text" class="userName txt"/></p>
            <p>密码<input type="password" class="password txt"/></p>
            <input type="button" class="btn_addCountyUser btn_submit" value="提交"/>
        </div>
    </div>
    
    <div id="updateCountyUser" class="pop">
        <div class="title">修改用户<a href="javascript:void(0);" class="close">X</a></div>
        <div class="content">
            <div class="empty_f"></div>
            <p class="test"></p>
            <p>县名<input type="text" class="countyName txt" disabled/></p>
            <input type="hidden" class="userId"/>
            <p>用户<input type="text" class="userName txt"/></p>
            <input type="button" class="btn_updateUser btn_submit" value="提交"/>
        </div>
    </div>

    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/dtree.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/p2.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/public.js"></script>

</body>
</html>