package com.mockproject.freetutsproject.dto;

import java.util.List;

public class AbstractDTO<T> {
	private Long id;
	
	// for return a list of result in single model object
	private List<T> listResult;
	
	//for paging
	private int totalItems;
	private int totalPage;
	private int page;
	private int limit;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the listResult
	 */
	public List<T> getListResult() {
		return listResult;
	}
	/**
	 * @param listResult the listResult to set
	 */
	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
	/**
	 * @return the totalItems
	 */
	public int getTotalItems() {
		return totalItems;
	}
	/**
	 * @param totalItems the totalItems to set
	 */
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}
	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}
	/**
	 * @param limit the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
}
