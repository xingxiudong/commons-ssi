package com.ebiz.ssi2.domain.support;

import java.util.List;

/**
 * <h4>Events</h4>
 * 
 * <p>Many events callback function can take the 'node' parameter, which contains following properties:</p>
 * 
 * <ul>
 * <li>id: An identity value bind to the node.</li>
 * <li>text: Text to be showed.</li>
 * <li>iconCls: The css class to display icon.</li>
 * <li>checked: Whether the node is checked.</li>
 * <li>state: The node state, 'open' or 'closed'.</li>
 * <li>attributes: Custom attributes bind to the node.</li>
 * <li>target: Target DOM object.</li>
 * </ul>
 * 
 * @author XingXiuDong
 * 
 */
public class TreeItem {
	private String id; // An identity value bind to the node.
	private String text; // Text to be showed.
	private String iconCls; // The css class to display icon.
	private String checked; // Whether the node is checked.
	private String state; // The node state, 'open' or 'closed'.
	private String attributes; // Custom attributes bind to the node.
	private String target; // Target DOM object.
	private List<TreeItem> children;
	
	private String par_id;
	
	public TreeItem() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
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

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public List<TreeItem> getChildren() {
		return children;
	}

	public void setChildren(List<TreeItem> children) {
		this.children = children;
	}

	public String getPar_id() {
		return par_id;
	}

	public void setPar_id(String par_id) {
		this.par_id = par_id;
	}

}
