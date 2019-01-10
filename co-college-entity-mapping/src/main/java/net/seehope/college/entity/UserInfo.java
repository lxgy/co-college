package net.seehope.college.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @BelongsProject: co-college
 * @BelongsPackage: net.seehope.college.entity
 * @Author: lxgy
 * @CreateTime: 2018-12-12 17:32
 * @Description: 用户实体信息补充.
 * @TableName t_user_info
 */
public class UserInfo implements Serializable {

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
	/* 头像地址 */
	private String photo;
	/* qq号 */
	private String qq_num;
	/* 微信号 */
	private String wechat;
	/* 性别 */
	private Integer sex;
	/* 电话号码 */
	private String phone;
	/* 用户主信息 */
	private User user;

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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getQq_num() {
		return qq_num;
	}

	public void setQq_num(String qq_num) {
		this.qq_num = qq_num;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
