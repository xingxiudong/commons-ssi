package com.ebiz.comm.domain;

import java.io.Serializable;

import com.ebiz.ssi2.domain.Entity;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-29 19:22:51
 */
public class BaseType extends Entity implements Serializable {

	private static final long serialVersionUID = -1L;

	private Long type_id;
	
	private String type_name;
	
	private Long par_type_id;
	
	private Long order_value;
	
	private Integer is_del;
	
	public BaseType() {

	}

	/**
	 * @val 类型ID
	 */
	public Long getType_id() {
		return type_id;
	}
	
	/**
	 * @val 类型ID
	 */
	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}
	
	/**
	 * @val 类型名称
	 */
	public String getType_name() {
		return type_name;
	}
	
	/**
	 * @val 类型名称
	 */
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
	/**
	 * @val 父类型ID
	 */
	public Long getPar_type_id() {
		return par_type_id;
	}
	
	/**
	 * @val 父类型ID
	 */
	public void setPar_type_id(Long par_type_id) {
		this.par_type_id = par_type_id;
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