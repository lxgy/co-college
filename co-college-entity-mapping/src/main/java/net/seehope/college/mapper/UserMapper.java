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
    /**
     * 查询所有用户
     *
     * @return
     */
    public List<User> findUsers();

    /**
     * 获取用户数量
     *
     * @return
     */
    public Integer getUserCount();

    /**
     * 根据邮箱校验用户
     *
     * @param email
     * @return
     */
    public Integer get_user_by_email(@Param("email") String email);

    /**
     * 添加用户
     *
     * @param user
     */
    public void insert_user(User user);

    /**
     * 激活用户
     *
     * @param email
     */
    public void activate_user(@Param("email") String email);

    /**
     * 根据邮箱查询用户详情
     *
     * @param email
     * @return
     */
    public User get_user_detail_by_email(@Param("email") String email);

    /**
     * 记录登录失败次数
     *
     * @param user
     */
    public void add_faile_time(User user);

    /**
     * 锁定用户
     *
     * @param email
     */
    public void lock_user(@Param("email") String email);

    /**
     * 记录登录ip
     *
     * @param email
     * @param ip
     */
    public void record_ip(@Param("email") String email, @Param("ip") String ip);
}
