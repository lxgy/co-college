package net.seehope.college.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.seehope.college.core.CodeEnum;
import net.seehope.college.entity.User;
import net.seehope.college.mapper.UserMapper;
import net.seehope.college.service.UserService;
import net.seehope.college.util.date.DateTimeUtil;
import net.seehope.college.util.http.GetIpUtil;
import net.seehope.college.util.security.BcryptEncodeUtil;
import net.seehope.college.vo.ResultVo;

/**
 * @BelongsProject: co-college
 * @BelongsPackage: net.seehope.college.service.impl
 * @Author: lxgy
 * @CreateTime: 2018-12-12 20:23
 * @Description: ${Description}
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private HttpServletRequest request;

    @Override
    public List<User> findUsers() {
        return this.userMapper.findUsers();
    }

    @Override
    public Integer getUserCount() {
        return this.userMapper.getUserCount();
    }

    /**
     * 通过邮箱获取用户.
     */
    @Override
    public boolean get_user_by_email(String email) {
        // TODO Auto-generated method stub
        int count = this.userMapper.get_user_by_email(email);
        if (count != 0) {
            return true;
        }
        return false;
    }

    /**
     * 添加用户.
     */
    @Override
    public boolean add_user(User user) {
        // TODO Auto-generated method stub
        boolean result = false;
        try {
            user.setLogin_ip(GetIpUtil.getIpAddr(request));
            user.setCreate_time(DateTimeUtil.getCurrentDate());
            this.userMapper.insert_user(user);
            log.info("邮箱为：" + user.getEmail() + DateTimeUtil.getCurrentDateTime() + "成功注册为创客用户");
            result = true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            log.info("邮箱为：" + user.getEmail() + DateTimeUtil.getCurrentDateTime() + "注册创客用户失败");
        }
        return result;
    }

    /**
     * 校验激活码
     */
    @Override
    public boolean check_token(String right_token, String token, String email) {
        if (right_token.equals(token)) {
            log.info("邮箱为" + email + "的用户校验激活码成功");
            this.userMapper.activate_user(email);
            log.info("邮箱为" + email + "的用户激活成功");
            HttpSession session = request.getSession();
            User user = this.userMapper.get_user_detail_by_email(email);
            session.setAttribute("login_user", user.getUsername());

            return true;
        } else {
            log.info("邮箱为" + email + "的用户校验激活码错误");
            return false;
        }
    }

    /**
     * 用户登录校验
     *
     * @param email
     * @return
     */
    @Override
    public ResultVo<User> user_login(String email, String password) {
        HttpSession session = request.getSession();
        User user = this.userMapper.get_user_detail_by_email(email);
        boolean result = BcryptEncodeUtil.decode(password, user.getPassword());
        ResultVo<User> resultVo = new ResultVo<>();
        if (user.getIs_lock() == 0) {
            if (result) {
                user.setLogin_faile(0);
                this.userMapper.add_faile_time(user);
                session.setAttribute("login_user", user.getUsername());
                session.setAttribute("user_photo",user.getUser_info().getPhoto());
                resultVo.setCode(CodeEnum._200.getCode());
                resultVo.setMsg("登录校验成功");
                userMapper.record_ip(email, GetIpUtil.getIpAddr(request));
            } else {
                int time = user.getLogin_faile() + 1;
                user.setLogin_faile(time);
                this.userMapper.add_faile_time(user);
                resultVo.setCode(CodeEnum._500.getCode());
                if (time < 5) {
                    resultVo.setMsg("账号或密码不正确 请重试");
                } else if (time == 10) {
                    resultVo.setMsg("登录失败 您的账号已锁定");
                    userMapper.lock_user(email);
                    log.info("账号" + email + "密码错误多次，已锁定");
                } else {
                    resultVo.setMsg("登录失败 您还有" + (10 - time) + "次机会");
                }
            }
        } else {
            resultVo.setCode(CodeEnum._500.getCode());
            resultVo.setMsg("您的账号已锁定 请联系管理员");
        }
        /*if (user.getLogin_faile() < 10) {
            if (result) {
                session.setAttribute("login_user", user.getUsername());
                return true;
            } else {
                return false;
            }
        } else {

        }*/
        return resultVo;
    }
}
