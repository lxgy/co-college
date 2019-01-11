package net.seehope.college.admin.controller;

import com.github.pagehelper.PageHelper;
import net.seehope.college.core.page.Page;
import net.seehope.college.core.page.PageRequest;
import net.seehope.college.entity.User;
import net.seehope.college.service.UserService;
import net.seehope.college.util.file.DownloadUtil;
import net.seehope.college.util.file.FileRWUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: co-college
 * @BelongsPackage: net.seehope.admin.controller
 * @Author: lxgy
 * @CreateTime: 2018-12-12 17:43
 * @Description: ${Description}
 */
@Controller
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
    public Object test1(HttpServletResponse response) {
        return this.userService.findUsers();
    }

    @RequestMapping("/test3")
    public void test2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String file_name = "DownloadUtil.java";
        String file_path = "D:\\workspace\\idea\\edumanage\\src\\main\\java\\com\\seehope\\util\\file\\DownloadUtil.java";
        DownloadUtil.download_file(file_name, file_path, request, response);
    }

    @PostMapping("/upload")
    @ResponseBody
    public String testUpload(@RequestParam(name = "file") MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            return "上传失败,文件为空.";
        }
        String file_name = file.getOriginalFilename();
        System.out.println("文件名为：" + file_name);
        String file_path = request.getServletContext().getRealPath("/upload/");
        System.out.println("context_path:" + file_path);
        FileRWUtil.mkdirs(file_path);
        File dest = new File(file_path + file_name);
        System.out.println("dest:" + dest);
        try {
            file.transferTo(dest);
            System.out.println(file_path + file_name);
            return "上传成功:文件地址为" + file_path + file_name;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    @PostMapping("/test4")
    @ResponseBody
    public Object test4(PageRequest pageRequest, HttpServletResponse response) {
        int total = this.userService.getUserCount();
        System.out.println("1269");
        PageHelper.startPage(pageRequest.getPage_no(), pageRequest.getPage_size());
        List<User> users = this.userService.findUsers();
        Page<User> page = new Page<>(pageRequest, users, total);
        page.setDatas(users);
        return page;
    }


}