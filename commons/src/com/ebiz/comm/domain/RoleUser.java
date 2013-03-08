package com.ebiz.comm.domain;

import java.io.Serializable;

import com.ebiz.ssi2.domain.Entity;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-29 19:22:51
 */
public class RoleUser extends Entity implements Serializable {

	private static final long serialVersionUID = -1L;

	private Long user_id;
	
	private Long role_id;
	
	public RoleUser() {

	}

	/**
	 * @val 用户ID
	 */
	public Long getUser_id() {
		return user_id;
	}
	
	/**
	 * @val 用户ID
	 */
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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
	
}