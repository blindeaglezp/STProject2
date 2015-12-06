/*
 * author:blindeagle
 * version:1.0
 * date:2015.11.29
 */

$(".provinceRfc").bind("input propertychange", function() {
	var provinceRfc = $(this).val();
	var data = {"provinceRfc":provinceRfc};
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/ProvinceServlet?type=queryRfcByRfc",
		dataType:"json",
		data:data,
		success:function(data){
			var $ul = $(".projectRight .rfcItem");
			$ul.find("li").remove();
			$(data).each(function() {
				$ul.append("<li>"+this+"</li>");
			});
		}
	});
});

// 省级统计项目
function projectTotal() {
	var budgetTotal = 0, costTotal = 0;
	$(".tab_provinceProject .tab_content .countyBudget").each(function() {
		budgetTotal += parseInt($(this).html());
	});
	$(".tab_provinceProject .tab_content .countyCost").each(function() {
		costTotal += parseInt($(this).html());
	});
	$(".tab_provinceProject .tab_count .budgetTotal").html(budgetTotal);
	$(".tab_provinceProject .tab_count .costTotal").html(costTotal);
	$(".tab_provinceProject .tab_count .percentTotal").html((costTotal / budgetTotal * 100).toFixed(2) + "%");
}

//县级统计项目
function county_projectTotal() {
	var budgetTotal = 0, costTotal = 0;
	$(".tab_cityProject .tab_content .countyBudget").each(function() {
		budgetTotal += parseInt($(this).html());
	});
	$(".tab_cityProject .tab_content .countyCost").each(function() {
		costTotal += parseInt($(this).html());
	});
	$(".tab_cityProject .tab_count .budgetTotal").html(budgetTotal);
	$(".tab_cityProject .tab_count .costTotal").html(costTotal);
	$(".tab_cityProject .tab_count .percentTotal").html((costTotal / budgetTotal * 100).toFixed(2) + "%");
}

// 根据条件查询市项目
function queryProjectByCondition() {
	var cityName;
	$(".projectRight .sel_allCity option").each(function() {});
}

// 根据市名查询县
function queryCountyByCity() {
	var cityName;
	$(".projectRight .sel_allCity option").each(function() {
		if (this.selected) {
			cityName = $(this).val();
			var data = {"cityName":cityName};
			if (cityName != 0) {
				$.ajax({
					type:"post",
					url:"/STProject2/servlet/ProvinceServlet?type=queryCountyByCityName",
					dataType:"json",
					data:data,
					success:function(data){
						var $county = $(".projectRight .sel_allCounty");
						$county.find("option.content").remove();
						$(data).each(function() {
							$county.append("<option class='content' value='"+this.county_Name+"'>"+this.county_Name+"</option>");
						});
					}
				});
			} else {
				$(".projectRight .sel_allCounty option.content").remove();
			}
		}
	});
}

// 根据类查询款
function queryRegByClass() {
	$(".projectRight .sel_allClass option").each(function() {
		if (this.selected) {
			var subClass = $(this).val();
			var data = {"class":subClass};
			if (subClass != 0) {
				$.ajax({
					type:"post",
					url:"/STProject2/servlet/ProvinceServlet?type=querySubjectByClass",
					dataType:"json",
					data:data,
					success:function(data){
						var $reg = $(".projectRight .sel_allRegulation");
						$reg.find("option.content").remove();
						$(data[1]).each(function() {
							$reg.append("<option class='content' value='"+this+"'>"+this+"</option>");
						});
					}
				});
			} else {
				$(".projectRight .sel_allRegulation option.content").remove();
			}
		}
	});
}

// 根据款查询项
function queryItemByReg() {
	$(".projectRight .sel_allRegulation option").each(function() {
		if (this.selected) {
			var subReg = $(this).val();
			var data = {"regulation":subReg};
			if (subReg != 0) {
				$.ajax({
					type:"post",
					url:"/STProject2/servlet/ProvinceServlet?type=querySubjectByRegulation",
					dataType:"json",
					data:data,
					success:function(data){
						var $item = $(".projectRight .sel_allItem");
						$item.find("option.content").remove();
						$(data[1]).each(function() {
							$item.append("<option class='content' value='"+this+"'>"+this+"</option>");
						});
					}
				});
			} else {
				$(".projectRight .sel_allItem option.content").remove();
			}
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

// 添加市项目
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








