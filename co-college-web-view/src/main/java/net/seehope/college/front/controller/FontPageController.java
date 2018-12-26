package net.seehope.college.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description：用户端页面控制层.
 * @Author:lxgy
 * @Date:2018-12-25
 */
@Controller
public class FontPageController {

    /*共创学院首页*/
    @RequestMapping("/index")
    public String page_index() {
        return "front/index";
    }

    /*登录页面*/
    @RequestMapping("/login")
    public String page_login(){
        return "front/login-regist/login";
    }

    /*注册页面*/
    @RequestMapping("/regist")
    public String page_regist(){
        return "front/login-regist/regist";
    }


}
