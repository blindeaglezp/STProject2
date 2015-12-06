/*
 * author:blindeagle
 * version:1.0
 * date:2015.11.29
 */

// 省级用户初始化左侧导航栏
function province_initLeft() {
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/ProvinceServlet?type=queryCityAndCounty",
		dataType:"json",
		data:null,
		success:function(data){
			d = new dTree('d');
		    d.add(0, -1, '山西省');
			var index = 1;
			$(data[0]).each(function() {
				var cityIndex = index;
				d.add(index, 0, this.cityName);
				index++;
				var cityId = this.cityID;
				$(data[1][this.cityID]).each(function() {
					d.add(index, cityIndex, this.county_Name);
					index++;
				});
			});
			$(".left").html(d.toString());
		}
	});
}

// 市级用户初始化左侧导航栏
function city_initLeft() {
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/CityServlet?type=queryCityAndCounty",
		dataType:"json",
		data:null,
		success:function(data){
			d = new dTree('d');
		    d.add(0, -1, data[0].cityName);
			var index = 1;
			$(data[1]).each(function() {
				var cityIndex = index;
				d.add(index, 0, this.county_Name);
				index++;
			});
			$(".left").html(d.toString());
		}
	});
}

// 县级用户初始化左侧导航栏
function county_initLeft() {
	$.ajax({
		type:"post",
		url:"/STProject2/servlet/CountyServlet?type=queryCountyByName",
		dataType:"json",
		data:null,
		success:function(data){
			d = new dTree('d');
		    d.add(0, -1, data.county_Name);
			$(".left").html(d.toString());
		}
	});
}







