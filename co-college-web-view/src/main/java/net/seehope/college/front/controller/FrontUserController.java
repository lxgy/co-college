package net.seehope.college.front.controller;

import javax.annotation.Resource;

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
		boolean result = this.userService.add_user(user);
		if(!result) {
			resultVo.setCode(CodeEnum._500.getCode());
			resultVo.setMsg("regist faile please try again");
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
	public String test_send_email() {
		this.sendEmail.sendMail("测试", "<a href='127.0.0.1:8888'>点我跳转</a>", "1058378595@qq.com");
		return "";
	}

}
