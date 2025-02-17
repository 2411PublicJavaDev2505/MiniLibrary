package com.library.book.vo;


public class SearchVO {
	private String searchCondition;
	private String searchKeyword;
	
	public SearchVO() {}
	
	public SearchVO(String searchCondition, String searchKeyword) {
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
		return "SearchVO [searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + "]";
	}
	
}
