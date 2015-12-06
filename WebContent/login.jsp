<!-- 
	author:blindeagle
	version:1.0
	date:2015.11.29
 -->
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>登录</title>
    <meta name="Keywords" content="">
    <meta name="description" content="">
    <style type="text/css">
        *{margin:0;padding:0;}
        a{text-decoration:none;color:#111;}
        li{list-style:none;}
        body{background:#FFF;font-size:14px;font-family:"微软雅黑";color:#666;}
        .container{width:1080px;margin:0 auto;}
        .login{width:275px;height:125px;border:1px solid #666;padding:15px;}
        .login table tr{height:25px;}
        .login table tr td.title{text-align:right;font-size:16px;}
        .login table tr td input{width:200px;height:25px;margin:5px 0;}
        .login table tr td button{width:269px;height:30px;border:none;background:blue;color:#FFF;
        	margin:5px 0;border-radius:3px;font-size:16px;}
    </style>
</head>
<body onload="setLoginDivCenter();">
    <div class="container">
    	<div class="login">
    		<form action="<%=request.getContextPath() %>/servlet/LoginServlet?type=checkUser" method="post">
	    		<table>
	    			<tr>
	    				<td class="title">用户名：</td>
	    				<td><input type="text" name="userName"/></td>
	    			</tr>
	    			<tr>
	    				<td class="title">密码：</td>
	    				<td><input type="password" name="password"/></td>
	    			</tr>
	    			<tr>
	    				<td colspan="2">
	    					<button type="submit" class="toLogin">登 录</button>
	    				</td>
	    			</tr>
	    		</table>
    		</form>
    	</div>
    </div>
    
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/blindeagle.js"></script>
    <script type="text/javascript">
    	function setLoginDivCenter() {
    		be_setDivCenter($(".login"));
    	}
    </script>
    
</body>
</html>