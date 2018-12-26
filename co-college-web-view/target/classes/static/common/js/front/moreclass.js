$(document)
	.ready(

		function() {
			$
				.ajax({
					type: "get",
					url: "/co-college/pagenum",
					async: true,
					success: function(num) {
						var str = "<li id='last' class='disabled'><a href='javascript:void(0)' onclick='lastpage()' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>";
						for(var i = 1; i <= num; i++) {
							str = str +
								"<li><a href='javascript:void(0)' onclick='dirpage(this)'>" +
								i + "</a></li>"
						}
						str = str +
							"<li id='next'><a href='javascript:void(0)' onclick='nextpage()' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>";
						$(".pagination").append(str);
					},
					error: function error() {
						var num = 5;
						var str = "<li id='last' class='disabled'><a href='javascript:void(0)' onclick='lastpage()' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>";
						for(var i = 1; i <= num; i++) {
							str = str +
								"<li><a href='javascript:void(0)' class='li_number' >" +
								i + "</a></li>"
						}
						str = str +
							"<li id='next'><a href='javascript:void(0)'  aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>";
						$(".pagination").append(str);
						$(".pagination li").eq(1).attr("class",
							"active");
					}
				});
			/* 检测页数是否大于1 不是的话禁用下一页 */
			if($(".pagination li").length == 3) {
				$("#next").attr("class", "disabled");
			}
			$(document).on('click', '#next', function() {
				/* 获得最大页数 */
				var num = $(".pagination li").length;
				var page = $(".active"); /* 获取当前页dom节点 */
				/* 检测下一页按键状态 */
				if($("#next").attr("class") == "disabled") {
					void(0);
				} else {
					/* 检测上一页选项是否禁用，解禁 */
					if($("#last").attr("class") == "disabled") {
						$("#last").removeAttr("class");
					}
					/* 检测选中节点是否为最后一页 */
					if($(".active a").html() != (num - 3)) {
						page.removeAttr("class");
						page.next().attr("class", "active");
					} else {
						$("#next").attr("class", "disabled");
						/* 将选中效果移到下一个dom节点 */
						page.removeAttr("class");
						page.next().attr("class", "active");
						search();
					}
				}
			})

			$(document).on('click', '#last', function() {
				/* 检测点击时当前页面是否为第一页 */
				if($(".active a").html() == 1) {
					void(0);
				} else {
					/* 检测下一页选项是否禁用，解禁 */
					if($("#next").attr("class") == "disabled") {
						$("#next").removeAttr("class");
					}
					var page = $(".active");
					/* 将选中得dom节点移至上一个节点 */
					page.removeAttr("class");
					page.prev().attr("class", "active");
					/* 检测当前页面是否回到第一页 */
					if($(".active a").html() == 1) {
						$("#last").attr("class", "disabled");
					} else {
						$("#last").removeAttr("class");
					}
					search();
				}
			})

			$(document).on('click', '.li_number', function() {
				/* 获取当前点击dom节点 */
				var num = $(this);
				/* 获取总页数 */
				var pagenum = $(".pagination li").length - 2;
				/* 检测选中页面是否为首页 */
				/* 选中页面为首页禁用上一页按钮 */
				/* 选中页面不为首页解禁上一页按钮 */
				if(num.html() == 1) {
					if($("#last").attr("class") != "disabled") {
						$("#last").attr("class", "disabled");
					}
				} else {
					if($("#last").attr("class") == "disabled") {
						$("#last").removeAttr("class");
					}
				}
				/* 检测选中页面是否为尾页 */
				/* 选中页面为尾页禁用上一页按钮 */
				/* 选中页面不为尾页解禁上一页按钮 */
				if(num.html() == pagenum) {
					if($("#next").attr("class") != "disabled") {
						$("#next").attr("class", "disabled");
					}
				} else {
					if($("#next").attr("class") == "disabled") {
						$("#next").removeAttr("class");
					}
				}
				/* 移除其他按钮选中效果 */
				$(".active").removeAttr("class");
				/* 给选中按钮添加选中效果 */
				num.parent().attr("class", "active");
				search();
			})
			$(".searchall").click(function() {
				$("#search").val("");
				search();
			})

			function search() {
				var search = $("#search").val(); /* 获得搜索条件 */
				var page = $(".active").html(); /* 获得当前页面 */
				var pagenum = 8; /* 设置每页查询条数 */
				$
					.ajax({
						type: "get",
						url: "/co-college/search",
						data: {
							"search": search,
							"page": page,
							"pagenum": pagenum,
						},
						async: true,
						success: function sunccess(data) {
							var str = "";
							for(var i = 0; i < data.Length; i++) {
								str = str +
									"<div class='clazz'><a href='javascript:;'><div><img title='课程图片' class='cover' src='" +
									data[i].imgsrc +
									"' /></div><div class='tag'>" +
									data[i].tag +
									"</div><div class='tietle'>" +
									data[i].tietle +
									"</div><div class='price'>" +
									data[i].price +
									"</div></a></div>"
							}
							$("clazzdiv").html(str);
						}
					});
			}
			$(".navbar-nav li").click(function() {
				$(".nav_active").removeAttr("class");
				$(this).attr("class", "nav_active");
			})
			/*			$(".modal_clazz").hide();
						$(".cover").hover(function() {
							$(this).find("div").eq(0).show();
						})
						$(".cover").mouseleave(function() {
							$(this).find("div").eq(0).hide();
						})
			*/
			/*	$(".clazz").hover(function(){
					$(this).css("width","20vw");
					$(this).css("height","28vw");
				})
				$(".clazz").mouseleave(function(){
					$(this).css("height","26vw");
					$(this).css("width","1vw");
					
				})*/
			$(".banner").css("background-image", "url(https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=580973613,606962119&fm=58&bpow=400&bpoh=293)")
			$(".container div").show(2000) /*延迟加载首页banner*/
		})