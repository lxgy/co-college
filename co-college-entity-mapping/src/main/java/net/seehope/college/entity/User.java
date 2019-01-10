package net.seehope.college.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @BelongsProject: co-college
 * @BelongsPackage: net.seehope.college.entity
 * @Author: lxgy
 * @CreateTime: 2018-12-12 17:32
 * @Description: 用户实体信息.
 * @TableName t_user
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* 唯一主键ID */
	@JsonIgnore
	private Integer id;
	/* 创建时间 */
	private String create_time;
	/* 更新时间 */
	private String update_time;
	/* 用户名 */
	private String username;
	/* 用户密码 */
	@JsonIgnore
	private String password;
	/* 邮箱 */
	private String email;
	/* 账号是否被锁定（0：未锁状态 1：已锁状态） */
	private Integer is_lock;
	/* 账号是否已经激活（0:未激活 1：已激活） */
	private Integer is_active;
	/* 账号登录ip地址 */
	@JsonIgnore
	private String login_ip;
	/* 账号登录失败次数 */
	private Integer login_faile;
	/* 账号类型：0：管理员 1：创客用户 */
	private Integer type;
	/* 用户详情信息 */
	private UserInfo user_info;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIs_lock() {
		return is_lock;
	}

	public void setIs_lock(Integer is_lock) {
		this.is_lock = is_lock;
	}

	public Integer getIs_active() {
		return is_active;
	}

	public void setIs_active(Integer is_active) {
		this.is_active = is_active;
	}

	public String getLogin_ip() {
		return login_ip;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	public Integer getLogin_faile() {
		return login_faile;
	}

	public void setLogin_faile(Integer login_faile) {
		this.login_faile = login_faile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* 用户名，密码构造器初始化 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/* 无参构造器 */
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", create_time=" + create_time + ", update_time=" + update_time + ", username="
				+ username + ", password=" + password + ", email=" + email + ", is_lock=" + is_lock + ", is_active="
				+ is_active + ", login_ip=" + login_ip + ", login_faile=" + login_faile + ", type=" + type + "]";
	}

	public UserInfo getUser_info() {
		return user_info;
	}

	public void setUser_info(UserInfo user_info) {
		this.user_info = user_info;
	}

}
