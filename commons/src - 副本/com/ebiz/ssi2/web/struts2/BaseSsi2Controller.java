package com.ebiz.ssi2.web.struts2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ebiz.ssi2.domain.support.Pager;
import com.opensymphony.xwork2.ActionSupport;

public class BaseSsi2Controller extends ActionSupport {
	protected static final Logger logger = LoggerFactory.getLogger(BaseSsi2Controller.class);
	private static final long serialVersionUID = 1L;
	
	public static final String input = "input";
	public static final String back = "back";
	public static final String cancel = "cancel";
	public static final String browse = "browse";
	public static final String index = "index";
	public static final String show = "show";
	public static final String edit = "edit";
	public static final String editNew = "editNew";
	public static final String deleteConfirm = "deleteConfirm";

	protected String id;

	protected Pager pager = new Pager();

	public void setId(String id) {
		this.id = id;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
}
