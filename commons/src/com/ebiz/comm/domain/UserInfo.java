package com.ebiz.comm.domain;

import java.io.Serializable;
import java.util.Date;

import com.ebiz.ssi2.domain.Entity;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-29 19:22:51
 */
public class UserInfo extends Entity implements Serializable {

	private static final long serialVersionUID = -1L;

	private Integer user_id;
	
	private String user_name;
	
	private String pass_word;
	
	private String real_name;
	
	private String email;
	
	private Long sex;
	
	private Date birthday;
	
	private String tel;
	
	private String mobile;
	
	private Long p_index;
	
	private String addr;
	
	private String qq;
	
	private String msn;
	
	private Long login_count;
	
	private Date last_login_date;
	
	private String last_login_ip;
	
	private Integer is_del;
	
	private Integer is_active;
	
	private String active_code;
	
	private Date add_date;
	
	public UserInfo() {

	}
	
	public UserInfo(String user_id) {
		this.user_id = Integer.valueOf(user_id);
	}

	/**
	 * @val 用户ID
	 */
	public Integer getUser_id() {
		return user_id;
	}
	
	/**
	 * @val 用户ID
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	/**
	 * @val 用户名
	 */
	public String getUser_name() {
		return user_name;
	}
	
	/**
	 * @val 用户名
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	/**
	 * @val 密码
	 */
	public String getPass_word() {
		return pass_word;
	}
	
	/**
	 * @val 密码
	 */
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	
	/**
	 * @val 真实姓名
	 */
	public String getReal_name() {
		return real_name;
	}
	
	/**
	 * @val 真实姓名
	 */
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	
	/**
	 * @val 电子邮箱
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @val 电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @val 性别
	 */
	public Long getSex() {
		return sex;
	}
	
	/**
	 * @val 性别
	 */
	public void setSex(Long sex) {
		this.sex = sex;
	}
	
	/**
	 * @val 生日
	 */
	public Date getBirthday() {
		return birthday;
	}
	
	/**
	 * @val 生日
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * @val 电话
	 */
	public String getTel() {
		return tel;
	}
	
	/**
	 * @val 电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * @val 手机
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * @val 手机
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * @val 地区编码
	 */
	public Long getP_index() {
		return p_index;
	}
	
	/**
	 * @val 地区编码
	 */
	public void setP_index(Long p_index) {
		this.p_index = p_index;
	}
	
	/**
	 * @val 街道地址
	 */
	public String getAddr() {
		return addr;
	}
	
	/**
	 * @val 街道地址
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	/**
	 * @val QQ
	 */
	public String getQq() {
		return qq;
	}
	
	/**
	 * @val QQ
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	/**
	 * @val MSN
	 */
	public String getMsn() {
		return msn;
	}
	
	/**
	 * @val MSN
	 */
	public void setMsn(String msn) {
		this.msn = msn;
	}
	
	/**
	 * @val 登录次数
	 */
	public Long getLogin_count() {
		return login_count;
	}
	
	/**
	 * @val 登录次数
	 */
	public void setLogin_count(Long login_count) {
		this.login_count = login_count;
	}
	
	/**
	 * @val 最后登录时间
	 */
	public Date getLast_login_date() {
		return last_login_date;
	}
	
	/**
	 * @val 最后登录时间
	 */
	public void setLast_login_date(Date last_login_date) {
		this.last_login_date = last_login_date;
	}
	
	/**
	 * @val 最后登录IP
	 */
	public String getLast_login_ip() {
		return last_login_ip;
	}
	
	/**
	 * @val 最后登录IP
	 */
	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}
	
	/**
	 * @val 是否删除
	 */
	public Integer getIs_del() {
		return is_del;
	}
	
	/**
	 * @val 是否删除
	 */
	public void setIs_del(Integer is_del) {
		this.is_del = is_del;
	}
	
	/**
	 * @val 是否激活
	 */
	public Integer getIs_active() {
		return is_active;
	}
	
	/**
	 * @val 是否激活
	 */
	public void setIs_active(Integer is_active) {
		this.is_active = is_active;
	}
	
	/**
	 * @val 激活码
	 */
	public String getActive_code() {
		return active_code;
	}
	
	/**
	 * @val 激活码
	 */
	public void setActive_code(String active_code) {
		this.active_code = active_code;
	}
	
	/**
	 * @val 添加时间
	 */
	public Date getAdd_date() {
		return add_date;
	}
	
	/**
	 * @val 添加时间
	 */
	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}
	
}