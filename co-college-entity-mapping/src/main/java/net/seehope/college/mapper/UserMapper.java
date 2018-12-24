package net.seehope.college.mapper;

import net.seehope.college.entity.User;

import java.util.List;

/**
 * @BelongsProject: co-college
 * @BelongsPackage: net.seehope.college.mapper
 * @Author: lxgy
 * @CreateTime: 2018-12-12 20:53
 * @Description: ${Description}
 */
public interface UserMapper {

    public List<User> findUsers();

    public Integer getUserCount();
}
