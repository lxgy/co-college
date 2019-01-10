package net.seehope.college.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description：用户端页面控制层.
 * @Author:lxgy
 * @Date:2018-12-25
 */
@Controller
public class FrontPageController {

    /*共创学院首页*/
	@GetMapping("/index")
    public String page_index() {
        return "front/home";
    }
	
	@GetMapping("/")
	public String page_index2() {
		return "front/home";
	}

    /*登录页面*/
    @GetMapping("/login")
    public String page_login(){
        return "front/login-regist/login";
    }

    /*注册页面*/
    @GetMapping("/regist")
    public String page_regist(){
        return "front/login-regist/regist";
    }
    
    /*留下电话号码页面*/
    @GetMapping("/front/page/stay_phone")
    public String page_stay_phone() {
    	return "front/index/stay-phone";
    }
    
    /*留言页面*/
    @GetMapping("/font/page/stay_message")
    public String page_stay_message() {
    	return "front/index/stay-message";
    }

}
