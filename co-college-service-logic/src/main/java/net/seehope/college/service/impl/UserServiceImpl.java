package net.seehope.college.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.seehope.college.entity.User;
import net.seehope.college.mapper.UserMapper;
import net.seehope.college.service.UserService;
import net.seehope.college.util.date.DateTimeUtil;

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
		if(count != 0) {
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
}
