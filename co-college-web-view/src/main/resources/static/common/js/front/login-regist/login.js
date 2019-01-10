$(document).ready(function(){
	new TencentCaptcha(document.getElementById("login-btn"),'2002199216',function(res){
		var login_data = $("#loginF").serialize();
		if(res.ret == 0){
			$.ajax({
				type: 'post',
				url: '/user/login',
				data: login_data,
				dataType: 'json',
				success: function(result) {
                    console.log(result);
				},
				error: function(xhr) {
					console.log(xhr);
				}
			});
		}
	});
});