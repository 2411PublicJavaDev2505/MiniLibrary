package com.library.lease.model.vo;

public class SearchVo {
	private String searchCondition;
	private String searchKeyword;
	
	
	public SearchVo() {}


	public SearchVo(String searchCondition, String searchKeyword) {
		super();
		this.searchCondition = searchCondition;
		this.searchKeyword = searchKeyword;
	}


	public String getSearchCondition() {
		return searchCondition;
	}


	public String getSearchKeyword() {
		return searchKeyword;
	}


	@Override
	public String toString() {
		return "SearchVo [searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + "]";
	}
	
	
	
	
}
