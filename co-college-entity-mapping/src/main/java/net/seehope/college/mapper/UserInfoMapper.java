package net.seehope.college.mapper;

import net.seehope.college.entity.UserInfo;

public interface UserInfoMapper {

    /**
     * 增加用户信息
     * @param info
     * @return
     */
    public Integer saveUserDetail(UserInfo info);
}
