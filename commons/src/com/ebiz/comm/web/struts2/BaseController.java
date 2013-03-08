package com.ebiz.comm.web.struts2;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;

import com.ebiz.comm.domain.ViewTreeItem;
import com.ebiz.comm.service.Facade;
import com.ebiz.ssi2.web.struts2.BaseSsi2Controller;

@Controller
public class BaseController extends BaseSsi2Controller {

	private static final long serialVersionUID = -3178022323267809698L;

	@Resource
	private Facade facade;

	protected Facade getFacade() {
		return this.facade;
	}

	public List<ViewTreeItem> startWithExcludeStart(List<ViewTreeItem> startList) {
		startWith(startList);
		List<ViewTreeItem> list = new ArrayList<ViewTreeItem>();
		for (ViewTreeItem tree : startList) {
			list.addAll(tree.getChildren());
		}
		startList.clear();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<ViewTreeItem> startWith(List<ViewTreeItem> startList) {
		if (null == startList || startList.size() == 0) {
			return null;
		}

		List<ViewTreeItem> nextStartList = new ArrayList<ViewTreeItem>();
		for (ViewTreeItem s : startList) {
			// get children.
			List<ViewTreeItem> childrenList = getChildren(s);

			s.setChildren(childrenList); // change s
			s.setAttributes(this.describe(s));

			nextStartList.addAll(childrenList);
		}
		return this.startWith(nextStartList);
	}

	@SuppressWarnings("rawtypes")
	public Map describe(Object obj) {
		try {
			return BeanUtils.describe(obj);
		} catch (IllegalAccessException e) {
			logger.error("IllegalAccessException : {}, {}", e.getMessage());
		} catch (InvocationTargetException e) {
			logger.error("InvocationTargetException : {}", e.getMessage());
		} catch (NoSuchMethodException e) {
			logger.error("NoSuchMethodException : {}", e.getMessage());
		}
		return null;
	}

	public List<ViewTreeItem> getChildren(ViewTreeItem s) {
		ViewTreeItem sm = new ViewTreeItem();
		sm.setPar_id(s.getId());
		List<ViewTreeItem> childrenList = getFacade().getViewTreeItemService().getViewTreeItemList(sm);
		return childrenList;
	}
}
