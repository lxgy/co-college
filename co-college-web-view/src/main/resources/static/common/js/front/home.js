$(document).ready(function() {
	//下拉时间，触顶时间
	$(document).scroll(function() {
		var scroll_top_value = $(document).scrollTop();
		if (scroll_top_value != 0) {
			$(".college-header").addClass("navbar-fixed-top fix-top");
		} else {
			$(".college-header").removeClass("navbar-fixed-top fix-top")
		}
	});
	
	//获取需要展示的文字    
	var i, et = document.getElementById('tags').childNodes;
	for (i in et) {
		et[i].nodeName == 'A' && et[i].addEventListener('click', function(e) {
			window.location.href = e.path[0].href;
			e.preventDefault();
		});
	}
	
	var j, ett = document.getElementById('class-tags').childNodes;
	for (j in ett) {
		et[i].nodeName == 'A' && et[i].addEventListener('click', function(e) {
			window.location.href = e.path[0].href;
			e.preventDefault();
		});
	}
	//开启3d展示效果
	TagCanvas.Start('myCanvas', 'tags', {
		textColour: '#222',
		outlineColour: '#fff',
		reverse: true,
		depth: 0.8,
		dragControl: true,
		decel: 0.95,
		maxSpeed: 0.05,
		initial: [-0.2, 0]
	});
	
	TagCanvas.Start('class-myCanvas', 'class-tags', {
		textColour: '#222',
		outlineColour: '#fff',
		reverse: true,
		depth: 0.8,
		dragControl: true,
		decel: 0.95,
		maxSpeed: 0.05,
		initial: [-0.2, 0]
	});
	
	
	
});
