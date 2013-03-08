package com.ebiz.ssi2.domain.support;

import java.io.Serializable;

import org.apache.commons.validator.GenericValidator;

/**
 * @author Liu,AiZhou
 */
public class Pager implements Serializable {

	private static final long serialVersionUID = -4853649627933466931L;

	private Integer pageSize = new Integer(10);

	private String requestPage;

	private Long recordCount = new Long(-1);

	private Integer firstRow = new Integer(0);

	private Integer rowCount = new Integer(10);

	private int currentPage = 1;

	private int pageCount = 1;

	private int firstPage = 1;

	private int priviousPage = 1;

	private int nextPage = 1;

	private int lastPage = 1;

	public Pager() {
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public int getFirstPage() {
		return this.firstPage;
	}

	public Integer getFirstRow() {
		return (this.firstRow < 0) ? 0 : this.firstRow;
	}

	public int getLastPage() {
		return this.lastPage;
	}

	public int getNextPage() {
		return this.nextPage;
	}

	public int getPageCount() {
		return this.pageCount;
	}

	public Integer getPageSize() {

		return this.pageSize;
	}

	public int getPriviousPage() {
		return this.priviousPage;
	}

	public Long getRecordCount() {
		return this.recordCount;
	}

	public String getRequestPage() {
		return GenericValidator.isLong(this.requestPage) ? this.requestPage : "1";
	}

	public Integer getRowCount() {
		return this.rowCount;
	}

	/**
	 * @param recordCount
	 * @param pageSize
	 * @param requestPage
	 */
	public void init(Long recordCount, Integer pageSize, String requestPage) {
		int iRecordCount = recordCount.intValue();
		int iPageSize = pageSize.intValue();
		int iRequestPage = Integer.parseInt(requestPage);

		if (iRecordCount == -1) {
			return;
		}

		this.recordCount = recordCount;
		this.pageSize = pageSize;

		this.pageCount = (int) Math.ceil((iRecordCount + iPageSize - 1) / iPageSize);
		if (iRequestPage > this.pageCount) {
			iRequestPage = this.pageCount;
		} else if (iRequestPage < 1) {
			iRequestPage = 1;
		}
		this.currentPage = iRequestPage;

		this.currentPage = iRequestPage;
		this.priviousPage = this.currentPage - 1;
		this.nextPage = this.currentPage + 1;
		this.lastPage = this.pageCount;
		this.firstRow = new Integer(iPageSize * (this.currentPage - 1));
		this.rowCount = this.pageSize;

	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setRequestPage(String requestPage) {
		this.requestPage = requestPage;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		sb.append("pageSize:").append(pageSize).append(",");
		sb.append("requestPage:").append(requestPage).append(",");
		sb.append("recordCount:").append(recordCount).append(",");
		sb.append("firstRow:").append(firstRow).append(",");
		sb.append("rowCount:").append(rowCount).append(",");
		sb.append("currentPage:").append(currentPage).append(",");
		sb.append("pageCount:").append(pageCount).append(",");
		sb.append("firstPage:").append(firstPage).append(",");
		sb.append("priviousPage:").append(priviousPage).append(",");
		sb.append("nextPage:").append(nextPage).append(",");
		sb.append("lastPage:").append(lastPage).append("]");
		return sb.toString();
	}

}
