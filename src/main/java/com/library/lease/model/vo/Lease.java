package com.library.lease.model.vo;

import java.sql.Date;

public class Lease {

	private int leaseNo;
	private int bookNo;
	private String userId;
	private Date leaseDate;
	private Date returnDate;	
	private String bookName;
	private String userName;
	
	public Lease() {}

	
	


	public String getBookName() {
		return bookName;
	}





	public String getUserName() {
		return userName;
	}





	public Lease(int leaseNo, int bookNo, String userId) {
		super();
		this.leaseNo = leaseNo;
		this.bookNo = bookNo;
		this.userId = userId;
	}
	
	

	
	




	public Lease(int leaseNo, int bookNo, String userId, Date leaseDate, Date returnDate, String bookName,
			String userName) {
		super();
		this.leaseNo = leaseNo;
		this.bookNo = bookNo;
		this.userId = userId;
		this.leaseDate = leaseDate;
		this.returnDate = returnDate;
		this.bookName = bookName;
		this.userName = userName;
		
	}








	public Lease(int bookNo, String userId) {
		super();
		this.bookNo = bookNo;
		this.userId = userId;
	}








	public int getLeaseNo() {
		return leaseNo;
	}


	public int getBookNo() {
		return bookNo;
	}


	public String getUserId() {
		return userId;
	}


	public Date getLeaseDate() {
		return leaseDate;
	}


	public Date getReturnDate() {
		return returnDate;
	}





	@Override
	public String toString() {
		return "Lease [leaseNo=" + leaseNo + ", bookNo=" + bookNo + ", userId=" + userId + ", leaseDate=" + leaseDate
				+ ", returnDate=" + returnDate + ", bookName=" + bookName + ", userName=" + userName + "]";
	}



	
	
	

	
}
