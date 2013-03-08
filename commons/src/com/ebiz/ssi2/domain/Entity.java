package com.ebiz.ssi2.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ebiz.ssi2.domain.support.Row;
import com.ebiz.ssi2.web.struts2.BaseSsi2Controller;

/**
 * Base Model Entity.
 * 
 * Remain field: queryString, token, page, row, rows, order and sort.
 * 
 * @author XingXiuDong
 * @version 2012-08-01
 */
public class Entity implements Serializable {
	protected static final Logger logger = LoggerFactory.getLogger(BaseSsi2Controller.class);
	private static final long serialVersionUID = 1L;

	private Long id;

	private String queryString;

	private Row row;

	private Map<String, String> param = new HashMap<String, String>();

	String[] pks = new String[] {};

	private String token;

	private Integer page;

	private Integer rows;

	private String order; // desc or asc

	private String sort; // field name

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String[] getPks() {
		return pks;
	}

	public void setPks(String[] pks) {
		this.pks = pks;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public Row getRow() {
		if (null == row) {
			row = new Row();
		}
		return row;
	}

	public void setRow(Row row) {
		this.row = row;
	}

	public Map<String, String> getParam() {
		return param;
	}

	public void setParam(Map<String, String> param) {
		this.param = param;
	}

	public Integer getPage() {
		return (null == page ? 1 : page);
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return (null == rows ? 10 : rows);
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getOrder() {
		return (null == order ? "asc" : order);
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

}
