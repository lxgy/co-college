package net.seehope.college.mapper;

import net.seehope.college.entity.Message;
import net.seehope.college.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: co-college
 * @BelongsPackage: net.seehope.college.mapper
 * @Author: xu
 * @CreateTime: 2018-12-12 20:53
 * @Description: ${Description}
 */
public interface MessageMapper {
    /*获取所有用户*/
    public List<Message> getAllMessage();
    /*添加留言*/
    public void addMessage(Message message);
}
