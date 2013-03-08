package com.ebiz.comm.web.struts2.manager;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.ebiz.comm.domain.UserInfo;
import com.ebiz.comm.web.struts2.BaseController;
import com.opensymphony.xwork2.ModelDriven;

@Results({ @Result(name = "success", type = "redirectAction", params = { "actionName", "user-info" }) })
@ParentPackage("commons-default")
public class HomeController extends BaseController implements ModelDriven<UserInfo> {
	private static final long serialVersionUID = -3989121082608356150L;
	List<UserInfo> modelList;
	UserInfo model = new UserInfo();

	// GET /orders/1
	public HttpHeaders show() {
		return new DefaultHttpHeaders(show);
	}

	// GET /orders
	public HttpHeaders index() {
		return new DefaultHttpHeaders(index).disableCaching();
	}

	// GET /orders/1/edit
	public String edit() {
		return edit;
	}

	// GET /orders/new
	public String editNew() {
		return editNew;
	}

	// GET /orders/1/deleteConfirm
	public String deleteConfirm() {
		return deleteConfirm;
	}

	// DELETE /orders/1
	public String destroy() {
		super.getFacade().getUserInfoService().removeUserInfo(model);
		addActionMessage("UserInfo removed successfully.");
		return SUCCESS;
	}

	// POST /orders
	public HttpHeaders create() {
		return new DefaultHttpHeaders("success").setLocationId(model.getUser_id());
	}

	// PUT /orders/1
	public String update() {
		return SUCCESS;
	}

	public void validateCreate() {
	}

	public UserInfo getModel() {
		return model;
	}

	public List<UserInfo> getModelList() {
		return modelList;
	}

	public void setId(String id) {
	}
}
