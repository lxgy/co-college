$(document).ready(function() {
	/*初始化验证码，用户名，密码，二次密码为空，不符合提交表单要求*/
	var code = false,
		usernameValue = false,
		passwordValue = false,
		rePasswordValue = false,
		emailValue = false;

	/*滑动验证通过  验证码设置为true */
	new SliderLock("#sliderLock", function() {
		code = true;
		$("#code-msg").text("");
	}).init();

	/*用户名规则验证*/
	$("#username").on('blur', function() {
		var username = $("#username").val();
		if(username == "" || username.length == 0) {
			$(".message-username").text("*用户名不能为空");
			usernameValue = false;
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
			passwordValue = false;
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

	/*二次密码规则验证*/
	$("#repassword").on('blur', function() {
		var password = $("#password").val(),
			repassword = $("#repassword").val(),
			msgText = "";

		if(repassword != password) {
			msgText = "*两次密码不一致，请重新输入";
			rePasswordValue = false;
		} else {
			rePasswordValue = true;
		}
		$(".message-repassword").text(msgText);
	});

	/*邮箱验证*/
	$("#email").on('blur', function() {
		var email = $("#email").val(),
			msgText = "";

		if(email == "" || email.length == 0) {
			msgText = "*邮箱不能为空";
			emailValue = false;
		} else {
			var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
			if(!reg.test(email)) {
				msgText = "*请填写正确的邮箱";
				emailValue = false;
			} else {
				emailValue = true;
			}
		}
		$(".message-email").text(msgText);
	});

	/*点击提交注册表单按钮*/
	$("#regist-btn").on('click', function() {
		/*提交登录之前 获取各个input的值*/
		var usernameV = $("#username").val(),
			passwordV = $("#password").val(),
			repasswordV = $("#repassword").val(),
			emailV = $("#email").val();

		/*按表单input顺序依次判断，如果发现有空的，则获取焦点，鼠标自动定位到该输入框，*/
		if(usernameV == "" || usernameV.length == 0) {
			$("#username").focus();
			$(".message-username").text("用户名不能为空");
		} else if(passwordV == "" || usernameV.length == 0) {
			$("#password").focus();
			$(".message-password").text("密码不能为空");
		} else if(repasswordV != passwordV) {
			$("#repassword").focus();
			$(".message-repassword").text("两次密码不一致");
		} else if(emailV == "" || emailV.length == 0) {
			$("#email").focus();
			$(".message-email").text("邮箱不能为空");
		}

		if(code && usernameValue && passwordValue && rePasswordValue && emailValue) {
			layer.msg("提交表单");
		} else {
			if(!usernameValue && !passwordValue && !rePasswordValue && !emailValue && !code) {
				$("#code-msg").text("请先通过验证");
			} else if(!code) {
				$("#code-msg").text("请先通过验证");
			}
		}
	});

	$("#logo").on('click', function() {
		location.href = "/index";
	});
});