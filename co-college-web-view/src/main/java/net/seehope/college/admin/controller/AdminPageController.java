package net.seehope.college.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {
    /**
     * 后台管理页面首页
     * @return
     */
    @GetMapping("/admin/index")
    public String admin_index() {
        return "admin/html/index.html";
    }

    /**
     * 更新书籍
     * @return
     */
    @GetMapping("/book/update")
    public String book_update() {
        return "admin/html/book/book-update.html";
    }

    /**
     * 添加书籍
     * @return
     */
    @GetMapping("/book/add")
    public String book_add() {
        return "admin/html/book/book-add.html";
    }

    /**
     * 查询书籍列表
     * @return
     */
    @GetMapping("/book/list")
    public String BookList() {
        return "admin/html/book/book-list.html";
    }

    /**
     * 添加书籍章节
     * @return
     */
    @GetMapping("/book/chapter/add")
    public String book_chapter_add() {
        return "admin/html/book/book-chapter-add.html";
    }

    /**
     * 修改书籍章节
     * @return
     */
    @GetMapping("/book/chapter/update")
    public String book_chapter_update() {
        return "admin/html/book/book-chapter-update.html";
    }

    /**
     * 修改用户账户
     * @return
     */
    @GetMapping("/user/update")
    public String user_update() {
        return "admin/html/user/user-update.html";
    }

    /**
     * 添加用户账户
     * @return
     */
    @GetMapping("/user/add")
    public String user_add() {
        return "admin/html/user/user-add.html";
    }

    /**
     * 查询用户账号列表
     * @return
     */
    @GetMapping("/user/list")
    public String user_list() {
        return "admin/html/user/user-list.html";
    }

    /**
     * 修改视频
     * @return
     */
    @GetMapping("/video/update")
    public String video_update() {
        return "admin/html/video/video-update.html";
    }

    /**
     * 添加视频
     * @return
     */
    @GetMapping("/video/add")
    public String video_add() {
        return "admin/html/video/video-add.html";
    }

    /**
     * 查询视频列表
     * @return
     */
    @GetMapping("/video/list")
    public String video_list() {
        return "admin/html/video/video-list.html";
    }

    /**
     * 修改工具
     * @return
     */
    @GetMapping("/tool/update")
    public String tool_update() {
        return "admin/html/tool/tool-update.html";
    }

    /**
     * 添加工具
     * @return
     */
    @GetMapping("/tool/add")
    public String tool_add() {
        return "admin/html/tool/tool-add.html";
    }

    /**
     * 查询工具列表
     * @return
     */
    @GetMapping("/tool/list")
    public String tool_list() {
        return "admin/html/tool/tool-list.html";
    }

    /**
     * 修改项目
     * @return
     */
    @GetMapping("/project/update")
    public String project_update() {
        return "admin/html/project/project-update.html";
    }

    /**
     * 添加项目
     * @return
     */
    @GetMapping("/project/add")
    public String project_add() {
        return "admin/html/project/project-add.html";
    }

    /**
     * 查询所有项目列表
     * @return
     */
    @GetMapping("/project/list")
    public String project_list() {
        return "admin/html/project/project-list.html";
    }

    /**
     * 修改新闻
     * @return
     */
    @GetMapping("/news/update")
    public String news_update() {
        return "admin/html/news/news-update.html";
    }

    /**
     * 添加新闻
     * @return
     */
    @GetMapping("/news/add")
    public String news_add() {
        return "admin/html/news/news-add.html";
    }

    /**
     * 查询新闻列表
     * @return
     */
    @GetMapping("/news/list")
    public String news_list() {
        return "admin/html/news/news-list.html";
    }

    /**
     * 修改团队
     * @return
     */
    @GetMapping("/group/update")
    public String group_update() {
        return "admin/html/group/group-update.html";
    }

    /**
     * 添加团队
     * @return
     */
    @GetMapping("/group/add")
    public String group_add() {
        return "admin/html/group/group-add.html";
    }

    /**
     * 查询团队列表
     * @return
     */
    @GetMapping("/group/list")
    public String group_list() {
        return "admin/html/group/group-list.html";
    }

    /**
     * 修改管理员账户
     * @return
     */
    @GetMapping("/admin/update")
    public String admin_update() {
        return "admin/html/admin/admin-update.html";
    }

    /**
     * 增加管理账户
     * @return
     */
    @GetMapping("/admin/add")
    public String admin_add() {
        return "admin/html/admin/admin-add.html";
    }

    /**
     * 查询管理员账户列表
     * @return
     */
    @GetMapping("/admin/list")
    public String admin_list() {
        return "admin/html/admin/admin-list.html";
    }

    /**
     * 修改增值业务
     * @return
     */
    @GetMapping("/pay_service/update")
    public String pay_service_update() {
        return "admin/html/pay_service/pay-service-update.html";
    }

    /**
     * 添加增值业务
     * @return
     */
    @GetMapping("/pay_service/add")
    public String pay_service_add() {
        return "admin/html/pay_service/pay-service-add.html";
    }

    /**
     * 查询增值业务列表
     * @return
     */
    @GetMapping("/pay_service/list")
    public String pay_service_list() {
        return "admin/html/pay_service/pay-service-list.html";
    }

    /**
     * 修改课程
     * @return
     */
    @GetMapping("/class/update")
    public String class_update() {
        return "admin/html/class/class-update.html";
    }

    /**
     * 添加课程
     * @return
     */
    @GetMapping("/class/add")
    public String class_add() {
        return "admin/html/class/class-add.html";
    }

    /**
     * 查询课程列表
     * @return
     */
    @GetMapping("/class/list")
    public String class_list() {
        return "admin/html/class/class-list.html";
    }

    /**
     * 后台管理系统欢迎页面
     * @return
     */
    @GetMapping("/welcome")
    public String welcome() {
        return "admin/html/welcome.html";
    }

    /**
     * 后台管理系统登录页面
     * @return
     */
    @GetMapping("/admin/login")
    public String login() {
        return "admin/html/login.html";
    }
}

