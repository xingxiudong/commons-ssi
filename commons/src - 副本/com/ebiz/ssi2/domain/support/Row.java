package com.ebiz.ssi2.domain.support;

import java.io.Serializable;

/**
 * @author Xing,XiuDong
 */
public class Row implements Serializable {

	private static final long serialVersionUID = -2345403372879875867L;

	private Integer first;

	private Integer count;

	public Row() {
	}

	public Row(Integer first, Integer count) {
		this.first = first;
		this.count = count;
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

}
