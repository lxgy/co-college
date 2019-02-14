package net.seehope.college.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * @BelongsProject: co-college
 * @BelongsPackage: net.seehope.college.entity
 * @Author: xu
 * @CreateTime: 2018-12-12 17:32
 * @Description: 留言实体信息.
 * @TableName t_message
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    /* 唯一主键ID */
    private Integer message_id;
    /*用户id*/
    private Integer id;
    /* 创建时间 */
    private String create_time;
    /* 留言内容 */
    private String message_content;
    /* 留言ip */
    private String message_ip;
    /* 留言时间 */
    private String message_date;
    /* 联系方式 */
    private String phone;


    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public String getMessage_ip() {
        return message_ip;
    }

    public void setMessage_ip(String message_ip) {
        this.message_ip = message_ip;
    }

    public String getMessage_date() {
        return message_date;
    }

    public void setMessage_date(String message_date) {
        this.message_date = message_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Message() {
    	
    }
    public Message(Integer message_id, Integer id, String create_time, String message_content, String message_ip, String message_date, String phone) {
        this.message_id = message_id;
        this.id = id;
        this.create_time = create_time;
        this.message_content = message_content;
        this.message_ip = message_ip;
        this.message_date = message_date;
        this.phone = phone;
    }

    public Message(Integer message_id) {
        this.message_id = message_id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", id=" + id +
                ", create_time='" + create_time + '\'' +
                ", message_content='" + message_content + '\'' +
                ", message_ip='" + message_ip + '\'' +
                ", message_date='" + message_date + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}