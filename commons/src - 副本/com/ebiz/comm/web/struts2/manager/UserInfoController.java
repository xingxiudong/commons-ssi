package com.ebiz.comm.web.struts2.manager;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.ebiz.comm.domain.UserInfo;
import com.ebiz.comm.web.struts2.BaseController;
import com.opensymphony.xwork2.ModelDriven;

@Results({ @Result(name = "success", type = "redirectAction", params = { "actionName", "user-info" }),
	@Result(name = "input", type="dispatcher", location="/WEB-INF/pages/jsp/manager/user-info-editNew.jsp")})
@ParentPackage("commons-default")
public class UserInfoController extends BaseController implements ModelDriven<UserInfo> {
	private static final long serialVersionUID = -3989121082608356150L;
	List<UserInfo> modelList;
	UserInfo model = new UserInfo();

	// GET /orders/1
	public HttpHeaders show() {
		return new DefaultHttpHeaders(show);
	}

	// GET /orders
	public HttpHeaders index() {
		Long recordCount = super.getFacade().getUserInfoService().getUserInfoCount(model);
		pager.init(recordCount, pager.getPageSize(), pager.getRequestPage());
		model.getRow().setFirst(pager.getFirstRow());
		model.getRow().setCount(pager.getRowCount());

		// modelList = super.getFacade().getUserInfoService().getUserInfoList(model);
		modelList = super.getFacade().getUserInfoService().getUserInfoPaginatedList(model);

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
		logger.info("########Birthday : {}", DateFormatUtils.format(model.getBirthday(), "yyyy-MM-dd"));
		super.getFacade().getUserInfoService().createUserInfo(model);
		addActionMessage("New UserInfo created successfully.");
		return new DefaultHttpHeaders("success").setLocationId(model.getUser_id());
	}

	// PUT /orders/1
	public String update() {
		super.getFacade().getUserInfoService().modifyUserInfo(model);
		addActionMessage("UserInfo updated successfully.");
		return SUCCESS;
	}

	public void validateCreate() {
		logger.info("Entering validateCreate");
		if (StringUtils.isBlank(model.getUser_name())) {
			addFieldError("user_name", getText("errors.required", "user_name"));
		}
		if (StringUtils.isBlank(model.getPass_word())) {
			addFieldError("pass_word", getText("errors.required", "user_name"));
		}
	}

	public UserInfo getModel() {
		return model;
	}

	public List<UserInfo> getModelList() {
		return modelList;
	}

	public void setId(String id) {
		logger.debug("Set request id : {}", id);
		Field[] f = model.getClass().getDeclaredFields();
		Class<?> idType = null;
		for (int i = 0; i < f.length; i++) {
			if ("user_id".equals(f[i].getName())) {
				idType = f[i].getType();
			}
		}
		logger.info("Model {} type is : {}", "user_name", idType);

		if (id != null) {
			UserInfo entity = new UserInfo();
			entity.setUser_id(Long.valueOf(id));
			this.model = super.getFacade().getUserInfoService().getUserInfo(entity);
		}
		super.setId(id);
	}
}
