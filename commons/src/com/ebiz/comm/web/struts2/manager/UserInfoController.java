package com.ebiz.comm.web.struts2.manager;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.ebiz.comm.domain.UserInfo;
import com.ebiz.comm.web.struts2.BaseController;
import com.ebiz.comm.web.struts2.Constants;
import com.ebiz.ssi2.domain.support.jqueryeasyui.Pager;
import com.opensymphony.xwork2.ModelDriven;

@Results({
		@Result(name = "success", type = "redirectAction", params = { "actionName", "user-info", "queryString",
				"${queryString}" }),
		@Result(name = "input", type = "dispatcher", location = "/WEB-INF/pages/jsp/manager/user-info-editNew.jsp") })
@ParentPackage("commons-default")
public class UserInfoController extends BaseController implements ModelDriven<Object> {
	private static final long serialVersionUID = -3989121082608356150L;
	List<UserInfo> modelList;
	Pager pager;
	UserInfo model = new UserInfo();

	// GET /orders/1
	public HttpHeaders show() {
		return new DefaultHttpHeaders(show);
	}

	// GET /orders
	public HttpHeaders index() throws UnsupportedEncodingException {

		// old request page
		// Long recordCount =
		// super.getFacade().getUserInfoService().getUserInfoCount(model);
		// pager.init(recordCount, pager.getPageSize(), pager.getRequestPage());
		// model.getRow().setFirst(pager.getFirstRow());
		// model.getRow().setCount(pager.getRowCount());
		// modelList =
		// super.getFacade().getUserInfoService().getUserInfoPaginatedList(model);

		// New request page below.
		logger.info("QueryString : {}", model.getQueryString());

		// get request parameters what is not in model.
		if (null != model.getQueryString()) {
			super.deserialize(URLDecoder.decode(model.getQueryString(), Constants.SYS_ENCODING), model);
		}
		String user_name_like = model.getParam().get("user_name_like");

		// reset parameters.
		if (null != user_name_like) {
			user_name_like = URLDecoder.decode(user_name_like, Constants.SYS_ENCODING);
			model.getParam().put("user_name_like", user_name_like);
		}
		//super.decodeParams(model, Constants.SYS_ENCODING);

		// query total count.
		Long recordCount = super.getFacade().getUserInfoService().getUserInfoCount(model);

		// pager initialize.
		pager = new Pager(recordCount, model.getPage(), model.getRows(), model.getOrder(), model.getSort());
		
		// query list.
		model.getRow().setFirst(pager.getOffset()); 
		model.getRow().setCount(pager.getPageSize());
		model.getRow().setOrder(pager.getOrder());
		model.getRow().setSort(pager.getSort());
		logger.info("Request Page Row:{}", model.getRow());

		modelList = super.getFacade().getUserInfoService().getUserInfoPaginatedList(model);
		
		pager.setRows(modelList);
		
		Map m = super.describe(model);
		m.put("param", model.getParam());
		pager.setQuery(m);
		
		logger.info("###########################################   Query Parameters :{}", pager.getQuery());

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

	public Object getModel() {
		return (pager == null ? model : pager);
	}

	public void setId(String id) {
		if (StringUtils.isNotBlank(id)) {
			model = super.getFacade().getUserInfoService().getUserInfo(new UserInfo(id));
		}

		if (null == model) {
			model = new UserInfo();
		}

		try {
			if (null != model.getQueryString()) {
				model.setQueryString(URLEncoder.encode(model.getQueryString(), Constants.SYS_ENCODING));
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("UnsupportedEncodingException : {}, StackTrace: {}", e.getMessage(), e.getStackTrace());
		}

		super.setId(id);
	}

}
