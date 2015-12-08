/*
 * author:blindeagle
 * version:1.0
 * date:2015.11.29
 */

//点击添加按钮显示市功能
$(".right .handle .addCity").click(function() {
    $("#gray").show();
    $("#addCity").show();
    setCenter();
});

//点击关闭按钮 关闭功能
$("a.close").click(function() {
    $("#gray").hide();
    $(".pop").hide();
});

//当动态改变浏览器窗口时，也要水平居中
$(window).resize(function() {
    setCenter();
});
function setCenter() {
    var _top = ($(window).height() - $(".pop").height()) / 2;
    var _left = ($(window).width() - $(".pop").width()) / 2;
    $(".pop").css({top:_top,left:_left});
}

//拖动效果
$(document).ready(function() {
    $(".pop").draggable();
});

// 添加市
$(".btn_addCity").click(function() {
	var cityName = $(".cityName").val();
	var data = {"cityName":cityName};
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/ProvinceServlet?type=addCity",
		dataType:"json",
		data:data,
		success:function(data){
			$("#gray").hide();
		    $("#addCity").hide();
		    $(".cityName").val("");
		    var $tab_city = $(".right table.tab_city");
		    $tab_city.find("tr.tab_content").remove();
		    var i = 1;
		    $(data).each(function() {
		    	$tab_city.append("<tr class='tab_content'><td>"+i+"</td>" +
	                    "<td class='td_cityName'>"+this.cityName+"</td><td>" +
	                    "<button type='button' value='"+this.cityID+"' class='btn_deleteCity'>删除</button> |" +
	                    "<button type='button' value='"+this.cityID+"' class='btn_updateCity'>修改</button></td></tr>");
		    });
		}
	});
});

// 删除市
$(".btn_deleteCity").click(function() {
	var $tr_city = $(this).parents("tr");
	var cityId = $(this).val();
	var cityName = $tr_city.find(".td_cityName").html();
	var r=confirm("确认删除" + cityName + "?")
	if (r) {
		var data = {"cityId":cityId};
		$.ajax({
			type:"post",
			url:"/STProject2/servlet/ProvinceServlet?type=deleteCity",
			dataType:"json",
			data:data,
			success:function(data){
				var $tab_city = $(".right table.tab_city");
			    $tab_city.find("tr.tab_content").remove();
			    var i = 1;
			    $(data).each(function() {
			    	$tab_city.append("<tr class='tab_content'><td>"+i+"</td>" +
		                    "<td class='td_cityName'>"+this.cityName+"</td><td>" +
		                    "<button type='button' value='"+this.cityID+"' class='btn_deleteCity'>删除</button> | " +
		                    "<button type='button' value='"+this.cityID+"' class='btn_updateCity'>修改</button></td></tr>");
			    });
			}
		});
	}
});

//点击编辑按钮显示功能
$(".right table .updateCity").click(function() {
    $("#gray").show();
    $("#updateCity").show();
    $("#updateCity .content .cityId").val($(this).val());
    setCenter();
});

// 修改市
$(".btn_updateCity").click(function() {
	var cityId = $(this).parent().children(".cityId").val();
	var cityName = $(".cityName").val();
	var data = {"cityId":cityId, "cityName":cityName};
	$("#gray").hide();
    $("#updateCity").hide();
    $(".cityName").val("");
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/ProvinceServlet?type=updateCity",
		dataType:"json",
		data:data,
		success:function(data){
			var $tab_city = $(".right table.tab_city");
		    $tab_city.find("tr.tab_content").remove();
		    var i = 1;
		    $(data).each(function() {
		    	$tab_city.append("<tr class='tab_content'><td>"+i+"</td>" +
	                    "<td class='td_cityName'>"+this.cityName+"</td><td>" +
	                    "<button type='button' value='"+this.cityID+"' class='btn_deleteCity'>删除</button> |" +
	                    "<button type='button' value='"+this.cityID+"' class='btn_updateCity'>修改</button></td></tr>");
		    });
		}
	});
});

// 修改市，查询用户信息和县信息
function selCityQueryUserAndCounty() {
	$(".right .handle .sel_city option").each(function() {
		if (this.selected) {
			var cityName = $(this).val();
			var data = {"cityName":cityName};
			$.ajax({
				type : "POST",
				dataType : "json",
				url : "/STProject2/servlet/ProvinceServlet?type=queryUserByCityName",
				data : data,
				success : function(data) {
					var $tab_user = $(".right .tab_user");
					$tab_user.find(".tab_content").remove();
					var i = 1;
					$(data).each(function() {
						$tab_user.append("<tr class='tab_content'><td>"+i+"</td><th>"+this.user_City_Name+"</th>" + 
							"<th>"+this.user_County_Name+"</th><td>"+this.user_Name+"</td><td>"+this.user_Level+"</td><td>" + 
							"<button type='button' class='btn_deleteUser' value='"+ this.user_Name +"'>删除</button> |" +
							"<button type='button' class='btn_updateUser' value='"+ this.user_Name +"'>修改</button></td></tr>");
						i++;
					});
				}
			});
			$.ajax({
				type : "POST",
				dataType : "json",
				url : "/STProject2/servlet/ProvinceServlet?type=queryCountyByCityName",
				data : data,
				success : function(data) {
					var $sel_county = $(".right .handle .sel_county");
					$sel_county.children("option.opt_content").remove();
					$(data).each(function() {
						$sel_county.append("<option class='opt_content' value='"+this.county_Name+"'>"+this.county_Name+"</option>");
					});
				}
			});
		}
	});
}

// 修改县，查询用户信息
function selCountyQueryUser() {
	var cityName;
	$(".right .handle .sel_city option").each(function() {
		if (this.selected) {
			cityName = $(this).val();
		}
	});
	$(".right .handle .sel_county option").each(function() {
		if (this.selected) {
			var countyName = $(this).val();
			var data = {"cityName":cityName,"countyName":countyName};
			$.ajax({
				type : "POST",
				dataType : "json",
				url : "/STProject2/servlet/ProvinceServlet?type=queryUserByCountyName",
				data : data,
				success : function(data) {
					var $tab_user = $(".right .tab_user");
					$tab_user.find(".tab_content").remove();
					var i = 1;
					$(data).each(function() {
						$tab_user.append("<tr class='tab_content'><td>"+i+"</td><th>"+this.user_City_Name+"</th>" + 
						"<th>"+this.user_County_Name+"</th><td>"+this.user_Name+"</td><td>"+this.user_Level+"</td><td>" + 
						"<button type='button' class='btn_deleteUser' value='"+ this.user_Name +"'>删除</button> |" +
						"<button type='button' class='btn_updateUser' value='"+ this.user_Name +"'>修改</button></td></tr>");
						i++;
					});
				}
			});
		}
	});
}

// 删除用户
$(".btn_deleteCityUser").click(function() {
	var userName = $(this).val();
	var r=confirm("确认删除" + userName + "?")
	if (r) {
		var data = {"userName":userName};
		var $tab_user = $(".right .tab_user");
		$.ajax({
			type:"post",
			url:"/STProject2/servlet/ProvinceServlet?type=deleteUser",
			dataType:"json",
			data:data,
			success:function(data){
				$tab_user.find("tr.tab_content").remove();
				var i = 1;
				$(data).each(function() {
					$tab_user.append("<tr><td>"+i+"</td><td>"+this.user_City_Name+"</td>" +
	                    "<td>"+this.user_County_Name+"</td><td class='td_userName'>"+this.user_Name+"</td>" +
	                    "<td>"+this.user_Level+"</td><td>" +
	                    "<button type='button' class='btn_deleteCityUser' value='"+this.user_Name+"'>删除</button> |" +
	                    "<button type='button' class='btn_updateCityUser' value='"+this.user_Name+"'>修改</button></td></tr>");
					i++;
				});
			}
		});
	}
});

//点击编辑按钮显示功能
$(".right table .updateUser").click(function() {
    $("#gray").show();
    $("#updateUser").show();
    $("#updateUser .content .userId").val($(this).val());
    setCenter();
});

// 修改用户
$(".btn_updateUser").click(function() {
	var cityId = $(this).parent().children(".userId").val();
	var cityName = $(".userName").val();
	var data = {"userId":cityId, "userName":cityName};
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/ProvinceServlet?type=updateUser",
		dataType:"json",
		data:data,
		success:function(data){
			$("#gray").hide();
		    $("#updateUser").hide();
			alert(data.result);
		}
	});
});

//点击添加按钮显示添加用户功能
$(".right .handle .addUser").click(function() {
    $("#gray").show();
    $("#addUser").show();
    $("#addUser .content .userName").val("");
    $("#addUser .content .password").val("");
    setCenter();
    var $sel_city = $("#addUser .content .sel_city");
    $.ajax({
		type:"post",
		url:"/STProject2/servlet/ProvinceServlet?type=queryAllCity",
		dataType:"json",
		data:null,
		success:function(data){
			$(data).each(function() {
				$sel_city.append("<option value='"+ this.cityName +"'>"+ this.cityName +"</option>");
			});
		}
	});
});

//添加用户
$(".btn_addUser").click(function() {
	var $sel_city = $("#addUser .content .sel_city");
	var cityName = null;
	$sel_city.children("option").each(function() {
		if (this.selected) {
			cityName = $(this).val();
		}
	});
	var userName = $("#addUser").find(".userName").val();
	var password = $("#addUser").find(".password").val();
	var data = {"userName":userName, "password":password, "cityName":cityName};
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/ProvinceServlet?type=addUser",
		dataType:"json",
		data:data,
		success:function(data){
			$("#gray").hide();
		    $("#addUser").hide();
		    $(".userName").val("");
		    var $tab_user = $(".right .tab_user");
			$tab_user.find(".tab_content").remove();
		    var i = 1;
		    $(data).each(function() {
		    	$tab_user.append("<tr class='tab_content'><td>"+i+"</td><th>"+this.user_City_Name+"</th>" + 
						"<th>"+this.user_County_Name+"</th><td>"+this.user_Name+"</td><td>"+this.user_Level+"</td><td>" + 
						"<button type='button' class='btn_deleteUser' value='"+ this.user_Name +"'>删除</button> |" +
						"<button type='button' class='btn_updateUser' value='"+ this.user_Name +"'>修改</button></td></tr>");
		    	i++;
		    });
		    
		}
	});
});
