/*
 * author:blindeagle
 * version:1.0
 * date:2015.11.29
 */

// 省级统计项目
function projectTotal() {
	var budgetTotal = 0, costTotal = 0;
	$(".tab_provinceProject .tab_content .countyBudget").each(function() {
		budgetTotal += parseInt($(this).html());
	});
	$(".tab_provinceProject .tab_content .countyCost").each(function() {
		costTotal += parseInt($(this).html());
	});
	$(".tab_provinceProject").append("<tr class='tab_count'><td>合计</td><td></td><td></td>" +
		"<td></td><td></td><td></td><td></td><td></td><td class='budgetTotal'>"+budgetTotal+"</td>" +
		"<td class='costTotal'>"+costTotal+"</td><td class='percentTotal'>"+(costTotal/budgetTotal*100).toFixed(2) +"%</td></tr>");
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

// 根据条件查询项目
$(".queryProjectByCondition").click(function queryProjectByCondition() {
	var cityName, countyName, subClass, subReg, subItem, provinceRfc, projectName;
	$(".projectRight .sel_allCity option").each(function() {
		if (this.selected) {
			cityName = $(this).val();
		}
	});
	$(".projectRight .sel_allCounty option").each(function() {
		if (this.selected) {
			countyName = $(this).val();
		}
	});
	$(".projectRight .sel_allClass option").each(function() {
		if (this.selected) {
			subClass = $(this).val();
		}
	});
	$(".projectRight .sel_allRegulation option").each(function() {
		if (this.selected) {
			subReg = $(this).val();
		}
	});
	$(".projectRight .sel_allItem option").each(function() {
		if (this.selected) {
			subItem = $(this).val();
		}
	});
	provinceRfc = $(".provinceRfc").val();
	projectName = $(".projectName").val();
	var data = {"cityName":cityName,"countyName":countyName,"subClass":subClass,"subReg":subReg,
			"subItem":subItem,"provinceRfc":provinceRfc,"projectName":projectName};
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/ProvinceServlet?type=queryProjectByCondition",
		dataType:"json",
		data:data,
		success:function(data){
			var $project = $(".projectRight .tab_provinceProject");
			$project.find("tr.tab_content").remove();
			$project.find("tr.tab_count").remove();
			var i = 1;
			$(data[0]).each(function() {
				$project.append("<tr class='tab_content'><td>"+i+"</td>" +
					"<td>"+data[1][i-1]+"</td><td>"+this.county_name_CPFK+"</td>" +
					"<td>"+this.city_RFC_CPFK+"</td><td>"+data[2][i-1].SBJ_Class+"</td>" +
					"<td>"+data[2][i-1].SBJ_Regulation+"</td><td>"+data[2][i-1].SBJ_Item+"</td>" +
					"<td>"+this.project_Name+"</td><td class='countyBudget'>"+this.county_Budget+"</td>" +
					"<td class='countyCost'>"+this.county_Cost+"</td><td>"+this.county_Percent+"</td>" +
					"<td><button type='button'>删除</button> | <button type='button'>修改</button></td></tr>");
				i++;
			});
			projectTotal();
		}
	});
});


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
$("#addCityProject").find(".add_assign").click(function() {
	$(".btn_addCityProject").parents("tr").before("<tr class='item_assign'><td id='text'>县：</td><td><input type='text' class='county_assign'>" +
		"</td><td id='text'>预算指标：</td><td><input type='text' class='other_budget'></td></tr>");
});

// 点击添加按钮，弹出添加省级项目的窗体
$(".projectRight .addProvinceProject").click(function() {
	$("#gray").show();
    $("#addProvinceProject").show();
    setCenter();
});

// 添加省级项目
$(".btn_addProvinceProject").click(function() {
	var $content = $("#addProvinceProject .table_province");
	var cityRfc = $content.find(".cityRfc").val();
	var subClass = $content.find(".class").val();
	var regulation = $content.find(".regulation").val();
	var item = $content.find(".item").val();
	var projectName = $content.find(".projectName").val();
	var totalBudget = $content.find(".totalBudget").val();
	var centreBudget = $content.find(".centreBudget").val();
	var provinceBudget = $content.find(".provinceBudget").val();
	var cityLocalBudget = $content.find(".cityLocalBudget").val();
	var $item_assign = $(".sub_content").find(".item_assign");
	var cityAndCounty;
	$item_assign.each(function() {
		cityAndCounty += this.find(".city_assign").val() + ":" + this.find(".county_assign").val() +
		":" + this.find(".other_budget").val() + ",";
	});
	alert(cityAndCounty);
	var data = {"cityRfc":cityRfc,"subClass":subClass,"regulation":regulation,"item":item,
			"projectName":projectName,"totalBudget":totalBudget,"centreBudget":centreBudget,"provinceBudget":provinceBudget,
			"cityLocalBudget":cityLocalBudget,"cityAndCounty":cityAndCounty};
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
$("#addCityProject").find(".btn_addCityProject").click(function() {
	var $content = $("#addCityProject table");
	var cityRfc = $content.find(".cityRfc").val();
	var subClass = $content.find(".class").val();
	var regulation = $content.find(".regulation").val();
	var item = $content.find(".item").val();
	var projectName = $content.find(".projectName").val();
	var totalBudget = $content.find(".totalBudget").val();
	var cityLocalBudget = $content.find(".cityLocalBudget").val();
	var provinceRfc = $content.find(".provinceRfc").val();
	var $item_assign = $("#addCityProject").find(".item_assign");
	var cityAndCounty = new Array();
	for (var i = 0; i < $item_assign.size(); i++) {
		cityAndCounty[i] = $item_assign.eq(i).find(".county_assign").val() +
			":" + $item_assign.eq(i).find(".other_budget").val();
	}
	alert(cityAndCounty);
	var data = {"cityRfc":cityRfc,"subClass":subClass,"regulation":regulation,"item":item,
			"projectName":projectName,"totalBudget":totalBudget,"provinceRfc":provinceRfc,
			"cityLocalBudget":cityLocalBudget,"cityAndCounty":cityAndCounty.toString()};
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

// 点击更新县级项目信息按钮
$(".btn_countyUpdate").click(function() {
	$("#gray").show();
	$("#updateCountyProject").show();
	$("#updateCountyProject .content .cityRfc").val($(this).parents("tr.tab_content").find(".cityRfc").html());
	$("#updateCountyProject .content .projectName").val($(this).parents("tr.tab_content").find(".projectName").html());
});

// 更新县级项目信息
$(".btn_updateCountyProject").click(function() {
	var $content = $(this).parent();
	var cityRfc = $content.find(".cityRfc").val();
	var projectName = $content.find(".projectName").val();
	var cost = $content.find(".cost").val();
	var data = {"cityRfc":cityRfc,"projectName":projectName,"cost":cost};
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/CountyServlet?type=updateCountyProject",
		dataType:"json",
		data:data,
		success:function(data){
			$("#gray").hide();
		    $("#updateCountyProject").hide();
		    var $tab_countyProject = $(".projectRight .tab_countyProject");
		    $tab_countyProject.find("tr.tab_content").remove();
		    var i = 1;
		    $(data[0]).each(function() {
		    	$tab_countyProject.append("<tr class='tab_content'><td>"+i+"</td>" +
	                "<td class='cityRfc'>"+this.city_RFC_CPFK+"</td>" +
	                "<td class='subClass'>"+data[1][i-1].SBJ_Class+"</td>" +
	                "<td class='subReg'>"+data[1][i-1].SBJ_Regulation+"</td>" +
	                "<td class='subItem'>"+data[1][i-1].SBJ_Item+"</td>" +
	                "<td class='projectName'>"+this.project_Name+"</td>" +
	                "<td class='budget'>"+this.county_Budget+"</td>" +
	                "<td>"+this.county_Cost+"</td>" +
	                "<td>"+this.county_Percent+"</td><td>" +
	                "<button type='button' class=btn_countyUpdate>修改</button></td></tr>");
		    	i++;
		    });
		}
	});
});

// 根据条件查询项目
$(".queryCityProByCondition").click(function() {
	var subClass, subReg, subItem, provinceRfc, projectName;
	$(".projectRight .sel_allClass option").each(function() {
		if (this.selected) {
			subClass = $(this).val();
		}
	});
	$(".projectRight .sel_allRegulation option").each(function() {
		if (this.selected) {
			subReg = $(this).val();
		}
	});
	$(".projectRight .sel_allItem option").each(function() {
		if (this.selected) {
			subItem = $(this).val();
		}
	});
	provinceRfc = $(".cityRfc").val();
	projectName = $(".cityName").val();
	var data = {"subClass":subClass,"subReg":subReg,"subItem":subItem,
			"provinceRfc":provinceRfc,"projectName":projectName};
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/CityServlet?type=queryCityProByCondition",
		dataType:"json",
		data:data,
		success:function(data){
			var $project = $(".projectRight .tab_cityProject");
			$project.find("tr.tab_content").remove();
			$project.find("tr.tab_count").remove();
			var i = 1;
			$(data[0]).each(function() {
				$project.append("<tr class='tab_content'><td>"+i+"</td>" +
					"<td>"+this.province_RFC_PPFK+"</td><td>"+data[1][i-1].SBJ_Class+"</td>" +
					"<td>"+data[1][i-1].SBJ_Regulation+"</td><td>"+data[1][i-1].SBJ_Item+"</td>" +
					"<td>"+this.project_Name+"</td><td>"+this.city_Local_Budget+"</td>" +
					"<td>"+this.city_Local_Cost+"</td><td>"+this.city_Local_Percent+"</td>" +
					"<td><button type='button'>删除</button> |<button type='button'>修改</button></td></tr>");
				i++;
			});
			projectTotal();
		}
	});
});








