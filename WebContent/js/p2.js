/*
 * author:blindeagle
 * version:1.0
 * date:2015.11.29
 */

// 点击添加科目，弹出添加窗
$(".right .handle .addSubject").click(function() {
    $("#gray").show();
    $("#addSubject").show();
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

// 添加科目
$(".btn_addSubject").click(function() {
	var $content = $(this).parent(".content");
	var subClass = $content.find(".subClass").val();
	var subRegulation = $content.find(".subRegulation").val();
	var subItem = $content.find(".subItem").val();
	var subName = $content.find(".subName").val();
	var data = {"subClass":subClass,"subRegulation":subRegulation,"subItem":subItem,"subName":subName};
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/ProvinceServlet?type=addSubject",
		dataType:"json",
		data:data,
		success:function(data){
			$("#gray").hide();
		    $("#addSubject").hide();
		    var $tab_subject = $(".right .tab_subject");
		    $tab_subject.find("tr.tab_content").remove();
		    var i = 1;
		    $(data).each(function() {
		    	$tab_subject.append("<tr class='tab_content'><td>"+i+"</td>" +
		    		"<td>"+this.SBJ_Class+"</td><td>"+this.SBJ_Regulation+"</td>" +
		    		"<td>"+this.SBJ_Item+"</td><td>"+this.SBJ_Name+"</td>" +
		    		"<td><button type='button' class='btn_deleteSubject' value='"+this.SBJ_ID+"'>删除</button> |" +
                    "<button type='button' class='btn_deleteSubject' value='"+this.SBJ_ID+"'>修改</button></td></tr>");
		    	i++;
		    });
		}
	});
});

// 根据科目的类获得科目和款
function selClassQuerySubAndReg() {
	$(".right .handle .sel_class option").each(function() {
		if (this.selected) {
			var subClass = $(this).val();
			var data = {"class":subClass};
			$.ajax({
				type:"post",
				url:"/STProject2/servlet/ProvinceServlet?type=querySubjectByClass",
				dataType:"json",
				data:data,
				success:function(data){
				    var $tab_subject = $(".right .tab_subject");
				    $tab_subject.find("tr.tab_content").remove();
				    var $sel_regulation = $(".right .handle .sel_regulation");
				    $sel_regulation.find("option.opt_reg").remove();
				    var $sel_item = $(".right .handle .sel_item");
				    $sel_item.find("option.opt_item").remove();
				    var i = 1;
				    $(data[0]).each(function() {
				    	$tab_subject.append("<tr class='tab_content'><td>"+i+"</td>" +
				    		"<td>"+this.SBJ_Class+"</td><td>"+this.SBJ_Regulation+"</td>" +
				    		"<td>"+this.SBJ_Item+"</td><td>"+this.SBJ_Name+"</td>" +
				    		"<td><button type='button' class='btn_deleteSubject' value='"+this.SBJ_ID+"'>删除</button> |" +
	                        "<button type='button' class='btn_deleteSubject' value='"+this.SBJ_ID+"'>修改</button></td></tr>");
				    	i++;
				    });
				    $(data[1]).each(function() {
				    	$sel_regulation.append("<option class='opt_reg' value='"+this+"'>"+this+"</option>");
				    });
				}
			});
		}
	});
}

// 根据科目的款获得科目和项
function selRegQuerySubAndItem() {
	$(".right .handle .sel_regulation option").each(function() {
		var subClass;
		$(".right .handle .sel_class option").each(function() {
			if (this.selected) {
				subClass = $(this).val();
			}
		});
		if (this.selected) {
			var regulation = $(this).val();
			var data = {"subClass":subClass,"regulation":regulation};
			$.ajax({
				type:"post",
				url:"/STProject2/servlet/ProvinceServlet?type=querySubjectByRegulation",
				dataType:"json",
				data:data,
				success:function(data){
				    var $tab_county = $(".right .tab_subject");
				    $tab_county.find("tr.tab_content").remove();
				    var $sel_item = $(".right .handle .sel_item");
				    $sel_item.find("option.opt_item").remove();
				    var i = 1;
				    $(data[0]).each(function() {
				    	$tab_county.append("<tr class='tab_content'><td>"+i+"</td>" +
				    		"<td>"+this.SBJ_Class+"</td><td>"+this.SBJ_Regulation+"</td>" +
				    		"<td>"+this.SBJ_Item+"</td><td>"+this.SBJ_Name+"</td>" +
				    		"<td><button type='button' class='btn_deleteSubject' value='"+this.SBJ_ID+"'>删除</button> |" +
	                        "<button type='button' class='btn_deleteSubject' value='"+this.SBJ_ID+"'>修改</button></td></tr>");
				    	i++;
				    });
				    $(data[1]).each(function() {
				    	$sel_item.append("<option class='opt_item' value='"+this+"'>"+this+"</option>");
				    });
				}
			});
		}
	});
}

// 根据科目的项获得科目信息
function selItemQuerySubject() {
	$(".right .handle .sel_item option").each(function() {
		var subClass, subRegulation;
		$(".right .handle .sel_class option").each(function() {
			if (this.selected) {
				subClass = $(this).val();
			}
		});
		$(".right .handle .sel_regulation option").each(function() {
			if (this.selected) {
				subRegulation = $(this).val();
			}
		});
		if (this.selected) {
			var item = $(this).val();
			var data = {"subClass":subClass,"subRegulation":subRegulation,"item":item};
			$.ajax({
				type:"post",
				url:"/STProject2/servlet/ProvinceServlet?type=querySubjectByItem",
				dataType:"json",
				data:data,
				success:function(data){
				    var $tab_county = $(".right .tab_subject");
				    $tab_county.find("tr.tab_content").remove();
				    
				    var i = 1;
				    $(data).each(function() {
				    	
				    	$tab_county.append("<tr class='tab_content'><td>"+i+"</td>" +
				    		"<td>"+this.SBJ_Class+"</td><td>"+this.SBJ_Regulation+"</td>" +
				    		"<td>"+this.SBJ_Item+"</td><td>"+this.SBJ_Name+"</td>" +
				    		"<td><button type='button' class='btn_deleteSubject' value='"+this.SBJ_ID+"'>删除</button> |" +
	                        "<button type='button' class='btn_deleteSubject' value='"+this.SBJ_ID+"'>修改</button></td></tr>");
				    	i++;
				    });
				}
			});
		}
	});
}

// 删除科目
$(".btn_deleteSubject").click(function() {
	var subjectId = $(this).val();
	var data = {"subjectId":subjectId};
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/ProvinceServlet?type=deleteSubject",
		dataType:"json",
		data:data,
		success:function(data){
		    var $tab_county = $(".right .tab_subject");
		    $tab_county.find("tr.tab_content").remove();
		    var i = 1;
		    $(data).each(function() {
		    	$tab_county.append("<tr class='tab_content'><td>"+i+"</td>" +
		    		"<td>"+this.SBJ_Class+"</td><td>"+this.SBJ_Regulation+"</td>" +
		    		"<td>"+this.SBJ_Item+"</td><td>"+this.SBJ_Name+"</td>" +
		    		"<td><button type='button' class='btn_deleteSubject' value='"+this.SBJ_ID+"'>删除</button> |" +
                    "<button type='button' class='btn_deleteSubject' value='"+this.SBJ_ID+"'>修改</button></td></tr>");
		    	i++;
		    });
		}
	});
});

// 点击添加县按钮，弹出添加窗
$(".right .handle .addCounty").click(function() {
	$("#gray").show();
    $("#addCounty").show();
    setCenter();
});

// 添加县
$("#addCounty .content .btn_addCounty").click(function() {
	var $countyName = $(this).parent().find(".countyName");
	var countyName = $countyName.val();
	var data = {"countyName":countyName};
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/CityServlet?type=addCounty",
		dataType:"json",
		data:data,
		success:function(data){
			$("#gray").hide();
		    $("#addCounty").hide();
		    $countyName.val("");
		    var $tab_county = $(".right .tab_county");
		    $tab_county.find("tr.tab_content").remove();
		    var i = 1;
		    $(data).each(function() {
		    	$(".right .tab_county").append("<tr class='tab_content'><td>"+i+"</td>" +
			    		"<td class='td_countyName'>"+this.county_Name+"</td><td>" +
		                "<button type='button' value='"+this.county_ID+"' class='btn_deleteCounty'>删除</button> |" +
		                "<button type='button' value='"+this.county_ID+"' class='btn_updateCounty'>修改</button></td></tr>");
		    	i++;
		    });
		}
	});
});

// 删除县
$(".btn_deleteCounty").click(function() {
	var countyId = $(this).val();
	var data = {"countyId":countyId};
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/CityServlet?type=deleteCounty",
		dataType:"json",
		data:data,
		success:function(data){
			alert(0);
			var $tab_county = $(".right .tab_county");
			$tab_county.find("tr.tab_content").remove();
			var i = 1;
			$(data).each(function() {
				$tab_county.append("<tr class='tab_content'><td>"+i+"</td>" +
			    		"<td class='td_countyName'>"+this.county_Name+"</td><td>" +
		                "<button type='button' value='"+this.county_ID+"' class='btn_deleteCounty'>删除</button> |" +
		                "<button type='button' value='"+this.county_ID+"' class='btn_updateCounty'>修改</button></td></tr>");
				i++;
			});
		}
	});
});

// 点击添加用户按钮，弹出添加县级用户窗体
$(".right .handle .btn_addCountyUser").click(function() {
	$("#gray").show();
    $("#addCountyUser").show();
    setCenter();
    $.ajax({
		type:"post",
		url:"/STProject2/servlet/CityServlet?type=queryCountyByCityId",
		dataType:"json",
		data:null,
		success:function(data){
			var $sel_county = $("#addCountyUser .content .sel_county");
			$(data).each(function() {
				$sel_county.append("<option class='sel_content' value='"+this.county_Name+"'>"+this.county_Name+"</option>");
			});
		}
	});
});

// 添加用户
$("#addCountyUser .content .btn_addCountyUser").click(function() {
	var $countyOption = $(this).parent().find(".sel_county").find(".sel_content");
	var countyName = null;
	$countyOption.each(function() {
		if (this.selected) {
			countyName = $(this).val();
		}
	});
	var userName = $(this).parent().find(".userName").val();
	var password = $(this).parent().find(".password").val();
	var data = {"countyName":countyName, "userName":userName, "password":password};
	$("#gray").hide();
    $("#addCountyUser").hide();
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/CityServlet?type=InsertCountyUser",
		dataType:"json",
		data:data,
		success:function(data){
			var $tab_user = $(".right .tab_user");
			$tab_user.find("tr.tab_content").remove();
			var i = 1;
			$(data).each(function() {
				$tab_user.append("<tr class='tab_content'><td>"+i+"</td><td>"+this.user_City_Name+"</td>" +
						"<td>"+this.user_County_Name+"</td><td class='td_userName'>"+this.user_Name+"</td>" +
	                    "<td>"+this.user_Level+"</td><td><button type='button' class='btn_deleteCountyUser' value='"+this.user_Name+"'>删除</button> |" +
	                    "<button type='button' class='btn_updateCountyUser' value='"+this.user_Name+"'>修改</button></td></tr>");
				i++;
			});
		}
	});
});

// 在市用户管理页面，选择县，查询用户
function county_selCountyQueryUser() {
	$("#addCountyUser .content .sel_county option").each(function() {
		if (this.selected) {
			var countyName = $(this).val();
			var data = {"countyName":countyName};
			$.ajax({
				type:"post",
				url:"/STProject2/servlet/CityServlet?type=queryUserByCountyName",
				dataType:"json",
				data:data,
				success:function(data){
					var $tab_user = $(".right .tab_user");
					$tab_user.find("tr.tab_content").remove();
					var i = 1;
					$(data).each(function() {
						$tab_user.append("<tr class='tab_content'><td>"+i+"</td><td>$"+this.user_City_Name+"</td>" +
								"<td>"+this.user_County_Name+"</td><td class='td_userName'>"+this.user_Name+"</td>" +
			                    "<td>"+this.user_Level+"</td><td><button type='button' class='btn_deleteCountyUser' value='"+this.user_Name+"'>删除</button> |" +
			                    "<button type='button' class='btn_updateCountyUser' value='"+this.user_Name+"'>修改</button></td></tr>");
						i++;
					});
				}
			});
		}
		
	});
}

// 删除县用户
$(".btn_deleteCountyUser").click(function() {
	var userName = $(this).val();
	var data = {"userName":userName};
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/CityServlet?type=deleteCountyUser",
		dataType:"json",
		data:data,
		success:function(data){
			var $tab_user = $(".right .tab_user");
			$tab_user.find("tr.tab_content").remove();
			var i = 1;
			$(data).each(function() {
				$tab_user.append("<tr class='tab_content'><td>"+i+"</td><td>"+this.user_City_Name+"</td>" +
						"<td>"+this.user_County_Name+"</td><td class='td_userName'>"+this.user_Name+"</td>" +
	                    "<td>"+this.user_Level+"</td><td><button type='button' class='btn_deleteCountyUser' value='"+this.user_Name+"'>删除</button> |" +
	                    "<button type='button' class='btn_updateCountyUser' value='"+this.user_Name+"'>修改</button></td></tr>");
				i++;
			});
		}
	});
});

//修改县，查询用户信息
function city_selCountyQueryUser() {
	$(".right .handle .sel_county option").each(function() {
		if (this.selected) {
			var countyName = $(this).val();
			var data = {"countyName":countyName};
			$.ajax({
				type : "POST",
				dataType : "json",
				url : "/STProject2/servlet/CityServlet?type=queryUserByCountyName",
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



