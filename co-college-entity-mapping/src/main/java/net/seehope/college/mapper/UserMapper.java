package net.seehope.college.mapper;

import net.seehope.college.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

    public Integer get_user_by_email(@Param("email") String email);

    public void insert_user(User user);

    public void activate_user(@Param("email") String email);

    public User get_user_detail_by_email(@Param("email") String email);

    public void add_faile_time(User user);

    public void lock_user(@Param("email") String email);

    public void record_ip(@Param("email") String email,@Param("ip") String ip);
}
