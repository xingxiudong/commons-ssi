package com.ebiz.comm.web.struts2.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.ebiz.comm.domain.ViewTreeItem;
import com.ebiz.comm.web.struts2.BaseController;
import com.opensymphony.xwork2.ModelDriven;

public class HomeController extends BaseController implements ModelDriven<Object> {
	private static final long serialVersionUID = -3989121082608356150L;
	List<ViewTreeItem> modelList = new ArrayList<ViewTreeItem>();
	ViewTreeItem model = new ViewTreeItem();

	public HttpHeaders index() {
		model.setId(1L);
		modelList.add(model);
		super.startWith(modelList);
		return new DefaultHttpHeaders(index).disableCaching();
	}

	public Object getModel() {
		return (modelList != null ? modelList : model);
	}

	public void setId(String id) {
		super.setId(id);
	}

	public List<ViewTreeItem> getModelList() {
		return modelList;
	}

}
