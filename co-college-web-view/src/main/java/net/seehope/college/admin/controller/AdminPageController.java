package net.seehope.college.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {
    @GetMapping("/admin/index")
    public String admin_index() {
        return "admin/html/index.html";
    }

    @GetMapping("/book/update")
    public String book_update() {
        return "admin/html/book/book-update.html";
    }

    @GetMapping("/book/add")
    public String book_add() {
        return "admin/html/book/book-add.html";
    }

    @GetMapping("/book/list")
    public String BookList() {
        return "admin/html/book/book-list.html";
    }

    @GetMapping("/book/chapter/add")
    public String book_chapter_add() {
        return "admin/html/book/book-chapter-add.html";
    }

    @GetMapping("/book/chapter/update")
    public String book_chapter_update() {
        return "admin/html/book/book-chapter-update.html";
    }

    @GetMapping("/user/update")
    public String user_update() {
        return "admin/html/user/user-update.html";
    }

    @GetMapping("/user/add")
    public String user_add() {
        return "admin/html/user/user-add.html";
    }

    @GetMapping("/user/list")
    public String user_list() {
        return "admin/html/user/user-list.html";
    }

    @GetMapping("/video/update")
    public String video_update() {
        return "admin/html/video/video-update.html";
    }

    @GetMapping("/video/add")
    public String video_add() {
        return "admin/html/video/video-add.html";
    }

    @GetMapping("/video/list")
    public String video_list() {
        return "admin/html/video/video-list.html";
    }

    @GetMapping("/tool/update")
    public String tool_update() {
        return "admin/html/tool/tool-update.html";
    }

    @GetMapping("/tool/add")
    public String tool_add() {
        return "admin/html/tool/tool-add.html";
    }

    @GetMapping("/tool/list")
    public String tool_list() {
        return "admin/html/tool/tool-list.html";
    }

    @GetMapping("/project/update")
    public String project_update() {
        return "admin/html/project/project-update.html";
    }

    @GetMapping("/project/add")
    public String project_add() {
        return "admin/html/project/project-add.html";
    }

    @GetMapping("/project/list")
    public String project_list() {
        return "admin/html/project/project-list.html";
    }

    @GetMapping("/news/update")
    public String news_update() {
        return "admin/html/news/news-update.html";
    }

    @GetMapping("/news/add")
    public String news_add() {
        return "admin/html/news/news-add.html";
    }

    @GetMapping("/news/list")
    public String news_list() {
        return "admin/html/news/news-list.html";
    }

    @GetMapping("/group/update")
    public String group_update() {
        return "admin/html/group/group-update.html";
    }

    @GetMapping("/group/add")
    public String group_add() {
        return "admin/html/group/group-add.html";
    }

    @GetMapping("/group/list")
    public String group_list() {
        return "admin/html/group/group-list.html";
    }

    @GetMapping("/admin/update")
    public String admin_update() {
        return "admin/html/admin/admin-update.html";
    }

    @GetMapping("/admin/add")
    public String admin_add() {
        return "admin/html/admin/admin-add.html";
    }

    @GetMapping("/admin/list")
    public String admin_list() {
        return "admin/html/admin/admin-list.html";
    }

    @GetMapping("/pay_service/update")
    public String pay_service_update() {
        return "admin/html/pay_service/pay-service-update.html";
    }

    @GetMapping("/pay_service/add")
    public String pay_service_add() {
        return "admin/html/pay_service/pay-service-add.html";
    }

    @GetMapping("/pay_service/list")
    public String pay_service_list() {
        return "admin/html/pay_service/pay-service-list.html";
    }

    @GetMapping("/class/update")
    public String class_update() {
        return "admin/html/class/class-update.html";
    }

    @GetMapping("/class/add")
    public String class_add() {
        return "admin/html/class/class-add.html";
    }

    @GetMapping("/class/list")
    public String class_list() {
        return "admin/html/class/class-list.html";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "admin/html/welcome.html";
    }
    @GetMapping("/admin/login")
    public String login() {
        return "admin/html/login.html";
    }
}

