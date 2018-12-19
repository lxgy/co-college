package net.seehope.college.service.impl;

import net.seehope.college.entity.User;
import net.seehope.college.mapper.UserMapper;
import net.seehope.college.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findUsers() {
        return this.userMapper.findUsers();
    }
}
