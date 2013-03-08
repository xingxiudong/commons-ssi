package com.ebiz.comm.domain;

import java.util.List;

import com.ebiz.ssi2.domain.Entity;

public class SysModule extends Entity {
	private static final long serialVersionUID = 1L;
	
	private Long mod_id;
	private Long par_id;
	private String mod_name;
	private String mod_desc;
	private String mod_url;
	private Integer is_public;
	private Long order_value;
	private Integer is_lock;
	private Integer is_del;
	
	List<SysModule> childrenList;

	public Long getMod_id() {
		return mod_id;
	}

	public void setMod_id(Long mod_id) {
		this.mod_id = mod_id;
	}

	public Long getPar_id() {
		return par_id;
	}

	public void setPar_id(Long par_id) {
		this.par_id = par_id;
	}

	public String getMod_name() {
		return mod_name;
	}

	public void setMod_name(String mod_name) {
		this.mod_name = mod_name;
	}

	public String getMod_desc() {
		return mod_desc;
	}

	public void setMod_desc(String mod_desc) {
		this.mod_desc = mod_desc;
	}

	public String getMod_url() {
		return mod_url;
	}

	public void setMod_url(String mod_url) {
		this.mod_url = mod_url;
	}

	public Integer getIs_public() {
		return is_public;
	}

	public void setIs_public(Integer is_public) {
		this.is_public = is_public;
	}

	public Long getOrder_value() {
		return order_value;
	}

	public void setOrder_value(Long order_value) {
		this.order_value = order_value;
	}

	public Integer getIs_lock() {
		return is_lock;
	}

	public void setIs_lock(Integer is_lock) {
		this.is_lock = is_lock;
	}

	public Integer getIs_del() {
		return is_del;
	}

	public void setIs_del(Integer is_del) {
		this.is_del = is_del;
	}

	public List<SysModule> getChildrenList() {
		return childrenList;
	}

	public void setChildrenList(List<SysModule> childrenList) {
		this.childrenList = childrenList;
	}

}
