/*
 * author:blindeagle
 * version:1.0
 * date:2015.11.29
 */

/**
 * 设置DIV居中
 * @author blindeagle
 * @param currentElement 要设置的div元素
 */
function be_setDivCenter(currentElement) {
	function setCenter(currentElement) {
		
		var _top = ($(window).height() - currentElement.height()) / 2;
		var _left = ($(window).width() - currentElement.width()) / 2;
		currentElement.css({position:"absolute",top:_top,left:_left});	
	}
	setCenter(currentElement);
	$(window).resize(function() {
		setCenter(currentElement);
	});	
}

/**
 * 设置元素可拖动
 * @author blindeagle
 * @param currentElement 要设置的元素
 */
function be_drag(currentElement) {
	var isDrag = false;
	currentElement.mousedown(function(e) {
		var x = e.clientX;
		var y = e.clientY;
		var left = $(this).offset().left;
		var top = $(this).offset().top;
		isDrag = true;
		$(document).mousemove(function(e) {
			if (isDrag) {
				var nleft = e.clientX + left - x;
				var ntop = e.clientY + top - y;
				currentElement.css({left:nleft, top:ntop});
			}
		}).mouseup(function() {
			isDrag = false;
		});
	});
}			
