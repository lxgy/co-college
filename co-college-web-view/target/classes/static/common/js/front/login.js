$(document).ready(function() {
	/*初始化验证不通过，用户名不通过，密码不通过*/
	var code = false,
		usernameValue = false,
		passwordValue = false;

	/*滑动验证*/
	new SliderLock("#sliderLock", function() {
		code = true;
		$("#code-msg").text("");
	}).init();

	/*用户名规则验证*/
	$("#username").on('blur', function() {
		var username = $("#username").val();
		if(username == "" || username.length == 0) {
			$(".message-username").text("*用户名不能为空");
		} else {
			var msgText = "*用户名长度为2-8";
			if(username.length >= 2 && username.length <= 8) {
				msgText = "";
				usernameValue = true;
			} else {
				usernameValue = false;
			}
			$(".message-username").text(msgText);
		}
	});

	/*密码规则验证*/
	$("#password").on('blur', function() {
		var password = $("#password").val();
		if(password == "" || password.length == 0) {
			$(".message-password").text("*密码不能为空");
		} else {
			var msgText = "",
				reg = /^\w{6,18}$/;
			if(!reg.test(password)) {
				msgText = "*密码由6-18位的数字、字母、下划线组成";
				passwordValue = false;
			} else {
				passwordValue = true;
			}
			$(".message-password").text(msgText);
		}
	});

	/*提交表单*/
	$("#login-btn").on('click', function() {
		var usernameV = $("#username").val(),
			passwordV = $("#password").val();
		
		/*依次检测用户名  密码是否为空  为空 依次获得焦点 */
		if(usernameV == "" || usernameV.length == 0) {
			$("#username").focus();
			$(".message-username").text("用户名不能为空");
		} else if(passwordV == "" || passwordV.length == 0) {
			$("#password").focus();
			$(".message-password").text("密码不能为空");
		}

		/*通过所有验证 则提交表单登录*/
		if(code && usernameValue && passwordValue) {
			/*登录表单数据序列化*/
			var formData = $("#loginF").serialize();
			/*ajax 提交登录表单*/
			$.ajax({
				type: "post",
				url: "/co-college/user/login",
				async: true,
				data: formData,
				dataType: 'json',
				success: function(result) {
					layer.msg("登录成功");
				},
				error: function() {
					layer.msg("系统错误!");
				}
			});
		} else {
			if(!usernameValue && !passwordValue && !code) {
				$("#code-msg").text("请先通过验证");
			} else if(!code) {
				$("#code-msg").text("请先通过验证");
			}
		}
	});
	/*点击logo 回到首页*/
	$("#logo").on('click', function() {
		location.href = "/index";
	});
});