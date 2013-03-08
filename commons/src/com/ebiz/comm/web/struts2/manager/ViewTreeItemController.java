package com.ebiz.comm.web.struts2.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.ebiz.comm.domain.ViewTreeItem;
import com.ebiz.comm.web.struts2.BaseController;
import com.opensymphony.xwork2.ModelDriven;

public class ViewTreeItemController extends BaseController implements ModelDriven<Object> {
	private static final long serialVersionUID = -3989121082608356150L;
	
	List<ViewTreeItem> modelList = new ArrayList<ViewTreeItem>();
	ViewTreeItem model = new ViewTreeItem();
	
	String exclude_start = "false";
	
	public HttpHeaders show() throws Exception {
		modelList.add(model);
		if ("true".equalsIgnoreCase(exclude_start)) {
			modelList = super.startWithExcludeStart(modelList);
		} else {
			super.startWith(modelList);
		}
		return new DefaultHttpHeaders(show);
	}

	public HttpHeaders index() throws Exception {
		ViewTreeItem t = new ViewTreeItem();
		t.setId(1L);
		modelList.add(t);
		super.startWith(modelList);
		
		return new DefaultHttpHeaders(index).disableCaching();
	}

	public void setId(String id) {
		if (id != null && GenericValidator.isLong(id)) {
			this.model = super.getFacade().getViewTreeItemService().getViewTreeItem(new ViewTreeItem(id));
		}
		super.setId(id);
	}

	public Object getModel() {
		return (modelList != null ? modelList : model);
	}

	public void setExclude_start(String exclude_start) {
		this.exclude_start = exclude_start;
	}

}
