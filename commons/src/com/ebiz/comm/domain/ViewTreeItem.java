package com.ebiz.comm.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ebiz.ssi2.domain.Entity;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-30 00:49:39
 */
public class ViewTreeItem extends Entity implements Serializable {

	private static final long serialVersionUID = -1L;

	private Long id;
	
	private Long par_id;
	
	private String text;
	
	private String target;
	
	private String checked;
	
	private String state;
	
	private String icon_cls;
	
	private Map<String, Object> attributes;
	
	private List<ViewTreeItem> children;
	
	public ViewTreeItem() {

	}
	
	public ViewTreeItem(String id) {
		this.id = Long.valueOf(id);
	}

	/**
	 * @val 类型ID
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @val 类型ID
	 */
	public void setId(Long id) {
		this.id = id;
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
	public String getText() {
		return text;
	}
	
	/**
	 * @val 父类型ID
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * @val 链接地址
	 */
	public String getTarget() {
		return target;
	}
	
	/**
	 * @val 链接地址
	 */
	public void setTarget(String target) {
		this.target = target;
	}
	
	public String getChecked() {
		return checked;
	}
	
	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getIcon_cls() {
		return icon_cls;
	}
	
	public void setIcon_cls(String icon_cls) {
		this.icon_cls = icon_cls;
	}

	public List<ViewTreeItem> getChildren() {
		return children;
	}

	public void setChildren(List<ViewTreeItem> children) {
		this.children = children;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
}