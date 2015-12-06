/*
 * author:blindeagle
 * version:1.0
 * date:2015.11.29
 */

// 根据市查询省级项目表
function queryProjectByCityName() {
	$(".projectRight .sel_allCity option").each(function() {
		if (this.selected) {
			var data = {"cityName":$(this).val()};
			$.ajax({
				type:"post",
				url:"/STProject2/servlet/ProvinceServlet?type=queryProjectByCityName",
				dataType:"json",
				data:data,
				success:function(data){
					var $tab_project = $(".projectRight .tab_provinceProject");
					$tab_project.find("tr.tab_content").remove();
					var i = 1;
					$(data[0]).each(function() {
						$tab_project.append("<tr class='tab_content'><td>"+i+"</td>" +
							"<td>"+this.city_Name_PPFK+"</td><td>"+this.province_RFC_PPFK+"</td>" +
							"<td>"+data[1][i-1].SBJ_Class+"</td><td>"+data[1][i-1].SBJ_Regulation+"</td>" +
							"<td>"+data[1][i-1].SBJ_Item+"</td><td>"+this.project_Name+"</td>" +
							"<td>"+this.total_Budget+"</td><td>"+this.centre_Budget+"</td>" +
							"<td>"+this.province_Budget+"</td><td>"+this.city_Local_Budget+"</td>" +
							"<td>"+this.city_Local_Cost+"</td><td>"+this.city_Local_Percent+"</td>" +
							"<td>"+this.county_Budget+"</td><td>"+this.county_Cost+"</td>" +
							"<td>"+this.county_Percent+"%</td><td></td><td>" +
	                        "<button type='button' value='"+this.project_Name+"'>删除</button> |" +
	                        "<button type='button' value='"+this.project_Name+"'>修改</button></td></tr>");
					});
				}
			});
		}
	});
}

//根据市查询省级项目表
function queryProjectByProvinceRFC() {
	$(".projectRight .sel_allPPFK option").each(function() {
		if (this.selected) {
			var data = {"provinceRFC":$(this).val()};
			$.ajax({
				type:"post",
				url:"/STProject2/servlet/ProvinceServlet?type=queryProjectByProvinceRFC",
				dataType:"json",
				data:data,
				success:function(data){
					var $tab_project = $(".projectRight .tab_provinceProject");
					$tab_project.find("tr.tab_content").remove();
					var i = 1;
					$(data[0]).each(function() {
						$tab_project.append("<tr class='tab_content'><td>"+i+"</td>" +
							"<td>"+this.city_Name_PPFK+"</td><td>"+this.province_RFC_PPFK+"</td>" +
							"<td>"+data[1][i-1].SBJ_Class+"</td><td>"+data[1][i-1].SBJ_Regulation+"</td>" +
							"<td>"+data[1][i-1].SBJ_Item+"</td><td>"+this.project_Name+"</td>" +
							"<td>"+this.total_Budget+"</td><td>"+this.centre_Budget+"</td>" +
							"<td>"+this.province_Budget+"</td><td>"+this.city_Local_Budget+"</td>" +
							"<td>"+this.city_Local_Cost+"</td><td>"+this.city_Local_Percent+"</td>" +
							"<td>"+this.county_Budget+"</td><td>"+this.county_Cost+"</td>" +
							"<td>"+this.county_Percent+"%</td><td></td><td>" +
	                        "<button type='button' value='"+this.project_Name+"'>删除</button> |" +
	                        "<button type='button' value='"+this.project_Name+"'>修改</button></td></tr>");
					});
				}
			});
		}
	});
}

//根据市查询省级项目表
function queryProjectBySubClass() {
	$(".projectRight .sel_allClass option").each(function() {
		if (this.selected) {
			var data = {"subClass":$(this).val()};
			$.ajax({
				type:"post",
				url:"/STProject2/servlet/ProvinceServlet?type=queryProjectBySubClass",
				dataType:"json",
				data:data,
				success:function(data){
					var $tab_project = $(".projectRight .tab_provinceProject");
					$tab_project.find("tr.tab_content").remove();
					var i = 1;
					$(data[0]).each(function() {
						$tab_project.append("<tr class='tab_content'><td>"+i+"</td>" +
							"<td>"+this.city_Name_PPFK+"</td><td>"+this.province_RFC_PPFK+"</td>" +
							"<td>"+data[1][i-1].SBJ_Class+"</td><td>"+data[1][i-1].SBJ_Regulation+"</td>" +
							"<td>"+data[1][i-1].SBJ_Item+"</td><td>"+this.project_Name+"</td>" +
							"<td>"+this.total_Budget+"</td><td>"+this.centre_Budget+"</td>" +
							"<td>"+this.province_Budget+"</td><td>"+this.city_Local_Budget+"</td>" +
							"<td>"+this.city_Local_Cost+"</td><td>"+this.city_Local_Percent+"</td>" +
							"<td>"+this.county_Budget+"</td><td>"+this.county_Cost+"</td>" +
							"<td>"+this.county_Percent+"%</td><td></td><td>" +
	                        "<button type='button' value='"+this.project_Name+"'>删除</button> |" +
	                        "<button type='button' value='"+this.project_Name+"'>修改</button></td></tr>");
					});
				}
			});
		}
	});
}

//点击关闭按钮 关闭功能
$("a.close").click(function() {
    $("#gray").hide();
    $(".pop2").hide();
});

//当动态改变浏览器窗口时，也要水平居中
$(window).resize(function() {
    setCenter();
});
function setCenter() {
    var _left = ($(window).width() - $(".pop2").width()) / 2;
    $(".pop2").css({top:"40px",left:_left});
}

//拖动效果
$(document).ready(function() {
    $(".pop2").draggable();
});

//点击添加分配条目按钮，添加分配条目
$("#addProvinceProject .content .div_assign .add_assign").click(function() {
	$(this).parent().append("<div class='item_assign'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
		"&nbsp;&nbsp;&nbsp;&nbsp;市<input type='text' class='city_assign'/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
		"&nbsp;&nbsp;&nbsp;&nbsp;县<input type='text' class='county_assign'/><br/>预算指标" +
		"<input type='text' class='countyBudget'/>&nbsp;&nbsp;&nbsp;支付数<input type='text' class='countyCost'/>" +
        "<br/>支付进度<input type='text' class='countyPercent txt'/></div>");
});

// 点击添加按钮，弹出添加省级项目的窗体
$(".projectRight .handle .addProvinceProject").click(function() {
	$("#gray").show();
    $("#addProvinceProject").show();
    setCenter();
});

// 添加省级项目
$("#addProvinceProject .content .btn_addProvinceProject").click(function() {
	var $content = $("#addProvinceProject .content");
	var cityRfc = $content.find(".cityRfc").val();
	var subClass = $content.find(".class").val();
	var regulation = $content.find(".regulation").val();
	var item = $content.find(".item").val();
	var projectName = $content.find(".projectName").val();
	var totalBudget = $content.find(".totalBudget").val();
	var centreBudget = $content.find(".centreBudget").val();
	var provinceBudget = $content.find(".provinceBudget").val();
	var cityLocalBudget = $content.find(".cityLocalBudget").val();
	var cityLocalCost = $content.find(".cityLocalCost").val();
	var cityLocalPercent = $content.find(".cityLocalPercent").val();
	
	var $item_assign = $("#addProvinceProject .content .div_assign .item_assign");
	var cityAndCounty = new Array();
	for (var i = 0; i < $item_assign.size(); i++) {
		cityAndCounty[i] = $item_assign.eq(i).find(".city_assign").val() + ":" + $item_assign.eq(i).find(".county_assign").val() +
			":" + $item_assign.eq(i).find(".other_budget").val() + ":" + $item_assign.eq(i).find(".other_cost").val() +
			":" + $item_assign.eq(i).find(".other_percent").val();
	}
	var data = {"cityRfc":cityRfc,"subClass":subClass,"regulation":regulation,"item":item,
			"projectName":projectName,"totalBudget":totalBudget,"centreBudget":centreBudget,
			"provinceBudget":provinceBudget,"cityLocalBudget":cityLocalBudget,"cityLocalCost":cityLocalCost,
			"cityLocalPercent":cityLocalPercent,"cityAndCounty":cityAndCounty.toString()};
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/ProvinceServlet?type=addProvinceProject",
		dataType:"json",
		data:data,
		success:function(data){
			$("#gray").hide();
		    $("#addCityProject").hide();
		    var $tab_cityProject = $(".projectRight .tab_cityProject");
		    $tab_cityProject.find("tr.tab_content").remove();
		    var i = 1;
		    $(data[0]).each(function() {
		    	$tab_cityProject.append("<tr class='tab_content'><td>"+i+"</td>" +
		    			"<td>"+this.province_RFC_PPFK+"</td><td>"+data[1][i-1].SBJ_Class+"</td>" +
	                    "<td>"+data[1][i-1].SBJ_Regulation+"</td><td>"+data[1][i-1].SBJ_Item+"</td>" +
	                    "<td>"+this.project_Name+"</td><td>"+this.total_Budget+"</td>" +
	                    "<td>"+this.centre_Budget+"</td><td>"+this.province_Budget+"</td>" +
	                    "<td>"+this.city_Local_Budget+"</td><td>"+this.city_Local_Cost+"</td>" +
	                    "<td>"+this.city_Local_Percent+"</td><td>"+this.county_Budget+"</td>" +
	                    "<td>"+this.county_Cost+"</td><td>"+this.county_Percent+"%</td>" +
	                    "<td></td><td><button type='button'>删除</button> |" +
	                    "<button type='button'>修改</button></td></tr>");
		    	i++;
		    });
		}
	});
});

//点击添加按钮，弹出添加市级项目的窗体
$(".projectRight .handle .addCityProject").click(function() {
	$("#gray").show();
    $("#addCityProject").show();
    setCenter();
});

// 添加省级项目
$("#addCityProject .content .btn_addCityProject").click(function() {
	var $content = $("#addCityProject .content");
	var cityRfc = $content.find(".cityRfc").val();
	var subClass = $content.find(".class").val();
	var regulation = $content.find(".regulation").val();
	var item = $content.find(".item").val();
	var projectName = $content.find(".projectName").val();
	var totalBudget = $content.find(".totalBudget").val();
	var cityLocalBudget = $content.find(".cityLocalBudget").val();
	var cityLocalCost = $content.find(".cityLocalCost").val();
	var cityLocalPercent = $content.find(".cityLocalPercent").val();
	
	var $item_assign = $("#addCityProject .content .div_assign .item_assign");
	var cityAndCounty = new Array();
	for (var i = 0; i < $item_assign.size(); i++) {
		cityAndCounty[i] = $item_assign.eq(i).find(".county_assign").val() +
			":" + $item_assign.eq(i).find(".other_budget").val() + ":" + $item_assign.eq(i).find(".other_cost").val() +
			":" + $item_assign.eq(i).find(".other_percent").val();
	}
	var data = {"cityRfc":cityRfc,"subClass":subClass,"regulation":regulation,"item":item,
			"projectName":projectName,"totalBudget":totalBudget,
			"cityLocalBudget":cityLocalBudget,"cityLocalCost":cityLocalCost,
			"cityLocalPercent":cityLocalPercent,"cityAndCounty":cityAndCounty.toString()};
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/CityServlet?type=addCityProject",
		dataType:"json",
		data:data,
		success:function(data){
			$("#gray").hide();
		    $("#addCityProject").hide();
		    var $tab_cityProject = $(".projectRight .tab_cityProject");
		    $tab_cityProject.find("tr.tab_content").remove();
		    var i = 1;
		    $(data[0]).each(function() {
		    	$tab_cityProject.append("<tr class='tab_content'><td>"+i+"</td>" +
		    			"<td>"+this.province_RFC_PPFK+"</td><td>"+data[1][i-1].SBJ_Class+"</td>" +
	                    "<td>"+data[1][i-1].SBJ_Regulation+"</td><td>"+data[1][i-1].SBJ_Item+"</td>" +
	                    "<td>"+this.project_Name+"</td><td>"+this.total_Budget+"</td>" +
	                    "<td>"+this.centre_Budget+"</td><td>"+this.province_Budget+"</td>" +
	                    "<td>"+this.city_Local_Budget+"</td><td>"+this.city_Local_Cost+"</td>" +
	                    "<td>"+this.city_Local_Percent+"</td><td>"+this.county_Budget+"</td>" +
	                    "<td>"+this.county_Cost+"</td><td>"+this.county_Percent+"%</td>" +
	                    "<td></td><td><button type='button'>删除</button> |" +
	                    "<button type='button'>修改</button></td></tr>");
		    	i++;
		    });
		}
	});
});








