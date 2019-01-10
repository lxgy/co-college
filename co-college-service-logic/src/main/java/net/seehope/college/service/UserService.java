package net.seehope.college.service;

import net.seehope.college.entity.User;

import java.util.List;

/**
 * @BelongsProject: co-college
 * @BelongsPackage: net.seehope.college.service
 * @Author: lxgy
 * @CreateTime: 2018-12-12 20:23
 * @Description: ${Description}
 */
public interface UserService {

    public List<User> findUsers();

    public Integer getUserCount();
    
    public boolean get_user_by_email(String email);
    
    public boolean add_user(User user);
}
