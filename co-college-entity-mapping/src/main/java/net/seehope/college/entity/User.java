package net.seehope.college.entity;

import javax.naming.directory.SearchResult;
import java.io.Serializable;

/**
 * @BelongsProject: co-college
 * @BelongsPackage: net.seehope.college.entity
 * @Author: lxgy
 * @CreateTime: 2018-12-12 17:32
 * @Description: 用户实体信息.
 */
public class User implements Serializable {

    /*唯一主键ID*/
    private Integer id;
    /*创建时间*/
    private String create_time;
    /*更新时间*/
    private String update_time;
    /*用户名*/
    private String username;
    /*用户密码*/
    private String password;

    /*用户名，密码构造器初始化*/
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /*无参构造器*/
    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
