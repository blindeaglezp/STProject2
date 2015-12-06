/*
 * author:blindeagle
 * version:1.0
 * date:2015.11.29
 */

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

// 点击添加按钮，弹出添加县级项目的窗体
$(".projectRight .handle .addCountyProject").click(function() {
	$("#gray").show();
    $("#addCountyProject").show();
    setCenter();
});


// 添加县级项目项目
$(".btn_addCountyProject").click(function() {
	var $content = $("#addCountyProject .content");
	var cityRfc = $content.find(".cityRfc").val();
	var subClass = $content.find(".class").val();
	var regulation = $content.find(".regulation").val();
	var item = $content.find(".item").val();
	var projectName = $content.find(".projectName").val();
	var countyBudget = $content.find(".countyBudget").val();
	var countyCost = $content.find(".countyCost").val();
	var data = {"cityRfc":cityRfc,"subClass":subClass,"regulation":regulation,"item":item,
			"projectName":projectName,"countyBudget":countyBudget,"countyCost":countyCost};
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/CountyServlet?type=addCountyProject",
		dataType:"json",
		data:data,
		success:function(data){
			$("#gray").hide();
		    $("#addCountyProject").hide();
		    var $tab_cityProject = $(".projectRight .tab_countyProject");
		    $tab_cityProject.find("tr.tab_content").remove();
		    var i = 1;
		    $(data[0]).each(function() {
		    	$tab_cityProject.append("<tr class='tab_content'><td>"+i+"</td>" +
		    		"<td>"+this.city_RFC_CPFK+"</td><td>$"+data[1][i-1].SBJ_Class+"</td>" +
	                "<td>"+data[1][i-1].SBJ_Regulation+"</td><td>"+data[1][i-1].SBJ_Item+"</td>" +
	                "<td>"+this.project_Name+"</td><td>"+this.county_Budget+"</td>" +
	                "<td>"+this.county_Cost+"</td><td>"+this.county_Percent+"</td>" +
	                "<td><button type='button' value='"+this.project_Name+"'>删除</button> |" +
	                "<button type='button' value='"+this.project_Name+"'>修改</button></td></tr>");
		    	i++;
		    });
		}
	});
});

/*//点击添加按钮，弹出添加市级项目的窗体
$(".projectRight .handle .addCityProject").click(function() {
	$("#gray").show();
    $("#addCityProject").show();
    setCenter();
});


// 添加市级项目
$(".btn_addCityProject").click(function() {
	var $content = $("#addCityProject .content");
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
	var countyBudget = $content.find(".countyBudget").val();
	var countyCost = $content.find(".countyCost").val();
	var countyPercent = $content.find(".countyPercent").val();
	var data = {"cityRfc":cityRfc,"subClass":subClass,"regulation":regulation,"item":item,
			"projectName":projectName,"totalBudget":totalBudget,"centreBudget":centreBudget,
			"provinceBudget":provinceBudget,"cityLocalBudget":cityLocalBudget,"cityLocalCost":cityLocalCost,
			"cityLocalPercent":cityLocalPercent,"countyBudget":countyBudget,"countyCost":countyCost,
			"countyPercent":countyPercent};
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
});*/

