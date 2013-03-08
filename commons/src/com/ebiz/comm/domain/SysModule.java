package com.ebiz.comm.domain;

import java.io.Serializable;
import java.util.List;

import com.ebiz.ssi2.domain.Entity;

/**
 * This class is pruduct by Coder-AutoGenerator.
 * 
 * @author SSI2Generator
 * @date 2012-07-29 19:22:51
 */
public class SysModule extends Entity implements Serializable {

	private static final long serialVersionUID = -1L;

	private Long mod_id;

	private Long par_id;

	private String mod_name;

	private String mod_desc;

	private String mod_url;

	private Integer is_public;

	private Long order_value;

	private Integer is_lock;

	private Integer is_del;
	
	private List<SysModule> children;

	public SysModule() {

	}

	/**
	 * @val 类型ID
	 */
	public Long getMod_id() {
		return mod_id;
	}

	/**
	 * @val 类型ID
	 */
	public void setMod_id(Long mod_id) {
		this.mod_id = mod_id;
	}

	/**
	 * @val 类型名称
	 */
	public Long getPar_id() {
		return par_id;
	}

	/**
	 * @val 类型名称
	 */
	public void setPar_id(Long par_id) {
		this.par_id = par_id;
	}

	/**
	 * @val 父类型ID
	 */
	public String getMod_name() {
		return mod_name;
	}

	/**
	 * @val 父类型ID
	 */
	public void setMod_name(String mod_name) {
		this.mod_name = mod_name;
	}

	/**
	 * @val 模块说明
	 */
	public String getMod_desc() {
		return mod_desc;
	}

	/**
	 * @val 模块说明
	 */
	public void setMod_desc(String mod_desc) {
		this.mod_desc = mod_desc;
	}

	/**
	 * @val 链接地址
	 */
	public String getMod_url() {
		return mod_url;
	}

	/**
	 * @val 链接地址
	 */
	public void setMod_url(String mod_url) {
		this.mod_url = mod_url;
	}

	/**
	 * @val 是否公共
	 */
	public Integer getIs_public() {
		return is_public;
	}

	/**
	 * @val 是否公共
	 */
	public void setIs_public(Integer is_public) {
		this.is_public = is_public;
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
	 * @val 是否锁定
	 */
	public Integer getIs_lock() {
		return is_lock;
	}

	/**
	 * @val 是否锁定
	 */
	public void setIs_lock(Integer is_lock) {
		this.is_lock = is_lock;
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

	public List<SysModule> getChildren() {
		return children;
	}

	public void setChildren(List<SysModule> children) {
		this.children = children;
	}

}