package com.ebiz.ssi2.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ebiz.ssi2.domain.support.Row;
import com.ebiz.ssi2.web.struts2.BaseSsi2Controller;

public class Entity implements Serializable {
	protected static final Logger logger = LoggerFactory.getLogger(BaseSsi2Controller.class);
	private static final long serialVersionUID = 1L;

	private Long id;

	private String queryString;

	private Row row = new Row();

	private Map<String, String> param = new HashMap<String, String>();

	String[] pks = new String[] {};

	private String token;

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

}
