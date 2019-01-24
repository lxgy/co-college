package net.seehope.college.front.controller;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.seehope.college.util.security.BcryptEncodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import net.seehope.college.core.CodeEnum;
import net.seehope.college.email.SendEmail;
import net.seehope.college.entity.User;
import net.seehope.college.service.UserService;
import net.seehope.college.util.date.DateTimeUtil;
import net.seehope.college.util.uuid.UUIDUtil;
import net.seehope.college.vo.ResultVo;

@Controller
public class FrontUserController {

    @Resource
    private UserService userService;

    @Resource
    private SendEmail sendEmail;

    /**
     * 用户注册.
     *
     * @param user
     * @return
     * @throws Throwable
     */
    @PostMapping("/user/regist")
    @ResponseBody
    public Object user_regist(User user) throws Throwable {
        ResultVo<User> resultVo = new ResultVo<User>(CodeEnum._200.getCode(), "regist success");
        user.setCreate_time(DateTimeUtil.getCurrentDateTime());
        user.setUsername(UUIDUtil.get_uuid_intercept(15));
        user.setIs_active(0);
        user.setPassword(BcryptEncodeUtil.encode(user.getPassword()));
        user.setIs_lock(0);
        user.setType(1);
        resultVo.setData(user);
        boolean result = this.userService.add_user(user);
        if (!result) {
            resultVo.setCode(CodeEnum._500.getCode());
            resultVo.setMsg("regist faile please try again");
            resultVo.setData(null);
        }
        return resultVo;
    }

    /**
     * 用户登录操作
     *
     * @param user
     * @return
     */
    @PostMapping("/user/login")
    @ResponseBody
    public Object user_login(HttpServletRequest request, User user) {
        ResultVo<User> resultVo = this.userService.user_login(user.getUsername(), user.getPassword());
        return resultVo;
    }

    /**
     * 邮箱验证是否已被注册.
     *
     * @param email
     * @return
     */
    @PostMapping("/user/validate_email")
    @ResponseBody
    public Object validate_user_email(String email) {
        boolean result = this.userService.get_user_by_email(email);
        ResultVo<User> resultVo = new ResultVo<User>(CodeEnum._500.getCode(), "该邮箱已被注册");
        if (!result) {
            resultVo.setCode(CodeEnum._200.getCode());
            resultVo.setMsg("邮箱可用");
        }
        return resultVo;
    }

    /**
     * 发送邮箱激活码
     *
     * @param request
     * @return
     * @throws MessagingException
     */
    @GetMapping("/send_email")
    @ResponseBody
    public Object send_email(HttpServletRequest request, String email) throws MessagingException {
        String token = null;
        ResultVo<User> resultVo = new ResultVo<>();
        try {
            token = UUIDUtil.get_uuid_intercept(5);
//		this.sendEmail.sendMail("砺锋众创创客账号激活", "<p>点击该链接即可激活砺锋众创创客账号</p><a href=\\\"http://127.0.0.1:8888\\\">http://127.0.0.1:8888</a>", "1315283983@qq.com");
            this.sendEmail.sendMail("砺锋众创创客账号激活", "<p>感谢您激活砺锋众创创客账号</p><p>您的激活码为<span style='color:red'>" + token + "</span></p><p>验证码三十分钟内有效</p>", "1315283983@qq.com");
            HttpSession session = request.getSession();
            session.setAttribute(email, token);
            resultVo.setCode(CodeEnum._200.getCode());
            resultVo.setMsg("邮件发送成功");
        } catch (Throwable e) {
            resultVo.setCode(CodeEnum._500.getCode());
            resultVo.setMsg("系统错误邮件发送失败");
            e.printStackTrace();
        }
        return resultVo;
    }

    /*校验激活码*/
    @PostMapping("/user/regist/check_token")
    @ResponseBody
    public Object check_token(HttpServletRequest request, @RequestParam("token") String token, @RequestParam("email") String email) {
        ResultVo<User> result = new ResultVo<>();
        String right_token = (String) request.getSession().getAttribute(email);
        Boolean token_result = userService.check_token(token, right_token, email);
        if (token_result == true) {
            result.setCode(CodeEnum._200.getCode());
            result.setMsg("激活码校验成功");
            HttpSession session = request.getSession();
        } else {
            result.setCode(CodeEnum._500.getCode());
            result.setMsg("激活码校验失败");
        }
        return result;
    }

    /**
     * 用户退出登录
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping("/user/exit")
    public Object user_exit(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("login_user");
        ResultVo<User> resultVo = new ResultVo<User>(CodeEnum._200.getCode(), "exit success");
        return resultVo;
    }
}
