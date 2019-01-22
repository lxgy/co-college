$(document).ready(function () {
    new TencentCaptcha(document.getElementById("login-btn"), '2002199216', function (res) {
        var login_data = $("#loginF").serialize();
        if (res.ret == 0) {
            $.ajax({
                type: 'post',
                url: '/user/login',
                data: login_data,
                dataType: 'json',
                success: function (result) {
                    if (result.code == 200) {
                        window.location.href = "/index";
                        layer.msg(result.msg);
                    } else {
                        layer.msg(result.msg);
                    }
                },
                error: function (xhr) {
                    console.log(xhr);
                }
            });
        }
    });
});