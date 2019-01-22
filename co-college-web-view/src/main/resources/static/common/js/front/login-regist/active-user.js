$(document).ready(function () {
    /*发送激活码*/
    $("#sendemail").click(function () {
        //加载层
        var index = layer.load(0, {
            shade: [0.1, '#fff'] //0.1透明度的白色背景
        });
        var data = "email=" + $("#email").html();
        $.ajax({
            method: 'get',
            data: data,
            url: '/send_email',
            async: true,
            success: function success(data) {
                layer.close(index);
                if (data.code == 200) {
                    $(".time-second").addClass("time-active");
                    $(".time-first-description").addClass("time-hidden")
                    $(".time-second-description").removeClass("time-hidden")
                }
                else {
                    layer.msg(data.msg);
                }
            },
            error: function error(data) {
                layer.msg("网络错误 请检查网络后重试")
            }
        })
        $("#send-email-again").click(function () {
            //加载层
            var index = layer.load(0, {
                shade: [0.1, '#fff'] //0.1透明度的白色背景
            });
            var data = "email=" + $("#email").html();
            $.ajax({
                method: 'get',
                data: data,
                url: '/send_email',
                async: true,
                success: function success(data) {
                    layer.close(index);
                    if (data.code == 200) {
                        layer.msg("验证码发送成功");
                    }
                    else {
                        layer.msg(data.msg);
                    }
                },
                error: function error(data) {
                    layer.msg("网络错误 请检查网络后重试")
                }
            })
        })
        /*校验激活码并激活账号*/
        $("#sendtoken").click(function () {
            $.ajax({
                method: 'post',
                url: '/user/regist/check_token',
                data: {
                    "email": $("#email").html(),
                    "token": $("#token").val()
                },
                async: true,
                success: function (data) {
                    layer.msg(data.msg);
                    var code = data.code
                    if (code == 200) {
                        $(".time-third").addClass("time-active");
                        $(".time-second-description").addClass("time-hidden")
                        $(".time-third-description").removeClass("time-hidden")
                    }
                    else {
                        layer.msg("校验失败，请重新输入");
                        $("#token").val("")
                        $("#token").focus();
                    }
                },
                error: function error() {
                    layer.msg("网络错误 请检查后重试");
                    $("#token").val("");
                    $("#token").focus();
                }
            })
        })
    })
})