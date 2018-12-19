package net.seehope.college.admin.controller;

import net.seehope.college.entity.User;
import net.seehope.college.mapper.UserMapper;
import net.seehope.college.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @BelongsProject: co-college
 * @BelongsPackage: net.seehope.admin.controller
 * @Author: lxgy
 * @CreateTime: 2018-12-12 17:43
 * @Description: ${Description}
 */
@Controller
@Service
public class AdminTestController {

    @Resource
    private UserService userService;

    @RequestMapping("/test")
    public Object test(Map<String, Object> map) {
        map.put("test", "hello 这是一个测试");
        System.out.println(this.userService.findUsers());
        return "admin/test";
    }

    @RequestMapping("/test2")
    @ResponseBody
    public Object test1(HttpServletResponse response){
        return this.userService.findUsers();
    }

}
