package com.ebiz.comm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.comm.dao.ViewTreeItemDao;
import com.ebiz.comm.domain.ViewTreeItem;
import com.ebiz.comm.service.ViewTreeItemService;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-30 00:49:39
 */
@Service
public class ViewTreeItemServiceImpl implements ViewTreeItemService {

	@Resource
	private ViewTreeItemDao viewTreeItemDao;

	public Long createViewTreeItem(ViewTreeItem entity) {
		return this.viewTreeItemDao.insert(entity);
	}

	public int modifyViewTreeItem(ViewTreeItem entity) {
		return this.viewTreeItemDao.update(entity);
	}

	public int removeViewTreeItem(ViewTreeItem entity) {
		return this.viewTreeItemDao.delete(entity);
	}

	public ViewTreeItem getViewTreeItem(ViewTreeItem entity) {
		return this.viewTreeItemDao.select(entity);
	}

	public List<ViewTreeItem> getViewTreeItemList(ViewTreeItem entity) {
		return this.viewTreeItemDao.selectList(entity);
	}

	public Long getViewTreeItemCount(ViewTreeItem entity) {
		return this.viewTreeItemDao.count(entity);
	}

	public List<ViewTreeItem> getViewTreeItemPaginatedList(ViewTreeItem entity) {
		return this.viewTreeItemDao.selectPaginatedList(entity);
	}

}
