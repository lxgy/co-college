package net.seehope.college.front.controller;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		user.setIs_lock(0);
		user.setType(1);
		resultVo.setData(user);
		boolean result = this.userService.add_user(user);
		if(!result) {
			resultVo.setCode(CodeEnum._500.getCode());
			resultVo.setMsg("regist faile please try again");
			resultVo.setData(null);
		}
		return resultVo;
	}

	/**
	 * 用户登录操作
	 * @param user
	 * @return
	 */
	@PostMapping("/user/login")
	@ResponseBody
	public Object user_login(User user) {
		ResultVo<User> resultVo = new ResultVo<User>(CodeEnum._200.getCode(), "login success");
		return resultVo;
	}

	/**
	 * 邮箱验证是否已被注册.
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
	
	@GetMapping("/send_email")
	@ResponseBody
	public String test_send_email() throws MessagingException {
		this.sendEmail.sendMail("测试", "<p>点击该链接即可激活砺锋众创创客账号</p><a href=\\\"http://127.0.0.1:8888\\\">http://127.0.0.1:8888", "1058378595@qq.com");
		return "发送成功";
	}

}
