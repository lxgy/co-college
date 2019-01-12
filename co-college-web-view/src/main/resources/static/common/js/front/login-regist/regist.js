$(document).ready(function() {

	var email,
		password,
		repassword;

	$("#email").bind('input propertychange', function() {
		var email_val = $("#email").val();
		email = email_rules();
	});

	$("#password").bind('input propertychange', function() {
		password = password_rules();
	});

	$("#repassword").bind('input propertychange', function() {
		password = $("#password").val(),
			repassword = $("#repassword").val();
		if (repassword != password) {
			$("#repassword-success").text("");
			$("#repassword-msg").text("两次密码不一致");
			$("#repassword").focus();
			repassword = false;
		} else {
			repassword = true;
			$("#repassword-msg").text("");
			$("#repassword-success").text("密码一致");
		}
	});


	// 腾讯防水墙验证码
	var tencentCaptchaVertify = new TencentCaptcha(document.getElementById("regist-btn"), '2002199216',
		function(res) {
			var regist_data = $("#registF").serialize();

			if (res.ret == 0) {
				email = email_rules();
				if (email) {
					password = password_rules();
				}
				if (password) {
					repassword = repassword_rules();
				}

				var protocol = $("#access-protocol").get(0).checked;

				if (email && password && repassword && protocol) {
					$.ajax({
						type: 'post',
						url: '/user/regist',
						data: regist_data,
						dataType: 'json',
						success: function(result) {
							console.log(result);
							if(result.code == 200){
								document.location.href= "/page/send_email/" + result.data.email
							}
						},
						error: function(xhr) {
							console.log(xhr);
						}
					});
				}
			}
		});
});

function email_rules() {
	var result, email_val = $("#email").val();
	if (email_val == "" || email_val == null) {
		$("#email-success").text("");
		$("#email-msg").text("* 邮箱不能为空");
		$("#email").focus();
		result = false;
	} else {
		var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		if (!reg.test(email_val)) {
			$("#email-success").text("");
			$("#email-msg").text("* 请填写正确的邮箱格式");
			$("#email").focus();
			result = false;
		} else {
			$("#email-msg").text("");
			$("#email-success").text("邮箱可用");
			result = true;
		}
	}
	if (result) {
		$.ajax({
			type: 'post',
			url: '/user/validate_email',
			data: {
				email: email_val
			},
			dataType: 'json',
			async:false,
			success: function(data) {
				if (data.code == 200) {
					result = true;
					$("#email-msg").text("");
					$("#email-success").text(data.msg);
				} else {
					result = false;
					$("#email-success").text("");
					$("#email-msg").text(data.msg);
				}
			},
			error: function(xhr) {
				layer.msg("请刷新重试");
				console.log(xhr);
			}
		});
	}
	return result;
}

function password_rules() {
	var result, password_val = $("#password").val();
	if (password_val == "" || password_val == null) {
		$("#password-success").text("");
		$("#password-msg").text("* 密码不能为空");
		$("#password").focus();
		result = false;
	} else {
		var reg = /^\w{6,18}$/;
		if (!reg.test(password_val)) {
			$("#password-success").text("");
			$("#password-msg").text("* 密码由6-18位的数字、字母、下划线组成");
			$("#password").focus();
			result = false;
		} else {
			$("#password-msg").text("");
			$("#password-success").text("密码可用");
			result = true;
		}
	}
	return result;
}

function repassword_rules() {
	var result,
		password = $("#password").val(),
		repassword = $("#repassword").val();
	if (password != repassword) {
		$("#repassword").text("两次密码不一致");
		$("#repassword").focus();
		result = false;
	} else {
		result = true;
		$("#repassword-msg").text("");
		$("#repassword-success").text("密码一致");
	}
	return result;
}
