package com.ebiz.ssi2.domain.support;

import java.io.Serializable;

/**
 * @author Xing,XiuDong
 * @version 2012-08-01
 */
public class Row implements Serializable {

	private static final long serialVersionUID = -2345403372879875867L;

	private Integer first;

	private Integer count;

	private String sort; // order by field.

	private String order; // desc or asc , asc as default.

	private Integer offset; // same as first, to fit old frame.

	public Row() {
	}

	public Integer getCount() {
		return this.count;
	}

	public Integer getFirst() {
		return this.first;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setFirst(Integer first) {
		this.first = first;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Integer getOffset() {
		return this.offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("{");
		sb.append("'first':'").append(this.getFirst()).append("',");
		sb.append("'count':'").append(this.getCount()).append("',");
		sb.append("'sort':'").append(this.getSort()).append("',");
		sb.append("'order':'").append(this.getOrder()).append("'");
		sb.append("}");
		return sb.toString();
	}

}
