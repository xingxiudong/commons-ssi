package com.ebiz.comm.service;

import java.util.List;

import com.ebiz.comm.domain.ViewTreeItem;

/**
 * This class is pruduct by Coder-AutoGenerator.
 *
 * @author SSI2Generator
 * @date 2012-07-30 00:49:39
 */
public interface ViewTreeItemService {

	Long createViewTreeItem(ViewTreeItem entity);

	int modifyViewTreeItem(ViewTreeItem entity);

	int removeViewTreeItem(ViewTreeItem entity);

	ViewTreeItem getViewTreeItem(ViewTreeItem entity);

	List<ViewTreeItem> getViewTreeItemList(ViewTreeItem entity);

	Long getViewTreeItemCount(ViewTreeItem entity);

	List<ViewTreeItem> getViewTreeItemPaginatedList(ViewTreeItem entity);

}