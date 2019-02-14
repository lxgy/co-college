package net.seehope.college.front.controller;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.seehope.college.entity.UserInfo;
import net.seehope.college.mapper.UserInfoMapper;
import net.seehope.college.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.seehope.college.core.CodeEnum;
import net.seehope.college.email.SendEmail;
import net.seehope.college.entity.Message;
import net.seehope.college.entity.User;
import net.seehope.college.service.MessageService;
import net.seehope.college.service.UserService;
import net.seehope.college.util.date.DateTimeUtil;
import net.seehope.college.util.security.BcryptEncodeUtil;
import net.seehope.college.util.uuid.UUIDUtil;
import net.seehope.college.vo.ResultVo;

import java.util.Date;
import java.util.List;

@Controller
public class FrontUserController {
    @Resource
    UserMapper mapper;

    @Resource
    UserInfoMapper infoMapper;

    @Resource
    private UserService userService;

    @Resource
    private MessageService messageService;

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
        boolean result = this.userService.add_user(user);
        resultVo.setData(user);
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
    public Object user_login(HttpServletResponse response, User user, String isRe) {
        ResultVo<User> resultVo = this.userService.user_login(user.getUsername(), user.getPassword());
//        if (resultVo.getCode() == 200 && isRe.equals(("on"))) {
//            Cookie cookie;
//            if (user.getUsername() != null) {
//                cookie = new Cookie("ci_account", user.getUsername());
//            } else {
//                cookie = new Cookie("ci_account", user.getEmail());
//            }
//            response.addCookie(cookie);
//        }
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
        HttpSession session = request.getSession();
        if (session.getAttribute("token_time") == null || new Date().getTime() - (long) session.getAttribute("token_time") > 60000) {
            try {
                token = UUIDUtil.get_uuid_intercept(5);
//		this.sendEmail.sendMail("砺锋众创创客账号激活", "<p>点击该链接即可激活砺锋众创创客账号</p><a href=\\\"http://127.0.0.1:8888\\\">http://127.0.0.1:8888</a>", "1315283983@qq.com");
                this.sendEmail.sendMail("砺锋众创创客账号激活", "<div align=\"center\" id=\"bodyCell\" valign=\"top\">\n" +
                        "\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"templateContainer\" style=\"border: 0px solid rgb(0, 0, 0);\" width=\"600\">\n" +
                        "\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t<td align=\"center\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"templatePreheader\" width=\"100%\">\n" +
                        "\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<td align=\"center\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"templateContainer\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"preheaderContainer tpl-container dragTarget\" data-container=\"preheader\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"tpl-block tpl-image\" style=\"margin-top: 0px; margin-bottom: 0px; border: 0px solid rgb(26, 188, 156); border-radius: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-attach-point=\"containerNode\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"imageBlock\" width=\"100%\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody class=\"imageBlockOuter\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"imageBlockInner\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"imageContentContainer\" width=\"100%\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" class=\"imageContent\" style=\"padding: 0px; text-align: -webkit-center; background-color: rgb(255, 255, 255);\" valign=\"top\"><img src=\"https://www.seehope.net/index/images/p1.jpg\" width=\"600px \" style=\"border-bottom: 2px solid #00b0ff;\"></td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t<td align=\"center\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"templateHeader\" width=\"100%\">\n" +
                        "\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<td align=\"center\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"templateContainer\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"headerContainer tpl-container dragTarget\" data-container=\"header\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"block tpl-block text-block\" style=\"margin-top: 0px; margin-bottom: 0px; border: 0px solid rgb(0, 0, 0); border-radius: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-attach-point=\"containerNode\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"textBlock\" width=\"100%\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody class=\"textBlockOuter\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"textBlockInner\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"textContentContainer\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" class=\"textContent\" style=\"padding: 10px 25px; text-align: left; background-color: rgb(255, 255, 255);\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"box-sizing: border-box; margin: 0px 0px 10px; font-family: 'Microsoft YaHei', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p>尊敬的用户：</p>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p>您好！</p>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p>您的验证码是" + token + "，请在邮箱验证页面输入验证码完成帐号激活。</p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"tpl-block tpl-text\" style=\"margin-top: 0px; margin-bottom: 0px; border: 0px solid rgb(0, 0, 0); border-radius: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-attach-point=\"containerNode\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"textBlock\" width=\"100%\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody class=\"textBlockOuter\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"textBlockInner\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"textContentContainer\" width=\"100%\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" class=\"textContent\" style=\"padding: 5px 0px; text-align: left; background: rgb(255, 255, 255);\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"text-align: center;\"><strong><span style=\"color:#1ABC9C;\"><span style=\"font-family:microsoft yahei;\">砺锋众创学院</span></span></strong></div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t<td align=\"center\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"templateBody\" width=\"100%\">\n" +
                        "\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<td align=\"center\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"templateContainer\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"bodyContainer tpl-container dragTarget\" data-container=\"body\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ghost-source\">&nbsp;</div>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"tpl-block tpl-divider\" style=\"margin-top: 0px; margin-bottom: 0px; border: 0px solid rgb(0, 0, 0); border-radius: 0px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-attach-point=\"containerNode\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"dividerBlock\" width=\"100%\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody class=\"dividerBlockOuter\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"dividerBlockInner\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"dividerContentContainer\" width=\"100%\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" class=\"dividerContent\" style=\"margin-top: 10px; margin-bottom: 15px; padding: 10px 25px; text-align: start; background-color: rgb(255, 255, 255);\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:100%;height:1px;background: rgb(153, 153, 153);\">&nbsp;</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t<td align=\"center\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"templateFooter\" width=\"100%\">\n" +
                        "\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t<td align=\"center\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"templateContainer\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"footerContainer tpl-container dragTarget\" data-container=\"footer\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"block tpl-block text-block\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-attach-point=\"containerNode\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"textBlock\" width=\"100%\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody class=\"textBlockOuter\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"textBlockInner\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"textContentContainer\" width=\"600\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"textContent\" style=\"padding-top:9px; padding-right: 18px; padding-bottom: 9px; padding-left: 18px;background-color:#ffffff\" valign=\"top\">\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"text-align: center;\"><span style=\"font-family:microsoft yahei; font-size:8px;  \">@ 2018 - 2019 砺锋信息科技有限公司 版权所有 | 粤ICP备16114193号-1<br>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t</tbody>\n" +
                        "\t\t\t</table>\n" +
                        "\t\t</div>", "1315283983@qq.com");

                session.setAttribute(email, token);
                session.setAttribute("token_time", new Date().getTime());
                resultVo.setCode(CodeEnum._200.getCode());
                resultVo.setMsg("邮件发送成功");
            } catch (Throwable e) {
                resultVo.setCode(CodeEnum._500.getCode());
                resultVo.setMsg("系统错误邮件发送失败");
                e.printStackTrace();
            }
        } else {
            resultVo.setCode(CodeEnum._500.getCode());
            resultVo.setMsg("距离上次发送不足1分钟 请稍后重试");
        }
        return resultVo;
    }

    /**
     * 校验激活码
     * @param request
     * @param token
     * @param email
     * @return
     */
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
     *
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

    /**
     * 添加留言
     * @param message
     * @return
     */
    @ResponseBody
    @GetMapping("/message/add")
    public Object message_add(Message message) {
        ResultVo<Message> resultVo = new ResultVo<>();
        try {
            messageService.addMessage(message);
            resultVo.setCode(CodeEnum._200.getCode());
            resultVo.setMsg("发送成功");
        } catch (Exception e) {
            resultVo.setCode(CodeEnum._500.getCode());
            e.printStackTrace();
            resultVo.setMsg("系统错误 请稍后重试");
        }
        return resultVo;
    }
}
