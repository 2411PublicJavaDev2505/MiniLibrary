package com.library.user.model.vo;

public class SearchVO {
	private String searchCondition;
	private String searchKeyword;
	
	public SearchVO(){}

	public SearchVO(String searchCondition, String searchKeyword) {
		super();
		this.searchCondition = searchCondition;
		this.searchKeyword = searchKeyword;
	}

	public String getSerachCondition() {
		return searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	@Override
	public String toString() {
		return "SearchVO [serachCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + "]";
	}
}
