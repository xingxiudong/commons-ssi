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
public class RoleInfo extends Entity implements Serializable {

	private static final long serialVersionUID = -1L;

	private Long role_id;
	
	private String role_name;
	
	private Long order_value;
	
	private Date add_date;
	
	private Integer is_del;
	
	public RoleInfo() {

	}

	/**
	 * @val 角色ID
	 */
	public Long getRole_id() {
		return role_id;
	}
	
	/**
	 * @val 角色ID
	 */
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	
	/**
	 * @val 角色名称
	 */
	public String getRole_name() {
		return role_name;
	}
	
	/**
	 * @val 角色名称
	 */
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	/**
	 * @val 排序值
	 */
	public Long getOrder_value() {
		return order_value;
	}
	
	/**
	 * @val 排序值
	 */
	public void setOrder_value(Long order_value) {
		this.order_value = order_value;
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
	
}