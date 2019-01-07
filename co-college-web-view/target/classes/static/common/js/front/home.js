$(document).ready(function () {
    // 下拉时间，触顶时间
    $(document).scroll(function () {
        var scroll_top_value = $(document).scrollTop();
        if (scroll_top_value > 540) {
            $(".aside-totop").removeClass("text-hide");
        } else {
            $(".aside-totop").addClass("text-hide");
        }
    });

    // 日志轮播
    var logs_carousel = new Swiper('.swiper-container', {
        autoplay: 3000,
        speed: 1000,
        loop: true
    });

    // 获取需要展示的文字
    var i, et = document.getElementById('tags').childNodes;
    for (i in et) {
        et[i].nodeName == 'A' && et[i].addEventListener('click', function (e) {
            window.location.href = e.path[0].href;
            e.preventDefault();
        });
    }

    var j, ett = document.getElementById('class-tags').childNodes;
    for (j in ett) {
        et[i].nodeName == 'A' && et[i].addEventListener('click', function (e) {
            window.location.href = e.path[0].href;
            e.preventDefault();
        });
    }
    // 开启3d展示效果
    TagCanvas.Start('myCanvas', 'tags', {
        textColour: '#222',
        outlineColour: '#cccccc',
        reverse: true,
        depth: 0.8,
        dragControl: true,
        decel: 0.95,
        maxSpeed: 0.05,
        initial: [-0.2, 0]
    });

    TagCanvas.Start('class-myCanvas', 'class-tags', {
        textColour: '#222',
        outlineColour: '#cccccc',
        reverse: true,
        depth: 0.8,
        dragControl: true,
        decel: 0.95,
        maxSpeed: 0.05,
        initial: [-0.2, 0]
    });

    // 点击留下电话号码图标
    $("#aside-phone").on('click',function(){
        layer.open({
            type:2,
            title:'提示信息',
            content: 'front/page/stay_phone',
            area:['430px','450px']
        });
    });

});