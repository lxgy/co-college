$(document).ready(function () {
    // 下拉时间，触顶时间
    $(document).scroll(function () {
        var scroll_top_value = $(document).scrollTop();
        if (scroll_top_value > 480) {
            $(".college-header").addClass("navbar-fixed-top fix-top");
            $(".college-nav").addClass("new-collegenav");
            $("#header-image").addClass("new-headerimage");
            $("#header-nav").addClass("new-headernav");
            $("#header-loginregist").addClass("new-headerloginregist");
            $("#header-image").removeClass("header-image");
            $("#header-nav").removeClass("header-nav");
            $("#header-loginregist").removeClass("header-loginregist");
        } else {
            $(".college-header").removeClass("navbar-fixed-top fix-top")
            $(".college-nav").removeClass("new-collegenav");
            $("#header-image").removeClass("new-headerimage");
            $("#header-nav").removeClass("new-headernav");
            $("#header-loginregist").removeClass("new-headerloginregist");
            $("#header-image").addClass("header-image");
            $("#header-nav").addClass("header-nav");
            $("#header-loginregist").addClass("header-loginregist");
        }

    });

    //首页
    $("#to-index").on('click', function () {
        document.location.href = "/index";
    });
// jquery下拉菜单插件绑定
//     $('#dropdown').mnmenu();
    // 登录页
    $("#to-login").on('click', function () {
        document.location.href = "/login";
    });

    // 注册页
    $("#to-regist").on('click', function () {
        document.location.href = "/regist";
    });
    $("#to-about-us").on('click', function () {
        document.location.href = "/about_us";
    });
    // 退出登录
    $("#exit").click(function () {
        $.get("/user/exit", function reload() {
            $(location).attr('href', '/login');
        })
    })
});