package com.ebiz.ssi2.domain.support.jqueryeasyui;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author XingXiuDong
 * @version 2012-08-03
 */
@SuppressWarnings("rawtypes")
public class Pager {
	protected static final Logger logger = LoggerFactory.getLogger(Pager.class);

	private Long total;

	private Integer pageNumber = 1;

	private Integer pageSize = 10;

	private Integer offset;

	private List<Map<String, Object>> rows;

	private List<Map<String, Object>> footer;

	private String order;
	
	private String sort;
	
	private Map query;
	
	public Pager(Long total, Integer pageNumber, Integer pageSize, String order, String sort) {
		if (null == total) {
			total = 0L;
		}
		if (null != pageNumber) {
			this.pageNumber = pageNumber;
		}
		if (null != pageSize) {
			this.pageSize = pageSize;
		}
		this.total = total;
		this.offset = (this.pageNumber - 1) * this.pageSize;
		this.order = order;
		this.sort = sort;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}

	@SuppressWarnings("unchecked")
	public void setRows(Collection<?> c) {
		if (c == null) {
			return;
		}
		
		List<Map<String, Object>> rowList = new ArrayList<Map<String, Object>>();
		for (Object obj : c) {
			Map<String, Object> m = new HashMap<String, Object>();
			try {
				m = BeanUtils.describe(obj);
			} catch (IllegalAccessException e) {
				logger.error("IllegalAccessException : {}, {}", e.getMessage());
			} catch (InvocationTargetException e) {
				logger.error("InvocationTargetException : {}", e.getMessage());
			} catch (NoSuchMethodException e) {
				logger.error("NoSuchMethodException : {}", e.getMessage());
			}
			rowList.add(m);
		}
		this.rows = rowList;
	}

	public List<Map<String, Object>> getFooter() {
		return footer;
	}

	public void setFooter(List<Map<String, Object>> footer) {
		this.footer = footer;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Map getQuery() {
		return query;
	}

	public void setQuery(Map query) {
		this.query = query;
	}
	
}
