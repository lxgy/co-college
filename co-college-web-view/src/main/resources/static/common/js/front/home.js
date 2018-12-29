$(document).ready(function () {
    $(document).scroll(function () {
        var scroll_top_value =  $(document).scrollTop();
        if(scroll_top_value != 0){
            $(".college-header").addClass("navbar-fixed-top fix-top");
        }else {
            $(".college-header").removeClass("navbar-fixed-top fix-top")
        }
    });
});