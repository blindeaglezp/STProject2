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


